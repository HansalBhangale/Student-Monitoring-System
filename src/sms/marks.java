package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class marks extends JFrame implements ActionListener {

    JScrollPane sp1, sp2;
    JTabbedPane tabs;
    JTable sem1, sem2;
    JButton add, pf;

    marks()
    {
        setSize(900,500);

        tabs= new JTabbedPane() ;
        tabs.setBounds(400,80,520,350);

        sp1= new JScrollPane();
        sp2= new JScrollPane();


        sem1= new JTable();
        sp1.setViewportView(sem1);

        sem2=new JTable();
        sp2.setViewportView(sem2);


        tabs.add("SEM 1",sp1);
        tabs.add("SEM 2",sp2);

        add(tabs);
        conn c= new conn();
        try {
            String str="select name,gr,english, maths,science from studdetails;";
            ResultSet rs=c.s.executeQuery(str);
            sem1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            System.out.println(e);
        }
        try {
            String str2="select name,gr,hist,geography, marathi  from studdetails;";
            ResultSet rs=c.s.executeQuery(str2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            System.out.println(e);
        }

        add= new JButton("Add/ Update");
        add.setBounds(100,80,150,50);
        add.addActionListener(this);
        add(add);

        pf = new JButton("Home");
        pf.setBounds(100,300,150,50);
        pf.addActionListener(this);
        add(pf);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            new addMarks();
            setVisible(false);
        }
        if(ae.getSource()==pf)
        {
            new options();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new marks();
    }
}
