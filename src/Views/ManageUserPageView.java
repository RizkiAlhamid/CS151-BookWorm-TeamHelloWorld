package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManageUserPageView extends JFrame {
    private DefaultTableModel tableModel;
    private JTable usersTable;
    private JButton removeButton;

    public ManageUserPageView() {
        // Set up the JFrame
        setTitle("Manage User List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        // Create a table model with columns: Username, Last Name, First Name
        String[] columns = {"Username", "Last Name", "First Name"};
        tableModel = new DefaultTableModel(columns, 0);

        // Create a JTable with the table model
        usersTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(usersTable);

        // Make the cells non-editable
        usersTable.setDefaultEditor(Object.class, null);

        // Add the table to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Add some users
        tableModel.addRow(new Object[]{"RA", "Alhamid", "Rizki"});
        tableModel.addRow(new Object[]{"HS", "Saib", "Harun"});
        tableModel.addRow(new Object[]{"AA", "Amriah", "Amir"});

        // Create buttons and panel
        removeButton = new JButton("Remove User");
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Add buttons to the panel
        buttonPanel.add(removeButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }
    public void removeUser() {
        int selectedRow = usersTable.getSelectedRow();
        if(selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a user to remove.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setRemoveButtonActionListener(ActionListener listener) {
        removeButton.addActionListener(listener);
    }
}
