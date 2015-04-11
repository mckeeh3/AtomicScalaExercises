package com.atomicscala.pythagorean

class EquilateralTriangle {
  def area(side: Double): Double = {
    Math.sqrt(3) * side * side / 4
  }
}
