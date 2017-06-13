package com.sms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSimCard;
    private String simNumber;
    private Date activationDate;
    private String operator;
    private int creditSms;
    private int treshold;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "simCard")
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private List<RechargeSim> recharges;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "simCard")
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private List<Sms> listSms;

    public SimCard() {
        super();
        // TODO Auto-generated constructor stub
    }


    public SimCard(String simNumber, Date activationDate, String operator, int creditSms, int treshold,
                   List<RechargeSim> recharges, List<Sms> listSms) {
        super();
        this.simNumber = simNumber;
        this.activationDate = activationDate;
        this.operator = operator;
        this.creditSms = creditSms;
        this.treshold = treshold;
        this.recharges = recharges;
        this.listSms = listSms;
    }


    public SimCard(String simNumber, Date activationDate, String operator, int creditSms, int treshold) {
        super();
        this.simNumber = simNumber;
        this.activationDate = activationDate;
        this.operator = operator;
        this.creditSms = creditSms;
        this.treshold = treshold;

    }

    public long getIdSimCard() {
        return idSimCard;
    }

    public void setIdSimCard(long idSimCard) {
        this.idSimCard = idSimCard;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getCreditSms() {
        return creditSms;
    }

    public void setCreditSms(int creditSms) {
        this.creditSms = creditSms;
    }

    public int getTreshold() {
        return treshold;
    }

    public void setTreshold(int treshold) {
        this.treshold = treshold;
    }

    @JsonIgnore
    public List<RechargeSim> getRecharges() {
        return recharges;
    }

    @JsonProperty
    public void setRecharges(List<RechargeSim> recharges) {
        this.recharges = recharges;
    }


}
