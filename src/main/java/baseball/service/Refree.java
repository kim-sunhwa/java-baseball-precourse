package baseball.service;

import java.util.Map;

import baseball.model.Batter;
import baseball.model.Pitcher;
import baseball.model.PlayNumber;

public class Refree {

	private final Batter batter;
	private final Pitcher pitcher;

	public Refree(Batter batter, Pitcher pitcher) {
		this.batter = batter;
		this.pitcher = pitcher;
	}

	public ScoreBoard play() {
		Map<Integer, Integer> pitching = pitcher.play();
		ScoreBoard scoreBoard = new ScoreBoard();
		for (Integer number : pitching.keySet()) {
			boolean strike = this.batter.isStrike(number, pitching.get(number));
			boolean ball = this.batter.isBall(number, pitching.get(number));

			scoreBoard.record(strike, ball);
		}
		return scoreBoard;
	}

	public void isValidPlayerStrategy(String playerNumber) {
		PlayNumber.isValid(playerNumber);
		this.pitcher.strategy(playerNumber);
	}
}
