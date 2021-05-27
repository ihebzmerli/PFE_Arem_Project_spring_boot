package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Fsolde {
    private String typDoc;
    private long id;
    private String numDoc;
    private BigDecimal montDoc;
    private Date datDoc;
    private long codFrs;
    private Date echeance;
    private String regle;
    private String paye;
    private String numReg;
    private BigDecimal montReg;
    private BigDecimal montDev;
    private String banque;
    private BigDecimal montRet;
    private String compta;
    private Date datComp;
    private String raison;
    private String poste;

    public Fsolde(String typDoc, String numDoc, BigDecimal montDoc, Date datDoc, long codFrs, Date echeance, String regle, String paye, String numReg, BigDecimal montReg, BigDecimal montDev, String banque, BigDecimal montRet, String compta, Date datComp, String raison, String poste) {
        this.typDoc = typDoc;
        this.numDoc = numDoc;
        this.montDoc = montDoc;
        this.datDoc = datDoc;
        this.codFrs = codFrs;
        this.echeance = echeance;
        this.regle = regle;
        this.paye = paye;
        this.numReg = numReg;
        this.montReg = montReg;
        this.montDev = montDev;
        this.banque = banque;
        this.montRet = montRet;
        this.compta = compta;
        this.datComp = datComp;
        this.raison = raison;
        this.poste = poste;
    }

    public Fsolde() {

    }

    @Basic
    @Column(name = "TYP_DOC")
    public String getTypDoc() {
        return typDoc;
    }

    public void setTypDoc(String typDoc) {
        this.typDoc = typDoc;
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
    @Column(name = "NUM_DOC")
    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
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
    @Column(name = "DAT_DOC")
    public Date getDatDoc() {
        return datDoc;
    }

    public void setDatDoc(Date datDoc) {
        this.datDoc = datDoc;
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
    @Column(name = "ECHEANCE")
    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    @Basic
    @Column(name = "REGLE")
    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    @Basic
    @Column(name = "PAYE")
    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    @Basic
    @Column(name = "NUM_REG")
    public String getNumReg() {
        return numReg;
    }

    public void setNumReg(String numReg) {
        this.numReg = numReg;
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
    @Column(name = "MONT_DEV")
    public BigDecimal getMontDev() {
        return montDev;
    }

    public void setMontDev(BigDecimal montDev) {
        this.montDev = montDev;
    }

    @Basic
    @Column(name = "BANQUE")
    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    @Basic
    @Column(name = "MONT_RET")
    public BigDecimal getMontRet() {
        return montRet;
    }

    public void setMontRet(BigDecimal montRet) {
        this.montRet = montRet;
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
    @Column(name = "DAT_COMP")
    public Date getDatComp() {
        return datComp;
    }

    public void setDatComp(Date datComp) {
        this.datComp = datComp;
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
        Fsolde fsolde = (Fsolde) o;
        return id == fsolde.id &&
                codFrs == fsolde.codFrs &&
                Objects.equals(typDoc, fsolde.typDoc) &&
                Objects.equals(numDoc, fsolde.numDoc) &&
                Objects.equals(montDoc, fsolde.montDoc) &&
                Objects.equals(datDoc, fsolde.datDoc) &&
                Objects.equals(echeance, fsolde.echeance) &&
                Objects.equals(regle, fsolde.regle) &&
                Objects.equals(paye, fsolde.paye) &&
                Objects.equals(numReg, fsolde.numReg) &&
                Objects.equals(montReg, fsolde.montReg) &&
                Objects.equals(montDev, fsolde.montDev) &&
                Objects.equals(banque, fsolde.banque) &&
                Objects.equals(montRet, fsolde.montRet) &&
                Objects.equals(compta, fsolde.compta) &&
                Objects.equals(datComp, fsolde.datComp) &&
                Objects.equals(raison, fsolde.raison) &&
                Objects.equals(poste, fsolde.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typDoc, id, numDoc, montDoc, datDoc, codFrs, echeance, regle, paye, numReg, montReg, montDev, banque, montRet, compta, datComp, raison, poste);
    }

    @Override
    public String toString() {
        return "Fsolde{" +
                "typDoc='" + typDoc + '\'' +
                ", id=" + id +
                ", numDoc='" + numDoc + '\'' +
                ", montDoc=" + montDoc +
                ", datDoc=" + datDoc +
                ", codFrs=" + codFrs +
                ", echeance=" + echeance +
                ", regle='" + regle + '\'' +
                ", paye='" + paye + '\'' +
                ", numReg='" + numReg + '\'' +
                ", montReg=" + montReg +
                ", montDev=" + montDev +
                ", banque='" + banque + '\'' +
                ", montRet=" + montRet +
                ", compta='" + compta + '\'' +
                ", datComp=" + datComp +
                ", raison='" + raison + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
}
