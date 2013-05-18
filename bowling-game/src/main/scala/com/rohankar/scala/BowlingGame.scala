package com.rohankar.scala

/**
 *
 * @author Sagar Rohankar
 */
class BowlingGame {

  def score: Int = {
    var score = 0
    var i = 0;

    for (frame <- 0 until 10) {
      if (rolles(i) == 10) { // strike
        score += 10 + rolles(i + 1) + rolles(i + 2)
        i += 1
      } else if (rolles(i) + rolles(i + 1) == 10) { // spare
        score += 10 + rolles(i + 2)
        i += 2
      } else {
        score += rolles(i) + rolles(i + 1)
        i += 2
      }
    }
    score
  }

  val rolles: Array[Int] = new Array(21);
  var currentRole: Int = 0

  def roll(pins: Int) {
    rolles(currentRole) = pins
    currentRole += 1
  }

}
