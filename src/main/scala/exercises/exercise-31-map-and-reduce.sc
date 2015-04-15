
import com.atomicscala.AtomicTest._

import scala.collection.immutable.VectorBuilder

// 1. Modify SimpleMap.scala so the anonymous function multiplies
//    each value by 11 and adds 10. Satisfy the following tests:
//    val v = Vector(1, 2, 3, 4)
//    v.map(/* Fill this in */) is
//    Vector(21, 32, 43, 54)

val v = Vector(1, 2, 3, 4)
v.map(n => n * 11 + 10) is Vector(21, 32, 43, 54)

// 2. Can you replace map with foreach in the above solution? What
//    happens? Test the result.

// v.foreach(n => n * 11 + 10) is Vector(21, 32, 43, 54)
// No vector is returned

// 3. Rewrite the solution for the previous exercise using for. Was this
//    more or less complex than using map? Which approach has the
//    greater potential for errors?

val vb = new VectorBuilder[Int]
for (n <- v) {
  vb += n * 11 + 10
}

vb.result() is Vector(21, 32, 43, 54)

// 4. Rewrite SimpleMap.scala using a for loop instead of map, and
//    observe the additional complexity this introduces.

val vb4 = new VectorBuilder[Int]
for (i <- v) {
  vb4 += i + 1
}

vb4.result() is Vector(2, 3, 4, 5)

// 5. Rewrite Reduce.scala using for loops.

var sum = 0
for (n <- Vector(1, 10, 100, 1000)) {
  sum += n
}

sum is 1111

// 6. Use reduce to implement a method sumIt that takes a variable
//    argument list and sums those arguments. Satisfy the following
//    tests:
//    sumIt(1, 2, 3) is 6
//    sumIt(45, 45, 45, 60) is 195

def sumIt(a: Int*): Int = {
  a.reduce((sum, n) => sum + n)
}

sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195
