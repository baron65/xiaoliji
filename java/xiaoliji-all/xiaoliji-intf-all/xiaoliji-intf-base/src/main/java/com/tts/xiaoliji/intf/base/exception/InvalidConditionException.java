package com.tts.xiaoliji.intf.base.exception;

public class InvalidConditionException extends IntfRuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidConditionException(String errorCode) {
		super(errorCode);
	}
}
