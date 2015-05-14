
import com.atomicscala.AtomicTest._

// 1. Add class Rectangle to Shape_Inheritance.scala and verify that it
//    works. Now add class Rectangle and its associated RectangleCalc
//    to Shape_TypeClass.scala and verify that it works. Note the
//    differences.

{
  import exercise73.Shape_Inheritance._
  case class Rectangle(side1: Double, side2: Double) extends Shape {
    def area = side1 * side2
  }

  a(Circle(2.2)) is "Circle(2.2) area: 13.82"
  a(EQLTriangle(3.9)) is "EQLTriangle(3.9) area: 6.59"
  a(Circle(4.5)) is "Circle(4.5) area: 28.27"
  a(Rectangle(2, 3)) is "Rectangle(2.0,3.0) area: 6.00"
}

{
  import exercise73.Shape_TypeClass._
  case class Rectangle(side1: Double, side2: Double)
  implicit object RectangleCalc extends Calc[Rectangle] {
    def area(shape: Rectangle) =
      shape.side1 * shape.side2

    def checksum(shape: Rectangle) =
      area(shape).toString.sum.toInt
  }

  a(Circle(2.2)) is "Circle(2.2) area: 13.82"
  a(EQLTriangle(3.9)) is "EQLTriangle(3.9) area: 6.59"
  a(Circle(4.5)) is "Circle(4.5) area: 28.27"
  a(Rectangle(2, 3)) is "Rectangle(2.0,3.0) area: 6.00"
}

// 2. Add a new operation checkSum to Shape_Inheritance.scala that
//    turns the area into a String, then sums each digit (and the decimal
//    point) to produce an Int result. Verify that it works. Now do the
//    same thing to Shape_TypeClass.scala and note the differences.

{
  import exercise73.Shape_Inheritance._
  // See trait in exercise73.Shape_Inheritance
  Circle(4.5).checksum is 935
  EQLTriangle(3.9).checksum is 891
}

{
  import exercise73.Shape_TypeClass._
  // See trait in exercise73.Shape_Inheritance
  c(Circle(4.5)) is "Circle(4.5) checksum: 935"
  c(EQLTriangle(3.9)) is "EQLTriangle(3.9) checksum: 891"
}

// 3. Add a new class to Shape_TypeClass.scala but do not create an
//    associated Calc class. Try to use it and see what happens.

{
  import exercise73.Shape_TypeClass._

  Square(4.4) is "Square(4.4)"
}

// 4. Try duplicating lines 19-20 and 24 of Shape_Inheritance.scala in
//    Shape_TypeClass.scala and see what happens. Why does this
//    make sense?

{
  import exercise73.Shape_TypeClass._

  val shapes = Vector(Circle(2.2), EQLTriangle(3.9), Circle(4.5))
  shapes.head is "Circle(2.2)"
//  val result = for(s <- shapes) yield a(s)
//  result is "?"
// gets error: could not find implicit value for parameter calc: ...
}

// 5. Create a type class trait called Reporter with a method generate.
//    Write a method report that takes any object and its associated
//    Reporter and produces a String (using generate) containing
//    information about that object. Create case classes Person, Store
//    and Vehicle, each containing different types of information. Create
//    their associated Reporter objects and show that your type class
//    system works correctly.

{
  trait Reporter[T] {
    def generate(item: T): String
  }
  def report[T](item: T)(implicit reporter: Reporter[T]) = {
    s"${reporter.generate(item)}"
  }

  case class Person(name: String, email: String)
  case class Store(name: String, address: String)
  case class Vehicle(make: String, model: String, color: String)

  implicit object PersonReporter extends Reporter[Person] {
    override def generate(item: Person): String =
      s"Person name: ${item.name}, email: ${item.email}"
  }

  implicit object StoreReporter extends Reporter[Store] {
    def generate(item: Store): String =
      s"Store name: ${item.name}, address: ${item.address}"
  }

  implicit object VehicleReporter extends Reporter[Vehicle] {
    def generate(item: Vehicle): String = {
      s"Vehicle make: ${item.make}, model: ${item.model}, color: ${item.color}"
    }
  }

  report(Person("Arthur Dent", "arthur.dent@gmail.com")) is
    "Person name: Arthur Dent, email: arthur.dent@gmail.com"
  report(Store("Milliways", "End of the universe")) is
    "Store name: Milliways, address: End of the universe"
  report(Vehicle("Ageis Dynamics", "Avenger", "Blue")) is
    "Vehicle make: Ageis Dynamics, model: Avenger, color: Blue"
}

// 6. Create a type class trait called Transformer with a method convert,
//    but Transformer takes two type parameters: the type it’s
//    converting from, and the type it’s converting to. Write a method
//    transform that takes any object and its associated Transformer
//    and converts the object. Create several classes and their associated
//    Transformers and show that your type class system works
//    correctly.

{
  trait Transformer[F, T] {
    def convert(from: F): T
  }
  def transform[F, T](from: F)(implicit transformer: Transformer[F, T]) = {
    transformer.convert(from)
  }

  case class Circle(radius: Double)
  case class Ellipse(r1: Double, r2: Double)
  case class Rectangle(side1: Double, side2: Double)

  implicit object CircleTransformer extends Transformer[Circle, Rectangle] {
    def convert(from: Circle): Rectangle =
      Rectangle(from.radius * 2, from.radius * 2)
  }

  implicit object EllipseTransformer extends Transformer[Ellipse, Rectangle] {
    def convert(from: Ellipse): Rectangle =
      Rectangle(from.r1 * 2, from.r2 * 2)
  }
  transform(Circle(3)) is "Rectangle(6.0,6.0)"
  transform(Ellipse(4.35, 2.15)) is "Rectangle(8.7,4.3)"
}

// 7. Start with the first example class and transformation in the
//    previous exercise. Try adding a second method transform2 that
//    produces a different type of result. Why doesn’t this work? Add
//    code to fix the problem.

{
  trait Transformer[F, T] {
    def convert(from: F): T
  }
  def transform[F, T](from: F)(implicit transformer: Transformer[F, T]) = {
    transformer.convert(from)
  }
//  def transform2[F, T](from: F)(implicit transformer: Transformer[F, T]) = {
//    transformer.convert(from)
//  }

  case class Circle(radius: Double)
  case class Ellipse(r1: Double, r2: Double)
  case class Rectangle(side1: Double, side2: Double)

  implicit object CircleTransformer extends Transformer[Circle, Rectangle] {
    def convert(from: Circle): Rectangle =
      Rectangle(from.radius * 2, from.radius * 2)
  }

//  implicit object CircleTransformer2 extends Transformer[Circle, Ellipse] {
//    def convert(from: Circle): Ellipse =
//      Ellipse(from.radius, from.radius)
//  }

  implicit object EllipseTransformer extends Transformer[Ellipse, Rectangle] {
    def convert(from: Ellipse): Rectangle =
      Rectangle(from.r1 * 2, from.r2 * 2)
  }
  transform(Circle(4)) is "Rectangle(8.0,8.0)"
  transform(Ellipse(5, 6)) is "Rectangle(10.0,12.0)"

//  transform2(Circle(4.35))// is "Rectangle(8.7,4.3)"

  // All 3 convert methods above expect return type Any
}

{
  trait Transformer[F, T] {
    def convert(from: F): T
  }
  def transform[F, T](from: F)(implicit transformer: Transformer[F, T]) = {
    transformer.convert(from)
  }
  trait Transformer2[F, T] {
    def convert(from: F): T
  }
  def transform2[F, T](from: F)(implicit transformer: Transformer2[F, T]) = {
    transformer.convert(from)
  }

  case class Circle(radius: Double)
  case class Ellipse(r1: Double, r2: Double)
  case class Rectangle(side1: Double, side2: Double)

  implicit object CircleTransformer extends Transformer[Circle, Rectangle] {
    def convert(from: Circle): Rectangle =
      Rectangle(from.radius * 2, from.radius * 2)
  }

  implicit object EllipseTransformer extends Transformer[Ellipse, Rectangle] {
    def convert(from: Ellipse): Rectangle =
      Rectangle(from.r1 * 2, from.r2 * 2)
  }
  transform(Circle(4)) is "Rectangle(8.0,8.0)"
  transform(Ellipse(5, 6)) is "Rectangle(10.0,12.0)"

  implicit object CircleTransformer2 extends Transformer2[Circle, Ellipse] {
    def convert(from: Circle): Ellipse =
      Ellipse(from.radius, from.radius)
  }
  transform2(Circle(7)) is "Ellipse(7.0,7.0)"
}
