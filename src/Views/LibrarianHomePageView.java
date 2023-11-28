package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LibrarianHomePageView extends JFrame {
    private JButton manageBookButton;
    private JButton manageUserButton;

    public LibrarianHomePageView()  {
        // Set up the JFrame
        setTitle("Librarian Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        manageBookButton = new JButton("Manage Book");
        manageUserButton = new JButton("Manage User");

        // Create a panel to place all the components
        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.add(manageBookButton);
        panel.add(manageUserButton);

        // Add the panel to the frame
        add(panel);
        // Make the frame visible
        setVisible(true);

    }
    public void setManageBookButtonActionListener(ActionListener listener) {
        manageBookButton.addActionListener(listener);
    }
    public void setManageUserButtonActionListener(ActionListener listener) {
        manageUserButton.addActionListener(listener);
    }
}
