package com.rohankar.game

class GameOfLife(seed: List[List[Cell]]) {

  private val row = seed.length
  private val col = seed.head.length

  {
    def add(i: Int, j: Int) = {
      if (i - 1 >= 0 && j - 1 >= 0) {
        seed(i)(j).addNeighbours(seed(i - 1)(j - 1));
      }
      if (i + 1 < row && j + 1 < col) {
        seed(i)(j).addNeighbours(seed(i + 1)(j + 1));
      }
      if (i - 1 >= 0 && j + 1 < col) {
        seed(i)(j).addNeighbours(seed(i - 1)(j + 1));
      }
      if (i + 1 < row && j - 1 >= 0) {
        seed(i)(j).addNeighbours(seed(i + 1)(j - 1));
      }
      if (i - 1 >= 0) {
        seed(i)(j).addNeighbours(seed(i - 1)(j));
      }
      if (j - 1 >= 0) {
        seed(i)(j).addNeighbours(seed(i)(j - 1));
      }
      if (i + 1 < row) {
        seed(i)(j).addNeighbours(seed(i + 1)(j));
      }
      if (j + 1 < col) {
        seed(i)(j).addNeighbours(seed(i)(j + 1));
      }
    }
    for {
      i <- (0 to seed.length - 1); j <- (0 to seed.head.length - 1)
    } yield add(i, j)
  }

  def tick(): List[List[Cell]] = {
    var seedCopy = List[List[Cell]]()
    var t: List[Cell] = Nil
    for (x <- seed) yield {
      t = List[Cell]()
      for (y <- x) yield {
        t = y.nextState :: t
      }
      seedCopy ::= t
    }
    seedCopy
  }
}