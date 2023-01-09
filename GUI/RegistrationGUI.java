package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationGUI extends JFrame {
    private JPanel pannel;
    private JTextField Namefield;
    private JTextField ContactField2;
    private JTextField AddressField3;
    private JTextField emailField4;
    private JTextField passwordfield;
    private JButton registerButton;
    private JButton backButton;
    private JLabel name;
    private JLabel contact;
    private JLabel email;
    private JLabel password;
    private JLabel title;

    public RegistrationGUI()
    {
         backButton.setFocusable(false);
         registerButton.setFocusable(false);
        setBounds(550,200,850,550);
        setTitle("Welcome to Pakistan Express");
        add(pannel);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Name = Namefield.getText();
                String Contact = ContactField2.getText();
                String Password = passwordfield.getText();
                String Email = emailField4.getText();

                if (Namefield.getText().equals("")
                        || ContactField2.getText().equals("")
                        || emailField4.getText().equals("")
                        || passwordfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(pannel, " Please fill all fields!");
                }
                else
                {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO USER_SIGNUP(cus_id,cus_name,cus_email,cus_phone,cus_password) VALUES(cus_id_seq.nextVal,?,?,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);

                        pst.setString(1, Name);
                        pst.setString(2, Email);
                        pst.setString(3, Contact);
                        pst.setString(4, Password);

                        pst.executeQuery();
                        System.out.println("Data saved successfully!");
                        Namefield.setText("");
                        ContactField2.setText("");
                        passwordfield.setText("");
                        emailField4.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pannel, ex);
                    }

                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserLoginGUI().setVisible(true);
                dispose();
            }
        });
    }
}
