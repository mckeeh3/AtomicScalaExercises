
import com.atomicscala.AtomicTest._

// 1. Use the REPL to create several Vectors, each populated by a
//    different type of data. See how the REPL responds and guess what
//    it means.

val v1 = Vector(1, 2, 3, 4, 5)
val v2 = Vector("one", "two", "three")
val v3 = Vector(1, "two", 3.0, true)

// 2. Use the REPL to see if you can make a Vector containing other
//    Vectors. How can you use such a thing?

val v4 = Vector(v1, v2, v3)

// 3. Create a Vector and populate it with words (which are Strings).
//    Add a for loop that prints each element in the Vector. Now append
//    to a var String to create a sentence. Satisfy the following test:
//    sentence.toString() is
//    "The dog visited the firehouse "

val v5 = Vector("The", "dog", "visited", "the", "firehouse")
var sentence = ""
for (w <- v5) {
  sentence += w+ " "
}
sentence is "The dog visited the firehouse "

// 4. That last space is unexpected. Use String’s replace method to
//    replace “firehouse ” with “firehouse!” Satisfy the following test:
//    theString is
//    "The dog visited the firehouse!"

sentence.replace("firehouse ", "firehouse!") is "The dog visited the firehouse!"

// 5. Building from your solution for Exercise 4, write a for loop that
//    prints each word, reversed. Your output should match:
//    /* Output:
//    ehT
//    god
//    detisiv
//    eht
//    esuoherif
//    */

sentence = ""
for (w <- v5) {
  println(w.reverse)
  sentence += w.reverse + " "
}
sentence is "ehT god detisiv eht esuoherif "

// 6. Write a for loop that prints the words from Exercise 4 in reverse
//    order (last word first, etc.). Your output should match:
//    /* Output:
//    firehouse
//    the
//    visited
//    dog
//    The
//    */

sentence = ""
for (w <- v5.reverse) {
  println(w)
  sentence += w + " "
}
sentence is "firehouse the visited dog The "

// 7. Create and initialize two Vectors, one containing Ints and one
//    containing Doubles. Call the sum, min and max operations on
//    each one.

val v6 = Vector(1, 2, 3, 4, 5)
val v7 = Vector(1.1, 1.2, 1.3, 1.4, 1.5)

v6.sum is 15
v6.min is 1
v6.max is 5
v7.sum is 6.5
v7.min is 1.1
v7.max is 1.5

// 8. Create a Vector containing Strings and apply the sum, min and
//    max operations. Explain the results. One of those methods won’t
//    work. Why?

// v2.sum
v2.min
v2.max

// 9. In For Loops, we added the values in a Range to get the sum. Try
//    calling the sum operation on a Range. Does this do the entire
//    summation in one step?

v1.sum is 15

// 10. List and Set are similar to Vector. Use the REPL to discover their
//     operations and compare them to those of Vector.

val l1 = List(1, 2, 3)
val l2 = List("one", "two", "three")
val l3 = List(1, "two", 3.0, true)

val s1 = Set(1, 2, 3)
val s2 = Set("one", "two", "three")
val s3 = Set(1, "two", 3.0, true)

// 11. Create and initialize a List and Set with words, then print each
//     one. Try the reverse and sorted operations and see what happens.

l2.reverse
l2.sorted

// s2.reverse
// s2.sorted

// 12. Create two Vectors of Int named myVector1 and myVector2, each
//     initialized to 1, 2, 3, 4, 5, 6. Use AtomicTest to show whether they
//     are equivalent.

val myVector1 = Vector(1, 2, 3, 4, 5, 6)
val myVector2 = Vector(1, 2, 3, 4, 5, 6)

myVector1 is myVector2
