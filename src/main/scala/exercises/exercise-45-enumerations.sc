
import com.atomicscala.AtomicTest._

// 1. Create an enumeration for MonthName, using January, February,
//    etc. Satisfy the following test:
//    MonthName.February is "February"
//    MonthName.February.id is 1

object MonthName extends Enumeration {
  type MonthName = Value
  val January, February, March, April, May, June,
  July, August, September, October, November, December = Value
}

MonthName.February is "February"
MonthName.February.id is 1

// 2. In the previous exercise, an id of 1 isn’t really what we expected
//    for February. We would like that to be 2, since February is the
//    second month. Try explicitly setting January to Value(1) and
//    leaving the others alone. What does that tell you about what Value
//    does? Satisfy the following tests:
//    MonthName2.February is "February"
//    MonthName2.February.id is 2
//    MonthName2.December.id is 12
//    MonthName2.July.id is 7

object MonthName2 extends Enumeration {
  type MonthName2 = Value
  val January = Value(1)
  val February, March, April, May, June,
  July, August, September, October, November, December = Value
}

MonthName2.February is "February"
MonthName2.February.id is 2
MonthName2.December.id is 12
MonthName2.July.id is 7

// 3. Building from the previous exercise, demonstrate how you can use
//    import so you don’t have to qualify the name space. Create a
//    method monthNumber that returns the appropriate value. Satisfy
//    the following tests:
//    July is "July"
//    monthNumber(July) is 7

object MonthName3 extends Enumeration {
  type MonthName3 = Value
  val January = Value(1)
  val February, March, April, May, June,
  July, August, September, October, November, December = Value

  def monthNumber(monthName: MonthName3) = {
    monthName.id
  }
}

import MonthName3._
July is "July"
monthNumber(MonthName3.July) is 7

// 4. Create a method season that takes a MonthName type (from
//    Exercise 1) and returns “Winter” if the month is December,
//    January, or February, “Spring” if March, April, or May, “Summer” if
//    June, July, or August, and “Autumn” if September, October, or
//    November. Satisfy the following tests:
//    season(January) is "Winter"
//    season(April) is "Spring"
//    season(August) is "Summer"
//    season(November) is "Autumn"

// get compile error when monthName parameter is type MonthName3 vs. MonthName3.MonthName3
def season(monthName: MonthName3.MonthName3) = {
  monthName.id match {
    case m if m == 12 || m == 1 || m == 2 => "Winter"
    case m if m >= 3 && m <= 5 => "Spring"
    case m if m >= 6 && m <= 8 => "Summer"
    case m if m >= 9 && m <= 11 => "Autumn"
    case _ => "Invalid month"
  }
}
season(January) is "Winter"
season(April) is "Spring"
season(August) is "Summer"
season(November) is "Autumn"

// 5. Modify TicTacToe.scala from Summary 2 to use enumerations.

object CellState extends Enumeration {
  type CellState = Value
  val Open, X, O = Value
}
CellState.Open is "Open"
CellState.X is "X"
CellState(1) is CellState.X
CellState.O is "O"
CellState(2) is CellState.O

class Cell(var entry: CellState.CellState = CellState.Open) {
  def set(e: CellState.CellState): String = {
    if (entry == CellState.Open && (e == CellState.X || e == CellState.O)) {
      entry = e
      "successful move"
    } else
      "invalid move"
  }
}
class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )
  def play(e: CellState.CellState, x: Int, y: Int): String = {
    if (x < 0 || x > 2 || y < 0 || y > 2)
      "invalid move"
    else
      cells(x)(y).set(e)
  }
}

val grid = new Grid
grid.play(CellState.X, 1, 1) is "successful move"
grid.play(CellState.X, 1, 1) is "invalid move"
grid.play(CellState.O, 1, 3) is "invalid move"

// 6. Modify the Level enumeration code from Level.scala. Create a new
//    val and add another set of values for “Draining, Pooling, and Dry”
//    to the Level enumeration. Update the code on lines 14-28 as
//    necessary. Satisfy the following tests:
//    Level.Draining is Draining
//    Level.Draining.id is 5
//    checkLevel(Low) is "Level Low OK"
//    checkLevel(Empty) is "Alert"
//    checkLevel(Draining) is "Level Draining OK"
//    checkLevel(Pooling) is "Warning!"
//    checkLevel(Dry) is "Alert"

object Level extends Enumeration {
  type Level = Value
  val Overflow, High, Medium, Low, Empty = Value
  val Draining, Pooling, Dry = Value
}
Level.Draining is "Draining"
// problems with Enumeration import in work sheet
//import Level._
//Draining is "Draining"

{ for(n <- Range(0, Level.maxId))
  yield (n, Level(n)) } is
  Vector((0, Level.Overflow), (1, Level.High), (2, Level.Medium),
    (3, Level.Low), (4, Level.Empty), (5, Level.Draining),
    (6, Level.Pooling), (7, Level.Dry))

{ for(lev <- Level.values)
  yield lev }.toIndexedSeq is
  Vector(Level.Overflow, Level.High, Level.Medium, Level.Low,
    Level.Empty, Level.Draining, Level.Pooling, Level.Dry)

def checkLevel(level:Level.Level)= level match {
  case Level.Overflow => ">>> Overflow!"
  case Level.Empty => "Alert"
  case other =>  s"Level $level OK"
}
def checkLevel1(level:Level.Level)= level match {
  case Level.Draining => ">>> Draining!"
  case Level.Dry => "Alert: Dry"
  case other =>  s"Level $level OK"
}
//Level.Draining is Draining
Level.Draining.id is 5
checkLevel(Level.Low) is "Level Low OK"
checkLevel(Level.Empty) is "Alert"
checkLevel(Level.Draining) is "Level Draining OK"
checkLevel(Level.Pooling) is "Warning!"
checkLevel(Level.Dry) is "Alert"
