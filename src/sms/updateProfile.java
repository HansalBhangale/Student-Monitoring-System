package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateProfile extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4;
    JTextField gr,data;
    JButton disp, submit, home;
    JComboBox fields;
    JTable t1;
    JScrollPane sp1;

    String [] list={"name","address","aadhaar","phoneno"};
    updateProfile(){

        setSize(900,600);

        l1= new JLabel("GR. NO");
        l1.setBounds(80,40,150,50);
        add(l1);

        gr= new JTextField();
        gr.setBounds(250,40,150,40);
        add(gr);

        disp= new JButton("Display");
        disp.setBounds(450,40,100,40);
        disp.addActionListener(this);
        add(disp);

        sp1= new JScrollPane();
        sp1.setBounds(50,170,770,60);
        add(sp1);

        t1= new JTable();
        sp1.setViewportView(t1);

        l2= new JLabel("Choose Labels");
        l2.setBounds(80,300,150,50);
        add(l2);

        fields= new JComboBox(list);
        fields.setBounds(300,300,150,40);
        add(fields);

        l3= new JLabel("Updated Value");
        l3.setBounds(80,380,150,50);
        add(l3);

        data= new JTextField();
        data.setBounds(300,380,150,50);
        add(data);

        submit = new JButton("Update data");
        submit.setBounds(200,450,180,50);
        submit.addActionListener(this);
        add(submit);

        home= new JButton("Home");
        home.setBounds(400,450,180,50);
        home.addActionListener(this);
        add(home);









        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==disp){
            conn c= new conn();
            String gr=this.gr.getText();
            try{
               String str="select name,address,dob,aadhar,phoneno, gender from studdetails where gr='"+gr+"';";
                ResultSet rs= c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==submit)
        {
            String gr=this.gr.getText();
            String value=this.data.getText();
            String choice=this.fields.getSelectedItem().toString();
            conn c= new conn();
            try{
                String str="update studdetails set "+choice+"='"+value+"' where gr='"+gr+"';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data updated successfully");

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
        new updateProfile();
    }
}
