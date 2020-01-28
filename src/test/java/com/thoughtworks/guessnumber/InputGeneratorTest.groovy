package com.thoughtworks.guessnumber

import spock.lang.Specification

class InputGeneratorTest extends Specification {

  def generator = new InputGenerator()

  def 'it can generate 4 number within 9'() {
    when:
      def input = generator.generateInput()
    then:
      input.size() == 4
      for (int i = 0; i < 4; i ++) {
        input.get(i) >= 0
        input.get(i) <= 9
      }
  }
}
