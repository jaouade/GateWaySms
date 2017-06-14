package com.sms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccount;
    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Client client;
    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Credential credential;
    @OneToOne(fetch = FetchType.EAGER)
    private SimCard simCard;
    private int smsCredit;
    private int threshold;

    @ManyToMany(mappedBy = "accounts")
    private List<Pack> packs;
    private Boolean state;
    @OneToMany(fetch = LAZY, mappedBy = "account")
    @JsonIgnore
    private List<PhoneBook> phoneBooks;
    @OneToMany(fetch = LAZY, mappedBy = "account")
    @JsonIgnore
    private List<Sms> smsList;
    @OneToMany(fetch = LAZY, mappedBy = "account")
    @JsonIgnore
    private List<SmsOrder> smsOrders;
    @OneToMany(fetch = LAZY, mappedBy = "loggedUser")
    @JsonIgnore
    private List<LogHistory> logHistories;

    public Account() {

    }

    public Account(Client client, Credential credential, int smsCredit, int threshold) {

        this.client = client;
        this.credential = credential;
        this.smsCredit = smsCredit;
        this.threshold = threshold;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<Sms> getSmsList() {
        return smsList;
    }

    public void setSmsList(List<Sms> smsList) {
        this.smsList = smsList;
    }

    public SimCard getSimCard() {
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

    public List<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void setPhoneBooks(List<PhoneBook> phoneBooks) {
        this.phoneBooks = phoneBooks;
    }

    public List<LogHistory> getLogHistories() {
        return logHistories;
    }

    public void setLogHistories(List<LogHistory> logHistories) {
        this.logHistories = logHistories;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public int getSmsCredit() {
        return smsCredit;
    }

    public void setSmsCredit(int smsCredit) {
        this.smsCredit = smsCredit;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }


    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", client=" + client +
                ", credential=" + credential +
                ", simCard=" + simCard +
                ", smsCredit=" + smsCredit +
                ", treshold=" + threshold +
                '}';
    }


}
