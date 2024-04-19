package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.model.ANemoVO;
import com.callor.hello.model.ClearVO;
import com.callor.hello.model.NemoVO;


public interface ClearDao {

	// 스테이지 클리어했는지 확인하는용
	public ClearVO findByRow(ClearVO vo);
	
	// 클리어정보 생성용
	public int insert(ClearVO vo);

}
