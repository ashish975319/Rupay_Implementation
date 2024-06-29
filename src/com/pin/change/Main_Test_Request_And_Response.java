package com.pin.change;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Main_Test_Request_And_Response {

	public static String global_result = "526";

	private static String formatXml(String xmlString) {
		try {
			// Parse the XML string
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(xmlString)));

			// Format the XML document
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");

			// Convert the Document to a String
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			return writer.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String args[]) {

		// String global_result = "526";

		// Create FiRequest with sample values
		Pin_Change_XMLRequest fiRequest = new Pin_Change_XMLRequest();
		fiRequest.setStan("007198");
		fiRequest.setTid("30000305");
		fiRequest.setType("pinchange");
		fiRequest.setAcctype("10");
		fiRequest.setAccount("6079737000392332");
		fiRequest.setPinblock("9B154009AF40CEA9");
		fiRequest.setNewpinblock("7A268E065DB42BEA");
		fiRequest.setTrack2("6079737000392332D26016209290000000000");
		fiRequest.setEmv("EMV DATA");
		// Generate XML request
		String xmlRequest = fiRequest.toXml();
		global_result = formatXml(xmlRequest);
		System.out.println("Generated XML Request::\n" + global_result);
		// System.out.println(global_result);

//		Pin_Change_XMLResponse responseGenerator = new Pin_Change_XMLResponse();
//		responseGenerator.setAccount("123456789");
//		responseGenerator.setAmount("100.00");
//		responseGenerator.setBalance("500.00");
//		responseGenerator.setDesc("Transaction successful");
//		responseGenerator.setEmv("1234");
//		responseGenerator.setRrn("5678");
//		responseGenerator.setStan("987654");
//		responseGenerator.setStatus("Approved");
//		responseGenerator.setTid("TID123");
//		responseGenerator.setType("Purchase");
//
//		// Generate XML response
//		String xmlResponse = responseGenerator.generateXmlResponse();
//		String globalResponse = xmlResponse;
//
//		System.out.println("Generate XMLResponse: " + globalResponse);
//		// Print the generated XML response
//		System.out.println("Generate XML Response: \n" + xmlResponse);
//
//		Pin_Change_XMLResponse a = printValuesByTagName(globalResponse);
//
//		System.out.println(a.getAccount());
//
//	}
//
//	private static Pin_Change_XMLResponse printValuesByTagName(String result) {
//
//		Pin_Change_XMLResponse p = new Pin_Change_XMLResponse();
//		try {
//			// Create a new DocumentBuilder
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//
//			// Parse the XML string to create a Document
//			Document doc = dBuilder.parse(new InputSource(new StringReader(result)));
//			doc.getDocumentElement().normalize();
//
//			// Get NodeList of elements with the specified tag name
//			NodeList nodeList = doc.getElementsByTagName("XmlResponse");
//
//			// Check if the tag is not present
////			if (nodeList.getLength() == 0) {
////				throw new Exception("Tag not found: " + tagName);
////			}
//
//			// Print values based on the tag name
////			System.out.println("Values for " + tagName + ":");
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Element element = (Element) nodeList.item(i);
//
//				p.setAccount(getElementValue(element, "Account"));
//
//				System.out.println(element.getTextContent());
//			}
//			System.out.println();
//		} catch (
//
//		Exception e) {
////		System.out.println("Exception occurred for tag " + tagName + ": " + e.getMessage());
//		}
//		return p;
//	}
//
//	private static String getElementValue(Element element, String tagName) {
//
//		NodeList nodeList = element.getElementsByTagName(tagName);
//
//		if (nodeList != null && nodeList.getLength() > 0) {
//			return nodeList.item(0).getTextContent();
//		} else {
//			return null;
//		}
//
////		return null;
	}

}
