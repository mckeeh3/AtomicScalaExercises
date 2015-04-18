
import com.atomicscala.AtomicTest._

// 1. Override toString in a case class. Modify Bicycle so its toString
//    produces “Bicycle built for 2.” Satisfy the following test:
//    val forTwo = Bicycle(2)
//    forTwo is "Bicycle built for 2"

case class Bicycle(riders: Int) {
  override def toString = s"Bicycle built for $riders"
}

val forTwo = Bicycle(2)
forTwo is "Bicycle built for 2"

// 2. Build on the previous exercise to show that the toString method
//    can be more complex than a single-line method.
//    A) Change the class name to Cycle and pass the number of wheels
//       as a class argument when you create the object.
//    B) Use pattern matching to display “Unicycle” for a single wheeled
//       cycle, “Bicycle” for 2 wheels, “Tricycle” for 3 wheels, “Quadricycle”
//       for 4 wheels, and “Cycle with n wheels” for numbers greater than
//       4, replacing “n” with the argument. Satisfy the following tests:
//    val c1 = Cycle(1)
//    c1 is "Unicycle"
//    val c2 = Cycle(2)
//    c2 is "Bicycle"
//    val cn = Cycle(5)
//    cn is "Cycle with 5 wheels"

case class Cycle(wheels: Int) {
  override def toString = {
    wheels match {
      case 1 => "Unicycle"
      case 2 => "Bicycle"
      case 3 => "Tricycle"
      case 4 => "Quadricycle"
      case n if n < 1 => "That's not a cycle!"
      case _ => s"Cycle with $wheels wheels"
    }
  }
}
val c1 = Cycle(1)
c1 is "Unicycle"
val c2 = Cycle(2)
c2 is "Bicycle"
val cn = Cycle(5)
cn is "Cycle with 5 wheels"

// 3. Add to the previous exercise. For a negative number of wheels,
//    satisfy the following test:
//    Cycle(-2) is "That's not a cycle!"

Cycle(-2) is "That's not a cycle!"
