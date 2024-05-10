package com.callor.hello.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.models.ImageVO;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	private final String folder; 
	
	private final ServletContext context;
	public FileUploadServiceImpl(ServletContext context) {
		super();
		this.context = context;
		folder = "/app/upload";
	}

	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		String originalFileName = file.getOriginalFilename();
		if(originalFileName.isEmpty()) {
			return null;
		}
		
		File path = new File(folder);
		// 업로드할 폴더를 검사해 보고 없으면 생성하라
				if(!path.exists()) { // 존재하지않으면
					path.mkdirs(); //mkdir, mkdirs 있음 
					// mkdirs 는 폴더의 개수와 상관없이 만든다 upload를 만드는 것만 아니라
					// static 폴더가 없을 수도 있기 때문.
				}
				String uuid = UUID.randomUUID().toString();
				String upLoadFileName = String.format("%s-%s", uuid,originalFileName);
				
				File upLoadFile = new File(folder,upLoadFileName);
				
				file.transferTo(upLoadFile); // file
				
				// 실제 저장된 파일의 이름을 return
				return upLoadFileName;
		
	}

	
	@Override
	public List<ImageVO> filesUpload(MultipartHttpServletRequest files) throws Exception {
		List<MultipartFile> result = files.getFiles("image_files");
		List<ImageVO> resultImages = new ArrayList<>();
		for(MultipartFile f : result) {
			String resName = this.fileUpload(f);
			resultImages.add(
					ImageVO.builder()
					.i_id(UUID.randomUUID().toString()) 
					.i_origin_image(f.getOriginalFilename())
					.i_up_image(resName).build()
				);	
		}
		return  resultImages;
	
	}

}
