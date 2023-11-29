package Database;

import Models.Book;
import Models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO {
    private static final String FILE_PATH = "users.txt";
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String username = parts[2].trim();
                    String password = parts[3].trim();

                    User user = new User(firstName, lastName, username, password);
                    loadBorrowedBooks(user);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    private ArrayList<Book> loadBorrowedBooks(User user) {
        BookDAO bookDatabase = new BookDAO();
        ArrayList<Book> books = bookDatabase.getAllBooks();
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        for(Book book: books) {
            if(book.getRentedBy().equals(user.getUsername())) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }
    public void addUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = String.format("%s,%s,%s,%s%n",
                    user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(String usernameToDelete) {
        List<User> users = getAllUsers();
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(usernameToDelete)) {
                iterator.remove();
                break; // Assuming usernames are unique
            }
        }

        saveUsers(users);
    }
    private void saveUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                String line = String.format("%s,%s,%s,%s%n",
                        user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User findUser(String username, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // User not found
    }
    public void editUser(String usernameToEdit, User updatedUser) {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(usernameToEdit)) {
                users.set(i, updatedUser);
                break; // Assuming usernames are unique
            }
        }
        saveUsers(users);
    }
}
