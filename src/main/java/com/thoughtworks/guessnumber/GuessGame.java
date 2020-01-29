package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class GuessGame {

  private GuessNumber guessNumber;

  public GuessGame(GuessNumber guessNumber) {
    this.guessNumber = guessNumber;
  }

  public List<GameInfo> simulateGame() {
    List<GameInfo> gameInfos = new ArrayList<>();
    while (!guessNumber.isWin() && !guessNumber.isLose()) {
      List<Integer> input = NumbersGenerator.generate();
      String result = playGame(input);
      String records = guessNumber.getGameStatus().showRecords();
      gameInfos.add(new GameInfo(result, records));
    }
    return gameInfos;
  }

  private String playGame(List<Integer> input) {
    if (guessNumber.isLose()) {
      return "You lose";
    }
    if (guessNumber.isWin()) {
      return "You win";
    }
    return guessNumber.guess(input);
  }

  @AllArgsConstructor
  @Getter
  public class GameInfo {
    private String result;
    private String record;
  }
}
