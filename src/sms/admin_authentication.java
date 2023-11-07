package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_authentication extends JFrame implements ActionListener {
    JLabel l1;
    JPasswordField t1;
    JButton b1;
    admin_authentication()
    {
        setSize(600,400);

        l1= new JLabel("Authentication key");
        l1.setBounds(60,80,250,50);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);

        t1 = new JPasswordField();
        t1.setBounds(350,80,150,40);
        t1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(t1);

        b1 = new JButton("Check authentication key");
        b1.setBounds(150,260,300,50);
        b1.setFont(new Font("Tahoma",Font.BOLD,20));
        b1.addActionListener(this);
        add(b1);

        JOptionPane.showMessageDialog(null,"In order to add the new admin please enter the correct authentication key");

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==b1)
        {
            String key= String.valueOf(this.t1.getPassword());
            String password = "SAKEC";
                if(password.equals(key))
                {
                    JOptionPane.showMessageDialog(null,"Correct authentication key");
                    new add_admin();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect authentication key");
                    new starter();
                    setVisible(false);
                }
        }
    }

    public static void main(String[] args) {
        new admin_authentication();
    }
}
