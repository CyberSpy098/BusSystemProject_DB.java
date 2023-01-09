package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel address;
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
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (Namefield.getText().equals("")
                        || ContactField2.getText().equals("")
                        || AddressField3.getText().equals("")
                        || emailField4.getText().equals("")
                        || passwordfield.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(pannel, " Please fill all fields!");
                }
                else
                {
                        /*HelpingRegistration.setRName(Namefield.getText(), HelpingRegistration.getRegisterCount());
                        HelpingRegistration.setRContact(ContactField2.getText(), HelpingRegistration.getRegisterCount());
                        HelpingRegistration.setRAddress(AddressField3.getText(), HelpingRegistration.getRegisterCount());
                        HelpingRegistration.setREmail(emailField4.getText(),HelpingRegistration.getRegisterCount());
                        HelpingRegistration.setRPassword(passwordfield.getText(),HelpingRegistration.getRegisterCount());

                        HelpingRegistration.AddRegisterCount();
                        JOptionPane.showMessageDialog(pannel, " Registered sucessfully!");
                        Namefield.setText("");
                        ContactField2.setText("");
                        AddressField3.setText("");
                        emailField4.setText("");
                        passwordfield.setText("");*/
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
