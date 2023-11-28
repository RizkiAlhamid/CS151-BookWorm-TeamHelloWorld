package Controllers;

import Database.BookDAO;
import Models.Book;
import Views.AddingBookPageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingBookPageController {
    private AddingBookPageView view;
    private ManageBookPageController delegate;
    // ====== Book Database Here ======
    private BookDAO bookDatabase = new BookDAO();

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
            int year = Integer.parseInt(view.getYearValue());
            String genre = view.getGenreValue();
            Book newBook = new Book(bookName, author, year,genre);
            // ====== Add new book to the database here ======
            bookDatabase.addBook(newBook);

            // this add the new book to the table
            delegate.addBook(newBook);
            view.dispose();
        }
    }
}
