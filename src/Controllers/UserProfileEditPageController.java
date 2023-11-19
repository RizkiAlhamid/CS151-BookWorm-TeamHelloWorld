package Controllers;

import Models.User;
import Views.UserProfileEditPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileEditPageController {
    private UserProfileEditPageView view;
    private User user;
    // ====== User Database here ======

    public UserProfileEditPageController(UserProfileEditPageView view, User user) {
        this.view = view;
        this.user = user;
        view.setSaveButtonActionListener(new SaveButtonClickListener());
    }
    private class SaveButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            user.setFirstName(view.getFirstNameValue());
            user.setLastName(view.getLastNameValue());
            user.setPassword(view.getPasswordValue());
            // ======= edit user data in the database ======
            view.dispose();
        }
    }
}
