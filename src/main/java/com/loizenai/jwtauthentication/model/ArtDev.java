package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "art_dev", schema = "testbd")
public class ArtDev {
    private long id;
    private String numDev;
    private Date datDev;
    private String codArt;
    private Short qutDev;
    private BigDecimal prixHt;
    private BigDecimal remise;
    private Byte tva;
    private BigDecimal totHt;
    private long codFrs;

    public ArtDev(Date datDev, String codArt, Short qutDev, BigDecimal prixHt, BigDecimal remise, Byte tva, BigDecimal totHt, long codFrs) {
        this.datDev = datDev;
        this.codArt = codArt;
        this.qutDev = qutDev;
        this.prixHt = prixHt;
        this.remise = remise;
        this.tva = tva;
        this.totHt = totHt;
        this.codFrs = codFrs;
    }

    public ArtDev() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUM_DEV")
    public String getNumDev() {
        return numDev;
    }

    public void setNumDev(String numDev) {
        this.numDev = numDev;
    }

    @Basic
    @Column(name = "DAT_DEV")
    public Date getDatDev() {
        return datDev;
    }

    public void setDatDev(Date datDev) {
        this.datDev = datDev;
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
    @Column(name = "QUT_DEV")
    public Short getQutDev() {
        return qutDev;
    }

    public void setQutDev(Short qutDev) {
        this.qutDev = qutDev;
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
    @Column(name = "REMISE")
    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    @Basic
    @Column(name = "TVA")
    public Byte getTva() {
        return tva;
    }

    public void setTva(Byte tva) {
        this.tva = tva;
    }

    @Basic
    @Column(name = "TOT_HT")
    public BigDecimal getTotHt() {
        return totHt;
    }

    public void setTotHt(BigDecimal totHt) {
        this.totHt = totHt;
    }

    @Basic
    @Column(name = "COD_FRS")
    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtDev artDev = (ArtDev) o;
        return id == artDev.id &&
                codFrs == artDev.codFrs &&
                Objects.equals(numDev, artDev.numDev) &&
                Objects.equals(datDev, artDev.datDev) &&
                Objects.equals(codArt, artDev.codArt) &&
                Objects.equals(qutDev, artDev.qutDev) &&
                Objects.equals(prixHt, artDev.prixHt) &&
                Objects.equals(remise, artDev.remise) &&
                Objects.equals(tva, artDev.tva) &&
                Objects.equals(totHt, artDev.totHt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numDev, datDev, codArt, qutDev, prixHt, remise, tva, totHt, codFrs);
    }

    @Override
    public String toString() {
        return "ArtDev{" +
                "id=" + id +
                ", numDev='" + numDev + '\'' +
                ", datDev=" + datDev +
                ", codArt='" + codArt + '\'' +
                ", qutDev=" + qutDev +
                ", prixHt=" + prixHt +
                ", remise=" + remise +
                ", tva=" + tva +
                ", totHt=" + totHt +
                ", codFrs=" + codFrs +
                '}';
    }
}
