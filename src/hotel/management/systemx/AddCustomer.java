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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {

    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2;
    private JComboBox c1;
    private Choice c2;
    private JRadioButton r1,r2;
            
    AddCustomer()
    {
        setTitle("ADD CUSTOMER");
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(880,500,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0,0,880,500);
        add(l1);
               
        JLabel l2=new JLabel("ID");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(35,60,100,20);
        l1.add(l2);
        
        c1=new JComboBox(new String[]{"Passport","Voter-Id-Card","Driving License","Aadhar Card"});
        c1.setBounds(200,60,180,20);
        l1.add(c1);
        
        JLabel l3=new JLabel("NUMBER");
        l3.setFont(new Font("Tahoma",Font.BOLD,15));        
        l3.setBounds(35,100,100,20);
        l3.setForeground(Color.WHITE);
        l1.add(l3);
        
        t1=new JTextField();
        t1.setBounds(200,100,180,20);
        l1.add(t1);
        
        JLabel l4=new JLabel("Name");
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        l4.setForeground(Color.WHITE);
        l4.setBounds(35,140,100,20);
        l1.add(l4);
        
        t2=new JTextField();
        t2.setBounds(200,140,180,20);
        l1.add(t2);
        
        JLabel l5=new JLabel("Gender");
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        l5.setForeground(Color.WHITE);
        l5.setBounds(35,180,100,20);
        l1.add(l5);
        
        r1=new JRadioButton("Male");
        r1.setBounds(200,180,90,20);
        r1.setBackground(Color.WHITE);
        l1.add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(290,180,90,20);
        r2.setBackground(Color.WHITE);
        l1.add(r2);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        JLabel l6=new JLabel("Country");
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        l6.setForeground(Color.WHITE);
        l6.setBounds(35,220,100,20);
        l1.add(l6);
        
        t3=new JTextField();
        t3.setBounds(200,220,180,20);
        l1.add(t3);
        
        JLabel l7=new JLabel("Room Number");
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        l7.setForeground(Color.WHITE);
        l7.setBounds(35,260,150,20);
        l1.add(l7);
        
        c2=new Choice();
        try{
            conn c=new conn();
            String str= "select * from room";
            ResultSet rs= c.s.executeQuery(str);
            
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            } 
        }catch(Exception e){}
        c2.setBounds(200,260,180,20);
        l1.add(c2);
                
        JLabel l8=new JLabel("Checked In");
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        l8.setForeground(Color.WHITE);
        l8.setBounds(35,300,100,20);
        l1.add(l8);
        
        t4=new JTextField();
        t4.setBounds(200,300,180,20);
        l1.add(t4);
        
        JLabel l9=new JLabel("Deposit");
        l9.setFont(new Font("Tahoma",Font.BOLD,15));
        l9.setForeground(Color.WHITE);
        l9.setBounds(35,340,100,20);
        l1.add(l9);        
       
        t5=new JTextField();
        t5.setBounds(200,340,180,20);
        l1.add(t5);
        
        b1=new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(50,400,120,25);
        l1.add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(200,400,120,25);
        l1.add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(500,200,880,500);
        setLayout(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            
            String id = (String)c1.getSelectedItem();
            String number= t1.getText();
            String name= t2.getText();
            String gender=null;
            if(r1.isSelected())
            { gender="Male";
            }else if(r2.isSelected()){
                gender="Female";
            }           
            
            String country=t3.getText();
            String room =(String)c2.getSelectedItem();
            String status=t4.getText();
            String deposit=t5.getText();
            
            String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
            String str2="update room set available = 'Occupied' where room_number = '"+room+"'";
            try{
                conn c=new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception aee){}
            
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
        
    }
    
}
