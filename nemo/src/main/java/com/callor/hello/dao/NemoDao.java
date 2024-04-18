package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.model.NemoVO;

public interface NemoDao {

	public List<NemoVO> selectAll();
	
	public int insert(NemoVO vo);
	
	public int update(NemoVO vo);
	
	// 플레이어의 데이터가 이미있는지 1줄 조회용
	public NemoVO findByRow(NemoVO vo);
	
	// 아이디 값, 그림번호, 행번호를 전부 가져와서 입력받은 것과 비교조회 한다면?
	public String findByRow_id(NemoVO vo);
	public Integer findByRow_num(NemoVO vo);
	public Integer findByRow_row_num(NemoVO vo);

}
