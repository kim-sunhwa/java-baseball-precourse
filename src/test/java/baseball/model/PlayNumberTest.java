package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.commons.exceptions.InvalidDuplicatedNumber;
import baseball.commons.exceptions.InvalidLengthOfNumber;
import baseball.commons.exceptions.InvalidRangeException;
import baseball.commons.exceptions.InvlieTypeOtherThanNumber;
import baseball.commons.response.ErrorCode;

class PlayNumberTest {

	@DisplayName("사용자 입력값 중복 에러 확인")
	@ParameterizedTest
	@ValueSource(strings = {"122", "212", "999"})
	void userValidNumber(String number) {
		assertThatExceptionOfType(InvalidDuplicatedNumber.class)
			.isThrownBy(() -> PlayNumber.isValid(number))
			.withMessageContaining(ErrorCode.INVALID_DUPLICATED_NUMBER.getErrorMessage());
	}

	@DisplayName("사용자 입력값 문자타입 에러 확인")
	@ParameterizedTest
	@ValueSource(strings = {"ab1", "12d", "asd"})
	void userValidType(String number) {
		assertThatExceptionOfType(InvlieTypeOtherThanNumber.class)
			.isThrownBy(() -> PlayNumber.isValid(number))
			.withMessageContaining(ErrorCode.NOT_NUMBER.getErrorMessage());
	}

	@DisplayName("사용자 입력값 1-9범위 에러 확인")
	@ParameterizedTest
	@ValueSource(strings = {"102", "012", "980"})
	void userValidRange(String number) {
		assertThatExceptionOfType(InvalidRangeException.class)
			.isThrownBy(() -> PlayNumber.isValid(number))
			.withMessageContaining(ErrorCode.INVALID_RANGE_NUMBER.getErrorMessage());
	}

	@DisplayName("사용자 입력값 3자리 에러 확인")
	@ParameterizedTest
	@ValueSource(strings = {"12", "2", "9876"})
	void userValidLength(String number) {
		assertThatExceptionOfType(InvalidLengthOfNumber.class)
			.isThrownBy(() -> PlayNumber.isValid(number))
			.withMessageContaining(ErrorCode.INVALID_LENGTH_NUMBER.getErrorMessage());
	}

}
