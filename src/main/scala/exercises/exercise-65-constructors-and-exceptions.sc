
import java.io.File

import com.atomicscala.AtomicTest._
import exercise65.{CodeListing, CodeListingTester}

// 1. Working from CodeListingTester.scala, write a script that uses
//    CodeListing.scala to open a source-code file and print all the lines
//    in the file.

val filePath = "exercise65/CodeListing.scala"
val filename = new File(getClass.getClassLoader.getResource(filePath).toURI).getPath

CodeListing.apply("x").head is "x doesn't end with '.scala'"
CodeListing.apply("x.scala").head is "File Not Found: x.scala"
CodeListing.apply(filename).head is "// CodeListing.scala"

for (line <- CodeListing.apply(filename)) {
  println(line)
}

// 2. Add line numbering to your solution for the previous exercise.
// 3. Use your new script on a file that does not exist. Do you need to
//    make additional modifications?

def dumpFile(lines: IndexedSeq[String], lineNumber: Int): Unit = {
  if (lines.nonEmpty) {
    println(s"${lineNumber + 1} ${lines.head}")
    dumpFile(lines.tail, lineNumber + 1)
  }
}

dumpFile(CodeListing.apply(filename), 0)
