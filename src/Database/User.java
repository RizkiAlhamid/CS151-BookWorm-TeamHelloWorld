package Database;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void editProfile(String name, String password) {
        // Username and password both cannot be less than 3 characters
        if (name.length() < 3 && password.length() < 3) { return; }
        // If they're not, then set them :)
        this.name = name;
        this.password = password;
    }

    public boolean rentBook(Book book) {
        return borrowedBooks.add(book);
    }

    public boolean returnBook() {
        return false;
    }
}
