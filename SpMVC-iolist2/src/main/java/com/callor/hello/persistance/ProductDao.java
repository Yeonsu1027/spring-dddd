package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.hello.models.ProductVO;

public interface ProductDao {
	@Select(" SELECT * FROM tbl_iolist ORDER BY io_date DESC, io_time DESC ")
	public List<ProductVO> selectAll();
//	public void findByPk(String pk);
//	
	public int insert(ProductVO productVO);

	@Select(" SELECT * FROM tbl_iolist "
			+ " WHERE io_seq = #{seq} ")
	public ProductVO findById(String seq);
	
//	+ " SET io_pname = #{io_pname}, io_price = #{io_price}, io_input = #{io_input}, io_quan = #{io_quan} "
//	+ " WHERE io_seq = #{seq} ")
	public int update(ProductVO productVO);
//	@Update(" UPDATE tbl_iolist "
//			+ " SET io_pname = #{io_pname}, io_price = #{io_price}, io_input = #{io_input}, io_quan = #{io_quan} "
//			+ " WHERE io_seq = #{io_seq} ")
	
//	public int update(ProductVO productVO);
//	
	@Delete("DELETE FROM tbl_iolist WHERE io_seq = #{seq}")
	public int delete(String seq);
	
}