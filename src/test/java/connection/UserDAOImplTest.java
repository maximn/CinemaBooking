/**
 * 
 */
package connection;



import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import domain.User;

/**
 * Represents unit tests for UserDAOImpl.java.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */




public class UserDAOImplTest {
    
    
    private UserDAOImpl userDAO = new UserDAOImpl();
    
     
    private User user = new User(null, "arar", "23471", "arar@com.com", "user");
    
        
    @Test
    public void findId(){
        userDAO.createUser(user);
        User user = userDAO.findId(1);
        assertEquals(user.equals(userDAO.findEmail("arar@com.com")), true);

        
    }


    
    @Test
    public void existEmailTest(){
        UserDAOImpl userDAO1 = new UserDAOImpl();
        User user1 = new User(null , "arar", "23471", "arara@com.com", "user");
        userDAO1.createUser(user1);
        assertTrue(userDAO.existEmail("arara@com.com"));
    }
    
//    @Test
//    public void insertUserTest(){
//        User user = new User(null, "Nick", "32344", "nick@nick.com", "user");
//        userDAO.createUser(user);
//        System.out.println("The first" + userDAO.findId(1).toString());
//        assertTrue(userDAO.existEmail("nick@nick.com"));
//        assertEquals(user.equals(userDAO.findEmail("nick@nick.com")), true);
//    }
//    
//    @Test
//    public void changePasswordTest(){
//        User user1 = new User((long)1, "arar", "234sa71", "arar@com.com", "user");
//        User user2 = new User((long)1, "arar", "23471", "arar@com.com", "user");
//        userDAO.createUser(user1);
//        String pass = userDAO.findEmail("arar@com.com").getUserPassword();
//        userDAO.changePassword(user2);
//        assertNotEquals(pass, userDAO.findEmail("arar@com.com").getUserPassword());
//    }
//    
//    @Test 
//    public void updateTest(){
//        User user1 = new User((long)1, "Nickk", "345456", "nick@nick.com", "user");
//        User user2 = new User((long)1, "arar", "23471", "arar@com.com", "user");
//        userDAO.createUser(user2);
//        userDAO.updateUser(user1);
//        assertEquals(user1.equals(userDAO.findEmail("nick@nick.com")), true);
//    }
//    
//    @Test
//    public void findIdTest(){
//        User user = new User(null,"arar", "23471", "arar@com.com", "user");
//        userDAO.createUser(user);
//        assertEquals(user.equals(userDAO.findId(1)),true);
//    }
//    
//    @Test
//    public void findEmailTest(){
//        User user1 = new User((long)1,"arar", "23471", "arar@com.com", "user");
//        userDAO.createUser(user1);
//        assertEquals(user1.equals(userDAO.findEmail("arar@com.com")), true);
//    }
//    
//    @Test
//    public void listTest(){
//        User user1 = new User(null,"arar", "23471", "arar@com.com", "user");
//        userDAO.createUser(user1);
//        List<User> userList = userDAO.list();
//        User user = userList.get(0);
//        assertEquals(user.equals(user1), true);
//    }
//    
//    @Test
//    public void deleteByEmailTest(){
//        User user = new User(null,"arar", "23471", "arar@com.com", "user");
//        userDAO.createUser(user);
//        userDAO.deleteByEmail(user);
//        assertEquals(userDAO.findEmail("arar@com.com")==null, true);
//    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
