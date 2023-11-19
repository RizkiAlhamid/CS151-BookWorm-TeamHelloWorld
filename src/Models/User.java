package Models;

import java.util.ArrayList;

public class User {
    String username;
    String firstName;
    String lastName;
    String password;
    ArrayList<Book> rentedBooks = new ArrayList<>();

    public ArrayList<Book> getRentedBooks() {
        return rentedBooks;
    }

    public User() {
        username = "RA-1948";
        firstName = "Rizki";
        lastName = "Alhamid";
        password = "SJSU123";
    }

    public User(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    public void addRentedBook(Book book) { rentedBooks.add(book); }
    public void returnBook(Book book) {
        rentedBooks.remove(book);
    }
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
