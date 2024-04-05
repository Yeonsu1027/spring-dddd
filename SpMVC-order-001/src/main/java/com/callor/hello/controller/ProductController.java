package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.models.CustomVO;
import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String insert(ProductVO productVO) {
		
		log.debug(productVO.toString());
		
		int result = productDao.insert(productVO);
		
		return "redirect:/product";
	}
	
//	디테일~~
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	// 주소 http://localhost:8080/hello/customer/detail?c_code=C1004 
	// 주소에 있는 p_code 를 pCode 라는 이름으로 받겠다.
	public String detail(@RequestParam("p_code")String pCode, Model model,
			@RequestParam(name="msg",required = false, defaultValue="OK") String msg) { // required = false : mag 값이 없어된다. 없으면 OK
		
		ProductVO productVO = productDao.findById(pCode);
		model.addAttribute("PRODUCT",productVO);
		model.addAttribute("MSG",msg);
		
		return "product/detail";
	}
	
//	수정
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("pcode")String pCode, Model model) {
		
		ProductVO productVO = productDao.findById(pCode);
		model.addAttribute("PRODUCT",productVO);
		return "product/input";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(ProductVO productVO) {
		
		log.debug("Update {}",productVO.toString());
		
		int result = productDao.update(productVO);
//		디테일화면으로
		String retString = String.format("redirect:/product/detail?p_code=%s", productVO.getP_code()); // 백팁대신
		
		return retString;
		
//		 return "redirect:/custom/detail?c_code=" + customVO.getC_code(); 리턴문에서 직접하는법 
		
	}
	// 삭제
	@RequestMapping(value="/delete/{pcode}",method=RequestMethod.GET)
	public String delete(@PathVariable("pcode") String pCode) {
		int result =0;
		try {
			result = productDao.delete(pCode);
			
		} catch (Exception e) {
//			디테일 보여주고 왜 보여줬는지 안내메시지
			return "redirect:/product/detail?p_code=" + pCode + "&msg=FK";
		}
		if(result > 0 ) {			
			return "redirect:/product";
		} else {
			return "redirect:/product/detail?p_code=" + pCode + "&msg=NOT";
		}
	}
	
	
	
}
