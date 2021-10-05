package baseball.service;

public enum ScoreStatus {

	STRIKE("스트라이크"),
	BALL("볼"),
	BASE_ON_BALLS("낫싱");

	private String umpire;

	ScoreStatus(String umpire) {
		this.umpire = umpire;
	}

	public String getUmpire() {
		return umpire;
	}

}
