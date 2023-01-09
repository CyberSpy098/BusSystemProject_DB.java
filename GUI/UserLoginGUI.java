package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginGUI extends JFrame
{
    private JTextField UserField1;
    private JTextField PasswordField2;
    private JButton loginButton;
    private JButton backButton;
    private JPanel pannel;
    private JButton registrationButton;

    public UserLoginGUI()
    {
        backButton.setFocusable(false);
        loginButton.setFocusable(false);

        add(pannel);
        setBounds(550,200,850,550);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WelcomeGUI().setVisible(true);
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(UserField1.getText().equals("")||PasswordField2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(pannel, "Please fill all fields!");
                }
                else
                {
                   /* for(int i=0;i<HelpingRegistration.getRegisterCount();i++)
                    {
                        if(Objects.equals(UserField1.getText(),HelpingRegistration.getRName(i))
                                &&Objects.equals(PasswordField2.getText(),HelpingRegistration.getRPassword(i)))
                        {
                            HelpingRegistration.setIndex(i);
                            new CustomerPannelGUI().setVisible(true);
                            dispose();
                        }

                    }*/
                }
            }
        });
        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new RegistrationGUI().setVisible(true);
                dispose();
            }
        });
    }
}
