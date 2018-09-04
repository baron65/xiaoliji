package com.tts.xiaoliji.intf.base.exception;

public class InvalidServiceResponseException extends IntfRuntimeException {
	private static final long serialVersionUID = -8703920132921871068L;

	public InvalidServiceResponseException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public InvalidServiceResponseException(String errorCode) {
		super(errorCode);
	}
}
