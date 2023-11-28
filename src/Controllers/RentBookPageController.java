package Controllers;

import Database.BookDAO;
import Database.UserDAO;
import Models.Book;
import Models.User;
import Views.RentBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentBookPageController {
    private RentBookPageView view;
    private User user;
    // ====== User Database here ======
    private UserDAO userDatabase = new UserDAO();
    // ====== Book Database here ======
    private BookDAO bookDatabase = new BookDAO();

    public RentBookPageController(RentBookPageView view, User user) {
        this.view = view;
        this.user = user;
        view.setRentButtonActionListener(new RentBookButtonClickListener());

        // ====== populate the table with available books from database ======
        view.populateTable(bookDatabase.getAllAvailableBooks());
    }
    private class RentBookButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String rentedBook = view.getSelectedBookTitle();
            if(rentedBook != null) {
                bookDatabase.markBookAsRented(rentedBook, user.getUsername());
            }
            // remove the book from the table
            view.rentBook();
        }
    }
}
