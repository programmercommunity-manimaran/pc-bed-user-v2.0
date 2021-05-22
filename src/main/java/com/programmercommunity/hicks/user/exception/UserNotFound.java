package com.programmercommunity.hicks.user.exception;

public class UserNotFound extends RuntimeException {

	private static final long serialVersionUID = -5141489219231730197L;

	public UserNotFound(String message) {
		super(message);
	}
}
