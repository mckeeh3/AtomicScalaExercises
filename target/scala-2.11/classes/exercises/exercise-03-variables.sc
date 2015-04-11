// 1. Create an Int value (val) and set it to 5. Try to update that number
//    to 10. What happened? How would you solve this problem?
val i:Int = 5
// i = 16 // reassignment to val

// 2. Create an Int variable (var) named v1 and set it to 5. Update it to 10
//    and store in a val named constantv1. Did this work? Can you think
//    of how this is useful?
var v1:Int = 5
v1 = 10
val constantv1 = v1

// 3. Using v1 and constantv1 from above, set v1 to 15. Did the value of
//    constantv1 change?
v1 = 15
println(constantv1)

// 4. Create a new Int variable (var) called v2 initialized to v1. Set v1 to
//    20. Did the value of v2 change?
var v2:Int = v1
v1 = 20
println(v2)
