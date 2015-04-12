
import com.atomicscala.AtomicTest._

// 1. Create a Vector filled with Chars, one filled with Ints, and one
//    filled with Strings. Sort each Vector and produce the min and max
//    for each. Write a for loop for each sorted Vector that appends its
//    elements, separated by spaces, to a String.

val vChars = Vector('f','i', 'l', 'l', 'e', 'd', 'w', 'i', 't', 'h', 'C', 'h', 'a', 'r', 's')
val vInts = Vector(3, 1, 5, 9, 1, 4, 8, 2)
val vStrings = Vector("and", "one", "filled", "with", "Strings")

var sentence = ""
for (w <- vChars.sorted) {
  sentence += w + " "
}

vChars.min is 'C'
vChars.max is 'w'
sentence is "C a d e f h h i i l l r s t w "
sentence = ""
for (w <- vInts.sorted) {
  sentence += w + " "
}
vInts.min is 1
vInts.max is 9
sentence is "1 1 2 3 4 5 8 9 "
sentence = ""
for (w <- vStrings.sorted) {
  sentence += w + " "
}
vStrings.min is "Strings"
vStrings.max is "with"
sentence is "Strings and filled one with "
// 2. Create a Vector containing all the Vectors from Exercise 1. Write a
//    for loop within a for loop to move through this Vector of Vectors
//    and append all the elements to a single String.
var sentenceChars = ""
for (w <- vChars) {
  sentenceChars += w + " "
}
var sentenceInts = ""
for (w <- vInts) {
  sentenceInts += w + " "
}
var sentenceStrings = ""
for (w <- vStrings) {
  sentenceStrings += w + " "
}
val vAll = Vector(vChars, vInts, vStrings)
sentence = ""
for (v <- vAll) {
  for (w <- v) {
    sentence += w + " "
  }
}
sentence is sentenceChars + sentenceInts + sentenceStrings

// 3. In the REPL, create a single Vector containing a Char, an Int, a
//    String and a Double. What type does this Vector contain? Try to
//    find the max of your Vector. Does this make sense?

val vMixed = Vector('c', 1, "one", 1.0)
// vMixed.max // No implicit Ordering defined for Any.

// 4. Modify BasicMethods.scala so the two methods are part of a class.
//    Put the class in a package and compile it. Import the resulting
//    library into a script and test it.

import com.atomicscala.exercise19.BasicMethods

val basicMethods = new BasicMethods
basicMethods.bang("Hello, World") is "Hello, World!"
basicMethods.cube(3) is 27

// 5. Create a package containing the classes in ClassBodies.scala.
//    Compile this package, then import it into a script. Modify the
//    classes by adding methods that produce results that can be tested
//    with AtomicTest.

import com.atomicscala.exercise19.{NoBody, SomeBody, EveryBody}

val noBody = new NoBody
val someBody = new SomeBody
val everyBody = new EveryBody

noBody.body() is ""
someBody.body() is "Janet Doe"
everyBody.body() is "Janet Doe Janet Doe Janet Doe "

// 6. Add Kelvin temperature units to Temperature.scala (Kelvin is
//    Celsius + 273.15). When writing the new code, call the existing
//    methods whenever possible.

import com.atomicscala.exercise19.Temperature

val temp = new Temperature
temp.setFahrenheit(212)
temp.getCelsius is 100
temp.getKelvin is 373.15

temp.setCelsius(0)
temp.getFahrenheit is 32
temp.getKelvin is 273.15

temp.setKelvin(0)
temp.getCelsius is -273.15
temp.getFahrenheit is -459.66999999999996

// 7. Add a method to TicTacToe.scala that displays the game board
//    (hint: use a for loop within a for loop). Call this method
//    automatically for each move.

import com.atomicscala.exercise19.Grid

var grid = new Grid
grid.play('X', 1, 1) is "successful move"
grid.play('X', 1, 1) is "invalid move"
grid.play('O', 1, 3) is "invalid move"
grid.play('X', 0, 0) is "successful move"
grid.play('O', 2, 2) is "successful move"

// 8. Add a method to TicTacToe.scala that determines if there is a
//    winner or if the game is a draw. Call this method automatically for
//    each move.

grid = new Grid
grid.play('X', 0, 0) is "successful move"
grid.play('X', 0, 1) is "successful move"
grid.play('X', 0, 2) is "X wins"

grid = new Grid
grid.play('X', 1, 0) is "successful move"
grid.play('X', 1, 1) is "successful move"
grid.play('X', 1, 2) is "X wins"

grid = new Grid
grid.play('X', 2, 0) is "successful move"
grid.play('X', 2, 1) is "successful move"
grid.play('X', 2, 2) is "X wins"

grid = new Grid
grid.play('O', 0, 0) is "successful move"
grid.play('O', 1, 0) is "successful move"
grid.play('O', 2, 0) is "O wins"

grid = new Grid
grid.play('O', 0, 1) is "successful move"
grid.play('O', 1, 1) is "successful move"
grid.play('O', 2, 1) is "O wins"

grid = new Grid
grid.play('O', 0, 2) is "successful move"
grid.play('O', 1, 2) is "successful move"
grid.play('O', 2, 2) is "O wins"

grid = new Grid
grid.play('X', 0, 0) is "successful move"
grid.play('X', 1, 1) is "successful move"
grid.play('X', 2, 2) is "X wins"

grid = new Grid
grid.play('O', 0, 2) is "successful move"
grid.play('O', 1, 1) is "successful move"
grid.play('O', 2, 0) is "O wins"

grid = new Grid
grid.play('O', 1, 1) is "successful move"
grid.play('X', 2, 2) is "successful move"
grid.play('O', 0, 1) is "successful move"
grid.play('X', 2, 1) is "successful move"
grid.play('O', 2, 0) is "successful move"
grid.play('X', 1, 0) is "successful move"
grid.play('O', 0, 0) is "successful move"
grid.play('X', 0, 2) is "successful move"
grid.play('O', 1, 2) is "Draw"
