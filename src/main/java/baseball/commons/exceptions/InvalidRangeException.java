package baseball.commons.exceptions;

import baseball.commons.response.ErrorCode;

public class InvalidRangeException extends BaseException {
	public InvalidRangeException() {
		super(ErrorCode.INVALID_RANGE_NUMBER);
	}
}
