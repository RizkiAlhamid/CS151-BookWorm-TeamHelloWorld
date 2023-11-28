package Controllers;

import Database.UserDAO;
import Models.User;
import Views.LibrarianHomePageView;
import Views.LoginPageView;
import Views.SignUpPageView;
import Views.UserHomePageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageController {
    private LoginPageView view;
    private String librarianID = "admin";
    private String librarianPassword = "admin";
    // ======= User Database here ======
    private UserDAO userDatabase = new UserDAO();

    public LoginPageController(LoginPageView view) {
        this.view = view;
        this.view.setLoginButtonActionListener(new LoginButtonClickListener());
        this.view.setSignUpButtonActionListener(new SignUpButtonClickListener());
    }

    private class LoginButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsernameValue();
            String password = view.getPasswordValue();

            // ====== Login Logic Here ======
            User foundUser = userDatabase.findUser(username, password);
            System.out.println(foundUser);
            if(username.equals(librarianID) && password.equals(librarianPassword)) {
                JOptionPane.showMessageDialog(view, "Librarian Login");
                LibrarianHomePageView newview = new LibrarianHomePageView();
                LibrarianHomePageController librarianHomePageController = new LibrarianHomePageController(newview);
                view.dispose();
            } else if(foundUser != null) {
                JOptionPane.showMessageDialog(view, "User Login");
                UserHomePageView newview = new UserHomePageView(foundUser);
                UserHomePageController controller = new UserHomePageController(newview, foundUser);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Login Failed");
            }
        }
    }
    private class SignUpButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ====== Go to signup page ======
            SignUpPageController signUpController = new SignUpPageController(new SignUpPageView());
        }
    }
}
