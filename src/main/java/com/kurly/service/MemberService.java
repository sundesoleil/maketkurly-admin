package com.kurly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurly.mapper.MemberMapper;
import com.kurly.vo.LoginVO;
import com.kurly.vo.MemberUpdateVO;
import com.kurly.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberMapper mapper;
	
	public boolean loginMember(LoginVO vo) {
		return mapper.loginMember(vo) == 1;
	}
	public List<MemberVO> selectMembers(Integer offset){
		offset = offset * 10;
		return mapper.selectMembers(offset);
	}
	public Integer selectMemberCount() {
		return mapper.selectMemberCount();
	}
	public void updateMemberInfo(MemberUpdateVO vo) {
		mapper.updateMemberInfo(vo);
	}
	public void deleteMemberInfo(Integer seq) {
		mapper.deleteMemberInfo(seq);
	}
}
