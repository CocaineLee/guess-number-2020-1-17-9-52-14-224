package com.thoughtworks.guessnumber;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Result {
  private String outPut;
  private String instruction;
}
