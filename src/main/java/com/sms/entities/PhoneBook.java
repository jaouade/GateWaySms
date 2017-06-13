package com.sms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPhoneBook;
    private String bookName;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Account account;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneBook")
    @JsonIgnore
    private List<PhoneNumber> phoneNumbers;


    public PhoneBook() {

    }

    public PhoneBook(String bookName, Account account) {

        this.bookName = bookName;
        this.account = account;
    }

    public long getIdPhoneBook() {
        return idPhoneBook;
    }

    public void setIdPhoneBook(long idPhoneBook) {
        this.idPhoneBook = idPhoneBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }




}
