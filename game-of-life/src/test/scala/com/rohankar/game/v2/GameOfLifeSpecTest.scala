package com.rohankar.game.v2

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

class GameOfLifeSpecTest extends FunSpec with ShouldMatchers {

  describe("A Game of Life") {

    it("should exhibit block pattern") {
      val initialUniverse = GameOfLife.createUniverse(2, 2, Set((0, 0), (0, 1), (1, 0), (1, 1)))
      initialUniverse should be(Universe(2, 2, IndexedSeq(
        IndexedSeq(true, true),
        IndexedSeq(true, true))))

      (GameOfLife tick initialUniverse) should be((Universe(2, 2, IndexedSeq(
        IndexedSeq(true, true),
        IndexedSeq(true, true)))))
    }

    it("should exhibit boat pattern") {
      val initialUniverse = GameOfLife.createUniverse(3, 3, Set((0, 1), (1, 0), (2, 1), (0, 2), (1, 2)))
      initialUniverse should be(Universe(3, 3, IndexedSeq(
        IndexedSeq(false, true, true),
        IndexedSeq(true, false, true),
        IndexedSeq(false, true, false))))

      (GameOfLife tick initialUniverse) should be((Universe(3, 3, IndexedSeq(
        IndexedSeq(true, false, true),
        IndexedSeq(true, false, true),
        IndexedSeq(false, true, false)))))
    }
  }
}