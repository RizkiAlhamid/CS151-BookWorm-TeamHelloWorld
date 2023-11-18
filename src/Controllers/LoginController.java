package Controllers;

import Views.BookListView;
import Views.LoginPageView;
import Views.SignUpPageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginPageView loginPageView;
    private String librarianID = "admin";
    private String librarianPassword = "admin";

    public LoginController(LoginPageView loginPageView) {
        this.loginPageView = loginPageView;
        this.loginPageView.addLoginButtonActionListener(new LoginButtonClickListener());
        this.loginPageView.addSignUpButtonActionListener(new SignUpButtonClickListener());
    }

    private class LoginButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idNumber = loginPageView.getUserIdValue();
            String password = loginPageView.getPasswordValue();

            if(idNumber.equals(librarianID) && password.equals(librarianPassword)) {
                JOptionPane.showMessageDialog(loginPageView, "Librarian Login");
                BookListView bookListView = new BookListView();
                loginPageView.dispose();
            } else {
                JOptionPane.showMessageDialog(loginPageView, "Login Failed");
            }
        }
    }
    private class SignUpButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignUpController signUpController = new SignUpController(new SignUpPageView());

        }
    }
}
