/**
 * 
 */
package connection;

import java.util.List;

import domain.Film;
import domain.Order;

/**
 * This interface represents DAO for the Order model.
 * @author Artem Meleshko   
 * @version 1.0 2017
 *
 */
public interface OrderDAO {
    
    /**
     * Returns Order from the database matching with the given order_id in the List, otherwise returns Order object
     *  with the fields filled with null.
     * @param id (Integer) ID of the Order to be returned.
     * @return returns Order object from the database matching with the given order_id.
     * @throws RuntimeException if something fails at the database level.
     */
    public Order findId(Integer id) throws RuntimeException;
    
    /**
     * Returns a list of Order from the database matching with the given film name. The list is never null and is empty 
     * when database doesn't contain any Order with that film name.
     * @param film Film object with the film's parameters of the Order to be returned.
     * @return list of Order from the database matching with the given film name.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Order> findOrdersFilm(Film film) throws RuntimeException;
    
    /**
     * Returns a list with all Orders in the database. The list is never null and is empty
     * when database doesn't contain any Order with that film DateTime.
     * @return List with all Orders in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Order> list() throws RuntimeException;
    
    /**
     * Creates a new Order in the database.
     * @param OrderCinema domain.Order object with the parameters of the order. 
     * @throws RuntimeException if something fails at the database level.
     */
    public void createOrder(Order orderCinema) throws RuntimeException;
    
    /**
     * Update the given order in the database. order_id must not be null, otherwise it will throw 
     * IllegalArgumentException.
     * @param connect (Connection) object with already existed connection to the database.
     * @param orderCinema domain.Order object with the parameters of the order to be updated in the database.
     * @throws IllegalArgumentException if the order_id is null.
     * @throws RuntimeException if something fails at the database level.
     */
    public void update(Order orderCinema) throws IllegalArgumentException, RuntimeException;
    
    /**
     * Deletes Order from the database matching with given order_id.
     * @param orderCinema domain.Order object with the parameters of the order to be deleted in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteById(Order orderCinema) throws RuntimeException;

}
