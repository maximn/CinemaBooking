/**
 * 
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

import javax.script.ScriptException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import domain.User;

/**
 * Represents unit tests for UserDAOImpl.java.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public class UserDAOImplTest {
    private static final String CREATE_TEST_TABLE = "CREATE TABLE userTest(user_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
            + "user_name VARCHAR(60) NULL, user_password VARCHAR(32) NOT NULL, "
            + "user_email VARCHAR(60) NOT NULL, user_role VARCHAR(60) NULL, "
            + "PRIMARY KEY (user_id), UNIQUE (user_email))";
    private static final String INSRT_TEST_USER = "INSERT INTO userTest(user_name, user_password, "
            + "user_email, user_role)VALUES('arar', '23471', 'arar@com.com', 'user')";
    private static final String DROP_TEST_TABLE ="DROP TABLE userTest";
    
    private UserDAOImpl userDAO = new UserDAOImpl();
    private ConnectionDB connect = new ConnectionH2DB();
    
    @Before
    public void before() throws ScriptException, SQLException {
          userDAO.setConnection(connect);
          Statement statement = userDAO.getConnection().createStatement();
          statement.executeUpdate(CREATE_TEST_TABLE);
          statement.executeUpdate(INSRT_TEST_USER);
          //ScriptUtils.executeSqlScript(userDAO.getConnection(), new ClassPathResource("user_t_create.sql"));
        System.out.println("ok");
    }
    
    @After
    public void after() throws ScriptException, SQLException {
        userDAO.setConnection(connect);
        Statement statement = userDAO.getConnection().createStatement();
        statement.executeUpdate(DROP_TEST_TABLE);
        //ScriptUtils.executeSqlScript(userDAO.getConnection(), new ClassPathResource("user_t_drop.sql"));
        System.out.println("ok");
    }
    
    @Test
    public void existEmailTest(){
        assertTrue(userDAO.existEmail("arar@com.com"));
    }
    
    @Test
    public void insertUserTest(){
        User user = new User(null, "Nick", "32344", "nick@nick.com", "user");
        userDAO.createUser(user);
        System.out.println("The first" + userDAO.findId(1).toString());
        assertTrue(userDAO.existEmail("nick@nick.com"));
        assertEquals(user.equals(userDAO.findEmail("nick@nick.com")), true);
    }
    
    @Test
    public void changePasswordTest(){
        User user1 = new User((long)1, "arar", "234sa71", "arar@com.com", "user");
        userDAO.changePassword(user1);
        assertEquals(user1.equals(userDAO.findEmail("arar@com.com")), true);
    }
    
    @Test 
    public void updateTest(){
        User user1 = new User((long)1, "Nickk", "345456", "nick@nick.com", "user");
        userDAO.updateUser(user1);
        assertEquals(user1.equals(userDAO.findEmail("nick@nick.com")), true);
    }
    
    @Test
    public void findIdTest(){
        User user = userDAO.findId(1);
        User user1 = new User((long)1,"arar", "23471", "arar@com.com", "user");
        assertEquals(user.equals(user1),true);
    }
    
    @Test
    public void findEmailTest(){
        User user = userDAO.findEmail("arar@com.com");
        User user1 = new User((long)1,"arar", "23471", "arar@com.com", "user");
        assertEquals(user.equals(user1), true);
    }
    
    @Test
    public void listTest(){
        List<User> userList = userDAO.list();
        User user = userList.get(0);
        User user1 = new User((long)1,"arar", "23471", "arar@com.com", "user");
        assertEquals(user.equals(user1), true);
    }
    
    @Test
    public void deleteByEmailTest(){
        User user = userDAO.findEmail("arar@com.com");
        userDAO.deleteByEmail(user);
        User user1 = new User();
        assertEquals(user1, userDAO.findEmail("arar@com.com"));
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
