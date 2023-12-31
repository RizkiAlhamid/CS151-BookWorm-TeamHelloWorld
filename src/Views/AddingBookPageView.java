package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingBookPageView extends JFrame {
    private JTextField bookNameField;
    private JTextField authorField;
    private JTextField genreField;
    private JTextField yearField;
    //more

    private JButton cancelButton;
    private JButton enterButton;
    public AddingBookPageView() {
        // Set up the JFrame
        setTitle("Adding Book Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,150);
        setLocationRelativeTo(null);

        // Create and configure components
        JLabel bookNameLabel = new JLabel("Book Name: ");
        JLabel authorLabel = new JLabel("Author: ");
        JLabel genreLabel = new JLabel("Genre: ");
        JLabel yearLabel = new JLabel("Year: ");

        bookNameField = new JTextField(20);
        authorField = new JTextField(20);
        genreField = new JTextField(20);
        yearField = new JTextField(20);

        cancelButton = new JButton("Cancel");
        // Action Listener for cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        enterButton = new JButton("Enter");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(5,2));
        panel.add(bookNameLabel);
        panel.add(bookNameField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(yearLabel);
        panel.add(yearField);
        panel.add(genreLabel);
        panel.add(genreField);
        panel.add(cancelButton);
        panel.add(enterButton);
        // Add the panel to the frame
        add(panel);
        // Make the frame visible
        setVisible(true);
    }
    public void setEnterButtonActionListener(ActionListener listener) {
        enterButton.addActionListener(listener);
    }
    public String getBookNameValue() {
        return bookNameField.getText();
    }
    public String getAuthorValue() {
        return authorField.getText();
    }
    public String getYearValue() { return yearField.getText(); }
    public String getGenreValue() { return genreField.getText(); }

}
