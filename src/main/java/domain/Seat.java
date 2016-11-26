package domain;

import java.util.*;

/**
 * represents notation with the information about the seats in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Seat {
    private Integer seatId;
    private Integer seatNum;
    private Integer seatRow;
    private String seatHall;
    private Set<Session> sessions = new LinkedHashSet<Session>();
        
    /**
     * Constructs and initialized Seat.
     * @param seatNumber is a seat's number.
     * @param seatStatus is a seat's status (reserved, booked, free);
     */
    
    private Seat(Integer seatId, Integer seatNum, Integer seatRow, String seatHall, Set sessions){
        this.seatId=seatId;
        this.seatNum=seatNum;
        this.seatRow=seatRow;
        this.seatHall=seatHall;
        this.sessions=sessions;
    }
    
    /**
     * Constructs and initialized Seat object with the empty fields.
     */
    public Seat(){
        this(null, null, null, null, null);
    }
   
    /**
     * @return the seatId
     */
    public Integer getSeatId() {
        return seatId;
    }

    /**
     * @param seatId the seatId to set
     */
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    /**
     * @return the seatNum
     */
    public Integer getSeatNum() {
        return seatNum;
    }

    /**
     * @param seatNum the seatNum to set
     */
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    /**
     * @return the seatRow
     */
    public Integer getSeatRow() {
        return seatRow;
    }

    /**
     * @param seatRow the seatRow to set
     */
    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    /**
     * @return the seatHall
     */
    public String getSeatHall() {
        return seatHall;
    }

    /**
     * @param seatHall the seatHall to set
     */
    public void setSeatHall(String seatHall) {
        this.seatHall = seatHall;
    }

    /**
     * @return the sessions
     */
    public Set<Session> getSessions() {
        return sessions;
    }

    /**
     * @param sessions the sessions to set
     */
    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Seat [seatId=" + seatId + ", seatNum=" + seatNum + ", seatRow=" + seatRow + ", seatHall=" + seatHall
                + ", sessions=" + sessions.toString() + "]";
    }

   

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((seatHall == null) ? 0 : seatHall.hashCode());
        result = prime * result + ((seatId == null) ? 0 : seatId.hashCode());
        result = prime * result + ((seatNum == null) ? 0 : seatNum.hashCode());
        result = prime * result + ((seatRow == null) ? 0 : seatRow.hashCode());
        result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
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
        Seat other = (Seat)obj;
        return (Objects.equals(seatId, other.seatId)) && (Objects.equals(seatNum, other.seatNum)) 
                &&(Objects.equals(seatRow, other.seatRow)) && (Objects.equals(seatHall, other.seatHall))
                && (Objects.equals(sessions, other.sessions));
    }
    
    
    public static void main(String[] args){
       //TODO
    }
    

}
