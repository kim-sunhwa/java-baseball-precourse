package baseball.service;

import baseball.model.Batter;
import baseball.model.Pitcher;

public class Refree {

	private final Batter batter;
	private final Pitcher pitcher;

	public Refree(Batter batter, Pitcher pitcher) {
		this.batter = batter;
		this.pitcher = pitcher;
	}

}
