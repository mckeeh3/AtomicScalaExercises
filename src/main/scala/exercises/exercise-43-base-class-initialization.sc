
import com.atomicscala.AtomicTest._

// 1. In GreatApe2.scala, add another val field in GreatApe. Now add a
//    new subclass BonoboC that inherits from BonoboB. Write a test for
//    BonoboC.

class GreatApe(val weight: Double, val age: Int, val height: Double)

class Bonobo(weight: Double, age: Int, height: Double)
  extends GreatApe(weight, age, height)

class Chimpanzee(weight: Double, age: Int, height: Double)
  extends GreatApe(weight, age, height)

class BonoboB(weight: Double, age: Int, height: Double)
  extends Bonobo(weight, age, height)

class BonoboC(weight: Double, age: Int, height: Double)
  extends BonoboB(weight, age, height)

def display(ape: GreatApe) =
  s"weight: ${ape.weight} age: ${ape.age} height: ${ape.height}"

display(new GreatApe(100, 12, 50)) is "weight: 100.0 age: 12 height: 50.0"
display(new Bonobo(100, 12, 35)) is "weight: 100.0 age: 12 height: 35.0"
display(new Chimpanzee(100, 12, 30)) is "weight: 100.0 age: 12 height: 30.0"
display(new BonoboB(100, 12, 40)) is "weight: 100.0 age: 12 height: 40.0"
display(new BonoboC(80, 9, 43.2)) is "weight: 80.0 age: 9 height: 43.2"

// 2. Demonstrate that the Bonobo constructor can call methods in the
//    GreatApe class by adding a method to GreatApe and calling it from
//    the Bonobo constructor.

class GreatApe2(val weight: Double, val age: Int, val height: Double) {
  def lbsPerHeight = weight / height
}

class Bonobo2(weight: Double, age: Int, height: Double)
  extends GreatApe2(weight, age, height) {
  println(lbsPerHeight)
}

// 3. Define a class Home derived from House with an additional
//    Boolean field heart. Satisfy the following tests:
//    val h = new Home
//    h.toString is "Where the heart is"
//    h.heart is true

class House {
  override def toString = "Where the heart is"
}
class Home extends House {
  val heart = true
}

val h = new Home
h.toString is "Where the heart is"
h.heart is true

// 4. Modify VacationHouse by including a class to represent months
//    rented (pattern matching can help here). Satisfy the following:
//    val v = new VacationHouse("MI","49431",6,8)
//    v is "Rented house in MI for months of " +
//      "June through August."

class House4(val address: String, val state: String, val zip: String) {
  def this(state: String, zip: String) = this("address?", state, zip)
  def this(zip: String) = this("address?", "state?", zip)
}

class Home4(address: String, state: String, zip: String, val name: String)
  extends House4(address, state, zip) {
  override def toString = s"$name: $address, $state $zip"
}

class VacationHouse(state: String, zip: String, val startMonth: Int, val endMonth: Int)
  extends House4(state, zip) {
  def monthName(month: Int) = month match {
    case 1 => "January"
    case 2 => "February"
    case 3 => "March"
    case 4 => "April"
    case 5 => "May"
    case 6 => "June"
    case 7 => "July"
    case 8 => "August"
    case 9 => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _ => s"Invalid ($month)"
  }
  override def toString =
    s"Rented house in $state for months " +
      s"of ${monthName(startMonth)} " +
      s"through ${monthName(endMonth)}."
}

val v = new VacationHouse("MI", "49431", 6, 8)
v is "Rented house in MI for months of June through August."

// 5. Create a class Trip including origin, destination, start and end
//    dates. Create a subclass AirplaneTrip, including the name of an in-
//    flight movie. Create a second subclass CarTrip, including a list of
//    cities you will drive through. Satisfy the following tests:
//    val t = new Trip("Detroit","Houston",
//      "5/1/2012","6/1/2012")
//    val a = new AirplaneTrip("Detroit",
//      "London","9/1/1939",
//      "10/31/1939", "Superman")
//    val cities = Vector("Boston",
//      "Albany","Buffalo","Cleveland",
//      "Columbus","Indianapolis",
//      "St. Louis", "Kansas City",
//      "Denver","Grand Junction",
//      "Salt Lake City","Las Vegas",
//      "Bakersfield","San Francisco")
//    val c = new CarTrip(cities,
//      "6/1/2012","7/1/2012")
//    c.origination is "Boston"
//    c.destination is "San Francisco"
//    c.startDate is "6/1/2012"
//    t is "From Detroit to Houston:"
//      + " 5/1/2012 to 6/1/2012"
//    a is "On a flight from Detroit to"
//      + " London, we watched Superman"
//    c is "From Boston to San Francisco:"
//      + " 6/1/2012 to 7/1/2012"

case class Trip(origination: String, destination: String,
                startDate: String, endDate: String) {
  override def toString =
    s"From $origination to $destination: $startDate to $endDate"
}

class AirplaneTrip(origin: String, destination: String,
                   start: String, end: String, movie: String)
  extends Trip(origin, destination, start, end) {
  override def toString =
    s"On a flight from $origin to $destination, we watched $movie"
}

class CarTrip(cities: Vector[String], start: String, end: String)
  extends Trip(cities.head, cities.last, start, end)

val t = new Trip("Detroit", "Houston", "5/1/2012", "6/1/2012")
val a = new AirplaneTrip("Detroit", "London", "9/1/1939", "10/31/1939", "Superman")
val cities = Vector("Boston",
  "Albany", "Buffalo", "Cleveland",
  "Columbus", "Indianapolis",
  "St. Louis", "Kansas City",
  "Denver", "Grand Junction",
  "Salt Lake City", "Las Vegas",
  "Bakersfield", "San Francisco")
val c = new CarTrip(cities, "6/1/2012", "7/1/2012")
c.origination is "Boston"
c.destination is "San Francisco"
c.startDate is "6/1/2012"
t is "From Detroit to Houston: 5/1/2012 to 6/1/2012"
a is "On a flight from Detroit to London, we watched Superman"
c is "From Boston to San Francisco: 6/1/2012 to 7/1/2012"

// 6. Does inheritance simplify the implementation of Exercise 5?
// some, there is some reuse

// 7. Can you think of other ways to design the classes in Exercise 5?
// case class Trip removes the val on the constructor

// 8. Show what happens if you try to inherit from a case class.
// all tests still pass
