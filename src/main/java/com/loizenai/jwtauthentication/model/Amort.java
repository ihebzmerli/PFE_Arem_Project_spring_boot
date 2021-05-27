package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Amort {
    private long id;
    private int num;
    private BigDecimal montant;
    private BigDecimal interet;
    private Date echeance;
    private String bank;
    private String type;
    private String avisdb;
    private Date datAvd;
    private String leasing;
    private long codFrs;
    private String cptInt;
    private String tresor;
    private String comptaS;
    private BigDecimal commission;
    private BigDecimal tva;
    private Date datComp;
    private String observ;

    public Amort(BigDecimal montant, BigDecimal interet, Date echeance, String bank, String type, String avisdb, Date datAvd, String leasing, long codFrs, String cptInt, String tresor, String comptaS, BigDecimal commission, BigDecimal tva, Date datComp, String observ) {
        this.montant = montant;
        this.interet = interet;
        this.echeance = echeance;
        this.bank = bank;
        this.type = type;
        this.avisdb = avisdb;
        this.datAvd = datAvd;
        this.leasing = leasing;
        this.codFrs = codFrs;
        this.cptInt = cptInt;
        this.tresor = tresor;
        this.comptaS = comptaS;
        this.commission = commission;
        this.tva = tva;
        this.datComp = datComp;
        this.observ = observ;
    }

    public Amort() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUM")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "MONTANT")
    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    @Basic
    @Column(name = "INTERET")
    public BigDecimal getInteret() {
        return interet;
    }

    public void setInteret(BigDecimal interet) {
        this.interet = interet;
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
    @Column(name = "BANK")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
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
    @Column(name = "AVISDB")
    public String getAvisdb() {
        return avisdb;
    }

    public void setAvisdb(String avisdb) {
        this.avisdb = avisdb;
    }

    @Basic
    @Column(name = "DAT_AVD")
    public Date getDatAvd() {
        return datAvd;
    }

    public void setDatAvd(Date datAvd) {
        this.datAvd = datAvd;
    }

    @Basic
    @Column(name = "LEASING")
    public String getLeasing() {
        return leasing;
    }

    public void setLeasing(String leasing) {
        this.leasing = leasing;
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
    @Column(name = "CPT_INT")
    public String getCptInt() {
        return cptInt;
    }

    public void setCptInt(String cptInt) {
        this.cptInt = cptInt;
    }

    @Basic
    @Column(name = "TRESOR")
    public String getTresor() {
        return tresor;
    }

    public void setTresor(String tresor) {
        this.tresor = tresor;
    }

    @Basic
    @Column(name = "COMPTA_S")
    public String getComptaS() {
        return comptaS;
    }

    public void setComptaS(String comptaS) {
        this.comptaS = comptaS;
    }

    @Basic
    @Column(name = "COMMISSION")
    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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
    @Column(name = "DAT_COMP")
    public Date getDatComp() {
        return datComp;
    }

    public void setDatComp(Date datComp) {
        this.datComp = datComp;
    }

    @Basic
    @Column(name = "OBSERV")
    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amort amort = (Amort) o;
        return id == amort.id &&
                num == amort.num &&
                codFrs == amort.codFrs &&
                Objects.equals(montant, amort.montant) &&
                Objects.equals(interet, amort.interet) &&
                Objects.equals(echeance, amort.echeance) &&
                Objects.equals(bank, amort.bank) &&
                Objects.equals(type, amort.type) &&
                Objects.equals(avisdb, amort.avisdb) &&
                Objects.equals(datAvd, amort.datAvd) &&
                Objects.equals(leasing, amort.leasing) &&
                Objects.equals(cptInt, amort.cptInt) &&
                Objects.equals(tresor, amort.tresor) &&
                Objects.equals(comptaS, amort.comptaS) &&
                Objects.equals(commission, amort.commission) &&
                Objects.equals(tva, amort.tva) &&
                Objects.equals(datComp, amort.datComp) &&
                Objects.equals(observ, amort.observ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, montant, interet, echeance, bank, type, avisdb, datAvd, leasing, codFrs, cptInt, tresor, comptaS, commission, tva, datComp, observ);
    }

    @Override
    public String toString() {
        return "Amort{" +
                "id=" + id +
                ", num=" + num +
                ", montant=" + montant +
                ", interet=" + interet +
                ", echeance=" + echeance +
                ", bank='" + bank + '\'' +
                ", type='" + type + '\'' +
                ", avisdb='" + avisdb + '\'' +
                ", datAvd=" + datAvd +
                ", leasing='" + leasing + '\'' +
                ", codFrs=" + codFrs +
                ", cptInt='" + cptInt + '\'' +
                ", tresor='" + tresor + '\'' +
                ", comptaS='" + comptaS + '\'' +
                ", commission=" + commission +
                ", tva=" + tva +
                ", datComp=" + datComp +
                ", observ='" + observ + '\'' +
                '}';
    }
}
