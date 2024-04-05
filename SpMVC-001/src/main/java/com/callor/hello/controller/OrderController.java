package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.OrderCustomVO;
import com.callor.hello.models.OrderVO;
import com.callor.hello.persistance.OrderCustomDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/order")
public class OrderController {
	
//	private final OrderDao orderDao;
//	public OrderController(OrderDao orderDao) {
//		this.orderDao = orderDao;
//	}
//	
	private final OrderCustomDao orderCustomDao;
	public OrderController(OrderCustomDao orderCustomDao) {
		this.orderCustomDao = orderCustomDao;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET) 
	// 주소가 /hello/order/ 랑 /hello/order 둘다 받아지게
	public String home(Model model) {
		
		List<OrderCustomVO> orderList = orderCustomDao.selectAll();
		log.debug(orderList.toString());
		model.addAttribute("ORDER_LIST", orderList);
		
		return "order/list"; // 얜 / 이라 null 말고 주소
		
	}

}
