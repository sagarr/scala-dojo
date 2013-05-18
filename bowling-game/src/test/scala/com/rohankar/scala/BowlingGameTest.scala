package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BowlingGameTest extends FunSuite with ShouldMatchers {

  var game: BowlingGame = null;

  test("looser game") {
    // given
    game = new BowlingGame

    // when
    rollPins(20, 0)

    // then
    game.score should be(0)
  }

  test("game with each frame score is 1") {
    // given
    game = new BowlingGame

    // when
    rollPins(20, 1)

    // then
    game.score should be(20)
  }

  test("game with one spare") {
    // given
    game = new BowlingGame

    // when
    game.roll(8)
    game.roll(2)
    game.roll(3)
    rollPins(17, 0)

    // then
    game.score should be(16)
  }

  test("game with one strike") {
    // given
    game = new BowlingGame

    // when
    game.roll(10) // strike
    game.roll(3)
    game.roll(4)
    rollPins(16, 0)

    // then
    game.score should be(24)
  }

  test("game with all strike") {
    // given
    game = new BowlingGame

    // when
    rollPins(20, 10)

    // then
    game.score should be(300)
  }

  private def rollPins(times: Int, pins: Int) {
    for (i <- 0 to times) {
      game.roll(pins)
    }

  }
}