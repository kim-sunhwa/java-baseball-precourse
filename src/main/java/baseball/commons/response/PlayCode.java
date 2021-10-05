package baseball.commons.response;

public interface PlayCode {
	// 게임 규정
	final Integer MIN = 1;
	final Integer MAX = 9;
	final Integer MIN_ASC = 49;
	final Integer MAX_ASC = 57;
	final Integer LENGTH = 3;
	final Integer START_IDX = 1;

	// 게임 진행
	final String PLAY_START = "숫자를 입력해 주세요 : ";
	final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	final String RESTART = "게임을 시작하려면 1, 종료하려면 2를 입력하세요.";
	final String PLAY_END = "종료합니다.";
}
