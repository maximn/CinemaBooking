/**
 * 
 */
package connection;

import domain.User;

import java.util.List;

/**
 * This interface represents a contract for a DAO for the User model.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public interface UserDAO {
    
    /**
     * Returns user from the database matching the given user_id in the List, otherwise returns User object 
     * with the fields filled with null. 
     * @param connect (Connection) object with already existed connection to the database. 
     * @param values List with the (Integer) ID of the user to be returned.
     * @return (User) object from the database matching the given ID, otherwise returns User object 
     * with the fields filled with null.
     * @throws RuntimeException if something fails at the database level.
     */
    public User findId(long id) throws RuntimeException;
    
    /**
     * Returns user from the database matching the given user_email in the List, otherwise returns User object 
     * with the fields filled with null.
     * @param connect (Connection) object with already existed connection to the database. 
     * @param values List with the (String) email of the user to be returned.
     * @return (User) object from the database matching the given ID, otherwise returns User object 
     * with the fields filled with null.
     * @throws RuntimeException if something fails at the database level.
     */
    public User findEmail(String email) throws RuntimeException;
    
    /**
     * Returns a list of all users from the database. The list is never null and is empty 
     * when database does not contain any user.
     * @param connect (Connection) object with already existed connection to the database. 
     * @return  a list of all users from the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public List<User> list() throws RuntimeException;
    
    /**
     * Create a new user in the database. The user_id must be null, database will generate a new user_id.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values a list with the user's parameters to be created in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public void createUser(User user) throws RuntimeException;
    
    /**
     * Updates the given user in the database. user_id must not be null, otherwise it will throw 
     * IllegalArgumentException. Note: the password will not be updated. Use changePassword() instead. 
     * @param connect (Connection) object with already existed connection to the database.
     * @param values a list with the user's parameters to be updated in the database.
     * @throws IllegalArgumentException if the user_id is null.
     * @throws RuntimeException if something fails at the database level.
     */
    public void updateUser(User user) throws IllegalArgumentException, RuntimeException;
    
    /**
     * Deletes user from the database matching with the given email.
     * @param connect (Connection) object with already existed connection to the database.
     * @param email user's email.
     * @throws RuntimeException if something fails at the database level.
     */
    public void deleteByEmail(User user) throws RuntimeException;
    
    /**
     * Returns true if the given email exists in the database.
     * @param connect (Connection) object with already existed connection to the database.
     * @param email user's email.
     * @return true if the given email exists in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public boolean existEmail(String email) throws RuntimeException;
    
    /**
     * Changes the password of the given user. user_id must not be null, otherwise it will throw 
     * IllegalArgumentException.
     * @param connect (Connection) object with already existed connection to the database.
     * @param values a list with the new password and user_id in the database.
     * @throws RuntimeException if something fails at the database level.
     */
    public void changePassword(User user) throws IllegalArgumentException, RuntimeException;

}
