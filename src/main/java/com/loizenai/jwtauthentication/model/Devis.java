package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Devis {
    private long numDev;
    private Date datDev;
    private long codUser;
    private String raison;
    private BigDecimal brutHt;
    private BigDecimal tauxRem;
    private BigDecimal montRem;
    private BigDecimal netHt;
    private BigDecimal montTva;
    private BigDecimal totTtc;
    private BigDecimal xbase1;
    private BigDecimal xbase2;
    private BigDecimal xbase3;
    private BigDecimal xbase4;
    private BigDecimal xbase5;
    private BigDecimal xtva1;
    private BigDecimal xtva2;
    private BigDecimal xtva3;
    private BigDecimal xtva4;

    public Devis(Date datDev, long codUser, String raison, BigDecimal brutHt, BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc, BigDecimal xbase1, BigDecimal xbase2, BigDecimal xbase3, BigDecimal xbase4, BigDecimal xbase5, BigDecimal xtva1, BigDecimal xtva2, BigDecimal xtva3, BigDecimal xtva4) {
        this.datDev = datDev;
        this.codUser = codUser;
        this.raison = raison;
        this.brutHt = brutHt;
        this.tauxRem = tauxRem;
        this.montRem = montRem;
        this.netHt = netHt;
        this.montTva = montTva;
        this.totTtc = totTtc;
        this.xbase1 = xbase1;
        this.xbase2 = xbase2;
        this.xbase3 = xbase3;
        this.xbase4 = xbase4;
        this.xbase5 = xbase5;
        this.xtva1 = xtva1;
        this.xtva2 = xtva2;
        this.xtva3 = xtva3;
        this.xtva4 = xtva4;
    }

    public Devis() {

    }

    @Id
    @Column(name = "NUM_DEV")
    public long getNumDev() {
        return numDev;
    }

    public void setNumDev(long numDev) {
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
    @Column(name = "COD_USER")
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
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
    @Column(name = "BRUT_HT")
    public BigDecimal getBrutHt() {
        return brutHt;
    }

    public void setBrutHt(BigDecimal brutHt) {
        this.brutHt = brutHt;
    }

    @Basic
    @Column(name = "TAUX_REM")
    public BigDecimal getTauxRem() {
        return tauxRem;
    }

    public void setTauxRem(BigDecimal tauxRem) {
        this.tauxRem = tauxRem;
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
    @Column(name = "NET_HT")
    public BigDecimal getNetHt() {
        return netHt;
    }

    public void setNetHt(BigDecimal netHt) {
        this.netHt = netHt;
    }

    @Basic
    @Column(name = "MONT_TVA")
    public BigDecimal getMontTva() {
        return montTva;
    }

    public void setMontTva(BigDecimal montTva) {
        this.montTva = montTva;
    }

    @Basic
    @Column(name = "TOT_TTC")
    public BigDecimal getTotTtc() {
        return totTtc;
    }

    public void setTotTtc(BigDecimal totTtc) {
        this.totTtc = totTtc;
    }

    @Basic
    @Column(name = "XBASE1")
    public BigDecimal getXbase1() {
        return xbase1;
    }

    public void setXbase1(BigDecimal xbase1) {
        this.xbase1 = xbase1;
    }

    @Basic
    @Column(name = "XBASE2")
    public BigDecimal getXbase2() {
        return xbase2;
    }

    public void setXbase2(BigDecimal xbase2) {
        this.xbase2 = xbase2;
    }

    @Basic
    @Column(name = "XBASE3")
    public BigDecimal getXbase3() {
        return xbase3;
    }

    public void setXbase3(BigDecimal xbase3) {
        this.xbase3 = xbase3;
    }

    @Basic
    @Column(name = "XBASE4")
    public BigDecimal getXbase4() {
        return xbase4;
    }

    public void setXbase4(BigDecimal xbase4) {
        this.xbase4 = xbase4;
    }

    @Basic
    @Column(name = "XBASE5")
    public BigDecimal getXbase5() {
        return xbase5;
    }

    public void setXbase5(BigDecimal xbase5) {
        this.xbase5 = xbase5;
    }

    @Basic
    @Column(name = "XTVA1")
    public BigDecimal getXtva1() {
        return xtva1;
    }

    public void setXtva1(BigDecimal xtva1) {
        this.xtva1 = xtva1;
    }

    @Basic
    @Column(name = "XTVA2")
    public BigDecimal getXtva2() {
        return xtva2;
    }

    public void setXtva2(BigDecimal xtva2) {
        this.xtva2 = xtva2;
    }

    @Basic
    @Column(name = "XTVA3")
    public BigDecimal getXtva3() {
        return xtva3;
    }

    public void setXtva3(BigDecimal xtva3) {
        this.xtva3 = xtva3;
    }

    @Basic
    @Column(name = "XTVA4")
    public BigDecimal getXtva4() {
        return xtva4;
    }

    public void setXtva4(BigDecimal xtva4) {
        this.xtva4 = xtva4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devis devis = (Devis) o;
        return numDev == devis.numDev &&
                codUser == devis.codUser &&
                Objects.equals(datDev, devis.datDev) &&
                Objects.equals(raison, devis.raison) &&
                Objects.equals(brutHt, devis.brutHt) &&
                Objects.equals(tauxRem, devis.tauxRem) &&
                Objects.equals(montRem, devis.montRem) &&
                Objects.equals(netHt, devis.netHt) &&
                Objects.equals(montTva, devis.montTva) &&
                Objects.equals(totTtc, devis.totTtc) &&
                Objects.equals(xbase1, devis.xbase1) &&
                Objects.equals(xbase2, devis.xbase2) &&
                Objects.equals(xbase3, devis.xbase3) &&
                Objects.equals(xbase4, devis.xbase4) &&
                Objects.equals(xbase5, devis.xbase5) &&
                Objects.equals(xtva1, devis.xtva1) &&
                Objects.equals(xtva2, devis.xtva2) &&
                Objects.equals(xtva3, devis.xtva3) &&
                Objects.equals(xtva4, devis.xtva4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDev, datDev, codUser, raison, brutHt, tauxRem, montRem, netHt, montTva, totTtc, xbase1, xbase2, xbase3, xbase4, xbase5, xtva1, xtva2, xtva3, xtva4);
    }

    @Override
    public String toString() {
        return "Devis{" +
                "numDev=" + numDev +
                ", datDev=" + datDev +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", brutHt=" + brutHt +
                ", tauxRem=" + tauxRem +
                ", montRem=" + montRem +
                ", netHt=" + netHt +
                ", montTva=" + montTva +
                ", totTtc=" + totTtc +
                ", xbase1=" + xbase1 +
                ", xbase2=" + xbase2 +
                ", xbase3=" + xbase3 +
                ", xbase4=" + xbase4 +
                ", xbase5=" + xbase5 +
                ", xtva1=" + xtva1 +
                ", xtva2=" + xtva2 +
                ", xtva3=" + xtva3 +
                ", xtva4=" + xtva4 +
                '}';
    }
}
