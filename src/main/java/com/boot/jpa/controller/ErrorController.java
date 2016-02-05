package com.boot.jpa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.jpa.vo.ErrorVO;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler
	@ResponseBody
	public ErrorVO handlerException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		ErrorVO errorVO = new ErrorVO(exception.getMessage());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return errorVO;
	}
	
}
