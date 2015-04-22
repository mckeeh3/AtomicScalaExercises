
import com.atomicscala.AtomicTest._

// 1. Create a ServingKitchen, where you just serve food, and a
//    PrepKitchen, where you prepare food. Satisfy the following tests:
//    val serving = new ServingKitchen
//    serving.serveFood is true
//    val prep = new PrepKitchen
//    prep.prepFood is true

trait Kitchen {
  def serveFood: Boolean
  def prepFood: Boolean
}

class ServingKitchen1 extends Kitchen {
  override def serveFood: Boolean = true
  override def prepFood: Boolean = false
}

class PrepKitchen1 extends Kitchen {
  override def serveFood: Boolean = false
  override def prepFood: Boolean = true
}

val serving1 = new ServingKitchen1
serving1.serveFood is true
val prep1 = new PrepKitchen1
prep1.prepFood is true

// 2. Adding to your solution above, define abstract methods for
//    serveFood and prepFood in Kitchen. Satisfy the following tests:
//    val serving = new ServingKitchen
//    serving.serveFood is true
//    serving.prepFood is false
//    val prep = new PrepKitchen
//    prep.prepFood is true
//    prep.serveFood is false
//    val simple = new SimpleKitchen
//    simple.serveFood is true
//    simple.prepFood is true

class ServingKitchen2 extends Kitchen {
  override def serveFood: Boolean = true
  override def prepFood: Boolean = false
}

class PrepKitchen2 extends Kitchen {
  override def serveFood: Boolean = false
  override def prepFood: Boolean = true
}

class SimpleKitchen2 extends Kitchen {
  override def serveFood: Boolean = true
  override def prepFood: Boolean = true
}

val serving2 = new ServingKitchen2
serving2.serveFood is true
serving2.prepFood is false
val prep = new PrepKitchen2
prep.prepFood is true
prep.serveFood is false
val simple2 = new SimpleKitchen2
simple2.serveFood is true
simple2.prepFood is true

// 3. Adding to your solution for the previous exercise, add Utensils to
//    the Kitchens. Satisfy the following tests:
//    val serving = new ServingKitchen
//    serving.serveFood is true
//    serving.prepFood is false
//    serving.utensils is "Vector(ServeUtensils)"
//    val prep = new PrepKitchen
//    prep.prepFood is true
//    prep.serveFood is false
//    prep.utensils is "Vector(PrepUtensils)"
//    val simple = new SimpleKitchen
//    simple.serveFood is true
//    simple.prepFood is true
//    simple.utensils is
//    "Vector(ServeUtensils, PrepUtensils)"

trait Utensils {
  override def toString = getClass.getSimpleName
}
class ServeUtensils extends Utensils
class PrepUtensils extends Utensils

trait Kitchen3 {
  def serveFood: Boolean
  def prepFood: Boolean
  def utensils: Vector[Utensils]
}

class ServingKitchen3 extends Kitchen3 {
  override def serveFood: Boolean = true
  override def prepFood: Boolean = false
  override def utensils: Vector[Utensils] = Vector(new ServeUtensils)
}

class PrepKitchen3 extends Kitchen3 {
  override def serveFood: Boolean = false
  override def prepFood: Boolean = true
  override def utensils: Vector[Utensils] = Vector(new PrepUtensils)
}

class SimpleKitchen3 extends Kitchen3 {
  override def serveFood: Boolean = true
  override def prepFood: Boolean = true
  override def utensils: Vector[Utensils] =
    Vector(new ServeUtensils, new PrepUtensils)
}

val serving3 = new ServingKitchen3
serving3.serveFood is true
serving3.prepFood is false
serving3.utensils is "Vector(ServeUtensils)"
val prep3 = new PrepKitchen3
prep3.prepFood is true
prep3.serveFood is false
prep3.utensils is "Vector(PrepUtensils)"
val simple3 = new SimpleKitchen3
simple3.serveFood is true
simple3.prepFood is true
simple3.utensils is "Vector(ServeUtensils, PrepUtensils)"
