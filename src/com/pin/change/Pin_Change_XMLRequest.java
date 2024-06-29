package com.pin.change;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.StringReader;
import java.io.StringWriter;

public class Pin_Change_XMLRequest {
	private String stan;
	private String tid;
	private String type;
	private String acctype;
	private String account;
	private String pinblock;
	private String newpinblock;
	private String track2;
	private String emv;

	// Setters
	public void setStan(String stan) {
		this.stan = stan;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPinblock(String pinblock) {
		this.pinblock = pinblock;
	}

	public void setNewpinblock(String newpinblock) {
		this.newpinblock = newpinblock;
	}

	public void setTrack2(String track2) {
		this.track2 = track2;
	}

	public void setEmv(String emv) {
		this.emv = emv;
	}

	// Getters
	public String getStan() {
		return stan;
	}

	public String getTid() {
		return tid;
	}

	public String getType() {
		return type;
	}

	public String getAcctype() {
		return acctype;
	}

	public String getAccount() {
		return account;
	}

	public String getPinblock() {
		return pinblock;
	}

	public String getNewpinblock() {
		return newpinblock;
	}

	public String getTrack2() {
		return track2;
	}

	public String getEmv() {
		return emv;
	}

	public static Pin_Change_XMLRequest fromXml(String xml) {
		Pin_Change_XMLRequest request = new Pin_Change_XMLRequest();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(xml)));

			request.setStan(getTagValue(document, "stan"));
			request.setTid(getTagValue(document, "tid"));
			request.setType(getTagValue(document, "type"));
			request.setAcctype(getTagValue(document, "acctype"));
			request.setAccount(getTagValue(document, "account"));
			request.setPinblock(getTagValue(document, "pinblock"));
			request.setNewpinblock(getTagValue(document, "newpinblock"));
			request.setTrack2(getTagValue(document, "track2"));
			request.setEmv(getTagValue(document, "emv"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error processing XML for FiRequest.");
		}
		return request;
	}

	private static String getTagValue(Document document, String tagName) {
		Element element = (Element) document.getElementsByTagName(tagName).item(0);
		return element.getTextContent();
	}

	public String toXml() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Element root = document.createElement("FiRequest");
			Node appendChild = document.appendChild(root);

			root.appendChild(createElement(document, "tid", getTid()));
			root.appendChild(createElement(document, "type", getType()));
			root.appendChild(createElement(document, "acctype", getAcctype()));
			root.appendChild(createElement(document, "account", getAccount()));
			root.appendChild(createElement(document, "pinblock", getPinblock()));
			root.appendChild(createElement(document, "newpinblock", getNewpinblock()));
			root.appendChild(createElement(document, "track2", getTrack2()));
			root.appendChild(createElement(document, "emv", getEmv()));

			// Convert the document to XML string
			StringWriter writer = new StringWriter();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			// System.out.println(writer.toString());

			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error generating XML for FiRequest.");
		}
		return null;
	}

	private Element createElement(Document document, String tagName, String textContent) {
		Element element = document.createElement(tagName);
		element.appendChild(document.createTextNode(textContent));
		return element;
	}

}
