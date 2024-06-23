import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class ComputerShop extends JFrame
{
    JLabel lblPerson;
    JTextField txtTextField1;
    JLabel lblLabel2;
    JTextField txtTextField2;
    JRadioButton rbtnRadioButton1;
    ComputerShop()
    {
        setLayout(null);
        lblPerson = new JLabel("Person Name");
        lblPerson.setBounds(10,10,150,30);
        add(lblPerson);
        lblPerson.setForeground(new Color(102,255,0));
        lblPerson.setBackground(new Color(51,0,51));
        txtTextField1 = new JTextField("Enter The Name Of Person");
        txtTextField1.setBounds(170,10,200,30);
        add(txtTextField1);
        txtTextField1.setForeground(new Color(204,0,153));
        txtTextField1.setBackground(new Color(255,255,51));
        lblLabel2 = new JLabel("Enter Your Age");
        lblLabel2.setBounds(10,60,150,30);
        add(lblLabel2);
        lblLabel2.setForeground(new Color(0,255,51));
        lblLabel2.setBackground(new Color(51,0,51));
        txtTextField2 = new JTextField("Age");
        txtTextField2.setBounds(180,60,200,30);
        add(txtTextField2);
        txtTextField2.setForeground(new Color(255,0,102));
        txtTextField2.setBackground(new Color(255,255,51));
        rbtnRadioButton1 = new JRadioButton("Show");
        rbtnRadioButton1.setBounds(10,250,152,30);
        add(rbtnRadioButton1);
        rbtnRadioButton1.setForeground(new Color(51,51,255));
        rbtnRadioButton1.setBackground(new Color(255,255,0));
    }
    public static void main(String args[])
    {
        ComputerShop objComputerShop =new ComputerShop();
         objComputerShop.setLocation(10,10);
         objComputerShop.setSize(400,500);
         objComputerShop.setTitle("ComputerShop.java");
         objComputerShop.setVisible(true);
    }
}
