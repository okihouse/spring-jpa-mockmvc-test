package com.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.service.LoginService;
import com.boot.jpa.vo.ResponseVO;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseVO login(@RequestParam String email) {
		return loginService.login(email);
	}
}
