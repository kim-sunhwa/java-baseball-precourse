package baseball.model;

import baseball.commons.exceptions.InvalidRangeException;
import baseball.commons.response.PlayCode;

public class PlayCard {

	private int number;
	private int index;

	public PlayCard(int number, int index) {
		if (number < PlayCode.MIN || number > PlayCode.MAX) {
			throw new InvalidRangeException();
		}
		this.number = number;
		this.index = index;
	}

	public boolean isStrike(int number, int idx) {
		return (isSame(number) && this.index == idx);
	}

	public boolean isBall(int number, int idx) {
		return (isSame(number) && this.index != idx);
	}

	public boolean isSame(int number) {
		return this.number == number;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
