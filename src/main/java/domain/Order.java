package domain;

import java.util.Objects;

/**
 * Order represents list of order in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Order {
    private Integer orderId;
    private User userId;
    private Seat seatNumber;
    private Film filmId;
    private Session sessionId;
   
    /**
     * Constructs and initializes Order. 
     * @param orderNumber is a unique number of this order.
     * @param userId is a unique user's Id in the database.
     * @param seatNumber is a number of the seat which is reserved.
     * @param filmId is a unique Id of the film.
     * @param sessionId is a unique session's id.
     */
    
    public Order(Integer orderNumber, User userId, Seat seatNumber, Film filmId, Session sessionId) {
        this.orderId = orderNumber;
        this.userId = userId;
        this.seatNumber = seatNumber;
        this.filmId = filmId;
        this.sessionId=sessionId;
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
        return userId;
    }

    /**
     * @param userId is a unique user's Id in the database to set.
     */
    public void setUserId(User userId) {
        this.userId = userId;
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
        return filmId;
    }

    /**
     * @param filmId is a unique Id of the film to set.
     */
    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    /**
     * @return the sessionId
     */
    public Session getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(Session sessionId) {
        this.sessionId = sessionId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Order [orderNumber=" + orderId + ", userId=" + userId + ", seatNumber=" + seatNumber + ", filmId="
                + filmId + ", sessionId=" + sessionId + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
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
        return (Objects.equals(orderId, other.orderId)) && (Objects.equals(filmId, other.filmId)) 
                && (Objects.equals(seatNumber, other.seatNumber)) && (Objects.equals(userId, other.userId)) 
                && (Objects.equals(sessionId, other.sessionId));
    }
    
    
    
    

}
