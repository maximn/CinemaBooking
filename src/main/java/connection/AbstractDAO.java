/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

/**
 * This class represents abstract DAO class with the executeQuery and updateQuery methods.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public abstract class AbstractDAO {
    private ConnectionDB connection;
    
    public Connection getConnection() throws SQLException{
        return connection.getConnection();
    }
    
    public void setConnection(ConnectionDB connection){
        this.connection=connection;
    }
    
    protected ResultSet executeQuery(Connection connect, String query, List values){
        ResultSet result = null;
        try {
            PreparedStatement statement = connect.prepareStatement(query);
            for(int i=0;i<values.size();i++){
                statement.setObject(i+1, values.get(i));
            }
            result = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    } 
    
    protected void updateQuery(String query, Object[] values){
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            for(int i=0;i<values.length;i++){
                statement.setObject(i+1, values[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        String SQL_FIND_BY_ID =
                "SELECT user_id, user_name, user_email, user_role FROM userTest WHERE user_id = ?";
        
        List list = new ArrayList();
        int id = 2;
        list.add(id);
        ConnectionDB connect = new ConnectionMysqlDB();
        UserDAOImpl dao = new UserDAOImpl();
        User user = new User();
        try {
            ResultSet rs = dao.executeQuery(connect.getConnection(), SQL_FIND_BY_ID, list);
            while(rs.next()){
                user.setUserId((long)rs.getLong("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRole(rs.getString("user_role"));
                }
            System.out.println(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}
