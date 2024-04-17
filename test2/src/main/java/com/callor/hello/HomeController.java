package com.callor.hello;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.TestDao;
import com.callor.hello.model.TestVO;





@Controller
public class HomeController {
	
	private final TestDao testDao;
	public HomeController(TestDao testDao) {
		this.testDao = testDao;
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<TestVO> test = testDao.selectAll();
		model.addAttribute("testlist", test);
		
		return "home";
	}
	
}
