package com.thoughtworks.guessnumber

import spock.lang.Specification

class GuessNumberTest extends Specification {
  GuessNumber guessNumber
  GameStatus gameStatus = Mock()
  NumbersGenerator numbersGenerator = Mock()

  def setup() {
    numbersGenerator.generate() >> [1, 2, 3, 4]
    guessNumber = new GuessNumber(gameStatus, numbersGenerator)
  }

  def 'it can return all wrong'() {
    given:
      def inputList = [5, 6, 7, 8]
    when:
      def result = guessNumber.guess(inputList)

    then:
      result == "0A0B"
  }

  def 'it can return 1 correct input '() {
    given:
      def inputList = [1, 5, 6, 7]

    when:
      def result = guessNumber.guess(inputList)

    then:
      result == "1A0B"
  }

  def 'it can return wrong Input, input again when input length is not 4'() {
    given:
      def inputList = [1, 1, 6, 7, 8]

    when:
      def result = guessNumber.guess(inputList)

    then:
      result == "Wrong Input, input again"
  }

  def 'it can return wrong Input, input again when input has repeat number '() {
    given:
      def inputList = [1, 1, 7, 8]

    when:
      def result = guessNumber.guess(inputList)

    then:
      result == "Wrong Input, input again"
  }

  def 'it can return 4A0B when input right '() {
    given:
      def inputList = [1, 2, 3, 4]

    when:
      def result = guessNumber.guess(inputList)
    then:
      result == "4A0B"
  }

}

