package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancellationBookingsGUIAdminPannel extends JFrame
{
    private JPanel Bookingpannel;
    private JButton Back;
    private JTable table1;
    private JScrollPane scrollpane;

    public CancellationBookingsGUIAdminPannel()
    {
        add(Bookingpannel);
        setBounds(400,150,850,550);
        setBackground(Color.WHITE);
        setTitle("Welcome to Pakistan Express");



        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
    }


    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();

        modell.addColumn("Index");
        modell.addColumn("Name");
        modell.addColumn("Father Name");
        modell.addColumn("Phone Number");
        modell.addColumn("CNIC");
        modell.addColumn("To");
        modell.addColumn("From");


       /* for (int i = 0; i< HelpingCancelTicket.getTicket(); i++)
        {
            String string0,string1,string2,string3,string4,string5,string6;

            //Storing Data
            string0= String.valueOf(i+1);
            string1=HelpingCancelTicket.getName(i);
            string2=HelpingCancelTicket.getFatherName(i);
            string3=HelpingCancelTicket.getCNIC(i);
            string4=HelpingCancelTicket.getPhone_Number(i);
            string5=HelpingCancelTicket.getTo(i);
            string6=HelpingCancelTicket.getFrom(i);

            String[] data={string0,string1,string2,string3,string4,string5,string6};
            modell.addRow(data);
        }
*/
        table1=new JTable(modell);
        table1.setBackground(Color.yellow);

    }
}
