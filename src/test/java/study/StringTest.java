package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

	@Test
	@DisplayName("요구사항 1) \"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
	public void splitContains() {
		String str = "1,2";

		String[] split = str.split(",");

		assertThat(split).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항 1) \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환 확인")
	public void splitContainsExactly() {
		String str = "1";

		String[] split = str.split(",");   //  변수명 체크

		assertThat(split).containsExactly(str);
	}

	@Test
	@DisplayName("요구사항 2) \"(1,2)\" 값을 String의 substring() 메소드를 활용해 () 을 제거,  \"1,2\"를 반환 확인")
	public void substring() {
		String str = "(1,2)";
		String expected = "1,2";
		int nextOpenBracket = str.indexOf('(') + 1;
		int closeBracket = str.indexOf(')');

		String substring = str.substring(nextOpenBracket, closeBracket);

		assertThat(substring).isEqualTo(expected);
	}

	@DisplayName("요구사항 3) \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있는지 확인")
	@ParameterizedTest
	@CsvSource(value = {"0,a", "1,b", "2,c"})
	public void charAt(int input, char expected) {
		String str = "abc";
		char letter = str.charAt(input);

		assertThat(letter).isEqualTo(expected);
	}

	@DisplayName("요구사항 3) String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생 확인")
	@ParameterizedTest
	@ValueSource(strings = {"String", "IndexOutOfBounds", "Exception"})
	public void stringIndexOutOfBoundsException(String testText) {
		int out = 1;
		int outOfRange = testText.length() + out;

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> testText.charAt(outOfRange))
			.withMessageMatching("String index out of range: " + outOfRange);
	}
}
