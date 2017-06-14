package com.sms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPhone;
    private String clientName;
    @ManyToMany(mappedBy = "numbers")
    private List<Compagne> compagnes;
    private String PhoneNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    private PhoneBook phoneBook;
    @ManyToMany(mappedBy = "receivers")
    private List<Sms> smsList;
    public PhoneNumber() {

    }
    public PhoneNumber(String clientName, String phoneNumber, PhoneBook phoneBook) {
        super();
        this.clientName = clientName;
        PhoneNumber = phoneNumber;
        this.phoneBook = phoneBook;
    }

    @JsonIgnore
    public List<Compagne> getCompagnes() {
        return compagnes;
    }

    @JsonProperty
    public void setCompagnes(List<Compagne> compagnes) {
        this.compagnes = compagnes;
    }

    @JsonIgnore
    public List<Sms> getSms() {
        return smsList;
    }

    @JsonProperty
    public void setSms(List<Sms> smsList) {
        this.smsList = smsList;
    }

    public long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(long idPhone) {
        this.idPhone = idPhone;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }




}
