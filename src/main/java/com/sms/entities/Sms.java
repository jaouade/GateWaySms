package com.sms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSms;
    @ManyToOne(fetch = EAGER)
    private Account account;
    @ManyToOne(fetch = EAGER)
    @Cascade(SAVE_UPDATE)
    private Delivery delivery;
    @ManyToMany(cascade = CascadeType.ALL)

    private List<PhoneNumber> receivers;
    @ManyToOne(fetch = LAZY)
    @Cascade(SAVE_UPDATE)
    private SimCard simCard;
    private int nbMessages;
    @Column(length=9999)
    private String message;
    private Date sendDate;
    @Transient
    private Long date;
    private String status;

    public Sms() {

    }

    public Sms(Account account, Delivery delivery, PhoneNumber phoneNumber, SimCard simCard,
               String message, Date sendDate, String status) {
        super();
        this.account = account;
        this.delivery = delivery;
        this.receivers.add(phoneNumber);

        this.simCard = simCard;
        this.message = message;
        this.sendDate = sendDate;
        this.status = status;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public long getIdSms() {
        return idSms;
    }

    public void setIdSms(long idSms) {
        this.idSms = idSms;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @JsonIgnore
    public List<PhoneNumber> getReceivers() {
        return receivers;
    }
    @JsonProperty
    public void setReceivers(List<PhoneNumber> receivers) {
        this.receivers = receivers;
    }

    public SimCard getSimCard() {
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public int getNbMessages() {
        return nbMessages;
    }

    public void setNbMessages(int nbMessages) {
        this.nbMessages = nbMessages;
    }


}
