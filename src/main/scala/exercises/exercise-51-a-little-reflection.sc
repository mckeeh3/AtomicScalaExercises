
import com.atomicscala.AtomicTest._

// 1. Call println on an instance of a case class. Now combine the case
//    class with Name and notice the difference. Remember to compile
//    Name.scala and import it.

case class Person(firstName: String, lastName: String)

Person("Douglas", "Adams") is "Person(Douglas,Adams)"

import com.atomicscala.exercise51.Name

case class PersonName(firstName: String, lastName: String) extends Name

PersonName("Arthur", "Dent") is "PersonName"

// 2. Can you use reflection on a class that isn’t a case class? Repeat
//    Exercise 1 using a non- case class.

class Person2(firstName: String, lastName: String)

println(new Person2("Douglas", "Adams"))

import com.atomicscala.exercise51.Name

class PersonName2(firstName: String, lastName: String) extends Name

new PersonName2("Arthur", "Dent") is "PersonName2"

// 3. Comment out the code in Name.scala that replaces the $ with
//    spaces and splits the String, so that you can see what Scala’s
//    reflection returns before our modifications. Repeat Exercise 2 using
//    this new class.

class Person3(firstName: String, lastName: String)

println(new Person3("Douglas", "Adams"))

import com.atomicscala.exercise51.Name3

class PersonName3(firstName: String, lastName: String) extends Name3

new PersonName3("Arthur", "Dent") is "PersonName3"
