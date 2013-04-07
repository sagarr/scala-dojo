package com.rohankar.game.v2

object Universe {
  type Position = (Int, Int)

  def column(p: Position) = p._1
  def row(p: Position) = p._2

  type Row = IndexedSeq[Boolean]
  type Columns = IndexedSeq[Row]

  def at(p: Position, u: Universe) = u.columns(column(p)).apply(row(p))

  def lifeAdjacentCount(p: Position, u: Universe): Int = {
    def wrap(c: Int, max: Int) = if (c < 0) max - 1 else if (c >= max) 0 else c

    val livePositions = (for {
      c <- (p._1 - 1) to (p._1 + 1)
      column = wrap(c, u.width)
      r <- (p._2 - 1) to (p._2 + 1)
      row = wrap(r, u.height)
      position = (column, row) if (position != p && at(position, u))
    } yield position) toSet

    livePositions size
  }
}

import Universe._

case class Universe(width: Int, height: Int, columns: Columns)