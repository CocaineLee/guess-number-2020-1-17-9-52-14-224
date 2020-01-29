package com.thoughtworks.guessnumber;

import java.util.List;
import lombok.Getter;

@Getter
public class GuessNumber {

  public static final int ANSWER_LENGTH = 4;
  public static final String WRONG_INPUT_MESSAGE = "Wrong Input, input again";
  private final GameStatus gameStatus;
  private List<Integer> answer;

  public GuessNumber(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
    this.answer = NumbersGenerator.generate();
  }

  public String guess(List<Integer> input) {
    //validate
    String outPut = validate(input);
    if (outPut == null) {
      //judge
      outPut = judge(input, answer);

      //record
      gameStatus.addRecord(input, outPut);
    }
    return outPut;
  }

  public boolean isLose() {
    return gameStatus.getGameRecordList().size() >= 6 && !gameStatus.getIsWin();
  }

  public boolean isWin() {
    return gameStatus.getIsWin();
  }

  private String validate(List<Integer> input) {
    //length
    if (input.size() != ANSWER_LENGTH) {
      return WRONG_INPUT_MESSAGE;
    }
    if (input.stream().distinct().count() < ANSWER_LENGTH) {
      return WRONG_INPUT_MESSAGE;
    }
    return null;
  }

  private String judge(List<Integer> input, List<Integer> answer) {
    int positionRight = 0;
    int valueRight = 0;
    for (int i = 0; i < input.size(); i++) {
      for (int j = 0; j < answer.size(); j++) {
        if (input.get(i).equals(answer.get(j))) {
          if (i == j) {
            positionRight++;
          } else {
            valueRight++;
          }
        }
      }
    }
    return getOutPut(positionRight, valueRight);
  }

  private String getOutPut(int positionRight, int valueRight) {
    return positionRight + "A" + valueRight + "B";
  }
}
