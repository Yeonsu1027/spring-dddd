package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.model.NemoVO;

public interface NemoDao {

	public List<NemoVO> selectAll();
	
	public int insert(NemoVO vo);
}
