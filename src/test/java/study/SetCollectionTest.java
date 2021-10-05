package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("요구사항 1) Set의 size() 메소드를 활용해 Set의 크기를 확인")
	public void size() {
		int expected = 3;
		assertThat(numbers).isNotNull();

		int size = numbers.size();
		assertThat(size).isEqualTo(expected);
	}

	@DisplayName("요구사항 2) Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인-ParameterizedTest를 활용")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void contains(int input) {
		assertThat(numbers).isNotNull();
		boolean contains = numbers.contains(input);

		assertThat(contains).isTrue();
	}

	@DisplayName("요구사항 3) 요구사항 2에 대해서 입력 값에 따라 결과값이 다른 경우에 대한 테스트를 하나의 Test Case로 구현")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	public void contains(int input, boolean expected) {
		assertThat(numbers).isNotNull();
		boolean contains = numbers.contains(input);

		assertThat(contains).isEqualTo(expected);
	}
}
