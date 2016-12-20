/**
 * 
 */
package connection;

import java.sql.Connection;
import java.util.List;

import domain.Seat;

/**
 * This interface represents a contract for a DAO for the Seat model.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public interface SeatDAO {
    
    /**
     * Returns Seat from the database matching the given seat_id in the List, otherwise returns Seat object 
     * with the fields filled with null. 
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the (Integer) ID of the seat to be returned.
     * @return Seat from the database matching the given seat_id.
     * @throws RuntimeException if something fails at the database.
     */
    public Seat findId(Connection connect, List values) throws RuntimeException;
    
    /**
     * Returns list of Seat from the database matching the given seat status and session. The list is never null and is empty 
     * when database does not contain any seat. 
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the (String) seat_status and session parameter of the seat to be returned.
     * @return list of Seat from the database matching the given seat status and session.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Seat> findStatusSession(Connection connect, List values) throws RuntimeException;
    
    /**
     * Returns list of all Seat from the database matching the given the session parameter. The list is never null and is empty 
     * when database does not contain any seat. 
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the session parameter of the seat to be returned.
     * @return list of Seat from the database matching the given session parameter.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Seat> findAllSeatSession(Connection connect, List values) throws RuntimeException;
    
    /**
     * Creates a new Seat in the database.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the (String) seat_status and session parameter of the seat to be returned.
     * @return list of Seat from the database matching the given seat status and session.
     * @throws RuntimeException if something fails at the database level.
     */
    public void createSeat(Connection connect, List values)throws RuntimeException;
    
    /**
     * Deletes Seat matching with the given seat_id and the session parameter.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values values List with the (Integer) seat_id and session parameter of the seat to be deleted.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteByIdSession(Connection connect, List values) throws RuntimeException;
    
    /**
     * Returns true if given Seat exists.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values List with the (Integer) seat_id and session parameter of the seat to be deleted.
     * @return Returns true if given Seat exists.
     * @throws RuntimeException if something fails at the database level.
     */
    public boolean existSeatIdSession(Connection connect, List values) throws RuntimeException;
    

}
