
import com.atomicscala.AtomicTest._

// 1. Modify House5.scala from Composition by adding Enumerations
//    for different types of food and utensils. Use type constraints for
//    Clean and Store as shown in Resilience.scala.

trait Building
trait Room
trait Storage
trait Sink
trait Stockpile
trait Store[T <: Stockpile]
trait Cook[T]
trait Hygienic
trait Clean[T <: Hygienic]

trait FoodGroups extends Hygienic with Stockpile

object Fruits extends Enumeration {
  case class _Val() extends Val with FoodGroups
  type Fruits = Val
  val apples, oranges, bananas, berries, lemons = _Val()
}
import Fruits._

object Vegetables extends Enumeration {
  case class _Val() extends Val with FoodGroups
  type Vegetables = Val
  val spinach, carrots, onions, peppers, broccoli = _Val()
}
import Vegetables._

object Grains extends Enumeration {
  case class _Val() extends Val with FoodGroups
  type Grains = Val
  val wheat, rice, oats, barley, bread, paste = _Val()
}
import Grains._

object Protein extends Enumeration {
  case class _Val() extends Val with FoodGroups
  type Protein = Val
  val chicken, fish, turkey, pork, beef = _Val()
}
import Protein._

object Dairy extends Enumeration {
  case class _Val() extends Val with FoodGroups
  val milk, butter, ghee, yogurt, cheese, cream, iceCream = _Val()
}

trait Food[F <: FoodGroups] extends Store[F] with Clean[F] with Cook[F]

trait Eating extends Hygienic with Stockpile

object Knives extends Enumeration {
  case class _Val() extends Val with Eating
  type Knives = Val
  val boning, butcher, butter, cleaver, tomato, spife, cutter, electric = _Val()
}
import Knives._

object Forks extends Enumeration {
  case class _Val() extends Val with Eating
  type Forks = Val
  val chork, crabFork, knork, pastryFork, spork, splayd, sporf = _Val()
}
import Forks._

object Spoons extends Enumeration {
  case class _Val() extends Val with Eating
  type Spoons = Val
  val egg, measuring, ladle, sause, caviar, desert = _Val()
}
import Spoons._

trait Utensil[E <: Eating] extends Store[E] with Clean[E] with Cook[E]

trait Kitchen extends Room {
  val storage: Storage
  val sinks: Vector[Sink]
  val food: Food[FoodGroups]
  val utensils: Vector[Utensil[Eating]]
}

trait House extends Building {
  val kitchens: Vector[Kitchen]
}

// 2. Modify Constraint.scala so CallF is a method rather than a class.

class WithF {
  def f(n: Int) = n * 11
}

class CallF[T <: WithF](t: T) {
  def g(n: Int) = t.f(n)
}

new CallF(new WithF).g(2) is 22
new CallF(new WithF {
  override def f(n: Int) = n * 7
}).g(2) is 14

def callF[T <: WithF](t: T, n: Int) = t.f(n)
callF(new WithF, 3) is 33

// 3. Would it ever make sense to have a type parameter that specifies
//    an exact type rather than a bounded type? Write code to explore
//    the possibilities and see if you can determine the differences.

class Level1() {
  override def toString = "Level1"
}
class Level2() extends Level1 {
  override def toString = "Level2"
}
class Level3() extends Level2 {
  override def toString = "Level3"
}
def level1(level: Level1) = s"level1($level)"
def level11[L <: Level1](level: L) = s"level11($level)"
def level2(level: Level2) = s"level2($level)"
def level21[L <: Level1](level: L) = s"level21($level)"
def level3(level: Level3) = s"level3($level)"
def level31[L <: Level1](level: L) = s"level31($level)"

level1(new Level1) is "level1(Level1)"
level1(new Level2) is "level1(Level2)"
level1(new Level3) is "level1(Level3)"

level2(new Level2) is "level2(Level2)"
level2(new Level3) is "level2(Level3)"

level3(new Level3) is "level3(Level3)"

level11(new Level1) is "level11(Level1)"
level11(new Level2) is "level11(Level2)"
level11(new Level3) is "level11(Level3)"

level21(new Level2) is "level21(Level2)"
level21(new Level3) is "level21(Level3)"

level31(new Level3) is "level31(Level3)"
