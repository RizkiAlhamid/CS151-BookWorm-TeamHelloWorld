package Controllers;

import Database.UserDAO;
import Models.User;
import Views.SignUpPageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPageController {
    private SignUpPageView view;
    // ====== User database here ======
    private UserDAO userDatabase = new UserDAO();

    // Custom Exception Class for Password Validation
    public class PasswordFormatException extends Exception {
        public PasswordFormatException(String message) {
            super(message);
        }
    }

    // Method to Validate Password
    public void validatePassword(String password) throws PasswordFormatException {
        if (password.length() < 8) {
            throw new PasswordFormatException("Password must be at least 8 characters long.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordFormatException("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new PasswordFormatException("Password must contain at least one number.");
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new PasswordFormatException("Password must contain at least one special character.");
        }
    }


    public SignUpPageController(SignUpPageView view) {
        this.view = view;
        view.setEnterButtonActionListener(new EnterButtonClickListener());
    }

    private class EnterButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstName = view.getFirstNameValue();
                String lastName = view.getLastNameValue();
                String password = view.getPasswordValue();

                // Validate password
                validatePassword(password);

                // Existing signup logic
                User newUser = new User(firstName, lastName, password);
                JOptionPane.showMessageDialog(view, "Your username is: " + newUser.getUsername());
                userDatabase.addUser(newUser);
                view.dispose();
            } catch (PasswordFormatException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        }
    }
}
