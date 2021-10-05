package baseball.controller;

import baseball.commons.exceptions.BaseException;
import baseball.commons.response.Message;
import baseball.service.Refree;
import nextstep.utils.Console;

public class BaseballField {

	private final Refree refree;

	public BaseballField(Refree refree) {
		this.refree = refree;
	}

	public boolean start() {
		readyToPlayer();
		return this.refree.play();
	}

	private void readyToPlayer() {
		try {
			Message.go();
			String playerNumber = Console.readLine();
			this.refree.isValidPlayerStrategy(playerNumber);
		} catch (BaseException exception) {
			Message.print(exception.getMessage());
			readyToPlayer();
		}
	}
}
