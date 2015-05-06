
import java.util.Locale.Category

import com.atomicscala.AtomicTest._
import exercise72.{Book3, BookExtension3}

// 1. Rewrite ExtensionMethodArguments.scala so you get the same
//    results without using extension methods.

case class Book(title: String) {
  def categorize(category: String) =
    s"$this, category: $category"
}
Book("Dracula") categorize "Vampire" is "Book(Dracula), category: Vampire"

//case class Book(title:String)
//
//object BookExtension {
//  implicit class Ops(book:Book) {
//    def categorize(category:String) =
//      s"$book, category: $category"
//  }
//}
//import BookExtension._
//
//Book("Dracula") categorize "Vampire" is "Book(Dracula), category: Vampire"

// 2. Modify ExtensionMethodArguments.scala by adding an additional
//    extension method in that has two arguments. Write tests.

case class Book2(title: String)

object BookExtension2 {
  implicit class Ops(book: Book2) {
    def categorize(category: String) =
      s"$book, category: $category"
    def categories(category: String, subCategory: String) =
      s"$book, category: $category, $subCategory"
  }
}
import BookExtension2._

Book2("Frankenstein").categories("horror", "monster") is
  "Book2(Frankenstein), category: horror, monster"

// 3. Rewrite ExtensionMethodArguments.scala to turn Ops into a value
//    class.

import BookExtension3._

Book3("Wolfman") categorize "monster" is "Book3(Wolfman), category: monster"
