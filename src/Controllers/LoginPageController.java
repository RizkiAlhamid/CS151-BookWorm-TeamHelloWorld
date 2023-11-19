package Controllers;

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

    public LoginPageController(LoginPageView view) {
        this.view = view;
        this.view.setLoginButtonActionListener(new LoginButtonClickListener());
        this.view.setSignUpButtonActionListener(new SignUpButtonClickListener());
    }

    private class LoginButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idNumber = view.getUserIdValue();
            String password = view.getPasswordValue();

            // ====== Login Logic Here ======
            if(idNumber.equals(librarianID) && password.equals(librarianPassword)) {
                JOptionPane.showMessageDialog(view, "Librarian Login");
                LibrarianHomePageView view = new LibrarianHomePageView();
                LibrarianHomePageController librarianHomePageController = new LibrarianHomePageController(view);
                LoginPageController.this.view.dispose();
            } else if(idNumber.equals("RA-1948") && password.equals("SJSU123")) {
                JOptionPane.showMessageDialog(view, "User Login");
                User user = new User();
                UserHomePageView view = new UserHomePageView(user);
                UserHomePageController controller = new UserHomePageController(view, user);
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
