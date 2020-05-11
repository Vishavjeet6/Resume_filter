package com.tcs.pdfsearchengine.service;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import com.tcs.pdfsearchengine.domain.Pdf;
import com.tcs.pdfsearchengine.model.FileModel;

public interface TikaService {

	Pdf parsePdf(FileModel userFile) throws IOException, SAXException, TikaException;

}
