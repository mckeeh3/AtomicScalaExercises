
import com.atomicscala.AtomicTest._

// 1. Modify Maps.scala so that the numbers are the keys and the
//    strings are the values.

val constants = Map("Pi" -> 3.141, "e" -> 2.718, "phi" -> 1.618)

(for ((k, v) <- constants) yield v -> k) is
  Map(3.141 -> "Pi", 2.718 -> "e", 1.618 -> "phi")

// 2. Maps store information using unique keys. An email address can
//    serve as a unique key. Create a class Name containing firstName
//    and lastName. Create a Map that associates emailAddress (a
//    String) with Name. Satisfy the following test:
//    val m = Map("sally@taylor.com"
//      -> Name("Sally","Taylor"))
//    m("sally@taylor.com") is
//      Name("Sally", "Taylor")

case class Name(firstName: String, lastName: String)

val m = Map("sally@taylor.com" -> Name("Sally","Taylor"))
m("sally@taylor.com") is Name("Sally", "Taylor")

// 3. Adding to your solution for the previous exercise, add Jiminy
//    Cricket to the map, where the email address is
//    “jiminy@cricket.com.” Satisfy the following tests:
//    m2("jiminy@cricket.com") is
//    Name("Jiminy", "Cricket")
//    m2("sally@taylor.com") is
//    Name("Sally", "Taylor")
val m2 = m ++ Map("jiminy@cricket.com" -> Name("Jiminy", "Cricket"))

m2("jiminy@cricket.com") is Name("Jiminy", "Cricket")
m2("sally@taylor.com") is Name("Sally", "Taylor")

// 4. Sets store distinct values. Create a set for the following languages:
//    English, French, Spanish, German, and Chinese. What happens
//    when you try to add Turkish?

val languages = Set("English", "French", "Spanish", "German", "Chinese")
val languages4 = languages + "Turkish"

languages4 is Set("English", "French", "Spanish", "German", "Chinese", "Turkish")

// 5. Adding to your solution for the previous exercise, try to add a
//    language that already exists to the set (for example, French). What
//    happens?

val languages5 = languages + "French"

languages5 is languages

// 6. Remove “Spanish” from a Set containing English, French, Spanish,
//    German, and Chinese. Remove “jiminy@cricket.com” from a Map
//    containing information for Jiminy Cricket, Mary Smith, and Sally
//    Taylor (using the classes defined in Exercise 2). Satisfy the
//    following tests:
//    val set3 = // fill this in
//    set3.size is 4
//    val map3 = // fill this in
//    map3.size is 2

val set3 = languages - "Spanish"
set3.size is 4
val map6 = Map("mary@smith.com" -> Name("Mary","Smith"),
  "sally@taylor.com" -> Name("Sally","Taylor"),
  "jiminy@cricket.com" -> Name("Jiminy", "Cricket"))
val map3 = map6 - "jiminy@cricket.com"
map3.size is 2
