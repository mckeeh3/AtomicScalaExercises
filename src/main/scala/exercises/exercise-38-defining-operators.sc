
import com.atomicscala.AtomicTest._

// 1. In Exercise 4 of Class Exercises, you created a class SimpleTime
//    with a subtract method. Change the name of that method to use
//    the minus sign (-). Satisfy the following tests:
//    val someT1 = new SimpleTime2(10, 30)
//    val someT2 = new SimpleTime2(9, 30)
//    val someST = someT1 - someT2
//    someST.hours is 1
//    someST.minutes is 0
//    val someST2 = new SimpleTime2(10, 30) -
//      new SimpleTime2(9, 45)
//    someST2.hours is 0
//    someST2.minutes is 45

class SimpleTime2(val hours: Int, val minutes: Int) {
  def -(time: SimpleTime2): SimpleTime2 = {
    val elapsed = (hours * 60 + minutes) - (time.hours * 60 + time.minutes)

    if (elapsed <= 0) {
      new SimpleTime2(0, 0)
    } else {
      new SimpleTime2(elapsed / 60, elapsed % 60)
    }
  }
}

val someT1 = new SimpleTime2(10, 30)
val someT2 = new SimpleTime2(9, 30)
val someST = someT1 - someT2
someST.hours is 1
someST.minutes is 0
val someST2 = new SimpleTime2(10, 30) -
  new SimpleTime2(9, 45)
someST2.hours is 0
someST2.minutes is 45

// 2. Create a class FancyNumber1 that takes an Int as a class
//    parameter and has one method, power(n: Int) that raises that
//    number to the nth power. Hint: you may choose to use
//    scala.math.pow, and if you do, investigate toInt and toDouble.
//    Satisfy the following tests:
//    val a1 = new FancyNumber1(2)
//    a1.power(3) is 8
//    val b1 = new FancyNumber1(10)
//    b1.power(2) is 100

class FancyNumber1(n: Int) {
  def power(x: Int) = scala.math.pow(n, x).toInt
}

val a1 = new FancyNumber1(2)
a1.power(3) is 8
val b1 = new FancyNumber1(10)
b1.power(2) is 100

// 3. Adding to your solution for the previous exercise, replace power
//    with ^. Satisfy the following tests:
//    val a2 = new FancyNumber2(2)
//    a2.^(3) is 8
//    val b2 = new FancyNumber2(10)
//    b2 ^ 2 is 100

class FancyNumber2(n: Int) {
  def ^(x: Int) = scala.math.pow(n, x).toInt
}

val a2 = new FancyNumber2(2)
a2.^(3) is 8
val b2 = new FancyNumber2(10)
b2 ^ 2 is 100

// 4. Building on the previous exercise, add another method ** which
//    does the same thing as ^. Do you see a benefit to leaving in the
//    method power and calling that from both methods? Satisfy the
//    following tests:
//    val a3 = new FancyNumber3(2.0)
//    a3.**(3) is 8
//    val b3 = new FancyNumber3(10.0)
//    b3 ** 2 is 100

class FancyNumber3(n: Double) {
  def power(x: Double) = scala.math.pow(n, x).toInt
  def ^(x: Int) = power(x)
  def **(x: Int) = power(x)
}

val a3 = new FancyNumber3(2.0)
a3.**(3) is 8
val b3 = new FancyNumber3(10.0)
b3 ** 2 is 100
