/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.systemx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class conn {
    
    Connection c;
    Statement s;
    
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","Ilovemew");
            s=c.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
