package com.thoughtworks.guessnumber

import spock.lang.Specification

class GuessNumberTest extends Specification {
  def guessNumber = new GuessNumber()

  def 'it can return all wrong'() {
    given:
      def inputList = [5, 6, 7, 8]
      def answerList = [1, 2, 3, 4]

    when:
      def result = guessNumber.guess(inputList, answerList)

    then:
      result == "0A0B"
  }

  def 'it can return 1 correct input '() {
    given:
      def inputList = [1, 5, 6, 7]
      def answerList = [1, 2, 3, 4]

    when:
      def result = guessNumber.guess(inputList, answerList)

    then:
      result == "1A0B"
  }
}
