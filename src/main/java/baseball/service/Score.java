package baseball.service;

public class Score {

	private ScoreStatus status;
	private int record;

	private Score() {
	}

	public static Score of(ScoreStatus scoreStatus) {
		Score score = new Score();
		score.status = scoreStatus;
		score.record = 0;
		return score;
	}

	public void add() {
		this.record += 1;
	}

	public int readRecord() {
		return this.record;
	}

	public boolean isZero() {
		return this.record == 0;
	}

	@Override
	public String toString() {
		return "Score{" +
			"status=" + status +
			", record=" + record +
			'}';
	}
}
