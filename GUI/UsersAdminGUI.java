package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsersAdminGUI extends JFrame
{
    private JTable table1;
    private JButton button1;
    private JPanel pannel;
    private JLabel Title;

    public UsersAdminGUI()
    {
        add(pannel);
        setBounds(400,150,850,550);
        setTitle("Pakistan Express");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();

        modell.addColumn("Serial#");
        modell.addColumn("Name");
        modell.addColumn("Contact#");
        modell.addColumn("Address");
        modell.addColumn("Email");
        modell.addColumn("Password");

/*
        for (int i = 0; i< HelpingRegistration.getRegisterCount(); i++)
        {
            String string0,string1,string2,string3,string4,string5;

            //Storing Data
            string0=String.valueOf(i);
            string1=HelpingRegistration.getRName(i);
            string2=HelpingRegistration.getRContact(i);
            string3=HelpingRegistration.getRAddress(i);
            string4=HelpingRegistration.getREmail(i);
            string5=HelpingRegistration.getRPassword(i);


            String[] data={string0,string1,string2,string3,string4,string5};
            modell.addRow(data);
        }*/

        table1=new JTable(modell);
        table1.setBackground(Color.white);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        //Center Side
        DefaultTableCellRenderer Centerrendere=new DefaultTableCellRenderer();
        Centerrendere.setHorizontalAlignment(JLabel.CENTER);
        //Index
        table1.getColumnModel().getColumn(0).setMaxWidth(100);
        table1.getColumnModel().getColumn(0).setMinWidth(100);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //Name
        table1.getColumnModel().getColumn(1).setMinWidth(100);
        table1.getColumnModel().getColumn(1).setMaxWidth(100);
        //Contact
        table1.getColumnModel().getColumn(2).setMinWidth(140);
        table1.getColumnModel().getColumn(2).setMaxWidth(140);
        //Address
        table1.getColumnModel().getColumn(3).setMinWidth(180);
        table1.getColumnModel().getColumn(3).setMaxWidth(180);
        table1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //Email
        table1.getColumnModel().getColumn(4).setMinWidth(200);
        table1.getColumnModel().getColumn(4).setMaxWidth(200);
        table1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        //Password
        table1.getColumnModel().getColumn(5).setMinWidth(130);
        table1.getColumnModel().getColumn(5).setMaxWidth(130);

    }
}
