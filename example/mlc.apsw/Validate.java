import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String id,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/esempio","root","01072014");
         PreparedStatement ps =con.prepareStatement
                             ("SELECT * FROM anagrafica WHERE id =? and password=?");
         ps.setString(1, id);
         ps.setString(2, password) ;
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}