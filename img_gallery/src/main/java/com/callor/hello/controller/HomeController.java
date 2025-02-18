package com.callor.hello.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.models.GalleryVO;
import com.callor.hello.service.impl.GalleryService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final GalleryService galleryService;

	public HomeController(GalleryService galleryService) {
		super();
		this.galleryService = galleryService;
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
	
		
		return "home";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		
		GalleryVO galleryVO = GalleryVO.builder()
				.g_up_image("noimage.png")
				.g_origin_image("noimage.png")
				.build();
		model.addAttribute("GALLERY", galleryVO);
		
		return "upload";
	}
	
	/*
	 * MultipartFile : form 의 input[type='file'] tag 에 담겨서 전달되는
	 * 파일을 수신하는 객체
	 * 
	 * MultipartHttpServletRequest : form 의 input[type='file'] tag 에
	 * 담겨서 전달되는 여러개의 파일을 수신하는 객체
	 * 여기에는 절대 @RequestParam()을 붙여서는 안된다.
	 * 
	 * */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(GalleryVO galleryVO, 
			@RequestParam("image_file")
		MultipartFile image_file,
		
		MultipartHttpServletRequest image_files, // @RequestParam 붙임 안됨.
		Model model) { 
		
//		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-mm-dd");
//		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
//		
//		 model.addAttribute("date", date );
//		 model.addAttribute("time", time );
		
		//log.debug("파일 업로드 {}", image_file.getOriginalFilename()); // image_file 객체에 들어있는 함수  getOriginalFilename()
		
		String singleFileName = image_file.getOriginalFilename();
		GalleryVO resultVO = null;
	try {
		if(!singleFileName.isEmpty()) {			
			resultVO = galleryService.createGallery(galleryVO,image_file);
		}
		/*
		 * Multi file 의 경우는 매개변수의 이름과 form 에서 전달한 이름은
		 * 전혀 연관이 없다
		 * Multi 파일의 경우는 변수.getFiles() method 를 실행할때
		 * form 에서 설정한 name 속성값을 매개변수로 전달한다
		 * */
		
		// 붙인 이름은 파일을 추출할때사용함
		if(image_files.getFiles("image_files").size() > 0) { // 멀티이미지가 선택되었으면
			List<GalleryVO> VOs 
				= galleryService
					.createGallery(galleryVO, image_files);
		}
		model.addAttribute("GALLERY",resultVO);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		model.addAttribute("IMAGE",image_file.getOriginalFilename());
		
		return "upload";
	}
	
}
