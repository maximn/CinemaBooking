package domain;

import java.util.Objects;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Session represents notation with the information about the sessions in the cinema booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Session {
    DateTime sessionTime;
    
    /**
     * Constructs and initialized Session.
     * @param sessionTime is a date and time of the film's session.
     */
    
    Session(DateTime sessionTime){
        this.sessionTime=sessionTime;
    }
    
    /**
     * Constructs and initialized Session object with the empty fields.
     */
    
    public Session(){
        this(null);
    }

    /**
     * @return the sessionTime
     */
    public DateTime getSessionTime() {
        return sessionTime;
    }

    /**
     * @param sessionTime is a date and time of the film's session to set.
     */
    public void setSessionTime(DateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return "Session [sessionTime=" + fmt.print(sessionTime) + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((sessionTime == null) ? 0 : sessionTime.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Session))
            return false;
        Session other = (Session) obj;
        return (Objects.equals(sessionTime, other.sessionTime));
    }
    
    
    

}
