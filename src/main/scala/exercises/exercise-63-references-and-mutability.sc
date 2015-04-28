
import com.atomicscala.AtomicTest._

import scala.collection.mutable.ListBuffer

// 1. Create a var reference to an immutable Map and demonstrate
//    what this means (That is, prove that you can’t change its contents,
//    nor append to it. Show that you can rebind the reference). Now
//    create a val reference to a mutable Map and demonstrate what this
//    means.

val mImmutable = Map(1 -> "one")
// mImmutable(1) = "two"

val mMutable = collection.mutable.Map(1 -> "one")
mMutable(1) = "two"
mMutable is Map(1 -> "two")

// 2. Other collections have mutable counterparts. Use ScalaDoc to
//    identify these (Note the names are often different). Create simple
//    examples and mutate them.

val sI = Set(1,2,3)
// remove is not a method of immutable sets

val sM = collection.mutable.Set(1,2,3)
sM.remove(2)
sM is Set(1,3)

// 3. Vector doesn’t have a mutable equivalent. Show what to do when
//    you have a Vector whose contents need to change.

Vector(1,2,3,4) filter(_ != 3) is Vector(1,2,4)
Vector(1,2,3) ++ Vector(3,4,5) is Vector(1,2,3,3,4,5)
Vector(1,2) :+ 3 is Vector(1,2,3)

// 4. Show the difference between the mutable and immutable Set.

// see question 2, some methods in mutable Sets are not available
// in immutable sets

// 5. Your house’s contents can change, perhaps through a remodel or a
//    shopping trip, but it wouldn’t be the same house if you tore it
//    down and put a new one in its place. Your house is mutable. Write
//    code to demonstrate this idea.

case class Item(name: String)
case class Furniture(name: String)
case class Room(name: String,
                var furniture: Vector[Furniture], var items: Vector[Item]) {
  def add(furniture: Furniture) = {
    this.furniture = this.furniture :+ furniture
    this.furniture
  }
  def add(item: Item) = {
    items = items :+ item
    items
  }
  def remove(furniture: Furniture) = {
    this.furniture = this.furniture.filter(_ != furniture)
    this.furniture
  }
  def remove(item: Item) = {
    items = items.filter(_ != item)
    items
  }
}
case class House(rooms: Room*)

val chair = Furniture("chair")
val sofa = Furniture("sofa")
val bed = Furniture("bed")
val chest = Furniture("chest")
val lamp = Furniture("lamp")
val book = Item("book")
val tablet = Item("tablet")
val phone = Item("phone")

val kitchen = Room("kitchen",
  Vector(Furniture("refrigerator"), Furniture("stove"),
    Furniture("microwave"), Furniture("dishwasher")),
  Vector(Item("pot"), Item("pan"), Item("plate"), Item("knife")))
val bedroom1 = Room("bedroom1",
  Vector(chair, lamp, bed, chest),
  Vector(book, phone))
val bedroom2 = Room("bedroom1",
  Vector(chair, lamp, bed, chest),
  Vector(book, phone))

val home = House(kitchen, bedroom1, bedroom2)

bedroom1.add(bed)
bedroom2.add(chair)
bedroom2.remove(book)

kitchen.add(Item("spoon"))
kitchen.remove(Item("knife"))

home.rooms.head.items.find(_ == Item("spoon")) is Some(Item("spoon"))

// 6. Create a class that has both mutable and immutable fields. Is the
//    resulting class mutable or immutable?

case class What(locked: Vector[String],
                unlocked: scala.collection.mutable.HashSet[Int])

val what = What(Vector(""), scala.collection.mutable.HashSet(1,2,3))
what.unlocked += 4

what.unlocked is scala.collection.mutable.HashSet(1,2,3,4)
