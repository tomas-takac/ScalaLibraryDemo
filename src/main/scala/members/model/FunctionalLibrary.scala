package members.model

import members.model.FunctionalLibrary.LibraryOperationResult
import members.model.FunctionalLibrary.LibraryOperationResult._

class FunctionalLibrary {
  private var books: Set[Book] = Set.empty[Book]
  private var members: Set[Member] = Set.empty[Member]


  def addBook(newBook: Book): LibraryOperationResult = {
    if (books.contains(newBook)) {
      BookAlreadyPresent
    } else {
      books = books + newBook
      LibraryOperationSuccess
    }
  }

  def addMember(newMember: Member): LibraryOperationResult = {
    if (members.contains(newMember)) {
      MemberAlreadyPresent
    } else {
      members = members + newMember
      LibraryOperationSuccess
    }
  }

  def borrowBook(membershipId: String, book: Book): LibraryOperationResult = {
    findMemberById(membershipId) match {
      case Some(member) =>
        if (books.contains(book)) {
          member.borrowBook(book)
          books = books.filterNot(_ == book)
          LibraryOperationSuccess
        } else
          BookNotFound
      case None => MemberNotFound
    }
  }

  def returnBook(membershipId: String, book: Book): LibraryOperationResult = {
    findMemberById(membershipId) match {
      case Some(member) =>
        member.returnBook(book)
        books = books + book
        LibraryOperationSuccess
      case None =>
        MemberNotFound
    }
  }

  def listBooks(): Set[Book] = books

  def listMembers(): Set[Member] = members

  def findBooksByAuthor(author: String): Set[Book] = {
    books.filter(_.author == author)
  }

  def findBooksByGenre(genre: String): Set[Book] = {
    books.filter(_.genre == genre)
  }

  def countBooks(): Int = books.size

  def countMembers(): Int = members.size

  private def findMemberById(membershipId: String): Option[Member] = {
    members.find(_.membershipId == membershipId)
  }
}

object FunctionalLibrary {
  sealed trait LibraryOperationResult

  object LibraryOperationResult {

    case object LibraryOperationSuccess extends LibraryOperationResult

    case object MemberNotFound extends LibraryOperationResult

    case object MemberAlreadyPresent extends LibraryOperationResult

    case object BookNotFound extends LibraryOperationResult

    case object BookAlreadyPresent extends LibraryOperationResult
  }
}

