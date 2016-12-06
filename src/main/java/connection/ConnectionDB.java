package connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class represents an abstract class for the SQL database connection.
 * @author Artem Meleshko
 * @version 1.0 2016
 */
public abstract class ConnectionDB {
    public abstract void initProperties();
    public abstract Connection getConnection() throws SQLException;
    public abstract void closeConnection();

}
