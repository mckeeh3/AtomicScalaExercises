// 1. Rename the package pythagorean using the reverse domain-name
//    standard described above. Build it with scalac, following the
//    previously described steps, and ensure that a directory hierarchy is
//    created on your computer to hold these classes. Revise
//    Import Pythagorean.scala, above, and save as Solution-1.scala.
//    Remember to update the package import to use your new class.
//    Ensure that the tests run properly.

import exercise13._

val rt = new RightTriangle
println(rt.hypotenuse(3,4))
println(rt.area(3,4))
assert(rt.hypotenuse(3,4) == 5)
assert(rt.area(3,4) == 6)
// 2. Add another class EquilateralTriangle to your solution for Exercise
//    1. Create a method area with an argument side (as a Double); look
//    up the formula in Wikipedia. Display a test result and use assert to
//    verify it.

val elt = new EquilateralTriangle
val area = elt.area(5)
println(area)
assert(area > 10.82 && area < 10.83, "area method incorrect")

// 3. Modify Import Pythagorean.scala to use the various different
//    importing methods shown in this atom.

import com.atomicscala.pythagorean._

val equilateralTriangle = new EquilateralTriangle
val rightTriangle = new RightTriangle

// 4. Create your own package containing three trivial classes (just
//    define the classes, don’t give them bodies). Use the techniques in
//    this atom to import one class, two classes, and all classes, and
//    show that you’ve successfully imported them in each case.

val hippo = new Hippo
val lion = new Lion
val monkey = new Monkey
