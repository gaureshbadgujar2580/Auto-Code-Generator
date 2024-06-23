import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Bhavesh extends JFrame
{
    JLabel lblLabel3;
    JTextField txtTextField1;
    Bhavesh()
    {
        setLayout(null);
        lblLabel3 = new JLabel("College Name");
        lblLabel3.setBounds(10,10,100,30);
        add(lblLabel3);
        lblLabel3.setForeground(new Color(153,255,102));
        lblLabel3.setBackground(new Color(51,204,255));
        txtTextField1 = new JTextField("College Name Here");
        txtTextField1.setBounds(125,10,300,30);
        add(txtTextField1);
        txtTextField1.setForeground(new Color(255,102,102));
        txtTextField1.setBackground(new Color(0,102,102));
    }
    public static void main(String args[])
    {
        Bhavesh objBhavesh =new Bhavesh();
         objBhavesh.setLocation(10,20);
         objBhavesh.setSize(200,400);
         objBhavesh.setTitle("Bhavesh.java");
         objBhavesh.setVisible(true);
    }
}
