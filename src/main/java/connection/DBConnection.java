package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.mysql.cj.api.*;

public class DBConnection {
    private String host;
    private String root;
    private String password;
    private String nameDB;
    private String url;
    
    private Properties properties = new Properties();
    private Connection mysqlConnect;
    
    public DBConnection(String host, String root, String password, String nameDB){
        this.host=host;
        this.root=root;
        this.password=password;
        this.nameDB=nameDB;
    }
    
    public void initProperties(){
        
        url = "jdbc:mysql://"+ host +"/"+ nameDB;
        
        properties.setProperty("user", this.root);
        properties.setProperty("password", this.password);
        properties.setProperty("characterEncoding", "ASC");
        properties.setProperty("useUnocode", "true");
        
        System.out.println("URL:" + url);
    }
    
    public void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mysqlConnect = DriverManager.getConnection(url, root, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
             e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
