
import com.atomicscala.AtomicTest._

// 1. Write a method max to find the maximum value in a List, without
//    using List’s max method. Satisfy the following tests:
//    val aList = List(10, 20, 45, 15, 30)
//    max(aList) is 45

def max(l: List[Int], m: Int = Int.MinValue): Int = {
  if (l.nonEmpty) {
    max(l.tail, if (l.head > m) l.head else m)
  } else {
    m
  }
}
val aList = List(10, 20, 45, 15, 30)
max(aList) is 45

// 2. Add println statements to RecursiveSum.scala to trace what
//    happens during recursion.

def sumIt(toSum: List[Int], sum: Int = 0): Int = {
  println(toSum, sum)
  if (toSum.isEmpty)
    sum
  else
    sumIt(toSum.tail, sum + toSum.head)
}
sumIt(List(10, 20, 30, 40, 50)) is 150

// 3. In map and reduce, you implemented a method sumIt that used
//    reduce to do a summation. There, you used a variable argument
//    list. Reimplement using a List. Compare this to your solution for
//    Exercise 1, above. Satisfy the following tests:
//    sumIt(List(1, 2, 3)) is 6
//    sumIt(List(45, 45, 45, 60)) is 195

def sumIt3(a: List[Int]): Int = {
  a.reduce((sum, n) => sum + n)
}

sumIt3(List(1, 2, 3)) is 6
sumIt3(List(45, 45, 45, 60)) is 195

// 4. In Reaching into Java, we used a math library method Frequency to
//    calculate the frequency of “cat” in a List of animals. Use a recursive
//    method to do the same thing. Satisfy the following tests:
//    calcFreq(animalList, "cat", 0) is 4
//    calcFreq(animalList, "dog", 0) is 1

val animalList = List("cat","dog","cat","bird","cat","cat","kitten","mouse")

def calcFreq(l: List[String], search: String, found: Int = 0): Int = {
  if (l.nonEmpty) {
    calcFreq(l.tail, search, if (search == l.head) found + 1 else found)
  } else {
    found
  }
}

calcFreq(animalList, "cat", 0) is 4
calcFreq(animalList, "dog", 0) is 1
