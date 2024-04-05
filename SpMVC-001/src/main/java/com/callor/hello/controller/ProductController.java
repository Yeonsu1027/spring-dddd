package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.CustomVO;
import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.ProductDao;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private final ProductDao productDao;
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		
		List<ProductVO> productlist = productDao.selectAll();
		model.addAttribute("PRODUCT_LIST",productlist);
		
		return "product/list";	
	}
//	상품추가
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "product/input";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(ProductVO vo, Model model) {
		try {
			int result = productDao.insert(vo);
			if(result > 0 ) {
				return "redirect:/product";
			}else {
				model.addAttribute("MSG","INSERT ERROR");
				return "product/input";
			}	
		} catch (Exception e) {
			model.addAttribute("MSG","INSERT SQL ERROR");
			return "product/input";
		}
	}
	
	
	
}
