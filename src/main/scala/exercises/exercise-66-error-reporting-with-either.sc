
import com.atomicscala.AtomicTest._

// 1. Add explicit return type information to DivZeroEither.scala.

def f(i: Int): Either[String, Int] =
  if (i == 0)
    Left("Divide by zero")
  else
    Right(24 / i)

def test(n: Int): Any =
  f(n) match {
    case Left(why) => s"Failed: $why"
    case Right(result) => result
  }

// 2. Modify TicTacToe.scala from Summary 2 to use Either.

class Cell {
  var entry = ' '

  def set(e: Char): Either[String, Int] = {
    if (entry == ' ' && (e == 'X' || e == 'O')) {
      entry = e
      Right(0) // TODO this could be something more interesting
    } else
      Left("invalid move")
  }
}
class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def play(e: Char, x: Int, y: Int): Either[String, Int] = {
    if (x < 0 || x > 2 || y < 0 || y > 2)
      Left("invalid move")
    else
      cells(x)(y).set(e)
  }
}
val grid = new Grid
grid.play('X', 1, 1) is Right(0) // "successful move"
grid.play('X', 1, 1) is Left("invalid move")
grid.play('O', 1, 3) is Left("invalid move")

// 3. Using the techniques shown in EitherMap.scala, start with the
//    range ‘a’ to ‘z’ and divide it into vowels and consonants. Print the
//    division. Satisfy the following test:
//    letters is "Vector(Left(a), Right(b)," +
//    "Right(c), Right(d), Left(e), Right(f)," +
//    "Right(g), Right(h), Left(i), Right(j)," +
//    "Right(k), Right(l), Right(m), Right(n)," +
//    "Left(o), Right(p), Right(q), Right(r)," +
//    "Right(s), Right(t), Left(u), Right(v)," +
//    "Right(w), Right(x), Right(y), Right(z))"

val vowels = Vector('a','e','i','o','u')
val letters = ('a' to 'z').map(l => if (vowels.contains(l)) Left(l) else Right(l))

letters is "Vector(Left(a), Right(b), " +
"Right(c), Right(d), Left(e), Right(f), " +
"Right(g), Right(h), Left(i), Right(j), " +
"Right(k), Right(l), Right(m), Right(n), " +
"Left(o), Right(p), Right(q), Right(r), " +
"Right(s), Right(t), Left(u), Right(v), " +
"Right(w), Right(x), Right(y), Right(z))"

// 4. Adding to your solution for the previous exercise, write a
//    testLetters method that separates the mapping into Left and Right,
//    as you saw in EitherMap.scala. Satisfy the following tests:
//    testLetters(0) is "Vowel: a"
//    testLetters(4) is "Vowel: e"
//    testLetters(13) is "Consonant: n"

def testLetters(c: Int) = {
  val vowels = Vector('a','e','i','o','u')
  ('a' to 'z')(c) match {
    case l if vowels.contains(l) => s"Vowel: $l"
    case l => s"Consonant: $l"
  }
}

testLetters(0) is "Vowel: a"
testLetters(4) is "Vowel: e"
testLetters(13) is "Consonant: n"
