//package com.callor.hello.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service("nemoProviderImpl")
//public class NemoProviderImpl implements AuthenticationProvider{
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		
//		String username = authentication.getName();
//		String password = authentication.getCredentials().toString();
//		
//		if(username == null || username.isBlank() || username.equalsIgnoreCase("USER1")) {
//			throw new UsernameNotFoundException("x");
//		}
//		
//		if(password == null || password.isBlank() || password.equalsIgnoreCase("12345")) {
//			throw new UsernameNotFoundException("x");
//		}
//		
//		List<GrantedAuthority> grantList = new ArrayList<>();
//		grantList.add(new SimpleGrantedAuthority("USER"));
//		grantList.add(new SimpleGrantedAuthority("ADMIN"));
//		
//		UsernamePasswordAuthenticationToken token
//			= new UsernamePasswordAuthenticationToken(username, password, grantList);
//		
//		return token;
//	}
//
////	@Override
////	public boolean supports(Class<?> authentication) {
////		// TODO Auto-generated method stub
////		return true;
////	}
//	
//	@Override
//	public boolean supports(Class<?> authentication) {
//	    return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//
//
//}
