package Controllers;

import Models.User;
import Views.RentBookPageView;
import Views.ReturnBookPageView;
import Views.UserHomePageView;
import Views.UserProfileEditPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserHomePageController {
    private UserHomePageView view;
    private User user;

    public UserHomePageController(UserHomePageView view, User user) {
        this.view = view;
        this.user = user;
        view.setEditProfileButtonActionListener(new EditProfileButtonClickListener());
        view.setRentBookButtonActionListener(new RentBookButtonActionListener());
        view.setReturnBookButtonActionListener(new ReturnBookActionListener());
    }
    private class EditProfileButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserProfileEditPageView view = new UserProfileEditPageView(user);
            UserProfileEditPageController controller = new UserProfileEditPageController(view, user);
        }
    }
    private class RentBookButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.currentOpenedWindow != null) {
                view.currentOpenedWindow.dispose();
            }
            RentBookPageView newView = new RentBookPageView();
            RentBookPageController controller = new RentBookPageController(newView, user);
            view.currentOpenedWindow = newView;
        }
    }
    private class ReturnBookActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.currentOpenedWindow != null) {
                view.currentOpenedWindow.dispose();
            }
            ReturnBookPageView newView = new ReturnBookPageView();
            ReturnBookPageController controller = new ReturnBookPageController(newView, user);
            view.currentOpenedWindow = newView;
        }
    }
}
