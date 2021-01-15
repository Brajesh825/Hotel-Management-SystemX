
package hotel.management.systemx;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener{

    private JTextField t1,t2;
    private JComboBox c1,c2, c3;
    private JButton b1,b2;

    public AddRoom() {
                
        setTitle("Add Room");
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/systemx/icons/addroom.jpg"));
        Image i3 = i1.getImage().getScaledInstance(800,450,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0,0,800,450);
        add(l1);
        
	JLabel l3 = new JLabel("Room Number");
	l3.setForeground(Color.WHITE);
	l3.setFont(new Font("Tahoma", Font.BOLD, 18));
	l3.setBounds(70, 50, 150, 30);
	l1.add(l3);
        
        t1 = new JTextField();
	t1.setBounds(70, 80, 160, 25);
	l1.add(t1);
        
        JLabel l6 = new JLabel("Price");
	l6.setForeground(Color.WHITE);
	l6.setFont(new Font("Tahoma", Font.BOLD, 18));
	l6.setBounds(520, 50, 150, 30);
	l1.add(l6);
        
        t2 = new JTextField();
	t2.setBounds(490, 80, 160, 25);
	l1.add(t2);
        
        c1 = new JComboBox(new String[] { "Available", "Occupied" });
	c1.setBounds(250, 150, 184, 25);
	l1.add(c1);
        
        c2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
	c2.setBounds(250, 200, 184, 25);
	l1.add(c2);

        c3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	c3.setBounds(250, 250, 184, 25);
	l1.add(c3);

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(80, 320, 140, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	l1.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(500, 320, 140, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	l1.add(b2);

	setBounds(380,180, 800,450);
	setLayout(null);        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String room = t1.getText();
                String available = (String)c1.getSelectedItem();
                String status = (String)c2.getSelectedItem();
                String price  = t2.getText();
                String type = (String)c3.getSelectedItem();
                String str = "insert into room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
              
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}