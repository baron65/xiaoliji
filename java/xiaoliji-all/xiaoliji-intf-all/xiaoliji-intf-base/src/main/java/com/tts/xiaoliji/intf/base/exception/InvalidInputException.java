package com.tts.xiaoliji.intf.base.exception;

public class InvalidInputException extends IntfRuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errorCode) {
		super(errorCode);
	}

	public InvalidInputException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}
}
