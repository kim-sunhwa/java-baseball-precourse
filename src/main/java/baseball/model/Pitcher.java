package baseball.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import baseball.commons.exceptions.InvalidDuplicatedNumber;
import baseball.commons.exceptions.InvalidLengthOfNumber;
import baseball.commons.exceptions.InvalidRangeException;
import baseball.commons.exceptions.InvlieTypeOtherThanNumber;
import baseball.commons.response.PlayCode;

public class Pitcher {
	// player
	private static final String VALID_REGEX = "[+-]?\\d*(\\.\\d+)?";
	private Map<Integer, Integer> numbers;

	public Pitcher() {
		this.numbers = new HashMap<>();
	}

	public Map<Integer, Integer> play() {
		return this.numbers;
	}

	public void strategy(String number) {
		isValid(number);
		int idx = PlayCode.START_IDX;
		for (char charNo : number.toCharArray()) {
			numbers.put(Character.getNumericValue(charNo), idx++);
		}
	}

	private void isValid(String stringNo) {
		char[] chars = stringNo.toCharArray();
		isNotNumberAndLength(stringNo);
		if (isDuplicated(chars)) {
			throw new InvalidDuplicatedNumber();
		}
		checkRange(chars);
	}

	private void isNotNumberAndLength(String stringNo) {
		int length = stringNo.length();
		if (!stringNo.matches(VALID_REGEX)) {
			throw new InvlieTypeOtherThanNumber();
		}
		if (length < PlayCode.LENGTH || length > PlayCode.LENGTH) {
			throw new InvalidLengthOfNumber();
		}
	}

	private boolean isDuplicated(char[] stringOfNumber) {
		Set<Character> set = new HashSet<>();
		int size = stringOfNumber.length;
		int length = 0;
		while (length < size) {
			set.add(stringOfNumber[length++]);
		}
		return set.size() < PlayCode.LENGTH;
	}

	private void checkRange(char[] chars) {
		for (char no : chars) {
			isRangeOfOneToNine(no);
		}
	}

	private void isRangeOfOneToNine(int no) {
		if (no < PlayCode.MIN_ASC || no > PlayCode.MAX_ASC)
			throw new InvalidRangeException();
	}
}
