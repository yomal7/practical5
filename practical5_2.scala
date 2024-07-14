case class Book(title: String, author: String, isbn: String)

def addBook(book : Book, books: Set[Book]): Set[Book] = {
    val newbooks = books + book
    println(s"Added : ${book.title}")
    newbooks
}

def removeBook(isbn: String, books: Set[Book]): Set[Book] = {
    val(removed , newbooks) = books.partition(_.isbn == isbn)
    if(removed.isEmpty){
        println(s"\n${isbn} not found.")
    }
    else{
        println(s"\n${removed.head.title} is removed.")
    }
    newbooks
}

def checkBook(isbn: String, books: Set[Book]): Unit = {
    if(books.exists(_.isbn == isbn)) println(s"\n${isbn} - ${books.filter(_.isbn == isbn).head.title} found.")
    else println(s"\n${isbn} not found")
}

def printCurrentBooks(books : Set[Book]) : Unit = {
    println("\nCurrent Books in the library : ")
    books.foreach(item => println(s"${item.title} - ${item.author} - ${item.isbn}"))
}

def findBookbyTitle(title: String, books: Set[Book]): Unit = {
    val newbook = books.filter(_.title == title)
    if(newbook.isEmpty){
        println(s"\n${title} not found.")
    }
    else{
        println(s"\n${newbook.head.title} - ${newbook.head.author} - ${newbook.head.isbn}")
    }
}

def displayAuthorBooks(author: String, books: Set[Book]): Unit = {
    val authorBooks = books.filter(_.author.toLowerCase == author.toLowerCase)
    if(authorBooks.isEmpty){
        println(s"\n${author} books not found.")
    }
    else{
        println(s"\nBooks by ${author.toUpperCase}")
        authorBooks.foreach(book => println(book.title))
    }
}

@main def practical5_2(): Unit = {
    var books : Set[Book] = Set(
        Book("The Lighning Thief", "Rick Riordan", "9780756966034"),
        Book("Sea of Monsters", "Rick Riordan", "9780141319148"),
        Book("And Then There Were None", "Agatha Christie", "9780008123208")
    )

    var book1 = Book("A Fall of Moondust", "Arthur C. Clarke", "9780330023122")
    var book2 = Book("Five on Kirrin Island Again", "Enid Blyton", "9788426142962")
    var book3 = Book("The Titan's Curse", "Rick Riordan", "9780141346816")

    books = addBook(book1, books)
    books = addBook(book2, books)
    books = addBook(book3, books)

    books = removeBook("9780008123208", books)
    books = removeBook("9780008123208", books)

    printCurrentBooks(books)

    checkBook("9780756966034", books)

    findBookbyTitle("A Fall of Moondust", books)

    displayAuthorBooks("rick riordan", books)

}