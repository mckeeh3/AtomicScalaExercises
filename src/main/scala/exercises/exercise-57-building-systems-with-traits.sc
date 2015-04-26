
import com.atomicscala.AtomicTest._
import exercise57.Syrup._

// 1. Rewrite Coffee.scala from Constructors using traits. Satisfy the
//    following tests:
//    val single = new Coffee(Single, Caf,
//      Here, Skim, Choc)
//    single is
//      "Coffee(Single,Caf,Here,Skim,Choc)"
//    val usual = new Coffee(Double, Caf,
//      Here, NoMilk, NoFlavor)
//    usual is
//      "Coffee(Double,Caf,Here,NoMilk,NoFlavor)"
//    val mocha = new Coffee(Double, HalfCaf,
//      ToGo, Skim, Choc)
//    mocha is
//      "Coffee(Double,HalfCaf,ToGo,Skim,Choc)"

object Shots extends Enumeration {
  type Shots = Value
  val Single, Double = Value
}
import Shots._

object Caffeine extends Enumeration {
  type Caffeine = Value
  val Caf, Decaf, HalfCaf = Value
}
import Caffeine._

object Where extends Enumeration {
  type Where = Value
  val Here, ToGo = Value
}
import Where._

object Cream extends Enumeration {
  type Cream = Value
  val NoMilk, Milk, Skim = Value
}
import Cream._

object Syrup extends Enumeration {
  type Syrup = Value
  val NoFlavor, Choc = Value
}
import Syrup._

class Coffee(val shots: Shots = Single,
             val caffeine: Caffeine = Caf,
             val where: Where = Here,
             val cream: Cream = NoMilk,
             val syrup: Syrup = NoFlavor) {
  println(shots, caffeine, cream, where, syrup)

  override def toString = s"${getClass.getSimpleName}" +
    s"($shots,$caffeine,$where,$cream,$syrup)"
}

val single = new Coffee(Single, Caf, Here, Skim, Choc)
single is "Coffee(Single,Caf,Here,Skim,Choc)"
val usual = new Coffee(Double, Caf, Here, NoMilk, NoFlavor)
usual is "Coffee(Double,Caf,Here,NoMilk,NoFlavor)"
val mocha = new Coffee(Double, HalfCaf, ToGo, Skim, Choc)
mocha is "Coffee(Double,HalfCaf,ToGo,Skim,Choc)"

// 2. Assume a latte is a coffee with milk. Create a new class Latte.
//    Simplify the Milk trait to remove NoMilk. Coffee should no longer
//    take Milk as a class argument. Did you implement Coffee as a
//    trait? Why or why not? Satisfy the following tests:
//    val latte = new Latte(Single, Caf,
//      Here, Skim)
//    latte is "Latte(Single,Caf,Here,Skim)"
//    val usual = new Coffee(Double, Caf, Here)
//    usual is "Coffee(Double,Caf,Here)"

class Coffee2(val shots: Shots = Single,
              val caffeine: Caffeine = Caf,
              val where: Where = Here,
              val syrup: Syrup = NoFlavor) {
  override def toString = s"${getClass.getSimpleName}" +
    s"($shots,$caffeine,$where)" +
    (if (syrup == NoFlavor) "" else s"$syrup")
}

class Latte(val shots: Shots = Single,
             val caffeine: Caffeine = Caf,
             val where: Where = Here,
             val cream: Cream = NoMilk,
             val syrup: Syrup = NoFlavor) {
  println(shots, caffeine, cream, where, syrup)

  override def toString = s"${getClass.getSimpleName}" +
    s"($shots,$caffeine,$where,$cream)"
}

val latte = new Latte(Single, Caf, Here, Skim)
latte is "Latte(Single,Caf,Here,Skim)"
val usual2 = new Coffee2(Double, Caf, Here)
usual2 is "Coffee2(Double,Caf,Here)"

// 3. A mocha is a variant of a latte, with chocolate. Satisfy the
//    following tests:
//    val mocha = new Mocha(Double,Caf,ToGo,Skim)
//    mocha is "Mocha(Double,Caf,ToGo,Skim,Choc)"

class Mocha(shots: Shots = Single,
            caffeine: Caffeine = Caf,
            where: Where = Here,
            cream: Cream = NoMilk)
  extends Latte(shots, caffeine, where, cream, Choc) {
  override def toString = s"${getClass.getSimpleName}" +
    s"($shots,$caffeine,$where,$cream,$syrup)"
}

val mocha3 = new Mocha(Double,Caf,ToGo,Skim)
mocha3 is "Mocha(Double,Caf,ToGo,Skim,Choc)"

// 4. What does Topping do in the MaltShoppe example? What happens
//    if you remove it? What do you lose?

// Topping provides for a variety of specific topping implementations
// based on the se of the Topping trait.

import com.atomicscala.AtomicTest._
import exercise57._ //Sodafountain._
import Quantity._
import Holder._
import Syrup._
import IceCream._
import Sprinkle._

case class Scoops(holder: Holder, scoops: Scoop*)

val iceCreamCone = Scoops(WaffleCone, Scoop(Extra, MochaFudge), Scoop(Extra, ButterPecan), Scoop(Extra, IceCream.Chocolate))

iceCreamCone is "Scoops(WaffleCone," +
  "WrappedArray(Scoop(Extra,MochaFudge), " +
  "Scoop(Extra,ButterPecan), " +
  "Scoop(Extra,Chocolate)))"

case class MadeToOrder(holder: Holder, scoops: Seq[Scoop], toppings: Seq[Topping])

val iceCreamDish = MadeToOrder(Bowl, Seq(Scoop(Regular, Strawberry), Scoop(Regular, ButterPecan)), Seq[Topping]())

iceCreamDish is "MadeToOrder(Bowl," +
  "List(Scoop(Regular,Strawberry), " +
  "Scoop(Regular,ButterPecan)),List())"

case class Sundae(sauce: Sauce, sprinkles: Sprinkles, whipped: WhippedCream, nuts: Nuts, scoops: Scoop*) {
  val holder: Holder = Bowl
}

val hotFudgeSundae = Sundae(
  Sauce(Regular, HotFudge),
  Sprinkles(Regular, Sprinkle.Chocolate),
  WhippedCream(Regular), Nuts(Regular),
  Scoop(Regular, Coffee),
  Scoop(Regular, RumRaisin))

hotFudgeSundae is "Sundae(" +
  "Sauce(Regular,HotFudge)," +
  "Sprinkles(Regular,Chocolate)," +
  "WhippedCream(Regular),Nuts(Regular)," +
  "WrappedArray(Scoop(Regular,Coffee), " +
  "Scoop(Regular,RumRaisin)))"
