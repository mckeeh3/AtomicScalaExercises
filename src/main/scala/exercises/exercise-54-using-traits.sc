
import com.atomicscala.AtomicTest._

// 1. Create a trait WIFI that reports a status and has an address. Create
//    a class Camera, and then another class WIFICamera that uses both
//    the Camera class and WIFI trait. Satisfy the following tests:
//    val webcam = new WIFICamera
//    webcam.showImage is "Showing video"
//    webcam.address is "192.168.0.200"
//    webcam.reportStatus is "working"

trait WIFI {
  val reportStatus: String
  val address: String
}

class Camera(val showImage: String)
class WIFICamera extends Camera("Showing video") with WIFI {
  override val reportStatus: String = "working"
  override val address: String = "192.168.0.200"
}

val webcam = new WIFICamera
webcam.showImage is "Showing video"
webcam.address is "192.168.0.200"
webcam.reportStatus is "working"

// 2. Create a trait Connections that tells how many connected users
//    there are and limits the number of connections to five. Satisfy the
//    following tests:
//    val c = new Object with Connections
//    c.maxConnections is 5
//    c.connect(true) is true
//    c.connected is 1
//    for (i <- 0 to 3)
//      c.connect(true) is true
//    c.connect(true) is false
//    c.connect(false) is true
//    c.connected is 4
//    for (i <- 0 to 3)
//      c.connect(false) is true
//    c.connected is 0
//    c.connect(false) is false

trait Connections {
  val maxConnections: Int = 5
  var connectedCount = 0

  def connect(doConnect: Boolean): Boolean = {
    val increment =
      if (doConnect && connectedCount < maxConnections) 1
      else if (!doConnect && connectedCount > 0) -1
      else 0

    connectedCount += increment
    increment != 0
  }

  def connected = connectedCount
}

val c = new Object with Connections
c.maxConnections is 5
c.connect(true) is true
c.connected is 1
for (i <- 0 to 3)
  c.connect(true) is true
c.connect(true) is false
c.connect(false) is true
c.connected is 4
for (i <- 0 to 3)
  c.connect(false) is true
c.connected is 0
c.connect(false) is false

// 3. Using the Connections trait from Exercise 2, create a WIFICamera
//    class that limits connections to five. Did you have to create any
//    additional classes or methods? Satisfy the following tests:
//    val c2 = new WIFICamera with Connections
//    c2.maxConnections is 5
//    c2.connect(true) is true
//    c2.connected is 1
//    c2.connect(false) is true
//    c2.connected is 0
//    c2.connect(false) is false

val c2 = new WIFICamera with Connections
c2.maxConnections is 5
c2.connect(true) is true
c2.connected is 1
c2.connect(false) is true
c2.connected is 0
c2.connect(false) is false

// 4. Create a new trait ArtPeriod, showing the art era associated with
//    the creation year. Implement it for the following dates, ignoring
//    potential lack of historical accuracy, and satisfy the following tests:
//    // From wikipedia.org/wiki/Art_periods
//    // Pre-Renaissance: before 1300
//    // Renaissance: 1300-1599
//    // Baroque: 1600-1699
//    // Late Baroque: 1700-1789
//    // Romanticism: 1790-1880
//    // Modern: 1881-1970
//    // Contemporary: after 1971
//    val period = new ArtPeriod
//    period.show(1400) is "Renaissance"
//    period.show(1650) is "Baroque"
//    period.show(1279) is "Pre-Renaissance"

// From wikipedia.org/wiki/Art_periods
// Pre-Renaissance: before 1300
// Renaissance: 1300-1599
// Baroque: 1600-1699
// Late Baroque: 1700-1789
// Romanticism: 1790-1880
// Modern: 1881-1970
// Contemporary: after 1971

trait ArtPeriod {
  def show(year: Int) = year match {
    case y if y < 1300 => "Pre-Renaissance"
    case y if y >= 1300 && y <= 1599 => "Renaissance"
    case y if y >= 1600 && y <= 1699 => "Baroque"
    case y if y >= 1700 && y <= 1789 => "Late Baroque"
    case y if y >= 1790 && y <= 1880 => "Romanticism"
    case y if y >= 1881 && y <= 1970 => "Modern"
    case _ => "Contemporary"
  }
}
val period = new Object with ArtPeriod
period.show(1400) is "Renaissance"
period.show(1650) is "Baroque"
period.show(1279) is "Pre-Renaissance"

// 5. Modify the class Painting by adding in the trait ArtPeriod, passing
//    the year into the Painting constructor. Satisfy the following tests:
//    val painting =
//    new Painting(64, 80, "Starry", 111)
//    painting.show(1889) is "Modern"

class Painting5(w: Int, x: Int, y: String, z: Int) extends ArtPeriod

val painting = new Painting5(64, 80, "Starry", 111)
painting.show(1889) is "Modern"

// 6. Traits can’t take class arguments. Can you eliminate the argument
//    passed to show in the previous exercise? How would you do this?
//    Satisfy the following tests:
//    val painting =
//    new Painting(64, 80, "Starry", 111, 1889)
//    painting.show is "Modern"

class Painting6(w: Int, x: Int, y: String, z: Int, year: Int) extends ArtPeriod {
  def show: String = {
    show(year)
  }
}

val painting6 = new Painting6(64, 80, "Starry", 111, 1889)
painting6.show is "Modern"
