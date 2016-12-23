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
            "INSERT INTO userTest (user_name, user_password, user_email, user_role) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE userTest SET user_name = ?, user_email = ?, user_role= ? WHERE user_id = ?";
    private static final String SQL_DELETE =
            "DELETE FROM userTest WHERE user_email = ?";
    private static final String SQL_EXIST_EMAIL =
            "SELECT user_id FROM userTest WHERE user_email = ?";
    private static final String SQL_CHANGE_PASSWORD =
            "UPDATE userTest SET user_password = ? WHERE user_id = ?";
    
    @Override
    public User findId(Integer id){
        User user = new User();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                user = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findEmail(String email) throws RuntimeException {
        User user = new User();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SQL_FIND_BY_EMAIL);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
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
    public List<User> list() throws RuntimeException {
        User user = new User();
        List<User> listUser = new ArrayList<>();
        try {
           PreparedStatement statement = getConnection().prepareStatement(SQL_LIST);
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
    public void createUser(User user) throws RuntimeException {
        Object[] values = {
            user.getUserName(),
            user.getUserPassword(),
            user.getUserEmail(),
            user.getUserRole()
        };
        updateQuery(SQL_INSERT, values);
 }

    @Override
    public void updateUser(User user) throws IllegalArgumentException, RuntimeException {
        Object[] values = {
          user.getUserName(),
          user.getUserEmail(),
          user.getUserRole(),
          user.getUserId()
        };
        updateQuery(SQL_UPDATE, values);
        
    }

    @Override
    public void deleteByEmail(User user) throws RuntimeException {
        try {
            PreparedStatement statement = getConnection().prepareStatement(SQL_DELETE);
            statement.setString(1, user.getUserEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existEmail(String email) throws RuntimeException {
        boolean result = false;
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SQL_EXIST_EMAIL);
            statement.setString(1, email);
            rs = statement.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void changePassword(User user) throws RuntimeException {
        Object[] values ={
                user.getUserPassword(),
                user.getUserId()
        };
        updateQuery(SQL_CHANGE_PASSWORD, values);
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
        userDAO.setConnection(new ConnectionMysqlDB());
        List<User> userList;
        try {
            userList = userDAO.list();
            for(User u: userList){
                 System.out.println(u.toString());
            }
        } catch (RuntimeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
                       
        //------------------------------------------------------------------------------
        
        List list = new ArrayList();
        int id = 9;
        String email = "bigg@com.com";
        list.add(email);
        ConnectionDB connect = new ConnectionMysqlDB();
        userDAO.setConnection(new ConnectionMysqlDB());
        try {
            Connection con = userDAO.getConnection();
            User user1 = userDAO.findEmail(email);
            System.out.println("User findEmail: " + user1);
            user1 = userDAO.findId(id);
            System.out.println("User fingId: " + user1);
            User user2 = new User(null, "Modsno", "123432", "modsno@nomo.com", "user");
            user2.setUserPassword("123432");
            //userDAO.createUser(user2);
            //userDAO.update(user2);
            //userDAO.changePassword(user2);
            System.out.println(userDAO.existEmail("fsjdkfh"));
            //userDAO.deleteByEmail(user2);
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
