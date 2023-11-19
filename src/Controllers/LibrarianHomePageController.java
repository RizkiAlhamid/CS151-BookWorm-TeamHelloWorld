package Controllers;

import Views.LibrarianHomePageView;
import Views.ManageBookPageView;
import Views.ManageUserPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianHomePageController {
    private LibrarianHomePageView view;

    public LibrarianHomePageController(LibrarianHomePageView view) {
        this.view = view;
        view.setManageBookButtonActionListener(new ManageBookButtonClickListener());
        view.setManageUserButtonActionListener(new ManageUserButtonClickListener());
    }

    private class ManageBookButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Go to manage book view
            ManageBookPageView view = new ManageBookPageView();
            ManageBookPageController controller = new ManageBookPageController(view);
        }
    }
    private class ManageUserButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Go to manage user view
            ManageUserPageView view = new ManageUserPageView();
            ManageUserPageController controller = new ManageUserPageController(view);
        }
    }
}
