package com.kurly.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kurly.vo.LoginVO;

@Mapper
public interface MemberMapper {
	public Integer loginMember(LoginVO vo);
}
