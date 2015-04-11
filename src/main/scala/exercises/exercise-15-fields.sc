
import com.atomicscala.AtomicTest._

// 1. What happens in Cup2’s add method if increase is a negative
//    value? Is any additional code necessary to satisfy the following
//    tests:
//    val cup2 = new Cup2
//    cup2.add(45) is 45
//    cup2.add(-15) is 30
//    cup2.add(-50) is -20

class Cup2 {
  var percentFull = 0
  val max = 100

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    percentFull // Return this value
  }
}

val cup2 = new Cup2
cup2.add(45) is 45
cup2.add(-15) is 30
cup2.add(-50) is -20

// 2. To your solution for Exercise 1, add code to handle negative values
//    to ensure that the total never goes below 0. Satisfy the following
//    tests:
//    val cup3 = new Cup3
//    cup3.add(45) is 45
//    cup3.add(-55) is 0
//    cup3.add(10) is 10
//    cup3.add(-9) is 1
//    cup3.add(-2) is 0

class Cup3 {
  var percentFull = 0
  val max = 100
  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    } else if (percentFull < 0) {
      percentFull = 0
    }
    percentFull // Return this value
  }
}

val cup3 = new Cup3
cup3.add(45) is 45
cup3.add(-55) is 0
cup3.add(10) is 10
cup3.add(-9) is 1
cup3.add(-2) is 0

// 3. Can you set percentFull from outside the class? Try it, like this:
//    cup3.percentFull = 56
//    cup3.percentFull is 56

cup3.percentFull = 56
cup3.percentFull is 56

// 4. Write methods that allow you to both set and get the value of
//    percentFull. Satisfy the following:
//    val cup4 = new Cup4
//    cup4.set(56)
//    cup4.get() is 56

class Cup4 {
  var percentFull = 0
  val max = 100

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    } else if (percentFull < 0) {
      percentFull = 0
    }
    percentFull // Return this value
  }

  def set(n: Int): Unit = {
    percentFull = n
    add(0)
  }

  def get(): Int = {
    percentFull
  }
}

val cup4 = new Cup4
cup4.set(56)
cup4.get() is 56
cup4.set(156)
cup4.get() is 100
cup4.set(-56)
cup4.get() is 0
