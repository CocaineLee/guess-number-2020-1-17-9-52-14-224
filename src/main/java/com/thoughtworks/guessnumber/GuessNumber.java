package com.thoughtworks.guessnumber;

import java.util.List;

public class GuessNumber {

  public String guess(List<Integer> input, List<Integer> answer) {
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
