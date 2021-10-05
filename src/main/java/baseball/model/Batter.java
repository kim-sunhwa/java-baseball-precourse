package baseball.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import baseball.commons.exceptions.BaseException;
import baseball.commons.response.PlayCode;
import nextstep.utils.Randoms;

public class Batter {
	// computer
	private Map<Integer, PlayCard> playLists;

	public Batter() {
		this.playLists = new HashMap<>();
		strategy();
	}

	public void strategy() {
		if (playLists.size() >= PlayCode.LENGTH) {
			return;
		}
		createUniquePlayLists();
		strategy();
	}

	public boolean isStrike(int number, int idx) {
		if (playLists.containsKey(number)) {
			PlayCard playCard = playLists.get(number);
			return playCard.isStrike(number, idx);
		}
		return false;
	}

	public boolean isBall(Integer number, Integer idx) {
		if (playLists.containsKey(number)) {
			PlayCard playCard = playLists.get(number);
			return playCard.isBall(number, idx);
		}
		return false;
	}

	private void createUniquePlayLists() {
		int number = select();
		if (!playLists.containsKey(number)) {
			createPlayCard(number);
		}
	}

	private void createPlayCard(int number) {
		int idx = getIndex();
		try {
			PlayCard playCard = new PlayCard(number, idx);
			playLists.put(number, playCard);
		} catch (BaseException exception) {
			createPlayCard(select());
		}
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
			PlayCard playCard = playLists.get(number);
			arr[playCard.getIndex() - PlayCode.START_IDX] = number;
		}
		return Arrays.toString(arr);
	}
}
