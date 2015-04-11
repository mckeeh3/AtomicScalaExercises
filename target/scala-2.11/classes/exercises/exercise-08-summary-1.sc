// 1. Store and print an Int value.
val i = 1
println(i)
// 2. Try to change the value. What happened?
// i = 2 // error: reassignment to val

// 3. Create a var and initialize it to an Int, then try reassigning to a
//    Double. What happened?
var n = 1
// n = 1.0 // error: type mismatch;

// 4. Store and print a Double. Did you use type inference? Try declaring
//    the type.
val d1 = 1.1
val d2: Double = 1.2
// 5. What happens if you try to store the number 15 in a Double value?
var d3 = 1.3
d3 = 15
//  6. Store a multiline String (see Data Types) and print it.
val mls =
  """
Line 1
Line 2
  """
println(mls)

// 7. What happens if you try to store the String “maybe” in a Boolean?
// val b: Boolean = "maybe" // error: type mismatch;

// 8. What happens if you try to store the number 15.4 in an Int value?
// val m: Int = 15.4 // error: type mismatch;

// 9. Modify weightStatus in CompoundBMI.scala to produce Unit
//    instead of String.
{
  val lbs = 150.0
  val height = 68.0
  val weightStatus: Unit = {
    val bmi = lbs/(height * height) * 703.07
    if(bmi < 18.5) println("Underweight")
    else if(bmi < 25) println("Normal weight")
    else println("Overweight")
  }
  println(weightStatus)
}

// 10. Modify CompoundBMI.scala to produce an idealWeight based on a
//     BMI of 22.0. Hint:
//     idealWeight = bmi * (height * height) / 703.07
{
  val lbs = 150.0
  val height = 68.0
  val weightStatus = {
    val bmi = lbs / (height * height) * 703.07
    if(bmi < 18.5) "Underweight"
    else if(bmi < 25) "Normal weight"
    else "Overweight"
  }
  println(weightStatus)

  val idealWeight = 22 * (height * height) / 703.07
  println("idealWeight " + idealWeight)
}
