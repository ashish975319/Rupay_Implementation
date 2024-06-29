
package com.pin.change;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class Pin_Change_XMLResponse {

	private String account;
	private String amount;
	private String balance;
	private String desc;
	private String emv;
	private String rrn;
	private String stan;
	private String status;
	private String tid;
	private String type;

	// Constructors, setters, and getters

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

	public String getEmv() {
		return emv;
	}

	public void setEmv(String emv) {
		this.emv = emv;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String generateXmlResponse() {
		try {
			// Create a new Document
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// Create root element
			Element rootElement = doc.createElement("XmlResponse");
			doc.appendChild(rootElement);

			// Add elements for each field
			rootElement.appendChild(createElement(doc, "Account", account));
			rootElement.appendChild(createElement(doc, "Amount", amount));
			rootElement.appendChild(createElement(doc, "Balance", balance));
			rootElement.appendChild(createElement(doc, "Description", desc));
			rootElement.appendChild(createElement(doc, "EMV", emv));
			rootElement.appendChild(createElement(doc, "RRN", rrn));
			rootElement.appendChild(createElement(doc, "STAN", stan));
			rootElement.appendChild(createElement(doc, "Status", status));
			rootElement.appendChild(createElement(doc, "TID", tid));
			rootElement.appendChild(createElement(doc, "Type", type));

			// Format the XML output
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("indent", "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			// Transform the Document to XML String
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));

			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Element createElement(Document doc, String name, String value) {
		Element element = doc.createElement(name);
		element.appendChild(doc.createTextNode(value));
		return element;
	}
	
	

}
