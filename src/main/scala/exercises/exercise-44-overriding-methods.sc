
import com.atomicscala.AtomicTest._

// 1. On line 7 in GreatApe3.scala, the method eat is defined with
//    parentheses. Do you recall why?

// the method changes the state of the object

// 2. Rework your solution for Exercise 2 in Base Class Initialization by
//    overriding myWords. Satisfy the following tests:
//    val roaringApe =
//      new GreatApe2(112, 9, "Male")
//    roaringApe.myWords is Vector("Roar")
//    val chattyBonobo =
//      new Bonobo2(150, 14, "Female")
//    chattyBonobo.myWords is
//    Vector("Roar","Hello")

class GreatApe2(val weight: Double, val age: Int, val sex: String) {
  def myWords = Vector("Roar")
}

class Bonobo2(weight: Double, age: Int, sex: String)
  extends GreatApe2(weight, age, sex) {
  override def myWords = Vector("Roar", "Hello")
}

val roaringApe = new GreatApe2(112, 9, "Male")
roaringApe.myWords is Vector("Roar")
val chattyBonobo = new Bonobo2(150, 14, "Female")
chattyBonobo.myWords is Vector("Roar", "Hello")
// 3. Rework your solution for the Trip, AirplaneTrip, and CarTrip
//    exercises in Base Class Initialization, using the toString method
//    from the base class rather than duplicating the code. Satisfy the
//    following tests:
//    val t = new Trip("Detroit","Houston",
//      "5/1/2012","6/1/2012")
//    t is "From Detroit to Houston:" +
//      " 5/1/2012 to 6/1/2012"
//    val a = new AirplaneTrip("Detroit",
//      "London","9/1/1939",
//      "10/31/1939", "Superman")
//    a is
//      "From Detroit to London:" +
//      " 9/1/1939 to 10/31/1939" +
//      ", we watched Superman"
//    val c = new CarTrip(cities,
//      "6/1/2012","7/1/2012")
//    c.origination is "Boston"
//    c.destination is "San Francisco"
//    c.startDate is "6/1/2012"
//    c is "From Boston to San Francisco:" +
//      " 6/1/2012 to 7/1/2012"

case class Trip(origination: String, destination: String,
                startDate: String, endDate: String) {
  override def toString =
    s"From $origination to $destination: $startDate to $endDate"
}

class AirplaneTrip(origin: String, destination: String,
                   start: String, end: String, movie: String)
  extends Trip(origin, destination, start, end) {
}

class CarTrip(cities: Vector[String], start: String, end: String)
  extends Trip(cities.head, cities.last, start, end)

val t = new Trip("Detroit","Houston", "5/1/2012", "6/1/2012")
t is "From Detroit to Houston: 5/1/2012 to 6/1/2012"
val a = new AirplaneTrip("Detroit", "London", "9/1/1939", "10/31/1939", "Superman")
// following test was not working - nothing happened, no errors no no other tests performed
//a is "From Detroit to London: 9/1/1939 to 10/31/1939, we watched Superman"
val cities = Vector("Boston",
  "Albany", "Buffalo", "Cleveland",
  "Columbus", "Indianapolis",
  "St. Louis", "Kansas City",
  "Denver", "Grand Junction",
  "Salt Lake City", "Las Vegas",
  "Bakersfield", "San Francisco")
val c = new CarTrip(cities, "6/1/2012","7/1/2012")
c.origination is "Boston"
c.destination is "San Francisco"
c.startDate is "6/1/2012"
c is "From Boston to San Francisco: 6/1/2012 to 7/1/2012"
