package com.rupay.main.implementation.cashWithdraw;

public class Cash_Widthraw_Test {

	public static void main(String[] args) {
		Cash_WidthrawalRequest requestGenerator = new Cash_WidthrawalRequest();
		requestGenerator.setAccount("6078367000000122");
		requestGenerator.setAmount("10000");
		requestGenerator.setChannel("");
		requestGenerator.setPinblock("80EB71B1F573B194");
		requestGenerator.setStan("885245");
		requestGenerator.setTid("08000273");
		requestGenerator.setTrack2("6078367000000122=28086207730000000000");
		requestGenerator.setType("withdraw");
		requestGenerator.setPinksn("FFFF9876543210000087");
		requestGenerator.setTrackksn("FFFF9876543210000088");
		requestGenerator.setPinpadtype("IRIX");
		requestGenerator.setEmv(
				"9F26081343E3D7ACBA310D9F2701809F10080105A000014000009F37042DDBA1099F36020088950580000488009A032401059C01019F02060000000100005F2A020356820238009F1A0203569F33036040009F34030200009F350122");

		String xmlRequest = requestGenerator.generateXmlRequest();
		System.out.println(xmlRequest);

		Cash_WidthrawalResponse responseGenerator = new Cash_WidthrawalResponse();
		responseGenerator.setAccount("607836XXXXXX0122");
		responseGenerator.setAccountnum("073172173485");
		responseGenerator.setAmount("100.00");
		responseGenerator.setBalance("0.00");
		responseGenerator.setDesc("Transaction Success");
		responseGenerator.setEmv("910AE2C3ADAF7757D09C0014");
		responseGenerator.setRrn("400517885245");
		responseGenerator.setStan("885245");
		responseGenerator.setStatus("00");
		responseGenerator.setStmt("");

		String xmlResponse = responseGenerator.generateXmlResponse();
		System.out.println(xmlResponse);
	}

}
