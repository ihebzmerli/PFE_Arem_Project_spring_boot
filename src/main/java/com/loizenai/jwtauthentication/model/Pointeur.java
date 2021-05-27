package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pointeur {
    private long id;
    private String code;
    private String raison;
    private String fonction;
    private String zone;
    private String zone1;
    private String numBon;
    private String heure;
    private String heure1;

    public Pointeur(String code, String raison, String fonction, String zone, String zone1, String numBon, String heure, String heure1) {
        this.code = code;
        this.raison = raison;
        this.fonction = fonction;
        this.zone = zone;
        this.zone1 = zone1;
        this.numBon = numBon;
        this.heure = heure;
        this.heure1 = heure1;
    }

    public Pointeur() {

    }

    
    public Pointeur(long id, String code, String raison, String fonction, String zone, String zone1, String numBon,
            String heure, String heure1) {
        this.id = id;
        this.code = code;
        this.raison = raison;
        this.fonction = fonction;
        this.zone = zone;
        this.zone1 = zone1;
        this.numBon = numBon;
        this.heure = heure;
        this.heure1 = heure1;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Basic
    @Column(name = "FONCTION")
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Basic
    @Column(name = "ZONE")
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Basic
    @Column(name = "ZONE1")
    public String getZone1() {
        return zone1;
    }

    public void setZone1(String zone1) {
        this.zone1 = zone1;
    }

    @Basic
    @Column(name = "NUM_BON")
    public String getNumBon() {
        return numBon;
    }

    public void setNumBon(String numBon) {
        this.numBon = numBon;
    }

    @Basic
    @Column(name = "HEURE")
    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Basic
    @Column(name = "HEURE1")
    public String getHeure1() {
        return heure1;
    }

    public void setHeure1(String heure1) {
        this.heure1 = heure1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointeur pointeur = (Pointeur) o;
        return id == pointeur.id &&
                Objects.equals(code, pointeur.code) &&
                Objects.equals(raison, pointeur.raison) &&
                Objects.equals(fonction, pointeur.fonction) &&
                Objects.equals(zone, pointeur.zone) &&
                Objects.equals(zone1, pointeur.zone1) &&
                Objects.equals(numBon, pointeur.numBon) &&
                Objects.equals(heure, pointeur.heure) &&
                Objects.equals(heure1, pointeur.heure1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, raison, fonction, zone, zone1, numBon, heure, heure1);
    }

    @Override
    public String toString() {
        return "Pointeur{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", raison='" + raison + '\'' +
                ", fonction='" + fonction + '\'' +
                ", zone='" + zone + '\'' +
                ", zone1='" + zone1 + '\'' +
                ", numBon='" + numBon + '\'' +
                ", heure='" + heure + '\'' +
                ", heure1='" + heure1 + '\'' +
                '}';
    }
}
