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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
    
    
    private UserDAOImpl userDAO = new UserDAOImpl();
    
    

    
    @Test
    public void existEmailTest(){
        User user = new User((long)1, "arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user);
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
        User user2 = new User((long)1, "arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user1);
        String pass = userDAO.findEmail("arar@com.com").getUserPassword();
        userDAO.changePassword(user2);
        assertNotEquals(pass, userDAO.findEmail("arar@com.com").getUserPassword());
    }
    
    @Test 
    public void updateTest(){
        User user1 = new User((long)1, "Nickk", "345456", "nick@nick.com", "user");
        User user2 = new User((long)1, "arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user2);
        userDAO.updateUser(user1);
        assertEquals(user1.equals(userDAO.findEmail("nick@nick.com")), true);
    }
    
    @Test
    public void findIdTest(){
        User user = new User(null,"arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user);
        assertEquals(user.equals(userDAO.findId(1)),true);
    }
    
    @Test
    public void findEmailTest(){
        User user1 = new User((long)1,"arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user1);
        assertEquals(user1.equals(userDAO.findEmail("arar@com.com")), true);
    }
    
    @Test
    public void listTest(){
        User user1 = new User(null,"arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user1);
        List<User> userList = userDAO.list();
        User user = userList.get(0);
        assertEquals(user.equals(user1), true);
    }
    
    @Test
    public void deleteByEmailTest(){
        User user = new User(null,"arar", "23471", "arar@com.com", "user");
        userDAO.createUser(user);
        userDAO.deleteByEmail(user);
        assertEquals(userDAO.findEmail("arar@com.com")==null, true);
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
