package basic.model

import basic.model.FunctionalLibrary.BookAddedFailure._
import basic.model.FunctionalLibrary.BookAddedSuccess.{BookAddedSuccessfully, BookAlreadyPresent}
import basic.model.FunctionalLibrary._

class FunctionalLibrary {
  private var books: Set[Book] = Set.empty[Book]

  def addBook(newBook: Book): BookAdditionResult = {
    if (bannedBookTitles.contains(newBook.title)) {
      BookNotPermitted
    } else if(books.contains(newBook)) {
      BookAlreadyPresent
    } else {
      books = books + newBook
      BookAddedSuccessfully
    }
  }

  def listBooks(): Set[Book] = books

  def findBooksByAuthor(author: String): Set[Book] = {
    books.filter(_.author == author)
  }

  def countBooks(): Int = books.size

}

object FunctionalLibrary {
  trait BookAdditionResult
  trait BookAddedSuccess extends BookAdditionResult
  trait BookAddedFailure extends BookAdditionResult
  object BookAddedSuccess {
    case object BookAddedSuccessfully extends BookAddedSuccess
    case object BookAlreadyPresent extends BookAddedSuccess
  }

  object BookAddedFailure {
    case object BookNotPermitted extends BookAddedFailure
  }

  private val bannedBookTitles: Set[String] = Set("50 shades of gray")
}

