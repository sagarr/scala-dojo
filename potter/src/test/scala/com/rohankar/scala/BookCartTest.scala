package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class bcTest extends FunSuite with ShouldMatchers {

  test("1 book got no discount") {
    val bc = new BookCart
    bc.add(1, "first book")

    bc.total should be(8)
  }

  test("2 different books get 5% discount") {
    val bc = new BookCart
    bc.add(1, "first book")
    bc.add(1, "second book")

    bc.total should be(15.2)
  }

  test("3 different books get 10% discount") {
    val bc = new BookCart
    bc.add(1, "first book")
    bc.add(1, "second book")
    bc.add(1, "third book")

    bc.total should be(21.6)
  }

  test("5 different books get 25% discount") {
    val bc = new BookCart
    bc.add(1, "first book")
    bc.add(1, "second book")
    bc.add(1, "third book")
    bc.add(1, "fourth book")
    bc.add(1, "fifth book")

    bc.total should be(30)
  }

  test("acceptance test") {
    val bc = new BookCart
    bc.add(2, "first book")
    bc.add(2, "second book")
    bc.add(2, "third book")
    bc.add(1, "fourth book")
    bc.add(1, "fifth book")

    bc.total should be(51.20)
  }
}