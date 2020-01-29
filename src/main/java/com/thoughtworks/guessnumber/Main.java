package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.GuessGame.GameInfo;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    GameStatus gameStatus = new GameStatus();
    GuessNumber guessNumber = new GuessNumber(gameStatus);
    GuessGame guessGame = new GuessGame(guessNumber);
    List<GameInfo> gameInfos = guessGame.simulateGame();
    gameInfos.stream().forEach(it -> {
      System.out.println(it.getRecord());
      System.out.println(it.getResult());
    });
  }

}
