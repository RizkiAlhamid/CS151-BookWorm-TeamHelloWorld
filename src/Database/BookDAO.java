package Database;
import Models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDAO {
    private static final String FILE_PATH = "books.txt";
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    String genre = parts[3].trim();
                    String rentedBy = parts[4].trim();
                    Book book = new Book(title, author, year, genre, rentedBy);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
    public ArrayList<Book> getAllAvailableBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    String genre = parts[3].trim();
                    String rentedBy = parts[4].trim();
                    if(rentedBy.equals("None")) {
                        Book book = new Book(title, author, year, genre, rentedBy);
                        books.add(book);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
    public ArrayList<Book> getAllBooksRentedByUser(String username) {
        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    String genre = parts[3].trim();
                    String rentedBy = parts[4].trim();
                    if(rentedBy.equals(username)) {
                        Book book = new Book(title, author, year, genre, rentedBy);
                        books.add(book);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
    public void addBook(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = String.format("%s,%s,%d,%s,%s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre(), book.getRentedBy());
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeBook(String title) {
        List<Book> books = getAllBooks();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                break; // Assuming that book titles are unique
            }
        }
        // Save the updated list back to the file
        saveBooks(books);
    }
    public void markBookAsRented(String title, String username) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setRentedBy(username);
                break; // Assuming that book titles are unique
            }
        }
        // Save the updated list back to the file
        saveBooks(books);
    }
    public void returnBook(String title, String username) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setRentedBy("None");
                break; // Assuming that book titles are unique
            }
        }
        // Save the updated list back to the file
        saveBooks(books);
    }
    private void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                String line = String.format("%s,%s,%d,%s,%s%n",
                        book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre(), book.getRentedBy());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

