package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    public ArrayList<Book> bookFile() {
        String fileName = "path"; // TODO
        ArrayList<Book> books = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String author = data[1].trim();
                String genre = data[2].trim();
                int year = Integer.parseInt(data[3].trim());
                books.add(new Book(name, author, year, genre));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<User> userFile() {
        String fileName = "path"; // TODO
        ArrayList<User> users = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String password = data[1].trim();
                users.add(new User(name, password));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
