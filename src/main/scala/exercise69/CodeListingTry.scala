// CodeListingEither.scala
package exercise69

import java.io.FileNotFoundException

import scala.util.Success

object CodeListingTry {
  def apply(name: String) =
    try {
      Success(new CodeListing(name))
    } catch {
      case _: FileNotFoundException =>
        Fail(s"File Not Found: $name")
      case _: NullPointerException =>
        Fail("Error: Null file name")
      case e: ExtensionException =>
        Fail(e.getMessage)
    }
}
