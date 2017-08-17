/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class represents a DAO factory for a SQL database.
 * @author Artem Meleshko
 * @version 1.0 2016
 */
public abstract class AbstractDAOFactory {
    public abstract UserDAO getUserDAO();

    /**
     * Returns a connection to the database.
     * @return A connection to the database.
     * @throws SQLException If the connection fails.
     */
    abstract Connection getConnection() throws SQLException;
    
    public static AbstractDAOFactory getDAOFactory(){
        return new MysqlDAOFactory();
    }

}
