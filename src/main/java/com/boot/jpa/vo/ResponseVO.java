package com.boot.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseVO {

	private int code;
	private String message;
}
