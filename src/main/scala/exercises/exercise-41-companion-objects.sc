
import com.atomicscala.AtomicTest._

// 1. Create a class WalkActivity that takes no class arguments. Create a
//    companion object with a single method start that has a single
//    argument for a name and prints “started!” Demonstrate how to
//    call this method. Did you have to instantiate the WalkActivity
//    object?

class WalkActivity {
}
object WalkActivity {
  def start(name: String) = println("started!")
}

WalkActivity.start("Jone")

// 2. Building on your solution for the previous exercise, add a field to
//    the companion object to log activities (Hint: Use a var String).
//    Calling start("Sally") should append “[Sally] Activity started.” Also,
//    add a stop method that similarly appends “[Sally] Activity
//    stopped.”

class WalkActivity2 {
}
object WalkActivity2 {
  var log: String = ""
  def start(name: String) = {
    log += s"[$name] Activity started."
    println("started!")
  }
  def stop(name: String) = {
    log += s"[$name] Activity stopped."
    println("stopped!")
  }
}

WalkActivity2.start("Sally")
WalkActivity2.log is "[Sally] Activity started."
WalkActivity2.stop("Sally")
WalkActivity2.log is "[Sally] Activity started.[Sally] Activity stopped."

// 3. Add a field for Metabolic Equivalent of Task (MET) initialized to 2.3.
//    Add the supplied method calories. Where did you put the field?
//    Where did you put the method? If you didn’t put them in the
//    companion object, do so now. Did you have to make any changes
//    to do so? Satisfy the following tests:
//    def calories(lbs:Int, mins:Int,
//      mph:Double=3):Long = math.round(
//        (MET * 3.5 * lbs * 0.45)/200.0 * mins
//      )
//    val sally = new WalkActivity3
//    sally.calories(150, 30) is 82

object WalkActivity3 {
  val MET = 2.3
  def calories(lbs: Int, mins: Int, mph: Double = 3): Long =
    math.round((MET * 3.5 * lbs * 0.45) / 200.0 * mins)
}
class WalkActivity3 {
  def calories(lbs: Int, mins: Int, mph: Double = 3) = {
    WalkActivity3.calories(lbs, mins, mph)
  }
}

val sally = new WalkActivity3
sally.calories(150, 30) is 82

// 4. Vary the Metabolic Equivalent of Task based on speed of walking.
//    Add the following MET method. Validate the method with tests.
//    Did you put it in the class or the companion object? Update your
//    calories method to call MET(mph). Satisfy the following tests:
//    def MET(mph: Double) = mph match {
//      case x if(x < 1.7) => 2.3
//      case x if(x < 2.5) => 2.9
//      case x if(x < 3) => 3.3
//      case x if(x >= 3) => 3.3
//      case _ => 2.3
//    }
//    WalkActivity4.MET(1.0) is 2.3
//    WalkActivity4.MET(2.7) is 3.3
//    val suzie = new WalkActivity4
//    suzie.calories(150, 30) is 117
//    val john = new WalkActivity4
//    john.calories(150, 30, 1.5) is 82

object WalkActivity4 {
  def MET(mph: Double) = mph match {
    case x if x < 1.7 => 2.3
    case x if x < 2.5 => 2.9
    case x if x < 3 => 3.3
    case x if x >= 3 => 3.3
    case _ => 2.3
  }
  def calories(lbs: Int, mins: Int, mph: Double = 3): Long =
    math.round((MET(mph) * 3.5 * lbs * 0.45) / 200.0 * mins)
}
class WalkActivity4 {
  def calories(lbs: Int, mins: Int, mph: Double = 3) = {
    WalkActivity4.calories(lbs, mins, mph)
  }
}

WalkActivity4.MET(1.0) is 2.3
WalkActivity4.MET(2.7) is 3.3
val suzie = new WalkActivity4
suzie.calories(150, 30) is 117
val john = new WalkActivity4
john.calories(150, 30, 1.5) is 82
