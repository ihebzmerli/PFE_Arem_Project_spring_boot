package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Vehicule {
    
    @Id
    @Column(name = "MATRICULE")
    private String matricule;

    private Long matAgent;

    private String marque;
    private String modele;
    private String couleur;
    private Timestamp dt1Mc;
    private Timestamp dtAcq;
    private BigDecimal pattc;
    private String ess;
    private Timestamp dtFAss;
    private Timestamp dtFVisit;
    private BigDecimal kmCour;
    private BigDecimal drKmVida;
    private BigDecimal drKmCh;
    private String observation;
    private BigDecimal tonnage;
    
    private Timestamp dt1Mc2;

    //FK_KEYS***********************
 

    //END FK_KEYS************************

    
    public Vehicule() {
    }
    
    public Vehicule(String matricule, Long matAgent, String marque, String modele, String couleur, Timestamp dt1Mc,
            Timestamp dtAcq, BigDecimal pattc, String ess, Timestamp dtFAss, Timestamp dtFVisit, BigDecimal kmCour,
            BigDecimal drKmVida, BigDecimal drKmCh, String observation, BigDecimal tonnage, Timestamp dt1Mc2) {
        this.matricule = matricule;
        this.matAgent = matAgent;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.dt1Mc = dt1Mc;
        this.dtAcq = dtAcq;
        this.pattc = pattc;
        this.ess = ess;
        this.dtFAss = dtFAss;
        this.dtFVisit = dtFVisit;
        this.kmCour = kmCour;
        this.drKmVida = drKmVida;
        this.drKmCh = drKmCh;
        this.observation = observation;
        this.tonnage = tonnage;
        this.dt1Mc2 = dt1Mc2;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Basic
    @Column(name = "MAT_AGENT")
    public Long getMatAgent() {
        return matAgent;
    }

    public void setMatAgent(Long matAgent) {
        this.matAgent = matAgent;
    }

    @Basic
    @Column(name = "MARQUE")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "MODELE")
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "COULEUR")
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Basic
    @Column(name = "DT_1_MC")
    public Timestamp getDt1Mc() {
        return dt1Mc;
    }

    public void setDt1Mc(Timestamp dt1Mc) {
        this.dt1Mc = dt1Mc;
    }

    @Basic
    @Column(name = "DT_ACQ")
    public Timestamp getDtAcq() {
        return dtAcq;
    }

    public void setDtAcq(Timestamp dtAcq) {
        this.dtAcq = dtAcq;
    }

    @Basic
    @Column(name = "PATTC")
    public BigDecimal getPattc() {
        return pattc;
    }

    public void setPattc(BigDecimal pattc) {
        this.pattc = pattc;
    }

    @Basic
    @Column(name = "ESS")
    public String getEss() {
        return ess;
    }

    public void setEss(String ess) {
        this.ess = ess;
    }

    @Basic
    @Column(name = "DT_F_ASS")
    public Timestamp getDtFAss() {
        return dtFAss;
    }

    public void setDtFAss(Timestamp dtFAss) {
        this.dtFAss = dtFAss;
    }

    @Basic
    @Column(name = "DT_F_VISIT")
    public Timestamp getDtFVisit() {
        return dtFVisit;
    }

    public void setDtFVisit(Timestamp dtFVisit) {
        this.dtFVisit = dtFVisit;
    }

    @Basic
    @Column(name = "KM_COUR")
    public BigDecimal getKmCour() {
        return kmCour;
    }

    public void setKmCour(BigDecimal kmCour) {
        this.kmCour = kmCour;
    }

    @Basic
    @Column(name = "DR_KM_VIDA")
    public BigDecimal getDrKmVida() {
        return drKmVida;
    }

    public void setDrKmVida(BigDecimal drKmVida) {
        this.drKmVida = drKmVida;
    }

    @Basic
    @Column(name = "DR_KM_CH")
    public BigDecimal getDrKmCh() {
        return drKmCh;
    }

    public void setDrKmCh(BigDecimal drKmCh) {
        this.drKmCh = drKmCh;
    }

    @Basic
    @Column(name = "OBSERVATION")
    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Basic
    @Column(name = "TONNAGE")
    public BigDecimal getTonnage() {
        return tonnage;
    }

    public void setTonnage(BigDecimal tonnage) {
        this.tonnage = tonnage;
    }

    @Basic
    @Column(name = "dt1mc2")
    public Timestamp getDt1Mc2() {
        return dt1Mc2;
    }

    public void setDt1Mc2(Timestamp dt1Mc2) {
        this.dt1Mc2 = dt1Mc2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return  Objects.equals(matricule, vehicule.matricule) &&
                Objects.equals(matAgent, vehicule.matAgent) &&
                Objects.equals(marque, vehicule.marque) &&
                Objects.equals(modele, vehicule.modele) &&
                Objects.equals(couleur, vehicule.couleur) &&
                Objects.equals(dt1Mc, vehicule.dt1Mc) &&
                Objects.equals(dtAcq, vehicule.dtAcq) &&
                Objects.equals(pattc, vehicule.pattc) &&
                Objects.equals(ess, vehicule.ess) &&
                Objects.equals(dtFAss, vehicule.dtFAss) &&
                Objects.equals(dtFVisit, vehicule.dtFVisit) &&
                Objects.equals(kmCour, vehicule.kmCour) &&
                Objects.equals(drKmVida, vehicule.drKmVida) &&
                Objects.equals(drKmCh, vehicule.drKmCh) &&
                Objects.equals(observation, vehicule.observation) &&
                Objects.equals(tonnage, vehicule.tonnage) &&
                Objects.equals(dt1Mc2, vehicule.dt1Mc2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, matAgent, marque, modele, couleur, dt1Mc, dtAcq, pattc, ess, dtFAss, dtFVisit, kmCour, drKmVida, drKmCh, observation, tonnage, dt1Mc2);
    }
}
