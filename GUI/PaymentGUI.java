package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PaymentGUI extends JFrame {
    private JPanel pannel;
    private JLabel header;
    private JLabel Namelabel;
    private JButton Bookbutton;
    private JButton backbutton;
    private JLabel CNICLabel;
    private JTextField CVCField;
    private JLabel PhoneNumberLabel;
    private JTextField CardTypeField;
    private JTextField CardField;

    public PaymentGUI() {
        add(pannel);
        setBounds(400,150,850,550);
        Bookbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CardNo=CardField.getText();
                String CVC=CVCField.getText();
                String CardType=CardTypeField.getText();

                try {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                    System.out.print("Connection Sucessful");
                    String sql = "INSERT INTO Payments(payment_id,CardNo,CVC ,CardType) " +
                            "VALUES(payment_id_seq.nextVal,?,?,?)";
                    PreparedStatement pst = ((Connection) conn).prepareStatement(sql);
                    pst.setString(1, CardNo);
                    pst.setString(2, CVC);
                    pst.setString(3, CardType);



                    pst.executeQuery();
                    System.out.println("Data saved successfully!");
                    JOptionPane.showMessageDialog(pannel,"Payment Successfully Completed");
                    CardField.setText("");
                    CVCField.setText("");
                    CardTypeField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pannel, ex);
                }
            }
        });
    }
}
