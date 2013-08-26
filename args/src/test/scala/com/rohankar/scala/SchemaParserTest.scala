package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SchemaParserTest extends FunSuite with ShouldMatchers {

  test("parse single schema") {
    // given
    val schemas: Map[String, AnyRef] = SchemaParser.parse("l boolean")

    // when
    schemas("l") should be(Boolean.box(false))
  }

  test("parse 2 schema") {
    // given
    val schemas: Map[String, AnyRef] = SchemaParser.parse("l boolean; d integer")

    // when
    schemas("l") should be(Boolean.box(false))
    schemas("d") should be(new Integer(0))
  }

}