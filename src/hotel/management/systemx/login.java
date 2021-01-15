/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.systemx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

/**
 *
 * @author Brajesh Mishra
 */
public class login extends JFrame implements ActionListener{
    
    private JLabel l1,l2;
    private JTextArea t1;
    private JPasswordField t2;
    private JButton b1,b2;
    
    login(){
        
        setTitle("Login");
        
        l1=new JLabel("Username");
        l1.setFont(new Font("Verdana", Font.PLAIN, 20));
        l1.setBounds(40,50,140,30);
        add(l1);
        
        t1=new JTextArea();
        t1.setBounds(180,50,120,20);
        add(t1);
        
        l2=new JLabel("Password");
        l2.setFont(new Font("Verdana", Font.PLAIN, 20));
        l2.setBounds(40,110,140,30);
        add(l2);
        
        t2=new JPasswordField();
        t2.setBounds(180,110,120,20);
        add(t2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(350,15,220,220);
        add(l3);
                       
        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(40,180,120,30);
        add(b1);
                
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(200,180,120,30);
        add(b2);        
        
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        setBounds(500,300,630,300);
        setVisible(true);
    
}
    @Override
    public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==b1){
             String username=t1.getText();
             String password=t2.getText();
             
             conn c=new conn();
             String str="select * from login where username = '"+username+"' and password = '"+password+"'";
             try{
             ResultSet rs = c.s.executeQuery(str);
             
             if(rs.next()){
                 
                new Dashboard().setVisible(true);
                 this.setVisible(false);
             }else{
                 JOptionPane.showMessageDialog(null,"Invalid username and password");
                 t1.setText("");
                 t2.setText("");
             }
             }catch(Exception e){
                 e.printStackTrace();
             }
        }    
        else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
        
    }
