
import java.io.File
import com.atomicscala.AtomicTest._
import exercise69.{Fail, CodeListingTry}

import scala.util.{Try, Failure, Success}

// 1. Rewrite ShowListingEither.scala (and other code as necessary) to
//    use Success and Fail.

def listing(name: String) = {
  CodeListingTry(name) match {
    case Success(lines) => lines
    case Failure(error) => Vector(error)
  }
}

val filePath = "exercise68/CodeListingTester.scala"
val filename = new File(getClass.getClassLoader.getResource(filePath).toURI).getPath

listing(filename)(1) is "package exercise68"

// 2. Modify TicTacToe.scala from Summary 2 to use Success and Fail.

class Cell {
  var entry = ' '

  def set(e: Char): Try[String] = {
    if (entry == ' ' && (e == 'X' || e == 'O')) {
      entry = e
      Success("successful move")
    } else
      Fail("invalid move")
  }
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def play(e: Char, x: Int, y: Int): Try[String] = {
    if (x < 0 || x > 2 || y < 0 || y > 2)
      Fail("invalid move")
    else
      cells(x)(y).set(e)
  }
}

val grid = new Grid
grid.play('X', 1, 1) is "successful move"
grid.play('X', 1, 1) is "invalid move"
grid.play('O', 1, 3) is "invalid move"

// 3. Write a method testArgs that takes a variable argument list of
//    tuples, where each tuple contains a Boolean expression and a
//    String message for when the Boolean fails. For each tuple, produce
//    a Success or Failure. Now create a method:
//    f(s:String, i:Int, d:Double)
//    Within the method, call testArgs passing it the following tuples:
//    (s.length > 0, "s must be non-zero length"),
//    (s.length <= 10, "length of s must be <= 10"),
//    (i >= 0, "i must be positive"),
//    (d > 0.1, "d must be > 0.1"),
//    (d < 0.9, "d must be < 0.9")
//    Take the output and filter it so only Failure objects remain. Satisfy
//    the following tests:
//    f("foo", 11, 0.5) is ""
//    f("foobarbazbingo", 11, 0.5) is
//    "Failure(length of s must be <= 10)"
//    f("", 11, 0.5) is
//    "Failure(s must be non-zero length)"
//    f("foo", -11, 0.5) is
//    "Failure(i must be positive)"
//    f("foo", 11, 0.1) is
//    "Failure(d must be > 0.1)"
//    f("foo", 11, 0.9) is
//    "Failure(d must be < 0.9)"

def testArgs(tuples: (Boolean, String)*) = {
  tuples.map(t => if (t._1) Success(t._2) else Fail(t._2))
}
def f(s: String, i: Int, d: Double) = {
  val failures = testArgs(
    (s.length > 0, "s must be non-zero length"),
    (s.length <= 10, "length of s must be <= 10"),
    (i >= 0, "i must be positive"),
    (d > 0.1, "d must be > 0.1"),
    (d < 0.9, "d must be < 0.9")).filter(t => t.isFailure)
  if (failures.isEmpty) "" else failures.head
}

f("foo", 11, 0.5) is ""
f("foobarbazbingo", 11, 0.5) is "Failure(length of s must be <= 10)"
f("", 11, 0.5) is "Failure(s must be non-zero length)"
f("foo", -11, 0.5) is "Failure(i must be positive)"
f("foo", 11, 0.1) is "Failure(d must be > 0.1)"
f("foo", 11, 0.9) is "Failure(d must be < 0.9)"
