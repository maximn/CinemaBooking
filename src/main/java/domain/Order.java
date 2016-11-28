package domain;

import java.util.Objects;

/**
 * Order represents list of order in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Order {
    private Integer orderId;
    private User user;
    private Seat seatNumber;
    private Film film;
    private Session session;
   
    /**
     * Constructs and initializes Order. 
     * @param orderNumber is a unique number of this order.
     * @param userId is a unique user's Id in the database.
     * @param seatNumber is a number of the seat which is reserved.
     * @param filmId is a unique Id of the film.
     * @param sessionId is a unique session's id.
     */
    
    public Order(Integer orderNumber, User user, Seat seatNumber, Film film, Session session) {
        this.orderId = orderNumber;
        this.user = user;
        this.seatNumber = seatNumber;
        this.film = film;
        this.session=session;
    }
    
    /**
     * Constructs and initializes Order with the empty fields.
     */
    public Order(){
        this(null, null, null, null, null);
    }

    /**
     * @return the orderNumber
     */
    public Integer getOrderNumber() {
        return orderId;
    }

    /**
     * @param orderNumber is a unique number of this order to set.
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderId = orderNumber;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return user;
    }

    /**
     * @param userId is a unique user's Id in the database to set.
     */
    public void setUserId(User user) {
        this.user = user;
    }

    /**
     * @return the seatNumber
     */
    public Seat getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber is a number of the seat which is reserved to set.
     */
    public void setSeatNumber(Seat seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the filmId
     */
    public Film getFilmId() {
        return film;
    }

    /**
     * @param filmId is a unique Id of the film to set.
     */
    public void setFilmId(Film film) {
        this.film = film;
    }

    /**
     * @return the sessionId
     */
    public Session getSessionId() {
        return session;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(Session session) {
        this.session = session;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Order [orderNumber=" + orderId + ", user=" + user + ", seatNumber=" + seatNumber + ", film="
                + film + ", session=" + session + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((film == null) ? 0 : film.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((session == null) ? 0 : session.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Order))
            return false;
        Order other = (Order) obj;
        return (Objects.equals(orderId, other.orderId)) && (Objects.equals(film, other.film)) 
                && (Objects.equals(seatNumber, other.seatNumber)) && (Objects.equals(user, other.user)) 
                && (Objects.equals(session, other.session));
    }
    
    
    
    

}
