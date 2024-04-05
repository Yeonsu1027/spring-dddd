package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CustomVO;

import lombok.Delegate;

public interface CustomDao {
	
	@Select(" SELECT * FROM tbl_customer "
			+ "ORDER BY c_code DESC ")
	public List<CustomVO> selectAll(); 
	
	
	public int insert(CustomVO vo);
	
//	@ 매퍼나 여기 둘중하나만 필요
	
	@Select(" SELECT * FROM tbl_customer "
			+ " WHERE c_code = #{cCdoe} ")
	public CustomVO findById(String cCdoe);

	
	public int update(CustomVO customVO);

	@Delete("DELETE FROM tbl_customer WHERE c_code = #{cCode}")
	public int delete(String cCode);
	
}
