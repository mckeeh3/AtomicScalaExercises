package com.atomicscala.exercise51

import reflect.runtime.currentMirror

object Name3 {
  def className(o: Any) = currentMirror.reflect(o).symbol.toString
}

trait Name3 {
  override def toString = Name.className(this)
}
