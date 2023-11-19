package Controllers;

import Models.Book;
import Views.AddingBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingBookPageController {
    private AddingBookPageView view;
    private ManageBookPageController delegate;
    // ====== Book Database Here ======

    public AddingBookPageController(AddingBookPageView view, ManageBookPageController delegate) {
        this.view = view;
        this.delegate = delegate;
        view.setEnterButtonActionListener(new EnterButtonClickListener());
    }
    private class EnterButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String bookName = view.getBookNameValue();
            String author = view.getAuthorValue();
            String genre = view.getGenreValue();
            Book newBook = new Book(bookName, author, genre);
            // ====== Add new book to the database here ======


            // this add the new book to the table
            delegate.addBook(bookName, author, genre);
            view.dispose();
        }
    }
}
