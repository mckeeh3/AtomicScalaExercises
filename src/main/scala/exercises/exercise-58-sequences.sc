
import com.atomicscala.AtomicTest._

// 1. Create a case class that represents a Person in an address book,
//    complete with name and email address. Satisfy the following tests:
//    val p = Person("John", "Smith",
//      "john@smith.com")
//    p.fullName is "John Smith"
//    p.first is "John"
//    p.email is "john@smith.com"

case class Person(first: String, last: String, email: String) {
  def fullName = s"$first $last"
}
val p = Person("John", "Smith", "john@smith.com")
p.fullName is "John Smith"
p.first is "John"
p.email is "john@smith.com"

// 2. Create three Person objects and put them in a Vector named
//    people. Satisfy the following test: people.size is 3
var people = Vector(
  Person("John", "Smith", "john@smith.com"),
  Person("Jane", "Smith", "jane@smith.com"),
  Person("Joe", "Smith", "joe@smith.com")
)

people.size is 3

// 3. Sort the Vector of Person objects by last name to produce a sorted
//    Vector. Hint: Use sortby(_.fieldname), where fieldname is the field
//    that you want to sort by. Satisfy the following tests:
//    val people = Vector(
//    Person("Zach","Smith","zach@smith.com"),
//    Person("Mary", "Add", "mary@add.com"),
//    Person("Sally", "Taylor",
//           "sally@taylor.com"))
//    val sorted = // call sort here
//    sorted is "Vector(" +
//    + "Person(Mary,Add,mary@add.com)," +
//    + "Person(Zach,Smith,zach@smith.com)," +
//    + "Person(Sally,Taylor,sally@taylor.com))"

val people3 = Vector(
Person("Zach","Smith", "zach@smith.com"),
Person("Mary", "Add", "mary@add.com"),
Person("Sally", "Taylor", "sally@taylor.com"))
val sorted = people3.sortBy(_.last) // call sort here
sorted is "Vector(" +
 "Person(Mary,Add,mary@add.com)," +
 " Person(Zach,Smith,zach@smith.com)," +
 " Person(Sally,Taylor,sally@taylor.com))"

// 4. Move the email address to a Contact trait, and mix that in to create
//    a new class Friend. Add Friend objects to a Vector. Sort on the
//    email address. Satisfy the following test (this may require some
//    refactoring):
//    val friends = Vector(
//      new Friend(
//        "Zach", "Smith", "zach@smith.com"),
//      new Friend(
//        "Mary", "Add", "mary@add.com"),
//      new Friend(
//        "Sally","Taylor","sally@taylor.com"))
//    val sorted = // call sort here
//    sorted is "Vector(Mary Add, " +
//    "Zach Smith, Sally Taylor)"

case class Friend(first: String, last: String, email: String) {
  override def toString = s"$first $last"
}
val friends = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally","Taylor","sally@taylor.com"))
val sorted4 = friends.sortWith(_.last < _.last)
sorted4 is "Vector(Mary Add, Zach Smith, Sally Taylor)"

// 5. What if you want to sort on a primary field (e.g., last name) and
//    resolve any “ties” with a secondary field (e.g., first name)? Hint:
//    sortBy is “stable” so if you sort the list first by the tiebreaker and
//    then by the primary field, you will accomplish your goal. Satisfy
//    the following tests:
//    val friends2 = Vector(
//      new Friend(
//        "Zach", "Smith", "zach@smith.com"),
//      new Friend(
//        "Mary", "Add", "mary@add.com"),
//      new Friend(
//        "Sally","Taylor","sally@taylor.com"),
//      new Friend(
//        "Mary", "Smith", "mary@smith.com"))
//    val s1 = // call first sort here
//    val s2 = // sort s1 here
//    s2 is "Vector(Mary Add, Mary Smith, " +
//    "Zach Smith, Sally Taylor)"

val friends2 = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally","Taylor","sally@taylor.com"),
  new Friend("Mary", "Smith", "mary@smith.com"))
val s1 = friends2.sortBy(_.first)
val s2 = s1.sortBy(_.last)
s2 is "Vector(Mary Add, Mary Smith, Zach Smith, Sally Taylor)"

// 6. Sort in a different way than in the previous example. Use the first
//    name as your primary sort key and the last name as your tie
//    breaker. Satisfy the following test:
//    val friends3 = Vector(
//      new Friend(
//        "Zach", "Smith", "zach@smith.com"),
//      new Friend(
//        "Mary", "Add", "mary@add.com"),
//      new Friend(
//        "Sally","Taylor","sally@taylor.com"),
//      new Friend(
//        "Mary", "Smith", "mary@smith.com") )
//    val s3 = // call first sort here
//    val s4 = // sort s1 here
//    s4 is "Vector(Mary Add, Mary Smith, " +
//    "Sally Taylor, Zach Smith)"

val friends3 = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally","Taylor","sally@taylor.com"),
  new Friend("Mary", "Smith", "mary@smith.com"))
val s3 = friends3.sortBy(_.last)
val s4 = s3.sortBy(_.first)
s4 is "Vector(Mary Add, Mary Smith, Sally Taylor, Zach Smith)"
