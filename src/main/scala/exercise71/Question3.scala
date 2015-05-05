package exercise71

import java.util.logging.Level

object Question3 extends App {
  val logInfo = new LoggingTest(Level.INFO)
  logInfo.trace("trace")

  val logDebug = new LoggingTest(Level.FINE)
  logInfo.debug("debug")
  logInfo.trace("trace")
}
