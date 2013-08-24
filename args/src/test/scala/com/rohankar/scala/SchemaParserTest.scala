package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SchemaParserTest extends FunSuite with ShouldMatchers {

  test("parse single schema") {
    // given
    val schemas: List[SchemaEntity] = SchemaParser.parse("l boolean")

    // when
    schemas(0) should be(SchemaEntity("l", true.getClass))
  }

  test("parse 2 schema") {
    // given
    val schemas: List[SchemaEntity] = SchemaParser.parse("l boolean; d integer")

    // when
    schemas(0) should be(SchemaEntity("l", true.getClass))
    schemas(1) should be(SchemaEntity("d", 10.getClass))
  }

}