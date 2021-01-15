/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.systemx;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {
    
    private Choice c1;
    private JButton b1,b2;
    private JTable t1;
    private JLabel l3,l4,l5,l6,l7,l8,l9;
    
    Pickup(){
    
        JLabel l1=new JLabel("Pickup Service");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(400,30,200,30);
        add(l1);
        
        JLabel l2=new JLabel("Type of Car");
        l2.setBounds(50,100,100,30);
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                c1.add(rs.getString("brand"));
            }
        }catch(Exception e){}
        c1.setBounds(150,100,200,25);
        add(c1);
        
        
        l3=new JLabel("Name");
        l3.setBounds(30,160,100,20);
        l3.setVisible(false);
        add(l3);
        
        l4=new JLabel("Age");
        l4.setBounds(180,160,100,20);
        l4.setVisible(false);
        add(l4);
        
        l5=new JLabel("Gender");
        l5.setBounds(330,160,100,20);
        l5.setVisible(false);
        add(l5);
        
        l6=new JLabel("Company");
        l6.setBounds(450,160,100,20);
        l6.setVisible(false);
        add(l6);
        
        l7=new JLabel("Brand");
        l7.setBounds(600,160,100,20);
        l7.setVisible(false);
        add(l7);
        
        l8=new JLabel("Available");
        l8.setBounds(740,160,100,20);
        l8.setVisible(false);
        add(l8);
        
        l9=new JLabel("Location");
        l9.setBounds(890,160,100,20);
        l9.setVisible(false);
        add(l9);
        
        t1=new JTable();
        t1.setBounds(0,200,1000,200);
        add(t1);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(350,520,120,30);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(500,520,120,30);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400,150,1000,650);
        setVisible(true);
    }  

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                String str="select * from driver where brand = '"+(String)c1.getSelectedItem()+"'";                              
                conn c=new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                l3.setVisible(true);
                l4.setVisible(true);
                l5.setVisible(true);
                l6.setVisible(true);
                l7.setVisible(true);
                l8.setVisible(true);
                l9.setVisible(true);
                         
            }catch(Exception ae){}
            
        }else if(e.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
