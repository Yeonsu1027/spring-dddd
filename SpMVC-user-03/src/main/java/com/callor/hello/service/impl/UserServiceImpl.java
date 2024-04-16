package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;

	
	// alt shift s 에서 using Fields(거의맨아래거)
	public UserServiceImpl(
			@Qualifier("passEncoderV1") // 유틸리티랑 다른이름을쓸때
			PasswordEncoder passwordEncoder, UserDao userDao, RoleDao roleDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}


	/*
	 * 회원가입 절차 1. 기존에 가입된 회원이 있을까? 2. 있으면 새로 추가(가입)되는 회원은 일반 사용자 3. 없으면 새로 추가(가입)되는
	 * 회원은 admin 이며 일반 사용자
	 */
	@Transactional
	@Override
	public UserVO createUser(UserVO createUserVO) {
		
		String username = createUserVO.getUsername();
		String password = createUserVO.getPassword();
		
		List<UserVO> userList = userDao.selectAll();
		
		// 회원가입시 입력한 password 를 암호화하기
		String encPassword = passwordEncoder.encode(password);
		createUserVO.setPassword(encPassword);
		
		List<RoleVO> roles = new ArrayList<>();
		// 조건이 true 이면 아직 아무도 회원가입을 하지 않았다
		if(userList == null || userList.size() <= 0) { // -1인경우도 있어서... 작거나 같으면
			roles.add(RoleVO.builder()
					.r_username(username)
					.r_role("ROLE_ADMIN").build());
			roles.add(RoleVO.builder()
			.r_username(username)
			.r_role("ROLE_USER").build()); // 첫생성계정은 2개의 ROLE을가짐
			
		} else {
			roles.add(RoleVO.builder()
			.r_username(username)
			.r_role("ROLE_USER").build());
		}
		userDao.insert(createUserVO); // 계정이생성되면 /  역할추가
		roleDao.insertAll(roles); // 순서 중요! user먼저, 그다음에 role (role에 user 들어가니까)
		
		return null;
	}


	/*
	 * @Bean 은 xml 에서 생성했던 bean 을 Annotaion 방식으로 사용하기 위한 설정
	 * 
	 * 그런데 여기서는 create_table 을 프로젝트가 시작될때 자동으로 실행하도록 하기위해 사용
	 * 
	 * 프로젝트가 시작될때 table 이 없으면 자동으로 생성되는 method 를 실행하기 위함임
	 * 
	 */
	@Autowired
	public void create_table() {
		userDao.create_user_table(null);
		userDao.create_role_table(null);
	}

}
