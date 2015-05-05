package exercise71

import java.util.logging.{Level, ConsoleHandler, FileHandler, Logger}

trait Logging1 {
  val log = Logger.getLogger(".")

  log.setUseParentHandlers(false)
  log.addHandler(new FileHandler("/tmp/AtomicLog1.txt"))
  log.addHandler(new ConsoleHandler)
  log.setLevel(Level.ALL)
  log.getHandlers.foreach(_.setLevel(Level.ALL))

  def error(msg: String) = log.severe(msg)
  def warn(msg: String) = log.warning(msg)
  def info(msg: String) = log.info(msg)
  def debug(msg: String) = log.fine(msg)
  def trace(msg: String) = log.finer(msg)
}

class LoggingTest1 extends Logging1 {
  log.addHandler(new FileHandler("/tmp/AtomicLog2.txt"))
  log.addHandler(new ConsoleHandler)
}

trait Logging2 {
  val log = Logger.getLogger(".2")
  log.setUseParentHandlers(false)
  log.setLevel(Level.ALL)

  def levelHandler(level: Level): Unit = {
    val handler = new FileHandler(s"/tmp/AtomicLog-$level.txt")
    handler.setLevel(level)
    log.addHandler(handler)
    val console = new ConsoleHandler
    console.setLevel(level)
    log.addHandler(console)
  }

  def levelHandlers(levels: Level*): Unit = {
    for (level <- levels) {
      levelHandler(level)
    }
  }

  def error(msg: String) = log.severe(msg)
  def warn(msg: String) = log.warning(msg)
  def info(msg: String) = log.info(msg)
  def debug(msg: String) = log.fine(msg)
  def trace(msg: String) = log.finer(msg)
}

class LoggingTest2 extends Logging2 {
  levelHandlers(Level.SEVERE, Level.WARNING, Level.INFO, Level.FINE, Level.FINER)
}
