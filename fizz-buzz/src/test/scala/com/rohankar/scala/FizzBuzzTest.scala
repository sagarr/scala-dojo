package com.rohankar.scala

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

class FizzBuzzTest extends FunSuite with ShouldMatchers {

  test("shout fizz for multiple of 3") {
    FizzBuzz.shout(6) should be("fizz")
  }

  test("shout buzz for multiple of 5") {
    FizzBuzz.shout(10) should be("buzz")
  }

  test("shout number itself for if number neither multiple of 3 nor 5") {
    FizzBuzz.shout(7) should be("7")
  }

  test("shout fizz for 	number has 3 in it") {
    FizzBuzz.shout(13) should be("fizz")
  }

  test("shout buzz if number has 5 in it") {
    FizzBuzz.shout(52) should be("buzz")
  }
}