// CodeListingTester.scala
package exercise65

import com.atomicscala.AtomicTest._

class CodeListingTester(makeList: String => IndexedSeq[String]) {

  makeList("CodeListingTester.scala")(4) is
    "class CodeListingTester("

  makeList("NotAFile.scala").head is
    "File Not Found: NotAFile.scala"

  makeList("NotAScalaFile.txt").head is
    "NotAScalaFile.txt doesn't end with '.scala'"

  makeList(null).head is "Error: Null file name"
}
