// ShowListingEither.scala

import exercise69.{CodeListingTester, CodeListingTry}

import scala.util.{Failure, Success}

def listing(name: String) = {
  CodeListingTry(name) match {
    case Success(lines) => lines
    case Failure(error) => Vector(error)
  }
}

//new CodeListingTester(listing) // getting compile error on type mismatch
