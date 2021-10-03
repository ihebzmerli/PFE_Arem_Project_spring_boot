package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "fac_comp", schema = "testbd")
public class FacComp {
    private int numFac;
    private Date datFac;
    private long codUser;
    private String raison;
    private BigDecimal brutHt;
    private BigDecimal tauxRem;
    private BigDecimal montRem;
    private BigDecimal netHt;
    private BigDecimal montTva;
    private BigDecimal totTtc;
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
    private String regle;
    private String compta;
    private BigDecimal avance;
    private BigDecimal plusV;
    private BigDecimal tauxRes;
    private String codeTva;
    private String livreur;
    private String liv;
    private String pointage;
    private BigDecimal timbre;
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

    public FacComp(Date datFac, long codUser, String raison, BigDecimal brutHt, BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc, BigDecimal xbase0, BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17, BigDecimal xbase29, BigDecimal xbase7, BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36, BigDecimal xtva6, BigDecimal xtva10, BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7, BigDecimal xtva12, BigDecimal xtva21, BigDecimal xtva36, String regle, String compta, BigDecimal avance, BigDecimal plusV, BigDecimal tauxRes, String codeTva, String livreur, String liv, String pointage, BigDecimal timbre, String comptaS, Date datComp, BigDecimal montIrpp, String poste, String centre, BigDecimal xbase19, BigDecimal xtva19, BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7A, BigDecimal xtva7A) {
        this.datFac = datFac;
        this.codUser = codUser;
        this.raison = raison;
        this.brutHt = brutHt;
        this.tauxRem = tauxRem;
        this.montRem = montRem;
        this.netHt = netHt;
        this.montTva = montTva;
        this.totTtc = totTtc;
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
        this.regle = regle;
        this.compta = compta;
        this.avance = avance;
        this.plusV = plusV;
        this.tauxRes = tauxRes;
        this.codeTva = codeTva;
        this.livreur = livreur;
        this.liv = liv;
        this.pointage = pointage;
        this.timbre = timbre;
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
    }

    public FacComp() {

    }

    @Id
    @Column(name = "NUM_FAC")
    public int getNumFac() {
        return numFac;
    }

    public void setNumFac(int numFac) {
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
    @Column(name = "BRUT_HT")
    public BigDecimal getBrutHt() {
        return brutHt;
    }

    public void setBrutHt(BigDecimal brutHt) {
        this.brutHt = brutHt;
    }

    @Basic
    @Column(name = "TAUX_REM")
    public BigDecimal getTauxRem() {
        return tauxRem;
    }

    public void setTauxRem(BigDecimal tauxRem) {
        this.tauxRem = tauxRem;
    }

    @Basic
    @Column(name = "MONT_REM")
    public BigDecimal getMontRem() {
        return montRem;
    }

    public void setMontRem(BigDecimal montRem) {
        this.montRem = montRem;
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
    @Column(name = "TOT_TTC")
    public BigDecimal getTotTtc() {
        return totTtc;
    }

    public void setTotTtc(BigDecimal totTtc) {
        this.totTtc = totTtc;
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
    @Column(name = "REGLE")
    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
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
    @Column(name = "AVANCE")
    public BigDecimal getAvance() {
        return avance;
    }

    public void setAvance(BigDecimal avance) {
        this.avance = avance;
    }

    @Basic
    @Column(name = "PLUS_V")
    public BigDecimal getPlusV() {
        return plusV;
    }

    public void setPlusV(BigDecimal plusV) {
        this.plusV = plusV;
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
    @Column(name = "LIV")
    public String getLiv() {
        return liv;
    }

    public void setLiv(String liv) {
        this.liv = liv;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacComp facComp = (FacComp) o;
        return numFac == facComp.numFac &&
                codUser == facComp.codUser &&
                Objects.equals(datFac, facComp.datFac) &&
                Objects.equals(raison, facComp.raison) &&
                Objects.equals(brutHt, facComp.brutHt) &&
                Objects.equals(tauxRem, facComp.tauxRem) &&
                Objects.equals(montRem, facComp.montRem) &&
                Objects.equals(netHt, facComp.netHt) &&
                Objects.equals(montTva, facComp.montTva) &&
                Objects.equals(totTtc, facComp.totTtc) &&
                Objects.equals(xbase0, facComp.xbase0) &&
                Objects.equals(xbase6, facComp.xbase6) &&
                Objects.equals(xbase10, facComp.xbase10) &&
                Objects.equals(xbase17, facComp.xbase17) &&
                Objects.equals(xbase29, facComp.xbase29) &&
                Objects.equals(xbase7, facComp.xbase7) &&
                Objects.equals(xbase12, facComp.xbase12) &&
                Objects.equals(xbase21, facComp.xbase21) &&
                Objects.equals(xbase36, facComp.xbase36) &&
                Objects.equals(xtva6, facComp.xtva6) &&
                Objects.equals(xtva10, facComp.xtva10) &&
                Objects.equals(xtva17, facComp.xtva17) &&
                Objects.equals(xtva29, facComp.xtva29) &&
                Objects.equals(xtva7, facComp.xtva7) &&
                Objects.equals(xtva12, facComp.xtva12) &&
                Objects.equals(xtva21, facComp.xtva21) &&
                Objects.equals(xtva36, facComp.xtva36) &&
                Objects.equals(regle, facComp.regle) &&
                Objects.equals(compta, facComp.compta) &&
                Objects.equals(avance, facComp.avance) &&
                Objects.equals(plusV, facComp.plusV) &&
                Objects.equals(tauxRes, facComp.tauxRes) &&
                Objects.equals(codeTva, facComp.codeTva) &&
                Objects.equals(livreur, facComp.livreur) &&
                Objects.equals(liv, facComp.liv) &&
                Objects.equals(pointage, facComp.pointage) &&
                Objects.equals(timbre, facComp.timbre) &&
                Objects.equals(comptaS, facComp.comptaS) &&
                Objects.equals(datComp, facComp.datComp) &&
                Objects.equals(montIrpp, facComp.montIrpp) &&
                Objects.equals(poste, facComp.poste) &&
                Objects.equals(centre, facComp.centre) &&
                Objects.equals(xbase19, facComp.xbase19) &&
                Objects.equals(xtva19, facComp.xtva19) &&
                Objects.equals(xbase13, facComp.xbase13) &&
                Objects.equals(xtva13, facComp.xtva13) &&
                Objects.equals(xbase7A, facComp.xbase7A) &&
                Objects.equals(xtva7A, facComp.xtva7A);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFac, datFac, codUser, raison, brutHt, tauxRem, montRem, netHt, montTva, totTtc, xbase0, xbase6, xbase10, xbase17, xbase29, xbase7, xbase12, xbase21, xbase36, xtva6, xtva10, xtva17, xtva29, xtva7, xtva12, xtva21, xtva36, regle, compta, avance, plusV, tauxRes, codeTva, livreur, liv, pointage, timbre, comptaS, datComp, montIrpp, poste, centre, xbase19, xtva19, xbase13, xtva13, xbase7A, xtva7A);
    }

    @Override
    public String toString() {
        return "FacComp{" +
                "numFac=" + numFac +
                ", datFac=" + datFac +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", brutHt=" + brutHt +
                ", tauxRem=" + tauxRem +
                ", montRem=" + montRem +
                ", netHt=" + netHt +
                ", montTva=" + montTva +
                ", totTtc=" + totTtc +
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
                ", regle='" + regle + '\'' +
                ", compta='" + compta + '\'' +
                ", avance=" + avance +
                ", plusV=" + plusV +
                ", tauxRes=" + tauxRes +
                ", codeTva='" + codeTva + '\'' +
                ", livreur='" + livreur + '\'' +
                ", liv='" + liv + '\'' +
                ", pointage='" + pointage + '\'' +
                ", timbre=" + timbre +
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
                '}';
    }
}
