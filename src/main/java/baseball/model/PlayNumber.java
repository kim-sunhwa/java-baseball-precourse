package baseball.model;

import java.util.HashSet;
import java.util.Set;

import baseball.commons.exceptions.InvalidDuplicatedNumber;
import baseball.commons.exceptions.InvalidLengthOfNumber;
import baseball.commons.exceptions.InvalidRangeException;
import baseball.commons.exceptions.InvlieTypeOtherThanNumber;
import baseball.commons.response.PlayCode;

public class PlayNumber {

	private static final String VALID_REGEX = "[+-]?\\d*(\\.\\d+)?";
	private static PlayNumber number = getInstance();

	private PlayNumber() {
	}

	public static void isValid(String stringNo) {
		char[] chars = stringNo.toCharArray();
		number.isNotNumberAndLength(stringNo);
		if (number.isDuplicated(chars)) {
			throw new InvalidDuplicatedNumber();
		}
		number.checkRange(chars);
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

	private static PlayNumber getInstance() {
		return new PlayNumber();
	}
}
