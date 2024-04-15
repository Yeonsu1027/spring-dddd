package com.callor.hello;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.dao.NemoDao;
import com.callor.hello.model.NemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final NemoDao nemoDao;

	public HomeController(NemoDao nemoDao) {
		this.nemoDao = nemoDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(
			@RequestParam(value = "p_block1", required = false) Integer block1,
			@RequestParam(value = "p_block2", required = false) Integer block2,
			@RequestParam(value = "p_block3", required = false) Integer block3,
			@RequestParam(value = "p_block4", required = false) Integer block4,
			@RequestParam(value = "p_block5", required = false) Integer block5, Model model,NemoVO nemoVO) {

		// 임시적용
		nemoVO.setP_id("USER1"); // 아이디
		nemoVO.setP_num(1); //그림번호
		nemoVO.setP_row_num(1); // 행번호..

		// 체크박스의 값이 전송되지 않으면 자동으로 0으로 설정
		nemoVO.setP_block1(block1 != null ? block1 : 0);
		nemoVO.setP_block2(block2 != null ? block2 : 0);
		nemoVO.setP_block3(block3 != null ? block3 : 0);
		nemoVO.setP_block4(block4 != null ? block4 : 0);
		nemoVO.setP_block5(block5 != null ? block5 : 0);

		nemoDao.insert(nemoVO);

//		log.debug(nemoVO.toString());
		log.debug("block1: {}, block2: {}, block3: {}, block4: {}, block5: {}", block1, block2, block3, block4, block5);
		
		return "redirect:/hello";
	}
}
