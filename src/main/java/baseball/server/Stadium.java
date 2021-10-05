package baseball.server;

import baseball.controller.BaseballField;
import baseball.model.Batter;
import baseball.model.Pitcher;
import baseball.service.Refree;

public class Stadium {

	private Stadium() {
	}

	public static void goIn() {
		Stadium stadium = new Stadium();
		boolean restart = true;
		Batter batter = new Batter();

		while (restart) {
			System.out.println(batter);
			Pitcher pitcher = new Pitcher();
			Refree refree = new Refree(batter, pitcher);
			BaseballField baseballField = new BaseballField(refree);

			boolean isEnd = baseballField.start();        // 3스트라이크 결과
			restart = baseballField.theEndOrRestart(isEnd);    // 사용자 재시작/종료 결정
			batter = stadium.isRestart(isEnd, restart, batter);
		}
	}

	private Batter isRestart(boolean isEnd, boolean restart, Batter batter) {
		if (!isEnd || !restart) {
			return batter;
		}
		return new Batter();
	}
}
