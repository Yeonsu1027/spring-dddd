package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.model.MembersVO;


public interface MembersDao {

	public List<MembersVO> selectAll();
	
	public int insert(MembersVO vo);
	
	public int update(MembersVO vo);
}
