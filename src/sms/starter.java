package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class starter extends JFrame implements ActionListener {

    JButton login, add;
    starter()
    {
        setSize(1000,600);
        JLabel l1 = new JLabel("STUDENT MONITORING SYSTEM");
        l1.setBounds(200,50,600,100);
        l1.setFont(new Font("Tahoma",Font.BOLD,32));
        add(l1);

        login=new JButton("LOGIN");
        login.setBounds(750,450,150,80);
        login.addActionListener(this);
        add(login);

        add=new JButton("Add admin");
        add.setBounds(400,450,150,80);
        add.addActionListener(this);
        add(add);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            new login();
            setVisible(false);
        }
        if(ae.getSource()==add)
        {
            new admin_authentication();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new starter();
    }
}
