/*
 * File Name: PDFGenerateController.java 
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 *
 * @author Isuru Jayasooriya
 *
 */

@RestController
@RequestMapping("/docx-generate")
public class ExporterController {
	
	@Autowired
	private ExpoterService docxExpoterService;
	
	@PostMapping("/generate-from-html")
	public Boolean generateFromHTML(@RequestBody DocxFileGeneratorRequest request) {
		try {
			docxExpoterService.exportToDocx(request.getHtmlFilePath(), request.getDestination());
		return Boolean.TRUE;
		}catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		
	}
	
//	
//	@PostMapping("/generate-from-html-landscape")
//	public Boolean generateLandscapePDFFromHTML(@RequestBody DocxFileGeneratorRequest request) {
//		try {
//		pdfGenerateService.generateLandscapePDFFromHTML(request.getHtmlFilePath(), request.getDestination());
//		return Boolean.TRUE;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return Boolean.FALSE;
//		}
//		
//	}

}
