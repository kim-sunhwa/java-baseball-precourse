package baseball.model;

import java.util.HashMap;
import java.util.Map;

import baseball.commons.response.PlayCode;

public class Pitcher {
	// player
	private Map<Integer, Integer> numbers;

	public Pitcher() {
		this.numbers = new HashMap<>();
	}

	public void strategy(String number) {
		int idx = PlayCode.START_IDX;
		for (char charNo : number.toCharArray()) {
			numbers.put(Character.getNumericValue(charNo), idx++);
		}
	}

	public Map<Integer, Integer> play() {
		return this.numbers;
	}
}
