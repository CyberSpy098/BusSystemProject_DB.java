package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginGUI extends JFrame
{
    private JTextField Usernamefield1;
    private JLabel Username;
    private JPanel Loginpannel;
    private JButton Login;
    private JPasswordField passwordField1;
    private JLabel WrongPassField;
    private JButton backButton;
    private JLabel Password;

    public LoginGUI()
    {
        Login.setFocusable(false);
        backButton.setFocusable(false);
        add(Loginpannel);
        setBounds(400,150,850,550);
        Border line = BorderFactory.createLineBorder(Color.white);
        Username.setBorder(line);
        Password.setBorder(line);
        setTitle("Pakistan Express");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Login.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String userName =Usernamefield1.getText();
                String password = passwordField1.getText();
                try
                {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","online_BusReservation","group");
                    System.out.print("Connection Sucessful");
                    PreparedStatement pst=conn.prepareStatement("Select * from login where username=? and password=?");
                    pst.setString(1,userName);
                    pst.setString(2,password);
                    ResultSet rs=pst.executeQuery();

                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(Loginpannel,"Success");

                        dispose();
                        new AdminGUIPannel().setVisible(true);
                        Usernamefield1.setText("");
                        passwordField1.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(Loginpannel,"Invalid Credientials");
                        Usernamefield1.setText("");
                        passwordField1.setText("");
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex);
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new WelcomeGUI().setVisible(true);
                dispose();
            }
        });
    }

}
