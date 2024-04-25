package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService{

	private final FileUploadService fileUploadService;
	public final GalleryDao galleryDao;

	public GalleryServiceImpl(FileUploadService fileUploadService, GalleryDao galleryDao) {
		super();
		this.fileUploadService = fileUploadService;
		this.galleryDao = galleryDao;
	}

	@Autowired
	public void create_table() {
		galleryDao.create_table(null);
	}

	@Override
	public List<GalleryVO> selectAll() {
		// TODO Auto-generated method stub
		return galleryDao.selectAll();
	}

	@Override
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception { //여기서 try catch안하고 익셉션발생시 컨트롤러로 보내겠다
		
		galleryVO.setG_id(UUID.randomUUID().toString());
		
		galleryVO.setG_origin_image(image_file.getOriginalFilename());
		
		// 파일을 업로드하고 return 받은 변형된 이름을 VO에 setting
		String fileName = fileUploadService.fileUpload(image_file);
		galleryVO.setG_up_image(fileName);
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-mm-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		galleryVO.setG_date(lt.format(date));
		galleryVO.setG_time(lt.format(time));
		galleryVO.setG_author("rito1205@naver.com");
		
		
		int ret = galleryDao.insert(galleryVO);
		// 정상적으로 입력되면
		if(ret > 0) {
			return galleryVO;
		}
		
		return null;
	}
	
}
