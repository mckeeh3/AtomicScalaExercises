
import com.atomicscala.AtomicTest._

// 1. Refactor the following example. First, remove the intermediate
//    result and satisfy the tests:
//    def assignResult(arg:Boolean):Int = {
//      val result = if(arg) 42 else 47
//      result
//    }
//    assignResult(true) is 42
//    assignResult(false) is 47

def assignResult(arg: Boolean): Int = {
  val result = if (arg) 42 else 47
  result
}
assignResult(arg = true) is 42
assignResult(arg = false) is 47

// 2. Continue the previous exercise by removing unnecessary curly
//    braces. Satisfy the following tests:
//    assignResult2(true) is 42
//    assignResult2(false) is 47

def assignResult2(arg: Boolean): Int =
  if (arg) 42 else 47

assignResult2(arg = true) is 42
assignResult2(arg = false) is 47

// 3. Continue the previous exercise by removing the return type of the
//    method. Note that you had to keep the equals sign. Do you see a
//    downside if you don’t declare the return type? Satisfy the
//    following tests:
//    assignResult3(true) is 42
//    assignResult3(false) is 47

def assignResult3(arg: Boolean) = if (arg) 42 else 47
assignResult3(arg = true) is 42
assignResult3(arg = false) is 47

// 4. Refactor Coffee.scala from Constructors using the techniques in
//    this atom.

class Coffee(val shots: Int = 2,
             val decaf: Boolean = false,
             val milk: Boolean = false,
             val toGo: Boolean = false,
             val syrup: String = "") {
  var result = ""
  println(shots, decaf, milk, toGo, syrup)

  def getCup() =
    if (toGo)
      result += "ToGoCup "
    else
      result += "HereCup "

  def pourShots() =
    for (s <- 0 until shots)
      if (decaf)
        result += "decaf shot "
      else
        result += "shot "

  def addMilk() = if (milk) result += "milk "
  def addSyrup() = result += syrup

  getCup()
  pourShots()
  addMilk()
  addSyrup()
}

new Coffee(syrup = "natural").result is "HereCup shot shot natural"
new Coffee(syrup = "natural", toGo = true).result is "ToGoCup shot shot natural"
new Coffee(syrup = "natural", shots = 3).result is "HereCup shot shot shot natural"
