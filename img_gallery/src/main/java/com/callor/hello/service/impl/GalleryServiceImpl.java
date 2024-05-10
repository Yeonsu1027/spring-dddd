package com.callor.hello.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.dao.GalleryDao;
import com.callor.hello.dao.ImageDao;
import com.callor.hello.models.GalleryVO;

@Service
public class GalleryServiceImpl implements GalleryService {
	

	private final FileUploadService fileUploadService;
	private final GalleryDao galleryDao;
	private final ImageDao imageDao;
	public GalleryServiceImpl(FileUploadService fileUploadService, GalleryDao galleryDao, ImageDao imageDao) {
		super();
		this.fileUploadService = fileUploadService;
		this.galleryDao = galleryDao;
		this.imageDao = imageDao;
	}
	
	@Override
	public List<GalleryVO> selectAll() {
		// TODO Auto-generated method stub
		return galleryDao.selectAll();
	}
	
	/*
	 * Single 파일을 업로드 했을때 사용하는 method
	 * */
	@Override
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception {
		galleryVO.setG_origin_image(image_file.getOriginalFilename());
		
		// 파일을 업로드하고 return 받은 변형된 이름을 VO에 setting
		String fileName = fileUploadService.fileUpload(image_file);
		galleryVO.setG_up_image(fileName);
		

		
		// id, 날짜, 시간 setting 대신 실행하기
		//setGalleryOptions(galleryVO);
		int ret = galleryDao.insert(galleryVO);
		// 정상적으로 입력되면
		if(ret > 0) {
			return galleryVO;
		}
		
		return null;
	}
	@Override
	public List<GalleryVO> createGallery(GalleryVO galleryVO, MultipartHttpServletRequest image_files)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
