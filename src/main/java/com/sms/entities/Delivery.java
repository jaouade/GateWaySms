package com.sms.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDelivery;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Account account;
    private Date date;
    private int totalSms;


    public Delivery() {

    }

    public Delivery(Account account, Date date, int totalSms) {
        super();
        this.account = account;
        this.date = date;
        this.totalSms = totalSms;
    }

    public long getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(long idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalSms() {
        return totalSms;
    }

    public void setTotalSms(int totalSms) {
        this.totalSms = totalSms;
    }

    @Override
    public String toString() {
        return "Delivery [idDelivery=" + idDelivery + ", account=" + account + ", date=" + date + ", totalSms="
                + totalSms + "]";
    }

}
