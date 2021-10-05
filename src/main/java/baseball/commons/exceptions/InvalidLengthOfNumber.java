package baseball.commons.exceptions;

import baseball.commons.response.ErrorCode;

public class InvalidLengthOfNumber extends BaseException {

	public InvalidLengthOfNumber() {
		super(ErrorCode.INVALID_LENGTH_NUMBER);
	}
}
