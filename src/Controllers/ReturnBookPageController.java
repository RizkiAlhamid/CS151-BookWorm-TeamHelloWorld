package Controllers;

import Database.BookDAO;
import Database.UserDAO;
import Models.Book;
import Models.User;
import Views.ReturnBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookPageController {
    private ReturnBookPageView view;
    private User user;
    // ====== Book Database here ======
    private BookDAO bookDatabase = new BookDAO();
    // ====== User Database here ======
    private UserDAO userDatabase = new UserDAO();

    public ReturnBookPageController(ReturnBookPageView view, User user) {
        this.view = view;
        this.user = user;
        view.setReturnButtonActionListener(new ReturnButtonClickListener());
        view.populateTable(bookDatabase.getAllBooksRentedByUser(user.getUsername()));
    }
    private class ReturnButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String returnedBook = view.getSelectedBookTitle();
            if(returnedBook != null) {
                // ====== Edit the returned book to be available in Book database ======
                bookDatabase.returnBook(returnedBook, user.getUsername());
            }
            // remove the book from the table
            view.returnBook();
        }
    }
}
