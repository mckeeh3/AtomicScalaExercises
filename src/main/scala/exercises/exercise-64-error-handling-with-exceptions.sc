
import com.atomicscala.AtomicTest._

// 1. Create a method that throws an object of class Exception inside a
//    try block. Pass the constructor for Exception a String argument.
//    Catch the exception inside a catch clause and print the String
//    argument.

val message1 = try {
  throw new Exception("Bang!")
} catch {
  case e: Exception => s"${e.getMessage}"
}

message1 is "Bang!"
// 2. Create a class with a simple method f. Create a var of that class
//    and initialize it to the special pre-defined value null, which means
//    “nothing.” Try to call f using this var. Now wrap the call in a try-
//    catch clause to catch the exception.

class Test2 {
  def f = "ok"
}

val t: Test2 = null
val message2 = try {
  t.f
} catch {
  case e: NullPointerException => "Null pointer exception."
  case e: Exception => "An exception"
}

message2 is "Null pointer exception."
// 3. Create a Vector containing some elements. Try to index outside
//    the range of that Vector. Now write code to catch the exception.

val v3 = Vector(1,2,3)

val message3 = try {
  v3(9)
} catch {
  case e: IndexOutOfBoundsException => s"Index out of bounds, ${e.getMessage}"
}

message3 is "Index out of bounds, 9"

// 4. Inherit your own subclass of Exception. Write a constructor for this
//    class that takes a String argument and stores it inside the base-
//    class Exception object. Write a method that displays the stored
//    String. Create a try-catch clause to test your new exception class.

class Exception4(message: String) extends Exception(message)

val message4 = try {
  throw new Exception4("Boom!")
} catch {
  case e: Exception4 => e.getMessage
}

message4 is "Boom!"

// 5. Create three new subtypes of Exception. Write a method that
//    throws all three. In another method, call the first method but only
//    use a single catch clause that will catch all three types of
//    exception.

class Exception51(message: String) extends Exception(message)
class Exception52(message: String) extends Exception(message)
class Exception53(message: String) extends Exception(message)

def error(whichOne: Int): Unit = {
  whichOne match {
    case 1 => throw new Exception51("1 Boom!")
    case 2 => throw new Exception51("2 Booms!")
    case 3 => throw new Exception51("3 Booms!")
  }
}

val message51 = try {
  error(1)
} catch {
  case e: Exception => e.getMessage
}

val message52 = try {
  error(2)
} catch {
  case e: Exception => e.getMessage
}

val message53 = try {
  error(3)
} catch {
  case e: Exception => e.getMessage
}

message51 is "1 Boom!"
message52 is "2 Booms!"
message53 is "3 Booms!"

// 6. Create a class with two methods, f and g. In g, throw a new type of
//    exception that you define. In f, call g, catch its exception and, in
//    the catch clause, throw a different exception (of a second type that
//    you define). Test your code.

class Exception61(message: String) extends Exception(message)
class Exception62(message: String) extends Exception(message)

class Test6 {
  def f(i: Int): Unit = {
    try {
      g(i)
    } catch {
      case e: Exception62 => throw new Exception61(s"From 62 ${e.getMessage}")
    }
  }
  def g(i: Int): Unit = {
    throw new Exception62("Bam 62!")
  }
}

val message6 = try {
  (new Test6).f(123)
} catch {
  case e: Exception61 => e.getMessage
}

message6 is "From 62 Bam 62!"

// 7. Demonstrate that a derived-class constructor cannot catch
//    exceptions thrown by its base-class constructor.

class Parent(val what: String) {
  throw new Exception(s"$what Failed!")
}

class Child(val why: String) extends Parent(why)

try {
  new Child("who")
} catch {
  case e: Exception => e.getMessage
}

// 8. Create a class called FailingConstructor with a constructor that
//    might fail partway through the construction process and throw an
//    exception. In another method, write code that properly guards
//    against this failure.

class FailingConstructor {
  throw new Exception("Constructor failed!")
}

def test8(i: Int): Any = {
  try {
    new FailingConstructor
  } catch {
    case e: Exception => "As expected, failed with exception"
  }
}

test8(8) is "As expected, failed with exception"

// 9. Create a three-level inheritance hierarchy of exceptions. Now
//    create a base class A with a method f that throws the exception at
//    the base of your hierarchy. Inherit B from A and override f so it
//    throws the exception at level two of your hierarchy. Repeat by
//    inheriting class C from B. Create a C and assign it to an A (this is
//    called “upcasting”), then call f.

class Exception91(message: String) extends Exception(message)
class Exception92(message: String) extends Exception91(message)
class Exception93(message: String) extends Exception92(message)

class A {
  def f(i: Int): Unit = {
    throw new Exception91("91")
  }
}
class B extends A {
  override def f(i: Int): Unit = {
    throw new Exception92("92")
  }
}
class C extends B {
  override def f(i: Int): Unit = {
    throw new Exception93("93")
  }
}

val a: A = new C

val message9 = try {
  a.f(1)
} catch {
  case e: Exception => e.getMessage
}

message9 is "93"
