/**
 * 
 */
package connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author artem
 *
 */
public abstract class AbstractDAO {
    private SessionFactory sessionFactory = null;
    private Session session = null;
    
    public SessionFactory getSessionFactory(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
    
    public Session getSession(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }
    
    public Session getOpenedSession(){
        return session;
    }
    
    public void beginSessionsTransaction(){
        session.beginTransaction();
    }
    
    public void saveOrUpdateSession(Object object){
        session.saveOrUpdate(object);
    }
    
    public void commitSessionsTransaction(){
        session.getTransaction().commit();
    }
    
    public void closeSession(){
        session.close();
    }
    
    public void closeSessionFactory(){
        sessionFactory.close();
    }

}
