package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MysqlDAOFactory extends AbstractDAOFactory {
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost/test";
    
    private String root = "root";
    private String password = "bonjorno";
    
    private Connection mysqlConnect;
    private Properties properties = new Properties();
    
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
    
    public void closeConnection(){
        try {
            mysqlConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet query(String query){
        ResultSet result = null;
        try {
            Statement stmt = mysqlConnect.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void updateQuery(String query){
        try {
            Statement stmt = mysqlConnect.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public SessionDAO getSessionDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FilmDAO getFilmDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SeatDAO getSeatDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    

}
