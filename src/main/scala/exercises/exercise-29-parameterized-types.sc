
import com.atomicscala.AtomicTest._

// 1. Modify explicit in ParameterizedReturnTypes.scala so it creates
//    and returns a Vector of Double. Satisfy the following test:
//    explicitDouble(1.0, 2.0, 3.0) is
//    Vector(1.0, 2.0, 3.0)

def inferred(c1: Char, c2: Char, c3: Char) = {
  Vector(c1, c2, c3)
}

def explicit(c1: Char, c2: Char, c3: Char): Vector[Char] = {
  Vector(c1, c2, c3)
}

def explicitDouble(c1: Double, c2: Double, c3: Double): Vector[Double] = {
  Vector(c1, c2, c3)
}

explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)
inferred('a', 'b', 'c') is "Vector(a, b, c)"
explicit('a', 'b', 'c') is "Vector(a, b, c)"
// 2. Building on the previous exercise, change explicit to take a Vector.
//    Create and return a List. Refer to the ScalaDoc for List, if necessary.
//    Satisfy the following tests:
//    explicitList(Vector(10.0, 20.0)) is
//    List(10.0, 20.0)
//    explicitList(Vector(1, 2, 3)) is
//    List(1.0, 2.0, 3.0)

def explicitList(v: Vector[Double]): List[Double] = {
  v.toList
}
explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)

// 3. Building on the previous exercise, change explicit to return a Set.
//    Satisfy the following tests:
//    explicitSet(Vector(10.0, 20.0, 10.0)) is
//    Set(10.0, 20.0)
//    explicitSet(Vector(1, 2, 3, 2, 3, 4)) is
//    Set(1.0, 2.0, 3.0, 4.0)

def explicitSet(v: Vector[Double]): Set[Double] = {
  v.toSet
}

explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)

// 4. In Pattern Matching, we created a method for weather forecasts
//    using “Sunny” (100), “Mostly Sunny” (80), “Partly Sunny” (50),
//    “Mostly Cloudy” (20), and “Cloudy” (0). Using parameterized types,
//    create a method historicalData that counts the number of sunny,
//    partly sunny, etc. days. Satisfy the following tests:
//    val weather = Vector(100, 80, 20, 100, 20)
//    historicalData(weather) is
//    "Sunny=2, Mostly Sunny=1, Mostly Cloudy=2"

def historicalData(v: Vector[Int]): String = {
  var sunny = 0
  var mostlySunny = 0
  var partlySunny = 0
  var mostlyCloudy = 0
  var cloudy = 0
  var unknown = 0
  var counts = ""

  for (cloudiness <- v) {
    cloudiness match {
      case 100 => sunny += 1
      case 80 => mostlySunny += 1
      case 50 => partlySunny += 1
      case 20 => mostlyCloudy += 1
      case 0 => cloudy += 1
      case _ => unknown += 1
    }
  }

  if (sunny > 0) counts += s"Sunny=$sunny"
  if (mostlySunny > 0) counts += s", Mostly Sunny=$mostlySunny"
  if (partlySunny > 0) counts += s", Partly Sunny=$partlySunny"
  if (mostlyCloudy > 0) counts += s", Mostly Cloudy=$mostlyCloudy"
  if (cloudy > 0) counts += s", Cloudy=$cloudy"
  if (unknown > 0) counts += s", Unknown=$unknown"
  counts
}

val weather = Vector(100, 80, 20, 100, 20)
historicalData(weather) is "Sunny=2, Mostly Sunny=1, Mostly Cloudy=2"
