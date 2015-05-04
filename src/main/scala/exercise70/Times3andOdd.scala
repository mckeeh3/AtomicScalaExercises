package exercise70

object Times3andOdd extends App {
  def times3andOdd(n: Int) = {
    val result = n * 3

    assume(result % 2 == 0, s"result $result must be odd")
    result
  }

  for (arg <- args) {
    times3andOdd(arg.toInt)
  }
}
