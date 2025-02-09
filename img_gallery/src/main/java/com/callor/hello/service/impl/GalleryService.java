package com.callor.hello.service.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.models.GalleryVO;

public interface GalleryService {

	public List<GalleryVO> selectAll();
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception;
	public List<GalleryVO> createGallery(GalleryVO galleryVO, MultipartHttpServletRequest image_files) throws Exception;
}
