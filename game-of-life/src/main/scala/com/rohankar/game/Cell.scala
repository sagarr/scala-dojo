package com.rohankar.game

case class Cell(val state: Int) {

  var neighbours: List[Cell] = List[Cell]()

  def addNeighbours(cs: Cell*) = neighbours :::= cs.toList

  private def liveCellCount: Int = {
    neighbours filter (c => c.state == 1) length
  }

  def shouldBeAliveInNextTick = (liveCellCount == 3 && state == 0) || ((liveCellCount == 2 || liveCellCount == 3) && state == 1)

  def nextState: Cell = if (shouldBeAliveInNextTick) Cell(1) else Cell(0)
}