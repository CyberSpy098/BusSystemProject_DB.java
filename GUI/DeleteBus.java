package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBus extends JFrame
{

    private JTable showTable;
    private JPanel panel;
    private JButton Backbutton;
    private JButton deleteButton;
    private JTextField indexfield;
    private JLabel indexlabel;


    public DeleteBus()
        {

            Border line = BorderFactory.createLineBorder(Color.white);
            indexlabel.setBorder(line);

            Backbutton.setFocusable(false);
            deleteButton.setFocusable(false);

            setBounds(550,200,850,650);
            setTitle("Pakistan Express");
            setBackground(Color.WHITE);
            setVisible(true);
            add(panel);


            Backbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new AdminGUIPannel().setVisible(true);
                    dispose();
                }
            });
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    int serial=Integer.parseInt(indexfield.getText());
                    //HelpingAddBusClass.DeleteBus(Integer.parseInt(indexfield.getText()));

                    dispose();
                    new DeleteBus().setVisible(true);
                }
            });
        };

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();

        modell.addColumn("Serial#");
        modell.addColumn("Name");
        modell.addColumn("Model");
        modell.addColumn("Registration No");

        /*for (int i = 0; i< HelpingAddBusClass.getcounter(); i++)
        {
            String s1,s2,s3,s4;
            s1= String.valueOf(i);
            s2=HelpingAddBusClass.getName(i);
            s3=HelpingAddBusClass.getModel(i);
            s4=HelpingAddBusClass.getRegistrationNO(i);

            String[] data={s1,s2,s3,s4};
            modell.addRow(data);
        }
*/
        showTable=new JTable(modell);
    }

}

