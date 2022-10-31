package com.kwei.springboot.exception;

public class UserNotExistException extends RuntimeException {
	
	private static final long serialVersionUID = 432423423424242L;
	
	public UserNotExistException() {
		super("用戶不存在!");
	}

	public UserNotExistException(String message) {
		super(message);
	}
	
}
