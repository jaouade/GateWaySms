package com.sms.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String token;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account whoCreateIt;

    public Token(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public Token() {
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @Transient
    private Client client;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getWhoCreateIt() {
        return whoCreateIt;
    }

    public void setWhoCreateIt(Account whoCreateIt) {
        this.whoCreateIt = whoCreateIt;
    }

    @Override
    public String toString() {
        return "Token [id=" + id + ", token=" + token + ", email=" + email + "]";
    }


}
