package demo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connection.DBConnection;

public class Demo {
    
    public boolean getBool(){
        return true;
        
    } 

    public static void main(String[] args) {
        DBConnection connect = new DBConnection("localhost", "root", "bonjorno", "test");
        connect.initProperties();
        connect.init();
        
//        try {
//            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "bonjorno");
//            Statement myStmt = myConn.createStatement();
//            ResultSet myRs = myStmt.executeQuery("select * from user");
//            while(myRs.next()){
//                System.out.println(myRs.getString("login")+ ", " + myRs.getString("password") );
//            }
//            //System.out.println(myRS.getString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
        
        
        
        
       // Statement myStmt =myConn.createStatement();
        

    }
 
}
