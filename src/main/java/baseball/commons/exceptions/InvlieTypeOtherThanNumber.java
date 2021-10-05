package baseball.commons.exceptions;

import baseball.commons.response.ErrorCode;

public class InvlieTypeOtherThanNumber extends BaseException {

	public InvlieTypeOtherThanNumber() {
		super(ErrorCode.NOT_NUMBER);
	}
}
