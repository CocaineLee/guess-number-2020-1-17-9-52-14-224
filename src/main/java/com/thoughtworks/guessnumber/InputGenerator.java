package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InputGenerator {

  public List<Integer> generateInput() {
    Random random = new Random();
    List<Integer> input = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      input.add(random.nextInt(9));
    }
    return input;
  }
}
