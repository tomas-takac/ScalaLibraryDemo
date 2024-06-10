package basic.model

class Library {
  private var books: List[Book] = List()

  def addBook(book: Book): Unit = {
    books = book :: books
  }

  def listBooks(): List[Book] = books

  def findBooksByAuthor(author: String): List[Book] = {
    books.filter(_.author == author)
  }

  def countBooks(): Int = books.size
}
