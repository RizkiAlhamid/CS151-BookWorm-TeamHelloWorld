package Controllers;

import Views.SignUpPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPageController {
    private SignUpPageView view;
    // ====== User database here ======

    public SignUpPageController(SignUpPageView view) {
        this.view = view;
        view.setEnterButtonActionListener(new EnterButtonClickListener());

    }

    private class EnterButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = view.getFirstNameValue();
            String lastName = view.getLastNameValue();
            String username = generateUserName(firstName, lastName);
            String password = view.getPasswordValue();
            // ====== Save user data to database here =======

            view.dispose();
        }
        private String generateUserName(String firstName, String lastName) {
            return "";
        }
    }
}
