package com.tcs.pdfsearchengine.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.tcs.pdfsearchengine.domain.Pdf;
import com.tcs.pdfsearchengine.model.FileModel;
import com.tcs.pdfsearchengine.repository.FileRepository;
import com.tcs.pdfsearchengine.service.TikaService;

@Service
public class TikaServiceImpl implements TikaService{
	
	@Autowired
	FileRepository fileRepository;

	@Override
	public Pdf parsePdf(FileModel file) throws IOException, SAXException, TikaException {
		// TODO Auto-generated method stub
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		ParseContext pcontext = new ParseContext();     
		PDFParser pdfparser = new PDFParser();
		InputStream inputstream = new ByteArrayInputStream(file.getFileByte());
		pdfparser.parse(inputstream, handler, metadata,pcontext);
		System.out.println("************************");
		System.out.println("************************");
		System.out.println("************************");
		System.out.println("Contents of the PDF :" + handler.toString());
		System.out.println("************************");
		System.out.println("************************");
		System.out.println("************************");
		Pdf parsedPdf = new Pdf(file.getId(), file.getName(), handler.toString());
		return parsedPdf;
	}

}
