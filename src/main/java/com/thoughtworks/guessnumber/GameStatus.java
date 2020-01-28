package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameStatus {

  private List<GameRecord> gameRecordList = new ArrayList<>();
  private Boolean isWin = false;

  public void addRecord(List<Integer> input, String outPut) {
    if (outPut.startsWith("4")) {
      this.isWin = true;
    }
    int times = gameRecordList.size()+1;
    gameRecordList.add(new GameRecord(times, input, outPut));
  }

  public String showRecords() {
    String head = "GuessNumber game records are:\n";
    String body = "";
    for (GameRecord it : gameRecordList) {
      body += it.print();
    }
    return head + body;
  }

  private class GameRecord {

    private Integer times;
    private List<Integer> input;
    private String outPut;

    public GameRecord(Integer times, List<Integer> input, String outPut) {
      this.times = times;
      this.input = input;
      this.outPut = outPut;
    }

    public String print() {
      return "times: " + times + " input: " + inputToString() + "outPut: " + outPut + "\n";
    }

    private String inputToString() {
      String result = "";
      for (Integer integer : input) {
        result += integer + " ";
      }
      return result;
    }
  }
}


