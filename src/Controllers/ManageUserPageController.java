package Controllers;

import Views.ManageUserPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserPageController {
    private ManageUserPageView view;

    public ManageUserPageController(ManageUserPageView view) {
        this.view = view;
        view.setRemoveButtonActionListener(new RemoveButtonClickListener());
    }
    private class RemoveButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.removeUser();
        }
    }
}
