package com.callor.hello.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.models.ProductVO;

import com.callor.hello.persistance.ProductDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j        // 이걸쓰면 log.debug() 명령사용가능
@Controller
public class HomeController {
	

	private final ProductDao productDao;
	public HomeController(ProductDao productDao) {
		this.productDao = productDao;
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home( Model model) {
//		List<ProductVO> productlist = productDao.selectAll();
//		model.addAttribute("PRODUCT_LIST",productlist);
//		
//		return "home";	
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	    List<ProductVO> productList = productDao.selectAll();
	    model.addAttribute("PRODUCT_LIST", productList);

	    // 합계 계산용
	    int totalPurchase = 0;
	    int totalSales = 0;
	    for (ProductVO product : productList) {
	        if (product.getIo_input() == 1) {
	            totalPurchase += product.getIo_total();
	        } else if (product.getIo_input() == 2) {
	            totalSales += product.getIo_total();
	        }
	    }
	    model.addAttribute("totalPurchase", totalPurchase);
	    model.addAttribute("totalSales", totalSales);

	    return "home";
	}

//	----------------------- 상품추가
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert() {
		
		return "input";
		
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(ProductVO productVO) {
		
		log.debug(productVO.toString());
		
		int result = productDao.insert(productVO);
		
		return "redirect:/";
	}

	// --------------------디테일-----------------------
	@RequestMapping(value="/detail", method=RequestMethod.GET)

		public String detail(@RequestParam("i_seq")String seq, Model model,
				@RequestParam(name="msg",required = false, defaultValue="OK") String msg) { // required = false : mag 값이 없어도된다. 없으면 OK
			
			ProductVO productVO = productDao.findById(seq);
			model.addAttribute("PRODUCT",productVO);
			model.addAttribute("MSG",msg);
			
			return "detail";
		
	}
	
//	---------------------- 삭제 ---------------------------
	@RequestMapping(value="/delete/{seq}",method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		int result = productDao.delete(seq);

			return "redirect:/";
	
	}
	
//	----------------------------- 수정 ----------------------------
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("i_seq")String seq, Model model) {
		
		ProductVO productVO = productDao.findById(seq);
		model.addAttribute("PRODUCT",productVO);
		return "input";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@RequestParam("i_seq")String seq, ProductVO productVO) {
		
		
		productVO.setIo_seq(Integer.valueOf(seq));
		int result = productDao.update(productVO);

		log.debug("Update {}",productVO.toString());
		String retString = String.format("redirect:/detail?i_seq=%s", productVO.getIo_seq()); 
		
		return retString;
		
//		 return "redirect:/custom/detail?c_code=" + customVO.getC_code(); 리턴문에서 직접하는법 
		
	}
	
}
