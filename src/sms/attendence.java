package sms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

import javax.swing.*;

public class attendence extends JFrame implements ActionListener {
    JButton add , defaulters, refresh,home;
    JTable t1;
    JScrollPane sp1;

    attendence()
    {
        setSize(1000,500);


        sp1=new JScrollPane();
        sp1.setBounds(650, 80,300,300);
        this.add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);
        displayOriginal();


        add = new JButton("Add/ Update");
        add.setBounds(70,80, 150,70);
        add.addActionListener(this);
        this.add(add);

        home = new JButton("Home");
        home.setBounds(70,130, 150,70);
        home.addActionListener(this);
        add(home);

        defaulters = new JButton("Defaulters");
        defaulters.setBounds(70,280, 150,70);
        defaulters.addActionListener(this);
        this.add(defaulters);

        refresh= new JButton("Refresh");
        refresh.setBounds(820,390,40,40);
        refresh.addActionListener(this);
        add(refresh);




        setLayout(null);
        setVisible(true);
    }
    void displayOriginal()
    {
        try{
            conn c=new conn();
            String str = "select gr, name,attendence from studdetails;";
            ResultSet rs= c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception e){
            System.out.println(e);

        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==defaulters)
        {
            conn c= new conn();
            try
            {
                String str="select gr,name,attendence from studdetails where attendence <50;";
                ResultSet rs =c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        if(ae.getSource()==refresh)
        {
            displayOriginal();
        }
        if(ae.getSource()==add)
        {
            new addAttedence();
            setVisible(false);
        }

        if(ae.getSource()==home)
        {
            new options();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new attendence();
    }

}
