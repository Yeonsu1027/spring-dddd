package com.callor.hello;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.dao.ANemoDao;
import com.callor.hello.dao.ClearDao;
import com.callor.hello.dao.NemoDao;
import com.callor.hello.model.ANemoVO;
import com.callor.hello.model.ClearVO;
import com.callor.hello.model.NemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final NemoDao nemoDao;
	private final ANemoDao anemoDao;
	private final ClearDao clearDao;
	public HomeController(NemoDao nemoDao, ANemoDao anemoDao, ClearDao clearDao) {
		super();
		this.nemoDao = nemoDao;
		this.anemoDao = anemoDao;
		this.clearDao = clearDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, NemoVO nemoVO) {

		// 주소에서 가져오는 대신 임시로 쓸 칸개수 번호 변수
		// 나중에 난이도 별로 만들면 주소에 그림번호/칸개수번호/(n*n)를 넣고
		int row = 5;

		// ----- ----게임을 시작하면 바로 테이블정보 생성..------------
		// 맨처음 한 번 만 생성되어야 하니까 데이터 조회해서 if
		// 데이터 조회로 변경해야함

		// 데이터 설정 : 아이디랑 그림번호,행번호라고 조회하는거해서
		String userid = "USER1";
		nemoVO.setP_id(userid); // 임시적용 아이디
		nemoVO.setP_num(1); // 나중에 그림번호 변수 만들어서 1자리에 집어넣기
		nemoVO.setP_row_num(1);

		// 그림번호로 조회하는거니 이게 있으면.. 플레이를 한적있는거
		Integer numcheck = nemoDao.findByRow_num(nemoVO);
				

		// 없으면 처음시작하는 스테이지니까 생성
		if (numcheck == null) {

			// block 0으로 세팅하는것도 그걸로 if문써서 난이도에 맞게 자동생성되게끔!
			nemoVO.setP_block1(0);
			nemoVO.setP_block2(0);
			nemoVO.setP_block3(0);
			nemoVO.setP_block4(0);
			nemoVO.setP_block5(0); // 모든 스테이지를 다 만들게 아니면 반복문으로...해야할듯

			for (int i = 0; i < row; i++) {
				nemoVO.setP_row_num(i + 1); // 현재는 총5개
				nemoDao.insert(nemoVO);
			}
			// 다시 생성안되게
		} // 자동생성 if문 end -------------------------------------------


		return "home";
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public String home(@RequestParam(value = "p_num", required = false) Integer num,
			@RequestParam(value = "p_row_num", required = false) Integer row_num,
			@RequestParam(value = "p_block1", required = false) Integer block1,
			@RequestParam(value = "p_block2", required = false) Integer block2,
			@RequestParam(value = "p_block3", required = false) Integer block3,
			@RequestParam(value = "p_block4", required = false) Integer block4,
			@RequestParam(value = "p_block5", required = false) Integer block5, Model model, NemoVO nemoVO) {

		// ===============================================================
		// ***** 기본정보 3개 세팅 *******

		// 임시적용 - 나중에 로그인 아이디 가져와서 집어넣기..
		String userid = "USER1";
		nemoVO.setP_id(userid); // 아이디

		nemoVO.setP_num(num); // 그림번호 - 이건나중에 주소자체에 집어넣기
		nemoVO.setP_row_num(row_num); // 행번호..

		// ===============================================================
//			해야할것 기존데이터는 >>>> 그대로 <<<< """""클릭한 것만"""""" 1로
//				그리고 체크 안한건 null 이되니까 입력이 null 인 건 기존데이터를 불러와서
//				다시 그걸로 저장!
		
		NemoVO existingData = nemoDao.findByRow(nemoVO); // 입력받은 행에 대한 정보를 조회한 것
		int zero = 0;
		int one = 1;

		// 입력받은 칸이 기존데이터가 0 이면 1로 저장
		if(block1 != null && block1 == one && existingData.getP_block1() ==zero) {
			nemoVO.setP_block1(block1); 
			// 나머지 기존데이터
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
			nemoVO.setP_block5(existingData.getP_block5()); 
		} else if(block1 != null && block1 == one && existingData.getP_block1() ==one) {
			// 1로 이미저장되어있으면 0으로 다시저장
			nemoVO.setP_block1(zero); 
			// 나머지 기존데이터
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
			nemoVO.setP_block5(existingData.getP_block5()); 
			// ------------------------------------------------------------------------ 이거 하나당 블록칸1개..
		} else if(block2 != null && block2 == one && existingData.getP_block2() ==zero) {
			nemoVO.setP_block2(block2); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
			nemoVO.setP_block5(existingData.getP_block5()); 
		} else if(block2 != null && block2 == one && existingData.getP_block2() ==one) {
			nemoVO.setP_block2(zero); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
			nemoVO.setP_block5(existingData.getP_block5());
			// ------------------------------------------------------------------------
		} else if(block3 != null && block3 == one && existingData.getP_block3() ==zero) {
			nemoVO.setP_block3(block3); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
			nemoVO.setP_block5(existingData.getP_block5()); 
		} else if(block3 != null && block3 == one && existingData.getP_block3() ==one) {
			nemoVO.setP_block3(zero); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
			nemoVO.setP_block5(existingData.getP_block5());
			// ------------------------------------------------------------------------
		} else if(block4 != null && block4 == one && existingData.getP_block4() ==zero) {
			nemoVO.setP_block4(block4); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block5(existingData.getP_block5()); 
		} else if(block4 != null && block4 == one && existingData.getP_block4() ==one) {
			nemoVO.setP_block4(zero); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block5(existingData.getP_block5());
			// ------------------------------------------------------------------------
		} else if(block5 != null && block5 == one && existingData.getP_block5() ==zero) {
			nemoVO.setP_block5(block5); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block4(existingData.getP_block4()); 
		} else if(block5 != null && block5 == one && existingData.getP_block5() ==one) {
			nemoVO.setP_block5(zero); 
			nemoVO.setP_block1(existingData.getP_block1()); 
			nemoVO.setP_block2(existingData.getP_block2()); 
			nemoVO.setP_block3(existingData.getP_block3()); 
			nemoVO.setP_block4(existingData.getP_block4());
			// ------------------------------------------------------------------------
		} 
		nemoDao.update(nemoVO);

		// ---------- 이후 할일 --------------

		// 입력한 데이터 바로바로 불러와지기 (칸 칠해져있게)

		/*
		 * 행 데이터를 전부 불러오고, 마찬가지로 플레이어 게임정보 데이터도 전부 불러와서 findByRow로 한줄씩 다 가져와서 비교 각각의
		 * 행데이터(block 의 값)을 비교해서 .. 점수변수를 하나 선언하고.. 다른게 있으면 ++ 해서 스테이지 점수 별같은거 조정
		 * 
		 * 다 맞췄으면 클리어 테이블에 데이터 생성 c_id, c_level, c_clear (유저아이디,그림번호,클리어(1))
		 * 
		 * 
		 */

		// 나중에 메인화면(스테이지 선택창)에서 이 클리어테이블 정보를 불러와서 없으면 ?같은 그림으로 보이게하고
		// 클리어를 한 스테이지 이면 완성된 도트 이미지 보여주기

//		log.debug(nemoVO.toString());
//		log.debug("{}",rowcheck);
//		log.debug("block1: {}, block2: {}, block3: {}, block4: {}, block5: {}", block1, block2, block3, block4, block5);

		return "redirect:/";
	}
	
	// 정답비교 
	// 그림번호/행번호 row는 게임하는곳에서 행 개수 변수
	@RequestMapping(value="/correct_check/{p_num}/{row}", method=RequestMethod.GET)
	public String correct_check (Model model, NemoVO nemoVO, ANemoVO anemoVO, ClearVO clearVO,
			@RequestParam(value = "p_num", required = false) Integer picture_num,
			@RequestParam(value = "row", required = false) Integer row_num
			) {
		
		// 틀린 개수 세어줄 변수
		int wrong_count = 0;
		
		// 현재 row_num(행번호 는 5)
		String userid = "USER1";
		nemoVO.setP_id(userid);
		
		anemoVO.setN_num(picture_num); // 그림번호
		nemoVO.setP_num(picture_num);// 플레이정보 것도 세팅
		
		// 정답테이블과 플레이어 테이블 값을 전부비교
		for(int i =0 ; i<row_num ; i++) {
		    anemoVO.setN_row_num(i+1);
		    nemoVO.setP_row_num(i+1);
		    ANemoVO correct_row =  anemoDao.findByRow(anemoVO);
		    NemoVO play_row =  nemoDao.findByRow(nemoVO);

// 다른거있으면 틀린개수 증가
		    if(correct_row.getN_block1() != play_row.getP_block1()) {
		        wrong_count += 1;
		    }
		    if(correct_row.getN_block2() != play_row.getP_block2()) {
		        wrong_count += 1;
		    }
		    if(correct_row.getN_block3() != play_row.getP_block3()) {
		        wrong_count += 1;
		    }
		    if(correct_row.getN_block4() != play_row.getP_block4()) {
		        wrong_count += 1;
		    }
		    if(correct_row.getN_block5() != play_row.getP_block5()) {
		        wrong_count += 1;
		    }
		}// for end
		
		if(wrong_count > 0) {
	        model.addAttribute("wrongMessage", wrong_count + "개 틀렸어요!");
	    } else {
	        model.addAttribute("clearMessage", "완성했어!!");
	        // 클리어정보 테이블에 데이터 생성 
	        clearVO.setC_id(userid);
	        clearVO.setC_level(picture_num);
	        clearVO.setC_clear(1);
	        clearDao.insert(clearVO);
	    }
		
		
		
		return "home"; // 검사하고 다시게임화면으로
	}
	
}
