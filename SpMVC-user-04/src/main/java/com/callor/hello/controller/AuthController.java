package com.callor.hello.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	@RequestMapping(value="/denided", method=RequestMethod.GET)
	public String denied(Model model, 
			HttpServletRequest req,
			Authentication auth) {// Authentication은 Spring Security에서 사용자의 인증 정보를 나타내는 인터페이스
		
		AccessDeniedException exp =
					(AccessDeniedException) 
					req.getAttribute(WebAttributes.ACCESS_DENIED_403);
		
		model.addAttribute("AUTH",auth);
		model.addAttribute("MESSAGE",exp);
		return null;
	}

}
