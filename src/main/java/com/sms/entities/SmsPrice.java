package com.sms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SmsPrice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSmsPrice;
    private int smsRange;
    private double unitPrice;
    private double tva;
    @OneToMany(mappedBy = "smsPrice", targetEntity = SmsOrder.class)
    @JsonIgnore
    private List<SmsOrder> smsOrders;

    public SmsPrice() {
        super();
        // TODO Auto-generated constructor stub
    }


    public SmsPrice(int smsRange, double unitPrice, double tva) {

        this.smsRange = smsRange;
        this.unitPrice = unitPrice;
        this.tva = tva;
    }

    public List<SmsOrder> getSmsOrders() {
        return smsOrders;
    }

    public void setSmsOrders(List<SmsOrder> smsOrders) {
        this.smsOrders = smsOrders;
    }

    public long getIdSmsPrice() {
        return idSmsPrice;
    }

    public void setIdSmsPrice(long idSmsPrice) {
        this.idSmsPrice = idSmsPrice;
    }

    public int getSmsRange() {
        return smsRange;
    }

    public void setSmsRange(int smsRange) {
        this.smsRange = smsRange;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    @Override
    public String toString() {
        return "SmsPrice [idSmsPrice=" + idSmsPrice + ", smsRange=" + smsRange + ", unitPrice=" + unitPrice + ", tva="
                + tva + "]";
    }

}
