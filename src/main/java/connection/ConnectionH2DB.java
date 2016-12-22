/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionH2DB represents H2's database connection class
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public class ConnectionH2DB extends ConnectionDB {
    public static final String DRIVER = "org.h2.Driver";
    public static final String DBURL = "jdbc:h2:~/test;MODE=MySQL;IFEXISTS=TRUE";
    public static final String DBURL1 = "jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"; //IGNORECASE=TRUE
    
    private String root = "sa";
    private String password = "";
    
    private Connection h2Connect;
    private Properties properties = new Properties();
   

    @Override
    public void initProperties() {
        properties.setProperty("characterEncoding", "ASC");
        properties.setProperty("useUnocode", "true");
        
        System.out.println("URL:" + DBURL1);
        
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (h2Connect == null)
            try {
                Class.forName("org.h2.Driver");
                h2Connect = DriverManager.getConnection(DBURL1, root, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } 
            catch (SQLException e) {
                 e.printStackTrace();
            }
        return h2Connect;
    }

    @Override
    public void closeConnection() {
        try {
            h2Connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ConnectionDB con = new ConnectionH2DB();
        try {
            con.initProperties();
            con.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
