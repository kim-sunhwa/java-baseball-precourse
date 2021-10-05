package baseball.controller;

import baseball.commons.exceptions.BaseException;
import baseball.commons.response.PlayCode;
import baseball.model.Batter;
import baseball.model.Pitcher;
import nextstep.utils.Console;

public class BaseballField {

	public void start() {
		Batter batter = new Batter();
		readyToPlayer();
	}

	private void readyToPlayer() {
		try {
			Pitcher pitcher = new Pitcher();
			System.out.println(PlayCode.PLAY_START);
			String s = Console.readLine();
			pitcher.strategy(s);
		} catch (BaseException exception) {
			System.out.println(exception.getMessage());
			start();
		}

	}
}
