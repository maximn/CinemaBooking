package connection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.joda.time.DateTime;

import domain.Film;
import domain.Sessions;

public class SessionsDAOImpl extends AbstractDAO implements SessionsDAO {

    @Override
    public Sessions findId(Integer id) throws RuntimeException {
        Sessions sessionsCinema = new Sessions();
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            sessionsCinema = (Sessions) session.get(Sessions.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session != null) && (session.isOpen())) 
                session.close();
        }
        return sessionsCinema;
    }

    @Override
    public List<Sessions> findSessionsFilm(Film film) throws RuntimeException {
     // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Sessions> findSessionDate(DateTime sessionsDate) throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<Sessions> list() throws RuntimeException {
        Session session = null;
        List<Sessions> listOfSessions = new ArrayList<Sessions>();
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            listOfSessions = session.createCriteria(Sessions.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if((session != null) && (session.isOpen())) session.close(); 
        }
        return listOfSessions;
    }

    @Override
    public void createSession(Sessions sessionCinema) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sessionCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void update(Sessions sessionCinema) throws IllegalArgumentException, RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sessionCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void deleteById(Sessions sessionCinema) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.getTransaction();
            session.delete(sessionCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
