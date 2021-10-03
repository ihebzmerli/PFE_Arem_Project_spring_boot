package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "art_com", schema = "testbd")
public class ArtCom {
    private int id;
    private long numCom;
    private String codArt;
    private String refOrg;
    private Integer qutArt;
    private long codFrs;
    private String marque;
    private BigDecimal prixAch;
    private String raison;
    private BigDecimal prixLiv;
    private Byte tva;
    private Integer qutFac;
    private BigDecimal marge;
    private BigDecimal remise;
    private BigDecimal totalTtc;
    private Integer analStk;
    private BigDecimal prixVen;

    public ArtCom(int id, String codArt, String refOrg, Integer qutArt, long codFrs, String marque, BigDecimal prixAch, String raison, BigDecimal prixLiv, Byte tva, Integer qutFac, BigDecimal marge, BigDecimal remise, BigDecimal totalTtc, Integer analStk, BigDecimal prixVen) {
        this.id = id;
        this.codArt = codArt;
        this.refOrg = refOrg;
        this.qutArt = qutArt;
        this.codFrs = codFrs;
        this.marque = marque;
        this.prixAch = prixAch;
        this.raison = raison;
        this.prixLiv = prixLiv;
        this.tva = tva;
        this.qutFac = qutFac;
        this.marge = marge;
        this.remise = remise;
        this.totalTtc = totalTtc;
        this.analStk = analStk;
        this.prixVen = prixVen;
    }

    public ArtCom() {

    }

    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "NUM_COM")
    public long getNumCom() {
        return numCom;
    }

    public void setNumCom(long numCom) {
        this.numCom = numCom;
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
    @Column(name = "REF_ORG")
    public String getRefOrg() {
        return refOrg;
    }

    public void setRefOrg(String refOrg) {
        this.refOrg = refOrg;
    }

    @Basic
    @Column(name = "QUT_ART")
    public Integer getQutArt() {
        return qutArt;
    }

    public void setQutArt(Integer qutArt) {
        this.qutArt = qutArt;
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
    @Column(name = "MARQUE")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
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
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Basic
    @Column(name = "PRIX_LIV")
    public BigDecimal getPrixLiv() {
        return prixLiv;
    }

    public void setPrixLiv(BigDecimal prixLiv) {
        this.prixLiv = prixLiv;
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
    @Column(name = "QUT_FAC")
    public Integer getQutFac() {
        return qutFac;
    }

    public void setQutFac(Integer qutFac) {
        this.qutFac = qutFac;
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
    @Column(name = "REMISE")
    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    @Basic
    @Column(name = "TOTAL_TTC")
    public BigDecimal getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(BigDecimal totalTtc) {
        this.totalTtc = totalTtc;
    }

    @Basic
    @Column(name = "ANAL_STK")
    public Integer getAnalStk() {
        return analStk;
    }

    public void setAnalStk(Integer analStk) {
        this.analStk = analStk;
    }

    @Basic
    @Column(name = "PRIX_VEN")
    public BigDecimal getPrixVen() {
        return prixVen;
    }

    public void setPrixVen(BigDecimal prixVen) {
        this.prixVen = prixVen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtCom artCom = (ArtCom) o;
        return id == artCom.id &&
                numCom == artCom.numCom &&
                codFrs == artCom.codFrs &&
                Objects.equals(codArt, artCom.codArt) &&
                Objects.equals(refOrg, artCom.refOrg) &&
                Objects.equals(qutArt, artCom.qutArt) &&
                Objects.equals(marque, artCom.marque) &&
                Objects.equals(prixAch, artCom.prixAch) &&
                Objects.equals(raison, artCom.raison) &&
                Objects.equals(prixLiv, artCom.prixLiv) &&
                Objects.equals(tva, artCom.tva) &&
                Objects.equals(qutFac, artCom.qutFac) &&
                Objects.equals(marge, artCom.marge) &&
                Objects.equals(remise, artCom.remise) &&
                Objects.equals(totalTtc, artCom.totalTtc) &&
                Objects.equals(analStk, artCom.analStk) &&
                Objects.equals(prixVen, artCom.prixVen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numCom, codArt, refOrg, qutArt, codFrs, marque, prixAch, raison, prixLiv, tva, qutFac, marge, remise, totalTtc, analStk, prixVen);
    }

    @Override
    public String toString() {
        return "ArtCom{" +
                "id=" + id +
                ", numCom=" + numCom +
                ", codArt='" + codArt + '\'' +
                ", refOrg='" + refOrg + '\'' +
                ", qutArt=" + qutArt +
                ", codFrs=" + codFrs +
                ", marque='" + marque + '\'' +
                ", prixAch=" + prixAch +
                ", raison='" + raison + '\'' +
                ", prixLiv=" + prixLiv +
                ", tva=" + tva +
                ", qutFac=" + qutFac +
                ", marge=" + marge +
                ", remise=" + remise +
                ", totalTtc=" + totalTtc +
                ", analStk=" + analStk +
                ", prixVen=" + prixVen +
                '}';
    }
}
