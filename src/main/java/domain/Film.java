package domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Film represents a notation with information about the film in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 *
 */
public class Film {
    private Integer filmId;
    private String filmName;
    private Integer filmYear;
    private String filmLength;
    private String filmDescription;
    private Set<Integer> sessionIdSet = new LinkedHashSet<Integer>();
    
    /**
     * Constructs and initializes Film.
     * @param filmId is an Integer film's id.
     * @param filmName is a String notation with the film's name. 
     * @param filmYear is an Integer notation with the film's production year. 
     * @param filmLength is a String notation with the film's length.
     * @param filmDescription is a String notation with the film's description.
     */
    
    Film(Integer filmId, String filmName, Integer filmYear, String filmLength, String filmDescription){
        this.filmId=filmId;
        this.filmName=filmName;
        this.filmYear=filmYear;
        this.filmLength=filmLength;
        this.filmDescription=filmDescription;        
    }
    
    /**
     * Constructs and initialized Film object with the empty fields.
     */
    
    public Film(){
        this(null, null, null, null, null);
    }
        
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
        result = prime * result + ((filmDescription == null) ? 0 : filmDescription.hashCode());
        result = prime * result + ((filmLength == null) ? 0 : filmLength.hashCode());
        result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
        result = prime * result + ((filmYear == null) ? 0 : filmYear.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object s) {
        if (s == this)
            return true;
        if (!(s instanceof Film))
            return false;
        Film other = (Film) s;
        return (Objects.equals(filmId, other.filmId)) && (Objects.equals(filmName, other.filmName)) && (Objects.equals(filmYear, other.filmYear)) 
                && (Objects.equals(filmLength, other.filmLength)) && (Objects.equals(filmDescription, other.filmDescription));
        
    }


    /**
     * Returns a string representation of the object Films.
     */
    @Override
    public String toString() {
        return "Film [filmId="+ filmId +", filmName=" + filmName + ", filmYear=" + filmYear + ", filmLength=" + filmLength
                + ", filmDescription=" + filmDescription + "]";
    }

    /**
     * @return the sessionIdSet
     */
    public Set<Integer> getSessionIdSet() {
        return sessionIdSet;
    }

    /**
     * @param sessionIdSet is the Set(Integer) Collection to set
     */
    public void setSessionIdSet(Set<Integer> sessionIdSet) {
        this.sessionIdSet = sessionIdSet;
    }
    
    /**
     * @param sessionIdSet is the Set(Integer) Collection to set
     * @param itemSessionIdSet is the Integer session's id.
     */
    public void setItemSessionIdSet(Integer itemSessionIdSet) {
        this.sessionIdSet.add(itemSessionIdSet);
    }

    /**
     * @return the filmId
     */
    public Integer getFilmId() {
        return filmId;
    }

    /**
     * @param filmId the filmId to set
     */
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    /**
     * @return the filmName
     */
    public String getFilmName() {
        return filmName;
    }

    /**
     * @param filmName is a String notation with the film's name to set.
     */
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    /**
     * @return the filmYear
     */
    public Integer getFilmYear() {
        return filmYear;
    }

    /**
     * @param filmYear is an Integer notation with the film's production year to set.
     */
    public void setFilmYear(Integer filmYear) {
        this.filmYear = filmYear;
    }

    /**
     * @return the filmLength
     */
    public String getFilmLength() {
        return filmLength;
    }

    /**
     * @param filmLength is a String notation with the film's length to set.
     */
    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    /**
     * @return the filmDescription
     */
    public String getFilmDescription() {
        return filmDescription;
    }

    /**
     * @param filmDescription is a String notation with the film's description to set.
     */
    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    

}
