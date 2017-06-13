package com.sms.entities;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    private String corp_name;
    private String name;
    private String postal_code;
    private String email;
    private String adresse;
    private String phone;
    private String fax;
    private double total_credit;
    private double remaining_credit;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private City city;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Sector sector;

    public Client() {

    }

    public Client(String corp_name, String name, String postal_code, String email, String adresse, String phone,
                  String fax, int total_credit, int remaining_credit, City city, Sector sector) {
        super();
        this.corp_name = corp_name;
        this.name = name;
        this.postal_code = postal_code;
        this.email = email;
        this.adresse = adresse;
        this.phone = phone;
        this.fax = fax;
        this.total_credit = total_credit;
        this.remaining_credit = remaining_credit;
        this.city = city;
        this.sector = sector;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getCorp_name() {
        return corp_name;
    }

    public void setCorp_name(String corp_name) {
        this.corp_name = corp_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public double getTotal_credit() {
        return total_credit;
    }

    public void setTotal_credit(double total_credit) {
        this.total_credit = total_credit;
    }

    public double getRemaining_credit() {
        return remaining_credit;
    }

    public void setRemaining_credit(double remaining_credit) {
        this.remaining_credit = remaining_credit;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Client [idClient=" + idClient + ", corp_name=" + corp_name + ", name=" + name + ", postal_code="
                + postal_code + ", email=" + email + ", adresse=" + adresse + ", phone=" + phone + ", fax=" + fax
                + ", total_credit=" + total_credit + ", remaining_credit=" + remaining_credit +
                ", city=" + city + ", sector=" + sector + "]";
    }

}
