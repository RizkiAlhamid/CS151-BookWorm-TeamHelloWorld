package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageView extends JFrame {
    private JTextField idNumberField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private String librarianID = "admin";
    private String librarianPassword = "admin";

    public LoginPageView() {
        // Set up the JFrame
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setLocationRelativeTo(null);

        // Create and configure components
        JLabel idNumberLabel = new JLabel("ID Number: ");
        JLabel passwordLabel = new JLabel("Password: ");

        idNumberField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(3,2));
        panel.add(idNumberLabel);
        panel.add(idNumberField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        // Action listener for the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idNumber = idNumberField.getText();
                String password = new String(passwordField.getPassword());

                if(idNumber.equals(librarianID) && password.equals(librarianPassword)) {
                    JOptionPane.showMessageDialog(LoginPageView.this, "Librarian Login");
                    BookListView bookListView = new BookListView();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginPageView.this, "Login Failed");
                }
            }
        });

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }
}
