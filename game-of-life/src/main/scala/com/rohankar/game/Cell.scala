package com.rohankar.game

case class Cell(val state: Int) {

  private var neighbours: List[Cell] = List[Cell]()

  //
  // public methods
  //
  def addNeighbours(cs: Cell*) = neighbours :::= cs.toList

  def nextState: Cell = if (shouldBeAliveInNextTick) Cell(1) else Cell(0)

  //
  // private methods
  //
  private def liveCellCount: Int = {
    neighbours filter (c => c.state == 1) length
  }

  private def shouldBeAliveInNextTick = {
    (liveCellCount == 3 && state == 0) || ((liveCellCount == 2 || liveCellCount == 3) && state == 1)
  }
}