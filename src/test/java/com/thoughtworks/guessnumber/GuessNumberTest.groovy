package com.thoughtworks.guessnumber

import spock.lang.Specification

class GuessNumberTest extends Specification {
  GuessNumber guessNumber
  GameStatus gameStatus = Mock()

  def setup() {
    guessNumber = new GuessNumber(gameStatus)
  }

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

  def 'it can return wrong Input, input again when input length is not 4'() {
    given:
      def inputList = [1, 1, 6, 7, 8]
      def answerList = [1, 2, 3, 4]

    when:
      def result = guessNumber.guess(inputList, answerList)

    then:
      result == "Wrong Input, input again"
  }

  def 'it can return wrong Input, input again when input has repeat number '() {
    given:
      def inputList = [1, 1, 7, 8]
      def answerList = [1, 2, 3, 4]

    when:
      def result = guessNumber.guess(inputList, answerList)

    then:
      result == "Wrong Input, input again"
  }

}

