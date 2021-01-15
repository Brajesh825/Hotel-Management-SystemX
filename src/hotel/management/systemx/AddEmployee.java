package hotel.management.systemx;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ //Third Frame

    
    private JTextField t1,t2,t3,t4,t5,t6;
    private JComboBox c1;
    private JButton b1;
    private JRadioButton Male,Female;

        public AddEmployee(){
            setTitle("ADD EMPLOYEE DETAILS");
		 			
            JLabel l1 = new JLabel("NAME");
            l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l1.setBounds(60, 30, 150, 27);
            add(l1);
            
            t1 = new JTextField();
            t1.setBounds(200, 30, 150, 27);
            add(t1);
			
            JLabel l2 = new JLabel("AGE");
            l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l2.setBounds(60, 80, 150, 27);
            add(l2);
			
            t2 = new JTextField();
            t2.setBounds(200, 80, 150, 27);
            add(t2);
            
            JLabel l3= new JLabel("GENDER");
            l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l3.setBounds(60, 120, 150, 27);
            add(l3);
		
            Male = new JRadioButton("MALE");
            Male.setBackground(Color.WHITE);
            Male.setBounds(200, 120, 70, 27);
            add(Male);
	
            Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(270, 120,80, 27);
            add(Female);
            
            
            JLabel l4 = new JLabel("JOB");
            l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l4.setBounds(60, 170, 150, 27);
            add(l4);
			
            String jobs[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(jobs);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel l5 = new JLabel("SALARY");
            l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l5.setBounds(60, 220, 150, 27);
            add(l5);
			
            t3 = new JTextField();
            t3.setBounds(200, 220, 150, 27);
            add(t3);
	
            JLabel l6 = new JLabel("PHONE");
            l6.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l6.setBounds(60, 270, 150, 27);
            add(l6);
	
            t4 = new JTextField();
            t4.setBounds(200, 270, 150, 27);
            add(t4);
	
            JLabel l7 = new JLabel("AADHAR");
            l7.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l7.setBounds(60, 320, 150, 27);
            add(l7);
			
            t5 = new JTextField();
            t5.setBounds(200, 320, 150, 27);
            add(t5);
	    
            JLabel l8 = new JLabel("EMAIL");
            l8.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l8.setBounds(60, 370, 150, 27);
            add(l8);
			
            t6 = new JTextField();
            t6.setBounds(200, 370, 150, 27);
            add(t6);
	
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/jobs.jpg"));
            Image i3 = i1.getImage().getScaledInstance(450, 360,Image.SCALE_SMOOTH);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel l9 = new JLabel(i2);
            l9.setBounds(410,80,450,360);
            add(l9);
            
            b1 = new JButton("SAVE");
            b1.setBounds(200, 450, 150, 30);
            b1.setBackground(Color.BLACK);
            b1.addActionListener(this);
            b1.setForeground(Color.WHITE);
            add(b1);
            
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setBounds(200,200,900,600);
            setVisible(true);
        }
             
            public void actionPerformed(ActionEvent ae){
                    String name = t1.getText();
                    String age = t2.getText();
                    String salary = t3.getText();
                    String phone = t4.getText();
                    String aadhar = t5.getText();
                    String email = t6.getText();
                   
                    String gender = null;
                    
                    if(Male.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
       
                    String job = (String)c1.getSelectedItem();
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch (Exception e) {}
                    
            }

            
}