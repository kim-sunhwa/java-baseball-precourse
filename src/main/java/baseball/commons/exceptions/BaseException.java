package baseball.commons.exceptions;

import baseball.commons.response.ErrorCode;

public class BaseException extends RuntimeException {

	private ErrorCode errorCode;

	public BaseException() {
	}

	public BaseException(ErrorCode errorCode) {
		super(errorCode.getErrorMessage());
		this.errorCode = errorCode;
	}

}
