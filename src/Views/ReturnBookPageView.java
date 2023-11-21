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
        String[] columns = {"Title", "Author","Year", "Genre"};
        tableModel = new DefaultTableModel(columns, 0);

        // Create a JTable with the table model
        booksTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(booksTable);

        // Make the cells non-editable
        booksTable.setDefaultEditor(Object.class, null);

        // Add the table to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons and panel
        returnButton = new JButton("Return Book");
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Add buttons to the panel
        buttonPanel.add(returnButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }
    public void addBook(Book book) {
        tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
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
    public String getSelectedBookTitle() {
        int selectedRow = booksTable.getSelectedRow();
        if(selectedRow != -1) {
            String title = (String) tableModel.getValueAt(selectedRow, 0);
            return title;
        } else {
            return null;
        }
    }
    public void populateTable(ArrayList<Book> books) {
        for(Book book: books) {
            addBook(book);
        }
    }
    public void setReturnButtonActionListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }
}
