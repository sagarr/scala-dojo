package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WordWrapTest extends FunSuite with ShouldMatchers {

  test("wrap empty string") {
    WordWrap.wrap("", 4) should be("")
  }

  test("wrap when column size greater than word length") {
    WordWrap.wrap("foo bar", 50) should be("foo bar")
  }

  test("wrap words for space at column index") {
    WordWrap.wrap("foo bar tarr", 3) should be("foo\nbar\ntarr")
  }

  test("wrap words for 1st space") {
    WordWrap.wrap("foo bar", 6) should be("foo\nbar")
  }

  test("wrap words for 2nd space") {
    WordWrap.wrap("this is space", 10) should be("this is\nspace")
  }
}