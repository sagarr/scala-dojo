package com.rohankar.game.v2

trait Rule {

  def isAlive(currentlyLive: Boolean, adjacentLifeCount: Int) = {
    if ((adjacentLifeCount == 2 || adjacentLifeCount == 3) && currentlyLive) true
    else if (adjacentLifeCount == 3 && !currentlyLive) true
    else false
  }

}