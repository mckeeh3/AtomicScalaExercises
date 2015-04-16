
import com.atomicscala.AtomicTest._

// 1. Create a method plus1 that pluralizes a String, adds 1 to an Int,
//    and adds “+ guest” to a Person. Satisfy the following tests:
//    plus1("car") is "cars"
//    plus1(67) is 68
//    plus1(Person("Joanna")) is
//    "Person(Joanna) + guest"

def plus1(x: Any): Any = {
  x match {
    case s: String => s + "s"
    case i: Int => i + 1
    case p: Person => p + " + guest"
    case _ => "Huh?"
  }
}

case class Person(name: String)

plus1("car") is "cars"
plus1(67) is 68
plus1(Person("Joanna")) is "Person(Joanna) + guest"

// 2. Create a method convertToSize that converts a String to its length,
//    uses Int and Double directly, and converts a Person to 1. Return 0 if
//    you don’t have a matching type. What was the return type of your
//    method? Satisfy the following tests:
//    convertToSize(45) is 45
//    convertToSize("car") is 3
//    convertToSize("truck") is 5
//    convertToSize(Person("Joanna")) is 1
//    convertToSize(45.6F) is 45.6F
//    convertToSize(Vector(1, 2, 3)) is 0

def convertToSize(x: Any): Any = {
  x match {
    case i: Int => i
    case s: String => s.length
    case p: Person => 1
    case f: Float => f
    case d: Double => d
    case _ => 0
  }
}
convertToSize(45) is 45
convertToSize("car") is 3
convertToSize("truck") is 5
convertToSize(Person("Joanna")) is 1
convertToSize(45.6F) is 45.6F
convertToSize(Vector(1, 2, 3)) is 0

// 3. Modify convertToSize from the previous exercise so it returns an
//    Int. Use the scala.math.round method to round the Double first.
//    Did you need to declare the return type? Do you see an advantage
//    to doing so? Satisfy the following tests:
//    convertToSize2(45) is 45
//    convertToSize2("car") is 3
//    convertToSize2("truck") is 5
//    convertToSize2(Person("Joanna")) is 1
//    convertToSize2(45.6F) is 46
//    convertToSize2(Vector(1, 2, 3)) is 0

def convertToSize2(x: Any): Int = {
  x match {
    case i: Int => i
    case s: String => s.length
    case p: Person => 1
    case f: Float => (f + 0.5F).toInt
    case d: Double => (d + 0.5).toInt
    case _ => 0
  }
}

convertToSize2(45) is 45
convertToSize2("car") is 3
convertToSize2("truck") is 5
convertToSize2(Person("Joanna")) is 1
convertToSize2(45.6F) is 46
convertToSize2(Vector(1, 2, 3)) is 0

// 4. Create a new method quantify to return “small” if the argument is
//    less than 100, “medium” if the argument is between 100 and 1000,
//    and “large” if the argument is greater than 1000. Support both
//    Doubles and Ints. Satisfy the following tests:
//    quantify(100) is "medium"
//    quantify(20.56) is "small"
//    quantify(100000) is "large"
//    quantify(-15999) is "small"

def quantify(n: Double): String = {
  n match {
    case d: Double if d < 100 => "small"
    case d: Double if d >= 100 && d <= 1000 => "medium"
    case d: Double if d >= 1000 => "large"
  }
}

quantify(100) is "medium"
quantify(20.56) is "small"
quantify(100000) is "large"
quantify(-15999) is "small"

// 5. Pattern Matching included an exercise to check the forecast, based
//    on sunniness. We tested using discrete values. Revisit that
//    exercise with ranges of values. Create a method forecast that
//    represents the percentage of cloudiness, and use it to produce a
//    “weather forecast” string such as “Sunny” (100), “Mostly Sunny”
//    (80), “Partly Sunny” (50), “Mostly Cloudy” (20), and “Cloudy” (0).
//    Satisfy the following tests:
//    forecast(100) is "Sunny"
//    forecast(81) is "Sunny"
//    forecast(80) is "Mostly Sunny"
//    forecast(51) is "Mostly Sunny"
//    forecast(50) is "Partly Sunny"
//    forecast(21) is "Partly Sunny"
//    forecast(20) is "Mostly Cloudy"
//    forecast(1) is "Mostly Cloudy"
//    forecast(0) is "Cloudy"
//    forecast(-1) is "Unknown"

def forecast(cloudiness: Int): String = {
  cloudiness match {
    case t: Int if t > 80 => "Sunny"
    case t: Int if t > 50 && t <= 80 => "Mostly Sunny"
    case t: Int if t > 20 && t <= 50 => "Partly Sunny"
    case t: Int if t > 0 && t <= 20 => "Mostly Cloudy"
    case t: Int if t == 0 => "Cloudy"
    case _ => "Unknown"
  }
}

forecast(100) is "Sunny"
forecast(81) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(51) is "Mostly Sunny"
forecast(50) is "Partly Sunny"
forecast(21) is "Partly Sunny"
forecast(20) is "Mostly Cloudy"
forecast(1) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(-1) is "Unknown"
