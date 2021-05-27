package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "art_tir", schema = "seratest")
public class ArtTir {
    private long id;
    private String numTir;
    private String poste;
    private long codUser;
    private Integer qutStk;
    private Short qutCom;
    private String codArt;
    private BigDecimal remise;
    private BigDecimal tva;
    private BigDecimal prixUnit;
    private BigDecimal prixHt;
    private BigDecimal montRem;
    private BigDecimal prixUttc;
    private BigDecimal prixTtc;
    private Date date;

    public ArtTir(String poste, long codUser, Integer qutStk, Short qutCom, String codArt, BigDecimal remise, BigDecimal tva, BigDecimal prixUnit, BigDecimal prixHt, BigDecimal montRem, BigDecimal prixUttc, BigDecimal prixTtc, Date date) {
        this.poste = poste;
        this.codUser = codUser;
        this.qutStk = qutStk;
        this.qutCom = qutCom;
        this.codArt = codArt;
        this.remise = remise;
        this.tva = tva;
        this.prixUnit = prixUnit;
        this.prixHt = prixHt;
        this.montRem = montRem;
        this.prixUttc = prixUttc;
        this.prixTtc = prixTtc;
        this.date = date;
    }

    public ArtTir() {

    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUM_TIR")
    public String getNumTir() {
        return numTir;
    }

    public void setNumTir(String numTir) {
        this.numTir = numTir;
    }

    @Basic
    @Column(name = "POSTE")
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Basic
    @Column(name = "COD_USER")
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    @Basic
    @Column(name = "QUT_STK")
    public Integer getQutStk() {
        return qutStk;
    }

    public void setQutStk(Integer qutStk) {
        this.qutStk = qutStk;
    }

    @Basic
    @Column(name = "QUT_COM")
    public Short getQutCom() {
        return qutCom;
    }

    public void setQutCom(Short qutCom) {
        this.qutCom = qutCom;
    }

    @Basic
    @Column(name = "COD_ART")
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    @Basic
    @Column(name = "REMISE")
    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    @Basic
    @Column(name = "TVA")
    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
    }

    @Basic
    @Column(name = "PRIX_UNIT")
    public BigDecimal getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(BigDecimal prixUnit) {
        this.prixUnit = prixUnit;
    }

    @Basic
    @Column(name = "PRIX_HT")
    public BigDecimal getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(BigDecimal prixHt) {
        this.prixHt = prixHt;
    }

    @Basic
    @Column(name = "MONT_REM")
    public BigDecimal getMontRem() {
        return montRem;
    }

    public void setMontRem(BigDecimal montRem) {
        this.montRem = montRem;
    }

    @Basic
    @Column(name = "PRIX_UTTC")
    public BigDecimal getPrixUttc() {
        return prixUttc;
    }

    public void setPrixUttc(BigDecimal prixUttc) {
        this.prixUttc = prixUttc;
    }

    @Basic
    @Column(name = "PRIX_TTC")
    public BigDecimal getPrixTtc() {
        return prixTtc;
    }

    public void setPrixTtc(BigDecimal prixTtc) {
        this.prixTtc = prixTtc;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtTir artTir = (ArtTir) o;
        return id == artTir.id &&
                codUser == artTir.codUser &&
                Objects.equals(numTir, artTir.numTir) &&
                Objects.equals(poste, artTir.poste) &&
                Objects.equals(qutStk, artTir.qutStk) &&
                Objects.equals(qutCom, artTir.qutCom) &&
                Objects.equals(codArt, artTir.codArt) &&
                Objects.equals(remise, artTir.remise) &&
                Objects.equals(tva, artTir.tva) &&
                Objects.equals(prixUnit, artTir.prixUnit) &&
                Objects.equals(prixHt, artTir.prixHt) &&
                Objects.equals(montRem, artTir.montRem) &&
                Objects.equals(prixUttc, artTir.prixUttc) &&
                Objects.equals(prixTtc, artTir.prixTtc) &&
                Objects.equals(date, artTir.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numTir, poste, codUser, qutStk, qutCom, codArt, remise, tva, prixUnit, prixHt, montRem, prixUttc, prixTtc, date);
    }

    @Override
    public String toString() {
        return "ArtTir{" +
                "id=" + id +
                ", numTir='" + numTir + '\'' +
                ", poste='" + poste + '\'' +
                ", codUser=" + codUser +
                ", qutStk=" + qutStk +
                ", qutCom=" + qutCom +
                ", codArt='" + codArt + '\'' +
                ", remise=" + remise +
                ", tva=" + tva +
                ", prixUnit=" + prixUnit +
                ", prixHt=" + prixHt +
                ", montRem=" + montRem +
                ", prixUttc=" + prixUttc +
                ", prixTtc=" + prixTtc +
                ", date=" + date +
                '}';
    }
}
