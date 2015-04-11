// 1. In Exercise 3 of Conditional Expressions, you checked to see if a
//    was less than c, and then if b was less than c. Repeat that exercise
//    but this time use less than or equal.
val a = 1
val b = 5
val c = 5

if (a <= c) {
  println("a is less than c")
} else {
  println("a is not less than c")
}
if (b <= c) {
  println("b is less than c")
} else {
  println("b is not less than c")
}

// 2. Adding to your solution for the previous exercise, check first to see
//    if both a and b are less than or equal to c using a single if. If they
//    are not, then check to see if either one is less than or equal to c. If
//    you set a to 1, b to 5, and c to 5, you should see “both are!” If,
//    instead, you set b to 6, you should see “one is and one isn’t!”

if (a <= c && b <= c) {
  println("Both and b less than or equal to c")
} else {
  if (a <= c) {
    println("a is less than c")
  } else {
    println("a is not less than c")
  }
  if (b <= c) {
    println("b is less than c")
  } else {
    println("b is not less than c")
  }
}

// 3. Modify CompoundExpressions2.scala to add a compound
//    expression for goodTemperature. Pick a temperature (low and
//    high) for each of the activities and determine if you want to do
//    each activity based on both temperature and if a facility is open.
//    Print the results of the comparisons to match the output described
//    below. Do this with the following code, once you define the
//    expression for goodTemperature.
//    val doActivity = isOpen && goodTemperature
//    println(activity + ": " + isOpen + " && " +
//    goodTemperature + " = " + doActivity)
//    /* Output
//    (run 4 times, once for each activity):
//    swimming: false && false = false
//    walking: true && true = true
//    biking: true && false = false
//    couch: true && true = true
//    */

val activity = "swimming"
val hour = 10
val temperature = 80

val goodTemperature = {
  if (activity == "swimming" && temperature >= 80) {
    true
  } else if (activity == "ice skating" && temperature <= 32) {
    true
  } else {
    false
  }
}

val isOpen = {
  if(activity == "swimming" || activity == "ice skating") {
    val opens = 9
    val closes = 20
    println("Operating hours: " + opens + " - " + closes)
    if(hour >= opens && hour <= closes) {
      true
    } else {
      false
    }
  } else {
    false
  }
}

val doActivity = isOpen && goodTemperature
println(activity + ": " + isOpen + " && " + goodTemperature + " = " + doActivity)
println(isOpen)
// 4. Create a compound expression that determines whether to do an
//    activity. For example, do the running activity if the distance is less
//    than 6 miles, the biking activity if the distance is less than 20
//    miles, and the swimming activity if the distance is less than 1
//    mile. You choose, and set up the compound expression. Test
//    against various distances and various activities, and print your
//    results. Here’s some code to get you started.
//    val distance = 9
//    val activity = "running"
//    val willDo = // fill this in
//    /* Output
//    (run 3 times, once for each activity):
//    running: true
//    walking: false
//    biking: true
//    */

val distance = 19
val activity2 = "biking"
val willDo = {
  if (activity2 == "swimming" && distance < 1) {
    true
  } else if (activity2 == "running" && distance < 6) {
    true
  } else if (activity2 == "biking" && distance < 20) {
    true
  } else {
    false
  }
}

println(s"$activity2: $willDo")
