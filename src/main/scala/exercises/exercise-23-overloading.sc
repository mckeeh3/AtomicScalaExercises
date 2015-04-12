
import com.atomicscala.AtomicTest._

// 1. Modify Overloading.scala so the argument lists for all the methods
//    are identical. Observe the error messages.

//class Overloading1 {
//  def f(n: Int): Int = {
//    88
//  }
//
//  def f(n: Int): Int = {
//    n + 2
//  }
//}
// error: method f is defined twice

// 2. Create five overloaded methods that sum their arguments. Create
//    the first with no arguments, the second with one argument, etc.
//    Satisfy the following tests:
//    f() is 0
//    f(1) is 1
//    f(1, 2) is 3
//    f(1, 2, 3) is 6
//    f(1, 2, 3, 4) is 10

def f(): Int = {
  0
}
def f(i1: Int): Int = {
  i1
}
def f(i1: Int, i2: Int): Int = {
  i1 + i2
}
def f(i1: Int, i2: Int, i3: Int): Int = {
  i1 + i2 + i3
}
def f(i1: Int, i2: Int, i3: Int, i4: Int): Int = {
  i1 + i2 + i3 + i4
}

f() is 0
f(1) is 1
f(1, 2) is 3
f(1, 2, 3) is 6
f(1, 2, 3, 4) is 10

// 3. Modify Exercise 2 to define the methods inside of a class.

class Overloading {
  def f(): Int = {
    0
  }
  def f(i1: Int): Int = {
    i1
  }
  def f(i1: Int, i2: Int): Int = {
    i1 + i2
  }
  def f(i1: Int, i2: Int, i3: Int): Int = {
    i1 + i2 + i3
  }
  def f(i1: Int, i2: Int, i3: Int, i4: Int): Int = {
    i1 + i2 + i3 + i4
  }
}

val overloading = new Overloading
overloading.f() is 0
overloading.f(1) is 1
overloading.f(1, 2) is 3
overloading.f(1, 2, 3) is 6
overloading.f(1, 2, 3, 4) is 10

// 4. Modify your solution for Exercise 3 to add a method with the same
//    name and arguments, but a different return type. Does that work?
//    Does it matter if you use an explicit return type or type inference
//    for the return type?

//class Overloading2 {
//  def f(i1: Int): Int = {
//    i1
//  }
//
//  def f(i1: Int): Double = {
//    i1
//  }
//}
// error: method f is defined twice
