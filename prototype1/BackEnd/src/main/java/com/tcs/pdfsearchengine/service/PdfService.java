package com.tcs.pdfsearchengine.service;

import java.util.List;

import com.tcs.pdfsearchengine.domain.Pdf;


public interface PdfService {
	
	Long savePdf(Pdf pdf);
	List<Pdf> findByDescription(String description);

}
