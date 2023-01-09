package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegistrationGUI extends JFrame {
    private JTextField UserField1;
    private JTextField ContactField2;
    private JTextField AdddressField3;
    private JTextField textField4;
    private JTextField PasswordField5;
    private JButton registerButton;
    private JButton backButton;
    private JLabel name;
    private JLabel contact;
    private JLabel address;
    private JLabel email;
    private JPanel Pannel;

    public AdminRegistrationGUI()
    {
        add(Pannel);
        setBounds(550,200,850,550);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminGUIPannel().setVisible(true);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (
                           UserField1.getText().equals("")
                        || ContactField2.getText().equals("")
                        || AdddressField3.getText().equals("")
                        || textField4.getText().equals("") || textField4.getText().equals("")
                        || PasswordField5.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(Pannel, " Please fill all fields!");
                }
                else
                {
                    /*HelpingRegistration.setRName(UserField1.getText(), HelpingRegistration.getRegisterCount());
                    HelpingRegistration.setRContact(ContactField2.getText(), HelpingRegistration.getRegisterCount());
                    HelpingRegistration.setRAddress(textField4.getText(), HelpingRegistration.getRegisterCount());
                    HelpingRegistration.setRPassword(textField4.getText(),HelpingRegistration.getRegisterCount());
                    HelpingRegistration.setREmail(PasswordField5.getText(),HelpingRegistration.getRegisterCount());


                    HelpingRegistration.AddRegisterCount();*/
                    JOptionPane.showMessageDialog(Pannel, " Registered sucessfully!");
                    UserField1.setText("");
                    ContactField2.setText("");
                    AdddressField3.setText("");
                    textField4.setText("");
                    PasswordField5.setText("");
                }
            }
        });
    }
}
