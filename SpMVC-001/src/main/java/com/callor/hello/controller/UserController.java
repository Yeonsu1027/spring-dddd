package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/get", method=RequestMethod.GET)
	public String getUser() {
		return null;
	}
	
	/*
	 * GET /user/join
	 * POST /user/join
	 * method 를 생성하여 회원가입 화면을 띄우고
	 * username, password, name, email, tel 을 입력받고
	 * 회원가입을 실행하여 서버로 데이터가 전달되는지 확인하기
	 * */
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	// 폼에서 입력된 데이터를 UserDto 객체로 받아 모델에 추가
	// Model : View와 Controller 간의 데이터 전달을 담당하는 객체
	public String join(UserDto userDto, Model model) {
		log.debug("FORM 에서 받은데이터{}",userDto.toString());
		model.addAttribute("USER",userDto);
		//  컨트롤러에서 모델에 추가된 "USER" 객체의 데이터를 뷰에서 출력
		return null;
	}
	
}
