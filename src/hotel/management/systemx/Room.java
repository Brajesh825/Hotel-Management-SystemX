/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.systemx;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.proteanit.sql.DbUtils;


public class Room extends JFrame implements ActionListener{
    private JTable t1;
    private JButton b1,b2;
    
    Room()
    {
        setTitle("Room Info");
        
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/eight.jpg"));
     Image i2=i1.getImage().getScaledInstance(600,500,Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel icon = new JLabel(i3);
     icon.setBounds(500,0,600,500);
     add(icon);
     
     JLabel l1=new JLabel("Room Number");
     l1.setBounds(10,10,100,20);
     add(l1);
     
     JLabel l2=new JLabel("Availability");
     l2.setBounds(120,10,100,20);
     add(l2);
     
     JLabel l3=new JLabel("Status");
     l3.setBounds(230,10,100,20);
     add(l3);
     
     JLabel l4=new JLabel("Price");
     l4.setBounds(330,10,100,20);
     add(l4);
     
     JLabel l5=new JLabel("Bed Type");
     l5.setBounds(400,10,100,20);
     add(l5);
     
     t1=new JTable();
     t1.setBounds(0,40,500,400);
     add(t1);
     
     b1=new JButton("LOAD DATA");
     b1.setBounds(100,460,120,30);
     b1.addActionListener(this);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     add(b1);
     
     b2=new JButton("BACK");
     b2.setBounds(250,460,120,30);
     b2.addActionListener(this);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     add(b2);
          
     setLayout(null);
     setBounds(450,200,1100,545);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){ 
        if(ae.getSource() == b1)
        {
           try{
               conn c=new conn();
           
            String str = "select * from room";
            
            ResultSet rs= c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){} 
        }else if(ae.getSource() == b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }    
}
