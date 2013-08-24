package com.rohankar.scala

object SchemaParser {

  def parse(s: String): List[SchemaEntity] = {
    def getClass(v: String): Class[_] = {
      v.trim match {
        case "boolean" => true.getClass
        case "integer" => 1.getClass
      }
    }

    for (schema <- s.split(";").toList) yield SchemaEntity(schema.trim.charAt(0).toString, getClass(schema.substring(2)))
  }

}