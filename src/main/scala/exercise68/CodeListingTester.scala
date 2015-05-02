// CodeListingTester.scala
package exercise68

import java.io.File

import com.atomicscala.AtomicTest._

class CodeListingTester(makeList: String => IndexedSeq[String]) {

  val filePath = "exercise68/CodeListingTester.scala"
  val filename = new File(getClass.getClassLoader.getResource(filePath).toURI).getPath

  makeList(filename)(7) is
    "class CodeListingTester(makeList: String => IndexedSeq[String]) {"

  makeList("NotAFile.scala").head is
    "File Not Found: NotAFile.scala"

  makeList("NotAScalaFile.txt").head is
    "NotAScalaFile.txt doesn't end with '.scala'"

  makeList(null).head is "Error: Null file name"
}
