
import com.atomicscala.AtomicTest._
import exercise51.Name

// 1. Write code that verifies the animals/vehicles description in the
//    second paragraph of this atom.

class Animal extends Mobile {
  override def move = s"biological ${super.move}"
}
class Vehicle extends Mobile {
  override def move = s"mechanical ${super.move}"
}
trait Mobile {
  def move = "movement"
  def move(mobile: Mobile): String = move
}

(new Animal).move is "biological movement"
(new Vehicle).move is "mechanical movement"

// 2. Add a draw method to Element. Satisfy the following tests:
//    val e = new Element
//    e.draw is "Drawing the element"
//    val in = new Inert
//    in.draw is "Inert drawing!"
//    val wall = new Wall
//    wall.draw is "Inert drawing!"

class Element extends Name {
  def interact(other: Element) = s"$this interact $other"
  def draw = "Drawing the element"
}

class Inert extends Element {
  override def draw = "Inert drawing!"
}

class Wall extends Inert

val e = new Element
e.draw is "Drawing the element"
val in = new Inert
in.draw is "Inert drawing!"
val wall = new Wall
wall.draw is "Inert drawing!"

// 3. Add a new draw method to Wall (that is, don’t use the Inert draw
//    method). Satisfy the following test:
//    val wall = new Wall
//    wall.draw is "Don't draw on the wall!"

class Wall3 extends Inert {
  override def draw = "Don't draw on the wall!"
}

val wall3 = new Wall3
wall3.draw is "Don't draw on the wall!"

// 4. In the definition of Character on line 39 of Polymorphism.scala, we
//    use a var for the player, and then change the player on line 51. Use
//    a val to accomplish the same thing. Satisfy the following test:
//    class Character(val player:String="None")
//    extends Element
//    // Change the next line
//    class Dragon extends Character
//    val d = new Dragon
//    d.player is "Puff"

class Character(val player: String = "None") extends Element
class Dragon(override val player: String = "Puff") extends Character
val d = new Dragon
d.player is "Puff"

// 5. Does it matter if the class argument to Character is a val or a var?
//    Try whichever one you didn’t use in the solution for the previous
//    exercise. Were there any differences?

class Character5(var player: String = "None") extends Element
class Dragon5(override val player: String = "Puff") extends Character
val d5 = new Dragon5
d5.player is "Puff"

// 6. Add to your solution for the previous exercise. Instead of creating
//    class Dragon by extending class Character and adding in the traits
//    Magic and Flight, simply extend Character and pass in the name.
//    Satisfy the following tests:
//    val d3 = new NoMagicNoFlyingDragon
//    d3.player is "Puff"
//    d3.id is "NoMagicNoFlyingDragon"

class Element6 {
  val id = getClass.getSimpleName
}
class Character6(val player: String = "None") extends Element6
class NoMagicNoFlyingDragon extends Character6("Puff")

val d3 = new NoMagicNoFlyingDragon
d3.player is "Puff"
d3.id is "NoMagicNoFlyingDragon"
