package baseball.commons.exceptions;

import baseball.commons.response.ErrorCode;

public class InvalidDuplicatedNumber extends BaseException {

	public InvalidDuplicatedNumber() {
		super(ErrorCode.INVALID_DUPLICATED_NUMBER);
	}
}
