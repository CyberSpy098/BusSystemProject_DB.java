package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRoute extends JFrame
{
    private JTable table1;
    private JScrollPane Scroll;
    private JPanel pannel;
    private JButton backButton;
    private JButton deleteButton;
    private JTextField indexField;
    private JLabel index;


    public DeleteRoute()
    {
        backButton.setFocusable(false);
        deleteButton.setFocusable(false);
        add(pannel);
        setBounds(550,200,850,630);
        setTitle("Pakistan Express");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
               new AdminGUIPannel().setVisible(true);
               dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int serial=Integer.parseInt(indexField.getText());
                //HelpingAddRouteClass.DeleteRoute(Integer.parseInt(indexField.getText()));
                dispose();
                new DeleteRoute().setVisible(true);

            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();
        modell.addColumn("Index");
        modell.addColumn("Source");
        modell.addColumn("Destination");


        /*for (int i = 0; i< HelpingAddRouteClass.getRoute(); i++)
        {
            String string0,string1,string2;
            //Storing Data
            string0= String.valueOf(i);
            string1=HelpingAddRouteClass.getSource(i);
            string2=HelpingAddRouteClass.getDestination(i);


            String[] data={string0,string1,string2};
            modell.addRow(data);
        }
*/
        table1=new JTable(modell);
    }
}
