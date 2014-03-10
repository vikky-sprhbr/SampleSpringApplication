package com.customexception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String customMessage) {
		super(customMessage);
	}

}
