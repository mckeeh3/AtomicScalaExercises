
import com.atomicscala.AtomicTest._

// 1. Create a trait BatteryPower to report remaining charge. If the
//    charge is greater than 40%, report “green.” If the charge is between
//    20-39%, report “yellow.” If the charge is less than 20%, report “red.”
//    Instantiate the trait and satisfy the following tests:
//    class Battery extends
//    EnergySource with BatteryPower
//    val battery = new Battery
//    battery.monitor(80) is "green"
//    battery.monitor(30) is "yellow"
//    battery.monitor(10) is "red"

trait BatteryPower {
  def monitor(charge: Double) = {
    charge match {
      case c if c < 20 => "red"
      case c if c >= 20 && c < 40 => "yellow"
      case _ => "green"
    }
  }
}

trait EnergySource extends BatteryPower

class Battery extends EnergySource

val battery = new Battery
battery.monitor(80) is "green"
battery.monitor(30) is "yellow"
battery.monitor(10) is "red"

// 2. Create a new class Toy. Use Toy and BatteryPower to create a new
//    class BatteryPoweredToy. Satisfy the following tests:
//    val toy = new BatteryPoweredToy
//    toy.monitor(50) is "green"

abstract class Toy

class BatteryPoweredToy extends Toy with BatteryPower

val toy = new BatteryPoweredToy
toy.monitor(50) is "green"

// 3. Instantiate an object without creating an intermediate class, using
//    Toy and BatteryPower directly. Satisfy the following test:
//    val toy2 = new // Fill this in
//    toy2.monitor(50) is "green"

val toy2 = new Toy with BatteryPower
toy2.monitor(50) is "green"
