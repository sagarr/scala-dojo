package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class StringCalculatorTest extends FunSuite with ShouldMatchers {

  test("add calculate 0 for empty string") {
    // when
    val sum = StringCalculator.add("")

    // then
    sum should be(0)
  }

  test("add calculate number itself when single number passed") {
    // when
    val sum = StringCalculator.add("1");

    // then
    sum should be(1)
  }

  test("add calculcate sum when two numbers passed") {
    // when
    val sum = StringCalculator.add("1, 2")

    // then
    sum should be(3)
  }

  test("negative numbers not allowed") {
    // when
    val exception = intercept[IllegalArgumentException] {
      StringCalculator.add("-1")
    }

    exception.getMessage should be("negatives not allowed - -1")
  }
}