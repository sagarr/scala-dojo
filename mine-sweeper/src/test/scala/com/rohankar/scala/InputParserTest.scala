package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class InputParserTest extends FunSuite with ShouldMatchers {

  test("create 4x4 2d array when input first line contain 4 4") {
    new {} with InputParser {
      // when
      val array: Array[Array[Char]] = parse("4 4")

      // then
      array.length should be(4)
    }
  }

  test("create 4x4 2d array when valid input passed") {
    new {} with InputParser {
      // given
      val input = "4 4" +
        "\n*..." +
        "\n...." +
        "\n.*.." +
        "\n...."

      // when
      val array: Array[Array[Char]] = parse(input)

      // then
      array.length should be(4)
      array(0) should be(Array('*', '0', '0', '0'))
    }
  }
}