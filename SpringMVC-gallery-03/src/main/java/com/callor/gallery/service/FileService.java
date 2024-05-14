package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {

	// Singel File Upload
	public String fileUp(MultipartFile file);
	
	// Multi file Upload
	public List<String> filesUp(MultipartHttpServletRequest files); 
}
