package members.model

case class Member(name: String, membershipId: String) {
  private var borrowedBooks: Seq[Book] = Seq.empty[Book]

  def borrowBook(book: Book): Unit = {
    borrowedBooks = book +: borrowedBooks
  }

  def returnBook(book: Book): Unit = {
    borrowedBooks = borrowedBooks.filterNot(_ == book)
  }
}
