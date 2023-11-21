package Models;

import java.util.ArrayList;
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = generateUsername();
    }
    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public String generateUsername() {
        // Extract the first letters from the first and last names
        char firstLetterFirstName = firstName.charAt(0);
        char firstLetterLastName = lastName.charAt(0);
        // Generate a random 4-digit number
        int randomDigits = new Random().nextInt(9000) + 1000;
        // Create the username by combining the initials and the random digits
        return String.format("%c%c-%04d", Character.toUpperCase(firstLetterFirstName),
                Character.toUpperCase(firstLetterLastName), randomDigits);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
