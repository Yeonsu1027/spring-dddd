package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.model.TestVO;

public interface TestDao {
	
public List<TestVO> selectAll();
	
	public int insert(TestVO vo);
	
	public int update(TestVO vo);

}
