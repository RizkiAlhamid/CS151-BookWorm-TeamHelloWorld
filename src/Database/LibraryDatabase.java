package Database;

import java.util.ArrayList;

public class LibraryDatabase {
    // Arraylists for ease of access
    private static ArrayList<Book> books;
    private static ArrayList<User> users;

    // Default constructor
    public LibraryDatabase() {
        books = null;
        users = null;
    }

    // Adds the user to the member list :)
    public boolean addUser(User user) {
        if (users.contains(user)) { return false; }
        return users.add(user);
    }

    // Removes the user from the member list :(
    public boolean removeUser(User user) {
        if (!users.contains(user)) { return false; }
        return users.remove(user);
    }

    // Adds a book to the library :)
    public boolean addBook(Book book) {
        if (books.contains(book)) { return false; }
        return books.add(book);
    }

    // Removes a book from the library :(
    public boolean removeBook(Book book) {
        if (!books.contains(book)) { return false; }
        return books.remove(book);
    }
}
