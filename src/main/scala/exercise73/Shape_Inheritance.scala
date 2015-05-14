package exercise73

// Shape_Inheritance.scala

import scala.math.{Pi, sqrt}

object Shape_Inheritance {

  trait Shape {
    def area: Double

    def checksum = {
      area.toString.sum.toInt
    }
  }

  case class Circle(radius: Double) extends Shape {
    def area = 2 * Pi * radius
  }

  case class EQLTriangle(side: Double) extends Shape {
    def area = (sqrt(3) / 4) * side * side
  }

  def a(s: Shape) = f"$s area: ${s.area}%.2f"
}
