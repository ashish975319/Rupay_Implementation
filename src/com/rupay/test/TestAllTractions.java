package com.rupay.test;

public class TestAllTractions {

	public static void main(String[] args) {
		RupayTransaction rupayTransaction = new RupayTransaction();
		rupayTransaction.setAccount("546475675");
		rupayTransaction.setAmount("500");
		rupayTransaction.setAcctype("current");
		rupayTransaction.setPinblock("54fef4353");
		rupayTransaction.setStan("56475gdrfer4e");
		rupayTransaction.setTid("DGF43534FS");
		rupayTransaction.setTrack2("3454erfe");

		rupayTransaction.setType("balanceEn");
		rupayTransaction.setPinksn("34543drfd");
		rupayTransaction.setPinpadtype("434wrw22ed");
		rupayTransaction.setEmv("sadfsg54645t");
		rupayTransaction.setBeneaccount("re454");
		rupayTransaction.setNewpinblock("ewrew5t34");
		rupayTransaction.setAccountnum("wr3432");
		rupayTransaction.setBalance("43r534t");
		rupayTransaction.setDesc("wer3543");
		rupayTransaction.setRrn("dewr5");
		rupayTransaction.setStatus("wer34rfw");
		rupayTransaction.setStmt("we4wer");
		rupayTransaction.setTrackksn("876hg");

		XmlGenerator xmlGenerator = new XmlGenerator();
		String request = xmlGenerator.generateXmlRequest(rupayTransaction);
		System.out.println("Generate XML Request" + request);
		System.out.println("=========================================");

		String response = xmlGenerator.generateXmlResponse(rupayTransaction);
		System.out.println("Generate XML Response" + response);

	}

}
