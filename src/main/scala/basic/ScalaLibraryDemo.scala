package basic

import model.{Book, Library}

object ScalaLibraryDemo extends App {

  private val library = new Library
  library.addBook(Book("Title1", "Author1", 2001))
  library.addBook(Book("Title2", "Author2", 2002))
  library.addBook(Book("Title3", "Author1", 2003))

  println("All Books: " + library.listBooks())
  println("Books by Author1: " + library.findBooksByAuthor("Author1"))
  println("Total number of books: " + library.countBooks())

}
