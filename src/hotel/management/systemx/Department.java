package hotel.management.systemx;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {
    
    private JButton b1,b2;
    private JTable t1;
    
    Department(){      
       
        setTitle("Department");
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(140,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l2.setBounds(280,10,100,20);
        add(l2);
                
        t1=new JTable();
        t1.setBounds(50,100,400,300);
        add(t1);
        
        b1=new JButton("Show");
        b1.setBounds(125,420,100,20);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(250,420,100,20);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(700,200,500,500);
        setVisible(true);
    }  
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                String str="select * from department";                              
                conn c=new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                                         
            }catch(Exception ae){}
            
        }else if(e.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
