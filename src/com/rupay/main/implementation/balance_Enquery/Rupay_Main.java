package com.rupay.main.implementation.balance_Enquery;

public interface Rupay_Main {
	
	String generateXMLRequest();

    String processXMLResponse(String xmlResponse, String tagName);

	
	

	/*
	 * public String generateXMLRequest();
	 * 
	 * public String readXMLRequest();
	 * 
	 * public String getResponse();
	 */

}
