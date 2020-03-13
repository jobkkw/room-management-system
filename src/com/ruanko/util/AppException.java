package com.ruanko.util;

public class AppException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int exceptionCode;
	private String message;
	
	public AppException (String message) {
		this.message = message;
	}
	
	public AppException (String message, int exceptionCode) {
		this.message = message;
		this.exceptionCode = exceptionCode;
	}
	
	//获取异常编号
	public int getExceptionCode () {
		return exceptionCode;		
	}
	
	//获取异常的信息
	public String getMessage () {
		return message;		
	}
	
	//获取异常详细信息
	public String getDetailMessage () {		
		return "Detail message："+exceptionCode+"："+message;
	}
	
	
}
