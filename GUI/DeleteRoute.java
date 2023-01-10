package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteRoute extends JFrame
{
    private JTable table1;
    private JScrollPane Scroll;
    private JPanel pannel;
    private JButton backButton;
    private JButton deleteButton;
    private JTextField indexField;
    private JLabel index;


    public DeleteRoute()
    {
        backButton.setFocusable(false);
        deleteButton.setFocusable(false);
        add(pannel);
        setBounds(400,150,850,550);
        setTitle("Pakistan Express");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
               new AdminGUIPannel().setVisible(true);
               dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int Id=Integer.parseInt(indexField.getText());
                try {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                    System.out.print("Connection Sucessful");
                    // Create a statement
                    String sql = "DELETE FROM Routes WHERE route_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setInt(1, Id);

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
    }

    private void createUIComponents() throws SQLException {
        // TODO: place custom component creation code here
        DefaultTableModel modell = new DefaultTableModel();
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
            System.out.print("Connection Sucessful");
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a select query
            String sql = "SELECT * FROM Routes ";
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
            JOptionPane.showMessageDialog(pannel, ex);
        }
        table1=new JTable(modell);
    }
}
