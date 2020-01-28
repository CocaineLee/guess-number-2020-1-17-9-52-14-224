package com.thoughtworks.guessnumber;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GuessNumber {

  public static final int ANSWER_LENGTH = 4;
  private final GameStatus gameStatus;

  public String guess(List<Integer> input, List<Integer> answer) {
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

  private String validate(List<Integer> input) {
    //length
    if (input.size() != ANSWER_LENGTH) {
      return "Wrong Input, input again";
    }
    if (input.stream().distinct().collect(Collectors.toList()).size() < ANSWER_LENGTH) {
      return "Wrong Input, input again";
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
