package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Avoir {
    private long numAvr;
    private String typAvr;
    private long numDoc;
    private Date datAvr;
    private long codUser;
    private String raison;
    private BigDecimal montAvr;
    private BigDecimal netHt;
    private BigDecimal montTva;
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
    private BigDecimal xbase1;
    private BigDecimal xbase2;
    private BigDecimal xbase3;
    private BigDecimal xbase4;
    private BigDecimal xbase5;
    private BigDecimal xtva1;
    private BigDecimal xtva2;
    private BigDecimal xtva3;
    private BigDecimal xtva4;
    private String compta;
    private String solde;
    private BigDecimal moinV;
    private BigDecimal tauxRes;
    private String codeTva;
    private String livreur;
    private String regImp;
    private BigDecimal montReg;
    private String pointage;
    private String numRis;
    private String motif;
    private String comptaS;
    private Date datComp;
    private BigDecimal montIrpp;
    private String poste;
    private String centre;
    private BigDecimal xbase19;
    private BigDecimal xtva19;
    private BigDecimal xbase13;
    private BigDecimal xtva13;
    private BigDecimal xbase7A;
    private BigDecimal xtva7A;
    private String numBon;

    public Avoir(String typAvr, long numDoc, Date datAvr, long codUser, String raison, BigDecimal montAvr, BigDecimal netHt, BigDecimal montTva, BigDecimal xbase0, BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17, BigDecimal xbase29, BigDecimal xbase7, BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36, BigDecimal xtva6, BigDecimal xtva10, BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7, BigDecimal xtva12, BigDecimal xtva21, BigDecimal xtva36, BigDecimal xbase1, BigDecimal xbase2, BigDecimal xbase3, BigDecimal xbase4, BigDecimal xbase5, BigDecimal xtva1, BigDecimal xtva2, BigDecimal xtva3, BigDecimal xtva4, String compta, String solde, BigDecimal moinV, BigDecimal tauxRes, String codeTva, String livreur, String regImp, BigDecimal montReg, String pointage, String numRis, String motif, String comptaS, Date datComp, BigDecimal montIrpp, String poste, String centre, BigDecimal xbase19, BigDecimal xtva19, BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7A, BigDecimal xtva7A, String numBon) {
        this.typAvr = typAvr;
        this.numDoc = numDoc;
        this.datAvr = datAvr;
        this.codUser = codUser;
        this.raison = raison;
        this.montAvr = montAvr;
        this.netHt = netHt;
        this.montTva = montTva;
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
        this.xbase1 = xbase1;
        this.xbase2 = xbase2;
        this.xbase3 = xbase3;
        this.xbase4 = xbase4;
        this.xbase5 = xbase5;
        this.xtva1 = xtva1;
        this.xtva2 = xtva2;
        this.xtva3 = xtva3;
        this.xtva4 = xtva4;
        this.compta = compta;
        this.solde = solde;
        this.moinV = moinV;
        this.tauxRes = tauxRes;
        this.codeTva = codeTva;
        this.livreur = livreur;
        this.regImp = regImp;
        this.montReg = montReg;
        this.pointage = pointage;
        this.numRis = numRis;
        this.motif = motif;
        this.comptaS = comptaS;
        this.datComp = datComp;
        this.montIrpp = montIrpp;
        this.poste = poste;
        this.centre = centre;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        this.xbase7A = xbase7A;
        this.xtva7A = xtva7A;
        this.numBon = numBon;
    }

    public Avoir() {

    }

    @Id
    @Column(name = "NUM_AVR")
    public long getNumAvr() {
        return numAvr;
    }

    public void setNumAvr(long numAvr) {
        this.numAvr = numAvr;
    }

    @Basic
    @Column(name = "TYP_AVR")
    public String getTypAvr() {
        return typAvr;
    }

    public void setTypAvr(String typAvr) {
        this.typAvr = typAvr;
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
    @Column(name = "DAT_AVR")
    public Date getDatAvr() {
        return datAvr;
    }

    public void setDatAvr(Date datAvr) {
        this.datAvr = datAvr;
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
    @Column(name = "MONT_AVR")
    public BigDecimal getMontAvr() {
        return montAvr;
    }

    public void setMontAvr(BigDecimal montAvr) {
        this.montAvr = montAvr;
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
    @Column(name = "MONT_TVA")
    public BigDecimal getMontTva() {
        return montTva;
    }

    public void setMontTva(BigDecimal montTva) {
        this.montTva = montTva;
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
    @Column(name = "XBASE1")
    public BigDecimal getXbase1() {
        return xbase1;
    }

    public void setXbase1(BigDecimal xbase1) {
        this.xbase1 = xbase1;
    }

    @Basic
    @Column(name = "XBASE2")
    public BigDecimal getXbase2() {
        return xbase2;
    }

    public void setXbase2(BigDecimal xbase2) {
        this.xbase2 = xbase2;
    }

    @Basic
    @Column(name = "XBASE3")
    public BigDecimal getXbase3() {
        return xbase3;
    }

    public void setXbase3(BigDecimal xbase3) {
        this.xbase3 = xbase3;
    }

    @Basic
    @Column(name = "XBASE4")
    public BigDecimal getXbase4() {
        return xbase4;
    }

    public void setXbase4(BigDecimal xbase4) {
        this.xbase4 = xbase4;
    }

    @Basic
    @Column(name = "XBASE5")
    public BigDecimal getXbase5() {
        return xbase5;
    }

    public void setXbase5(BigDecimal xbase5) {
        this.xbase5 = xbase5;
    }

    @Basic
    @Column(name = "XTVA1")
    public BigDecimal getXtva1() {
        return xtva1;
    }

    public void setXtva1(BigDecimal xtva1) {
        this.xtva1 = xtva1;
    }

    @Basic
    @Column(name = "XTVA2")
    public BigDecimal getXtva2() {
        return xtva2;
    }

    public void setXtva2(BigDecimal xtva2) {
        this.xtva2 = xtva2;
    }

    @Basic
    @Column(name = "XTVA3")
    public BigDecimal getXtva3() {
        return xtva3;
    }

    public void setXtva3(BigDecimal xtva3) {
        this.xtva3 = xtva3;
    }

    @Basic
    @Column(name = "XTVA4")
    public BigDecimal getXtva4() {
        return xtva4;
    }

    public void setXtva4(BigDecimal xtva4) {
        this.xtva4 = xtva4;
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
    @Column(name = "SOLDE")
    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    @Basic
    @Column(name = "MOIN_V")
    public BigDecimal getMoinV() {
        return moinV;
    }

    public void setMoinV(BigDecimal moinV) {
        this.moinV = moinV;
    }

    @Basic
    @Column(name = "TAUX_RES")
    public BigDecimal getTauxRes() {
        return tauxRes;
    }

    public void setTauxRes(BigDecimal tauxRes) {
        this.tauxRes = tauxRes;
    }

    @Basic
    @Column(name = "CODE_TVA")
    public String getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(String codeTva) {
        this.codeTva = codeTva;
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
    @Column(name = "REG_IMP")
    public String getRegImp() {
        return regImp;
    }

    public void setRegImp(String regImp) {
        this.regImp = regImp;
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
    @Column(name = "POINTAGE")
    public String getPointage() {
        return pointage;
    }

    public void setPointage(String pointage) {
        this.pointage = pointage;
    }

    @Basic
    @Column(name = "NUM_RIS")
    public String getNumRis() {
        return numRis;
    }

    public void setNumRis(String numRis) {
        this.numRis = numRis;
    }

    @Basic
    @Column(name = "MOTIF")
    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
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
    @Column(name = "NUM_BON")
    public String getNumBon() {
        return numBon;
    }

    public void setNumBon(String numBon) {
        this.numBon = numBon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avoir avoir = (Avoir) o;
        return numAvr == avoir.numAvr &&
                numDoc == avoir.numDoc &&
                codUser == avoir.codUser &&
                Objects.equals(typAvr, avoir.typAvr) &&
                Objects.equals(datAvr, avoir.datAvr) &&
                Objects.equals(raison, avoir.raison) &&
                Objects.equals(montAvr, avoir.montAvr) &&
                Objects.equals(netHt, avoir.netHt) &&
                Objects.equals(montTva, avoir.montTva) &&
                Objects.equals(xbase0, avoir.xbase0) &&
                Objects.equals(xbase6, avoir.xbase6) &&
                Objects.equals(xbase10, avoir.xbase10) &&
                Objects.equals(xbase17, avoir.xbase17) &&
                Objects.equals(xbase29, avoir.xbase29) &&
                Objects.equals(xbase7, avoir.xbase7) &&
                Objects.equals(xbase12, avoir.xbase12) &&
                Objects.equals(xbase21, avoir.xbase21) &&
                Objects.equals(xbase36, avoir.xbase36) &&
                Objects.equals(xtva6, avoir.xtva6) &&
                Objects.equals(xtva10, avoir.xtva10) &&
                Objects.equals(xtva17, avoir.xtva17) &&
                Objects.equals(xtva29, avoir.xtva29) &&
                Objects.equals(xtva7, avoir.xtva7) &&
                Objects.equals(xtva12, avoir.xtva12) &&
                Objects.equals(xtva21, avoir.xtva21) &&
                Objects.equals(xtva36, avoir.xtva36) &&
                Objects.equals(xbase1, avoir.xbase1) &&
                Objects.equals(xbase2, avoir.xbase2) &&
                Objects.equals(xbase3, avoir.xbase3) &&
                Objects.equals(xbase4, avoir.xbase4) &&
                Objects.equals(xbase5, avoir.xbase5) &&
                Objects.equals(xtva1, avoir.xtva1) &&
                Objects.equals(xtva2, avoir.xtva2) &&
                Objects.equals(xtva3, avoir.xtva3) &&
                Objects.equals(xtva4, avoir.xtva4) &&
                Objects.equals(compta, avoir.compta) &&
                Objects.equals(solde, avoir.solde) &&
                Objects.equals(moinV, avoir.moinV) &&
                Objects.equals(tauxRes, avoir.tauxRes) &&
                Objects.equals(codeTva, avoir.codeTva) &&
                Objects.equals(livreur, avoir.livreur) &&
                Objects.equals(regImp, avoir.regImp) &&
                Objects.equals(montReg, avoir.montReg) &&
                Objects.equals(pointage, avoir.pointage) &&
                Objects.equals(numRis, avoir.numRis) &&
                Objects.equals(motif, avoir.motif) &&
                Objects.equals(comptaS, avoir.comptaS) &&
                Objects.equals(datComp, avoir.datComp) &&
                Objects.equals(montIrpp, avoir.montIrpp) &&
                Objects.equals(poste, avoir.poste) &&
                Objects.equals(centre, avoir.centre) &&
                Objects.equals(xbase19, avoir.xbase19) &&
                Objects.equals(xtva19, avoir.xtva19) &&
                Objects.equals(xbase13, avoir.xbase13) &&
                Objects.equals(xtva13, avoir.xtva13) &&
                Objects.equals(xbase7A, avoir.xbase7A) &&
                Objects.equals(xtva7A, avoir.xtva7A) &&
                Objects.equals(numBon, avoir.numBon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAvr, typAvr, numDoc, datAvr, codUser, raison, montAvr, netHt, montTva, xbase0, xbase6, xbase10, xbase17, xbase29, xbase7, xbase12, xbase21, xbase36, xtva6, xtva10, xtva17, xtva29, xtva7, xtva12, xtva21, xtva36, xbase1, xbase2, xbase3, xbase4, xbase5, xtva1, xtva2, xtva3, xtva4, compta, solde, moinV, tauxRes, codeTva, livreur, regImp, montReg, pointage, numRis, motif, comptaS, datComp, montIrpp, poste, centre, xbase19, xtva19, xbase13, xtva13, xbase7A, xtva7A, numBon);
    }

    @Override
    public String toString() {
        return "Avoir{" +
                "numAvr=" + numAvr +
                ", typAvr='" + typAvr + '\'' +
                ", numDoc=" + numDoc +
                ", datAvr=" + datAvr +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", montAvr=" + montAvr +
                ", netHt=" + netHt +
                ", montTva=" + montTva +
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
                ", xbase1=" + xbase1 +
                ", xbase2=" + xbase2 +
                ", xbase3=" + xbase3 +
                ", xbase4=" + xbase4 +
                ", xbase5=" + xbase5 +
                ", xtva1=" + xtva1 +
                ", xtva2=" + xtva2 +
                ", xtva3=" + xtva3 +
                ", xtva4=" + xtva4 +
                ", compta='" + compta + '\'' +
                ", solde='" + solde + '\'' +
                ", moinV=" + moinV +
                ", tauxRes=" + tauxRes +
                ", codeTva='" + codeTva + '\'' +
                ", livreur='" + livreur + '\'' +
                ", regImp='" + regImp + '\'' +
                ", montReg=" + montReg +
                ", pointage='" + pointage + '\'' +
                ", numRis='" + numRis + '\'' +
                ", motif='" + motif + '\'' +
                ", comptaS='" + comptaS + '\'' +
                ", datComp=" + datComp +
                ", montIrpp=" + montIrpp +
                ", poste='" + poste + '\'' +
                ", centre='" + centre + '\'' +
                ", xbase19=" + xbase19 +
                ", xtva19=" + xtva19 +
                ", xbase13=" + xbase13 +
                ", xtva13=" + xtva13 +
                ", xbase7A=" + xbase7A +
                ", xtva7A=" + xtva7A +
                ", numBon='" + numBon + '\'' +
                '}';
    }
}
