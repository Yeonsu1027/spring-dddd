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
		
		// db연결확인용 -> 잘뜸 db연결엔 이상없음..
//		List<NemoVO> testlist = nemoDao.selectAll();
//		model.addAttribute("test", testlist);
//		
		// 정답테이블 이건또 왜안나와
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

		// 임시적용 - 나중에 로그인 아이디 가져와서 집어넣기..
		String userid = "USER1";
		nemoVO.setP_id(userid); // 아이디
		
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

		
		// 해야할거:  if(id,p_num,p_row_num 일치하는행있으면) 
		// { 업데이트
		// }
		// WHERE 
		
		
		// 그러면 있는지 확인하는게아니라.. 입력받은거랑 기존데이터를 비교해서?
		// 조회한 것들
		String idcheck = nemoDao.findByRow_id(nemoVO); // 아이디
		Integer numcheck = nemoDao.findByRow_num(nemoVO); // 그림번호
		Integer rownumcheck = nemoDao.findByRow_row_num(nemoVO); // 행번호

		// 여기 id도 나중에 로그인 아이디 가져와서 넣어야함
		if (userid.equals(idcheck)) { 
		    if (numcheck != null && num.equals(numcheck)) {
		        if (rownumcheck != null && row_num.equals(rownumcheck)) {
		        	// 여기까지오면 이미데이터가 있는거니 업데이트
		        	
		        	// 1로 저장되어있던거 다시 체크해서 저장하면 0으로 바뀌게
		        	   NemoVO existingData = nemoDao.findByRow(nemoVO);
		        	
		        	   if(existingData != null) {
		        	        // 해당 위치의 값이 1이면 0으로 업데이트, 0이면 업데이트하지 않음
		        	        if(existingData.getP_block1() == 1) {
		        	            nemoVO.setP_block1(0);
		        	        }
		        	        if(existingData.getP_block2() == 1) {
		        	            nemoVO.setP_block2(0);
		        	        }
		        	        if(existingData.getP_block3() == 1) {
		        	            nemoVO.setP_block3(0);
		        	        }
		        	        if(existingData.getP_block4() == 1) {
		        	            nemoVO.setP_block4(0);
		        	        }
		        	        if(existingData.getP_block5() == 1) {
		        	            nemoVO.setP_block5(0);
		        	        }
		        	        nemoDao.update(nemoVO); 
		        	   } // 애초에 이미 데이터가 있는경우니 여긴 더 추가할 필요 없을듯
		        	   
		        } else {
		            nemoDao.insert(nemoVO); // 나머진 추가
		        }
		    } else {
		        nemoDao.insert(nemoVO);
		    }
		} else {
		    nemoDao.insert(nemoVO); 
		}

		
//		log.debug(idcheck);
		
		//-----------------------
//		nemoDao.insert(nemoVO);

		
		// ---------- 이후 할일 -------------- 
		
		// 입력한 데이터 바로바로 불러와지기 (칸 칠해져있게)
		// 이미 1로 입력된 칸 다시클릭하면 0으로 업데이트해서저장
		
		// 0인 줄도 있고 클릭을 안할 수도 있으니 게임을하면 일단 5개의 행 데이터가 0으로 생성되게하거나 < 이게더 쉬울듯?
		// 아니면 완성버튼 누르면 비어있는행 생성
		
		
		// 다 그렸다 누르면 정답테이블 불러와서 비교 후 점수매기기
		
		

//		log.debug(nemoVO.toString());
//		log.debug("{}",rowcheck);
//		log.debug("block1: {}, block2: {}, block3: {}, block4: {}, block5: {}", block1, block2, block3, block4, block5);
		
		return "redirect:/";
	}
}
