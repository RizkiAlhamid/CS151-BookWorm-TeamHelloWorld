package Views;

import Models.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReturnBookPageView extends JFrame {
    private DefaultTableModel tableModel;
    private JTable booksTable;
    private JButton returnButton;

    public ReturnBookPageView() {
        // Set up the JFrame
        setTitle("Your Rented Book List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        // Create a table model with columns: Title, Author, Genre
        String[] columns = {"Title", "Author", "Genre"};
        tableModel = new DefaultTableModel(columns, 0);

        // Create a JTable with the table model
        booksTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(booksTable);

        // Make the cells non-editable
        booksTable.setDefaultEditor(Object.class, null);

        // Add the table to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons and panel
        returnButton = new JButton("Rent Book");
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Add buttons to the panel
        buttonPanel.add(returnButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }
    public void addBook(String title, String author, String genre) {
        tableModel.addRow(new Object[]{title, author, genre});
    }
    public void returnBook() {
        int selectedRow = booksTable.getSelectedRow();
        if(selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a book to return.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Book getSelectedBookData() {
        int selectedRow = booksTable.getSelectedRow();
        if(selectedRow != -1) {
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            String author = (String) tableModel.getValueAt(selectedRow, 1);
            String genre = (String) tableModel.getValueAt(selectedRow, 2);
            return new Book(name, author, genre);
        } else {
            return null;
        }
    }
    public void populateTable(ArrayList<Book> books) {
        for(Book book: books) {
            addBook(book.getName(), book.getAuthor(), book.getGenre());
        }
    }
    public void setReturnButtonActionListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }
}
