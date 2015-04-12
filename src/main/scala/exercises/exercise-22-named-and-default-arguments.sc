
import com.atomicscala.AtomicTest._

// 1. Define a class SimpleTime that takes two arguments: an Int that
//    represents hours, and an Int that represents minutes. Use named
//    arguments to create a SimpleTime object. Satisfy the following
//    tests:
//    val t = new SimpleTime(hours=5, minutes=30)
//    t.hours is 5
//    t.minutes is 30

class SimpleTime(val hours: Int, val minutes: Int) {}
val t = new SimpleTime(hours=5, minutes=30)
t.hours is 5
t.minutes is 30
// 2. Using the solution for SimpleTime above, default minutes to 0 so
//    you don’t have to specify them. Satisfy the following tests:
//    val t2 = new SimpleTime2(hours=10)
//    t2.hours is 10
//    t2.minutes is 0

class SimpleTime2(val hours: Int = 0, val minutes: Int = 0) {}
val t2 = new SimpleTime2(hours=10)
t2.hours is 10
t2.minutes is 0
// 3. Create a class Planet that has, by default, a single moon. The
//    Planet class should have a name (String) and description (String).
//    Use named arguments to specify the name and description, and a
//    default for the number of moons. Satisfy the following test:
//    val p = new Planet(name = "Mercury",
//      description = "small and hot planet",
//      moons = 0)
//    p.hasMoon is false

class Planet(val name: String, val description: String, val moons: Int = 0) {
  def hasMoon: Boolean = {
    moons > 0
  }
}

val p = new Planet(name = "Mercury",
  description = "small and hot planet",
  moons = 0)
p.hasMoon is false
// 4. Modify your solution for the previous exercise by changing the
//    order of the arguments that you use to create the Planet. Did you
//    have to change any code? Satisfy the following test:
//    val earth = new Planet(moons = 1,
//      name = "Earth",
//      description = "a hospitable planet")
//    earth.hasMoon is true

val earth = new Planet(moons = 1,
  name = "Earth",
  description = "a hospitable planet")
earth.hasMoon is true

// 5. Can you modify your solution for Exercise 2 in Class Arguments to
//    default the mother’s name to “Mom” and the father’s name to
//    “Dad?” Why do you get an error? Hint: Scala does a good job of
//    telling you what the problem is.
//class FlexibleFamily(mother: String = "Mom", father: String, children: String*) {
//  def familySize(): Int = {
//    children.length + 2
//  }
//}
// a parameter section with a `*'-parameter is not allowed to have default arguments

// 6. Demonstrate that named and default arguments can be used with
//    methods. Create a class Item that takes two class arguments: A
//    String for name and a Double for price. Add a method cost which
//    has named arguments for grocery ( Boolean), medication ( Boolean),
//    and taxRate ( Double). Default grocery and medication to false,
//    taxRate to 0.10. In this scenario, groceries and medications are not
//    taxable. Return the total cost of the item by calculating the
//    appropriate tax. Satisfy the following tests:
//    val flour = new Item(name="flour", 4)
//    flour.cost(grocery=true) is 4
//    val sunscreen = new Item(
//      name="sunscreen", 3)
//    sunscreen.cost() is 3.3
//    val tv = new Item(name="television", 500)
//    tv.cost(taxRate = 0.06) is 530

class Item(val name: String, val price: Double) {
  def cost(grocery: Boolean = false, medication: Boolean = false,
           taxRate: Double = 0.10): Double = {
    if (grocery || medication) {
      price
    } else {
      price + taxRate * price
    }
  }
}

val flour = new Item(name = "flour", 4)
flour.cost(grocery = true) is 4
val sunscreen = new Item(name = "sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name = "television", 500)
tv.cost(taxRate = 0.06) is 530
