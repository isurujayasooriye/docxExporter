package com.isuru.exporter.docxexporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.contenttype.ContentType;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.CTAltChunk;
import org.springframework.stereotype.Service;

@Service
public class ExpoterService {
	
	public void exportToDocx(String htmlFilePath, String destination) throws Docx4JException, FileNotFoundException {
		
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
		
		AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(new PartName("/test.html"));
		afiPart.setBinaryData(new FileInputStream(new File(htmlFilePath)));
		afiPart.setContentType(new ContentType("text/html"));
		
		Relationship altChunkRel = wordMLPackage.getMainDocumentPart().addTargetPart(afiPart);
		CTAltChunk ac = Context.getWmlObjectFactory().createCTAltChunk();
		ac.setId(altChunkRel.getId() );
		wordMLPackage.getMainDocumentPart().addObject(ac);
		wordMLPackage.getContentTypeManager().addDefaultContentType("html", "text/html");
		wordMLPackage.save(new java.io.File(destination));
	}
	


}
