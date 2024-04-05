package com.callor.iolist.exec;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateEx2 {
	
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		// 메모리 덜소모하고 안정적임
		String strDate = localDateTime.format(dayFormat);
		String strTime = localDateTime.format(timeFormat);
		System.out.println(strDate);
		System.out.println(strTime);
		
		System.out.println(localDateTime.plusYears(1)); //1년 후 날짜
		System.out.println(localDateTime.minusYears(1)); 
	}
}
