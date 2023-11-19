package Views;

import Models.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManageBookPageView extends JFrame {
    private DefaultTableModel tableModel;
    private JTable booksTable;
    private JButton addButton;
    private JButton removeButton;

    public ManageBookPageView() {
        // Set up the JFrame
        setTitle("Manage Book List");
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

        // Add some books
        addBook("Calculus 1", "Author 1", "Fiction");
        addBook("Calculus 2", "Author 2", "Sci-Fi");
        addBook("Calculus 3", "Author 3", "Education");

        // Create buttons and panel
        addButton = new JButton("Add Book");
        removeButton = new JButton("Remove Book");
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }
    public void addBook(String title, String author, String genre) {
        tableModel.addRow(new Object[]{title, author, genre});
    }
    public void removeBook() {
        int selectedRow = booksTable.getSelectedRow();
        if(selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a book to remove.",
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
    public void setAddButtonActionListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
    public void setRemoveButtonActionListener(ActionListener listener) {
        removeButton.addActionListener(listener);
    }
}
