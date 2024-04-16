package com.callor.hello;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.dao.ANemoDao;
import com.callor.hello.dao.NemoDao;
import com.callor.hello.model.ANemoVO;
import com.callor.hello.model.NemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final NemoDao nemoDao;
	private final ANemoDao anemoDao;
	
	
public HomeController(NemoDao nemoDao, ANemoDao anemoDao) {
		super();
		this.nemoDao = nemoDao;
		this.anemoDao = anemoDao;
	}

//	public HomeController(NemoDao nemoDao) {
//		this.nemoDao = nemoDao;
//	}

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// db연결확인용 -> 잘뜸 연결엔 이상없음..
//		List<NemoVO> testlist = nemoDao.selectAll();
//		model.addAttribute("test", testlist);
		
		List<ANemoVO> alist = anemoDao.selectAll();
		model.addAttribute("answer", alist);
		return "home";
	}

	@RequestMapping(value = {"/",""}, method = RequestMethod.POST)
	public String home(
			@RequestParam(value = "p_num", required = false) Integer num,
			@RequestParam(value = "p_row_num", required = false) Integer row_num,
			@RequestParam(value = "p_block1", required = false) Integer block1,
			@RequestParam(value = "p_block2", required = false) Integer block2,
			@RequestParam(value = "p_block3", required = false) Integer block3,
			@RequestParam(value = "p_block4", required = false) Integer block4,
			@RequestParam(value = "p_block5", required = false) Integer block5, Model model,NemoVO nemoVO) {

		// 임시적용 - 나중에 로그인 아이디 가져오기..
		nemoVO.setP_id("USER1"); // 아이디
		
		nemoVO.setP_num(num); //그림번호 - 이건나중에 주소자체에 집어넣기
		nemoVO.setP_row_num(row_num); // 행번호..

		// 체크박스의 값이 전송되지 않으면 자동으로 0으로 설정
		nemoVO.setP_block1(block1 != null ? block1 : 0);
		nemoVO.setP_block2(block2 != null ? block2 : 0);
		nemoVO.setP_block3(block3 != null ? block3 : 0);
		nemoVO.setP_block4(block4 != null ? block4 : 0);
		nemoVO.setP_block5(block5 != null ? block5 : 0);
		
		// 나머지도 해줘야하나?
		nemoVO.setP_block6(null);
		nemoVO.setP_block7(null);
		nemoVO.setP_block8(null);
		nemoVO.setP_block9(null);
		nemoVO.setP_block10(null);
		nemoVO.setP_block11(null);
		nemoVO.setP_block12(null);
		nemoVO.setP_block13(null);
		nemoVO.setP_block14(null);
		nemoVO.setP_block15(null);

		// 한줄 추가 -- 
		nemoDao.insert(nemoVO);
		
		
		// ---------- 이후 할일 -------------- 
		// 0인 줄도 있고 클릭을 안할 수도 있으니 게임을하면 일단 5개의 행 데이터가 0으로 생성(?)
		
		// 나중에 if(id,p_num,p_row_num 일치하는행있으면) 
		// { 업데이트
		// }

//		log.debug(nemoVO.toString());
		log.debug("{}",num);
		log.debug("block1: {}, block2: {}, block3: {}, block4: {}, block5: {}", block1, block2, block3, block4, block5);
		
		return "redirect:/hello";
	}
}
