package Controllers;

import Models.Book;
import Models.User;
import Views.ReturnBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookPageController {
    private ReturnBookPageView view;
    private User user;
    // ====== Book Database here ======
    // ====== User Database here ======

    public ReturnBookPageController(ReturnBookPageView view, User user) {
        this.view = view;
        this.user = user;
        view.setReturnButtonActionListener(new ReturnButtonClickListener());
        view.populateTable(user.getRentedBooks());
    }
    private class ReturnButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book returnedBook = view.getSelectedBookData();
            if(returnedBook != null) {
                user.returnBook(returnedBook);
                // ====== Edit the returned book to be available in Book database ======
                // ====== Remove the returned book from the user in User database ======
            }
            // remove the book from the table
            view.returnBook();
        }
    }
}
