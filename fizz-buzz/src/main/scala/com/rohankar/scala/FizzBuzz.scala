package com.rohankar.scala

object FizzBuzz {

  def shout(n: Int): String = {
    if (n % 3 == 0 || n.toString.contains("3")) "fizz" else if (n % 5 == 0) "buzz" else n.toString
  }
}