package com.rupay.main.implementation.cashWithdraw;

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

public class Cash_WidthrawalResponse {

	private String account;
	private String accountnum;
	private String amount;
	private String balance;
	private String desc;
	private String emv;
	private String rrn;
	private String stan;
	private String status;
	private String stmt;
	
	

	// Setters and getters for each field

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
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

	public String getStmt() {
		return stmt;
	}

	public void setStmt(String stmt) {
		this.stmt = stmt;
	}

	// ... (Omitted for brevity)

	// Method to generate XML response in the specified format
	public String generateXmlResponse() {
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

	private void createElement(Document document, Element parent, String tagName, String textContent) {
		Element element = document.createElement(tagName);
		element.appendChild(document.createTextNode(textContent));
		parent.appendChild(element);
	}

	public static void main(String[] args) {
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
