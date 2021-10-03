package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "fac_term", schema = "testbd")
public class FacTerm {
    private long id;
    private long codUser;
    private String raison;
    private Date datFac;
    private BigDecimal netHt;
    private BigDecimal tva;
    private BigDecimal totTtc;
    private Date echeance;
    private BigDecimal xbase0;
    private BigDecimal xbase6;
    private BigDecimal xbase10;
    private BigDecimal xbase17;
    private BigDecimal xbase29;
    private BigDecimal xbase7;
    private BigDecimal xbase12;
    private BigDecimal xbase21;
    private BigDecimal xbase36;
    private BigDecimal xtva6;
    private BigDecimal xtva10;
    private BigDecimal xtva17;
    private BigDecimal xtva29;
    private BigDecimal xtva7;
    private BigDecimal xtva12;
    private BigDecimal xtva21;
    private BigDecimal xtva36;
    private String compta;
    private BigDecimal montTrs;
    private String numRis;
    private String numFac;
    private BigDecimal montProv;
    private BigDecimal montReg;
    private BigDecimal timbre;
    private String comptaS;
    private Date datComp;
    private BigDecimal montIrpp;
    private BigDecimal xbase19;
    private BigDecimal xtva19;
    private BigDecimal xbase13;
    private BigDecimal xtva13;
    private BigDecimal xbase7A;
    private BigDecimal xtva7A;
    private String codeTva;

    public FacTerm(long codUser, String raison, Date datFac, BigDecimal netHt, BigDecimal tva, BigDecimal totTtc, Date echeance, BigDecimal xbase0, BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17, BigDecimal xbase29, BigDecimal xbase7, BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36, BigDecimal xtva6, BigDecimal xtva10, BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7, BigDecimal xtva12, BigDecimal xtva21, BigDecimal xtva36, String compta, BigDecimal montTrs, String numRis, String numFac, BigDecimal montProv, BigDecimal montReg, BigDecimal timbre, String comptaS, Date datComp, BigDecimal montIrpp, BigDecimal xbase19, BigDecimal xtva19, BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7A, BigDecimal xtva7A, String codeTva) {
        this.codUser = codUser;
        this.raison = raison;
        this.datFac = datFac;
        this.netHt = netHt;
        this.tva = tva;
        this.totTtc = totTtc;
        this.echeance = echeance;
        this.xbase0 = xbase0;
        this.xbase6 = xbase6;
        this.xbase10 = xbase10;
        this.xbase17 = xbase17;
        this.xbase29 = xbase29;
        this.xbase7 = xbase7;
        this.xbase12 = xbase12;
        this.xbase21 = xbase21;
        this.xbase36 = xbase36;
        this.xtva6 = xtva6;
        this.xtva10 = xtva10;
        this.xtva17 = xtva17;
        this.xtva29 = xtva29;
        this.xtva7 = xtva7;
        this.xtva12 = xtva12;
        this.xtva21 = xtva21;
        this.xtva36 = xtva36;
        this.compta = compta;
        this.montTrs = montTrs;
        this.numRis = numRis;
        this.numFac = numFac;
        this.montProv = montProv;
        this.montReg = montReg;
        this.timbre = timbre;
        this.comptaS = comptaS;
        this.datComp = datComp;
        this.montIrpp = montIrpp;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        this.xbase7A = xbase7A;
        this.xtva7A = xtva7A;
        this.codeTva = codeTva;
    }

    public FacTerm() {

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
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
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
    @Column(name = "DAT_FAC")
    public Date getDatFac() {
        return datFac;
    }

    public void setDatFac(Date datFac) {
        this.datFac = datFac;
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
    @Column(name = "ECHEANCE")
    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    @Basic
    @Column(name = "XBASE0")
    public BigDecimal getXbase0() {
        return xbase0;
    }

    public void setXbase0(BigDecimal xbase0) {
        this.xbase0 = xbase0;
    }

    @Basic
    @Column(name = "XBASE6")
    public BigDecimal getXbase6() {
        return xbase6;
    }

    public void setXbase6(BigDecimal xbase6) {
        this.xbase6 = xbase6;
    }

    @Basic
    @Column(name = "XBASE10")
    public BigDecimal getXbase10() {
        return xbase10;
    }

    public void setXbase10(BigDecimal xbase10) {
        this.xbase10 = xbase10;
    }

    @Basic
    @Column(name = "XBASE17")
    public BigDecimal getXbase17() {
        return xbase17;
    }

    public void setXbase17(BigDecimal xbase17) {
        this.xbase17 = xbase17;
    }

    @Basic
    @Column(name = "XBASE29")
    public BigDecimal getXbase29() {
        return xbase29;
    }

    public void setXbase29(BigDecimal xbase29) {
        this.xbase29 = xbase29;
    }

    @Basic
    @Column(name = "XBASE7")
    public BigDecimal getXbase7() {
        return xbase7;
    }

    public void setXbase7(BigDecimal xbase7) {
        this.xbase7 = xbase7;
    }

    @Basic
    @Column(name = "XBASE12")
    public BigDecimal getXbase12() {
        return xbase12;
    }

    public void setXbase12(BigDecimal xbase12) {
        this.xbase12 = xbase12;
    }

    @Basic
    @Column(name = "XBASE21")
    public BigDecimal getXbase21() {
        return xbase21;
    }

    public void setXbase21(BigDecimal xbase21) {
        this.xbase21 = xbase21;
    }

    @Basic
    @Column(name = "XBASE36")
    public BigDecimal getXbase36() {
        return xbase36;
    }

    public void setXbase36(BigDecimal xbase36) {
        this.xbase36 = xbase36;
    }

    @Basic
    @Column(name = "XTVA6")
    public BigDecimal getXtva6() {
        return xtva6;
    }

    public void setXtva6(BigDecimal xtva6) {
        this.xtva6 = xtva6;
    }

    @Basic
    @Column(name = "XTVA10")
    public BigDecimal getXtva10() {
        return xtva10;
    }

    public void setXtva10(BigDecimal xtva10) {
        this.xtva10 = xtva10;
    }

    @Basic
    @Column(name = "XTVA17")
    public BigDecimal getXtva17() {
        return xtva17;
    }

    public void setXtva17(BigDecimal xtva17) {
        this.xtva17 = xtva17;
    }

    @Basic
    @Column(name = "XTVA29")
    public BigDecimal getXtva29() {
        return xtva29;
    }

    public void setXtva29(BigDecimal xtva29) {
        this.xtva29 = xtva29;
    }

    @Basic
    @Column(name = "XTVA7")
    public BigDecimal getXtva7() {
        return xtva7;
    }

    public void setXtva7(BigDecimal xtva7) {
        this.xtva7 = xtva7;
    }

    @Basic
    @Column(name = "XTVA12")
    public BigDecimal getXtva12() {
        return xtva12;
    }

    public void setXtva12(BigDecimal xtva12) {
        this.xtva12 = xtva12;
    }

    @Basic
    @Column(name = "XTVA21")
    public BigDecimal getXtva21() {
        return xtva21;
    }

    public void setXtva21(BigDecimal xtva21) {
        this.xtva21 = xtva21;
    }

    @Basic
    @Column(name = "XTVA36")
    public BigDecimal getXtva36() {
        return xtva36;
    }

    public void setXtva36(BigDecimal xtva36) {
        this.xtva36 = xtva36;
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
    @Column(name = "MONT_TRS")
    public BigDecimal getMontTrs() {
        return montTrs;
    }

    public void setMontTrs(BigDecimal montTrs) {
        this.montTrs = montTrs;
    }

    @Basic
    @Column(name = "NUM_RIS")
    public String getNumRis() {
        return numRis;
    }

    public void setNumRis(String numRis) {
        this.numRis = numRis;
    }

    @Column(name = "NUM_FAC")
    public String getNumFac() {
        return numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }

    @Basic
    @Column(name = "MONT_PROV")
    public BigDecimal getMontProv() {
        return montProv;
    }

    public void setMontProv(BigDecimal montProv) {
        this.montProv = montProv;
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
    @Column(name = "TIMBRE")
    public BigDecimal getTimbre() {
        return timbre;
    }

    public void setTimbre(BigDecimal timbre) {
        this.timbre = timbre;
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
    @Column(name = "DAT_COMP")
    public Date getDatComp() {
        return datComp;
    }

    public void setDatComp(Date datComp) {
        this.datComp = datComp;
    }

    @Basic
    @Column(name = "MONT_IRPP")
    public BigDecimal getMontIrpp() {
        return montIrpp;
    }

    public void setMontIrpp(BigDecimal montIrpp) {
        this.montIrpp = montIrpp;
    }

    @Basic
    @Column(name = "XBASE19")
    public BigDecimal getXbase19() {
        return xbase19;
    }

    public void setXbase19(BigDecimal xbase19) {
        this.xbase19 = xbase19;
    }

    @Basic
    @Column(name = "XTVA19")
    public BigDecimal getXtva19() {
        return xtva19;
    }

    public void setXtva19(BigDecimal xtva19) {
        this.xtva19 = xtva19;
    }

    @Basic
    @Column(name = "XBASE13")
    public BigDecimal getXbase13() {
        return xbase13;
    }

    public void setXbase13(BigDecimal xbase13) {
        this.xbase13 = xbase13;
    }

    @Basic
    @Column(name = "XTVA13")
    public BigDecimal getXtva13() {
        return xtva13;
    }

    public void setXtva13(BigDecimal xtva13) {
        this.xtva13 = xtva13;
    }

    @Basic
    @Column(name = "XBASE7A")
    public BigDecimal getXbase7A() {
        return xbase7A;
    }

    public void setXbase7A(BigDecimal xbase7A) {
        this.xbase7A = xbase7A;
    }

    @Basic
    @Column(name = "XTVA7A")
    public BigDecimal getXtva7A() {
        return xtva7A;
    }

    public void setXtva7A(BigDecimal xtva7A) {
        this.xtva7A = xtva7A;
    }

    @Basic
    @Column(name = "CODE_TVA")
    public String getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(String codeTva) {
        this.codeTva = codeTva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacTerm facTerm = (FacTerm) o;
        return id == facTerm.id &&
                codUser == facTerm.codUser &&
                Objects.equals(raison, facTerm.raison) &&
                Objects.equals(datFac, facTerm.datFac) &&
                Objects.equals(netHt, facTerm.netHt) &&
                Objects.equals(tva, facTerm.tva) &&
                Objects.equals(totTtc, facTerm.totTtc) &&
                Objects.equals(echeance, facTerm.echeance) &&
                Objects.equals(xbase0, facTerm.xbase0) &&
                Objects.equals(xbase6, facTerm.xbase6) &&
                Objects.equals(xbase10, facTerm.xbase10) &&
                Objects.equals(xbase17, facTerm.xbase17) &&
                Objects.equals(xbase29, facTerm.xbase29) &&
                Objects.equals(xbase7, facTerm.xbase7) &&
                Objects.equals(xbase12, facTerm.xbase12) &&
                Objects.equals(xbase21, facTerm.xbase21) &&
                Objects.equals(xbase36, facTerm.xbase36) &&
                Objects.equals(xtva6, facTerm.xtva6) &&
                Objects.equals(xtva10, facTerm.xtva10) &&
                Objects.equals(xtva17, facTerm.xtva17) &&
                Objects.equals(xtva29, facTerm.xtva29) &&
                Objects.equals(xtva7, facTerm.xtva7) &&
                Objects.equals(xtva12, facTerm.xtva12) &&
                Objects.equals(xtva21, facTerm.xtva21) &&
                Objects.equals(xtva36, facTerm.xtva36) &&
                Objects.equals(compta, facTerm.compta) &&
                Objects.equals(montTrs, facTerm.montTrs) &&
                Objects.equals(numRis, facTerm.numRis) &&
                Objects.equals(numFac, facTerm.numFac) &&
                Objects.equals(montProv, facTerm.montProv) &&
                Objects.equals(montReg, facTerm.montReg) &&
                Objects.equals(timbre, facTerm.timbre) &&
                Objects.equals(comptaS, facTerm.comptaS) &&
                Objects.equals(datComp, facTerm.datComp) &&
                Objects.equals(montIrpp, facTerm.montIrpp) &&
                Objects.equals(xbase19, facTerm.xbase19) &&
                Objects.equals(xtva19, facTerm.xtva19) &&
                Objects.equals(xbase13, facTerm.xbase13) &&
                Objects.equals(xtva13, facTerm.xtva13) &&
                Objects.equals(xbase7A, facTerm.xbase7A) &&
                Objects.equals(xtva7A, facTerm.xtva7A) &&
                Objects.equals(codeTva, facTerm.codeTva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codUser, raison, datFac, netHt, tva, totTtc, echeance, xbase0, xbase6, xbase10, xbase17, xbase29, xbase7, xbase12, xbase21, xbase36, xtva6, xtva10, xtva17, xtva29, xtva7, xtva12, xtva21, xtva36, compta, montTrs, numRis, numFac, montProv, montReg, timbre, comptaS, datComp, montIrpp, xbase19, xtva19, xbase13, xtva13, xbase7A, xtva7A, codeTva);
    }

    @Override
    public String toString() {
        return "FacTerm{" +
                "id=" + id +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", datFac=" + datFac +
                ", netHt=" + netHt +
                ", tva=" + tva +
                ", totTtc=" + totTtc +
                ", echeance=" + echeance +
                ", xbase0=" + xbase0 +
                ", xbase6=" + xbase6 +
                ", xbase10=" + xbase10 +
                ", xbase17=" + xbase17 +
                ", xbase29=" + xbase29 +
                ", xbase7=" + xbase7 +
                ", xbase12=" + xbase12 +
                ", xbase21=" + xbase21 +
                ", xbase36=" + xbase36 +
                ", xtva6=" + xtva6 +
                ", xtva10=" + xtva10 +
                ", xtva17=" + xtva17 +
                ", xtva29=" + xtva29 +
                ", xtva7=" + xtva7 +
                ", xtva12=" + xtva12 +
                ", xtva21=" + xtva21 +
                ", xtva36=" + xtva36 +
                ", compta='" + compta + '\'' +
                ", montTrs=" + montTrs +
                ", numRis='" + numRis + '\'' +
                ", numFac='" + numFac + '\'' +
                ", montProv=" + montProv +
                ", montReg=" + montReg +
                ", timbre=" + timbre +
                ", comptaS='" + comptaS + '\'' +
                ", datComp=" + datComp +
                ", montIrpp=" + montIrpp +
                ", xbase19=" + xbase19 +
                ", xtva19=" + xtva19 +
                ", xbase13=" + xbase13 +
                ", xtva13=" + xtva13 +
                ", xbase7A=" + xbase7A +
                ", xtva7A=" + xtva7A +
                ", codeTva='" + codeTva + '\'' +
                '}';
    }
}
