
import com.atomicscala.AtomicTest._

// 1. Create sets for fruits, vegetables, and meats. Create a grocery list,
//    and calculate what percentage of your list is in each category,
//    including an “other” category determined by not matching any
//    category. Satisfy the following tests:
//    val fruits = Set("apple", "orange",
//      "banana", "kiwi")
//    val vegetables = Set("beans", "peas",
//      "carrots", "sweet potatoes",
//      "asparagus", "spinach")
//    val meats = Set("beef", "chicken")
//    val groceryCart = Set("apple",
//      "pretzels", "bread", "orange", "beef",
//      "beans", "asparagus", "sweet potatoes",
//      "spinach", "carrots")
//    percentMeat(groceryCart) is 10.0
//    percentFruit(groceryCart) is 20.0
//    percentVeggies(groceryCart) is 50.0
//    percentOther(groceryCart) is 20.0

val fruits = Set("apple", "orange", "banana", "kiwi")
val vegetables = Set("beans", "peas",
  "carrots", "sweet potatoes",
  "asparagus", "spinach")
val meats = Set("beef", "chicken")
val groceryCart = Set("apple",
  "pretzels", "bread", "orange", "beef",
  "beans", "asparagus", "sweet potatoes",
  "spinach", "carrots")

def percentMeat(cart: Set[String]) = {
  (meats & cart).size / cart.size.toDouble * 100
}
def percentFruit(cart: Set[String]) = {
  (fruits & cart).size / cart.size.toDouble * 100
}
def percentVeggies(cart: Set[String]) = {
  (vegetables & cart).size / cart.size.toDouble * 100
}
def percentOther(cart: Set[String]) = {
  (cart &~ (meats | fruits | vegetables)).size / cart.size.toDouble * 100
}
percentMeat(groceryCart) is 10.0
percentFruit(groceryCart) is 20.0
percentVeggies(groceryCart) is 50.0
percentOther(groceryCart) is 20.0

// 2. Using your solution for Exercise 1, add a set for protein that
//    includes the set for meats, as well as a new set for vegetarian
//    proteins. Satisfy the following tests:
//    val vegetarian = Set("kidney beans",
//      "black beans", "tofu")
//    val groceryCart2 = Set("apple",
//      "pretzels", "bread", "orange", "beef",
//      "beans", "asparagus", "sweet potatoes",
//      "kidney beans", "black beans")
//    percentMeat(groceryCart2) is 10.0
//    percentVegetarian(groceryCart2) is 20.0
//    percentProtein(groceryCart2) is 30.0

val vegetarian = Set("kidney beans", "black beans", "tofu")
val groceryCart2 = Set("apple",
  "pretzels", "bread", "orange", "beef",
  "beans", "asparagus", "sweet potatoes",
  "kidney beans", "black beans")

def percentVegetarian(cart: Set[String]) = {
  (vegetarian & cart).size / cart.size.toDouble * 100
}
def percentProtein(cart: Set[String]) = {
  ((meats | vegetarian) & cart).size / cart.size.toDouble * 100
}
percentMeat(groceryCart2) is 10.0
percentVegetarian(groceryCart2) is 20.0
percentProtein(groceryCart2) is 30.0

// 3. Write code that produces a container of containers of containers.
//    Use flatten to reduce your container to a single-level sequence.
//    Hint: you may want to do this in several steps. Satisfy the
//    following tests:
//    val box1 = Set("shoes", "clothes")
//    val box2 = Set("toys", "dishes")
//    val box3 = Set("toys", "games", "books")
//    val attic = Set(box1, box2)
//    val basement = Set(box3)
//    val house = Set(attic, basement)
//    Set("shoes", "clothes", "toys",
//      "dishes") is attic.flatten
//    Set("toys", "games", "books") is
//      basement.flatten
//    Set("shoes", "clothes", "toys",
//      "dishes", "games", "books") is
//    /* fill this in -- call flatten */

val box1 = Set("shoes", "clothes")
val box2 = Set("toys", "dishes")
val box3 = Set("toys", "games", "books")
val attic = Set(box1, box2)
val basement = Set(box3)
val house = Set(attic, basement)
Set("shoes", "clothes", "toys", "dishes") is attic.flatten
Set("toys", "games", "books") is basement.flatten
Set("shoes", "clothes", "toys", "dishes", "games", "books") is
house.flatten.flatten
