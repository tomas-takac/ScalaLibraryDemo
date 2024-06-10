package members.model

class Library {
  private var books: Seq[Book] = Seq.empty[Book]
  private var members: Seq[Member] = Seq.empty[Member]

  def addBook(book: Book): Unit = {
    books = book +: books
  }

  def addMember(member: Member): Unit = {
    members = member +: members
  }

  def borrowBook(membershipId: String, book: Book): Unit = {
    findMemberById(membershipId).foreach { member =>
      if (books.contains(book)) {
        member.borrowBook(book)
        books = books.filterNot(_ == book)
      }
    }
  }

  def returnBook(membershipId: String, book: Book): Unit = {
    findMemberById(membershipId).foreach { member =>
      member.returnBook(book)
      books = book +: books
    }
  }

  def listBooks(): Seq[Book] = books

  def listMembers(): Seq[Member] = members

  def findBooksByAuthor(author: String): Seq[Book] = {
    books.filter(_.author == author)
  }

  def findBooksByGenre(genre: String): Seq[Book] = {
    books.filter(_.genre == genre)
  }

  def countBooks(): Int = books.size

  def countMembers(): Int = members.size

  private def findMemberById(membershipId: String): Option[Member] = {
    members.find(_.membershipId == membershipId)
  }
}
