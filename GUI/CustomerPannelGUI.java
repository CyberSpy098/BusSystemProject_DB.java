package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPannelGUI extends JFrame
{
    private JPanel CustomerPannel;
    private JLabel Bookingt;
    private JButton bookTicketButton;
    private JButton myBookingsButton;
    private JButton backButton;

    public CustomerPannelGUI()
    {
        bookTicketButton.setFocusable(false);
        myBookingsButton.setFocusable(false);
        backButton.setFocusable(false);
        add(CustomerPannel);
        setBounds(550,200,850,550);
        setVisible(true);
        setTitle("Welcome to Pakistan Express");
        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new TicketBookingGUI().setVisible(true);
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               new WelcomeGUI().setVisible(true);
               dispose();
            }
        });
        myBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              new MyBookingsGUI().setVisible(true);
              dispose();
            }
        });
    }
}
