package domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Session represents notation with the information about the sessions in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class Sessions {
    private Integer sessionsId = null;
    private Calendar sessionsTime;
    private Film sessionsFilm;
    private Set<Seat> sessionsSeats = new HashSet<Seat>();
    
    /**
     * Constructs and initialized Session.
     * @param sessionTime is a date and time of the film's session.
     * @param sessionFilmId is a film's id. 
     */
    
    public Sessions(Integer sessionsId, Calendar sessionsTime, Film sessionsFilm, Set<Seat> sessionsSeats){
        this.sessionsId=sessionsId;
        this.sessionsTime=sessionsTime;
        this.sessionsFilm=sessionsFilm;
        this.sessionsSeats=sessionsSeats;
    }
    
    /**
     * Constructs and initialized Session object with the empty fields.
     */
    
    public Sessions(){}
    
    /**
     * @return the sessionsId
     */
    public Integer getSessionsId() {
        return sessionsId;
    }

    /**
     * @param sessionsId the sessionsId to set
     */
    public void setSessionsId(Integer sessionsId) {
        this.sessionsId = sessionsId;
    }

    /**
     * @return the sessionsTime
     */
    public Calendar getSessionsTime() {
        return sessionsTime;
    }

    /**
     * @param sessionsTime the sessionsTime to set
     */
    public void setSessionsTime(Calendar sessionsTime) {
        this.sessionsTime = sessionsTime;
    }

    /**
     * @return the sessionsFilm
     */
    public Film getSessionsFilm() {
        return sessionsFilm;
    }

    /**
     * @param sessionsFilm the sessionsFilm to set
     */
    public void setSessionsFilm(Film sessionsFilm) {
        this.sessionsFilm = sessionsFilm;
    }
    
    /**
     * @return the sessionsSeats
     */
    public Set<Seat> getSessionsSeats() {
        return sessionsSeats;
    }

    /**
     * @param sessionsSeats the sessionsSeats to set
     */
    public void setSessionsSeats(Set<Seat> sessionsSeats) {
        this.sessionsSeats = sessionsSeats;
    }
    
    public void addSeat(Seat seat) {
        this.sessionsSeats.add(seat);
    }

//    /* (non-Javadoc)
//     * @see java.lang.Object#toString()
//     */
//    @Override
//    public String toString() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
//        if (sessionsId == null){
//            return "Sessions [sessionsTime=" + sdf.format(sessionsTime.getTime()) + ", sessionsFilm=" + sessionsFilm + "]";
//        } else
//        return "Sessions [sessionsId=" + sessionsId + "sessionsTime=" + sdf.format(sessionsTime.getTime()) + ", sessionsFilm=" + sessionsFilm + "]";
//    }
    //sdf.format(sessionsTime.getTime())

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((sessionsId == null) ? 0 : sessionsId.hashCode());
        result = prime * result + ((sessionsTime == null) ? 0 : sessionsTime.hashCode());
        result = prime * result + ((sessionsFilm == null) ? 0 : sessionsFilm.hashCode());
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
        return (Objects.equals(sessionsId, other.sessionsId)) && (Objects.equals(sessionsTime, other.sessionsTime)) 
                && (Objects.equals(sessionsFilm, other.sessionsFilm));
    }
    
    public static void main(String[] args) {
        Sessions ses = new Sessions();
        //ses.setSessionsId(null);
       // ses.setSessionsTime("10:30");
        System.out.println(ses);
        
//        Set<Sessions> sessionsSet = new HashSet<Sessions>();
//        sessionsSet.add(ses);
//        
//        
//        Film filmNew = new Film();
//        filmNew.setFilmName("Shadow");
//        filmNew.setFilmYear((Integer)1992);
//        filmNew.setFilmLength("02:20");
//        filmNew.setFilmDescription("Cool film");
//        filmNew.setSessionsSet(sessionsSet);
//        
//        ses.setSessionsFilm(filmNew);
//        //ses.setSessionsFilm(null);
//        System.out.println(ses);
    }
}
