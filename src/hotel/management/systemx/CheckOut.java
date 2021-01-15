/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.systemx;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;


public class CheckOut extends JFrame implements ActionListener {

    private Choice c1;
    private JTextField t1;
    private JButton b1,b2,b3;
    
    CheckOut(){
        
        JLabel l1 =new JLabel("Check Out");
        l1.setBounds(30,20,150,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(l1);
        
        JLabel l2 =new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }            
        }catch(Exception e){}
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel l3 =new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);
        
        b1=new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(30,200,120,30);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(170,200,120,30);
        add(b2);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        b3=new JButton(i3);
        b3.addActionListener(this);
        b3.setBounds(360,80,20,20);
        add(b3);
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(380,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(390,10,380,250);
        add(l4);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str="delete from customer where number = '"+id+"'";
            String str2="update room set available = 'Available' where room_number ='"+room+"'";

            conn c=new conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                
                JOptionPane.showMessageDialog(null,"Checkout done");
                
            }catch(Exception ee){}
            
        
        }else if(e.getSource()== b2){
        new Reception().setVisible(true);
        this.setVisible(false);
        
    }else if(e.getSource()== b3){
        try{
            conn c=new conn();
            String id = (String)c1.getSelectedItem();
            ResultSet rs= c.s.executeQuery("select * from customer where number = '"+id+"'");
            while(rs.next()){
                t1.setText(rs.getString("room"));
            }
            
        }catch(Exception ae){}
    }
    
}
}
