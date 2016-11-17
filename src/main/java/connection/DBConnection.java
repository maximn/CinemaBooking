package connection;

import java.sql.Connection;
import java.util.Properties;

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
        
        properties.setProperty("user", root);
        properties.setProperty("password", password);
        properties.setProperty("characterEncoding", "UTF-8");
        properties.setProperty("useUnocode", "true");
        
        System.out.println("URL:" + url);
    }
    
    public void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
