package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



// 컨트롤러 어노테이션 : 라우터 같은거
@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET) // get method & post
	public String home(Locale locale, Model model) {
		return "home"; // home.jsp 파일을 렌더링해서 응답하라
	}
	
}
