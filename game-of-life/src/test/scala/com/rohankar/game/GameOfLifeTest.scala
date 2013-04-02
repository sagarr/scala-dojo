package com.rohankar.game

import org.scalatest.FunSuite
import org.scalatest.Assertions
import org.junit.Test

class GameOfLifeTest extends Assertions {

  @Test def test_BlockPattern_StiilLife {
    // given
    val seed = List(List(Cell(1), Cell(1)), List(Cell(1), Cell(1)))

    val gol = new GameOfLife(seed)

    expect(List(List(Cell(1), Cell(1)), List(Cell(1), Cell(1)))) {
      gol.tick
    }
  }

  def test_BlinkerPattern_Oscillator {
    // given
    val seed = List(List(Cell(0), Cell(0), Cell(0)), List(Cell(1), Cell(1), Cell(1)), List(Cell(0), Cell(0), Cell(0)))

    val gol = new GameOfLife(seed)

    expect(List(List(Cell(0), Cell(1), Cell(0)), List(Cell(0), Cell(1), Cell(0)), List(Cell(0), Cell(1), Cell(0)))) {
      gol.tick
    }
  }
}