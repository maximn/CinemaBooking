package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.User;

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
            session = getSessionFactory().openSession();
        user = (User) session.get(User.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) 
                session.close();
        }
        return user;
    }

    @Override
    public User findEmail(String email) throws RuntimeException {
        Session session = null;
        User user = new User();
        try {
            session = getSessionFactory().openSession();
            user = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
                    .setString("user_email", email)
                    .uniqueResult();
       } 
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) session.close();
        }
        return user;
    }
    
    
    @Override
    public List<User> list() throws RuntimeException {
        Session session = null;
        User user = new User();
        List<User> listUser = new ArrayList<User>();
        try {
           session = getSessionFactory().openSession();
           listUser = session.createCriteria(User.class).list();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public void createUser(User user) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if ((session != null)&&(session.isOpen())) 
                session.close();
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
        }
    }

    @Override
    public boolean existEmail(String email) throws RuntimeException {
        User user = null;
        boolean result = false;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            user = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
                    .setString("user_email", email)
                    .uniqueResult();
            if (user != null){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        }
    }
    
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        long id = 2;
        User user = new User(null, "Mods232no", "1234324", "modsno@nomo2.com", "user");
        //userDAO.createUser(user);
        User user1 = userDAO.findEmail("modsno@nomo.com");
        List<User> userList = userDAO.list();
        for(User c : userList){
            System.out.println(c.toString());
        }
        User user2 = new User((long) 2, "Mods", "1234324", "mod@no.com", "user");
        //userDAO.updateUser(user2);
        //userDAO.deleteByEmail(user2);
        
       System.out.println(userDAO.existEmail("modsno@nomo.com"));
        
        
    }

}
