package domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * represents notation with the information about the seats in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Seat {
    private Integer sessionId;
    private Map<Integer, String> seatsNumStat = new LinkedHashMap<Integer, String>();
    /**
     * Constructs and initialized Seat.
     * @param seatNumber is a seat's number.
     * @param seatStatus is a seat's status (reserved, booked, free);
     */
    
    private Seat(Integer sessionId, Map seatsNumStat){
        this.sessionId=sessionId;
        this.seatsNumStat=seatsNumStat;
    }
    
    /**
     * Constructs and initialized Seat object with the empty fields.
     */
    
    public Seat(){
        this(null, null);
    }
   
    /**
     * @return the sessionId
     */
    public Integer getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the seatsNumStat
     */
    public Map<Integer, String> getSeatsNumStat() {
        return seatsNumStat;
    }

    /**
     * @param seatsNumStat the seatsNumStat to set
     */
    public void setSeatsNumStat(Map<Integer, String> seatsNumStat) {
        this.seatsNumStat = seatsNumStat;
    }
        
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Seat [sessionId=" + sessionId + ", seatsNumStat=" + seatsNumStat.toString() + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime * result + ((seatsNumStat == null) ? 0 : seatsNumStat.hashCode());
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
        return (Objects.equals(sessionId, other.sessionId)) && (Objects.equals(seatsNumStat, other.seatsNumStat));
    }
    
    
    public static void main(String[] args){
       
        Seat seat = new Seat();
        Map<Integer, String> seatsNumStat = new LinkedHashMap<Integer, String>();
        seatsNumStat.put(1, "free");
        seat.setSessionId(332);
        seat.setSeatsNumStat(seatsNumStat);
        System.out.println(seat);
    }
    

}
