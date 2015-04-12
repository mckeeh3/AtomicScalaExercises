
import com.atomicscala.AtomicTest._

// 1. Create a new class Family that takes a variable argument list
//    representing the names of family members. Satisfy the following
//    tests:
//    val family1 = new Family("Mom",
//      "Dad", "Sally", "Dick")
//    family1.familySize() is 4
//    val family2 =
//      new Family("Dad", "Mom", "Harry")
//    family2.familySize() is 3

class Family(members: String*) {
  def familySize(): Int = {
    members.length
  }
}

val family1 = new Family("Mom", "Dad", "Sally", "Dick")
family1.familySize() is 4
val family2 = new Family("Dad", "Mom", "Harry")
family2.familySize() is 3

// 2. Adapt the Family class definition to include class arguments for a
//    mother, father, and a variable number of children. What changes
//    did you have to make? Satisfy the following tests:
//    val family3 = new FlexibleFamily(
//      "Mom", "Dad", "Sally", "Dick")
//    family3.familySize() is 4
//    val family4 =
//      new FlexibleFamily("Dad", "Mom", "Harry")
//    family4.familySize() is 3

class FlexibleFamily(mother: String, father: String, children: String*) {
  def familySize(): Int = {
    children.length + 2
  }
}

val family3 = new FlexibleFamily("Mom", "Dad", "Sally", "Dick")
family3.familySize() is 4
val family4 = new FlexibleFamily("Dad", "Mom", "Harry")
family4.familySize() is 3

// 3. Does it work to leave out the kids altogether? Should you modify
//    your familySize method? Satisfy the following test:
//    val familyNoKids =
//      new FlexibleFamily("Mom", "Dad")
//    familyNoKids.familySize() is 2

val familyNoKids = new FlexibleFamily("Mom", "Dad")
familyNoKids.familySize() is 2

// 4. Can you use a variable argument list for both parents and
//    children?

// No, variable parameter must come last

// 5. Can you put the variable argument list first, and the parents last?

val family5 = new FlexibleFamily(children = "Sally",
  mother = "Mom", father = "Dad")

family5.familySize() is 3

// 6. Fields contained a class Cup2 with a field percentFull. Rewrite that
//    class definition, using a class argument instead of defining a field.

class Cup2(var percentFull: Int = 0) {
  val max = 100
  add(0)

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

val cup21 = new Cup2()
cup21.percentFull is 0
val cup22 = new Cup2(50)
cup22.percentFull is 50
val cup23 = new Cup2(150)
cup23.percentFull is 100
val cup24 = new Cup2(-50)
cup24.percentFull is 0

// 7. Using your solution for Exercise 6, can you get and set the value of
//    percentFull without writing any new methods? Try it!

cup21.percentFull = 150

// 8. Continue working with the Cup2 class. Modify the add method to
//    take a variable argument list. Specify any number of pours
//    (increase) and spills (decrease = increase with a negative value)
//    and return the resulting value. Satisfy the following tests:
//    val cup5 = new Cup5(0)
//    cup5.increase(20, 30, 50,
//      20, 10, -10, -40, 10, 50) is 100
//    cup5.increase(10, 10, -10, 10,
//      90, 70, -70) is 30

class Cup5(adjustments: Int*) {
  val max = 100
  val min = 0
  var percentFull = 0

  for (adjustment <- adjustments) {
    add(adjustment)
  }

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    } else if (percentFull < min) {
      percentFull = min
    }
    percentFull
  }
}

val cup51 = new Cup5()
cup51.percentFull is 0
val cup52 = new Cup5(50, 25, -50)
cup52.percentFull is 25
val cup53 = new Cup5(150, -150, 50)
cup53.percentFull is 50

// 9. Write a method that squares a variable argument list of numbers
//    and returns the sum. Satisfy the following tests:
//    squareThem(2) is 4
//    squareThem(2, 4) is 20
//    squareThem(1, 2, 4) is 21

def squareThem(numbers: Int*): Int = {
  var sum = 0
  for (number <- numbers) {
    sum += number * number
  }
  sum
}

squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21
