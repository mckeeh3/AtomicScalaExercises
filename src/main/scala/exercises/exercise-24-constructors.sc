
import com.atomicscala.AtomicTest._

// 1. Modify Coffee.scala to specify some caffeinated shots and some
//    decaf shots. Satisfy the following tests:
//    val doubleHalfCaf =
//      new Coffee(shots=2, decaf=1)
//    val tripleHalfCaf =
//      new Coffee(shots=3, decaf=2)
//    doubleHalfCaf.decaf is 1
//    doubleHalfCaf.caf is 1
//    doubleHalfCaf.shots is 2
//    tripleHalfCaf.decaf is 2
//    tripleHalfCaf.caf is 1
//    tripleHalfCaf.shots is 3

class Coffee(val shots: Int = 2,
             var caf: Int = 0,
             val decaf: Int = 0,
             val milk: Boolean = false,
             val toGo: Boolean = false,
             val syrup: String = "") {
  caf = if (caf == 0) shots - decaf else caf
  var result = ""
  println(shots, caf, decaf, milk, toGo, syrup)

  def getCup(): Unit = {
    if (toGo)
      result += "ToGoCup "
    else
      result += "HereCup "
  }

  def pourShots(): Unit = {
    for (s <- 0 until shots - decaf) {
      result += "shot "
    }
    for (s <- 0 until decaf) {
      result += "decaf shot "
    }
  }

  def addMilk(): Unit = {
    if (milk)
      result += "milk "
  }

  def addSyrup(): Unit = {
    result += syrup
  }

  getCup()
  pourShots()
  addMilk()
  addSyrup()
}

val doubleHalfCaf = new Coffee(shots = 2, decaf = 1)
val tripleHalfCaf = new Coffee(shots = 3, decaf = 2)
doubleHalfCaf.decaf is 1
doubleHalfCaf.caf is 1
doubleHalfCaf.shots is 2
tripleHalfCaf.decaf is 2
tripleHalfCaf.caf is 1
tripleHalfCaf.shots is 3

// 2. Create a new class Tea that has 2 methods: describe, which
//    includes information about whether the tea includes milk, sugar,
//    is decaffeinated, and includes the name; and calories, which adds
//    100 calories for milk and 16 calories for sugar. Satisfy the following
//    tests:
//    val tea = new Tea
//    tea.describe is "Earl Grey"
//    tea.calories is 0
//
//    val lemonZinger = new Tea(
//      decaf = true, name="Lemon Zinger")
//    lemonZinger.describe is
//      "Lemon Zinger decaf"
//    lemonZinger.calories is 0
//
//    val sweetGreen = new Tea(
//      name="Jasmine Green", sugar=true)
//    sweetGreen.describe is
//      "Jasmine Green + sugar"
//    sweetGreen.calories is 16
//
//    val teaLatte = new Tea(
//      sugar=true, milk=true)
//    teaLatte.describe is
//      "Earl Grey + milk + sugar"
//    teaLatte.calories is 116

class Tea(name: String = "Earl Grey", decaf: Boolean = false,
          sugar: Boolean = false, milk: Boolean = false) {
  var calories: Int = 0
  if (sugar) calories += 16
  if (milk) calories += 100

  def describe: String = {
    var result = name
    if (decaf) result += " decaf"
    if (milk) result += " + milk"
    if (sugar) result += " + sugar"
    result
  }
}

val tea = new Tea
tea.describe is "Earl Grey"
tea.calories is 0

val lemonZinger = new Tea(decaf = true, name = "Lemon Zinger")
lemonZinger.describe is "Lemon Zinger decaf"
lemonZinger.calories is 0

val sweetGreen = new Tea(name = "Jasmine Green", sugar = true)
sweetGreen.describe is "Jasmine Green + sugar"
sweetGreen.calories is 16

val teaLatte = new Tea(sugar = true, milk = true)
teaLatte.describe is "Earl Grey + milk + sugar"
teaLatte.calories is 116

// 3. Use your solution for Exercise 2 as a starting point. Make decaf,
//    milk, sugar and name accessible outside of the class. Satisfy the
//    following tests:
//    val tea = new Tea2
//    tea.describe is "Earl Grey"
//    tea.calories is 0
//    tea.name is "Earl Grey"
//
//    val lemonZinger = new Tea2(decaf = true,
//      name="Lemon Zinger")
//    lemonZinger.describe is
//      "Lemon Zinger decaf"
//    lemonZinger.calories is 0
//    lemonZinger.decaf is true
//
//    val sweetGreen = new Tea2(
//      name="Jasmine Green", sugar=true)
//    sweetGreen.describe is
//      "Jasmine Green + sugar"
//    sweetGreen.calories is 16
//    sweetGreen.sugar is true
//
//    val teaLatte = new Tea2(sugar=true,
//      milk=true)
//    teaLatte.describe is
//      "Earl Grey + milk + sugar"
//    teaLatte.calories is 116
//    teaLatte.milk is true

class Tea2(val name: String = "Earl Grey", val decaf: Boolean = false,
          val sugar: Boolean = false, val milk: Boolean = false) {
  var calories: Int = 0
  if (sugar) calories += 16
  if (milk) calories += 100

  def describe: String = {
    var result = name
    if (decaf) result += " decaf"
    if (milk) result += " + milk"
    if (sugar) result += " + sugar"
    result
  }
}

val tea2 = new Tea2
tea2.describe is "Earl Grey"
tea2.calories is 0
tea2.name is "Earl Grey"

val lemonZinger2 = new Tea2(decaf = true, name="Lemon Zinger")
lemonZinger2.describe is "Lemon Zinger decaf"
lemonZinger2.calories is 0
lemonZinger2.decaf is true

val sweetGreen2 = new Tea2(name="Jasmine Green", sugar=true)
sweetGreen2.describe is "Jasmine Green + sugar"
sweetGreen2.calories is 16
sweetGreen2.sugar is true

val teaLatte2 = new Tea2(sugar=true, milk=true)
teaLatte2.describe is "Earl Grey + milk + sugar"
teaLatte2.calories is 116
teaLatte2.milk is true
