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
	private int io_seq; //AUTO_INCREMENT PRIMARY KEY,
	private String io_date; //VARCHAR(10),
	private String io_time ;//VARCHAR(10),
	private String io_pname ;//VARCHAR(30),
	private int io_input; //INT,
	private int io_price ;//INT,
	private int io_quan ;//INT,
	private int io_total ;//INT
}
