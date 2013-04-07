package com.rohankar.game.v2

object GameOfLife extends Rule {

  import Universe._

  def createUniverse(width: Int, height: Int, alivePositions: Set[Position]) = {
    val grid = for (col <- 0 until width) yield {
      for (row <- 0 until height) yield {
        alivePositions contains (col, row)
      }
    }

    new Universe(width, height, grid)
  }

  def tick(universe: Universe): Universe = {
    val alivePositions = for {
      w <- 0 until universe.width
      h <- 0 until universe.height
      p = (w, h)
      if (isAlive(at(p, universe), lifeAdjacentCount(p, universe)))
    } yield p

    createUniverse(universe.width, universe.height, alivePositions.toSet)
  }

}