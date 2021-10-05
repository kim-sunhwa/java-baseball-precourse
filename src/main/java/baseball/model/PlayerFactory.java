package baseball.model;

public class PlayerFactory {

	public static Pitcher standOnPitcher() {
		Pitcher pitcher = new Pitcher();
		return pitcher;
	}

	public static Batter standOnBatter() {
		Batter batter = new Batter();
		batter.strategy();
		return batter;
	}
}
