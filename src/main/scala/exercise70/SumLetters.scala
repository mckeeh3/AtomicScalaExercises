package exercise70

object SumLetters extends App {
  def sumLetters(letters: String) = {
    require(letters.toLowerCase.filter(c => !('a' to 'z').contains(c)).length == 0,
      "argument must contain only letters")

    def sumLetters(letters: String, sum: Int): Int = {
      if (letters.nonEmpty) {
        sumLetters(letters.tail, sum + letters.head.toInt - 'a'.toInt + 1)
      } else {
        sum
      }
    }
    val sum = sumLetters(letters, 0)

    assume(sum < 50, s"letters ($letters) sum ($sum) be be less than 50")
    sum
  }

  for (arg <- args) {
    println(s"$arg = ${sumLetters(arg.toLowerCase)}")
  }
}
