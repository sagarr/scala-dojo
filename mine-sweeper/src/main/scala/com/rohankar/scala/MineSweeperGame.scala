package com.rohankar.scala

object MineSweeperGame extends MineSweeper with InputParser {

  def createGame(input: String): Array[Array[Char]] = {
    createFieldsAndMines(parse(input))
  }

}