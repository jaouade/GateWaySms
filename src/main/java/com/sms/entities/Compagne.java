package com.sms.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Compagne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompagne;
    private String compagneDesignation;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
    private Date sendDate;
    private String message;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> numbers;
    private long date;

    public Compagne() {

    }

    public Compagne(String compagneDesignation, Account account) {
        super();
        this.compagneDesignation = compagneDesignation;
        this.account = account;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
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

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public long getIdCompagne() {
        return idCompagne;
    }

    public void setIdCompagne(long idCompagne) {
        this.idCompagne = idCompagne;
    }

    public String getCompagneDesignation() {
        return compagneDesignation;
    }

    public void setCompagneDesignation(String compagneDesignation) {
        this.compagneDesignation = compagneDesignation;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Compagne [idCompagne=" + idCompagne + ", compagneDesignation=" + compagneDesignation + ", account=" + account + "]";
    }

}
