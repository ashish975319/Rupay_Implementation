package com.rupay.main.implementation.cashWithdraw;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RupayMain {

	private String account;
	private String amount;
	private String acctype;
	private String channel;
	private String pinblock;
	private String stan;
	private String tid;
	private String track2;
	private String type;
	private String pinksn;
	private String trackksn;
	private String pinpadtype;
	private String emv;
	private String beneaccount;
	private String newpinblock;

	private String accountnum;
	private String balance;
	private String desc;
	private String rrn;
	private String status;
	private String stmt;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPinblock() {
		return pinblock;
	}

	public void setPinblock(String pinblock) {
		this.pinblock = pinblock;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTrack2() {
		return track2;
	}

	public void setTrack2(String track2) {
		this.track2 = track2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPinksn() {
		return pinksn;
	}

	public void setPinksn(String pinksn) {
		this.pinksn = pinksn;
	}

	public String getTrackksn() {
		return trackksn;
	}

	public void setTrackksn(String trackksn) {
		this.trackksn = trackksn;
	}

	public String getPinpadtype() {
		return pinpadtype;
	}

	public void setPinpadtype(String pinpadtype) {
		this.pinpadtype = pinpadtype;
	}

	public String getEmv() {
		return emv;
	}

	public void setEmv(String emv) {
		this.emv = emv;
	}

	public String getBeneaccount() {
		return beneaccount;
	}

	public void setBeneaccount(String beneaccount) {
		this.beneaccount = beneaccount;
	}

	public String getNewpinblock() {
		return newpinblock;
	}

	public void setNewpinblock(String newpinblock) {
		this.newpinblock = newpinblock;
	}

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStmt() {
		return stmt;
	}

	public void setStmt(String stmt) {
		this.stmt = stmt;
	}

	// Method to generate XML request using DocumentBuilderFactory
	public String generateXmlRequestForCashWidthrawal() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Create a new Document
			Document document = documentBuilder.newDocument();

			// Create the root element
			Element rootElement = document.createElement("FiRequest");
			document.appendChild(rootElement);

			// Create child elements for each field and append them to the root element
			createElement(document, rootElement, "account", account);
			createElement(document, rootElement, "amount", amount);
			createElement(document, rootElement, "channel", channel);
			createElement(document, rootElement, "pinblock", pinblock);
			createElement(document, rootElement, "stan", stan);
			createElement(document, rootElement, "tid", tid);
			createElement(document, rootElement, "track2", track2);
			createElement(document, rootElement, "type", type);
			createElement(document, rootElement, "pinksn", pinksn);
			createElement(document, rootElement, "trackksn", trackksn);
			createElement(document, rootElement, "pinpadtype", pinpadtype);
			createElement(document, rootElement, "emv", emv);

			// Transform the document to a string
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter stringWriter = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

			return stringWriter.toString();
		} catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void createElement(Document document, Element parent, String tagName, String textContent) {
		Element element = document.createElement(tagName);
		element.appendChild(document.createTextNode(textContent));
		parent.appendChild(element);
	}

	/*
	 * private void createElement(Document document, Element parent, String tagName,
	 * String textContent) { Element element = document.createElement(tagName);
	 * element.appendChild(document.createTextNode(textContent));
	 * parent.appendChild(element); }
	 */

	public String generateXmlResponseForCashWidthrawal() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Create a new Document
			Document document = documentBuilder.newDocument();

			// Create the root element
			Element rootElement = document.createElement("FiResponse");
			document.appendChild(rootElement);

			// Create child elements for each field and append them to the root element in
			// order
			createElement(document, rootElement, "account", account);
			createElement(document, rootElement, "accountnum", accountnum);
			createElement(document, rootElement, "amount", amount);
			createElement(document, rootElement, "balance", balance);
			createElement(document, rootElement, "desc", desc);
			createElement(document, rootElement, "emv", emv);
			createElement(document, rootElement, "rrn", rrn);
			createElement(document, rootElement, "stan", stan);
			createElement(document, rootElement, "status", status);
			createElement(document, rootElement, "stmt", stmt);

			// Transform the document to a string
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter stringWriter = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

			return stringWriter.toString();
		} catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateXMLRequestForDeposit() {
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Create a new Document
			Document document = documentBuilder.newDocument();

			// Create the root element
			Element rootElement = document.createElement("FiRequest");
			document.appendChild(rootElement);

			// Create child elements for each field and append them to the root element
			createElement(document, rootElement, "account", account);
			createElement(document, rootElement, "amount", amount);
			createElement(document, rootElement, "pinblock", pinblock);
			createElement(document, rootElement, "stan", stan);
			createElement(document, rootElement, "tid", tid);
			createElement(document, rootElement, "track2", track2);
			createElement(document, rootElement, "type", type);
			createElement(document, rootElement, "pinpadtype", pinpadtype);
			createElement(document, rootElement, "emv", emv);

			// Transform the document to a string
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter stringWriter = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

			return stringWriter.toString();

		} catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {

		RupayMain requestGenerator = new RupayMain();
		requestGenerator.setAccount("6078367000000122");
		requestGenerator.setAmount("10000");
		requestGenerator.setChannel("desf");
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
		requestGenerator.setStan("121689");

		String xmlRequest = requestGenerator.generateXmlRequestForCashWidthrawal();
		System.out.println("Generate XMLRequest For CashWidthrawal: \n" + xmlRequest);

		RupayMain responseGenerator = new RupayMain();
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

		String xmlResponse = responseGenerator.generateXmlResponseForCashWidthrawal();
		System.out.println("Generate XMLRequest For CashWidthrawal: \n" + xmlResponse);

		String generateXMLRequestForDeposit = requestGenerator.generateXMLRequestForDeposit();
		System.out.println("Generate XMLRequest For RupayDeposit: \n" + generateXMLRequestForDeposit);

	}

}
