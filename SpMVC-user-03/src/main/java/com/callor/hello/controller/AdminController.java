package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Getter;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String home() {
		return null;
	}

}
