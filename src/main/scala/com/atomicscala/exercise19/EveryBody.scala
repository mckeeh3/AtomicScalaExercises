package com.atomicscala.exercise19

class EveryBody {
  val all = Vector(new SomeBody, new SomeBody, new SomeBody)

  def body(): String = {
    var s = ""
    for (o <- all) {
      s += o.body() + " "
    }
    s
  }
}
