
import com.atomicscala.AtomicTest._

// 1. Write code to pair people up to do exercises in a programming
//    seminar. Take the list of attendees and split it into two lists. Use
//    zip to create the pairs. Satisfy the following tests:
//    val people = Vector("Sally Smith",
//      "Dan Jones", "Tom Brown", "Betsy Blanc",
//      "Stormy Morgan", "Hal Goodsen")
//    val group1 = // fill this in
//    val group2 = // fill this in
//    val pairs = // fill this in
//    pairs is Vector(
//      ("Sally Smith","Betsy Blanc"),
//      ("Dan Jones","Stormy Morgan"),
//      ("Tom Brown","Hal Goodsen"))

val people = Vector("Sally Smith",
  "Dan Jones", "Tom Brown", "Betsy Blanc",
  "Stormy Morgan", "Hal Goodsen")
val group1 = for {
  (x, i) <- people.zipWithIndex
  if i < people.length / 2
} yield x
val group2 = for {
  (x, i) <- people.zipWithIndex
  if i >= people.length / 2
} yield x
val pairs = group1 zip group2
pairs is Vector(
  ("Sally Smith", "Betsy Blanc"),
  ("Dan Jones", "Stormy Morgan"),
  ("Tom Brown", "Hal Goodsen"))

// 2. What happens when the initial list is an odd number, so that the
//    groups split into uneven sizes? Try it.

val people2 = Vector("Sally Smith",
  "Dan Jones", "Tom Brown", "Betsy Blanc",
  "Stormy Morgan")
val group21 = for {
  (x, i) <- people2.zipWithIndex
  if i < people2.length / 2
} yield x
val group22 = for {
  (x, i) <- people2.zipWithIndex
  if i >= people2.length / 2
} yield x
val pairs2 = group21 zip group22
pairs2 is Vector(
  ("Sally Smith", "Tom Brown"),
  ("Dan Jones", "Betsy Blanc"))

// 3. Repeat Exercise 1 using a List instead of a Vector. Did you have to
//    make any other modifications?

val people3 = List("Sally Smith",
  "Dan Jones", "Tom Brown", "Betsy Blanc",
  "Stormy Morgan", "Hal Goodsen")
val group31 = for {
  (x, i) <- people.zipWithIndex
  if i < people.length / 2
} yield x
val group32 = for {
  (x, i) <- people.zipWithIndex
  if i >= people.length / 2
} yield x
val pairs3 = group31 zip group32
pairs3 is Vector(
  ("Sally Smith", "Betsy Blanc"),
  ("Dan Jones", "Stormy Morgan"),
  ("Tom Brown", "Hal Goodsen"))
