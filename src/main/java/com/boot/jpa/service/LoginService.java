package com.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jpa.domain.UserInfo;
import com.boot.jpa.repository.UserInfoRepository;
import com.boot.jpa.vo.ResponseVO;

@Service
public class LoginService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	public ResponseVO login(String email) {
		UserInfo userInfo = userInfoRepository.findByEmail(email);
		if (userInfo == null) {
			throw new NullPointerException("user is not exist");
		}
		
		ResponseVO responseVO = new ResponseVO(0, "user exist");
		return responseVO;
	}

}
