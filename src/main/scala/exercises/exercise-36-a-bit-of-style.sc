
import com.atomicscala.AtomicTest._

// 1. Create a class Exclaim with a class argument var s:String. Create
//    methods parens and noParens that append an exclamation point
//    to s and return it. Satisfy the following tests:
//    val e = new Exclaim("yes")
//    e.noParens is "yes!"
//    e.parens() is "yes!"

class Exclaim(arg: String) {
  def noParens = s"$arg!"
  def parens() = noParens
}
val e = new Exclaim("yes")
e.noParens is "yes!"
e.parens() is "yes!"

// 2. Building on Exercise 1, change noParens to be a field ( val) instead
//    of a method. Satisfy the following tests:
//    val e2 = new Exclaim2("yes")
//    e2.noParens is "yes!"
//    e2.parens() is "yes!"

class Exclaim2(val arg: String) {
  val noParens = s"$arg!"
  def parens() = noParens
}
val e2 = new Exclaim2("yes")
e2.noParens is "yes!"
e2.parens() is "yes!"

// 3. Refactor your solution to Exercise 1, renaming the class Exclaim3.
//    Remove the method that doesn’t match the conventional style for
//    parentheses in Scala.

class Exclaim3(arg: String) {
  def noParens = s"$arg!"
}

// 4. Add the variable count to the class in the previous exercise.
//    Increment count when someone calls the method that adds an
//    exclamation point. Call that method twice and satisfy the
//    following test:
//    val e4 = new Exclaim4("counting")
//    // Call exclamation method
//    // Call exclamation method again
//    e4.count is 2

class Exclaim4(arg: String) {
  var count = 0
  def noParens = {
    count += 1
    s"$arg!"
  }
}
val e4 = new Exclaim4("counting")
// Call exclamation method
e4.noParens
// Call exclamation method again
e4.noParens
e4.count is 2
