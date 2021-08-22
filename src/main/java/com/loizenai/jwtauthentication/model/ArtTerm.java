package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "art_term", schema = "seratest")
public class ArtTerm implements Serializable{

    @Id
    @Column(name = "NUM_ART_TERM")
    private String numBonFac;
    private String numDoc;
    private Timestamp date;
    private BigDecimal netHt;
    private BigDecimal tva;
    private BigDecimal totTtc;
    private BigDecimal montTrs;

    //FK_KEYS***********************
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private Facture facture;
    
    @OneToMany(mappedBy = "artPrep_artTerm", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<ArtPrep> artPreps;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "NUM_BON_LIV", nullable = true)
    private BonLiv bonLiv;

    //END FK_KEYS************************

    public ArtTerm(String numDoc, Timestamp date, BigDecimal netHt, BigDecimal tva, BigDecimal totTtc, BigDecimal montTrs) {
        this.numDoc = numDoc;
        this.date = date;
        this.netHt = netHt;
        this.tva = tva;
        this.totTtc = totTtc;
        this.montTrs = montTrs;
    }

    public ArtTerm(String numBonFac, String numDoc, Timestamp date, BigDecimal netHt, BigDecimal tva,
            BigDecimal totTtc, BigDecimal montTrs, Facture facture, List<ArtPrep> artPreps, BonLiv bonLiv) {
        this.numBonFac = numBonFac;
        this.numDoc = numDoc;
        this.date = date;
        this.netHt = netHt;
        this.tva = tva;
        this.totTtc = totTtc;
        this.montTrs = montTrs;
        this.facture = facture;
        this.artPreps = artPreps;
        this.bonLiv = bonLiv;
    }

    public ArtTerm() {

    }


    public String getNumBonFac() {
        return numBonFac;
    }

    public void setNumBonFac(String numBonFac) {
        this.numBonFac = numBonFac;
    }

    @Basic
    @Column(name = "NUM_DOC")
    public String getNumBon() {
        return numDoc;
    }

    public void setNumBon(String numDoc) {
        this.numDoc = numDoc;
    }

    @Basic
    @Column(name = "DATE")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "TVA")
    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
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
    @Column(name = "MONT_TRS")
    public BigDecimal getMontTrs() {
        return montTrs;
    }

    public void setMontTrs(BigDecimal montTrs) {
        this.montTrs = montTrs;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public List<ArtPrep> getArtPreps() {
        return artPreps;
    }

    public void setArtPreps(List<ArtPrep> artPreps) {
        this.artPreps = artPreps;
    }

    public void setBonLiv(BonLiv bonLiv) {
        this.bonLiv = bonLiv;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtTerm artTerm = (ArtTerm) o;
        return Objects.equals(numBonFac, artTerm.numBonFac) &&
                Objects.equals(date, artTerm.date) &&
                Objects.equals(netHt, artTerm.netHt) &&
                Objects.equals(tva, artTerm.tva) &&
                Objects.equals(totTtc, artTerm.totTtc) &&
                Objects.equals(montTrs, artTerm.montTrs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numBonFac, numDoc, date, netHt, tva, totTtc, montTrs);
    }

    @Override
    public String toString() {
        return "ArtTerm{" +
                "numBonFac='" + numBonFac + '\'' +
                ", numDoc='" + numDoc + '\'' +
                ", date=" + date +
                ", netHt=" + netHt +
                ", tva=" + tva +
                ", totTtc=" + totTtc +
                ", montTrs=" + montTrs +
                '}';
    }
    
}
