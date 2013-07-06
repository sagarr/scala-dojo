package com.rohankar.scala

trait MineSweeper {

  def createFieldsAndMines(array: Array[Array[Char]]): Array[Array[Char]] = {
    for (i <- 0 until array.length) {
      for (j <- array(i).indices) {
        if (array(i)(j) == '*') {
          if (i + 1 < array.length) {
            array(i + 1)(j) = nextValue(array(i + 1)(j))
          }
          if (i - 1 >= 0) {
            array(i - 1)(j) = nextValue(array(i - 1)(j))
          }
          if (j + 1 < array(i).length) {
            array(i)(j + 1) = nextValue(array(i)(j + 1))
          }
          if (j - 1 >= 0) {
            array(i)(j - 1) = nextValue(array(i)(j - 1))
          }
          if (i + 1 < array.length && j + 1 < array(i).length) {
            array(i + 1)(j + 1) = nextValue(array(i + 1)(j + 1))
          }
          if (i + 1 < array.length && j - 1 >= 0) {
            array(i + 1)(j - 1) = nextValue(array(i + 1)(j - 1))
          }
          if (i - 1 >= 0 && j - 1 >= 0) {
            array(i - 1)(j - 1) = nextValue(array(i - 1)(j - 1))
          }
          if (i - 1 >= 0 && j + 1 < array(i).length) {
            array(i - 1)(j + 1) = nextValue(array(i - 1)(j + 1))
          }
        }
      }
    }
    array
  }

  private def nextValue(c: Char): Char = {
    if (c == '*') c else (c.toInt + 1).toChar
  }
}