package com.thoughtworks.guessnumber

import spock.lang.Specification

class GuessNumberTest extends Specification {
  def guessNumber = new GuessNumber()

  def 'it can return wrong input when guess wrong'() {
    given:
      def inputList = [5, 6, 7, 8]
      def answerList = [1, 2, 3, 4]

    when:
      def result = guessNumber.guess(inputList, answerList)

    then:
      result.outPut == "Wrong Input, input again"
      result.instruction == "Wrong Input, input again"
  }

}
