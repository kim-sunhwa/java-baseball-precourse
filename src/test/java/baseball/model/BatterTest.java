package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BatterTest {

	private Batter batter = getInstance();
	private String batterNumber = getBatterNumber();

	private Batter getInstance() {
		Batter newBatter = new Batter();
		return newBatter;
	}

	private String getBatterNumber() {
		String text = batter.toString().replace(", ", "");
		int openIdx = text.indexOf('[') + 1;
		int closeIdx = text.indexOf(']');
		return text.substring(openIdx, closeIdx);
	}

	@RepeatedTest(20)
	@DisplayName("컴퓨터 1-9 범위 3자리 숫자 생성 확인")
	void checkNumberLength() {
		HashSet<String> set = new HashSet<>(Arrays.asList(batterNumber.split("")));

		assertNotNull(batterNumber);
		assertAll(
			() -> assertTrue(batterNumber.matches("[1-9]{3}"), "1-9범위 내 3자리 숫자 확인"),
			() -> assertTrue(batterNumber.length() == 3, "3자리 확인"),
			() -> assertTrue(set.size() == 3, "각기 다른 3자리 확인")
		);
	}
}
