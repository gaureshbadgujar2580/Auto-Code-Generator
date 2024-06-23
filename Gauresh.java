import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Gauresh extends JFrame
{
    JLabel lblLabel3;
    Gauresh()
    {
        setLayout(null);
        lblLabel3 = new JLabel("Name");
        lblLabel3.setBounds(10,10,150,30);
        add(lblLabel3);
        lblLabel3.setForeground(new Color(255,255,153));
        lblLabel3.setBackground(new Color(255,102,102));
    }
    public static void main(String args[])
    {
        Gauresh objGauresh =new Gauresh();
         objGauresh.setLocation(10,20);
         objGauresh.setSize(150,30);
         objGauresh.setTitle("Gauresh.java");
         objGauresh.setVisible(true);
    }
}
