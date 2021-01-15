/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.systemx;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JLabel;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{

    private JTable t1;
    private JButton b1,b2;

    public CustomerInfo() {
     
        setTitle("Customer Info");
        
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(20,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(170,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(290,10,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(400,10,90,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(520,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Status");
        l7.setBounds(790,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(910,10,70,20);
        add(l8);
        
        b1 = new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530,560,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(375,175,1010,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            try{
            conn c = new conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
            
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ae){}
        }
        else if(e.getSource() == b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
}
