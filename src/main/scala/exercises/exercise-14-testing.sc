
import com.atomicscala.AtomicTest._

// 1. Create a value named myValue1 initialized to 20. Create a value
//    named myValue2 initialized to 10. Use “is” to test that they do not
//    match.

val myValue1 = 20
val myValue2 = 10
myValue1 is myValue2 + 10

// 2. Create a value named myValue3 initialized to 10. Create a value
//    named myValue4 initialized to 10. Use “is” to test that they do
//    match.

val myValue3 = 10
val myValue4 = 10
myValue3 is myValue4

// 3. Compare myValue2 and myValue3. Do they match?

myValue2 is myValue3

// 4. Create a value named myValue5 initialized to the String “10”.
//    Compare it to myValue2. Does it match?

val myValue5 = "10"
myValue2 is myValue5.toInt

// 5. Use Test Driven Development (write a failing test, and then write
//   the code to fix it) to calculate the area of a quadrangle. Start with
//   the following sample code and fix the intentional bugs:
//   def squareArea(x: Int):Int = { x * x }
//   def rectangleArea(x:Int, y:Int):Int = { x * x }
//   def trapezoidArea(x:Int, y:Int,
//    h:Int):Double = { h/2 * (x + y) }
//    squareArea(1) is 1
//    squareArea(2) is 4
//    squareArea(5) is 25
//    rectangleArea(2, 2) is 4
//    rectangleArea(5, 4) is 20
//    trapezoidArea(2, 2, 4) is 8
//    trapezoidArea(3, 4, 1) is 3.5

def squareArea(x: Int): Int = { x * x }
def rectangleArea(x: Int, y: Int): Int = { x * y }
def trapezoidArea(x: Int, y: Int, h: Int): Double = { h / 2.0 * (x + y) }

squareArea(1) is 1
squareArea(2) is 4
squareArea(5) is 25

rectangleArea(2, 2) is 4
rectangleArea(5, 4) is 20
trapezoidArea(2, 2, 4) is 8
trapezoidArea(3, 4, 1) is 3.5
