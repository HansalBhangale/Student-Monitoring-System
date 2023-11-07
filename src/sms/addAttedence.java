package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addAttedence extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField gr,att;
    JButton display,submit, home;

    JScrollPane sp1;
    JTable t1;

    addAttedence()
    {
        setSize(550,600);

        l1= new JLabel("GR.NO");
        l1.setBounds(70,50,120,50);
        add(l1);

        gr=new JTextField();
        gr.setBounds(190,50,150,50);
        add(gr);


        display=new JButton("Display");
        display.setBounds(390,50,100,50);
        display.addActionListener(this);
        add(display);

        sp1= new JScrollPane();
        sp1.setBounds(30,180,480,50);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);
        l2= new JLabel("Add/Update Record");
        l2.setBounds(60,300,130,50);
        add(l2);

        att = new JTextField();
                att.setBounds(250,300,130,50);
        add(att);

        submit= new JButton("Submit");
        submit.setBounds(100,450,100,50);
        submit.addActionListener(this);
        add(submit);

        home= new JButton("Home");
        home.setBounds(300,450,100,50);
        home.addActionListener(this);
        add(home);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==display)
        {
            String gr= this.gr.getText();
            conn c= new conn();
             try{

                 String str = "select name, gr,attendence from studdetails where gr='"+gr+"';";

                 ResultSet rs =c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));

             }catch (Exception e)
             {
                 System.out.println(e);
             }
        }
        if (ae.getSource()==submit)
        {
            String gr =this.gr.getText();
            String attend= this.att.getText();
            conn c= new conn();
            try{
                String str=" update studdetails set attendence ='"+attend+"' where gr ='"+gr+"';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Attendence record updated successfully");

            }catch(Exception e)
            {
                System.out.println(e);
            }
        }

        if(ae.getSource()==home)
        {
            new options();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addAttedence();
    }
}
