package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "art_fac", schema = "testbd")
public class ArtFac {
    private long numFac;
    private Date datFac;
    private String codArt;
    private Integer qutFac;
    private BigDecimal prixHt;
    private BigDecimal remise;
    private long codFrs;
    private BigDecimal tva;
    private BigDecimal totHt;
    private BigDecimal marge;
    private Integer cumulRet;
    private long codUser;
    private BigDecimal prixAch;
    private String livreur;
    private BigDecimal remExp;
    private String poste;
    private String centre;

    public ArtFac(Date datFac, String codArt, Integer qutFac, BigDecimal prixHt, BigDecimal remise, long codFrs, BigDecimal tva, BigDecimal totHt, BigDecimal marge, Integer cumulRet, long codUser, BigDecimal prixAch, String livreur, BigDecimal remExp, String poste, String centre) {
        this.datFac = datFac;
        this.codArt = codArt;
        this.qutFac = qutFac;
        this.prixHt = prixHt;
        this.remise = remise;
        this.codFrs = codFrs;
        this.tva = tva;
        this.totHt = totHt;
        this.marge = marge;
        this.cumulRet = cumulRet;
        this.codUser = codUser;
        this.prixAch = prixAch;
        this.livreur = livreur;
        this.remExp = remExp;
        this.poste = poste;
        this.centre = centre;
    }

    public ArtFac() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_FAC")
    public long getNumFac() {
        return numFac;
    }

    public void setNumFac(long numFac) {
        this.numFac = numFac;
    }

    @Basic
    @Column(name = "DAT_FAC")
    public Date getDatFac() {
        return datFac;
    }

    public void setDatFac(Date datFac) {
        this.datFac = datFac;
    }

    @Basic
    @Column(name = "COD _ART")
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    @Basic
    @Column(name = "QUT_FAC")
    public Integer getQutFac() {
        return qutFac;
    }

    public void setQutFac(Integer qutFac) {
        this.qutFac = qutFac;
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
    @Column(name = "COD_FRS")
    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
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
    @Column(name = "TOT_HT")
    public BigDecimal getTotHt() {
        return totHt;
    }

    public void setTotHt(BigDecimal totHt) {
        this.totHt = totHt;
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
    @Column(name = "CUMUL_RET")
    public Integer getCumulRet() {
        return cumulRet;
    }

    public void setCumulRet(Integer cumulRet) {
        this.cumulRet = cumulRet;
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
        ArtFac artFac = (ArtFac) o;
        return numFac == artFac.numFac &&
                codFrs == artFac.codFrs &&
                codUser == artFac.codUser &&
                Objects.equals(datFac, artFac.datFac) &&
                Objects.equals(codArt, artFac.codArt) &&
                Objects.equals(qutFac, artFac.qutFac) &&
                Objects.equals(prixHt, artFac.prixHt) &&
                Objects.equals(remise, artFac.remise) &&
                Objects.equals(tva, artFac.tva) &&
                Objects.equals(totHt, artFac.totHt) &&
                Objects.equals(marge, artFac.marge) &&
                Objects.equals(cumulRet, artFac.cumulRet) &&
                Objects.equals(prixAch, artFac.prixAch) &&
                Objects.equals(livreur, artFac.livreur) &&
                Objects.equals(remExp, artFac.remExp) &&
                Objects.equals(poste, artFac.poste) &&
                Objects.equals(centre, artFac.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFac, datFac, codArt, qutFac, prixHt, remise, codFrs, tva, totHt, marge, cumulRet, codUser, prixAch, livreur, remExp, poste, centre);
    }

    @Override
    public String toString() {
        return "ArtFac{" +
                "numFac=" + numFac +
                ", datFac=" + datFac +
                ", codArt='" + codArt + '\'' +
                ", qutFac=" + qutFac +
                ", prixHt=" + prixHt +
                ", remise=" + remise +
                ", codFrs=" + codFrs +
                ", tva=" + tva +
                ", totHt=" + totHt +
                ", marge=" + marge +
                ", cumulRet=" + cumulRet +
                ", codUser=" + codUser +
                ", prixAch=" + prixAch +
                ", livreur='" + livreur + '\'' +
                ", remExp=" + remExp +
                ", poste='" + poste + '\'' +
                ", centre='" + centre + '\'' +
                '}';
    }
}
