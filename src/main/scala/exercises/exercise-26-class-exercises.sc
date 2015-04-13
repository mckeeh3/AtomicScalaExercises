
import com.atomicscala.AtomicTest._

// 1. Make a class Dimension that has an integer field height and an
//    integer field width that can be both retrieved and modified from
//    outside the class. Satisfy the following tests:
//    val c = new Dimension(5,7)
//    c.height is 5
//    c.height = 10
//    c.height is 10
//    c.width = 19
//    c.width is 19

class Dimension(var height: Int, var width: Int) { }

val c = new Dimension(5,7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19

// 2. Make a class Info that has a String field name that can be retrieved
//    from outside the class (but not modified) and a String field
//    description that can be both modified and retrieved from outside
//    the class. Satisfy the following tests:
//    val info = new Info("stuff", "Something")
//    info.name is "stuff"
//    info.description is "Something"
//    info.description = "Something else"
//    info.description is "Something else"

class Info(val name: String, var description: String) { }

val info = new Info("stuff", "Something")
info.name is "stuff"
info.description is "Something"
info.description = "Something else"
info.description is "Something else"

// 3. Working from your solution to Exercise 2, modify the Info class to
//    satisfy the following test:
//    info.name = "This is the new name"
//    info.name is "This is the new name"

class Info2(var name: String, var description: String) { }

val info2 = new Info2("stuff", "Something")
info2.name = "This is the new name"
info2.name is "This is the new name"

// 4. Modify SimpleTime (from Named & Default Arguments) to add a
//    method subtract that subtracts one SimpleTime object from
//    another. If the second time is greater than the first, just return
//    zero. Satisfy the following tests:
//    val t1 = new SimpleTime(10, 30)
//    val t2 = new SimpleTime(9, 30)
//    val st = t1.subtract(t2)
//    st.hours is 1
//    st.minutes is 0
//    val st2 = new SimpleTime(10, 30).
//    subtract(new SimpleTime(9, 45))
//    st2.hours is 0
//    st2.minutes is 45
//    val st3 = new SimpleTime(9, 30).
//    subtract(new SimpleTime(10, 0))
//    st3.hours is 0
//    st3.minutes is 0

class SimpleTime(val hours: Int, val minutes: Int) {
  def subtract(time: SimpleTime): SimpleTime = {
    val elapsed = (hours * 60 + minutes) - (time.hours * 60 + time.minutes)

    if (elapsed <= 0) {
      new SimpleTime(0, 0)
    } else {
      new SimpleTime(elapsed / 60, elapsed % 60)
    }
  }
}

val t1 = new SimpleTime(10, 30)
val t2 = new SimpleTime(9, 30)
val st = t1.subtract(t2)
st.hours is 1
st.minutes is 0
val st2 = new SimpleTime(10, 30).subtract(new SimpleTime(9, 45))
st2.hours is 0
st2.minutes is 45
val st3 = new SimpleTime(9, 30).subtract(new SimpleTime(10, 0))
st3.hours is 0
st3.minutes is 0

// 5. Modify your SimpleTime solution to use default arguments for
//    minutes (see Named & Default Arguments). Satisfy the following
//    tests:
//    val anotherT1 =
//    new SimpleTimeDefault(10, 30)
//    val anotherT2 = new SimpleTimeDefault(9)
//    val anotherST =
//    anotherT1.subtract(anotherT2)
//    anotherST.hours is 1
//    anotherST.minutes is 30
//    val anotherST2 = new SimpleTimeDefault(10).
//    subtract(new SimpleTimeDefault(9, 45))
//    anotherST2.hours is 0
//    anotherST2.minutes is 15

class SimpleTimeDefault(val hours: Int, val minutes: Int = 0) {
  def subtract(time: SimpleTimeDefault): SimpleTimeDefault = {
    val elapsed = (hours * 60 + minutes) - (time.hours * 60 + time.minutes)

    if (elapsed <= 0) {
      new SimpleTimeDefault(0)
    } else {
      new SimpleTimeDefault(elapsed / 60, elapsed % 60)
    }
  }
}

val anotherT1 = new SimpleTimeDefault(10, 30)
val anotherT2 = new SimpleTimeDefault(9)
val anotherST = anotherT1.subtract(anotherT2)
anotherST.hours is 1
anotherST.minutes is 30
val anotherST2 = new SimpleTimeDefault(10).subtract(new SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15

// 6. Modify your solution for Exercise 5 to use an auxiliary constructor.
//    Again, satisfy the following tests:
//    val auxT1 = new SimpleTimeAux(10, 5)
//    val auxT2 = new SimpleTimeAux(6)
//    val auxST = auxT1.subtract(auxT2)
//    auxST.hours is 4
//    auxST.minutes is 5
//    val auxST2= new SimpleTimeAux(12).subtract(
//    new SimpleTimeAux(9, 45))
//    auxST2.hours is 2
//    auxST2.minutes is 15

class SimpleTimeAux(val hours: Int, val minutes: Int) {
  def this(hours: Int) {
    this(hours, 0)
  }

  def subtract(time: SimpleTimeAux): SimpleTimeAux = {
    val elapsed = (hours * 60 + minutes) - (time.hours * 60 + time.minutes)

    if (elapsed <= 0) {
      new SimpleTimeAux(0)
    } else {
      new SimpleTimeAux(elapsed / 60, elapsed % 60)
    }
  }
}

val auxT1 = new SimpleTimeAux(10, 5)
val auxT2 = new SimpleTimeAux(6)
val auxST = auxT1.subtract(auxT2)
auxST.hours is 4
auxST.minutes is 5
val auxST2= new SimpleTimeAux(12).subtract(new SimpleTimeAux(9, 45))
auxST2.hours is 2
auxST2.minutes is 15

// 7. Defaulting both hours and minutes in the previous exercise is
//    problematic. Can you see why? Can you figure out how to use
//    named arguments to solve this problem? Did you have to change
//    any code?

class SimpleTimeAux2(val hours: Int = 0, val minutes: Int = 0) {
  def subtract(time: SimpleTimeAux2): SimpleTimeAux2 = {
    val elapsed = (hours * 60 + minutes) - (time.hours * 60 + time.minutes)

    if (elapsed <= 0) {
      new SimpleTimeAux2(0)
    } else {
      new SimpleTimeAux2(elapsed / 60, elapsed % 60)
    }
  }
}

val aux2T1 = new SimpleTimeAux2(10, 5)
val aux2T2 = new SimpleTimeAux2(6)
val aux2ST = aux2T1.subtract(aux2T2)
aux2ST.hours is 4
aux2ST.minutes is 5
val aux2ST2= new SimpleTimeAux2(12).subtract(new SimpleTimeAux2(9, 45))
aux2ST2.hours is 2
aux2ST2.minutes is 15

// Did not see any problems with defaults
