package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Fournis implements Serializable{

    @Id
    @Column(name = "COD_FRS")
    private long codFrs;
    private String raison;
    private String respon1;
    private String respon2;
    private String adresse;
    private String tel;
    private String fax;
    private String paye;
    private String modReg;
    private BigDecimal creance;
    private BigDecimal cumulAch;
    private BigDecimal affCours;
    private BigDecimal ristourne;
    private BigDecimal cumulRis;
    private BigDecimal cumulVen;
    private Byte marge;
    private BigDecimal remise;
    private BigDecimal fodec;
    private BigDecimal remTarif;
    private Short delLiv;
    private BigDecimal avoir;
    private BigDecimal cumTva;
    private BigDecimal cumulBl;
    private BigDecimal echeance;
    private BigDecimal chifAff;
    private BigDecimal facInst;
    private BigDecimal effNrec;
    private BigDecimal obligation;
    private BigDecimal regEsp;
    private BigDecimal regChq;
    private BigDecimal regEff;
    private BigDecimal effNech;
    private BigDecimal chqCir;
    private BigDecimal credDoc;
    private BigDecimal contAcc;
    private BigDecimal virement;
    private BigDecimal contDoc;
    private BigDecimal soldeDep;
    private BigDecimal payement;
    private BigDecimal escompte;
    private BigDecimal espece;
    private BigDecimal solde;
    private BigDecimal effEch;
    private Boolean echEff;
    private Byte posit;
    private BigDecimal totRegl;
    private String retenue;

    @Column(name = "LatGoogleMap")
    private String LatGoogleMap;
    @Column(name = "LngGoogleMap")
    private String LngGoogleMap;
    @Column(name = "LabelGoogleMap")
    private String LabelGoogleMap;
    //FK_KEYS***********************

    @OneToMany(mappedBy = "fournis", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<BonLiv> bonLivs;

    @OneToMany(mappedBy = "fournis", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Xcommand> xcommands;

    @OneToMany(mappedBy = "codFrs", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<BonPrep> bonPreps;
/*
    @ManyToMany(mappedBy = "Fourniss", fetch = FetchType.LAZY)
    private List<Article> articles;
*/
    //END FK_KEYS************************
    public Fournis(String raison, String respon1, String respon2, String adresse, String tel, String fax, String paye, String modReg, BigDecimal creance, BigDecimal cumulAch, BigDecimal affCours, BigDecimal ristourne, BigDecimal cumulRis, BigDecimal cumulVen, Byte marge, BigDecimal remise, BigDecimal fodec, BigDecimal remTarif,
     Short delLiv, BigDecimal avoir, BigDecimal cumTva, BigDecimal cumulBl, BigDecimal echeance, BigDecimal chifAff, BigDecimal facInst, BigDecimal effNrec, 
     BigDecimal obligation, BigDecimal regEsp, BigDecimal regChq, BigDecimal regEff, BigDecimal effNech, BigDecimal chqCir, BigDecimal credDoc, BigDecimal contAcc, 
     BigDecimal virement, BigDecimal contDoc, BigDecimal soldeDep, BigDecimal payement, BigDecimal escompte, BigDecimal espece, BigDecimal solde, BigDecimal effEch, 
     Boolean echEff, Byte posit, BigDecimal totRegl, String retenue, String LatGoogleMap, String LngGoogleMap, String LabelGoogleMap) {
        this.raison = raison;
        this.respon1 = respon1;
        this.respon2 = respon2;
        this.adresse = adresse;
        this.tel = tel;
        this.fax = fax;
        this.paye = paye;
        this.modReg = modReg;
        this.creance = creance;
        this.cumulAch = cumulAch;
        this.affCours = affCours;
        this.ristourne = ristourne;
        this.cumulRis = cumulRis;
        this.cumulVen = cumulVen;
        this.marge = marge;
        this.remise = remise;
        this.fodec = fodec;
        this.remTarif = remTarif;
        this.delLiv = delLiv;
        this.avoir = avoir;
        this.cumTva = cumTva;
        this.cumulBl = cumulBl;
        this.echeance = echeance;
        this.chifAff = chifAff;
        this.facInst = facInst;
        this.effNrec = effNrec;
        this.obligation = obligation;
        this.regEsp = regEsp;
        this.regChq = regChq;
        this.regEff = regEff;
        this.effNech = effNech;
        this.chqCir = chqCir;
        this.credDoc = credDoc;
        this.contAcc = contAcc;
        this.virement = virement;
        this.contDoc = contDoc;
        this.soldeDep = soldeDep;
        this.payement = payement;
        this.escompte = escompte;
        this.espece = espece;
        this.solde = solde;
        this.effEch = effEch;
        this.echEff = echEff;
        this.posit = posit;
        this.totRegl = totRegl;
        this.retenue = retenue;
        this.LatGoogleMap = LatGoogleMap;
        this.LngGoogleMap = LngGoogleMap;
    }

    public Fournis() {

    }

    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
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
    @Column(name = "RESPON1")
    public String getRespon1() {
        return respon1;
    }

    public void setRespon1(String respon1) {
        this.respon1 = respon1;
    }

    @Basic
    @Column(name = "RESPON2")
    public String getRespon2() {
        return respon2;
    }

    public void setRespon2(String respon2) {
        this.respon2 = respon2;
    }

    @Basic
    @Column(name = "ADRESSE")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "TEL")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "FAX")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
    @Column(name = "MOD_REG")
    public String getModReg() {
        return modReg;
    }

    public void setModReg(String modReg) {
        this.modReg = modReg;
    }

    @Basic
    @Column(name = "CREANCE")
    public BigDecimal getCreance() {
        return creance;
    }

    public void setCreance(BigDecimal creance) {
        this.creance = creance;
    }

    @Basic
    @Column(name = "CUMUL_ACH")
    public BigDecimal getCumulAch() {
        return cumulAch;
    }

    public void setCumulAch(BigDecimal cumulAch) {
        this.cumulAch = cumulAch;
    }

    @Basic
    @Column(name = "AFF_COURS")
    public BigDecimal getAffCours() {
        return affCours;
    }

    public void setAffCours(BigDecimal affCours) {
        this.affCours = affCours;
    }

    @Basic
    @Column(name = "RISTOURNE")
    public BigDecimal getRistourne() {
        return ristourne;
    }

    public void setRistourne(BigDecimal ristourne) {
        this.ristourne = ristourne;
    }

    @Basic
    @Column(name = "CUMUL_RIS")
    public BigDecimal getCumulRis() {
        return cumulRis;
    }

    public void setCumulRis(BigDecimal cumulRis) {
        this.cumulRis = cumulRis;
    }

    @Basic
    @Column(name = "CUMUL_VEN")
    public BigDecimal getCumulVen() {
        return cumulVen;
    }

    public void setCumulVen(BigDecimal cumulVen) {
        this.cumulVen = cumulVen;
    }

    @Basic
    @Column(name = "MARGE")
    public Byte getMarge() {
        return marge;
    }

    public void setMarge(Byte marge) {
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
    @Column(name = "FODEC")
    public BigDecimal getFodec() {
        return fodec;
    }

    public void setFodec(BigDecimal fodec) {
        this.fodec = fodec;
    }

    @Basic
    @Column(name = "REM_TARIF")
    public BigDecimal getRemTarif() {
        return remTarif;
    }

    public void setRemTarif(BigDecimal remTarif) {
        this.remTarif = remTarif;
    }

    @Basic
    @Column(name = "DEL_LIV")
    public Short getDelLiv() {
        return delLiv;
    }

    public void setDelLiv(Short delLiv) {
        this.delLiv = delLiv;
    }

    @Basic
    @Column(name = "AVOIR")
    public BigDecimal getAvoir() {
        return avoir;
    }

    public void setAvoir(BigDecimal avoir) {
        this.avoir = avoir;
    }

    @Basic
    @Column(name = "CUM_TVA")
    public BigDecimal getCumTva() {
        return cumTva;
    }

    public void setCumTva(BigDecimal cumTva) {
        this.cumTva = cumTva;
    }

    @Basic
    @Column(name = "CUMUL_BL")
    public BigDecimal getCumulBl() {
        return cumulBl;
    }

    public void setCumulBl(BigDecimal cumulBl) {
        this.cumulBl = cumulBl;
    }

    @Basic
    @Column(name = "ECHEANCE")
    public BigDecimal getEcheance() {
        return echeance;
    }

    public void setEcheance(BigDecimal echeance) {
        this.echeance = echeance;
    }

    @Basic
    @Column(name = "CHIF_AFF")
    public BigDecimal getChifAff() {
        return chifAff;
    }

    public void setChifAff(BigDecimal chifAff) {
        this.chifAff = chifAff;
    }

    @Basic
    @Column(name = "FAC_INST")
    public BigDecimal getFacInst() {
        return facInst;
    }

    public void setFacInst(BigDecimal facInst) {
        this.facInst = facInst;
    }

    @Basic
    @Column(name = "EFF_NREC")
    public BigDecimal getEffNrec() {
        return effNrec;
    }

    public void setEffNrec(BigDecimal effNrec) {
        this.effNrec = effNrec;
    }

    @Basic
    @Column(name = "OBLIGATION")
    public BigDecimal getObligation() {
        return obligation;
    }

    public void setObligation(BigDecimal obligation) {
        this.obligation = obligation;
    }

    @Basic
    @Column(name = "REG_ESP")
    public BigDecimal getRegEsp() {
        return regEsp;
    }

    public void setRegEsp(BigDecimal regEsp) {
        this.regEsp = regEsp;
    }

    @Basic
    @Column(name = "REG_CHQ")
    public BigDecimal getRegChq() {
        return regChq;
    }

    public void setRegChq(BigDecimal regChq) {
        this.regChq = regChq;
    }

    @Basic
    @Column(name = "REG_EFF")
    public BigDecimal getRegEff() {
        return regEff;
    }

    public void setRegEff(BigDecimal regEff) {
        this.regEff = regEff;
    }

    @Basic
    @Column(name = "EFF_NECH")
    public BigDecimal getEffNech() {
        return effNech;
    }

    public void setEffNech(BigDecimal effNech) {
        this.effNech = effNech;
    }

    @Basic
    @Column(name = "CHQ_CIR")
    public BigDecimal getChqCir() {
        return chqCir;
    }

    public void setChqCir(BigDecimal chqCir) {
        this.chqCir = chqCir;
    }

    @Basic
    @Column(name = "CRED_DOC")
    public BigDecimal getCredDoc() {
        return credDoc;
    }

    public void setCredDoc(BigDecimal credDoc) {
        this.credDoc = credDoc;
    }

    @Basic
    @Column(name = "CONT_ACC")
    public BigDecimal getContAcc() {
        return contAcc;
    }

    public void setContAcc(BigDecimal contAcc) {
        this.contAcc = contAcc;
    }

    @Basic
    @Column(name = "VIREMENT")
    public BigDecimal getVirement() {
        return virement;
    }

    public void setVirement(BigDecimal virement) {
        this.virement = virement;
    }

    @Basic
    @Column(name = "CONT_DOC")
    public BigDecimal getContDoc() {
        return contDoc;
    }

    public void setContDoc(BigDecimal contDoc) {
        this.contDoc = contDoc;
    }

    @Basic
    @Column(name = "SOLDE_DEP")
    public BigDecimal getSoldeDep() {
        return soldeDep;
    }

    public void setSoldeDep(BigDecimal soldeDep) {
        this.soldeDep = soldeDep;
    }

    @Basic
    @Column(name = "PAYEMENT")
    public BigDecimal getPayement() {
        return payement;
    }

    public void setPayement(BigDecimal payement) {
        this.payement = payement;
    }

    @Basic
    @Column(name = "ESCOMPTE")
    public BigDecimal getEscompte() {
        return escompte;
    }

    public void setEscompte(BigDecimal escompte) {
        this.escompte = escompte;
    }

    @Basic
    @Column(name = "ESPECE")
    public BigDecimal getEspece() {
        return espece;
    }

    public void setEspece(BigDecimal espece) {
        this.espece = espece;
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
    @Column(name = "EFF_ECH")
    public BigDecimal getEffEch() {
        return effEch;
    }

    public void setEffEch(BigDecimal effEch) {
        this.effEch = effEch;
    }

    @Basic
    @Column(name = "ECH_EFF")
    public Boolean getEchEff() {
        return echEff;
    }

    public void setEchEff(Boolean echEff) {
        this.echEff = echEff;
    }

    @Basic
    @Column(name = "POSIT")
    public Byte getPosit() {
        return posit;
    }

    public void setPosit(Byte posit) {
        this.posit = posit;
    }

    @Basic
    @Column(name = "TOT_REGL")
    public BigDecimal getTotRegl() {
        return totRegl;
    }

    public void setTotRegl(BigDecimal totRegl) {
        this.totRegl = totRegl;
    }

    @Basic
    @Column(name = "RETENUE")
    public String getRetenue() {
        return retenue;
    }

    public void setRetenue(String retenue) {
        this.retenue = retenue;
    }

    public void setBonLivs(List<BonLiv> bonLivs) {
        this.bonLivs = bonLivs;
    }

    public void setBonPreps(List<BonPrep> bonPreps) {
        this.bonPreps = bonPreps;
    }

    public String getLatGoogleMap() {
        return LatGoogleMap;
    }

    public void setLatGoogleMap(String latGoogleMap) {
        LatGoogleMap = latGoogleMap;
    }

    public String getLngGoogleMap() {
        return LngGoogleMap;
    }

    public void setLngGoogleMap(String lngGoogleMap) {
        LngGoogleMap = lngGoogleMap;
    }

    public String getLabelGoogleMap() {
        return LabelGoogleMap;
    }

    public void setLabelGoogleMap(String labelGoogleMap) {
        LabelGoogleMap = labelGoogleMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fournis fournis = (Fournis) o;
        return codFrs == fournis.codFrs &&
                Objects.equals(raison, fournis.raison) &&
                Objects.equals(respon1, fournis.respon1) &&
                Objects.equals(respon2, fournis.respon2) &&
                Objects.equals(adresse, fournis.adresse) &&
                Objects.equals(tel, fournis.tel) &&
                Objects.equals(fax, fournis.fax) &&
                Objects.equals(paye, fournis.paye) &&
                Objects.equals(modReg, fournis.modReg) &&
                Objects.equals(creance, fournis.creance) &&
                Objects.equals(cumulAch, fournis.cumulAch) &&
                Objects.equals(affCours, fournis.affCours) &&
                Objects.equals(ristourne, fournis.ristourne) &&
                Objects.equals(cumulRis, fournis.cumulRis) &&
                Objects.equals(cumulVen, fournis.cumulVen) &&
                Objects.equals(marge, fournis.marge) &&
                Objects.equals(remise, fournis.remise) &&
                Objects.equals(fodec, fournis.fodec) &&
                Objects.equals(remTarif, fournis.remTarif) &&
                Objects.equals(delLiv, fournis.delLiv) &&
                Objects.equals(avoir, fournis.avoir) &&
                Objects.equals(cumTva, fournis.cumTva) &&
                Objects.equals(cumulBl, fournis.cumulBl) &&
                Objects.equals(echeance, fournis.echeance) &&
                Objects.equals(chifAff, fournis.chifAff) &&
                Objects.equals(facInst, fournis.facInst) &&
                Objects.equals(effNrec, fournis.effNrec) &&
                Objects.equals(obligation, fournis.obligation) &&
                Objects.equals(regEsp, fournis.regEsp) &&
                Objects.equals(regChq, fournis.regChq) &&
                Objects.equals(regEff, fournis.regEff) &&
                Objects.equals(effNech, fournis.effNech) &&
                Objects.equals(chqCir, fournis.chqCir) &&
                Objects.equals(credDoc, fournis.credDoc) &&
                Objects.equals(contAcc, fournis.contAcc) &&
                Objects.equals(virement, fournis.virement) &&
                Objects.equals(contDoc, fournis.contDoc) &&
                Objects.equals(soldeDep, fournis.soldeDep) &&
                Objects.equals(payement, fournis.payement) &&
                Objects.equals(escompte, fournis.escompte) &&
                Objects.equals(espece, fournis.espece) &&
                Objects.equals(solde, fournis.solde) &&
                Objects.equals(effEch, fournis.effEch) &&
                Objects.equals(echEff, fournis.echEff) &&
                Objects.equals(posit, fournis.posit) &&
                Objects.equals(totRegl, fournis.totRegl) &&
                Objects.equals(retenue, fournis.retenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codFrs, raison, respon1, respon2, adresse, tel, fax, paye, modReg, creance, cumulAch, affCours, ristourne, cumulRis, cumulVen, marge, remise, fodec, remTarif, delLiv, avoir, cumTva, cumulBl, echeance, chifAff, facInst, effNrec, obligation, regEsp, regChq, regEff, effNech, chqCir, credDoc, contAcc, virement, contDoc, soldeDep, payement, escompte, espece, solde, effEch, echEff, posit, totRegl, retenue);
    }

    @Override
    public String toString() {
        return "Fournis{" +
                ", codFrs=" + codFrs +
                ", raison='" + raison + '\'' +
                ", respon1='" + respon1 + '\'' +
                ", respon2='" + respon2 + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", fax='" + fax + '\'' +
                ", paye='" + paye + '\'' +
                ", modReg='" + modReg + '\'' +
                ", creance=" + creance +
                ", cumulAch=" + cumulAch +
                ", affCours=" + affCours +
                ", ristourne=" + ristourne +
                ", cumulRis=" + cumulRis +
                ", cumulVen=" + cumulVen +
                ", marge=" + marge +
                ", remise=" + remise +
                ", fodec=" + fodec +
                ", remTarif=" + remTarif +
                ", delLiv=" + delLiv +
                ", avoir=" + avoir +
                ", cumTva=" + cumTva +
                ", cumulBl=" + cumulBl +
                ", echeance=" + echeance +
                ", chifAff=" + chifAff +
                ", facInst=" + facInst +
                ", effNrec=" + effNrec +
                ", obligation=" + obligation +
                ", regEsp=" + regEsp +
                ", regChq=" + regChq +
                ", regEff=" + regEff +
                ", effNech=" + effNech +
                ", chqCir=" + chqCir +
                ", credDoc=" + credDoc +
                ", contAcc=" + contAcc +
                ", virement=" + virement +
                ", contDoc=" + contDoc +
                ", soldeDep=" + soldeDep +
                ", payement=" + payement +
                ", escompte=" + escompte +
                ", espece=" + espece +
                ", solde=" + solde +
                ", effEch=" + effEch +
                ", echEff=" + echEff +
                ", posit=" + posit +
                ", totRegl=" + totRegl +
                ", retenue='" + retenue + '\'' +
                ", LatGoogleMap='" + LatGoogleMap + '\'' +
                ", totRegl=" + LngGoogleMap +
                ", LabelGoogleMap=" + LabelGoogleMap +
                '}';
    }

}
