package com.callor.hello.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.CustomVO;
import com.callor.hello.persistance.CustomDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j        // 이걸쓰면 log.debug() 명령사용가능
@Controller
public class HomeController {
	
	private final CustomDao customDao;
	public HomeController(CustomDao customDao) {
		this.customDao = customDao;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<CustomVO> cList = customDao.selectAll();
		for(CustomVO vo : cList) {
			log.debug(vo.toString());			
		}
		log.debug("HOME");
		
		return "home";
	}
	
}
