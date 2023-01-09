package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminBookingGUI extends JFrame
{
    private JPanel Pannel;
    private JLabel title;
    private JTable table1;
    private JButton backButton;
    private JTextField textField1;
    private JButton deleteBookingButton;

    public AdminBookingGUI()
    {
        setBounds(550,200,850,650);
        add(Pannel);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
        deleteBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                int serial=Integer.parseInt(textField1.getText());
                //HelpingTicketBookingClass.CancelBooking(Integer.parseInt(textField1.getText()));
                dispose();
                new AdminBookingGUI().setVisible(true);
            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();

        modell.addColumn("#");
        modell.addColumn("Name");
        modell.addColumn("CNIC#");
        modell.addColumn("Contact#");
        modell.addColumn("Date");
        modell.addColumn("Time");
        modell.addColumn("To");
        modell.addColumn("From");


       /* for (int i = 0; i< HelpingTicketBookingClass.getTicket(); i++)
        {
            String string0,string1,string2,string3,string4,string5,string6,string7;

            //Storing Data
            string0= String.valueOf(i+1);
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
        table1.getColumnModel().getColumn(0).setMaxWidth(40);
        table1.getColumnModel().getColumn(0).setMinWidth(40);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //Name
        table1.getColumnModel().getColumn(1).setMinWidth(90);
        table1.getColumnModel().getColumn(1).setMaxWidth(90);
        //CNIC
        table1.getColumnModel().getColumn(2).setMinWidth(100);
        table1.getColumnModel().getColumn(2).setMaxWidth(100);
        //Contact
        table1.getColumnModel().getColumn(3).setMinWidth(110);
        table1.getColumnModel().getColumn(3).setMaxWidth(110);
        table1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //Date
        table1.getColumnModel().getColumn(4).setMinWidth(100);
        table1.getColumnModel().getColumn(4).setMaxWidth(100);
        table1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer
        );
        //Time
        table1.getColumnModel().getColumn(5).setMinWidth(60);
        table1.getColumnModel().getColumn(5).setMaxWidth(60);
        //To
        table1.getColumnModel().getColumn(6).setMinWidth(95);
        table1.getColumnModel().getColumn(6).setMaxWidth(95);
        table1.getColumnModel().getColumn(6).setCellRenderer(Centerrendere);
        //From
        table1.getColumnModel().getColumn(7).setMinWidth(95);
        table1.getColumnModel().getColumn(7).setMaxWidth(95);
        table1.getColumnModel().getColumn(7).setCellRenderer(Centerrendere);
    }
}
