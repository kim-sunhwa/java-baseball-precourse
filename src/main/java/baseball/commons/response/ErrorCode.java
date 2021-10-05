package baseball.commons.response;

public enum ErrorCode {

	INVALID_RANGE_NUMBER("[ERROR] 1~9 사이의 값을 입력하세요."),
	INVALID_LENGTH_NUMBER("[ERROR] 3자리 수를 입력하세요."),
	INVALID_DUPLICATED_NUMBER("[ERROR] 각각 다른 3자리의 수를 입력하세요."),
	NOT_NUMBER("[ERROR] 숫자를 입력하셔야 합니다."),

	// 재시작 및 종료 입력 에러
	INVALID_END_OR_RESTART("[ERROR] 1 또는 2로만 입력 하세요.");

	private String errorMessage;

	ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
