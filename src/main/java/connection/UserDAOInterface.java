/**
 * 
 */
package connection;

import java.util.List;

import domain.User;

/**
 * This interface represents a contract for a DAO for the User model.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public interface UserDAOInterface {
    public User find(Long id) throws RuntimeException;
    public User find(String email, String password) throws RuntimeException;
    public List<User> list() throws RuntimeException;
    public void createUser(User user) throws RuntimeException;
    public void update(User user) throws IllegalArgumentException, RuntimeException;
    public void delete(User user) throws RuntimeException;
    public boolean existEmail(String email) throws RuntimeException;
    public void changePassword(User user) throws RuntimeException;

}
