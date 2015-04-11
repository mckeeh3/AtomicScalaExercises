// 1. Create an expression that initializes feetPerMile to 5280.
val feetPerMile = 5280

// 2. Create an expression that initializes yardsPerMile by dividing
//    feetPerMile by 3.0.
val yardsPerMile = feetPerMile / 3.0

// 3. Create an expression that divides 2000 by yardsPerMile to calculate
//    miles.
val miles1 = 2000 / yardsPerMile

// 4. Combine the above three expressions into a multiline expression
//    that returns miles.
val miles2 = 2000 / (5280 / 3.0)
