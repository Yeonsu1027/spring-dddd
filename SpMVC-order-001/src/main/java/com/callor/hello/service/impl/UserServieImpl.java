package com.callor.hello.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

/*
 * UserServiceImpl 클래스는 userService 라는 이름의
 * Service 역할을 수행하는 컴포넌트(bean)이다 라는 선언
 * */
@Service("userService") // Service bean 안만들어도 자동 bean생성 : xml 안만들어도됨
public class UserServieImpl implements UserService{

	@Override
	public UserDto getUSer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
