package com.kurly.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.service.MemberService;
import com.kurly.utils.AESAlgorithm;
import com.kurly.vo.LoginVO;
import com.kurly.vo.MemberUpdateVO;

@RestController
public class MemberAPIController {
	@Autowired
	MemberService service;
	
	@PostMapping("/login")
	public Map<String, String> postLogin(@RequestBody LoginVO vo, HttpSession session){
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		String pwd = vo.getPwd();
		try {
		pwd = AESAlgorithm.Encrypt(pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		vo.setPwd(pwd);
		
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
	@GetMapping("/member_cnt")
	public Map<String, Integer> getMemberCnt(){
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("count", service.selectMemberCount());
		return resultMap;
	}
	
	@PatchMapping("/member")
	public Map<String, String> patchMember(@RequestBody MemberUpdateVO vo){
		Map<String, String> resultMap = new HashMap<String, String>();
		
		service.updateMemberInfo(vo);
		resultMap.put("status", "success");
		resultMap.put("message", "변경되었습니다.");
		
		return resultMap;
	}
	
	@DeleteMapping("/member/{seq}")
	public Map<String, String> deleteMember(@PathVariable Integer seq){
		Map<String, String> resultMap = new HashMap<String, String>();
		
		service.deleteMemberInfo(seq);
		resultMap.put("status", "success");
		resultMap.put("message", "삭제되었습니다.");
		
		return resultMap;
	}
}
