package demo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connection.ConnectionDB;
import connection.ConnectionH2DB;
import connection.ConnectionMysqlDB;
import connection.DBConnection;
import connection.MysqlDAOFactory;
import connection.UserDAOImpl;

public class Demo {
    private static final String SQL_FIND_BY_ID =
            "SELECT login, password FROM user WHERE id = ?"; 
    private static final String SQL_FIND_BY_ID_1 =
            "SELECT user_name, user_email, user_role FROM userTest WHERE user_id = ?"; 
    
    public boolean getBool(){
        return true;
        
    } 

    public static void main(String[] args) {
        DBConnection connect = new DBConnection("localhost", "root", "bonjorno", "test");
        connect.initProperties();
        //connect.init();
        Long id = (long) 2;
        try {
            PreparedStatement statement = connect.init().prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println("Login= " + rs.getString(1) + " Password= " + rs.getString(2));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        MysqlDAOFactory connection=new MysqlDAOFactory();
        UserDAOImpl userDAO = new UserDAOImpl();
                
        Long idd = (long) 2;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SQL_FIND_BY_ID_1);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println("Login= " + rs.getString(1) + " Password= " + rs.getString(2) + "Role " + rs.getString(3));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
  //  ______________________________________________    
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
        
        
//        UserDAOImpl userDAO = new UserDAOImpl();
//        System.out.println(userDAO.find(2));
//        
        
        
       // Statement myStmt =myConn.createStatement();
        
     //-------------------H2 DEMO Connection ------------------------------------------------
        String Qx= "CREATE TABLE user(id int(10) AUTO_INCREMENT PRIMARY KEY, login char(255), password char(255))";
        String In = "INSERT INTO user(login, password)VALUES('daron', '23471')";
        ConnectionDB connectt = new ConnectionH2DB();
        
        try {
            Connection h2Con = connectt.getConnection();
            Statement myStmt = h2Con.createStatement();
             myStmt.execute(In);
             System.out.println("Ok");
             ResultSet myRs = myStmt.executeQuery("select * from user");
             while(myRs.next()){
                 System.out.println(myRs.getString("login")+ ", " + myRs.getString("password") );
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 
}
