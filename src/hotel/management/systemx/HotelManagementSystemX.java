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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Brajesh Mishra
 */
public class HotelManagementSystemX extends JFrame implements ActionListener{

    public HotelManagementSystemX(){
        
         setTitle("Hotel Management System");
        
                
        ImageIcon i1;
        i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500,800,Image.SCALE_SMOOTH); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,1500,800);
        add(l1);
        
        JLabel l2 =new JLabel("Hotel Management System");
        l2.setBounds(20, 650, 1000, 80);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif",Font.PLAIN,70));
        l1.add(l2);
        
        JButton b1=new JButton("NEXT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(1150, 650, 150,30);
        b1.addActionListener(this);
        l1.add(b1);
        
        setBounds(150,100,1500,800);
        setLayout(null);
        setVisible(true);
        
        while(true){
         l2.setVisible(false);
         try{
             Thread.sleep(500);
         }catch(Exception e){
             
         }
         l2.setVisible(true);
         try{
             Thread.sleep(500);
         }catch(Exception e){}
             
         }
        }       
    public static void main(String[] args) {
        new HotelManagementSystemX().setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        new login().setVisible(true);
        this.setVisible(false);
    }
    
}
