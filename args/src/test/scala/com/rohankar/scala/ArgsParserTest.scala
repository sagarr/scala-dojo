package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import java.lang.Boolean

class ArgsParserTest extends FunSuite with ShouldMatchers {

  test("parse single argument w/o argument") {
    // when
    val values: Array[ArgsValue[_]] = new ArgsParser("l boolean").parse("-l")

    // then
    values(0) should be(ArgsValue(Boolean.TRUE.getClass, false))
  }

  test("parse single argument w/ argument") {
    // when
    val values: Array[ArgsValue[_]] = new ArgsParser("p integer").parse("-p 8080")

    // then
    values(0) should be(ArgsValue(Integer.valueOf(1).getClass, 8080))
  }
}