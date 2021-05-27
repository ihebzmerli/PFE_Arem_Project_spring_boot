package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "art_avr", schema = "seratest")
public class ArtAvr {
    private long numAvr;
    private Date datAvr;
    private String codArt;
    private Integer qutRet;
    private BigDecimal prixHt;
    private BigDecimal tva;
    private BigDecimal remise;
    private String codFrs;
    private BigDecimal marge;
    private String typArt;
    private String cumulRet;
    private String codUser;
    private BigDecimal prixAch;
    private String livreur;
    private String numavr;
    private BigDecimal remExp;
    private String poste;
    private String centre;

    public ArtAvr(Date datAvr, String codArt, Integer qutRet, BigDecimal prixHt, BigDecimal tva, BigDecimal remise, String codFrs, BigDecimal marge, String typArt, String cumulRet, String codUser, BigDecimal prixAch, String livreur, String numavr, BigDecimal remExp, String poste, String centre) {
        this.datAvr = datAvr;
        this.codArt = codArt;
        this.qutRet = qutRet;
        this.prixHt = prixHt;
        this.tva = tva;
        this.remise = remise;
        this.codFrs = codFrs;
        this.marge = marge;
        this.typArt = typArt;
        this.cumulRet = cumulRet;
        this.codUser = codUser;
        this.prixAch = prixAch;
        this.livreur = livreur;
        this.numavr = numavr;
        this.remExp = remExp;
        this.poste = poste;
        this.centre = centre;
    }

    public ArtAvr() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_AVR")
    public long getNumAvr() {
        return numAvr;
    }

    public void setNumAvr(long numAvr) {
        this.numAvr = numAvr;
    }

    @Basic
    @Column(name = "DAT_AVR")
    public Date getDatAvr() {
        return datAvr;
    }

    public void setDatAvr(Date datAvr) {
        this.datAvr = datAvr;
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
    @Column(name = "QUT_RET")
    public Integer getQutRet() {
        return qutRet;
    }

    public void setQutRet(Integer qutRet) {
        this.qutRet = qutRet;
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
    @Column(name = "TVA")
    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
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
    @Column(name = "COD_FRS")
    public String getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(String codFrs) {
        this.codFrs = codFrs;
    }

    @Basic
    @Column(name = "MARGE")
    public BigDecimal getMarge() {
        return marge;
    }

    public void setMarge(BigDecimal marge) {
        this.marge = marge;
    }

    @Basic
    @Column(name = "TYP_ART")
    public String getTypArt() {
        return typArt;
    }

    public void setTypArt(String typArt) {
        this.typArt = typArt;
    }

    @Basic
    @Column(name = "CUMUL_RET")
    public String getCumulRet() {
        return cumulRet;
    }

    public void setCumulRet(String cumulRet) {
        this.cumulRet = cumulRet;
    }

    @Basic
    @Column(name = "COD_USER")
    public String getCodUser() {
        return codUser;
    }

    public void setCodUser(String codUser) {
        this.codUser = codUser;
    }

    @Basic
    @Column(name = "PRIX_ACH")
    public BigDecimal getPrixAch() {
        return prixAch;
    }

    public void setPrixAch(BigDecimal prixAch) {
        this.prixAch = prixAch;
    }

    @Basic
    @Column(name = "LIVREUR")
    public String getLivreur() {
        return livreur;
    }

    public void setLivreur(String livreur) {
        this.livreur = livreur;
    }

    @Basic
    @Column(name = "NUMAVR")
    public String getNumavr() {
        return numavr;
    }

    public void setNumavr(String numavr) {
        this.numavr = numavr;
    }

    @Basic
    @Column(name = "REM_EXP")
    public BigDecimal getRemExp() {
        return remExp;
    }

    public void setRemExp(BigDecimal remExp) {
        this.remExp = remExp;
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
    @Column(name = "CENTRE")
    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtAvr artAvr = (ArtAvr) o;
        return numAvr == artAvr.numAvr &&
                Objects.equals(datAvr, artAvr.datAvr) &&
                Objects.equals(codArt, artAvr.codArt) &&
                Objects.equals(qutRet, artAvr.qutRet) &&
                Objects.equals(prixHt, artAvr.prixHt) &&
                Objects.equals(tva, artAvr.tva) &&
                Objects.equals(remise, artAvr.remise) &&
                Objects.equals(codFrs, artAvr.codFrs) &&
                Objects.equals(marge, artAvr.marge) &&
                Objects.equals(typArt, artAvr.typArt) &&
                Objects.equals(cumulRet, artAvr.cumulRet) &&
                Objects.equals(codUser, artAvr.codUser) &&
                Objects.equals(prixAch, artAvr.prixAch) &&
                Objects.equals(livreur, artAvr.livreur) &&
                Objects.equals(numavr, artAvr.numavr) &&
                Objects.equals(remExp, artAvr.remExp) &&
                Objects.equals(poste, artAvr.poste) &&
                Objects.equals(centre, artAvr.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAvr, datAvr, codArt, qutRet, prixHt, tva, remise, codFrs, marge, typArt, cumulRet, codUser, prixAch, livreur, numavr, remExp, poste, centre);
    }

    @Override
    public String toString() {
        return "ArtAvr{" +
                "numAvr=" + numAvr +
                ", datAvr=" + datAvr +
                ", codArt='" + codArt + '\'' +
                ", qutRet=" + qutRet +
                ", prixHt=" + prixHt +
                ", tva=" + tva +
                ", remise=" + remise +
                ", codFrs='" + codFrs + '\'' +
                ", marge=" + marge +
                ", typArt='" + typArt + '\'' +
                ", cumulRet='" + cumulRet + '\'' +
                ", codUser='" + codUser + '\'' +
                ", prixAch=" + prixAch +
                ", livreur='" + livreur + '\'' +
                ", numavr='" + numavr + '\'' +
                ", remExp=" + remExp +
                ", poste='" + poste + '\'' +
                ", centre='" + centre + '\'' +
                '}';
    }
}
