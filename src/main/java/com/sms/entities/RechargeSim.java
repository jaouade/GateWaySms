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
public class RechargeSim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRechargeSim;
    private double mentantRecharge;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private SimCard simCard;
    private int etat;
    private Date dateRecharge;
    private int equivalentSms;


    public long getIdRechargeSim() {
        return idRechargeSim;
    }

    public void setIdRechargeSim(long idRechargeSim) {
        this.idRechargeSim = idRechargeSim;
    }

    public double getMentantRecharge() {
        return mentantRecharge;
    }

    public void setMentantRecharge(double mentantRecharge) {
        this.mentantRecharge = mentantRecharge;
    }

    public SimCard getSimCard() {
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateRecharge() {
        return dateRecharge;
    }

    public void setDateRecharge(Date dateRecharge) {
        this.dateRecharge = dateRecharge;
    }

    public int getEquivalentSms() {
        return equivalentSms;
    }

    public void setEquivalentSms(int equivalentSms) {
        this.equivalentSms = equivalentSms;
    }

    @Override
    public String toString() {
        return "RechargeSim [idRechargeSim=" + idRechargeSim + ", mentantRecharge=" + mentantRecharge + ", simCard="
                + simCard + ", etat=" + etat + ", dateRecharge=" + dateRecharge + ", equivalentSms=" + equivalentSms
                + "]";
    }


}
