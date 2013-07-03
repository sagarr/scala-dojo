package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class StringCalculatorTest extends FunSuite with ShouldMatchers {

  test("add calculate 0 for empty string") {
    StringCalculator.add("") should be(0)
  }

  test("add calculate number itself when single number passed") {
    StringCalculator.add("1") should be(1)
  }

  test("add calculcate sum when two numbers passed") {
    StringCalculator.add("1, 2") should be(3)
  }

  test("negative numbers not allowed") {
    val exception = intercept[IllegalArgumentException] {
      StringCalculator.add("-1")
    }

    exception.getMessage should be("negatives not allowed - -1")
  }

  test("new line character allowed for separating numbers") {
    StringCalculator.add("1\n2,3") should be(6)
  }

  test("custom delimiter") {
    StringCalculator.add("//;1;2") should be(3)
  }

}