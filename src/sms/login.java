package sms;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;


public class login extends JFrame implements ActionListener {

    JButton signin, cancel;
    JTextField username;
    JPasswordField password;
    login()
    {
        setSize(600,400);
        JLabel l1= new JLabel("Username");
        l1.setBounds(60,80,150,50);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);

         username = new JTextField();
        username.setBounds(250,80,150,40);
        username.setFont(new Font("Tahoma",Font.BOLD,15));
        add(username);

        JLabel l2= new JLabel("Password");
        l2.setBounds(60,160,150,50);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l2);


        password = new JPasswordField();
        password.setBounds(250,160,150,40);
        add(password);

         signin = new JButton("Sigh in");
        signin.setBounds(100,260,120,50);
        signin.setFont(new Font("Tahoma",Font.BOLD,20));
        signin.addActionListener(this);
        add(signin);

        cancel=new JButton("Cancel");
        cancel.setBounds(280,260,120,50);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==signin)
         {
             String username=this.username.getText();
             String password= String.valueOf(this.password.getPassword());
             conn c= new conn();
             String str1="select username, password from login where username='"+username+"' and password = '"+password+"';";
             try{
                 ResultSet rs= c.s.executeQuery(str1);
                 if(rs.next())
                 {
                     JOptionPane.showMessageDialog(null,"Login successfull");
                     this.setVisible(false);
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Invalid Login Credentials");

                 }
             }catch(Exception e)
             {
                 System.out.println(e);
             }
             new options();
             setVisible(false);


         }
         if(ae.getSource()==cancel)
         {
             System.exit(0 );
         }
    }

    public static void main(String[] args) {

        new login();
    }
}
