package com.sms.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPhone;
    private String clientName;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Compagne compagne;
    private String PhoneNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    private PhoneBook phoneBook;
    @ManyToMany(mappedBy = "receivers")
    private List<Sms> smsList;
    @JsonIgnore
    public List<Sms> getSms() {
        return smsList;
    }
    @JsonProperty
    public void setSms(List<Sms> smsList) {
        this.smsList = smsList;
    }

    public PhoneNumber() {

    }

    public PhoneNumber(String clientName, String phoneNumber, PhoneBook phoneBook) {
        super();
        this.clientName = clientName;
        PhoneNumber = phoneNumber;
        this.phoneBook = phoneBook;
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
