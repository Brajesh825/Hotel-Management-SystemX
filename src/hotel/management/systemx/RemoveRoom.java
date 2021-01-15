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

public class RemoveRoom extends JFrame implements ActionListener {
    
    private Choice c2;
    private JButton b1,b2;
    private JTable t1;
    private JLabel l3,l4,l5,l6,l7;
    
    RemoveRoom(){
    
        JLabel l1=new JLabel("Search for Room");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(200,30,200,30);
        add(l1);
        
        JLabel l2=new JLabel("Name");
        l2.setBounds(50,100,100,30);
        add(l2);
        
        c2=new Choice();
        try{
            conn c=new conn();
            String str= "select * from room";
            ResultSet rs= c.s.executeQuery(str);
            
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            } 
        }catch(Exception e){}
        c2.setBounds(200,100,180,20);
        add(c2);
        
        b1=new JButton("Remove");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(150,250,120,30);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(350,250,120,30);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400,150,700,350);
        setVisible(true);
        
    }  
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            
            try{
                String name= c2.getSelectedItem();
                conn c=new conn();
                
                c.s.executeUpdate("delete from room where room_number = '"+name+"'");
                
                JOptionPane.showMessageDialog(null,"Removed Successfully");
                
                this.setVisible(false);
                
            }catch(Exception ae){}
            
        }else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
}
