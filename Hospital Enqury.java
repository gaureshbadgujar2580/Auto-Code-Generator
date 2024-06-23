import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Hospital Enqury extends JFrame
{
    Jlabel lblLabel1;
    JTextField txtTextField3;
    JTextField txtTextField4;
    Hospital Enqury()
    {
        setLayout(null);
        lblLabel1 = new Jlabel("Name Of Employee");
        lblLabel1.setBounds(10,10,130,30);
        add(lblLabel1);
        lblLabel1.setForeground(new Color(255,51,153));
        lblLabel1.setBackground(new Color(204,204,255));
        txtTextField3 = new JTextField("Enter Your City");
        txtTextField3.setBounds(10,200,200,30);
        add(txtTextField3);
        txtTextField3.setForeground(new Color(0,255,255));
        txtTextField3.setBackground(new Color(204,255,204));
        txtTextField4 = new JTextField("Enter Your City");
        txtTextField4.setBounds(10,250,300,30);
        add(txtTextField4);
        txtTextField4.setForeground(new Color(255,102,102));
        txtTextField4.setBackground(new Color(0,204,204));
    }
    public static void main(String args[])
    {
        Hospital Enqury objHospital Enqury =new Hospital Enqury();
         objHospital Enqury.setLocation(10,10);
         objHospital Enqury.setSize(500,300);
         objHospital Enqury.setTitle("Hospital Enqury.java");
         objHospital Enqury.setVisible(true);
    }
}
