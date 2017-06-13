package com.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCredential;
    @Column(unique = true)
    private String login;
    private String password;
    private boolean enabled;
    private String encrypted;
    private String role;

    public Credential() {

    }

    public Credential(String login, String password,  String role) {
        super();
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public long getIdCredential() {
        return idCredential;
    }

    public void setIdCredential(long idCredential) {
        this.idCredential = idCredential;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void  setEnabled(boolean enab) {
         enabled =enab;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Credential [idCredential=" + idCredential + ", login=" + login + ", password=" + password + ", enabled="
                + enabled + ", encrypted=" + encrypted + ", role=" + role + "]";
    }

}
