
import com.atomicscala.AtomicTest._

// 1. Rewrite matchColor using if/else. Which approach seems more
//    straightforward? Satisfy the following tests:
//    matchColor("white") is
//    "UNKNOWN COLOR: white"
//    matchColor("blue") is "BLUE"

def matchColor(color: String): String = {
  color match {
    case "red" => "RED"
    case "blue" => "BLUE"
    case "green" => "GREEN"
    case _ => "UNKNOWN COLOR: " + color
  }
}

def matchColorIfElse(color: String): String = {
  if (color == "red") {
    "RED"
  } else if (color == "blue") {
    "BLUE"
  } else if (color == "green") {
    "GREEN"
  } else {
    "UNKNOWN COLOR: " + color
  }
}

matchColor("red") is "RED"
matchColorIfElse("red") is "RED"

matchColor("blue") is "BLUE"
matchColorIfElse("blue") is "BLUE"

matchColor("green") is "GREEN"
matchColorIfElse("green") is "GREEN"

matchColor("white") is "UNKNOWN COLOR: white"
matchColorIfElse("white") is "UNKNOWN COLOR: white"

// 2. Rewrite oneOrTheOther from More Conditionals using pattern
//    matching. Satisfy the following tests:
//    val v = Vector(1)
//    val v2 = Vector(3, 4)
//    oneOrTheOther(v == v.reverse) is "True!"
//    oneOrTheOther(v2 == v2.reverse) is
//    "It's false"

val v = Vector(1)
val v2 = Vector(3, 4)

def oneOrTheOther(exp: Boolean): String = {
  if (exp) {
    "True!" // No 'return' necessary
  }
  else {
    "It's false"
  }
}

def oneOrTheOtherCase(exp: Boolean): String = {
  exp match {
    case true => "True!"
    case _ => "It's false"
  }
}

oneOrTheOther(v == v.reverse) is "True!"
oneOrTheOtherCase(v == v.reverse) is "True!"

oneOrTheOther(v2 == v2.reverse) is "It's false"
oneOrTheOtherCase(v2 == v2.reverse) is "It's false"

// 3. Rewrite checkTruth from More Conditionals with pattern
//    matching. Satisfy the following tests:
//    checkTruth(true || false, true) is
//      "Both are true"
//    checkTruth(1 > 0 && -1 < 0, 1 == 2) is
//      "First: true, second: false"
//    checkTruth(1 >= 2, 1 >= 1) is
//      "First: false, second: true"
//    checkTruth(true && false, false && true) is
//      "Both are false"

def checkTruth(exp1: Boolean, exp2: Boolean): String = {
  if (exp1 && exp2) {
    "Both are true"
  } else if (!exp1 && !exp2) {
    "Both are false"
  } else if (exp1) {
    "First: true, second: false"
  } else {
    "First: false, second: true"
  }
}

def checkTruthCase(exp1: Boolean, exp2: Boolean): String = {
  (exp1, exp2) match {
    case (true, true) => "Both are true"
    case (true, false) => "First: true, second: false"
    case (false, true) => "First: false, second: true"
    case _ => "Both are false"
  }
}

checkTruth(true || false, true) is "Both are true"
checkTruthCase(true || false, true) is "Both are true"
checkTruth(1 > 0 && -1 < 0, 1 == 2) is "First: true, second: false"
checkTruthCase(1 > 0 && -1 < 0, 1 == 2) is "First: true, second: false"
checkTruth(1 >= 2, 1 >= 1) is "First: false, second: true"
checkTruthCase(1 >= 2, 1 >= 1) is "First: false, second: true"
checkTruth(true && false, false && true) is "Both are false"
checkTruthCase(true && false, false && true) is "Both are false"

// 4. Create a method forecast that represents the percentage of
//    cloudiness, and use it to produce a “weather forecast” string such
//    as “Sunny” (100), “Mostly Sunny” (80), “Partly Sunny” (50), “Mostly
//    Cloudy” (20), and “Cloudy” (0). For this exercise, only match for the
//    legal values 100, 80, 50, 20, and 0. Everything else should produce
//    “Unknown.” Satisfy the following tests:
//    forecast(100) is "Sunny"
//    forecast(80) is "Mostly Sunny"
//    forecast(50) is "Partly Sunny"
//    forecast(20) is "Mostly Cloudy"
//    forecast(0) is "Cloudy"
//    forecast(15) is "Unknown"

def forecast(cloudiness: Int): String = {
  cloudiness match {
    case 100 => "Sunny"
    case 80 => "Mostly Sunny"
    case 50 => "Partly Sunny"
    case 20 => "Mostly Cloudy"
    case 0 => "Cloudy"
    case _ => "Unknown"
  }
}

forecast(100) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(50) is "Partly Sunny"
forecast(20) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(15) is "Unknown"

// 5. Create a Vector named sunnyData that holds the values (100, 80,
//    50, 20, 0, 15). Use a for loop to call forecast with the contents of
//    sunnyData. Display the answers and ensure that they match the
//    responses above.

val sunnyDate = Vector(100, 80, 50, 20, 0, 15)
for (temp <- sunnyDate) {
  println(forecast(temp))
}
