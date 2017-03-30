package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import connection.UserDAOImpl;
import domain.User;

public class Demo1 {

    public static void main(String[] args) {
    
        UserDAOImpl userDAO = new UserDAOImpl();
       
       User user = new User();
       user.setUserId(null);
       user.setUserName("Gamlet");
       user.setUserPassword("3w33");
       user.setUserEmail("Gamlet@Gamlet.com");
       user.setUserRole("user");
       
       userDAO.createUser(user);
      // userDAO.deleteByEmail(user);
       
       
      // System.out.println(userDAO.existEmail("frad@frad.com") + "\n" + userDAO.findEmail("frad@frad.com"));
       //System.out.println(userDAO.findEmail("Gamlet@Gamlet.com"));
       
      //userDAO.closeSessionFactory();
        
       

    }

}
