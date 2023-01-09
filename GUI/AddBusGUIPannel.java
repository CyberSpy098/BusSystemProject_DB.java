package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
                String Name=NameText.getText();
                String ModelYear=Model.getText();
                String regNo=regfield.getText();
                if(NameText.getText().equals("")||Model.getText().equals("")||regfield.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(AddPannel, " Please fill all fields!");
                }
                else
                {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "online_BusReservation", "group");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO BUS(bus_id,bus_name,bus_no,bus_modelYear) VALUES(bus_id_seq.nextVal,?,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);

                        pst.setString(1, Name);
                        pst.setString(2, ModelYear);
                        pst.setString(3, regNo);



                        pst.executeQuery();
                        System.out.println("Data saved successfully!");
                        JOptionPane.showMessageDialog(AddPannel, "Bus has been Added!");
                        NameText.setText("");
                        Model.setText("");
                        regfield.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AddPannel, ex);
                    }
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
