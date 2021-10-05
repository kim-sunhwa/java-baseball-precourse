package baseball.commons.response;

public class Message {

	public static void go() {
		System.out.println(PlayCode.PLAY_START);
	}

	public static void success() {
		System.out.println(PlayCode.SUCCESS);
	}

	public static void checkRestart() {
		System.out.println(PlayCode.RESTART);
	}

	public static void theEnd() {
		System.out.println(PlayCode.PLAY_END);
	}

	public static void print(String text) {
		System.out.println(text);
	}

}
