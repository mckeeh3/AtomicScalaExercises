
import com.atomicscala.AtomicTest._

// 1. The Garden Gnome example in Auxiliary Constructors has a show
//    method to display information about a gnome. Rewrite show using
//    String interpolation. Satisfy the following tests:
//    val gnome =
//      new GardenGnome(20.0, 110.0, false)
//    gnome.show() is "20.0 110.0 false true"
//    val bob = new GardenGnome("Bob")
//    bob.show() is "15.0 100.0 true true"

class GardenGnome(val height: Double, val weight: Double, val happy: Boolean) {
  println("Inside primary constructor")
  var painted = true

  def magic(level: Int): String = {
    // "Poof! " + level
    s"Poof! $level"
  }

  def this(height: Double) {
    this(height, 100.0, true)
  }

  def this(name: String) = {
    this(15.0)
    painted is true
  }

  def show(): String = {
    // height + " " + weight + " " + happy + " " + painted
    s"$height $weight $happy $painted"
  }

  def show(level: Int): String = {
    s"${magic(level)} $happy $painted"
  }
}

val gnome = new GardenGnome(20.0, 110.0, false)
gnome.show() is "20.0 110.0 false true"
val bob = new GardenGnome("Bob")
bob.show() is "15.0 100.0 true true"
new GardenGnome(20.0, 110.0, false).show() is "20.0 110.0 false true"
new GardenGnome("Bob").show() is "15.0 100.0 true true"
// 2. Use GardenGnome’s magic method with String Interpolation. Add
//    a method show that takes one parameter, level, and calls
//    magic(level) in place of height and width. Satisfy the following
//    tests:
//    val gnome =
//      new GardenGnome(20.0, 50.0, false)
//    gnome.show(87) is "Poof! 87 false true"
//    val bob = new GardenGnome("Bob")
//    bob.show(25) is "Poof! 25 true true"

val gnome2 = new GardenGnome(20.0, 50.0, false)
gnome2.show(87) is "Poof! 87 false true"
val bob2 = new GardenGnome("Bob")
bob2.show(25) is "Poof! 25 true true"

// 3. Rework your solution for Exercise 1 to display height and weight
//    with labels. Satisfy the following tests:
//    val gnome =
//    new GardenGnome(20.0, 110.0, false)
//    gnome.show() is "height: 20.0 " +
//      "weight: 110.0 happy: false painted: true"
//    val bob = new GardenGnome("Bob")
//    bob.show() is
//      "height: 15.0 weight: 100.0 true true"
class GardenGnome2(val height: Double, val weight: Double, val happy: Boolean) {
  println("Inside primary constructor")
  var painted = true
  def magic(level: Int): String = {
    // "Poof! " + level
    s"Poof! $level"
  }

  def this(height: Double) {
    this(height, 100.0, true)
  }

  def this(name: String) = {
    this(15.0)
    painted is true
  }

  def show(): String = {
    // height + " " + weight + " " + happy + " " + painted
    s"height: $height weight: $weight happy: $happy painted: $painted"
  }

  def show(level: Int): String = {
    s"${magic(level)} $happy $painted"
  }
}

val gnome3 = new GardenGnome2(20.0, 110.0, false)
gnome3.show() is "height: 20.0 weight: 110.0 happy: false painted: true"
val bob3 = new GardenGnome2("Bob")
bob3.show() is "height: 15.0 weight: 100.0 happy: true painted: true"
