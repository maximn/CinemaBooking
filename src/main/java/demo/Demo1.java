package demo;

import connection.UserDAOImpl;
import domain.User;

public class Demo1 {

    public static void main(String[] args) {
       UserDAOImpl userDAO = new UserDAOImpl();
       
//       User user = new User();
//       user.setUserId(null);
//       user.setUserName("Frad");
//       user.setUserPassword("2222");
//       user.setUserEmail("frad@frad.com");
//       user.setUserRole("user");
//       
//       userDAO.createUser(user);
       
       //System.out.println(userDAO.existEmail("frad@frad.com") + "\n" + userDAO.findEmail("frad@frad.com"));
       System.out.println(userDAO.findEmail("frad@frad.com"));
       
      userDAO.closeSessionFactory();
       

    }

}
