package com.rohankar.scala

object StringCalculator {

  def add(value: String): Int = {
    if (value == "")
      0
    else {
      val numbers: Array[Int] = value.split(",").map(_.trim.toInt)
      val negNumbers: Array[Int] = numbers.filter(_ < 0)
      if (!negNumbers.isEmpty)
        throw new IllegalArgumentException("negatives not allowed - " + negNumbers.mkString)
      numbers.sum
    }
  }
}