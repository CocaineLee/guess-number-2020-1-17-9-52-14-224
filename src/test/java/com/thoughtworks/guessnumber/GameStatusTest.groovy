package com.thoughtworks.guessnumber

import spock.lang.Specification

class GameStatusTest extends Specification {
  def gameStatus = new GameStatus()

  def 'it can add one record'() {
    given:
      List<Integer> input1 = [9, 2, 3, 4, 5]
      String result1 = "3A0B"

    when:
      gameStatus.addRecord(input1, result1)
      String records = gameStatus.showRecords()
    then:
      records == "GuessNumber game records are:\n" +
          "times: 1 input: 9 2 3 4 5 outPut: 3A0B\n"
      gameStatus.getIsWin() == false
  }

  def 'it can add two record and record win'() {
    given:
      List<String> input1 = [9, 2, 3, 4, 5]
      String result1 = "3A0B"

      List<String> input2 = [1, 2, 3, 4, 5]
      String result2 = "4A0B"

    when:
      gameStatus.addRecord(input1, result1)
      gameStatus.addRecord(input2, result2)
      String records = gameStatus.showRecords()
    then:
      records == "GuessNumber game records are:\n" +
          "times: 1 input: 9 2 3 4 5 outPut: 3A0B\n" +
          "times: 2 input: 1 2 3 4 5 outPut: 4A0B\n"
      gameStatus.getIsWin() == true
  }

}
