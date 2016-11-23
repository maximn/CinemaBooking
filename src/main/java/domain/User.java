package domain;

import java.util.Objects;

/**
 * User represents a notation with the information about User in the cinema's booking system.
 * @author Artem Meleshko
 * @version 1.0 2016
 */

public class User {
    private Integer id;
    private String userName;
    private String userEmail;
    private String userRole;
    
    /**
     * Constructs and Initializes User.
     * @param id is an Integer User's id.
     * @param userName is a String notation with the User's name.
     * @param userEmail is a String notation with the User's email.
     * @param userRole is a String notation with the User's role.
     */
    
    public User(Integer id, String userName, String userEmail, String userRole){
        this.id=id;
        this.userName=userName;
        this.userEmail=userEmail;
        this.userRole=userRole;
    }
    
    /**
     * Constructs and initialized Film object with the empty fields.
     */
    
    public User(){
        this(null, null, null, null);
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName is a String notation with the User's name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail is a String notation with the User's email to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole is a String notation with the User's role to set.
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ",userName=" + userName + ", userEmail=" + userEmail + ", userRole=" + userRole + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        return (Objects.equals(id, other.id)) && (Objects.equals(userName, other.userName)) && (Objects.equals(userEmail, other.userEmail)) 
                && (Objects.equals(userRole, other.userRole));
    }
    
    
}
