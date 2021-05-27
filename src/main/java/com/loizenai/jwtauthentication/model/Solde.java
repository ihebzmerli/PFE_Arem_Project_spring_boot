package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Solde {
    private long id;
    private String type;
    private BigDecimal venteP;
    private BigDecimal venteM;
    private BigDecimal venteI;
    private BigDecimal venteS;
    private BigDecimal regCli;
    private BigDecimal regDiv;
    private String regImp;
    private BigDecimal majPfChq;
    private BigDecimal majPfEff;
    private BigDecimal recette;
    private BigDecimal banque;
    private BigDecimal solde;
    private Date date;
    private String poste;

    public Solde(String type, BigDecimal venteP, BigDecimal venteM, BigDecimal venteI, BigDecimal venteS, BigDecimal regCli, BigDecimal regDiv, String regImp, BigDecimal majPfChq, BigDecimal majPfEff, BigDecimal recette, BigDecimal banque, BigDecimal solde, Date date, String poste) {
        this.type = type;
        this.venteP = venteP;
        this.venteM = venteM;
        this.venteI = venteI;
        this.venteS = venteS;
        this.regCli = regCli;
        this.regDiv = regDiv;
        this.regImp = regImp;
        this.majPfChq = majPfChq;
        this.majPfEff = majPfEff;
        this.recette = recette;
        this.banque = banque;
        this.solde = solde;
        this.date = date;
        this.poste = poste;
    }

    public Solde() {

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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "VENTE_P")
    public BigDecimal getVenteP() {
        return venteP;
    }

    public void setVenteP(BigDecimal venteP) {
        this.venteP = venteP;
    }

    @Basic
    @Column(name = "VENTE_M")
    public BigDecimal getVenteM() {
        return venteM;
    }

    public void setVenteM(BigDecimal venteM) {
        this.venteM = venteM;
    }

    @Basic
    @Column(name = "VENTE_I")
    public BigDecimal getVenteI() {
        return venteI;
    }

    public void setVenteI(BigDecimal venteI) {
        this.venteI = venteI;
    }

    @Basic
    @Column(name = "VENTE_S")
    public BigDecimal getVenteS() {
        return venteS;
    }

    public void setVenteS(BigDecimal venteS) {
        this.venteS = venteS;
    }

    @Basic
    @Column(name = "REG_CLI")
    public BigDecimal getRegCli() {
        return regCli;
    }

    public void setRegCli(BigDecimal regCli) {
        this.regCli = regCli;
    }

    @Basic
    @Column(name = "REG_DIV")
    public BigDecimal getRegDiv() {
        return regDiv;
    }

    public void setRegDiv(BigDecimal regDiv) {
        this.regDiv = regDiv;
    }

    @Basic
    @Column(name = "REG_IMP")
    public String getRegImp() {
        return regImp;
    }

    public void setRegImp(String regImp) {
        this.regImp = regImp;
    }

    @Basic
    @Column(name = "MAJ_PF_CHQ")
    public BigDecimal getMajPfChq() {
        return majPfChq;
    }

    public void setMajPfChq(BigDecimal majPfChq) {
        this.majPfChq = majPfChq;
    }

    @Basic
    @Column(name = "MAJ_PF_EFF")
    public BigDecimal getMajPfEff() {
        return majPfEff;
    }

    public void setMajPfEff(BigDecimal majPfEff) {
        this.majPfEff = majPfEff;
    }

    @Basic
    @Column(name = "RECETTE")
    public BigDecimal getRecette() {
        return recette;
    }

    public void setRecette(BigDecimal recette) {
        this.recette = recette;
    }

    @Basic
    @Column(name = "BANQUE")
    public BigDecimal getBanque() {
        return banque;
    }

    public void setBanque(BigDecimal banque) {
        this.banque = banque;
    }

    @Basic
    @Column(name = "SOLDE")
    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "POSTE")
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solde solde1 = (Solde) o;
        return id == solde1.id &&
                Objects.equals(type, solde1.type) &&
                Objects.equals(venteP, solde1.venteP) &&
                Objects.equals(venteM, solde1.venteM) &&
                Objects.equals(venteI, solde1.venteI) &&
                Objects.equals(venteS, solde1.venteS) &&
                Objects.equals(regCli, solde1.regCli) &&
                Objects.equals(regDiv, solde1.regDiv) &&
                Objects.equals(regImp, solde1.regImp) &&
                Objects.equals(majPfChq, solde1.majPfChq) &&
                Objects.equals(majPfEff, solde1.majPfEff) &&
                Objects.equals(recette, solde1.recette) &&
                Objects.equals(banque, solde1.banque) &&
                Objects.equals(solde, solde1.solde) &&
                Objects.equals(date, solde1.date) &&
                Objects.equals(poste, solde1.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, venteP, venteM, venteI, venteS, regCli, regDiv, regImp, majPfChq, majPfEff, recette, banque, solde, date, poste);
    }

    @Override
    public String toString() {
        return "Solde{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", venteP=" + venteP +
                ", venteM=" + venteM +
                ", venteI=" + venteI +
                ", venteS=" + venteS +
                ", regCli=" + regCli +
                ", regDiv=" + regDiv +
                ", regImp='" + regImp + '\'' +
                ", majPfChq=" + majPfChq +
                ", majPfEff=" + majPfEff +
                ", recette=" + recette +
                ", banque=" + banque +
                ", solde=" + solde +
                ", date=" + date +
                ", poste='" + poste + '\'' +
                '}';
    }
}
