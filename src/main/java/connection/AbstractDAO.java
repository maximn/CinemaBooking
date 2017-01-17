/**
 * 
 */
package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author artem
 *
 */
public abstract class AbstractDAO {
    private SessionFactory sessionFactory = null;
    
    public SessionFactory getSessionFactory(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

}
