package com.rohankar.game

import org.scalatest.Assertions
import org.junit.Test

class CellTest extends Assertions {

  @Test def testLiveCellShouldBecomeDeadWhenLiveNeighboursCountIsLessThan2 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1)) // only 1 live neighbor

    expect(Cell(0)) {
      // when
      cell nextState
    }
  }

  def testLiveCellShouldBecomeDeadWhenLiveNeighboursCountIsMoreThan3 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1), Cell(1), Cell(1), Cell(1))

    expect(Cell(0)) {
      // when
      cell nextState
    }
  }

  def testLiveCellShouldRemainLiveWhenLiveNeighboursCountIsEqualTo2 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1), Cell(1))

    expect(Cell(1)) {
      // when
      cell nextState
    }
  }

  def testLiveCellShouldRemainLiveWhenLiveNeighboursCountIsEqualTo3 {
    // given
    val cell: Cell = Cell(1)
    cell addNeighbours (Cell(1), Cell(1), Cell(1))

    expect(Cell(1)) {
      // when
      cell nextState
    }
  }

  def testDeadCellShouldBecomeLiveWhenLiveNeighboursCountIsEqualTo3 {
    // given
    val cell: Cell = Cell(0)
    cell addNeighbours (Cell(1), Cell(1), Cell(1))

    expect(Cell(1)) {
      // when
      cell nextState
    }
  }
}