package com.kurly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurly.mapper.MemberMapper;
import com.kurly.vo.LoginVO;

@Service
public class MemberService {
	@Autowired
	MemberMapper mapper;
	
	public boolean loginMember(LoginVO vo) {
		return mapper.loginMember(vo) == 1;
	}
}
