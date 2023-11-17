package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookListView extends JFrame {
    private DefaultTableModel tableModel;
    private JTable booksTable;

    public BookListView() {
        // Set up the JFrame
        setTitle("Library Book List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        // Create a table model with columns: Title, Author, Genre
        String[] columns = {"Title", "Author", "Genre"};
        tableModel = new DefaultTableModel(columns, 0);

        // Create a JTable with the table model
        booksTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(booksTable);

        // Add the table to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Add some books
        addBook("Calculus 1", "Author 1", "Fiction");
        addBook("Calculus 2", "Author 2", "Sci-Fi");
        addBook("Calculus 3", "Author 3", "Education");

        // Make the frame visible
        setVisible(true);
    }

    private void addBook(String title, String author, String genre) {
        tableModel.addRow(new Object[]{title, author, genre});
    }
}
