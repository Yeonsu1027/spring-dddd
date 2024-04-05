package com.callor.hello.sql;

public class TableSQL {
	
	// final static 으로 쿼리만들기
	public final static String ORDER_CUSTOM = "SELECT * FROM tbl_orders O"
			+ "	JOIN tbl_customer C "
			+ "		ON O.o_ccode = C.c_code "
			+ "	ORDER BY O.o_num ";
}
