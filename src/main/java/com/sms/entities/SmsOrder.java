package com.sms.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class SmsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSmsOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Account account;
    private int smsRange;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private SmsPrice smsPrice;
    private double tva;
    private double totalTtc;
    private Date orderDate;
    private String status;
    public SmsOrder() {

    }

    public SmsOrder(Account account, int smsRange, int quantity, SmsPrice smsPrice, double unitPrice, double tva,
                    double totalTtc, Date orderDate, String status) {
        super();
        this.account = account;
        this.smsRange = smsRange;
        this.quantity = quantity;
        this.smsPrice = smsPrice;
        this.tva = tva;
        this.totalTtc = totalTtc;
        this.orderDate = orderDate;
        this.status = status;
    }

    public SmsPrice getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(SmsPrice smsPrice) {
        this.smsPrice = smsPrice;
    }

    public long getIdSmsOrder() {
        return idSmsOrder;
    }

    public void setIdSmsOrder(long idSmsOrder) {
        this.idSmsOrder = idSmsOrder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getSmsRange() {
        return smsRange;
    }

    public void setSmsRange(int smsRange) {
        this.smsRange = smsRange;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(double totalTtc) {
        this.totalTtc = totalTtc;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    @Override
    public String toString() {
        return "SmsOrder [idSmsOrder=" + idSmsOrder + ", account=" + account + ", smsRange=" + smsRange + ", quantity="
                + quantity + ",  tva=" + tva + ", totalTtc=" + totalTtc + ", orderDate="
                + orderDate + ", status=" + status + "]";
    }


}