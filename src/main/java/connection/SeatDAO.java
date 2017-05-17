/**
 * 
 */
package connection;

import java.sql.Connection;
import java.util.List;

import domain.Film;
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
     * @param id (Integer) ID of the seat to be returned.
     * @return Seat from the database matching the given seat_id.
     * @throws RuntimeException if something fails at the database.
     */
    public Seat findId(Integer id) throws RuntimeException;
    
    /**
     * Returns list of Seat from the database. The list is never null and is empty 
     * when database does not contain any Seat. 
     * @return list of all objects Seat from the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Seat> list() throws RuntimeException;
    
    /**
     * Creates a new Seat in the database.
     * @param seatInConcreteHall of the type Seat is the concrete seat of the concrete hall of the concrete Film and Session.
     * @throws RuntimeException if something fails at the database level.
     */
    public void createSeat(Seat seatInConcreteHall)throws RuntimeException;
    
    /**
     * Update the given Seat in the database. Seat_id must not be null, otherwise it will throw 
     * IllegalArgumentException.
     * @param seatInConcreteHall of the type Seat is the concrete seat of the concrete hall of the concrete Film and Session.
     * @throws IllegalArgumentException if the Seat_id is null.
     * @throws RuntimeException if something fails at the database level.
     */
    public void update(Seat seatInConcreteHall) throws IllegalArgumentException, RuntimeException;
    
    /**
     * Deletes Seat matching with the given seat_id and the session parameter.
     * @param seatInConcreteHall of the type Seat is the concrete seat of the concrete hall of the concrete Film and Session.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteSession(Seat seatInConcreteHall) throws RuntimeException;
    
    
}
