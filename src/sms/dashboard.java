package sms;

import javax.swing.*;
import java.awt.*;

public class dashboard extends JFrame{
    JMenuBar mb;
    JButton primary, seconadary, highsec, logout;
    dashboard()
    {
        setSize(700,500);

        mb= new JMenuBar();
        mb.setBounds(0,0,150,500);
        mb.setBackground(Color.BLUE);
        mb.setBackground(Color.getColor("gray", 40));
        mb.setLayout(new GridLayout(5,1,0,50));

        primary= new JButton("Primary");
        mb.add(primary);


        seconadary= new JButton("Seconadary");
        mb.add(seconadary);

        highsec= new JButton("Higher Secondary");
        mb.add(highsec);

        logout = new JButton("Log out");
        mb.add(logout);

        add(mb);






        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new dashboard();
    }
}
