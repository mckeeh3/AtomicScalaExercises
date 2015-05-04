import com.atomicscala.AtomicTest._
import exercise70.SumLetters

import scala.util.Try

// 1. Create three methods: the first checks only preconditions, the
//    second checks only postconditions, and the third checks both.
//    Each method has the same body: it takes a String argument which
//    must be between 4-10 characters, and each of those characters
//    must represent a digit. Each method converts each digit into an Int
//    and then adds up all the digits to produce the result. The
//    postcondition should verify the result is in the expected range of
//    values.

def sumDigits1(digits: String) = {
  require(digits.length >= 4 && digits.length <= 10,
    s"argument must between 4-10 characters, length = ${digits.length}")
  require(digits.filter(c => c < '0' || c > '9').length == 0,
    "argument must only contain digits 0-9")

  def sumDigits(digits: String, sum: Int): Int = {
    if (digits.nonEmpty) {
      sumDigits(digits.tail, sum + digits.head.toInt - '0'.toInt)
    } else {
      sum
    }
  }
  sumDigits(digits, 0)
}
def sumDigits2(digits: String) = {
  def sumDigits(digits: String, sum: Int): Int = {
    if (digits.nonEmpty) {
      sumDigits(digits.tail, sum + digits.head.toInt - '0'.toInt)
    } else {
      sum
    }
  }
  val sum = sumDigits(digits, 0)

  assume(sum >= 25 && sum <= 75, s"sum of digits must be between 25-75, sum = $sum")
  sum
}
def sumDigits3(digits: String) = {
  require(digits.length >= 4 && digits.length <= 10,
    s"argument must between 4-10 characters, length = ${digits.length}")
  require(digits.filter(c => c < '0' || c > '9').length == 0,
    "argument must only contain digits 0-9")

  def sumDigits(digits: String, sum: Int): Int = {
    if (digits.nonEmpty) {
      sumDigits(digits.tail, sum + digits.head.toInt - '0'.toInt)
    } else {
      sum
    }
  }
  val sum = sumDigits(digits, 0)

  assume(sum >= 25 && sum <= 75, s"sum of digits must be between 25-75, sum = $sum")
  sum
}

Try(sumDigits1("123")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits1("0123456789012345")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits1("0000")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("9871")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("999998765")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits1("9999999999")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("123")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("0123456789012345")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("0000")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("9871")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("999999876")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("9999999999")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits3("123")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits3("0123456789012345")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits3("0000")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("9871")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits2("999999876")).recover { case e: Throwable => e.getMessage }.get
Try(sumDigits3("9999999999")).recover { case e: Throwable => e.getMessage }.get

// 2. Write an App (see Applications) with a method that takes the
//    command-line argument of a String of letters, converts it to
//    lowercase, and then converts each character to its numerical value
//    in the alphabet, with ‘a’ being 1, ‘b’ being 2, etc. Sum the values
//    and display the result. Use preconditions to verify that the input is
//    in the correct form, and postconditions to ensure that the result is
//    in the expected range of values.

SumLetters.sumLetters("abcdrfg") is 41
SumLetters.sumLetters("xy") is 49
Try(SumLetters.sumLetters("abc6rfg"))
  .recover { case e: Throwable => e.getMessage }.get is
  "requirement failed: argument must contain only letters"
Try(SumLetters.sumLetters("yz"))
  .recover { case e: Throwable => e.getMessage }.get is
  "assumption failed: letters (yz) sum (51) be be less than 50"

// 3. Write a method that takes an Int argument, multiplies it by 3, and
//    has a postcondition that fails if the result is odd. Elide the
//    postcondition and show the failure slipping through. Add a
//    precondition to prevent the failure.

// see exercise.Times3andOdd.scala
