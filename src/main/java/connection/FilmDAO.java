/**
 * 
 */
package connection;

import java.util.List;

import domain.Film;



/**
 * This interface represents a contract for a DAO for the Film model.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public interface FilmDAO {
    
    /**
     * Returns Film from the database matching with the given Film_id in the List, otherwise returns Film object
     *  with the fields filled with null.
     * @param id (Integer) ID of the Film to be returned.
     * @return returns Film object from the database matching with the given Film_id.
     * @throws RuntimeException if something fails at the database level.
     */
    public Film findId(Integer id) throws RuntimeException;
    
    /**
     * Returns a list with all Films in the database. The list is never null and is empty
     * when database doesn't contain any Film.
     * @return List with all Films in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<Film> list() throws RuntimeException;
    
    /**
     * Creates a new Film in the database.
     * @param FilmCinema domain.Film object with the parameters of the Film. 
     * @throws RuntimeException if something fails at the database level.
     */
    public void createFilm(Film filmCinema) throws RuntimeException;
    
    /**
     * Update the given Film in the database. Film_id must not be null, otherwise it will throw 
     * IllegalArgumentException.
     * @param connect (Connection) object with already existed connection to the database.
     * @param FilmCinema domain.Film object with the parameters of the Film to be updated in the database.
     * @throws IllegalArgumentException if the Film_id is null.
     * @throws RuntimeException if something fails at the database level.
     */
    public void update(Film filmCinema) throws IllegalArgumentException, RuntimeException;
    
    /**
     * Deletes Film from the database matching with given Film_id.
     * @param FilmCinema domain.Film object with the parameters of the Film to be deleted in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteFilm(Film filmCinema) throws RuntimeException;

}
