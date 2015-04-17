
import com.atomicscala.AtomicTest._

// 1. Building from PatternMatchingCaseClasses.scala, define a new
//    class Plane containing a Vector of Passengers and a name for the
//    plane, so you can create a trip. Satisfy the following test:
//    val trip2 = Vector(
//    Train(travelers, "Reading"),
//    Plane(travelers, "B757"),
//    Bus(travelers, 100))
//    travel(trip2(1)) is "Plane B757 " +
//    "Vector(Passenger(Harvey,Rabbit), " +
//    "Passenger(Dorothy,Gale))"

case class Passenger(first: String, last: String)
case class Plane(travelers: Vector[Passenger], name: String)
case class Train(travelers: Vector[Passenger], line: String)
case class Bus(passengers: Vector[Passenger], capacity: Int)

val travelers = Vector(
  Passenger("Harvey", "Rabbit"),
  Passenger("Dorothy", "Gale"))

def travel(transport: Any): String = {
  transport match {
    case Train(passengers, line) => s"Train line $line $passengers"
    case Bus(passengers, seats) => s"Bus size $seats $passengers"
    case Plane(passengers, name) => s"Plane $name $passengers"
    case Passenger(first, last) => s"$last, $first"
    case what => s"$what is in limbo!"
  }
}

val trip2 = Vector(
  Train(travelers, "Reading"),
  Plane(travelers, "B757"),
  Bus(travelers, 100))

travel(trip2(1)) is "Plane B757 " +
  "Vector(Passenger(Harvey,Rabbit), Passenger(Dorothy,Gale))"

// 2. Building on your solution for Exercise 1, change the case for
//    Passenger so it extracts the object. Satisfy the following test:
//    travel2(Passenger("Sally", "Marie")) is
//    "Sally is walking"

def travel2(transport: Any): String = {
  transport match {
    case Train(passengers, line) => s"Train line $line $passengers"
    case Bus(passengers, seats) => s"Bus size $seats $passengers"
    case Plane(passengers, name) => s"Plane $name $passengers"
    case Passenger(first, last) => s"$first is walking"
    case what => s"$what is in limbo!"
  }
}

travel2(Passenger("Sally", "Marie")) is "Sally is walking"

// 3. Building on your solution for Exercise 2, determine if you must
//    make any changes to pass in a Kitten. Satisfy the following test:
//    case class Kitten(name:String)
//    travel2(Kitten("Kitty")) is
//    "Kitten(Kitty) is in limbo!"

case class Kitten(name:String)
travel2(Kitten("Kitty")) is "Kitten(Kitty) is in limbo!"
