import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class HospitalEnqury extends JFrame
{
    JTextField txtTextField4;
    JTextField txtTextField1;
    JTextField txtTextField2;
    JLabel lblLabel3;
    JButton btnButton1;
    JButton btnButton2;
    JLabel lblLabel1;
    HospitalEnqury()
    {
        setLayout(null);
        txtTextField4 = new JTextField("Enter Your City");
        txtTextField4.setBounds(10,250,300,30);
        add(txtTextField4);
        txtTextField4.setForeground(new Color(255,102,102));
        txtTextField4.setBackground(new Color(0,204,204));
        txtTextField1 = new JTextField("Enter Your Name");
        txtTextField1.setBounds(150,10,200,30);
        add(txtTextField1);
        txtTextField1.setForeground(new Color(255,51,51));
        txtTextField1.setBackground(new Color(255,204,204));
        txtTextField2 = new JTextField("Enter Your Age");
        txtTextField2.setBounds(150,50,150,30);
        add(txtTextField2);
        txtTextField2.setForeground(new Color(255,255,0));
        txtTextField2.setBackground(new Color(51,0,51));
        lblLabel3 = new JLabel("City");
        lblLabel3.setBounds(10,50,80,30);
        add(lblLabel3);
        lblLabel3.setForeground(new Color(0,51,51));
        lblLabel3.setBackground(new Color(204,255,204));
        btnButton1 = new JButton("Press ME");
        btnButton1.setBounds(10,150,200,30);
        add(btnButton1);
        btnButton1.setForeground(new Color(0,0,0));
        btnButton1.setBackground(new Color(204,204,204));
        btnButton2 = new JButton("Sujay Badgujar");
        btnButton2.setBounds(50,300,300,35);
        add(btnButton2);
        btnButton2.setForeground(new Color(0,0,0));
        btnButton2.setBackground(new Color(153,255,255));
        lblLabel1 = new JLabel("Name");
        lblLabel1.setBounds(10,10,120,30);
        add(lblLabel1);
        lblLabel1.setForeground(new Color(0,0,0));
        lblLabel1.setBackground(new Color(0,204,204));
    }
    public static void main(String args[])
    {
        HospitalEnqury objHospitalEnqury =new HospitalEnqury();
         objHospitalEnqury.setLocation(10,10);
         objHospitalEnqury.setSize(500,300);
         objHospitalEnqury.setTitle("HospitalEnqury.java");
         objHospitalEnqury.setVisible(true);
    }
}
