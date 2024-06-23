import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Rahul extends JFrame
{
    JLabel lblLabel3;
    JTextField txtTextField1;
    Rahul()
    {
        setLayout(null);
        lblLabel3 = new JLabel("Name");
        lblLabel3.setBounds(10,10,150,30);
        add(lblLabel3);
        lblLabel3.setForeground(new Color(255,255,255));
        lblLabel3.setBackground(new Color(0,255,255));
        txtTextField1 = new JTextField("Name");
        txtTextField1.setBounds(170,10,150,30);
        add(txtTextField1);
        txtTextField1.setForeground(new Color(255,255,255));
        txtTextField1.setBackground(new Color(0,0,255));
    }
    public static void main(String args[])
    {
        Rahul objRahul =new Rahul();
         objRahul.setLocation(10,20);
         objRahul.setSize(400,500);
         objRahul.setTitle("Rahul.java");
         objRahul.setVisible(true);
    }
}
