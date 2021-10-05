package baseball.service;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {

	private Map<ScoreStatus, Score> scores;

	public ScoreBoard() {
		this.scores = new HashMap<>();
		this.scores.put(ScoreStatus.STRIKE, Score.of(ScoreStatus.STRIKE));
		this.scores.put(ScoreStatus.BALL, Score.of(ScoreStatus.BALL));
	}

	public void record(boolean isStrike, boolean isBall) {
		if (isStrike) {
			Score score = this.scores.get(ScoreStatus.STRIKE);
			score.add();
		}
		if (isBall) {
			Score score = this.scores.get(ScoreStatus.BALL);
			score.add();
		}
	}

	public boolean threeStrike() {
		return this.scores.get(ScoreStatus.STRIKE).readRecord() == 3;
	}

	@Override
	public String toString() {
		return "ScoreBoard{" +
			"scores=" + scores +
			'}';
	}

}
