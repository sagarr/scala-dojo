package com.rohankar.game.v2

object GameOfLife {

  import Universe._

  def createUniverse(width: Int, height: Int, alivePositions: Set[Position]) = {
    val grid = for (col <- 0 until width) yield {
      for (row <- 0 until height) yield {
        alivePositions contains (col, row)
      }
    }

    new Universe(width, height, grid)
  }
}