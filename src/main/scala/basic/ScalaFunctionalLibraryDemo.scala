package basic

import basic.model.{Book, FunctionalLibrary}

object ScalaFunctionalLibraryDemo extends App{

  private val library = new FunctionalLibrary
  val book1 = Book("Title1", "Author1", 2001)
  val bannedBook = Book("50 shades of gray", "Author4", 2005)

  println(library.addBook(book1))
  println(library.addBook(book1))
  println(library.addBook(Book("Title2", "Author2", 2002)))
  println(library.addBook(Book("Title3", "Author1", 2003)))
  println(library.addBook(bannedBook))

  println("All Books: " + library.listBooks())
  println("Books by Author1: " + library.findBooksByAuthor("Author1"))
  println("Books by Author4: " + library.findBooksByAuthor("Author4"))
  println("Total number of books: " + library.countBooks())

}
