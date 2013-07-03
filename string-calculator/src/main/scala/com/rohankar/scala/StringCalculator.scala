package com.rohankar.scala

object StringCalculator {

  def add(string: String): Int = {
    if (string == null || string.isEmpty) return 0

    var tempString = string
    var delimiter = ","

    if (string startsWith "//") {
      delimiter = string.charAt(2).toString
      tempString = string.substring(3, string.length)
    }

    if (tempString contains ("\n")) {
      val nos = tempString.split("\n")
      (for (s <- nos) yield {
        if (s contains (delimiter)) {
          calculateSumForDelimiterSeparatedString(s, delimiter)
        } else {
          s.trim.toInt
        }
      }).sum
    } else {
      calculateSumForDelimiterSeparatedString(tempString, delimiter)
    }
  }

  private def calculateSumForDelimiterSeparatedString(string: String, delimiter: String = ","): Int = {
    val numbers: Array[Int] = string.split(delimiter).map(_.trim.toInt)
    val negNumbers: Array[Int] = numbers.filter(_ < 0)
    if (!negNumbers.isEmpty)
      throw new IllegalArgumentException("negatives not allowed - " + negNumbers.mkString)
    numbers.sum
  }
}