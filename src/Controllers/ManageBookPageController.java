package Controllers;

import Database.BookDAO;
import Models.Book;
import Views.AddingBookPageView;
import Views.ManageBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageBookPageController {
    private ManageBookPageView view;

    // ====== Book Database Here ======
    private BookDAO bookDatabase = new BookDAO();

    public ManageBookPageController(ManageBookPageView view) {
        this.view = view;
        view.setAddButtonActionListener(new AddButtonClickListener());
        view.setRemoveButtonActionListener(new RemoveButtonClickListener());

        // ====== populate the table with books from database ======
        view.populateTable(bookDatabase.getAllBooks());
    }
    public void addBook(Book book) {
        view.addBook(book);
    }
    private class AddButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // goes to adding book page
            AddingBookPageView view = new AddingBookPageView();
            AddingBookPageController controller = new AddingBookPageController(view,
                    ManageBookPageController.this);
        }
    }
    private class RemoveButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedBook = view.getSelectedBookTitle();
            if(selectedBook != null) {
                // ====== remove the selected book from database here ======
                bookDatabase.removeBook(selectedBook);
            }

            // this removes the book from the table
            view.removeBook();
        }
    }
}
