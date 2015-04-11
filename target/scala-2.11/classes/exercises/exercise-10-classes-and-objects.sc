// 1. Create a Range object and print the step value. Create a second
//    Range object with a step value of 2 and then print the step value.
//    What’s different?
val r = Range(0, 1)
println(r.step)

// 2. Create a String object initialized to "This is an experiment" and call
//    the split method on it, passing a space (" ") as the argument to the
//    split method.
val s = "This is an experiment".split(" ")

// 3. Create a String object s1 (as a var) initialized to "Sally". Create a
//    second String object s2 (as a var) initialized to "Sally". Use
//    s1.equals(s2) to determine if the two Strings are equivalent. If they
//    are, print “s1 and s2 are equal”, otherwise print “s1 and s2 are not
//    equal.”
var s1 = "Sally"
var s2 = "Sally"

if (s1.equals(s2)) {
  println("s1 and s2 are equal")
} else {
  println("s1 and s2 are not equal")
}

// 4. Building from Exercise 3, set s2 to "Sam". Do the strings match? If
// they match, print “s1 and s2 are equal.” If they do not match, print
// “s1 and s2 are not equal.” Is s1 still set to "Sally"?

s2 = "Sam"

if (s1.equals(s2)) {
  println("s1 and s2 are equal")
} else {
  println("s1 and s2 are not equal")
}

// 5. Building from Exercise 3, create a String object s3 by calling
//    toUpperCase on s1. Call contentEquals to compare the Strings s1
//    and s3. If they match, print “s1 and s3 are equal.” If they do not
//    match, print “s1 and s3 are not equal.” Hint: use s1.toUpperCase.

val s3 = s1.toUpperCase

if (s1.contentEquals(s3)) {
  println("s1 and s2 are equal")
} else {
  println("s1 and s2 are not equal")
}
