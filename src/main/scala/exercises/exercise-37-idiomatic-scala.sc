
import com.atomicscala.AtomicTest._

// 1. Refactor If4.scala and If5.scala from Conditional Expressions.

// If4.scala
val z: Boolean = false

if (z) println("It's true!") else println("It's false")

// If5.scala
val result1 = if (99 > 100) 4 else 42
result1 is 42

// 2. Refactor For.scala from For Loops.

// For.scala
var result2 = ""
for(i <- 0 to 9) result2 += i + " "
result2 is "0 1 2 3 4 5 6 7 8 9 "

result2 = ""
for(i <- 0 until 10) result2 += i + " "
result2 is "0 1 2 3 4 5 6 7 8 9 "

result2 = ""
for(i <- Range(0, 10)) result2 += i + " "
result2 is "0 1 2 3 4 5 6 7 8 9 "

result2 = ""
for(i <- Range(0, 20, 2)) result2 += i + " "
result2 is "0 2 4 6 8 10 12 14 16 18 "

var sum = 0
for(i <- Range(0, 20, 2)) {
  println("adding " + i + " to " + sum)
  sum += i
}
sum is 90

// 3. Refactor CompoundExpressions2.scala from Compound
//    Expressions.

// CompoundExpressions2.scala
val activity = "swimming"
val hour = 10

val isOpen = {
  if(activity == "swimming" || activity == "ice skating") {
    val opens = 9
    val closes = 20
    println(s"Operating hours: $opens  - $closes")
    hour >= opens && hour <= closes
  } else {
    false
  }
}
isOpen is true

// 4. Refactor AddMultiply.scala from Methods. Remove the return type
//    of the method.

// AddMultiply.scala
def addMultiply(x: Int, y: Double, s: String) = {
  println(s)
  (x + y) * 2.1
}

val r2: Double = addMultiply(7, 9, "Inside addMultiply")
println(r2)

def test(x: Int, y: Double, s: String, expected: Double) {
  val result = addMultiply(x, y, s)
  assert(result == expected, s"Expected $expected Got $result")
  println("result: " + result)
}

test(7, 9, "Inside addMultiply", 33.6)

// 5. Refactor CheckTruth.scala from More Conditionals.

// CheckTruth.scala
def checkTruth(exp1: Boolean, exp2: Boolean): String = {
  if (exp1 && exp2) "Both are true"
  else if (!exp1 && !exp2) "Both are false"
  else if (exp1) "First: true, second: false"
  else "First: false, second: true"
}

checkTruth(true || false, true) is "Both are true"
checkTruth(1 > 0 && -1 < 0, 1 == 2) is "First: true, second: false"
checkTruth(1 >= 2, 1 >= 1) is "First: false, second: true"
checkTruth(true && false, false && true) is "Both are false"

// 6. Refactor Dog.scala, Cat.scala and Hamster.scala from Methods
//    Inside Classes.

// Dog.scala
class Dog {
  def bark = "yip!"
}

val dog = new Dog
dog.bark is "yip!"

// Cat.scala
class Cat {
  def meow = "mew!"
}

val cat = new Cat
val m1 = cat.meow
m1 is "mew!"

// Hamster.scala
class Hamster {
  def speak = "squeak!"
  def exercise = speak + " Running on wheel"
}

val hamster = new Hamster
val e1 = hamster.exercise
e1 is "squeak! Running on wheel"

// 7. Refactor ClassArg.scala and VariableClassArgs.scala from Class
//    Arguments.

// ClassArg.scala
class ClassArg(a: Int) {
  println(f)
  def f = a * 10
}

val ca = new ClassArg(19)
ca.f is 190

// VariableClassArgs.scala
class Sum(args: Int*) {
  def result = args.sum
}

new Sum(13, 27, 44).result is 84
new Sum(1, 3, 5, 7, 9, 11).result is 36
