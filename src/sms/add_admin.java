package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;


public class add_admin extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField username;
    JPasswordField password;

    add_admin() {
        setSize(600, 400);
        JLabel l1 = new JLabel("Username");
        l1.setBounds(60, 80, 150, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);

        username = new JTextField();
        username.setBounds(250, 80, 150, 40);
        username.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(username);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(60, 160, 150, 50);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l2);


        password = new JPasswordField();
        password.setBounds(250, 160, 150, 40);
        add(password);

        add = new JButton("Add");
        add.setBounds(100, 260, 120, 50);
        add.setFont(new Font("Tahoma", Font.BOLD, 20));
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 260, 120, 50);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==add)
        {
           String username=this.username.getText();
           String password = String.valueOf(this.password.getPassword());

           conn c= new conn();
           String query="insert into login(username,password) values('"+username+"','"+password+"');";
            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Admin Added Successfully!");
                new login();
                setVisible(false);

            }catch (Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Some error occured :(");
            }

        }
    }


    public static void main(String[] args) {
        new add_admin();
    }
}
