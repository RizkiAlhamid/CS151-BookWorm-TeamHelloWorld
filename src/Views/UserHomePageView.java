package Views;

import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserHomePageView extends JFrame {
    private JButton editProfileButton;
    private JButton rentBookButton;
    private JButton returnBookButton;
    private User user;
    public JFrame currentOpenedWindow;
    public UserHomePageView(User user)  {
        this.user = user;
        // Set up the JFrame
        setTitle("User Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        editProfileButton = new JButton("Edit Profile");
        rentBookButton = new JButton("Rent Book");
        returnBookButton = new JButton("Return Book");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(editProfileButton);
        panel.add(rentBookButton);
        panel.add(returnBookButton);

        // Add the panel to the frame
        add(panel);
        // Make the frame visible
        setVisible(true);

    }
    public void setEditProfileButtonActionListener(ActionListener listener) {
        editProfileButton.addActionListener(listener);
    }
    public void setRentBookButtonActionListener(ActionListener listener) {
        rentBookButton.addActionListener(listener);
    }
    public void setReturnBookButtonActionListener(ActionListener listener) {
        returnBookButton.addActionListener(listener);
    }
}
