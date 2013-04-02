package com.rohankar.game

import org.scalatest.Assertions
import org.junit.Test

class CellTest extends Assertions {

  @Test def testLiveCellShouldBecomeDeadWhenLiveNeighboursCountIsLessThan2 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1)) // only 1 live neighbor

    // when
    val isAlive = cell shouldBeAliveInNextTick

    // then
    assert(isAlive === false)
  }

  def testLiveCellShouldBecomeDeadWhenLiveNeighboursCountIsMoreThan3 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1), Cell(1), Cell(1), Cell(1))

    expect(false) {
      // when
      cell shouldBeAliveInNextTick
    }
  }

  def testLiveCellShouldRemainLiveWhenLiveNeighboursCountIsEqualTo2 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1), Cell(1))

    // when
    val isAlive = cell shouldBeAliveInNextTick

    // then
    assert(isAlive === true)
  }

  def testLiveCellShouldRemainLiveWhenLiveNeighboursCountIsEqualTo3 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1), Cell(1), Cell(1))

    // when
    val isAlive = cell shouldBeAliveInNextTick

    // then
    assert(isAlive === true)
  }

  def testDeadCellShouldBecomeLiveWhenLiveNeighboursCountIsEqualTo3 {
    // given
    val cell: Cell = Cell(0)
    cell addNeighbours (Cell(1), Cell(1), Cell(1))

    // when
    val isAlive = cell shouldBeAliveInNextTick

    // then
    assert(isAlive === true)
  }
}