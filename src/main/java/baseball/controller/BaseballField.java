package baseball.controller;

import baseball.commons.exceptions.BaseException;
import baseball.commons.response.PlayCode;
import baseball.model.Batter;
import baseball.model.Pitcher;
import baseball.service.Refree;
import nextstep.utils.Console;

public class BaseballField {

	public void start() {
		Batter batter = new Batter();
		System.out.println(batter);
		Pitcher pitcher = readyToPlayer();

		Refree refree = new Refree(batter, pitcher);
	}

	private Pitcher readyToPlayer() {
		try {
			Pitcher pitcher = new Pitcher();
			System.out.println(PlayCode.PLAY_START);
			String s = Console.readLine();
			pitcher.strategy(s);
			return pitcher;
		} catch (BaseException exception) {
			System.out.println(exception.getMessage());
			start();
		}
		return null;
	}
}
