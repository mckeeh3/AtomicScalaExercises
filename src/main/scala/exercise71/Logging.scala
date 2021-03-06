// Logging.scala
package exercise71

import java.util.logging._

trait Logging {
  val log = Logger.getLogger(".")
  log.setUseParentHandlers(false)
  log.addHandler(new FileHandler("AtomicLog.txt"))
  log.addHandler(new ConsoleHandler)
  log.setLevel(Level.ALL)

  def setLevel(level: Level): Unit = {
    log.getHandlers.foreach(_.setLevel(level))
  }

  def error(msg: String) = log.severe(msg)

  def warn(msg: String) = log.warning(msg)

  def info(msg: String) = log.info(msg)

  def debug(msg: String) = log.fine(msg)

  def trace(msg: String) = log.finer(msg)
}
