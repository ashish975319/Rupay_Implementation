package com.rupay.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class XmlGenerator {

	public String generateXmlRequest(RupayTransaction transactionData) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("FiRequest");
			doc.appendChild(rootElement);

			/*
			 * rootElement.appendChild(createElement(doc, "OLIVE-FIGATWAY"));
			 */

			if (transactionData.getType().equalsIgnoreCase("balanceEn")) {
				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "acctype", transactionData.getAcctype()));
				rootElement.appendChild(createElement(doc, "channel", transactionData.getChannel()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "track2", transactionData.getTrack2()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));
				rootElement.appendChild(createElement(doc, "pinksn", transactionData.getPinksn()));
				rootElement.appendChild(createElement(doc, "trackksn", transactionData.getTrackksn()));
				rootElement.appendChild(createElement(doc, "pinpadtype", transactionData.getPinpadtype()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
			} else if (transactionData.getType().equalsIgnoreCase("cashWidthrawal")) {
				System.out.println("cash");
				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "acctype", transactionData.getAcctype()));
				rootElement.appendChild(createElement(doc, "channel", transactionData.getChannel()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "track2", transactionData.getTrack2()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));
				rootElement.appendChild(createElement(doc, "pinksn", transactionData.getPinksn()));
				rootElement.appendChild(createElement(doc, "trackksn", transactionData.getTrackksn()));
				rootElement.appendChild(createElement(doc, "pinpadtype", transactionData.getPinpadtype()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));

			} else if (transactionData.getType().equalsIgnoreCase("fundTrtansfer")) {

				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));
				rootElement.appendChild(createElement(doc, "trackksn", transactionData.getTrackksn()));
				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "beneaccount", transactionData.getBeneaccount()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "track2", transactionData.getTrack2()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "pinpadtype", transactionData.getPinpadtype()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));

			} else if (transactionData.getType().equalsIgnoreCase("deposite")) {
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));
				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "pinpadtype", transactionData.getPinpadtype()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "track2", transactionData.getTrack2()));

			} else if (transactionData.getType().equalsIgnoreCase("ministatement")) {
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));
				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "pinpadtype", transactionData.getPinpadtype()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "pinblock", transactionData.getPinblock()));
				rootElement.appendChild(createElement(doc, "track2", transactionData.getTrack2()));

			}

			return transformDocumentToString(doc);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateXmlResponse(RupayTransaction transactionData) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("FiResponse");
			doc.appendChild(rootElement);

			if (transactionData.getType().equalsIgnoreCase("balanceEn")) {
				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "accountnum", transactionData.getAccountnum()));
				rootElement.appendChild(createElement(doc, "balance", transactionData.getBalance()));
				rootElement.appendChild(createElement(doc, "desc", transactionData.getDesc()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "rrn", transactionData.getRrn()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "status", transactionData.getStatus()));
				rootElement.appendChild(createElement(doc, "stmt", transactionData.getStmt()));
			} else if (transactionData.getType().equalsIgnoreCase("cashWidthrawal")) {

				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "accountnum", transactionData.getAccountnum()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "balance", transactionData.getBalance()));
				rootElement.appendChild(createElement(doc, "desc", transactionData.getDesc()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "rrn", transactionData.getRrn()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "status", transactionData.getStatus()));
				rootElement.appendChild(createElement(doc, "stmt", transactionData.getStmt()));

			} else if (transactionData.getType().equalsIgnoreCase("fundTrtansfer")) {

				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "beneaccount", transactionData.getBeneaccount()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "desc", transactionData.getDesc()));
				rootElement.appendChild(createElement(doc, "rrn", transactionData.getRrn()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "status", transactionData.getStatus()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "stmt", transactionData.getStmt()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));

			} else if (transactionData.getType().equalsIgnoreCase("deposite")) {

				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "balance", transactionData.getBalance()));
				rootElement.appendChild(createElement(doc, "desc", transactionData.getDesc()));
				rootElement.appendChild(createElement(doc, "rrn", transactionData.getRrn()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "status", transactionData.getStatus()));
				rootElement.appendChild(createElement(doc, "stmt", transactionData.getStmt()));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));

			} else if (transactionData.getType().equalsIgnoreCase("ministatement")) {

				rootElement.appendChild(createElement(doc, "account", transactionData.getAccount()));
				rootElement.appendChild(createElement(doc, "amount", transactionData.getAmount()));
				rootElement.appendChild(createElement(doc, "balance", transactionData.getBalance()));
				rootElement.appendChild(createElement(doc, "desc", transactionData.getDesc()));
				rootElement.appendChild(createElement(doc, "rrn", transactionData.getRrn()));
				rootElement.appendChild(createElement(doc, "emv", transactionData.getEmv()));
				rootElement.appendChild(createElement(doc, "stan", transactionData.getStan()));
				rootElement.appendChild(createElement(doc, "status", transactionData.getStatus()));
				rootElement.appendChild(createElement(doc, "stmt", transactionData.getStmt()));
				Element stmtElement = doc.createElement("stmt");
				rootElement.appendChild(stmtElement);
				stmtElement.appendChild(createElement(doc, "txn", "25/10 Cr 3982.92 BULK POSTING"));
				stmtElement.appendChild(createElement(doc, "txn", "16/10 Cr 3477.52 BULK POSTING"));
				stmtElement.appendChild(createElement(doc, "txn", "09/10 Cr 15.00 BULK POSTING"));
				stmtElement.appendChild(createElement(doc, "txn", "07/10 Dr 600.00 ATM TRF"));
				stmtElement.appendChild(createElement(doc, "txn", "07/10 Dr 1300.00 ATM TRF"));
				stmtElement.appendChild(createElement(doc, "txn", "06/10 Cr 1909.97 BULK POSTING"));
				stmtElement.appendChild(createElement(doc, "txn", "05/10 Dr 15.00 SMS CHARGE HA"));
				stmtElement.appendChild(createElement(doc, "txn", "30/09 Cr 6.00 CREDIT INTERE"));
				stmtElement.appendChild(createElement(doc, "txn", "26/09 Dr 300.00 ATM TRF"));
				stmtElement.appendChild(createElement(doc, "txn", "AVAILABLE BALANCE Cr 7500.91"));
				rootElement.appendChild(createElement(doc, "tid", transactionData.getTid()));
				rootElement.appendChild(createElement(doc, "type", transactionData.getType()));

			}

			return transformDocumentToString(doc);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Element createElement(Document doc, String tagName, String textContent) {
		Element element = doc.createElement(tagName);
		element.appendChild(doc.createTextNode(textContent));
		return element;
	}

	private static String transformDocumentToString(Document doc) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));

		return writer.toString();
	}
}
