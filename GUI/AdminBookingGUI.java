package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminBookingGUI extends JFrame
{
    private JPanel Pannel;
    private JLabel title;
    private JTable table1;
    private JButton backButton;
    private JTextField textField1;
    private JButton deleteBookingButton;

    public AdminBookingGUI()
    {
        setBounds(400,150,850,550);
        add(Pannel);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
        deleteBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                int serial=Integer.parseInt(textField1.getText());
                try {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                    System.out.print("Connection Sucessful");
                    // Create a statement
                    String sql = "DELETE FROM Ticket_Booking WHERE ticket_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setInt(1, serial);

                    // Execute the delete statement
                    int rowDeleted = pstmt.executeUpdate();
                    if (rowDeleted > 0) {
                        System.out.println("A row has been deleted successfully!");
                        dispose();
                        new AdminBookingGUI().setVisible(true);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
            System.out.print("Connection Sucessful");
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a select query
            String sql = "SELECT * FROM Ticket_Booking";
            ResultSet rs = stmt.executeQuery(sql);

            // Get the metadata of the result set
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get the number of columns in the result set
            int columnCount = rsmd.getColumnCount();
            // Add the column names to the model
            for (int i = 1; i <= columnCount; i++) {
                modell.addColumn(rsmd.getColumnName(i));
            }

            // Add the rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                modell.addRow(row);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Pannel, ex);
        }

        table1=new JTable(modell);
        table1.setBackground(Color.white);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //Cent
        // er Side
        DefaultTableCellRenderer Centerrendere=new DefaultTableCellRenderer();
        Centerrendere.setHorizontalAlignment(JLabel.CENTER);
        //Index
        table1.getColumnModel().getColumn(0).setMaxWidth(90);
        table1.getColumnModel().getColumn(0).setMinWidth(90);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //Name
        table1.getColumnModel().getColumn(1).setMinWidth(90);
        table1.getColumnModel().getColumn(1).setMaxWidth(90);
        //CNIC
        table1.getColumnModel().getColumn(2).setMinWidth(140);
        table1.getColumnModel().getColumn(2).setMaxWidth(140);
        //Contact
        table1.getColumnModel().getColumn(3).setMinWidth(120);
        table1.getColumnModel().getColumn(3).setMaxWidth(120);
        table1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //Date
        table1.getColumnModel().getColumn(4).setMinWidth(120);
        table1.getColumnModel().getColumn(4).setMaxWidth(120);
        table1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer
        );
        //Time
        table1.getColumnModel().getColumn(5).setMinWidth(70);
        table1.getColumnModel().getColumn(5).setMaxWidth(70);

        //To
        table1.getColumnModel().getColumn(6).setMinWidth(100);
        table1.getColumnModel().getColumn(6).setMaxWidth(100);
        table1.getColumnModel().getColumn(6).setCellRenderer(Centerrendere);
        //From
        table1.getColumnModel().getColumn(7).setMinWidth(100);
        table1.getColumnModel().getColumn(7).setMaxWidth(100);
        table1.getColumnModel().getColumn(7).setCellRenderer(Centerrendere);
    }
}
