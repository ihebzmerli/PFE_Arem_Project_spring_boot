package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "art_inst", schema = "seratest")
public class ArtInst {
    private long numFac;
    private Date datFac;
    private Integer qutLiv;
    private BigDecimal remise;
    private BigDecimal prixHt;
    private BigDecimal tva;
    private String codArt;
    private BigDecimal totHt;
    private long codFrs;
    private BigDecimal marge;
    private String typArt;
    private Integer cumulRet;
    private long codUser;
    private BigDecimal prixAch;
    private String livreur;
    private BigDecimal remExp;
    private String typFac;
    private String poste;
    private String centre;

    public ArtInst(Date datFac, Integer qutLiv, BigDecimal remise, BigDecimal prixHt, BigDecimal tva, String codArt, BigDecimal totHt, long codFrs, BigDecimal marge, String typArt, Integer cumulRet, long codUser, BigDecimal prixAch, String livreur, BigDecimal remExp, String typFac, String poste, String centre) {
        this.datFac = datFac;
        this.qutLiv = qutLiv;
        this.remise = remise;
        this.prixHt = prixHt;
        this.tva = tva;
        this.codArt = codArt;
        this.totHt = totHt;
        this.codFrs = codFrs;
        this.marge = marge;
        this.typArt = typArt;
        this.cumulRet = cumulRet;
        this.codUser = codUser;
        this.prixAch = prixAch;
        this.livreur = livreur;
        this.remExp = remExp;
        this.typFac = typFac;
        this.poste = poste;
        this.centre = centre;
    }

    public ArtInst() {

    }

    @Id
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
    @Column(name = "QUT_LIV")
    public Integer getQutLiv() {
        return qutLiv;
    }

    public void setQutLiv(Integer qutLiv) {
        this.qutLiv = qutLiv;
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
    @Column(name = "COD_ART")
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
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
    @Column(name = "TYP_FAC")
    public String getTypFac() {
        return typFac;
    }

    public void setTypFac(String typFac) {
        this.typFac = typFac;
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
        ArtInst artInst = (ArtInst) o;
        return numFac == artInst.numFac &&
                codFrs == artInst.codFrs &&
                codUser == artInst.codUser &&
                Objects.equals(datFac, artInst.datFac) &&
                Objects.equals(qutLiv, artInst.qutLiv) &&
                Objects.equals(remise, artInst.remise) &&
                Objects.equals(prixHt, artInst.prixHt) &&
                Objects.equals(tva, artInst.tva) &&
                Objects.equals(codArt, artInst.codArt) &&
                Objects.equals(totHt, artInst.totHt) &&
                Objects.equals(marge, artInst.marge) &&
                Objects.equals(typArt, artInst.typArt) &&
                Objects.equals(cumulRet, artInst.cumulRet) &&
                Objects.equals(prixAch, artInst.prixAch) &&
                Objects.equals(livreur, artInst.livreur) &&
                Objects.equals(remExp, artInst.remExp) &&
                Objects.equals(typFac, artInst.typFac) &&
                Objects.equals(poste, artInst.poste) &&
                Objects.equals(centre, artInst.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFac, datFac, qutLiv, remise, prixHt, tva, codArt, totHt, codFrs, marge, typArt, cumulRet, codUser, prixAch, livreur, remExp, typFac, poste, centre);
    }

    @Override
    public String toString() {
        return "ArtInst{" +
                "numFac=" + numFac +
                ", datFac=" + datFac +
                ", qutLiv=" + qutLiv +
                ", remise=" + remise +
                ", prixHt=" + prixHt +
                ", tva=" + tva +
                ", codArt='" + codArt + '\'' +
                ", totHt=" + totHt +
                ", codFrs=" + codFrs +
                ", marge=" + marge +
                ", typArt='" + typArt + '\'' +
                ", cumulRet=" + cumulRet +
                ", codUser=" + codUser +
                ", prixAch=" + prixAch +
                ", livreur='" + livreur + '\'' +
                ", remExp=" + remExp +
                ", typFac='" + typFac + '\'' +
                ", poste='" + poste + '\'' +
                ", centre='" + centre + '\'' +
                '}';
    }
}
