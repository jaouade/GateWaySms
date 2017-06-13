package com.sms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSector;
    private String sectorName;
    private String description;


    public Sector() {

    }

    public Sector(String sectorName, String description) {
        super();
        this.sectorName = sectorName;
        this.description = description;
    }

    public long getIdSector() {
        return idSector;
    }

    public void setIdSector(long idSector) {
        this.idSector = idSector;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sector [idSector=" + idSector + ", sectorName=" + sectorName + ", description=" + description + "]";
    }
}
