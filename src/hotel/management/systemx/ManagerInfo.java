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

public class ManagerInfo extends JFrame implements ActionListener{

    private JTable t1;
    private JButton b1,b2;

    public ManagerInfo() {
     
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(40,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(170,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(290,10,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("DEPARTMENT");
        l4.setBounds(400,10,90,20);
        add(l4);
        
        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(540,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(670,10,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("AADHAR");
        l7.setBounds(790,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("EMAIL");
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
            String str = "select * from employee where job = 'Manager'";
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
