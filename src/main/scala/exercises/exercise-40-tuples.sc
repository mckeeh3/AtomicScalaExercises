
import com.atomicscala.AtomicTest._

// 1. Unpack the values from the tuples below into named variables for
//    temp, sky, and view. Satisfy the following tests:
//    val tuple1 = (65, "Sunny", "Stars")
//    val (/* fill this in */) = tuple1
//    temp1 is 65
//    sky1 is "Sunny"
//    view1 is "Stars"
//
//    val tuple2 =
//      (78, "Cloudy", "Satellites")
//    val (/* fill this in */) = tuple2
//    temp2 is 78
//    ski2 is "Cloudy"
//    view2 is "Satellites"
//
//    val tuple3 = (51, "Blue", "Night")
//    val (/* fill this in */) = tuple3
//    temp3 is 51
//    ski3 is "Blue"
//    view3 is "Night"

val tuple1 = (65, "Sunny", "Stars")
val (temp1, sky1, view1) = tuple1
temp1 is 65
sky1 is "Sunny"
view1 is "Stars"

val tuple2 = (78, "Cloudy", "Satellites")
val (temp2, ski2, view2) = tuple2
temp2 is 78
ski2 is "Cloudy"
view2 is "Satellites"

val tuple3 = (51, "Blue", "Night")
val (temp3, ski3, view3) = tuple3
temp3 is 51
ski3 is "Blue"
view3 is "Night"

// 2. Create a tuple to hold the values 50 and 45. Unpack the values
//    using numeric indices. Satisfy the following tests:
//    val info = // fill this in
//    info./* what goes here? */ is 50
//    info./* what goes here? */ is 45

val info = (50, 45)
info._1 is 50
info._2 is 45

// 3. Create a method weather that takes arguments for temperature
//    and humidity. Your method will return “Hot” if the temp is above
//    80 degrees and “Cold” if the temperature is below 50 degrees.
//    Otherwise, return “Temperate.” Your method will also return
//    “Humid” if humidity is above 40%, unless the temperature is below
//    50. In that case, it should return “Damp.” Otherwise, return
//    “Pleasant.” Write tests for the above conditions, and also satisfy
//    the following tests:
//    weather(81, 45) is ("Hot", "Humid")
//    weather(50, 45) is ("Temperate", "Humid")

def weather(temperature: Int, humidity: Int) = {
  val temperatureLevel = temperature match {
    case t if t > 80 => "Hot"
    case t if t < 50 => "Cold"
    case _ => "Temperate"
  }
  val humidityLevel = humidity match {
    case h if h > 40 && temperature >= 50 => "Humid"
    case h if h > 40 && temperature < 50 => "Damp"
    case _ => "Pleasant"
  }
  (temperatureLevel, humidityLevel)
}

weather(81, 45) is ("Hot", "Humid")
weather(50, 45) is ("Temperate", "Humid")

// 4. Using your solution for the previous exercise, unpack the values
//    into heat and moisture. Satisfy the following tests:
//    val (/* fill this in */) = weather(81, 45)
//    heat1 is "Hot"
//    moisture1 is "Humid"
//    val (/* fill this in */) = weather(27, 55)
//    heat2 is "Cold"
//    moisture2 is "Damp"

val (heat1, moisture1) = weather(81, 45)
heat1 is "Hot"
moisture1 is "Humid"
val (heat2, moisture2) = weather(27, 55)
heat2 is "Cold"
moisture2 is "Damp"
