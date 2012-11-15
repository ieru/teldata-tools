package com.uah.dto.modle;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class ParticipantMoodleDTO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String city;
    private String country;
    private String language;

    
    /**************************************************************************
    *                              getters & setters
    **************************************************************************/
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
}
