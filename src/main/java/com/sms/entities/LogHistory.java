package com.sms.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLog;
    private String operation;
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Account loggedUser;


    public LogHistory() {
        super();
    }

    public LogHistory(String operation, Date date, Account loggedUser) {
        super();
        this.operation = operation;
        this.date = date;
        this.loggedUser = loggedUser;
    }

    public long getIdLog() {
        return idLog;
    }

    public void setIdLog(long idLog) {
        this.idLog = idLog;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Account loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public String toString() {
        return "LogHistory [idLog=" + idLog + ", operation=" + operation + ", date=" + date + ", loggedUser="
                + loggedUser + "]";
    }


}
