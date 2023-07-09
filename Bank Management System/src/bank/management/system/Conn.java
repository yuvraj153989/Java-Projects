package bank.management.system;
import java.sql.*;

//JDBC CONSISTS OF 5 MAJOR STEPS...
//register the driver
//create conneciton
//create statement
//execute query
//close connection
public class Conn {
    //why we need to try-catch? coz mysql is an external entity and possibly can cause runtime errors
    Connection c;
    Statement s;
    public Conn(){  
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");    //Registering Driver
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");  //creating connection
            s=c.createStatement();
        } catch(Exception e){
            System.out.print(e);
        }
    }
}
