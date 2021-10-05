package baseball.server;

import baseball.commons.response.PlayCode;
import baseball.controller.BaseballField;
import baseball.model.Batter;
import baseball.model.Pitcher;
import baseball.service.Refree;
import nextstep.utils.Console;

public class Stadium {

	private Stadium stadium;

	public static void goIn() {
		Stadium stadium = new Stadium();
		boolean restart = true;
		Batter batter = new Batter();

		while (restart) {
			System.out.println(batter);
			Pitcher pitcher = new Pitcher();
			Refree refree = new Refree(batter, pitcher);
			BaseballField baseballField = new BaseballField(refree);

			boolean isEnd = baseballField.start();

			if (isEnd) {
				System.out.println(PlayCode.RESTART);
				String s = Console.readLine();
				restart = (s.equals("1"));
			}
		}
	}
}
