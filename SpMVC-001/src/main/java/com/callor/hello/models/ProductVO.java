package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVO {
	private String p_code;	//varchar(6)
	private String p_name;	//varchar(25)
	private String p_item;	//varchar(25)
	private int p_price;	//int
}
