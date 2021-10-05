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
			Score score = getStrikeScore();
			score.add();
		}
		if (isBall) {
			Score score = getBallScore();
			score.add();
		}
	}

	public boolean isThreeStrike() {
		return getStrikeScore().readRecord() == 3;
	}

	public String umpire() {
		StringBuilder sb = new StringBuilder();
		Score scoreInStrike = getStrikeScore();
		Score scoreInBall = getBallScore();
		if (scoreInStrike.isZero() && scoreInBall.isZero()) {
			return ScoreStatus.BASE_ON_BALLS.getUmpire();
		}

		if (!scoreInStrike.isZero()) {
			sb.append(scoreInStrike.readRecord()).append(ScoreStatus.STRIKE.getUmpire()).append(" ");
		}
		if ((!scoreInBall.isZero())) {
			sb.append(scoreInBall.readRecord()).append(ScoreStatus.BALL.getUmpire());
		}
		return sb.toString();
	}

	private Score getBallScore() {
		return this.scores.get(ScoreStatus.BALL);
	}

	private Score getStrikeScore() {
		return this.scores.get(ScoreStatus.STRIKE);
	}

	@Override
	public String toString() {
		return "ScoreBoard{" +
			"scores=" + scores +
			'}';
	}

}
