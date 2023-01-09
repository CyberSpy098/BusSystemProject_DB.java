package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteGUI extends JFrame
{
    private JPanel AddRoutePannel;
    private JLabel Title;
    private JButton Addbutton;
    private JLabel Destinationabel;
    private JLabel SourceLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton backButton;


    public AddRouteGUI()
    {
        Border line = BorderFactory.createLineBorder(Color.white);
       SourceLabel.setBorder(line);
       Destinationabel.setBorder(line);
        Addbutton.setFocusable(false);
        backButton.setFocusable(false);
        add(AddRoutePannel);
        setBounds(550,200,850,550);
        setTitle("Pakistan Express");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(textField1.getText().equals("")||textField2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(AddRoutePannel, " Please fill all fields!");
                }
                else
                {
                   // HelpingAddRouteClass.setSource(textField1.getText(),HelpingAddRouteClass.getRoute());
                    //HelpingAddRouteClass.setDestination(textField2.getText(),HelpingAddRouteClass.getRoute());
                    //HelpingAddRouteClass.addRoute();

                    JOptionPane.showMessageDialog(AddRoutePannel, "Bus has been Added!");
                    textField1.setText("");
                    textField2.setText("");
                }
               textField1.setText("");
               textField2.setText("");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
    }

//    private void createUIComponents()
//    {
//        // TODO: place custom component creation code here
//        DefaultTableModel modell=new DefaultTableModel();
//        modell.addColumn("Index");
//        modell.addColumn("Source");
//        modell.addColumn("Destination");
//
//
//        for (int i = 0; i< HelpingAddRouteClass.getRoute(); i++)
//        {
//            String string0,string1,string2;
//            //Storing Data
//            string0= String.valueOf(i);
//            string1=HelpingAddRouteClass.getSource(i);
//            string2=HelpingAddRouteClass.getDestination(i);
//
//
//            String[] data={string0,string1,string2};
//            modell.addRow(data);
//        }
//
//        table1=new JTable(modell);
//       // table1.setBackground(Color.yellow);
//    }
}
