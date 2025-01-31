package com.week3.day1;
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    Book next;
    Book prev;

    // Constructor to initialize book details
    public Book(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head;
    private Book tail;

    // Add a new book at the beginning of the list
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a new book at the end of the list
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a new book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookId, availabilityStatus);
            return;
        }

        Book temp = head;
        for (int i=1; i < position - 1 &&temp != null ;i++) {
            temp = temp.next;

        }
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position. Adding at the end.");
            addBookAtEnd(title, author, genre, bookId, availabilityStatus);
        } else {
            temp.next.prev = newBook;
            newBook.prev = temp;
            newBook.next = temp.next;
            temp.next = newBook;
        }

//        if (temp != null) {
//            newBook.next = temp.next;
//            newBook.prev = temp;
//            if (temp.next != null) {
//                temp.next.prev = newBook;
//            }
//            temp.next = newBook;
//        } else {
//            System.out.println("Invalid position. Adding at the end.");
//            addBookAtEnd(title, author, genre, bookId, availabilityStatus);
//        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        Book temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
//            temp.next = temp.next.next;
//            temp.next.prev = temp;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Search for a book by Book Title or Author
    public void searchBook(String searchQuery) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(searchQuery) || temp.author.equalsIgnoreCase(searchQuery)) {
                System.out.println("Book Found: ");
                System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre
                        + ", Book ID: " + temp.bookId + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found with the title or author: " + searchQuery);
        }
    }

    // Update a book’s availability status
    public void updateAvailabilityStatus(int bookId, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availabilityStatus = status;
                System.out.println("Book availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre
                    + ", Book ID: " + temp.bookId + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre
                    + ", Book ID: " + temp.bookId + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBookAtBeginning("Happiness", "Sarowar gupta", "Fiction", 101, true);
        library.addBookAtEnd("Vision", "Sarowar", "World", 102, false);
        library.addBookAtEnd("Turning Point", "Suru", "Life", 103, true);
        library.addBookAtPosition(2, "Hello to the World", "Sarowar", "Adventure", 104, true);

        // Display books in forward order
        System.out.println("Books in Library (Forward Order):");
        library.displayBooksForward();

        // Search for a book by title or author
        System.out.println("\nSearching for books by title 'Vision':");
        library.searchBook("Vision");

        // Update availability status
        library.updateAvailabilityStatus(102, true);

        // Display books in reverse order
        System.out.println("\nBooks in Library (Reverse Order):");
        library.displayBooksReverse();

        // Count the total number of books
        System.out.println("\nTotal number of books in library: " + library.countBooks());

        // Remove a book by Book ID
        library.removeBookById(103);

        // Display books after removal
        System.out.println("\nBooks after removal of Book ID 103:");
        library.displayBooksForward();
    }
}

