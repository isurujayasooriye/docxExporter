/*
 * File Name: PDFFileGeneratorRequest.java 
 * Date : Jun 17, 2019
 * Copyright (c) 2019 Affno (Pvt) Ltd.
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Affno ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Affno.
 *
 */
package com.isuru.exporter.docxexporter;

/**
 * 
 *
 * @author Isuru Jayasooriya
 *
 */
public class DocxFileGeneratorRequest {
	
	private String htmlFilePath;
	private String destination;
	
	public String getHtmlFilePath() {
		return htmlFilePath;
	}
	public void setHtmlFilePath(String htmlFilePath) {
		this.htmlFilePath = htmlFilePath;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
