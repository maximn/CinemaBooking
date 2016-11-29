package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserDAOImpl implements UserDAO{
    private static final String SQL_FIND_BY_ID =
            "SELECT user_id, user_name, user_email, user_role FROM userTest WHERE user_id = ?"; 
    private static final String SQL_FIND_BY_EMAIL =
            "SELECT user_id, user_name, user_email, user_role FROM userTest WHERE email = ?";
    private static final String SQL_LIST =
            "SELECT user_id, user_name, user_email, user_role FROM userTest";
    private static final String SQL_INSERT =
            "INSERT INTO userTest (user_name, user_password, user_email, user_role) VALUES (?, MD5(?), ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE userTest SET user_name = ?, user_email = ?, user_role= ? WHERE id = ?";
    private static final String SQL_DELETE =
            "DELETE FROM userTest WHERE user_email = ?";
    private static final String SQL_EXIST_EMAIL =
            "SELECT id FROM userTest WHERE user_email = ?";
    private static final String SQL_CHANGE_PASSWORD =
            "UPDATE userTest SET password = MD5(?) WHERE id = ?";

    @Override
    public User find(Integer id) throws RuntimeException {
        User user = new User();
        MysqlDAOFactory connect = new MysqlDAOFactory();
        connect.initProperties();
        try {
           PreparedStatement statement = connect.getConnection().prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
            user = map(rs);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User find(String email) throws RuntimeException {
        User user = new User();
        MysqlDAOFactory connect = new MysqlDAOFactory();
        connect.initProperties();
        try {
           PreparedStatement statement = connect.getConnection().prepareStatement(SQL_FIND_BY_ID);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
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
        MysqlDAOFactory connect = new MysqlDAOFactory();
        connect.initProperties();
        try {
           PreparedStatement statement = connect.getConnection().prepareStatement(SQL_LIST);
            ResultSet rs = statement.executeQuery();
               while(rs.next()){
                  listUser.add(map(rs));
               }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public void createUser(User user) throws RuntimeException {
        // SQL_INSERT
        if (user.getUserId() != null) {
            throw new IllegalArgumentException("User is already created, the user ID is not null.");
        }
        Object[] values ={
                user.getUserName(),
                user.getUserPassword(),
                user.getUserEmail(),
                user.getUserRole()};
        MysqlDAOFactory connect = new MysqlDAOFactory();
        connect.initProperties();
        try {
           PreparedStatement statement = connect.getConnection().prepareStatement(SQL_INSERT);
           for(int i=0;i<values.length;i++){
               statement.setObject(i+1, values[i]);
           }
           ResultSet rs = statement.executeQuery();
               
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) throws IllegalArgumentException, RuntimeException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(User user) throws RuntimeException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean existEmail(String email) throws RuntimeException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void changePassword(User user) throws RuntimeException {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Map the current row of the given ResultSet to an User.
     * @param resultSet The ResultSet of which the current row is to be mapped to an User.
     * @return The mapped User from the current row of the given ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        while(resultSet.next()){
        user.setUserId((long)resultSet.getLong("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setUserEmail(resultSet.getString("user_email"));
        user.setUserRole(resultSet.getString("user_role"));
        }
        return user;
    }
    
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.find(2);
        System.out.println(user);
    }

}
