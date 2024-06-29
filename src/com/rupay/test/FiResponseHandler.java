package com.rupay.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class FiResponseHandler {

	public static void main(String[] args) {
		// Your XML response as a string
		String xmlResponse = "<FiResponse><type>STMT</type>\n" + "<stmt>01/02 Cr 100.00 AEPS TRF </stmt>\n"
				+ "<stmt>01/02 Dr 100.00 AEPS TRF </stmt>\n" + "<stmt>01/02 Dr 2500.00 WDL TFR </stmt>\n"
				+ "<stmt>01/02 Cr 100.00 AEPS TRF </stmt>\n" + "<stmt>01/02 Cr 88.00 By Transfer </stmt>\n"
				+ "<stmt>01/02 Cr 1000.00 By Transfer </stmt>\n" + "<stmt>01/02 Cr 100.00 AEPS TRF </stmt>\n"
				+ "<stmt>01/02 Cr 88.00 By Transfer </stmt>\n" + "<stmt>01/02 Cr 1000.00 By Transfer </stmt>\n"
				+ "<stmt>AVAILABLE BALANCE Cr 1169155.00</stmt>\n" + "<tid>00128204</tid>\n"
				+ "<account>000018XXXXXX04240197371</account>\n" + "<rrn>400416000286</rrn>\n" + "<stan>697522</stan>\n"
				+ "<desc>Transaction Done Successfully(00)</desc>\n" + "<status>00</status>\n"
				+ "<amount>0.00</amount>\n" + "<balance>0.00</balance>\n" + "</FiResponse>";

		// Parse the XML string
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(xmlResponse)));

			// Get the root element
			Element rootElement = document.getDocumentElement();

			// Print all values with tag names
			printAllValues(rootElement);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printAllValues(Element rootElement) {
		NodeList nodeList = rootElement.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String tagName = element.getTagName();
				String textContent = element.getTextContent();
				System.out.println(tagName + ": " + textContent);
			}
		}
	}

}
