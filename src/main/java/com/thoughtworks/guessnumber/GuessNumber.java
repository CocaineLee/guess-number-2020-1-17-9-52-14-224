package com.thoughtworks.guessnumber;

import java.util.List;

public class GuessNumber {

  public Result guess(List<Integer> input, List<Integer> answer) {
    if (answer.retainAll(input)) {
      return Result.builder()
          .outPut("Wrong Input, input again")
          .instruction("Wrong Input, input again").build();
    }
      return null;
  }
}
