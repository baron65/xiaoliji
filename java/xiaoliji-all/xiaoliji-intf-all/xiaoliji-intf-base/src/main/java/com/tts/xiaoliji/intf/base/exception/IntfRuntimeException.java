package com.tts.xiaoliji.intf.base.exception;

public class IntfRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 5493777808778223383L;
	private static final String ERROR_MESSAGE_NOT_SET = IntfRuntimeException.class.getName()
			+ "-[ERROR_MESSAGE_NOT_SET]";
	private String errorCode;
	private String errorMessage = ERROR_MESSAGE_NOT_SET;
	private Object[] args = null;

	public IntfRuntimeException(String errorCode, String errorMsg, Object[] args) {
		this.errorCode = errorCode;
		this.args = args;
		this.errorMessage = errorMsg;
	}

	public IntfRuntimeException(String errorCode, Object[] args) {
		this(errorCode, null, args);
	}

	public IntfRuntimeException(String errorCode) {
		this.errorCode = errorCode;
	}

	public IntfRuntimeException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMessage = errorMsg;
	}

	@Deprecated
	public IntfRuntimeException() {
		this.errorCode = null;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public Object[] getArgs() {
		return this.args;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isErrorMessageSet() {
		return !ERROR_MESSAGE_NOT_SET.equals(getErrorMessage());
	}

	public String getErrorCode() {
		return this.errorCode;
	}
}
