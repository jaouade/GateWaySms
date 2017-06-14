package com.sms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class SmsTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSmsTemplate;
    private String name;
    private String smsTemplate;
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private Account account;


    public SmsTemplate() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SmsTemplate(String smsTemplate, Account account) {
        super();
        this.smsTemplate = smsTemplate;
        this.account = account;
    }

    public long getIdSmsTemplate() {
        return idSmsTemplate;
    }

    public void setIdSmsTemplate(long idSmsTemplate) {
        this.idSmsTemplate = idSmsTemplate;
    }

    public String getSmsTemplate() {
        return smsTemplate;
    }

    public void setSmsTemplate(String smsTemplate) {
        this.smsTemplate = smsTemplate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "SmsTemplate [idSmsTemplate=" + idSmsTemplate + ", smsTemplate=" + smsTemplate + ", account=" + account
                + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
