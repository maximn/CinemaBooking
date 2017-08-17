package connection;

import domain.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDAOImpl represents DAO for the domain class User. 
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    
   @Override
    public User findId(long id){
        User user = new User();
        Session session = null;
        try {
          //  session = getSessionFactory().openSession();
            session = getSession();
        user = (User) session.get(User.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) 
                session.close();
            closeSession();
           // closeSessionFactory();
        }
        return user;
    }

    @Override
    public User findEmail(String email) throws RuntimeException {
        Session session = null;
        User user = new User();
        try {
            //session = getSessionFactory().openSession();
            session = getSession();
            user = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
                    .setString("user_email", email)
                    .uniqueResult();
       } 
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close(); 
                closeSession();
            //closeSessionFactory();
        }
        return user;
    }
    
    
    @Override
    public List<User> list() throws RuntimeException {
        Session session = null;
        User user = new User();
        List<User> listUser = new ArrayList<User>();
        try {
           session = getSession();
           listUser = session.createCriteria(User.class).list();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
                closeSession();
           // closeSessionFactory();
        }
        return listUser;
    }

    @Override
    public void createUser(User user) throws RuntimeException {
        Session session = null;
        try {
           // session = getSessionFactory().openSession();
          session = getSession();
//            session.beginTransaction();
//            session.saveOrUpdate(user);
//            session.getTransaction().commit();
            
            
            beginSessionsTransaction();
            saveOrUpdateSession(user);
            commitSessionsTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
                closeSession();
           // closeSessionFactory();
        }
 }

    @Override
    public void updateUser(User user) throws IllegalArgumentException, RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
           // closeSessionFactory();
        }
        
    }

    @Override
    public void deleteByEmail(User user) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
           // closeSessionFactory();
        }
    }

    @Override
    public boolean existEmail(String email) throws RuntimeException {
        User user = null;
        boolean result = false;
        Session session = null;
        try {
            //session = getSessionFactory().openSession();
            session = getSession();
            user = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
                    .setString("user_email", email)
                    .uniqueResult();
            if (user != null){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
           // closeSession();
           // closeSessionFactory();
        }
        return result;
    }

    @Override
    public void changePassword(User user) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
            closeSessionFactory();
        }
    }
    
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
//        long id = 2;
        User user = new User(0, "Mods232no", "1234324", "modsno@nomo2.com", "user");
        userDAO.createUser(user);
        User user1 = userDAO.findEmail("garry_gefferson1959@garry.com");
        List<User> userList = userDAO.list();
        for(User c : userList){
            System.out.println(c.toString());
        }
       // User user2 = new User((long) 2, "Mods", "1234324", "mod@no.com", "user");
        //userDAO.updateUser(user2);
        //userDAO.deleteByEmail(user2);
        
       System.out.println(userDAO.existEmail("garry_gefferson1959@garry.com"));
        
        
    }

}
