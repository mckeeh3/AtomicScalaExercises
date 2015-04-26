// PythagoreanTheorem.scala
package exercise13

class RightTriangle {
  def hypotenuse(a: Double, b: Double): Double = {
    Math.sqrt(a * a + b * b)
  }

  def area(a: Double, b: Double): Double = {
    a * b / 2
  }
}
