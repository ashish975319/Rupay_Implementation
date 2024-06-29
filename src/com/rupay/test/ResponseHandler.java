package com.rupay.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class ResponseHandler {

	public static void handleXmlResponse(String xmlResponse) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Use ByteArrayInputStream to parse the XML string
			ByteArrayInputStream input = new ByteArrayInputStream(xmlResponse.getBytes());
			Document doc = dBuilder.parse(input);

			doc.getDocumentElement().normalize();

			Element rootElement = doc.getDocumentElement();
			String responseType = rootElement.getElementsByTagName("type").item(0).getTextContent();

			if ("STMT".equals(responseType)) {
				handleStmtResponse(rootElement);
			} else {
				System.out.println("Unsupported response type: " + responseType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void handleStmtResponse(Element rootElement) {
		NodeList stmtList = rootElement.getElementsByTagName("stmt");
		for (int i = 1; i < stmtList.getLength() - 1; i++) {
			String stmt = stmtList.item(i).getTextContent();
			System.out.println(" " + stmt);
		}

		/*
		 * String tid =
		 * rootElement.getElementsByTagName("tid").item(0).getTextContent(); String
		 * account =
		 * rootElement.getElementsByTagName("account").item(0).getTextContent(); String
		 * rrn = rootElement.getElementsByTagName("rrn").item(0).getTextContent();
		 * String stan =
		 * rootElement.getElementsByTagName("stan").item(0).getTextContent(); String
		 * desc = rootElement.getElementsByTagName("desc").item(0).getTextContent();
		 * String status =
		 * rootElement.getElementsByTagName("status").item(0).getTextContent(); String
		 * amount = rootElement.getElementsByTagName("amount").item(0).getTextContent();
		 * String balance =
		 * rootElement.getElementsByTagName("balance").item(0).getTextContent();
		 */
	}

	public static void main(String[] args) {
		String xmlResponse = "<FiResponse><type>STMT</type>\n" + "<stmt>01/02 Cr 100.00 AEPS TRF </stmt>\n"
				+ "<stmt>01/02 Dr 100.00 AEPS TRF </stmt>\n" + "<stmt>01/02 Dr 2500.00 WDL TFR </stmt>\n"
				+ "<stmt>01/02 Cr 100.00 AEPS TRF </stmt>\n" + "<stmt>01/02 Cr 88.00 By Transfer </stmt>\n"
				+ "<stmt>01/02 Cr 1000.00 By Transfer </stmt>\n" + "<stmt>01/02 Cr 100.00 AEPS TRF </stmt>\n"
				+ "<stmt>01/02 Cr 88.00 By Transfer </stmt>\n" + "<stmt>01/02 Cr 1000.00 By Transfer </stmt>\n"
				+ "<stmt>AVAILABLE BALANCE Cr 1169155.00</stmt>\n" + "<tid>00128204</tid>\n"
				+ "<account>000018XXXXXX04240197371</account>\n" + "<rrn>400416000286</rrn>\n" + "<stan>697522</stan>\n"
				+ "<desc>Transaction Done Successfully(00)</desc>\n" + "<status>00</status>\n"
				+ "<amount>0.00</amount>\n" + "<balance>0.00</balance>\n" + "</FiResponse>";

		handleXmlResponse(xmlResponse);
	}
}
