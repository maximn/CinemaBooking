/**
 * 
 */
package connection;


import domain.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Represents unit tests for UserDAOImpl.java.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */




public class UserDAOImplTest {
    
    private UserDAOImpl userDAO = new UserDAOImpl();
    private User user = new User(0, "arar", "23471", "arar@com.com", "user");
    
    
//    @Before
//    public void beforeTest(){
//        userDAO.createUser(user);
//    }
        
    @Test
    public void findId(){
        User user = userDAO.findId(1);
        assertEquals(user.equals(userDAO.findEmail("arar@com.com")), true);
    }
    
    @Test
    public void existEmailTest(){
       assertTrue(userDAO.existEmail("arar@com.com"));
    }
    
    @Test
    public void createUserTest(){
        User user1 = new User(0, "Nick", "32344", "nick@nick.com", "user");
        userDAO.createUser(user1);
        System.out.println("The first" + userDAO.findId(1).toString());
        assertTrue(userDAO.existEmail("nick@nick.com"));
        assertEquals(user1.equals(userDAO.findEmail("nick@nick.com")), true);
    }
    
    @Test
    public void changePasswordTest(){
        User user2 = new User((long)1, "arar", "23a471", "arar@com.com", "user");
        String pass = userDAO.findEmail("arar@com.com").userPassword();
        userDAO.changePassword(user2);
        assertNotEquals(pass, userDAO.findEmail("arar@com.com").userPassword());
    }
    
    @Test 
    public void updateUserTest(){
        User user1 = new User((long)1, "Nickk", "345456", "nickk@nickk.com", "user");
        userDAO.updateUser(user1);
        assertEquals(user1.equals(userDAO.findEmail("nickk@nickk.com")), true);
    }
           
    @Test
    public void findEmailTest(){
        userDAO.createUser(user);
        User user1 = userDAO.findId(1);
        assertEquals(user1.equals(userDAO.findEmail("arar@com.com")), true);
    }
    
    @Test
    public void listTest(){
        List<User> userList = userDAO.list();
        User user = userList.get(0);
        assertEquals(user.equals(userDAO.findEmail("nickk@nickk.com")), true);
    }
    
    @Test
    public void deleteByEmailTest(){
        User user = new User(0,"arar", "23471", "arar@com.com", "user");
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
