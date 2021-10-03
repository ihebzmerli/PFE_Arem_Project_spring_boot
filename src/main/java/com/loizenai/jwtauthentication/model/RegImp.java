package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reg_imp", schema = "testbd")
public class RegImp {
    private long id;
    private Long codUser;
    private String raison;
    private long numDoc;
    private String typDoc;
    private Date datDoc;
    private BigDecimal montDoc;
    private String typReg;
    private long numReg;
    private Date datReg;
    private BigDecimal montAvc;
    private BigDecimal montReg;
    private BigDecimal soldeDoc;
    private String numdoc;
    private String compta;
    private String avCli;
    private String poste;

    public RegImp(Long codUser, String raison, long numDoc, String typDoc, Date datDoc, BigDecimal montDoc, String typReg, long numReg, Date datReg, BigDecimal montAvc, BigDecimal montReg, BigDecimal soldeDoc, String numdoc, String compta, String avCli, String poste) {
        this.codUser = codUser;
        this.raison = raison;
        this.numDoc = numDoc;
        this.typDoc = typDoc;
        this.datDoc = datDoc;
        this.montDoc = montDoc;
        this.typReg = typReg;
        this.numReg = numReg;
        this.datReg = datReg;
        this.montAvc = montAvc;
        this.montReg = montReg;
        this.soldeDoc = soldeDoc;
        this.numdoc = numdoc;
        this.compta = compta;
        this.avCli = avCli;
        this.poste = poste;
    }

    public RegImp() {

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
    @Column(name = "COD_USER")
    public Long getCodUser() {
        return codUser;
    }

    public void setCodUser(Long codUser) {
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
    @Column(name = "NUM_DOC")
    public long getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(long numDoc) {
        this.numDoc = numDoc;
    }

    @Basic
    @Column(name = "TYP_DOC")
    public String getTypDoc() {
        return typDoc;
    }

    public void setTypDoc(String typDoc) {
        this.typDoc = typDoc;
    }

    @Basic
    @Column(name = "DAT_DOC")
    public Date getDatDoc() {
        return datDoc;
    }

    public void setDatDoc(Date datDoc) {
        this.datDoc = datDoc;
    }

    @Basic
    @Column(name = "MONT_DOC")
    public BigDecimal getMontDoc() {
        return montDoc;
    }

    public void setMontDoc(BigDecimal montDoc) {
        this.montDoc = montDoc;
    }

    @Basic
    @Column(name = "TYP_REG")
    public String getTypReg() {
        return typReg;
    }

    public void setTypReg(String typReg) {
        this.typReg = typReg;
    }

    @Column(name = "NUM_REG")
    public long getNumReg() {
        return numReg;
    }

    public void setNumReg(long numReg) {
        this.numReg = numReg;
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
    @Column(name = "MONT_AVC")
    public BigDecimal getMontAvc() {
        return montAvc;
    }

    public void setMontAvc(BigDecimal montAvc) {
        this.montAvc = montAvc;
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
    @Column(name = "SOLDE_DOC")
    public BigDecimal getSoldeDoc() {
        return soldeDoc;
    }

    public void setSoldeDoc(BigDecimal soldeDoc) {
        this.soldeDoc = soldeDoc;
    }

    @Basic
    @Column(name = "NUMDOC")
    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    @Basic
    @Column(name = "COMPTA")
    public String getCompta() {
        return compta;
    }

    public void setCompta(String compta) {
        this.compta = compta;
    }

    @Basic
    @Column(name = "AV_CLI")
    public String getAvCli() {
        return avCli;
    }

    public void setAvCli(String avCli) {
        this.avCli = avCli;
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
        RegImp regImp = (RegImp) o;
        return id == regImp.id &&
                numDoc == regImp.numDoc &&
                numReg == regImp.numReg &&
                Objects.equals(codUser, regImp.codUser) &&
                Objects.equals(raison, regImp.raison) &&
                Objects.equals(typDoc, regImp.typDoc) &&
                Objects.equals(datDoc, regImp.datDoc) &&
                Objects.equals(montDoc, regImp.montDoc) &&
                Objects.equals(typReg, regImp.typReg) &&
                Objects.equals(datReg, regImp.datReg) &&
                Objects.equals(montAvc, regImp.montAvc) &&
                Objects.equals(montReg, regImp.montReg) &&
                Objects.equals(soldeDoc, regImp.soldeDoc) &&
                Objects.equals(numdoc, regImp.numdoc) &&
                Objects.equals(compta, regImp.compta) &&
                Objects.equals(avCli, regImp.avCli) &&
                Objects.equals(poste, regImp.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codUser, raison, numDoc, typDoc, datDoc, montDoc, typReg, numReg, datReg, montAvc, montReg, soldeDoc, numdoc, compta, avCli, poste);
    }

    @Override
    public String toString() {
        return "RegImp{" +
                "id=" + id +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", numDoc=" + numDoc +
                ", typDoc='" + typDoc + '\'' +
                ", datDoc=" + datDoc +
                ", montDoc=" + montDoc +
                ", typReg='" + typReg + '\'' +
                ", numReg=" + numReg +
                ", datReg=" + datReg +
                ", montAvc=" + montAvc +
                ", montReg=" + montReg +
                ", soldeDoc=" + soldeDoc +
                ", numdoc='" + numdoc + '\'' +
                ", compta='" + compta + '\'' +
                ", avCli='" + avCli + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
}
