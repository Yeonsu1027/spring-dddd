package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.impl.FileUploadService;

public interface GalleryService {

	public List<GalleryVO> selectAll();
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception;
	public List<GalleryVO> createGallery(GalleryVO galleryVO, MultipartHttpServletRequest image_files) throws Exception;
	
	
}
