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

    public SignUpPageController(SignUpPageView view) {
        this.view = view;
        view.setEnterButtonActionListener(new EnterButtonClickListener());

    }

    private class EnterButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = view.getFirstNameValue();
            String lastName = view.getLastNameValue();
            String password = view.getPasswordValue();
            // ====== Save user data to database here =======
            User newUser = new User(firstName, lastName, password);
            JOptionPane.showMessageDialog(view, "Your username is: " + newUser.getUsername());
            userDatabase.addUser(newUser);
            view.dispose();
        }
    }
}
