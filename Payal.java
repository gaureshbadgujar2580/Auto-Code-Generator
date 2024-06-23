import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Payal extends JFrame
{
    JButton btnButton1;
    Payal()
    {
        setLayout(null);
        btnButton1 = new JButton("Press Me To save");
        btnButton1.setBounds(25,20,250,40);
        add(btnButton1);
        btnButton1.setForeground(new Color(153,255,153));
        btnButton1.setBackground(new Color(153,102,255));
    }
    public static void main(String args[])
    {
        Payal objPayal =new Payal();
         objPayal.setLocation(10,10);
         objPayal.setSize(600,600);
         objPayal.setTitle("Payal.java");
         objPayal.setVisible(true);
    }
}
