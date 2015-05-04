
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Validate {
      public static boolean checkUser(String username,String email,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/deepak","root","");
         PreparedStatement ps =con.prepareStatement
                             ("select * from login where username=? AND email=? AND password=?");
         ps.setString(1, username);
         ps.setString(2, email);
         ps.setString(3, password);
         ResultSet rs =ps.executeQuery();
         st = rs.first();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
    
}
