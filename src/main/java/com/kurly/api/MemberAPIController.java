package com.kurly.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.service.MemberService;
import com.kurly.vo.LoginVO;

@RestController
public class MemberAPIController {
	@Autowired
	MemberService service;
	
	@PostMapping("/login")
	public Map<String, String> postLogin(@RequestBody LoginVO vo, HttpSession session){
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		if(service.loginMember(vo)) {
			resultMap.put("status", "success");
			resultMap.put("message", "로그인 성공");
			session.setAttribute("user", vo.getId()); // 로그인 정보 저장
		}else{
			resultMap.put("status", "failed");
			resultMap.put("message", "관리자 전용 페이지입니다.");
		}

		return resultMap;
	}

}
