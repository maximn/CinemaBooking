package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.User;

public class UserDAO implements UserDAOInterface{
    private static final String SQL_FIND_BY_ID =
            "SELECT user_name, user_email, user_role FROM userTest WHERE user_id = ?"; 
    private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD =
            "SELECT user_name, user_email, user_role FROM userTest WHERE email = ? AND password = MD5(?)";
    private static final String SQL_LIST_ORDER_BY_ID =
            "SELECT user_name, user_email, user_role FROM userTest ORDER BY id";
    private static final String SQL_INSERT =
            "INSERT INTO userTest (user_name, user_password, user_email, user_role) VALUES (?, MD5(?), ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE userTest SET user_name = ?, user_email = ?, user_role= ? WHERE id = ?";
    private static final String SQL_DELETE =
            "DELETE FROM userTest WHERE id = ?";
    private static final String SQL_EXIST_EMAIL =
            "SELECT id FROM userTest WHERE email = ?";
    private static final String SQL_CHANGE_PASSWORD =
            "UPDATE userTest SET password = MD5(?) WHERE id = ?";

    @Override
    public User find(Long id) throws RuntimeException {
        return find(SQL_FIND_BY_ID, id);
    }

    @Override
    public User find(String email, String password) throws RuntimeException {
        return find(SQL_FIND_BY_EMAIL_AND_PASSWORD, email, password);
    }
    
    private User find(String sql, Object... values){
        DBConnection connect = new DBConnection("localhost", "root", "bonjorno", "test");
        connect.initProperties();
        connect.init();
        return null;
    }

    @Override
    public List<User> list() throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createUser(User user) throws RuntimeException {
        // TODO Auto-generated method stub
        
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
        user.setUserId(resultSet.getLong("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setUserEmail(resultSet.getString("user_email"));
        return user;
    }

}
