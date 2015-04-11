
import com.atomicscala.AtomicTest._

// 1. Create a value of type Range that goes from 0 to 10 (not including
//    10). Satisfy the following tests:
//    val r1 = // fill this in
//    r1 is // fill this in

val r1 = Range(0, 10)
r1 is Range(0, 10)

// 2. Use Range.inclusive to solve the problem above. What changed?

val r2 = Range(0, 10).inclusive
r2 is Range(0, 11)

// 3. Write a for loop that adds the values 0 through 10 (including 10).
//    Sum all the values and ensure that it equals 55. Must you use a var
//    instead of a val? Why? Satisfy the following test:
//    total is 55

var total = 0
for (i <- Range(0, 11)) {
  total += i
}
total is 55

// 4. Write a for loop that adds even numbers between 1 and 10
//    (including 10). Sum all the values and ensure that it equals 30.
//    Hint: this conditional expression determines if a number is even:
//    if (number % 2 == 0)
//    The % (modulo) operator checks to see if there is a remainder
//    when you divide number by 2. Satisfy the following:
//    totalEvens is 30

var totalEvens = 0
for (i <- Range(2, 10, 2).inclusive) {
  totalEvens += i
}
totalEvens is 30

// 5. Write a for loop to add even numbers between 1 and 10 (including
//    10) and odd numbers between 1 and 10. Calculate a sum for the
//    even numbers and a sum for the odd numbers. Did you write two
//    for loops? If so, try rewriting this with a single for loop. Satisfy the
//    following tests:
//    evens is 30
//    odds is 25
//    (evens + odds) is 55

var evens = 0
var odds = 0
for (i <- Range(1, 11)) {
  if (i % 2 == 0) {
    evens += i
  } else {
    odds += i
  }
}
evens is 30
odds is 25

// 6. If you didn’t use Range for Exercise 5, rewrite using Range. If you
//    did use Range, rewrite the for using to or until.

evens = 0
odds = 0
for (i <- 1 until 11) {
  if (i % 2 == 0) {
    evens += i
  } else {
    odds += i
  }
}
evens is 30
odds is 25

// changed until to to for fun
evens = 0
odds = 0
for (i <- 1 to 10) {
  if (i % 2 == 0) {
    evens += i
  } else {
    odds += i
  }
}
evens is 30
odds is 25
