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
public abstract class DAOFactory {
    public abstract UserDAO getUserDAO();
    public abstract SessionDAO getSessionDAO();
    public abstract FilmDAO getFilmDAO();
    public abstract SeatDAO getSeatDAO();
    public abstract OrderDAO getOrderDAO();
    
    /**
     * Returns a connection to the database.
     * @return A connection to the database.
     * @throws SQLException If the connection fails.
     */
    abstract void getConnection() throws SQLException;
    
    public static DAOFactory getDAOFactory(){
        return new MysqlDAOFactory();
    }

}
