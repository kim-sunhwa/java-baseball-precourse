package baseball.commons.response;

public enum ErrorCode {

	INVALID_RANGE_NUMBER("[ERROR] 1~9 사이의 값을 입력하세요.");

	private String errorMessage;

	ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
