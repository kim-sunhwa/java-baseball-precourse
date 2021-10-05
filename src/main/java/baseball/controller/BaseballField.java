package baseball.controller;

import baseball.commons.exceptions.BaseException;
import baseball.commons.response.PlayCode;
import baseball.service.Refree;
import nextstep.utils.Console;

public class BaseballField {

	private final Refree refree;

	public BaseballField(Refree refree) {
		this.refree = refree;
	}

	public void start() {
		readyToPlayer();
		this.refree.play();
	}

	private void readyToPlayer() {
		try {
			System.out.println(PlayCode.PLAY_START);
			String playerNumber = Console.readLine();
			this.refree.isValidPlayerStrategy(playerNumber);
		} catch (BaseException exception) {
			System.out.println(exception.getMessage());
			readyToPlayer();
		}
	}
}
