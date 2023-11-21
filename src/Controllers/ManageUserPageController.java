package Controllers;

import Database.UserDAO;
import Views.ManageUserPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserPageController {
    private ManageUserPageView view;
    // ====== User Database Here ======
    private UserDAO userDatabase = new UserDAO();

    public ManageUserPageController(ManageUserPageView view) {
        this.view = view;
        view.setRemoveButtonActionListener(new RemoveButtonClickListener());
        view.populateTable(userDatabase.getAllUsers());
    }
    private class RemoveButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedUser = view.getSelectedUser();
            if(selectedUser != null) {
                userDatabase.deleteUser(selectedUser);
            }
            view.removeUser();
        }
    }
}
