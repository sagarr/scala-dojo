package com.rohankar.scala

object WordWrap {

  def wrap(word: String, col: Int): String = {
    var res = ""

    if (word.length < col) {
      word
    } else {
      if (word.charAt(col) == ' ') {
        res += word.substring(0, col) + "\n"
        val nextLine = word.substring(col + 1, word.length)
        if (nextLine.length > col) {
          res += wrap(nextLine, col) // rec
        } else {
          res += nextLine
        }
      } else {
        val lastIndexOfSpace = word.lastIndexWhere(_ == ' ')
        if (lastIndexOfSpace > 0) {
          res += word.updated(lastIndexOfSpace, '\n')
        } else {
          res += word
        }
      }
      res
    }
  }

}