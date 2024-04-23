package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.BBsVO;

// VO, PK는 임의의 이름
public interface GenericDao<VO, PK> {

	public List<VO> selectAll();
	public VO findById(String pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	
}
