
package exercise50

trait BatteryPower3 {
  def monitor(charge: Double) = {
    charge match {
      case c if c < 20 => "red"
      case c if c >= 20 && c < 40 => "yellow"
      case _ => "green"
    }
  }
}

trait EnergySource3 extends BatteryPower3

class Battery3 extends EnergySource3

object Battery3 extends App {
  val battery = new Battery3

  for (arg <- args) println(s"Charge $arg is ${battery.monitor(arg.toInt)}")
}
