
import java.io.{File, FileNotFoundException}

import com.atomicscala.AtomicTest._
import exercise65.{CodeListing, ExtensionException}
import scala.util.{Success, Try}
import exercise68._

// 1. Modify TryTransform.scala to show that all the Try calls within the
//    transform argument list can be replaced with Success. Satisfy the
//    following tests:
//    f(0) is "OK Bob"
//    f(1) is "Reason"
//    f(2) is "11"
//    f(3) is "1.618"

def f1(n:Int) = Try(toss(n)).transform(
  i => Success(s"$i Bob"), // Success
  { // Failure
    case Except1(why) => Success(why)
    case Except2(n) => Success(n)
    case Except3(msg, d) => Success(d)
  }
).get

f1(0) is "OK Bob"
f1(1) is "Reason"
f1(2) is "11"
f1(3) is "1.618"

// 2. Remove the .get acting on the result of the transform. What must
//    you do to make the tests pass?
def f2(n: Int) = Try(toss(n)).transform(
  i => Success(s"$i Bob"), // Success
  { // Failure
    case Except1(why) => Success(why)
    case Except2(n) => Success(n)
    case Except3(msg, d) => Success(d)
  }
)

f2(0).get is "OK Bob"
f2(1).get is "Reason"
f2(2).get is "11"
f2(3).get is "1.618"

// 3. Modify ShowListingTry.scala to include line numbers. Were you
//    able to use the CodeListingTester from your solution in
//    Constructors and Exceptions?

def listing(name: String) = {
  Try(new CodeListing(name)).recover {
    case _: FileNotFoundException =>
      Vector(s"File Not Found: $name")
    case _: NullPointerException =>
      Vector("Error: Null file name")
    case e: ExtensionException =>
      Vector(e.getMessage)
  }.get}

def listingNumbered(filename: String) = {
  var lineNumber = 0
  def numberLine(line: String) = {
    lineNumber += 1
    s"$lineNumber $line"
  }
  listing(filename).map(line => numberLine(line))
}

new CodeListingTester(listing)

val filePath = "exercise68/CodeListingTester.scala"
val filename = new File(getClass.getClassLoader.getResource(filePath).toURI).getPath

val lines = listingNumbered(filename)
lines(1) is "2 package exercise68"
