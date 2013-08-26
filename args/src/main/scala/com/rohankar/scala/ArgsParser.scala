package com.rohankar.scala

import java.lang.Boolean

class ArgsParser(schema: String) {

  val schemaEntities: Map[String, AnyRef] = SchemaParser.parse(schema)

  def parse(args: String): Array[ArgsValue[_]] = {
    (for (
      arg <- args.split("-w*").filter(!_.isEmpty);
      val flagAndValue: Array[String] = arg.split(" ");
      val ref: AnyRef = schemaEntities(flagAndValue(0));
      val value: Any = if (flagAndValue.length > 1 && flagAndValue(1) != null && !flagAndValue(1).isEmpty()) convertToValue(ref.getClass, flagAndValue(1)) else ref
    ) yield (
      ArgsValue(ref.getClass, value)))
  }

  private def convertToValue(ref: Class[_], value: AnyRef): Any = {
    println(ref.getName)
    ref.getName match {
      case "java.lang.Boolean" => Boolean.parseBoolean(value.toString)
      case "java.lang.Integer" => Integer.parseInt(value.toString)
    }
  }
}