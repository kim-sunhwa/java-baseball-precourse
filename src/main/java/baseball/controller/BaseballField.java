package baseball.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import baseball.commons.exceptions.BaseException;
import baseball.commons.response.ErrorCode;
import baseball.commons.response.Message;
import baseball.commons.response.PlayCode;
import baseball.service.Refree;
import baseball.service.ScoreBoard;
import nextstep.utils.Console;

public class BaseballField {

	private final Set<String> isEndOrRestartSet = restartOrEnd();
	private final Refree refree;

	public BaseballField(Refree refree) {
		this.refree = refree;
	}

	public boolean play() {
		readyToPlayer();
		ScoreBoard scoreBoard = this.refree.play();
		Message.print(scoreBoard.umpire());
		return scoreBoard.isThreeStrike();
	}

	private void readyToPlayer() {
		try {
			Message.go();
			String playerNumber = Console.readLine();
			this.refree.isValidPlayerStrategy(playerNumber);
		} catch (BaseException exception) {
			Message.print(exception.getMessage());
			readyToPlayer();
		}
	}

	public boolean theEndOrRestart(boolean isEnd) {
		boolean isRestart = true;
		if (isEnd) {
			Message.success();
			isRestart = getResultOfUser();
			restart(isRestart);
		}
		return isRestart;
	}

	private void restart(boolean isRestart) {
		if (!isRestart) {
			Message.theEnd();
		}
	}

	private boolean getResultOfUser() {
		Message.checkRestart();
		String resultOfUser = Console.readLine();
		isValid(resultOfUser);
		return resultOfUser.equals(PlayCode.SELECTED_RESTART);
	}

	private void isValid(String resultOfUser) {
		if (!isEndOrRestartSet.contains(resultOfUser)) {
			Message.print(ErrorCode.INVALID_END_OR_RESTART.getErrorMessage());
			getResultOfUser();
		}
	}

	private Set<String> restartOrEnd() {
		return Collections.unmodifiableSet(
			new HashSet<String>(Arrays.asList(PlayCode.SELECTED_RESTART, PlayCode.SELECTED_END)));
	}
}
