//1. Create a method getSquare that takes an Int argument and returns
//   its square. Print your answer. Test using the following code.
//   val a = getSquare(3)
//   assert(/* fill this in */)
//   val b = getSquare(6)
//   assert(/* fill this in */)
//   val c = getSquare(5)
//   assert(/* fill this in */)

def getSquare(n: Int): Int = {
  n * n
}

val a = getSquare(3)
assert(a == 9)
val b = getSquare(6)
assert(b == 36)
val c = getSquare(5)
assert(c == 25)

// 2. Create a method getSquareDouble that takes a Double argument
//    and returns its square. Print your answer. How does this differ
//    from Exercise 1? Use the following code to check your solutions.
//    val sd1 = getSquareDouble(1.2)
//    assert(1.44 == sd1, "Your message here")
//    val sd2 = getSquareDouble(5.7)
//    assert(32.49 == sd2, "Your message here")

def getSquareDouble(x: Double): Double = {
  x * x
}

val sd1 = getSquareDouble(1.2)
assert(1.44 == sd1, "getSquareDouble failed")
val sd2 = getSquareDouble(5.7)
assert(32.49 == sd2, "getSquareDouble failed")

// 3. Create a method isArg1GreaterThanArg2 that takes two Double
// arguments. Return true if the first argument is greater than the
// second. Return false otherwise. Print your answer. Satisfy the
// following:
// val t1 = isArg1GreaterThanArg2(4.1, 4.12)
// assert(/* fill this in */)
// val t2 = isArg1GreaterThanArg2(2.1, 1.2)
// assert(/* fill this in */)

def isArg1GreaterThanArg2(x: Double, y: Double): Boolean = {
  x > y
}

val t1 = isArg1GreaterThanArg2(4.1, 4.12)
assert(!t1)
val t2 = isArg1GreaterThanArg2(2.1, 1.2)
assert(t2)

// 4. Create a method getMe that takes a String and returns the same
// String, but all in lowercase letters (There’s a String method called
// toLowerCase). Print your answer. Satisfy the following:
// val g1 = getMe("abraCaDabra")
// assert("abracadabra" == g1,
// "Your message here")
// val g2 = getMe("zyxwVUT")
// assert("zyxwvut"== g2, "Your message here")

def getMe(s: String): String = {
  s.toLowerCase
}

val g1 = getMe("abraCaDabra")
assert("abracadabra" == g1, "getMe not working")
val g2 = getMe("zyxwVUT")
assert("zyxwvut" == g2, "getMe not working")

// 5. Create a method addStrings that takes two Strings as arguments,
// and returns the Strings appended (added) together. Print your
// answer. Satisfy the following:
// val s1 = addStrings("abc", "def")
// assert(/* fill this in */)
// val s2 = addStrings("zyx", "abc")
// assert(/* fill this in */)

def addStrings(s1: String, s2: String): String = {
  s1 + s2
}

val s1 = addStrings("abc", "def")
assert(s1 == "abcdef")
val s2 = addStrings("zyx", "abc")
assert(s2 == "zyxabc")

// 6. Create a method manyTimesString that takes a String and an Int
//    as arguments and returns the String duplicated that many times.
//    Print your answer. Satisfy the following:
//    val m1 = manyTimesString("abc", 3)
//    assert("abcabcabc" == m1,
//    "Your message here")
//    val m2 = manyTimesString("123", 2)
//    assert("123123" == m2, "Your message here")

def manyTimesString(s: String, c: Int): String = {
  var result = ""
  for (i <- Range(0, c)) {
    result += s
  }
  result
}

val m1 = manyTimesString("abc", 3)
assert("abcabcabc" == m1, "manyTimesString failed")
val m2 = manyTimesString("123", 2)
assert("123123" == m2, "manyTimesString failed")

// 7. In the exercises for Evaluation Order, you calculated body mass
//    index (BMI) using weight in pounds and height in inches. Rewrite
//    as a method. Satisfy the following:
//    val normal = bmiStatus(160, 68)
//    assert("Normal weight" == normal,
//      "Expected Normal weight, Got " + normal)
//    val overweight = bmiStatus(180, 60)
//    assert("Overweight" == overweight,
//      "Expected Overweight, Got " +
//      overweight)
//    val underweight = bmiStatus(100, 68)
//    assert("Underweight" == underweight,
//      "Expected Underweight, Got " +
//      underweight)

def bmiStatus(lbs: Double, height: Double): String = {
  val bmi = lbs / (height * height) * 703.07
  if(bmi < 18.5) "Underweight"
  else if(bmi < 25) "Normal weight"
  else "Overweight"
}

val normal = bmiStatus(160, 68)
assert("Normal weight" == normal, "Expected Normal weight, Got " + normal)
val overweight = bmiStatus(180, 60)
assert("Overweight" == overweight,  "Expected Overweight, Got " + overweight)
val underweight = bmiStatus(100, 68)
assert("Underweight" == underweight, "Expected Underweight, Got " + underweight)
