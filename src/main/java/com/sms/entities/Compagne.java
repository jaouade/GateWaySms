package com.sms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Compagne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompagne;
    private String compagneDesignation;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
    private Date sendDate;
    @OneToOne(fetch = FetchType.EAGER)
    private Sms message;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "compagne")
    private List<PhoneNumber> numbers;
    public Compagne() {

    }

    public Compagne(String compagneDesignation, Account account) {
        super();
        this.compagneDesignation = compagneDesignation;
        this.account = account;
    }

    public Sms getMessage() {
        return message;
    }

    public void setMessage(Sms message) {
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
