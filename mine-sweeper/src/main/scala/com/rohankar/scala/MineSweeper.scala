package com.rohankar.scala

trait MineSweeper {

  def createFieldsAndMines(array: Array[Array[Char]]): Array[Array[Char]] = {

    val temp: Array[Array[Char]] = array

    for (i <- 0 until array.length; j <- array(i).indices) {
      if (array(i)(j) == '*') {
        for {
          r <- i - 1 to i + 1
          c <- j - 1 to j + 1
          if (r >= 0 && c >= 0 && r < array.length && c < array.length)
        } {
          temp(r)(c) = nextValue(array(r)(c))
        }
      }
    }
    temp

  }

  private def nextValue(c: Char): Char = {
    if (c == '*') c else (c.toInt + 1).toChar
  }
}