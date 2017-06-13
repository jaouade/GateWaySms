package com.sms.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCity;
    private String cityName;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Country country;

    public City() {

    }

    public City(String cityName, Country country) {
        super();
        this.cityName = cityName;
        this.country = country;
    }

    public City(String cityName) {
        super();
        this.cityName = cityName;
    }

    public long getIdCity() {
        return idCity;
    }

    public void setIdCity(long idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City [idCity=" + idCity + ", cityName=" + cityName + ", country=" + country + "]";
    }

    @PreRemove
    public void test() {
        this.setCountry(null);
    }

}
