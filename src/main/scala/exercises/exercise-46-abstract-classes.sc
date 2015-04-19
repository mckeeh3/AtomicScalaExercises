
import com.atomicscala.AtomicTest._

// 1. Modify Animal and its subclasses to also indicate what each
//    animal eats. Satisfy the following tests:
//    val duck = new Duck
//    duck.food is "plants"
//    val cow = new Cow
//    cow.food is "grass"

abstract class Animal {
  def templateMethod = s"The $animal goes $sound"

  def animal: String
  def sound: String
  def food: String
}

class Duck extends Animal {
  def animal = "Duck"
  def sound = "Quack"
  def food = "plants"
}

class Cow extends Animal {
  def animal = "Cow"
  def sound = "Moo"
  def food = "grass"
}

(new Duck).templateMethod is "The Duck goes Quack"
(new Cow).templateMethod is "The Cow goes Moo"

val duck = new Duck
duck.food is "plants"
val cow = new Cow
cow.food is "grass"

// 2. Add new classes for Chicken and Pig. Satisfy the following tests:
//    val chicken = new Chicken
//    chicken.food is "insects"
//    val pig = new Pig
//    pig.food is "anything"

class Chicken extends Animal {
  def animal: String = "Chicken"
  def food: String = "insects"
  def sound: String = "cluck"
}

class Pig extends Animal {
  def animal: String = "Pig"
  def food: String = "anything"
  def sound: String = "oink"
}

val chicken = new Chicken
chicken.food is "insects"
val pig = new Pig
pig.food is "anything"

// 3. Inherit from the Adder class to make it operational. Satisfy the
//    following tests:
//    class NumericAdder(val x:Int)
//    extends Adder(x) {
//    def add(y:Int):Int = // Complete this
//    }
//    val num = new NumericAdder(5)
//    num.add(10) is 15

abstract class Adder(x: Int) {
  def add(y: Int): Int
}

class NumericAdder(val x: Int) extends Adder(x) {
  def add(y: Int): Int = x + y
}

val num = new NumericAdder(5)
num.add(10) is 15

// 4. Can case classes inherit from abstract classes?

abstract class CaseClassBase(numbers: Int*) {
  def sum(): Int
}

case class CaseClass(numbers: Int*) extends CaseClassBase {
  override def sum(): Int = numbers.sum
}

CaseClass(1, 2, 3, 4, 5).sum() is 15

// 5. Inherit a class from Animal and try making an animal method that
//    takes an argument. What happens and why?

class Mutant extends Animal {
  def animal: String = "Mutant"
  def food: String = "waste"
  def sound: String = "ugh"
  def animal(animal: String) = {
    animal
  }
}

(new Mutant).animal("Beast") is "Beast"
