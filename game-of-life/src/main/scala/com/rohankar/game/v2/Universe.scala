package com.rohankar.game.v2

object Universe {
  type Position = (Int, Int)

  def column(p: Position) = p._1
  def row(p: Position) = p._2

  type Row = IndexedSeq[Boolean]
  type Columns = IndexedSeq[Row]
}

import Universe._

case class Universe(width: Int, height: Int, columns: Columns)