package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpPageView extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;
    private JButton cancelButton;
    private JButton enterButton;

    public SignUpPageView() {
        // Set up the JFrame
        setTitle("Sign Up Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setLocationRelativeTo(null);

        // Create and configure components
        JLabel firstNameLabel = new JLabel("Firstname: ");
        JLabel lastNameLabel = new JLabel("Lastname: ");
        JLabel passwordLabel = new JLabel("Password: ");

        lastNameField = new JTextField(20);
        firstNameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        cancelButton = new JButton("Cancel");
        enterButton = new JButton("Enter");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(4,2));
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(cancelButton);
        panel.add(enterButton);
        // Add the panel to the frame
        add(panel);
        // Make the frame visible
        setVisible(true);
    }
    public void addCancelButtonActionListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }
    public void addEnterButtonActionListener(ActionListener listener) {
        enterButton.addActionListener(listener);
    }
    public String getFirstNameValue() {
        return firstNameField.getText();
    }
    public String getLastNameValue() {
        return lastNameField.getText();
    }
    public String getPasswordValue() {
        return new String(passwordField.getPassword());
    }
}
