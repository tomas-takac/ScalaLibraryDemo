package members

import members.model.{Book, Library, Member}

object ScalaLibraryDemo extends App {

  val library = new Library()

  val book1 = Book("Title1", "Author1", 2001, "Genre1")
  val book2 = Book("Title2", "Author2", 2002, "Genre2")
  val book3 = Book("Title3", "Author1", 2003, "Genre1")

  library.addBook(book1)
  library.addBook(book2)
  library.addBook(book3)

  val member1 = Member("Member1", "ID1")
  val member2 = Member("Member2", "ID2")

  library.addMember(member1)
  library.addMember(member2)

  library.borrowBook("ID1", book1)

  println("All Books: " + library.listBooks())
  println("All Members: " + library.listMembers())
  println("Books by Author1: " + library.findBooksByAuthor("Author1"))
  println("Books in Genre1: " + library.findBooksByGenre("Genre1"))
  println("Total number of books: " + library.countBooks())
  println("Total number of members: " + library.countMembers())

  library.returnBook("ID1", book1)

  println("All Books after return: " + library.listBooks())

}
