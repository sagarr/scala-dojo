package com.rohankar.scala

object SchemaParser {

  def parse(schema: String): Map[String, AnyRef] = {
    (for (s <- schema.split(";").toList; val dataType = s.substring(2))
      yield (s.trim.charAt(0).toString -> createValue(dataType))) toMap
  }

  private def createValue(dt: String): AnyRef = {
    dt.trim match {
      case "boolean" => Boolean.box(false) // default false
      case "integer" => new Integer(0) // default 0
      case _ => throw new Error("data type not supported")
    }
  }

}