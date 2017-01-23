package domain;

import java.util.Objects;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Session represents notation with the information about the sessions in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Sessions {
    private Integer sessionId;
    private DateTime sessionTime;
    private Film sessionFilm;
    
    /**
     * Constructs and initialized Session.
     * @param sessionTime is a date and time of the film's session.
     * @param sessionFilmId is a film's id. 
     */
    
    public Sessions(Integer sessionId, DateTime sessionTime, Film sessionFilm){
        this.sessionId=sessionId;
        this.sessionTime=sessionTime;
        this.sessionFilm=sessionFilm;
    }
    
    /**
     * Constructs and initialized Session object with the empty fields.
     */
    
    public Sessions(){
        this(null, null, null);
    }
    
    /**
     * @return the sessionId
     */
    public Integer getSessionsId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionsId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the sessionTime
     */
    public DateTime getSessionsTime() {
        return sessionTime;
    }

    /**
     * @param sessionTime the sessionTime to set
     */
    public void setSessionsTime(DateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    /**
     * @return the sessionFilm
     */
    public Film getSessionsFilm() {
        return sessionFilm;
    }

    /**
     * @param sessionFilm the sessionFilm to set
     */
    public void setSessionsFilm(Film sessionFilm) {
        this.sessionFilm = sessionFilm;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");
        return "Session [sessionId=" + sessionId + "sessionTime=" + fmt.print(sessionTime) + ", sessionFilm=" + sessionFilm + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime * result + ((sessionTime == null) ? 0 : sessionTime.hashCode());
        result = prime * result + ((sessionFilm == null) ? 0 : sessionFilm.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Sessions))
            return false;
        Sessions other = (Sessions) obj;
        return (Objects.equals(sessionId, other.sessionId)) && (Objects.equals(sessionTime, other.sessionTime)) 
                && (Objects.equals(sessionFilm, other.sessionFilm));
    }
}
