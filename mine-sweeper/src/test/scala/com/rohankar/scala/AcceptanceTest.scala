package com.rohankar.scala

import org.specs2.Specification
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class AcceptanceTest extends FunSuite with ShouldMatchers {

  test("acceptance test") {
    // given
    val input = "4 4" +
      "\n*..." +
      "\n...." +
      "\n.*.." +
      "\n...."

    // when
    val array: Array[Array[Char]] = MineSweeperGame.createGame(input)

    // then
    array(0) should be(Array('*', '1', '0', '0'))
    array(1) should be(Array('2', '2', '1', '0'))
    array(2) should be(Array('1', '*', '1', '0'))
    array(3) should be(Array('1', '1', '1', '0'))
  }
}