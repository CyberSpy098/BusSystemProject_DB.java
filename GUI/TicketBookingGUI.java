package GUI;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private DatePicker date;
    private JComboBox timebox;
    private JLabel datelabel;
    private JLabel timelabel;

    public TicketBookingGUI()
    {
        backbutton.setFocusable(false);
        Bookbutton.setFocusable(false);
        add(pannel);
        setBounds(550,200,850,550);

        Border line = BorderFactory.createLineBorder(Color.white);
        Namelabel.setBorder(line);
        CNICLabel.setBorder(line);
        FromLabel.setBorder(line);
        ToLabel.setBorder(line);
        PhoneNumberLabel.setBorder(line);
        datelabel.setBorder(line);
        timelabel.setBorder(line);




        setTitle("Pakistan Express");
        timebox.addItem("Select");
        timebox.addItem("9:00AM");
        timebox.addItem("11:00PM");

        FromBox.addItem("Select");
        FromBox.addItem("Islamabad");
        FromBox.addItem("Peshawar");
        FromBox.addItem("Karachi");
        FromBox.addItem("Lahore");

        ToBox.addItem("Select");
        ToBox.addItem("Lahore");
        ToBox.addItem("Karachi");
        ToBox.addItem("Islamabad");
        ToBox.addItem("Peshawar");
        //setVisible(true);



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
                    } else
                    {
                       /* HelpingTicketBookingClass.setName(NametextField.getText(), HelpingTicketBookingClass.getTicket());
                        HelpingTicketBookingClass.setCNIC(CNICField.getText(), HelpingTicketBookingClass.getTicket());
                        HelpingTicketBookingClass.setPhone_Number(PhoneNumberField.getText(), HelpingTicketBookingClass.getTicket());
                        HelpingTicketBookingClass.setTime(timebox.getSelectedItem().toString(), HelpingTicketBookingClass.getTicket());
                        HelpingTicketBookingClass.setTo(ToBox.getSelectedItem().toString(), HelpingTicketBookingClass.getTicket());
                        HelpingTicketBookingClass.setFrom(FromBox.getSelectedItem().toString(), HelpingTicketBookingClass.getTicket());
                        HelpingTicketBookingClass.setDate(date.getText(), HelpingTicketBookingClass.getTicket());


                        HelpingTicketBookingClass.addTicket();*/
                        JOptionPane.showMessageDialog(pannel, " Your ticket has been Booked!");
                        NametextField.setText("");
                        CNICField.setText("");
                        PhoneNumberField.setText("");
                        ToBox.setSelectedItem("");
                        FromBox.setSelectedItem("");
                        timebox.setSelectedItem("");
                        date.setText("");
                    }
                }


            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
