package com.rohankar.scala

trait InputParser {

  def parse(input: String): Array[Array[Char]] = {
    val inputs = input.lines
    val dim = inputs.next.split(" ")

    val arr = Array.ofDim[Char](dim(0).trim.toInt, dim(1).trim.toInt)
    var i = 0;
    while (inputs.hasNext) {
      var ls = inputs.next.toCharArray.toList
      arr.update(i, ls.map(c => if (c != '*') '0' else c).toArray)
      i += 1
    }
    arr
  }

}