package baseball.service;

import java.util.Map;

import baseball.model.Batter;
import baseball.model.Pitcher;

public class Refree {

	private final Batter batter;
	private final Pitcher pitcher;

	public Refree(Batter batter, Pitcher pitcher) {
		this.batter = batter;
		this.pitcher = pitcher;
	}

	public void play() {
		Map<Integer, Integer> pitching = pitcher.play();
		for (Integer number : pitching.keySet()) {
			boolean strike = this.batter.isStrike(number, pitching.get(number));
			boolean ball = this.batter.isBall(number, pitching.get(number));
			System.out.println("스트라이크 : " + strike);
			System.out.println("볼 : " + ball);
		}
	}
}
