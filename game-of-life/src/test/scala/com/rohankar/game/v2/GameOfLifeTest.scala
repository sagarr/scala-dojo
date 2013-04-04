package com.rohankar.game.v2

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameOfLifeTest extends FunSuite with ShouldMatchers {

  test("a empty set of alive positions should define universe with all false positions") {
    GameOfLife.createUniverse(5, 5, Set()) should be(Universe(5, 5, IndexedSeq(
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, false, false, false))))
  }

  test("a set with alive positions as (2, 2) should define universe with single true position at (2, 2)") {
    GameOfLife.createUniverse(5, 5, Set((2, 2))) should be(Universe(5, 5, IndexedSeq(
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, true, false, false),
      IndexedSeq(false, false, false, false, false),
      IndexedSeq(false, false, false, false, false))))
  }
}