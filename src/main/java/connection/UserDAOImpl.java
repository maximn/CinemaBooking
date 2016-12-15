package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.User;

/**
 * UserDAOImpl represents DAO for the domain class User. 
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    private static final String SQL_FIND_BY_ID =
            "SELECT user_id, user_name, user_email, user_role FROM userTest WHERE user_id = ?"; 
    private static final String SQL_FIND_BY_EMAIL =
            "SELECT user_id, user_name, user_email, user_role FROM userTest WHERE user_email = ?";
    private static final String SQL_LIST =
            "SELECT user_id, user_name, user_email, user_role FROM userTest";
    private static final String SQL_INSERT =
            "INSERT INTO userTest (user_name, user_password, user_email, user_role) VALUES (?, MD5(?), ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE userTest SET user_name = ?, user_email = ?, user_role= ? WHERE user_id = ?";
    private static final String SQL_DELETE =
            "DELETE FROM userTest WHERE user_email = ?";
    private static final String SQL_EXIST_EMAIL =
            "SELECT user_id FROM userTest WHERE user_email = ?";
    private static final String SQL_CHANGE_PASSWORD =
            "UPDATE userTest SET user_password = MD5(?) WHERE user_id = ?";
    
    @Override
    public User findId(Connection connect, List values){
        User user = new User();
        try {
            ResultSet rs = executeQuery(connect, SQL_FIND_BY_ID, values);
            while(rs.next()){
                user = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findEmail(Connection connect, List values) throws RuntimeException {
        User user = new User();
        try {
            ResultSet rs = executeQuery(connect, SQL_FIND_BY_EMAIL, values);
            while(rs.next()){
                user = map(rs);
            }
       } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    @Override
    public List<User> list(Connection connect) throws RuntimeException {
        User user = new User();
        List<User> listUser = new ArrayList<>();
        try {
           PreparedStatement statement = connect.prepareStatement(SQL_LIST);
            ResultSet rs = statement.executeQuery();
               while(rs.next()){
                  listUser.add((User)map(rs));
               }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public void createUser(Connection connect, List values) throws RuntimeException {
        updateQuery(connect, SQL_INSERT, values);
 }

    @Override
    public void update(Connection connect, List values) throws IllegalArgumentException, RuntimeException {
        updateQuery(connect, SQL_UPDATE, values);
        
    }

    @Override
    public void deleteByEmail(Connection connect, String email) throws RuntimeException {
        try {
            PreparedStatement statement = connect.prepareStatement(SQL_DELETE);
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existEmail(Connection connect, String email) throws RuntimeException {
        boolean result = false;
        ResultSet rs = null;
        try {
            PreparedStatement statement = connect.prepareStatement(SQL_EXIST_EMAIL);
            statement.setString(1, email);
            rs = statement.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void changePassword(Connection connect, List values) throws RuntimeException {
        updateQuery(connect, SQL_CHANGE_PASSWORD, values);
    }
    
    /**
     * Map the current row of the given ResultSet to an User.
     * @param resultSet The ResultSet of which the current row is to be mapped to an User.
     * @return The mapped User from the current row of the given ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
       // while(resultSet.next()){
        user.setUserId((long)resultSet.getLong("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setUserEmail(resultSet.getString("user_email"));
        user.setUserRole(resultSet.getString("user_role"));
        //}
        return user;
    }
    
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        ConnectionDB connect1 = new ConnectionMysqlDB();
        List<User> userList;
        try {
            userList = userDAO.list((Connection)connect1.getConnection());
            for(User u: userList){
                 System.out.println(u.toString());
            }
        } catch (RuntimeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        //User user1= new User(null, "nickolas", "press", "nickolas@ltddd.ua", "user");
        //userDAO.createUser(user1);
        //User user = userDAO.findEmail("bigg@com.com");
        //System.out.println(user);
       
        //------------------------------------------------------------------------------
        
        List list = new ArrayList();
        int id = 9;
        String email = "bigg@com.com";
        list.add(email);
        ConnectionDB connect = new ConnectionMysqlDB();
        try {
            Connection con = connect.getConnection();
            User user1 = userDAO.findEmail(con, list);
            System.out.println(user1);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //user_name, user_password, user_email, user_role 
        //SET user_name = ?, user_email = ?, user_role= ? WHERE id = ?";
        int id1 = 2;
        List listUser = new ArrayList();
        listUser.add("Password");
        //listUser.add("billAnderson");
        //listUser.add("bill@bgg.com");
        //listUser.add("user");
        listUser.add(id1);
        try {
            Connection con1 = connect.getConnection();
            //userDAO.changePassword(con1, listUser);
            //boolean result = userDAO.existEmail(con1, "bigg@com.com");
            //System.out.println(result);
            //userDAO.deleteByEmail(con1, "bill@bgg.com");
            //userDAO.update(con1, listUser);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
