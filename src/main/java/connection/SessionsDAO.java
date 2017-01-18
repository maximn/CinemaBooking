package connection;

import java.sql.Connection;
import java.util.List;

import org.joda.time.DateTime;

import domain.Film;
import domain.Sessions;

/**
 * This interface represents a contract for a DAO for the Session model.
 * @author Artem Meleshko
 * @version 1.01 2016
 *
 */
public interface SessionsDAO {
    /**
     * Returns Session from the database matching with the given session_id in the List, otherwise returns Session object
     *  with the fields filled with null.
     * @param id (Integer) ID of the session to be returned.
     * @return returns Session object from the database matching with the given session_id.
     * @throws RuntimeException if something fails at the database level.
     */
    public Sessions findId(Integer id) throws RuntimeException;
    
    /**
     * Returns a list of Session from the database matching with the given film name. The list is never null and is empty 
     * when database doesn't contain any Session with that film name.
     * @param film Film object with the film's parameters of the session to be returned.
     * @return list of Session from the database matching with the given film name.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Sessions> findSessionsFilm(Film film) throws RuntimeException;
    
    /**
     * Returns a list of Session from the database matching with the given film DateTime. The list is never null and is empty
     * when database doesn't contain any Session with that film DateTime.
     * @param sessionsDate with the (DateTime) film DateTime of the session to be returned.
     * @return list of Session from the database matching with the given film DateTime.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Sessions> findSessionDate(DateTime sessionsDate) throws RuntimeException;
    
    /**
     * Returns a list with all Sessions in the database. The list is never null and is empty
     * when database doesn't contain any Session with that film DateTime.
     * @return List with all Sessions in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Sessions> list() throws RuntimeException;
    
    /**
     * Creates a new Session in the database.
     * @param sessionCinema domain.Session object with the parameters of the session. 
     * @throws RuntimeException if something fails at the database level.
     */
    public void createSession(Sessions sessionCinema) throws RuntimeException;
    
    /**
     * Update the given session in the database. session_id must not be null, otherwise it will throw 
     * IllegalArgumentException.
     * @param connect (Connection) object with already existed connection to the database.
     * @param sessionCinema domain.Session object with the parameters of the session to be updated in the database.
     * @throws IllegalArgumentException if the session_id is null.
     * @throws RuntimeException if something fails at the database level.
     */
    public void update(Sessions sessionCinema) throws IllegalArgumentException, RuntimeException;
    
    /**
     * Deletes Session from the database matching with given session_id.
     * @param sessionCinema domain.Session object with the parameters of the session to be deleted in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteById(Sessions sessionCinema) throws RuntimeException;
    
    

}
