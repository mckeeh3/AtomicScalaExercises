
import com.atomicscala.AtomicTest._

//1.  Add “Purple” to Color’s object. Don’t add to the match expression.
//    What happens?

sealed trait Color
case object Red extends Color
case object Green extends Color
case object Blue extends Color
case object Purple extends Color
object Color {
  val values = Vector(Red, Green, Blue) //, Purple)
}

// get match error when purple color is added
def display(c: Color) = c match {
  case Red => s"It's $c"
  case Green => s"It's $c"
  case Blue => s"It's $c"
}

Color.values.map(display) is "Vector(It's Red, It's Green, It's Blue)"

// 2. Implement Color as an Enumeration called EnumColor for
//    comparison. Satisfy the following tests:
//    EnumColor.Red is "Red"
//    EnumColor.Blue is "Blue"
//    EnumColor.Green is "Green"

object EnumColor extends Enumeration {
  type EnumColor = Value
  val Red, Green, Blue = Value
}

EnumColor.Red is "Red"
EnumColor.Blue is "Blue"
EnumColor.Green is "Green"

// 3. Add another Red to EnumColor. What happens?

// error Red is already defined

// 4. Add another Red to the tagging trait Color. What happens?

// error Red is already defined
