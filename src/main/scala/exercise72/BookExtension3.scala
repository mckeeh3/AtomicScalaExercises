package exercise72

case class Book3(title: String)

package object BookExtension3 {

  implicit class Ops3(val book: Book3) extends AnyVal {
    def categorize(category: String) =
      s"$book, category: $category"
  }
}
