package Controllers;

import Models.Book;
import Models.User;
import Views.RentBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentBookPageController {
    private RentBookPageView view;
    private User user;
    // ====== User Database here ======
    // ====== Book Database here ======

    public RentBookPageController(RentBookPageView view, User user) {
        this.view = view;
        this.user = user;
        view.setRentButtonActionListener(new RentBookButtonClickListener());

        // ====== populate the table with available books from database ======
        //view.populateTable(database.getBooks());
    }
    private class RentBookButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book rentedBook = view.getSelectedBookData();
            if(rentedBook != null) {
                user.addRentedBook(rentedBook);
                // ====== edit the rentedBook to not available in Book database ======
                // ====== edit user's rented book in User database ======
            }
            // remove the book from the table
            view.rentBook();
        }
    }
}
