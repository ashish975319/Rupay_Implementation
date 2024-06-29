package com.rupay.test;

public class RupayTransaction {
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
	/*
	 * public String generateXmlRequest() { try { DocumentBuilderFactory
	 * documentBuilderFactory = DocumentBuilderFactory.newInstance();
	 * DocumentBuilder documentBuilder =
	 * documentBuilderFactory.newDocumentBuilder();
	 * 
	 * // Create a new Document Document document = documentBuilder.newDocument();
	 * 
	 * // Create the root element based on the transaction type Element rootElement
	 * = document.createElement("Rupay_" + type); document.appendChild(rootElement);
	 * 
	 * // Create child elements for common fields createElement(document,
	 * rootElement, "account", account); createElement(document, rootElement,
	 * "amount", amount); createElement(document, rootElement, "acctype", acctype);
	 * createElement(document, rootElement, "channel", channel);
	 * createElement(document, rootElement, "pinblock", pinblock);
	 * createElement(document, rootElement, "stan", stan); createElement(document,
	 * rootElement, "tid", tid); createElement(document, rootElement, "track2",
	 * track2); createElement(document, rootElement, "type", type);
	 * createElement(document, rootElement, "pinksn", pinksn);
	 * createElement(document, rootElement, "trackksn", trackksn);
	 * createElement(document, rootElement, "pinpadtype", pinpadtype);
	 * createElement(document, rootElement, "emv", emv); createElement(document,
	 * rootElement, "beneaccount", beneaccount); createElement(document,
	 * rootElement, "newpinblock", newpinblock);
	 * 
	 * // Additional fields specific to each transaction type will be handled in //
	 * subclasses
	 * 
	 * // Transform the document to a string TransformerFactory transformerFactory =
	 * TransformerFactory.newInstance(); Transformer transformer =
	 * transformerFactory.newTransformer();
	 * transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	 * 
	 * StringWriter stringWriter = new StringWriter(); transformer.transform(new
	 * DOMSource(document), new StreamResult(stringWriter));
	 * 
	 * return stringWriter.toString(); } catch (ParserConfigurationException |
	 * javax.xml.transform.TransformerException e) { e.printStackTrace(); return
	 * null; } }
	 * 
	 * // Method to generate XML response public String generateXmlResponse(String
	 * responseStatus, String additionalInfo) { try { DocumentBuilderFactory
	 * documentBuilderFactory = DocumentBuilderFactory.newInstance();
	 * DocumentBuilder documentBuilder =
	 * documentBuilderFactory.newDocumentBuilder();
	 * 
	 * // Create a new Document Document document = documentBuilder.newDocument();
	 * 
	 * // Create the root element based on the transaction type Element rootElement
	 * = document.createElement("Rupay_" + type + "Response");
	 * document.appendChild(rootElement);
	 * 
	 * // Create child elements for common fields createElement(document,
	 * rootElement, "account", account); createElement(document, rootElement,
	 * "amount", amount); createElement(document, rootElement, "acctype", acctype);
	 * createElement(document, rootElement, "channel", channel);
	 * createElement(document, rootElement, "stan", stan); createElement(document,
	 * rootElement, "status", responseStatus); createElement(document, rootElement,
	 * "additionalInfo", additionalInfo);
	 * 
	 * // Additional fields specific to each transaction type will be handled in //
	 * subclasses
	 * 
	 * // Transform the document to a string TransformerFactory transformerFactory =
	 * TransformerFactory.newInstance(); Transformer transformer =
	 * transformerFactory.newTransformer();
	 * transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	 * 
	 * StringWriter stringWriter = new StringWriter(); transformer.transform(new
	 * DOMSource(document), new StreamResult(stringWriter));
	 * 
	 * return stringWriter.toString(); } catch (ParserConfigurationException |
	 * javax.xml.transform.TransformerException e) { e.printStackTrace(); return
	 * null; } }
	 * 
	 * protected void createElement(Document document, Element parent, String
	 * tagName, String textContent) { Element element =
	 * document.createElement(tagName);
	 * element.appendChild(document.createTextNode(textContent));
	 * parent.appendChild(element); }
	 */

}
