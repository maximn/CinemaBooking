package connection;

import java.sql.Connection;
import java.util.List;

import domain.Session;

/**
 * This interface represents a contract for a DAO for the Session model.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public interface SessionDAO {
    /**
     * Returns Session from the database matching with the given session_id in the List, otherwise returns Session object
     *  with the fields filled with null.
     * @param connect (Connection) object with already existed connection to the database. 
     * @param values List with the (Integer) ID of the session to be returned.
     * @return returns Session from the database matching with the given session_id.
     * @throws RuntimeException if something fails at the database level.
     */
    public Session findId(Connection connect, List values) throws RuntimeException;
    
    /**
     * Returns a list of Session from the database matching with the given film name. The list is never null and is empty 
     * when database doesn't contain any Session with that film name.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the (String) film name of the session to be returned.
     * @return list of Session from the database matching with the given film name.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Session> findSessionsFilm(Connection connect, List values) throws RuntimeException;
    
    /**
     * Returns a list of Session from the database matching with the given film DateTime. The list is never null and is empty
     * when database doesn't contain any Session with that film DateTime.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the (DateTime) film DateTime of the session to be returned.
     * @return list of Session from the database matching with the given film DateTime.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Session> findSessionDate(Connection connect, List values) throws RuntimeException;
    
    /**
     * Returns a list with all Sessions in the database. The list is never null and is empty
     * when database doesn't contain any Session with that film DateTime.
     * @param connect (Connection) object with already existed connection to the database.
     * @return List with all Sessions in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Session> list(Connection connect) throws RuntimeException;
    
    /**
     * Creates a new Session in the database.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the parameters of the session. 
     * @throws RuntimeException if something fails at the database level.
     */
    public void createSession(Connection connect, List values) throws RuntimeException;
    
    /**
     * Update the given session in the database. session_id must not be null, otherwise it will throw 
     * IllegalArgumentException.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the parameters of the session to be updated in the database.
     * @throws IllegalArgumentException if the session_id is null.
     * @throws RuntimeException if something fails at the database level.
     */
    public void update(Connection connect, List values) throws IllegalArgumentException, RuntimeException;
    
    /**
     * Deletes Session from the database matching with given session_id.
     * @param connect (Connection) object with already existed connection to the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteById(Connection connect) throws RuntimeException;
    
    /**
     * Returns true if the given session exists in the database.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the parameters of the session to be deleted from the database.
     * @return true if the given session exists in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public boolean sessionExist(Connection connect, List values) throws RuntimeException;

}
