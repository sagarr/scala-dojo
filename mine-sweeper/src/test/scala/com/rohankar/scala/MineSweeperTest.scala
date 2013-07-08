package com.rohankar.scala

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MineSweeperTest extends FunSuite with ShouldMatchers {

  test("no mine field for 1x1 array creates field with 0 value") {
    // given
    val array: Array[Array[Char]] = Array.ofDim[Char](1, 1)
    array(0)(0) = '0'

    new {} with MineSweeper {
      // when
      val result: Array[Array[Char]] = createFieldsAndMines(array)

      // then
      result(0)(0) should be('0')
    }

  }

  test("mine field at 0,0 for 2x2 array creates field with 1 mine and 3 one value field") {
    // given
    val array: Array[Array[Char]] = Array.ofDim[Char](2, 2)
    array(0)(0) = '*'
    array(0)(1) = '0'
    array(1)(0) = '0'
    array(1)(1) = '0'

    new {} with MineSweeper {
      // when
      val result: Array[Array[Char]] = createFieldsAndMines(array)

      // then
      result(0)(0) should be('*')
      result(0)(1) should be('1')
      result(1)(0) should be('1')
      result(1)(1) should be('1')
    }
  }

  test("mine field at 0,0 & 1,1 for 2x2 array creates field with 2 mine and 2 two value field") {
    // given
    val array: Array[Array[Char]] = Array.ofDim[Char](2, 2)
    array(0)(0) = '*'
    array(0)(1) = '0'
    array(1)(0) = '0'
    array(1)(1) = '*'

    new {} with MineSweeper {
      // when
      val result: Array[Array[Char]] = createFieldsAndMines(array)

      // then
      result(0)(0) should be('*')
      result(0)(1) should be('2')
      result(1)(0) should be('2')
      result(1)(1) should be('*')
    }
  }

  test("mine field at 1,1 for 3x3 array creates field with 1 mine and 8 one value field") {
    // given
    val array: Array[Array[Char]] = Array.ofDim[Char](3, 3)
    array(0)(0) = '0'
    array(0)(1) = '0'
    array(0)(2) = '0'
    array(1)(0) = '0'
    array(1)(1) = '*'
    array(1)(2) = '0'
    array(2)(0) = '0'
    array(2)(1) = '0'
    array(2)(2) = '0'

    new {} with MineSweeper {
      // when
      val result: Array[Array[Char]] = createFieldsAndMines(array)

      // then
      result(0)(0) should be('1')
      result(0)(1) should be('1')
      result(0)(2) should be('1')
      result(1)(0) should be('1')
      result(1)(1) should be('*')
      result(1)(2) should be('1')
      result(2)(0) should be('1')
      result(2)(1) should be('1')
      result(2)(2) should be('1')
    }
  }
}