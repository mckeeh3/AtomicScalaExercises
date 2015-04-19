
import com.atomicscala.AtomicTest._

// 1. Show that the uniform access principle demonstrated in
//    UniformAccess.scala works when Base is an abstract class.

//trait Base {
abstract class Base {
  def f1: Int
  def f2: Int
  val d1: Int
  val d2: Int
  var d3: Int
  var n = 1
}

class Derived extends Base {
  def f1 = 1
  val f2 = 1
  // Was def, now val
  val d1 = 1
  // Can't do this; must be a val:
  // def d2 = 1
  val d2 = 1
  def d3 = n
  def d3_=(newVal: Int) = n = newVal
}

val d = new Derived
d.d3 is 1 // Calls getter (line 25)
d.d3 = 42 // Calls setter (line 26)
d.d3 is 42

// 2. Does the uniform access principle demonstrated in
//    UniformAccess.scala work when Base is a concrete class? Can you
//    think of a different way to use a setter here? Hint: Look at Base
//    Class Initialization.

// No, Base cannot define val fields without setting values.
// Unless Base has constructor that provides values for all val fields.

// 3. Create a class with a var named internal and a getter and setter for
//    internal named x, and demonstrate that it works.

class Internal  {
  var n = 0
  def internal = n
  def internal_= (i: Int) = n = i
}
val internal = new Internal

internal.internal is 0
internal.internal = 10
internal.internal is 10
