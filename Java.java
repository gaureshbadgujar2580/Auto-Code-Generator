import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Java extends JFrame
{
    JLabel lblLabel3;
    JTextField txtTextField1;
    Java()
    {
        setLayout(null);
        lblLabel3 = new JLabel("Name");
        lblLabel3.setBounds(10,10,100,30);
        add(lblLabel3);
        lblLabel3.setForeground(new Color(0,255,0));
        lblLabel3.setBackground(new Color(255,255,255));
        txtTextField1 = new JTextField("Name");
        txtTextField1.setBounds(120,10,150,30);
        add(txtTextField1);
        txtTextField1.setForeground(new Color(255,255,255));
        txtTextField1.setBackground(new Color(0,0,0));
    }
    public static void main(String args[])
    {
        Java objJava =new Java();
         objJava.setLocation(10,10);
         objJava.setSize(150,30);
         objJava.setTitle("Java.java");
         objJava.setVisible(true);
    }
}
