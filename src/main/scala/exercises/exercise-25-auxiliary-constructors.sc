
import com.atomicscala.AtomicTest._

// 1. Create a class called ClothesWasher with a default constructor and
//    two auxiliary constructors, one that specifies model (as a String)
//    and one that specifies capacity (as a Double).

class ClothesWasher(val model: String, val capacity: Double) {
  def this(model: String) {
    this(model, 10)
  }

  def this(capacity: Double) {
    this(model = "", capacity = capacity)
  }
}

val clothesWasher1 = new ClothesWasher("model1", 100)
clothesWasher1.model is "model1"
clothesWasher1.capacity is 100

val clothesWasher2 = new ClothesWasher("model2")
clothesWasher2.model is "model2"
clothesWasher2.capacity is 10

val clothesWasher3 = new ClothesWasher(50)
clothesWasher3.model is ""
clothesWasher3.capacity is 50

// 2. Create a class ClothesWasher2 that looks just like your solution for
//    Exercise 1, but use named and default arguments instead so you
//    produce the same results with just a default constructor.

class ClothesWasher2(val model: String = "none", val capacity: Double = 10) {}

val clothesWasher4 = new ClothesWasher2("model1", 100)
clothesWasher4.model is "model1"
clothesWasher4.capacity is 100

val clothesWasher5 = new ClothesWasher2("model2")
clothesWasher5.model is "model2"
clothesWasher5.capacity is 10

val clothesWasher6 = new ClothesWasher2(capacity = 50.0)
clothesWasher6.model is "none"
clothesWasher6.capacity is 50

// 3. Show that the first line of an auxiliary constructor must be a call to
//    the primary constructor.

class ClothesWasher4(val model: String, val capacity: Double) {
  def this(model: String) {
    this(model, 10)
  }
  def this(capacity: Double){
    // println(capacity) // causes compile error
    this(model = "", capacity = capacity)
  }
}

// 4. Recall from Overloading that methods can be overloaded in Scala,
//    and that this is different from the way that we overload
//    constructors (writing auxiliary constructors). Add two methods to
//    your solution for Exercise 1 to show that methods can be
//    overloaded. Satisfy the following tests:
//    val washer =
//      new ClothesWasher3("LG 100", 3.6)
//    washer.wash(2, 1) is
//      "Wash used 2 bleach and 1 fabric softener"
//    washer.wash() is "Simple wash"

class ClothesWasher3(val model: String, val capacity: Double) {
  def this(model: String) {
    this(model, 10)
  }

  def this(capacity: Double) {
    this(model = "", capacity = capacity)
  }

  def wash(): String = {
    "Simple wash"
  }

  def wash(arg1: Int = 0): String = {
    s"Simple wash $arg1"
  }

  def wash(arg1: Int, arg2: Int): String = {
    s"Wash used $arg1 bleach and $arg2 fabric softener"
  }
}

val washer = new ClothesWasher3("LG 100", 3.6)
washer.wash(2, 1) is "Wash used 2 bleach and 1 fabric softener"
washer.wash() is "Simple wash"
