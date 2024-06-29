package com.rupay.main.implementation.balance_Enquery;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class Balance_Enquery_XMLRequest {

	private String account;
	private String amount;
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

	// Setters and getters for each field

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

	// ... (Omitted for brevity)

	// Method to generate XML request in the specified format
	public String generateXmlRequest() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Create a new Document
			Document document = documentBuilder.newDocument();

			// Create the root element
			Element rootElement = document.createElement("FiRequest");
			document.appendChild(rootElement);

			// Create child elements for each field and append them to the root element in
			// order
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

	public static void main(String[] args) {
		Balance_Enquery_XMLRequest requestGenerator = new Balance_Enquery_XMLRequest();
		requestGenerator.setAccount("6078367000000122");
		requestGenerator.setAmount("000");
		requestGenerator.setChannel("");
		requestGenerator.setPinblock("284E94548A20258D");
		requestGenerator.setStan("210035");
		requestGenerator.setTid("00128204");
		requestGenerator.setTrack2("6078367000000122=28086207730000000000");
		requestGenerator.setType("balance");
		requestGenerator.setPinksn("FFFF987654321000007C");
		requestGenerator.setTrackksn("FFFF987654321000007D");
		requestGenerator.setPinpadtype("IRIX");
		requestGenerator.setEmv(
				"9F260821B28AE0B8006FF89F2701809F10080105A000014000009F3704C1F6FF5D9F3602007F950580000488009A032401059C01319F02060000000000005F2A020356820238009F1A0203569F33036040009F34030200009F350122");

		String xmlRequest = requestGenerator.generateXmlRequest();
		System.out.println(xmlRequest);
	}
}
