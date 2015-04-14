
import com.atomicscala.AtomicTest._

// 1. Modify DisplayVectorWithAnonymous.scala to store results in a
//    String, as in DisplayDuckTestable.scala. Satisfy the following test:
//    str is "1234"

var str = ""
val v = Vector(1, 2, 3, 4)
v.foreach(n => str += n)

str is "1234"

// 2. Working from your solution to the exercise above, add a comma
//    between each number. Satisfy the following test:
//    str is "1,2,3,4,"

str = ""
v.foreach(n => str += n + ",")

str is "1,2,3,4,"

// 3. Create an anonymous function that calculates age in “dog years”
//    (by multiplying years by 7). Assign it to a val and then call your
//    function. Satisfy the following test:
//    val dogYears = // Your function here
//    dogYears(10) is 70

val dogYears = (y: Int) => y * 7

dogYears(10) is 70

// 4. Create a Vector and append the result of dogYears to a String for
//    each value in the Vector. Satisfy the following test:
//    var s = ""
//    val v = Vector(1, 5, 7, 8)
//    v.foreach(/* Fill this in */)
//    s is "7 35 49 56 "

var s = ""
val v4 = Vector(1, 5, 7, 8)
v4.foreach((n: Int) => s += dogYears(n) + " ")

s is "7 35 49 56 "

// 5. Repeat Exercise 4 without using the dogYears method:
//    var s = ""
//    val v = Vector(1, 5, 7, 8)
//    v.foreach(/* Fill this in */)
//    s is "7 35 49 56 "

s = ""
val v5 = Vector(1, 5, 7, 8)
v5.foreach((n: Int) => s += ((y: Int) => y * 7)(n) + " ")

s is "7 35 49 56 "

// 6. Create an anonymous function with three arguments
//    (temperature, low, and high). The anonymous function will return
//    true if the temperature is between high and low, and false
//    otherwise. Assign the anonymous function to a def and then call
//    your function. Satisfy the following tests:
//    between(70, 80, 90) is false
//    between(70, 60, 90) is true

val between = (temperature: Int, low: Int, high: Int) =>
  temperature >= low && temperature <= high

between(70, 80, 90) is false
between(70, 60, 90) is true

// 7. Create an anonymous function to square a list of numbers. Call the
//    function for every element in a Vector, using foreach. Satisfy the
//    following test:
//    var s = ""
//    val numbers = Vector(1, 2, 5, 3, 7)
//    numbers.foreach(/* Fill this in */)
//    s is "1 4 25 9 49 "

s = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(n => s += ((x: Int) => x * x)(n) + " ")

s is "1 4 25 9 49 "


// 8. Create an anonymous function and assign it to the name pluralize.
//    It should construct the (simple) plural form of a word by just
//    adding an “s.” Satisfy the following tests:
//    pluralize("cat") is "cats"
//    pluralize("dog") is "dogs"
//    pluralize("silly") is "sillys"

val pluralize = (w: String) => w + "s"

pluralize("cat") is "cats"
pluralize("dog") is "dogs"
pluralize("silly") is "sillys"

// 9. Use pluralize from the previous exercise. Use foreach on a Vector
//    of Strings and print the plural form of each word. Satisfy the
//    following test:
//    var s = ""
//    val words = Vector("word", "cat", "animal")
//    words.foreach(/* Fill this in */)
//    s is "words cats animals "

s = ""
val words = Vector("word", "cat", "animal")
words.foreach(w => s += pluralize(w) + " ")

s is "words cats animals "
