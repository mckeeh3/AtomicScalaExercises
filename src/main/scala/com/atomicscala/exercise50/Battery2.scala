
package com.atomicscala.exercise50
import com.atomicscala.AtomicTest._

trait BatteryPower2 {
  def monitor(charge: Double) = {
    charge match {
      case c if c < 20 => "red"
      case c if c >= 20 && c < 40 => "yellow"
      case _ => "green"
    }
  }
}

trait EnergySource2 extends BatteryPower2

class Battery2 extends EnergySource2

object Battery2 extends App {
  val battery = new Battery2
  battery.monitor(80) is "green"
  battery.monitor(30) is "yellow"
  battery.monitor(10) is "red"
}
