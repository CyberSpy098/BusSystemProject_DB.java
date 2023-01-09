package GUI;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBookingsGUI extends JFrame
{
    private JButton Backbutton;
    private JTable table1;
    private JScrollPane ScrollPane;
    private JPanel Pannel;
    private JButton cancelTicketButton;
    private JLabel indexlabel;
    private JTextField serialfield;

    public MyBookingsGUI()
    {
        Backbutton.setFocusable(false);
        cancelTicketButton.setFocusable(false);

        setBounds(550,200,850,650);
        Border line = BorderFactory.createLineBorder(Color.white);
        indexlabel.setBorder(line);

        add(Pannel);


        Backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new CustomerPannelGUI().setVisible(true);
                dispose();
            }
        });
        cancelTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                int serial=Integer.parseInt(serialfield.getText());
              //  HelpingTicketBookingClass.CancelBooking(Integer.parseInt(serialfield.getText()));
                dispose();
                new MyBookingsGUI().setVisible(true);
            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();

        modell.addColumn("Serial#");
        modell.addColumn("Name");
        modell.addColumn("CNIC#");
        modell.addColumn("Contact#");
        modell.addColumn("Date");
        modell.addColumn("Time");
        modell.addColumn("To");
        modell.addColumn("From");

/*
        for (int i = 0; i< HelpingTicketBookingClass.getTicket();i++)
        {
            String string0,string1,string2,string3,string4,string5,string6,string7;

            //Storing Data
            string0= String.valueOf(i);
            string1=HelpingTicketBookingClass.getName(i);
            string2=HelpingTicketBookingClass.getDate(i);
            string3=HelpingTicketBookingClass.getCNIC(i);
            string4=HelpingTicketBookingClass.getPhone_Number(i);
            string5=HelpingTicketBookingClass.getTo(i);
            string6=HelpingTicketBookingClass.getFrom(i);
            string7=HelpingTicketBookingClass.getTime(i);


            String[] data={string0,string1,string3,string4,string2,string7,string5,string6};
            modell.addRow(data);
        }
*/
        table1=new JTable(modell);
        table1.setBackground(Color.white);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        //Center Side
        DefaultTableCellRenderer Centerrendere=new DefaultTableCellRenderer();
        Centerrendere.setHorizontalAlignment(JLabel.CENTER);
        //Index
        table1.getColumnModel().getColumn(0).setMaxWidth(90);
        table1.getColumnModel().getColumn(0).setMinWidth(90);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //Name
        table1.getColumnModel().getColumn(1).setMinWidth(90);
        table1.getColumnModel().getColumn(1).setMaxWidth(90);
        //CNIC
        table1.getColumnModel().getColumn(2).setMinWidth(140);
        table1.getColumnModel().getColumn(2).setMaxWidth(140);
        //Contact
        table1.getColumnModel().getColumn(3).setMinWidth(120);
        table1.getColumnModel().getColumn(3).setMaxWidth(120);
        table1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //Date
        table1.getColumnModel().getColumn(4).setMinWidth(120);
        table1.getColumnModel().getColumn(4).setMaxWidth(120);
        table1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer
        );
        //Time
        table1.getColumnModel().getColumn(5).setMinWidth(70);
        table1.getColumnModel().getColumn(5).setMaxWidth(70);

        //To
        table1.getColumnModel().getColumn(6).setMinWidth(100);
        table1.getColumnModel().getColumn(6).setMaxWidth(100);
        table1.getColumnModel().getColumn(6).setCellRenderer(Centerrendere);
        //From
        table1.getColumnModel().getColumn(7).setMinWidth(100);
        table1.getColumnModel().getColumn(7).setMaxWidth(100);
        table1.getColumnModel().getColumn(7).setCellRenderer(Centerrendere);

    }
}
