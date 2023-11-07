package sms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options extends JFrame implements ActionListener {

    JButton add, attendance,marks;

    options(){
        setSize(600,300);

        add= new JButton("Details");
        add.setBounds(100,100,100,50);
        add.addActionListener(this);
        add(add);

        attendance = new JButton("Attendance");
        attendance.setBounds(250,100,100,50);
        attendance.addActionListener(this);
        add(attendance);

        marks = new JButton("Marks");
        marks.setBounds(400,100,100,50);
        marks.addActionListener(this);
        add(marks);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            new addDetails();
            setVisible(false);
        }
        if(ae.getSource()==attendance)
        {
            new attendence();
            setVisible(false);
        }
        if(ae.getSource()==marks)
        {
            new marks();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new options();
    }
}
