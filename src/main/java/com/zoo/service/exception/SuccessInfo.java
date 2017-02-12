package com.zoo.service.exception;

public class SuccessInfo {
	private static final Integer OK = 200;

	@SuppressWarnings("unused")
	private Integer code;
	
	public SuccessInfo(){
		this.code = OK;
	}

}
