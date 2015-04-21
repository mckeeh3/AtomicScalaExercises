package com.atomicscala.exercise51

import reflect.runtime.currentMirror

object Name {
  def className(o: Any) = currentMirror.reflect(o).symbol.
    toString.replace('$', ' ').split(' ').last
}

trait Name {
  override def toString = Name.className(this)
}
