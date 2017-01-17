package connection;

import java.util.List;

import org.joda.time.DateTime;

import domain.Film;
import domain.Session;

public class SessionDAOImpl extends AbstractDAO implements SessionDAO {

    @Override
    public Session findId(Integer id) throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Session> findSessionsFilm(Film film) throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Session> findSessionDate(DateTime sessionsDate) throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Session> list() throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createSession(Session sessionCinema) throws RuntimeException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Session sessionCinema) throws IllegalArgumentException, RuntimeException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Session sessionCinema) throws RuntimeException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean sessionExist(Session sessionCinema) throws RuntimeException {
        // TODO Auto-generated method stub
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
