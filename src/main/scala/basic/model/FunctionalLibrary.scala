package basic.model

import basic.model.FunctionalLibrary.BookAddedFailure._
import basic.model.FunctionalLibrary.BookAddedSuccess.{BookAddedSuccessfully, BookAlreadyPresent}
import basic.model.FunctionalLibrary._

class FunctionalLibrary {
  private var books: Set[Book] = Set.empty[Book]

  def addBook(newBook: Book): BookAdditionResult = {
    if (bannedBookTitles.contains(newBook.title)) {
      BookBanned
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
  sealed trait BookAdditionResult
  sealed trait BookAddedSuccess extends BookAdditionResult
  sealed trait BookAddedFailure extends BookAdditionResult
  object BookAddedSuccess {
    case object BookAddedSuccessfully extends BookAddedSuccess
    case object BookAlreadyPresent extends BookAddedSuccess
  }

  object BookAddedFailure {
    case object BookBanned extends BookAddedFailure
  }

  private val bannedBookTitles: Set[String] = Set("50 shades of gray")
}

