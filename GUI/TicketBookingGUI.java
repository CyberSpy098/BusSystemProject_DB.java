package GUI;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TicketBookingGUI extends JFrame
{
    private JPanel pannel;
    private JButton backbutton;
    private JTextField NametextField;
    private JLabel header;
    private JLabel Namelabel;
    private JTextField CNICField;
    private JTextField PhoneNumberField;
    private JComboBox FromBox;
    private JComboBox ToBox;
    private JLabel PhoneNumberLabel;
    private JLabel FromLabel;
    private JLabel ToLabel;
    private JButton Bookbutton;
    private JLabel CNICLabel;
    private JComboBox timebox;
    private JLabel datelabel;
    private JLabel timelabel;
    private DatePicker date;
    private JComboBox comboBox1;

    public TicketBookingGUI()
    {

        backbutton.setFocusable(false);
        Bookbutton.setFocusable(false);
        add(pannel);
        setBounds(400,150,850,550);

        Border line = BorderFactory.createLineBorder(Color.white);
        Namelabel.setBorder(line);
        CNICLabel.setBorder(line);
        FromLabel.setBorder(line);
        ToLabel.setBorder(line);
        PhoneNumberLabel.setBorder(line);
        datelabel.setBorder(line);
        timelabel.setBorder(line);
        fillComboBox();
        destinationCombo();
        BusComboBo();
       // destinationCombo();




        setTitle("Pakistan Express");
        timebox.addItem("Select");
        timebox.addItem("9:00AM");
        timebox.addItem("11:00PM");
//
//        FromBox.addItem("Select");
//        FromBox.addItem("Islamabad");
//        FromBox.addItem("Peshawar");
//        FromBox.addItem("Karachi");
//        FromBox.addItem("Lahore");
//
//        ToBox.addItem("Select");
//        ToBox.addItem("Lahore");
//        ToBox.addItem("Karachi");
//        ToBox.addItem("Islamabad");
//        ToBox.addItem("Peshawar");

        //setVisible(true);
        // public void fill_comboBox() {



        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
               new CustomerPannelGUI().setVisible(true);
               dispose();
            }
        });
        Bookbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (NametextField.getText().equals("")
                        || CNICField.getText().equals("")
                        || PhoneNumberField.getText().equals("")
                        || timebox.getSelectedItem().equals("")
                        || FromBox.getSelectedItem().equals("")
                        || ToBox.getSelectedItem().equals("")
                        || date.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(pannel, " Please fill all fields!");
                }
                else if(FromBox.getSelectedIndex()==0 || ToBox.getSelectedIndex()==0||timebox.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(pannel, "Please Select all options!");
                }
                else {
                    if (FromBox.getSelectedItem() == ToBox.getSelectedItem())
                    {
                        JOptionPane.showMessageDialog(pannel, "Destination cannot be same!");
                    }
                    else
                    {
                        String Name =NametextField.getText();
                        String CNIC=CNICField.getText();
                        String Phone_Number=PhoneNumberField.getText();
                        String Source=FromBox.getSelectedItem().toString();
                        String Destination=ToBox.getSelectedItem().toString();
                        String Date = date.toString();
                        String Time=timebox.getSelectedItem().toString();

                        try {
                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                            System.out.print("Connection Sucessful");
                            String sql = "INSERT INTO Ticket_Booking(Ticket_id,customer_name ,CNIC ,Phone_Number,Departure ,Arrival ,Ticket_Date,Time) " +
                            "VALUES(Ticket_id_seq.nextVal,?,?,?,?,?,?,?)";
                            PreparedStatement pst = ((Connection) conn).prepareStatement(sql);
                            pst.setString(1, Name);
                            pst.setString(2, CNIC);
                            pst.setString(3, Phone_Number);
                            pst.setString(4, Source);
                            pst.setString(5, Destination);
                            pst.setString(6, Date);
                            pst.setString(7, Time);


                            pst.executeQuery();
                            System.out.println("Data saved successfully!");
                            NametextField.setText("");
                            CNICField.setText("");
                            PhoneNumberField.setText("");
                            ToBox.setSelectedItem("");
                            FromBox.setSelectedItem("");
                            timebox.setSelectedItem("");
                            date.setText("");

                            new PaymentGUI().setVisible(true);
                            dispose();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(pannel, ex);
                        }
                    }
                }


            }
        });

    }

    public void fillComboBox()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
            System.out.print("Connection Sucessful");
            String sql="Select ROUTE_SOURCE from ROUTES";
            PreparedStatement pst = ((Connection) conn).prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                String data = rs.getString("ROUTE_SOURCE");
                ToBox.addItem(data);
            }
            System.out.println("Data saved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void destinationCombo()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
            System.out.print("Connection Sucessful");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select ROUTE_DESTINATION from ROUTES");
            while (rs.next()) {
                String data = rs.getString("ROUTE_DESTINATION");
                FromBox.addItem(data);
            }

            System.out.println("Data saved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void BusComboBo()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
            System.out.print("Connection Sucessful");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select BUS_MODELYEAR from BUS");
            while (rs.next()) {
                String data = rs.getString("BUS_MODELYEAR");
                comboBox1.addItem(data);
            }

            System.out.println("Data saved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here


    }
}
