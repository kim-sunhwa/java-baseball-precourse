package baseball.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import baseball.commons.exceptions.InvalidRangeException;
import baseball.commons.response.PlayCode;
import nextstep.utils.Randoms;

public class Batter {
	// computer
	private Map<Integer, Integer> playLists;

	public Batter() {
		this.playLists = new HashMap<>();
		strategy(select());
	}

	public void strategy(int number) {
		if (number < PlayCode.MIN || number > PlayCode.MAX) {
			throw new InvalidRangeException();
		}
		if (playLists.size() >= PlayCode.LENGTH) {
			return;
		}
		int idx = getIndex();
		if (!playLists.containsKey(number)) {
			playLists.put(number, idx++);
		}
		strategy(select());
	}

	private int getIndex() {
		return playLists.size() + PlayCode.START_IDX;
	}

	private int select() {
		return Randoms.pickNumberInRange(PlayCode.MIN, PlayCode.MAX);
	}

	@Override
	public String toString() {
		int[] arr = new int[PlayCode.LENGTH];
		for (Integer number : playLists.keySet()) {
			int idx = playLists.get(number) - PlayCode.START_IDX;
			arr[idx] = number;
		}
		return Arrays.toString(arr);
	}
}
