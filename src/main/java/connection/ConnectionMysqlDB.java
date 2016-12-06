/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class represents MySQL database connection.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public class ConnectionMysqlDB extends ConnectionDB {
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost/test";
    
    private String root = "root";
    private String password = "bonjorno";
    
    private Connection mysqlConnect;
    private Properties properties = new Properties();
    
    @Override
    public void initProperties(){
        properties.setProperty("characterEncoding", "ASC");
        properties.setProperty("useUnocode", "true");
        
        System.out.println("URL:" + DBURL);
    }
    
    @Override
    public Connection getConnection() throws SQLException {
        if (mysqlConnect == null)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                mysqlConnect = DriverManager.getConnection(DBURL, root, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } 
            catch (SQLException e) {
                 e.printStackTrace();
            }
        return mysqlConnect;
    }
    
    @Override
    public void closeConnection(){
        try {
            mysqlConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ConnectionDB con = new ConnectionMysqlDB();
        try {
            con.initProperties();
            con.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
