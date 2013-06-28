package com.rohankar.scala

import scala.collection.immutable.Map

class BookCart {

  type Book = (Int, String)

  var bookSet: Set[Book] = Set()

  def add(qty: Int, book: String) {
    bookSet += ((qty, book))
  }

  def total: Double = {
    var discounts: List[Int] = adjustDiscountSet(createDiscountSet)

    (for (bookCount <- discounts) yield {
      calcDiscountedPrice(bookCount)
    }).sum
  }

  //
  // private methods
  //
  private def calcDiscountedPrice(bookCount: Int): Double = {
    if (bookCount > 1) {
      val discount = getDiscountForNumberOfBooks(bookCount);
      (8 * bookCount) - (8 * bookCount * discount)
    } else 8 * bookCount
  }

  private def getDiscountForNumberOfBooks(bookCount: Int): Double = {
    if (bookCount == 2 || bookCount == 3)
      (bookCount - 1) * 0.05
    else
      bookCount * 0.05
  }

  /**
   * Creates a discount set count for a *each* book e.g (4, 4)
   */
  private def createDiscountSet: List[Int] = {
    var discounts: List[Int] = List(0, 0) // FIXME considering only max 2 discount set
    for (book <- bookSet) {
      for (i <- 0 until book._1) {
        discounts = discounts.updated(i, discounts(i) + 1)
      }
    }
    discounts
  }

  /**
   * Adjust discount set for max discount, e.g. convert discount set (5, 4) to (4, 4) for max discount.
   * This is purely as per dojo specific, this algorithm is faulty.
   */
  private def adjustDiscountSet(discounts: List[Int]): List[Int] = {
    var t = 0
    val disc = remove(0, discounts)
    if (disc.length > 1) {
      for (d <- discounts) yield {
        if (d > 4) {
          t = d - 4
          d - t
        } else d + t
      }
    } else discounts
  }

  private def remove(num: Int, list: List[Int]) = list diff List(num)
}