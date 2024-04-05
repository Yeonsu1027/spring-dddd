package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ProductVO;

public interface ProductDao {
	@Select("SELECT * FROM tbl_product")
	public List<ProductVO> selectAll();
//	public void findByPk(String pk);
//	
//	public int insert(ProductVO productVO);
//	public int update(ProductVO productVO);
//	public int delete(String pk);
//
//	@Insert(" INSERT INTO tbl_product (p_code, p_name,p_item, p_price) "
//			+ "	VALUE(#{p_code},#{p_name},#{p_item},#{p_price}) ")
	public int insert(ProductVO vo);
}