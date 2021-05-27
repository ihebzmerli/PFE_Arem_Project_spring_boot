package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reg_imp1", schema = "seratest")
public class RegImp1 {
    private int id;
    private long codFrs;
    private BigDecimal solde;
    private String modReg;
    private String del;
    private String codBank;
    private String numReg1;
    private String numDoc;
    private BigDecimal montReg;
    private Date datEch;
    private Date datReg;
    private String numFac;
    private String poste;
    private long codUser;

    public RegImp1(long codFrs, BigDecimal solde, String modReg, String del, String codBank, String numReg1, String numDoc, BigDecimal montReg, Date datEch, Date datReg, String numFac, String poste, long codUser) {
        this.codFrs = codFrs;
        this.solde = solde;
        this.modReg = modReg;
        this.del = del;
        this.codBank = codBank;
        this.numReg1 = numReg1;
        this.numDoc = numDoc;
        this.montReg = montReg;
        this.datEch = datEch;
        this.datReg = datReg;
        this.numFac = numFac;
        this.poste = poste;
        this.codUser = codUser;
    }

    public RegImp1() {

    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "SOLDE")
    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Basic
    @Column(name = "MOD_REG")
    public String getModReg() {
        return modReg;
    }

    public void setModReg(String modReg) {
        this.modReg = modReg;
    }

    @Basic
    @Column(name = "DEL")
    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Basic
    @Column(name = "COD_BANK")
    public String getCodBank() {
        return codBank;
    }

    public void setCodBank(String codBank) {
        this.codBank = codBank;
    }

    @Column(name = "NUM_REG1")
    public String getNumReg1() {
        return numReg1;
    }

    public void setNumReg1(String numReg1) {
        this.numReg1 = numReg1;
    }

    @Basic
    @Column(name = "NUM_DOC")
    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    @Basic
    @Column(name = "MONT_REG")
    public BigDecimal getMontReg() {
        return montReg;
    }

    public void setMontReg(BigDecimal montReg) {
        this.montReg = montReg;
    }

    @Basic
    @Column(name = "DAT_ECH")
    public Date getDatEch() {
        return datEch;
    }

    public void setDatEch(Date datEch) {
        this.datEch = datEch;
    }

    @Basic
    @Column(name = "DAT_REG")
    public Date getDatReg() {
        return datReg;
    }

    public void setDatReg(Date datReg) {
        this.datReg = datReg;
    }

    @Basic
    @Column(name = "NUM_FAC")
    public String getNumFac() {
        return numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegImp1 regImp1 = (RegImp1) o;
        return id == regImp1.id &&
                codFrs == regImp1.codFrs &&
                codUser == regImp1.codUser &&
                Objects.equals(solde, regImp1.solde) &&
                Objects.equals(modReg, regImp1.modReg) &&
                Objects.equals(del, regImp1.del) &&
                Objects.equals(codBank, regImp1.codBank) &&
                Objects.equals(numReg1, regImp1.numReg1) &&
                Objects.equals(numDoc, regImp1.numDoc) &&
                Objects.equals(montReg, regImp1.montReg) &&
                Objects.equals(datEch, regImp1.datEch) &&
                Objects.equals(datReg, regImp1.datReg) &&
                Objects.equals(numFac, regImp1.numFac) &&
                Objects.equals(poste, regImp1.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codFrs, solde, modReg, del, codBank, numReg1, numDoc, montReg, datEch, datReg, numFac, poste, codUser);
    }

    @Override
    public String toString() {
        return "RegImp1{" +
                "id=" + id +
                ", codFrs=" + codFrs +
                ", solde=" + solde +
                ", modReg='" + modReg + '\'' +
                ", del='" + del + '\'' +
                ", codBank='" + codBank + '\'' +
                ", numReg1='" + numReg1 + '\'' +
                ", numDoc='" + numDoc + '\'' +
                ", montReg=" + montReg +
                ", datEch=" + datEch +
                ", datReg=" + datReg +
                ", numFac='" + numFac + '\'' +
                ", poste='" + poste + '\'' +
                ", codUser=" + codUser +
                '}';
    }
}
