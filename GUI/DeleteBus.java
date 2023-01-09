package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteBus extends JFrame
{

    private JTable showTable;
    private JPanel panel;
    private JButton Backbutton;
    private JButton deleteButton;
    private JTextField indexfield;
    private JLabel indexlabel;


    public DeleteBus()
        {

            Border line = BorderFactory.createLineBorder(Color.white);
            indexlabel.setBorder(line);

            Backbutton.setFocusable(false);
            deleteButton.setFocusable(false);

            setBounds(550,200,850,650);
            setTitle("Pakistan Express");
            setBackground(Color.WHITE);
            setVisible(true);
            add(panel);


            Backbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new AdminGUIPannel().setVisible(true);
                    dispose();
                }
            });
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    int serial=Integer.parseInt(indexfield.getText());
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                        System.out.print("Connection Sucessful");
                        // Create a statement
                        String sql = "DELETE FROM BUS WHERE bus_id = ?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);

                        pstmt.setInt(1, serial);

                        // Execute the delete statement
                        int rowDeleted = pstmt.executeUpdate();
                        if (rowDeleted > 0) {
                            System.out.println("A row has been deleted successfully!");
                            dispose();
                            new DeleteBus().setVisible(true);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        };

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
            String sql = "SELECT * FROM BUS";
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
        }

        catch(Exception ex){
            JOptionPane.showMessageDialog(panel, ex);
        }
        showTable=new JTable(modell);
    }

}

