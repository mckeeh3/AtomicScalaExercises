
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
