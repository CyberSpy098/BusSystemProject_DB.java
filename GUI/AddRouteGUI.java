package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddRouteGUI extends JFrame
{
    private JPanel AddRoutePannel;
    private JLabel Title;
    private JButton Addbutton;
    private JLabel Destinationabel;
    private JLabel SourceLabel;
    private JTextField Sourcefield;
    private JTextField destinationfield;
    private JButton backButton;


    public AddRouteGUI()
    {
        Border line = BorderFactory.createLineBorder(Color.white);
        SourceLabel.setBorder(line);
        Destinationabel.setBorder(line);
        Addbutton.setFocusable(false);
        backButton.setFocusable(false);
        add(AddRoutePannel);
        setBounds(550,200,850,550);
        setTitle("Pakistan Express");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Source = Sourcefield.getText();
                String Destination = destinationfield.getText();
                if (Sourcefield.getText().equals("") || destinationfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(AddRoutePannel, " Please fill all fields!");
                } else {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO Routes(route_id,route_source,route_destination) VALUES(route_id_seq.nextVal,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);

                        pst.setString(1, Source);
                        pst.setString(2, Destination);


                        pst.executeQuery();
                        System.out.println("Data saved successfully!");
                        JOptionPane.showMessageDialog(AddRoutePannel, "Route has been Added!");
                        Sourcefield.setText("");
                        destinationfield.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AddRoutePannel, ex);
                    }
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
    }

//    private void createUIComponents()
//    {
//        // TODO: place custom component creation code here
//        DefaultTableModel modell=new DefaultTableModel();
//        modell.addColumn("Index");
//        modell.addColumn("Source");
//        modell.addColumn("Destination");
//
//
//        for (int i = 0; i< HelpingAddRouteClass.getRoute(); i++)
//        {
//            String string0,string1,string2;
//            //Storing Data
//            string0= String.valueOf(i);
//            string1=HelpingAddRouteClass.getSource(i);
//            string2=HelpingAddRouteClass.getDestination(i);
//
//
//            String[] data={string0,string1,string2};
//            modell.addRow(data);
//        }
//
//        table1=new JTable(modell);
//       // table1.setBackground(Color.yellow);
//    }
}
