package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPageView extends JFrame {
    private JTextField idNumberField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

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
        signupButton = new JButton("Sign Up");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(4,2));
        panel.add(idNumberLabel);
        panel.add(idNumberField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        panel.add(new JLabel());
        panel.add(signupButton);
        // Add the panel to the frame
        add(panel);
        // Make the frame visible
        setVisible(true);
    }
    public void setLoginButtonActionListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
    public void setSignUpButtonActionListener(ActionListener listener) {
        signupButton.addActionListener(listener);
    }
    public String getUserIdValue() {
        return idNumberField.getText();
    }
    public String getPasswordValue() {
        return new String(passwordField.getPassword());
    }
}
