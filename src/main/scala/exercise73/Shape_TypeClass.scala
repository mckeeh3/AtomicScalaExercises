package exercise73

// Shape_TypeClass.scala

import scala.math.{Pi, sqrt}

object Shape_TypeClass {

  trait Calc[S] {
    def area(shape: S): Double

    def checksum(shape: S): Int
  }

  case class Circle(radius: Double)

  implicit object CircleCalc extends Calc[Circle] {
    def area(shape: Circle) =
      2 * shape.radius * Pi

    def checksum(shape: Circle) =
      area(shape).toString.sum.toInt
  }

  case class EQLTriangle(side: Double)

  implicit object EQLTriangleCalc extends Calc[EQLTriangle] {
    def area(shape: EQLTriangle) =
      (sqrt(3) / 4) * shape.side * shape.side

    def checksum(shape: EQLTriangle) =
      area(shape).toString.sum.toInt
  }

  case class Square(side: Double)

  def a[S](shape: S)(implicit calc: Calc[S]) =
    f"$shape area: ${calc.area(shape)}%2.2f"

  def c[S](shape: S)(implicit calc: Calc[S]) =
    f"$shape checksum: ${calc.checksum(shape)}%d"
}
