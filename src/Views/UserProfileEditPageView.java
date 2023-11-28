package Views;

import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserProfileEditPageView extends JFrame {
    private JLabel usernameField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField passwordField;
    private User user;
    private JButton saveButton;

    public UserProfileEditPageView(User user) {
        this.user = user;
        // Set up the JFrame
        setTitle("User Profile Edit Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        // Create and configure components
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel firstNameLabel = new JLabel("Firstname: ");
        JLabel lastNameLabel = new JLabel("Lastname: ");
        JLabel passwordLabel = new JLabel("Password: ");

        usernameField = new JLabel(user.getUsername());
        lastNameField = new JTextField(user.getLastName());
        firstNameField = new JTextField(user.getFirstName());
        passwordField = new JTextField(user.getPassword());

        saveButton = new JButton("Save");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(5,2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(saveButton);
        // Add the panel to the frame
        add(panel);
        // Make the frame visible
        setVisible(true);
    }
    public void setSaveButtonActionListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
    public String getUsernameValue() { return usernameField.getText(); }
    public String getLastNameValue() { return lastNameField.getText(); }
    public String getFirstNameValue() { return firstNameField.getText(); }
    public String getPasswordValue() { return passwordField.getText(); }
}
