package Controllers;

import Views.SignUpPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private SignUpPageView signUpPageView;

    public SignUpController(SignUpPageView signUpPageView) {
        this.signUpPageView = signUpPageView;
        signUpPageView.addCancelButtonActionListener(new CancelButtonClickListener());
        signUpPageView.addEnterButtonActionListener(new EnterButtonClickListener());
    }

    private class CancelButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            signUpPageView.dispose();
        }
    }

    private class EnterButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = signUpPageView.getFirstNameValue();
            String lastName = signUpPageView.getLastNameValue();
            String password = signUpPageView.getPasswordValue();

        }

        private String generateUserName(String firstName, String lastName, String password) {
            return "";
        }
    }
}
