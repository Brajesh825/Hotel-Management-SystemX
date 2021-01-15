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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener{
    
    private JMenuBar mb;
    private JMenu m1,m2;
    private JMenuItem i1,i2,i3,i4,i5,i6,i7;
    private JLabel l2;
    private JButton b1;
    private int count=0;
    
    Dashboard(){
        setTitle("Hotel Management system");
        
        mb=new JMenuBar();
        mb.setBackground(Color.GRAY);
        mb.setBounds(0,0,1920,30);
        add(mb);
        
        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.WHITE);
        mb.add(m1);
        
        m2=new JMenu("ADMIN");
        m2.setForeground(Color.WHITE);
        mb.add(m2);
        
        i1=new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        i1.setForeground(Color.BLUE);
        m1.add(i1);
        
        i2=new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        i2.setForeground(Color.BLUE);
        m2.add(i2);
        
        i3=new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        i3.setForeground(Color.BLUE);
        m2.add(i3);
        
        i4=new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        i4.setForeground(Color.BLUE);
        m2.add(i4);

        i5=new JMenuItem("REMOVE EMPLOYEE");
        i5.addActionListener(this);
        i5.setForeground(Color.BLUE);
        m2.add(i5);
        
        i6=new JMenuItem("REMOVE ROOMS");
        i6.addActionListener(this);
        i6.setForeground(Color.BLUE);
        m2.add(i6);
        
        i7=new JMenuItem("REMOVE DRIVERS");
        i7.addActionListener(this);
        i7.setForeground(Color.BLUE);
        m2.add(i7);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/third.jpg"));
        Image I2 = I1.getImage().getScaledInstance(1920,1000,Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l1=new JLabel(I3);
        l1.setBounds(0,0,1920,1000);
        add(l1);
        
        l2=new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,50));
        l2.setBounds(450,50,900,60);
        l1.add(l2);               
        
        setBounds(0,0,2000,1100);
        setLayout(null);
        setVisible(true);
        setState(JFrame.MAXIMIZED_BOTH);
      }
      
    public void actionPerformed(ActionEvent ae) {
          if(ae.getActionCommand().equals("RECEPTION")){
              flicker();
             new Reception().setVisible(true);
          }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
              flicker();
             new AddEmployee().setVisible(true);
          }else if(ae.getActionCommand().equals("ADD ROOMS")){
              flicker();
             new AddRoom().setVisible(true);
          }else if(ae.getActionCommand().equals("ADD DRIVERS")){
              flicker();
             new AddDriver().setVisible(true);
          }
          else if(ae.getActionCommand().equals("REMOVE EMPLOYEE")){
              flicker();
             new RemoveEmployee().setVisible(true);
          }else if(ae.getActionCommand().equals("REMOVE ROOMS")){
              flicker();
             new RemoveRoom().setVisible(true);
          }else if(ae.getActionCommand().equals("REMOVE DRIVERS")){
              flicker();
             new RemoveDriver().setVisible(true);
          }
    }
     private void flicker() {
       
         if(count%3==0){
         l2.setText("Welcomes you! Welcomes You!");
         l2.setForeground(Color.BLUE); 
         count++;
         }
         else if(count%3==1){
         l2.setText("Welcomes you! Welcomes You!");
         l2.setForeground(Color.RED); 
         count++;
         }
         else if(count%3==2){
         l2.setText("Welcomes you! Welcomes You!");
         l2.setForeground(Color.PINK); 
         count++;
         }
    }       
}
