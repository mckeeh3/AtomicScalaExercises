
import com.atomicscala.AtomicTest._

// 1. Rewrite DivZeroEither.scala from Error Reporting with Either to use
//    Option instead of Either. Satisfy the following tests:
//    f(4) is Some(6)
//    f(5) is Some(4)
//    f(6) is Some(4)
//    f(0) is None
//    f(24) is Some(1)
//    f(25) is Some(0)

def f(i: Int) =
  if (i == 0)
    None
  else
    Some(24 / i)

f(4) is Some(6)
f(5) is Some(4)
f(6) is Some(4)
f(0) is None
f(24) is Some(1)
f(25) is Some(0)

// 2. Add explicit return types to the previous exercise.

def f2(i: Int): Option[Int] =
  if (i == 0)
    None
  else
    Some(24 / i)

// 3. Modify TicTacToe.scala from Summary 2 to use Option.

class Cell {
  var entry = ' '
  def set(e: Char): Option[String] = {
    if (entry == ' ' && (e == 'X' || e == 'O')) {
      entry = e
      Some("successful move")
    } else
      None
  }
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def play(e: Char, x: Int, y: Int): Option[String] = {
    if (x < 0 || x > 2 || y < 0 || y > 2)
      None
    else
      cells(x)(y).set(e)
  }
}
val grid = new Grid
grid.play('X', 1, 1) is Some("successful move")
grid.play('X', 1, 1) is None
grid.play('O', 1, 3) is None

// 4. Create a method that ensures that its argument is numeric or
//    alphabetical. Return None for any other characters. Satisfy the
//    following tests:
//    alphanumeric(0) is Some(0)
//    alphanumeric('a') is Some('a')
//    alphanumeric('m') is Some('m')
//    alphanumeric('$') is None
//    alphanumeric('Z') is Some('Z')

def alphanumeric(c: Char) = {
  c match {
    case n if (0 to 9).contains(n) => Some(n)
    case x if ('a' to 'z').contains(x) => Some(x)
    case x if ('A' to 'Z').contains(x) => Some(x)
    case _ => None
  }
}

alphanumeric(0) is Some(0)
alphanumeric('a') is Some('a')
alphanumeric('m') is Some('m')
alphanumeric('$') is None
alphanumeric('Z') is Some('Z')
