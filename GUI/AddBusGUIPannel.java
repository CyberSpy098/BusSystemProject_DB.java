package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBusGUIPannel extends JFrame
{

    private JLabel Name;
    private JTextField NameText;

    private JLabel BusNo;
    private JTextField Model;

    private JButton addButton;
    private JPanel AddPannel;
    private JButton backButton;
    private JTextField regfield;
    private JLabel registrationlabel;
    private JButton deleteButton;
    private JLabel WrongPassField;
    //DefaultTableModel modell=new DefaultTableModel();

    public AddBusGUIPannel()
    {

        add(AddPannel);
        setBounds(550,200,850,550);
        Border line = BorderFactory.createLineBorder(Color.white);
        BusNo.setBorder(line);
        Name.setBorder(line);
        registrationlabel.setBorder(line);

        setTitle("Pakistan Express");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(NameText.getText().equals("")||Model.getText().equals("")||regfield.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(AddPannel, " Please fill all fields!");
                }
                else
                {
                    JOptionPane.showMessageDialog(AddPannel, "Bus has been Added!");
                    NameText.setText("");
                    Model.setText("");
                    regfield.setText("");
                }


            }
        });
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });

    }
}
