/**
 * 
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

import javax.script.ScriptException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        //user_name, user_password, user_email, user_role
        User user = new User(null, "Nick", "32344", "nick@nick.com", "user");
        userDAO.setConnection(connect);
        //userDAO.createUser(user);
        assertTrue(userDAO.existEmail("arar@com.com"));
    }
    
    @Test
    public void insertUserTest(){
        //user_name, user_password, user_email, user_role
        User user = new User(null, "Nick", "32344", "nick@nick.com", "user");
        //userDAO.setConnection(connect);
        //userDAO.createUser(user);
        //assertTrue(userDAO.createUser(user), true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
