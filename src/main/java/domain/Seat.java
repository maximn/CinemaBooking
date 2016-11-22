package domain;

import java.util.Objects;

/**
 * represents notation with the information about the seats in the cinema booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Seat {
    Integer seatNumber;
    String seatStatus;
    
    /**
     * Constructs and initialized Seat.
     * @param seatNumber is a seat's number.
     * @param seatStatus is a seat's status (reserved, booked, free);
     */
    
    Seat(Integer seatNumber, String seatStatus){
        this.seatNumber=seatNumber;
        this.seatStatus=seatStatus;
    }
    
    /**
     * Constructs and initialized Seat object with the empty fields.
     */
    
    public Seat(){
        this(null, null);
    }

    /**
     * @return the seatNumber
     */
    public Integer getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the seatStatus
     */
    public String getSeatStatus() {
        return seatStatus;
    }

    /**
     * @param seatStatus the seatStatus to set
     */
    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Seat [seatNumber=" + seatNumber + ", seatStatus=" + seatStatus + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
        result = prime * result + ((seatStatus == null) ? 0 : seatStatus.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Seat))
            return false;
        Seat other = (Seat) obj;
        return (Objects.equals(seatNumber, other.seatNumber)) && (Objects.equals(seatStatus, other.seatStatus));
    }
    
    

}
