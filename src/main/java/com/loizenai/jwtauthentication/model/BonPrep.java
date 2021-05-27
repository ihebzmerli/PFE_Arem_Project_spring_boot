package com.loizenai.jwtauthentication.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "bon_prep", schema = "testbd")
public class BonPrep implements Serializable{

    @Id 
    @Column(name = "NUM_BON_PREP")
    private String numBon;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_BON")
    @LastModifiedDate
    private Timestamp datBon;


    //FK_KEYS***********************

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bonPreps_articles",
            joinColumns = {
                    @JoinColumn(name = "NUM_BON_PREP", referencedColumnName = "NUM_BON_PREP",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "COD_ART", referencedColumnName = "COD_ART",
                            nullable = true, updatable = false)})
    private List<Article> articles;   


    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "bonprep_detEmbas", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<DetEmba> detEmbas;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "codFrs", nullable = true)
    private Fournis codFrs;
/*
    @OneToOne(mappedBy = "bonprep_detPreps", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private DetPrep detPreps;
*/


    //END FK_KEYS************************
    @Column(name = "COD_CLI")
    private String nomprenomCli;

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

    @Column(name = "PLUS_V")
    private BigDecimal plusV;
    private BigDecimal tauxRes;
    private BigDecimal montTrs;
    private String liv;
    private String pointage;

    private String natDoc;
    private String codeTva;
    private String adresse;
    private String point;
    private String aideMag;
    private String embal;
    private String prep;
    private String poste;
    private String centre;
    private BigDecimal xbase19;
    private BigDecimal xtva19;
    private BigDecimal xbase13;
    private BigDecimal xtva13;
    private BigDecimal xbase7A;
    private BigDecimal xtva7A;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "NAT_LIV")
    private NatLiv natLiv;
    public enum NatLiv{
        sur_comptoir,
        livraison
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "AVANTAGE")
    private AVANTAGE aven_tage;
    public enum AVANTAGE{
        sur_le_champ,
        sur_un_delay,
        n_existe_pas
    }


    public BonPrep() {

    }

    public BonPrep(Timestamp datBon, String raison, BigDecimal brutHt,
            BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc,
             BigDecimal xbase0, BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17,
            BigDecimal xbase29, BigDecimal xbase7, BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36,
            BigDecimal xtva6, BigDecimal xtva10, BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7,
            BigDecimal xtva12, BigDecimal xtva21, BigDecimal xtva36, BigDecimal plusV, BigDecimal tauxRes,
            BigDecimal montTrs, String liv, String pointage, NatLiv natLiv,
            String natDoc, String codeTva, String adresse, String point, String aideMag, String embal, 
            String prep, String poste, String centre, BigDecimal xbase19, BigDecimal xtva19,
            BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7a, BigDecimal xtva7a) {
        this.datBon = datBon;
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
        this.plusV = plusV;
        this.tauxRes = tauxRes;
        this.montTrs = montTrs;
        this.liv = liv;
        this.pointage = pointage;
        this.natLiv = natLiv;
        this.natDoc = natDoc;
        this.codeTva = codeTva;
        this.adresse = adresse;
        this.point = point;
        this.aideMag = aideMag;
        this.embal = embal;
        this.prep = prep;
        this.poste = poste;
        this.centre = centre;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        this.xbase7A = xbase7a;
        this.xtva7A = xtva7a;
    }

    public BonPrep(Timestamp datBon, User user, String raison, BigDecimal brutHt,
            BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc,
            BigDecimal xbase0, BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17,
            BigDecimal xbase29, BigDecimal xbase7, BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36,
            BigDecimal xtva6, BigDecimal xtva10, BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7,
            BigDecimal xtva12, BigDecimal xtva21, BigDecimal xtva36, BigDecimal plusV, BigDecimal tauxRes,
            BigDecimal montTrs, String liv, String pointage, NatLiv natLiv,
            String natDoc, String codeTva, String adresse, String point, String aideMag, String embal,
            String prep, String poste, String centre, BigDecimal xbase19, BigDecimal xtva19,
            BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7a, BigDecimal xtva7a) {
        this.datBon = datBon;
        this.user = user;
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
        this.plusV = plusV;
        this.tauxRes = tauxRes;
        this.montTrs = montTrs;
        this.liv = liv;
        this.pointage = pointage;
        this.natLiv = natLiv;
        this.natDoc = natDoc;
        this.codeTva = codeTva;
        this.adresse = adresse;
        this.point = point;
        this.aideMag = aideMag;
        this.embal = embal;
        this.prep = prep;
        this.poste = poste;
        this.centre = centre;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        this.xbase7A = xbase7a;
        this.xtva7A = xtva7a;
    }
    


    public BonPrep(String numBon, Timestamp datBon, List<Article> articles, User user, List<DetEmba> detEmbas,
            Fournis codFrs, String nomprenomCli, String raison, BigDecimal brutHt, BigDecimal tauxRem,
            BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc, BigDecimal xbase0,
            BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17, BigDecimal xbase29, BigDecimal xbase7,
            BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36, BigDecimal xtva6, BigDecimal xtva10,
            BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7, BigDecimal xtva12, BigDecimal xtva21,
            BigDecimal xtva36, BigDecimal plusV, BigDecimal tauxRes, BigDecimal montTrs, String liv, String pointage,
            String natDoc, String codeTva, String adresse, String point, String aideMag, String embal, String prep,
            String poste, String centre, BigDecimal xbase19, BigDecimal xtva19, BigDecimal xbase13, BigDecimal xtva13,
            BigDecimal xbase7a, BigDecimal xtva7a, NatLiv natLiv, AVANTAGE aven_tage) {
        this.numBon = numBon;
        this.datBon = datBon;
        this.articles = articles;
        this.user = user;
        this.detEmbas = detEmbas;
        this.codFrs = codFrs;
        this.nomprenomCli = nomprenomCli;
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
        this.plusV = plusV;
        this.tauxRes = tauxRes;
        this.montTrs = montTrs;
        this.liv = liv;
        this.pointage = pointage;
        this.natDoc = natDoc;
        this.codeTva = codeTva;
        this.adresse = adresse;
        this.point = point;
        this.aideMag = aideMag;
        this.embal = embal;
        this.prep = prep;
        this.poste = poste;
        this.centre = centre;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        xbase7A = xbase7a;
        xtva7A = xtva7a;
        this.natLiv = natLiv;
        this.aven_tage = aven_tage;
    }

    public String getNumBon() {
        return numBon;
    }

    public void setNumBon(String numBon) {
        this.numBon = numBon;
    }

    public Timestamp getDatBon() {
        return datBon;
    }

    public void setDatBon(Timestamp datBon) {
        this.datBon = datBon;
    }
 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public BigDecimal getBrutHt() {
        return brutHt;
    }

    public void setBrutHt(BigDecimal brutHt) {
        this.brutHt = brutHt;
    }

    public BigDecimal getTauxRem() {
        return tauxRem;
    }

    public void setTauxRem(BigDecimal tauxRem) {
        this.tauxRem = tauxRem;
    }

    public BigDecimal getMontRem() {
        return montRem;
    }

    public void setMontRem(BigDecimal montRem) {
        this.montRem = montRem;
    }

    public BigDecimal getNetHt() {
        return netHt;
    }

    public void setNetHt(BigDecimal netHt) {
        this.netHt = netHt;
    }

    public BigDecimal getMontTva() {
        return montTva;
    }

    public void setMontTva(BigDecimal montTva) {
        this.montTva = montTva;
    }

    public BigDecimal getTotTtc() {
        return totTtc;
    }

    public void setTotTtc(BigDecimal totTtc) {
        this.totTtc = totTtc;
    }


    public BigDecimal getXbase0() {
        return xbase0;
    }

    public void setXbase0(BigDecimal xbase0) {
        this.xbase0 = xbase0;
    }

    public BigDecimal getXbase6() {
        return xbase6;
    }

    public void setXbase6(BigDecimal xbase6) {
        this.xbase6 = xbase6;
    }

    public BigDecimal getXbase10() {
        return xbase10;
    }

    public void setXbase10(BigDecimal xbase10) {
        this.xbase10 = xbase10;
    }

    public BigDecimal getXbase17() {
        return xbase17;
    }

    public void setXbase17(BigDecimal xbase17) {
        this.xbase17 = xbase17;
    }

    public BigDecimal getXbase29() {
        return xbase29;
    }

    public void setXbase29(BigDecimal xbase29) {
        this.xbase29 = xbase29;
    }

    public BigDecimal getXbase7() {
        return xbase7;
    }

    public void setXbase7(BigDecimal xbase7) {
        this.xbase7 = xbase7;
    }

    public BigDecimal getXbase12() {
        return xbase12;
    }

    public void setXbase12(BigDecimal xbase12) {
        this.xbase12 = xbase12;
    }

    public BigDecimal getXbase21() {
        return xbase21;
    }

    public void setXbase21(BigDecimal xbase21) {
        this.xbase21 = xbase21;
    }

    public BigDecimal getXbase36() {
        return xbase36;
    }

    public void setXbase36(BigDecimal xbase36) {
        this.xbase36 = xbase36;
    }

    public BigDecimal getXtva6() {
        return xtva6;
    }

    public void setXtva6(BigDecimal xtva6) {
        this.xtva6 = xtva6;
    }

    public BigDecimal getXtva10() {
        return xtva10;
    }

    public void setXtva10(BigDecimal xtva10) {
        this.xtva10 = xtva10;
    }

    public BigDecimal getXtva17() {
        return xtva17;
    }

    public void setXtva17(BigDecimal xtva17) {
        this.xtva17 = xtva17;
    }

    public BigDecimal getXtva29() {
        return xtva29;
    }

    public void setXtva29(BigDecimal xtva29) {
        this.xtva29 = xtva29;
    }

    public BigDecimal getXtva7() {
        return xtva7;
    }

    public void setXtva7(BigDecimal xtva7) {
        this.xtva7 = xtva7;
    }

    public BigDecimal getXtva12() {
        return xtva12;
    }

    public void setXtva12(BigDecimal xtva12) {
        this.xtva12 = xtva12;
    }

    public BigDecimal getXtva21() {
        return xtva21;
    }

    public void setXtva21(BigDecimal xtva21) {
        this.xtva21 = xtva21;
    }

    public BigDecimal getXtva36() {
        return xtva36;
    }

    public void setXtva36(BigDecimal xtva36) {
        this.xtva36 = xtva36;
    }

    public BigDecimal getPlusV() {
        return plusV;
    }

    public void setPlusV(BigDecimal plusV) {
        this.plusV = plusV;
    }

    public BigDecimal getTauxRes() {
        return tauxRes;
    }

    public void setTauxRes(BigDecimal tauxRes) {
        this.tauxRes = tauxRes;
    }

    public BigDecimal getMontTrs() {
        return montTrs;
    }

    public void setMontTrs(BigDecimal montTrs) {
        this.montTrs = montTrs;
    }

    public String getLiv() {
        return liv;
    }

    public void setLiv(String liv) {
        this.liv = liv;
    }


    public String getPointage() {
        return pointage;
    }

    public void setPointage(String pointage) {
        this.pointage = pointage;
    }

    public NatLiv getNatLiv() {
        return natLiv;
    }

    public void setNatLiv(NatLiv natLiv) {
        this.natLiv = natLiv;
    }

    public String getNatDoc() {
        return natDoc;
    }

    public void setNatDoc(String natDoc) {
        this.natDoc = natDoc;
    }

    public String getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(String codeTva) {
        this.codeTva = codeTva;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getAideMag() {
        return aideMag;
    }

    public void setAideMag(String aideMag) {
        this.aideMag = aideMag;
    }

    public String getEmbal() {
        return embal;
    }

    public void setEmbal(String embal) {
        this.embal = embal;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public BigDecimal getXbase19() {
        return xbase19;
    }

    public void setXbase19(BigDecimal xbase19) {
        this.xbase19 = xbase19;
    }

    public BigDecimal getXtva19() {
        return xtva19;
    }

    public void setXtva19(BigDecimal xtva19) {
        this.xtva19 = xtva19;
    }

    public BigDecimal getXbase13() {
        return xbase13;
    }

    public void setXbase13(BigDecimal xbase13) {
        this.xbase13 = xbase13;
    }

    public BigDecimal getXtva13() {
        return xtva13;
    }

    public void setXtva13(BigDecimal xtva13) {
        this.xtva13 = xtva13;
    }

    public BigDecimal getXbase7A() {
        return xbase7A;
    }

    public void setXbase7A(BigDecimal xbase7a) {
        xbase7A = xbase7a;
    }

    public BigDecimal getXtva7A() {
        return xtva7A;
    }

    public void setXtva7A(BigDecimal xtva7a) {
        xtva7A = xtva7a;
    }

    public Fournis getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(Fournis codFrs) {
        this.codFrs = codFrs;
    }

    public void setDetEmbas(List<DetEmba> detEmbas) {
        this.detEmbas = detEmbas;
    }
 
    public AVANTAGE getAven_tage() {
        return aven_tage;
    }

    public void setAven_tage(AVANTAGE aven_tage) {
        this.aven_tage = aven_tage;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getNomprenomCli() {
        return nomprenomCli;
    }

    public void setNomprenomCli(String nomprenomCli) {
        this.nomprenomCli = nomprenomCli;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
        result = prime * result + ((aideMag == null) ? 0 : aideMag.hashCode());
        result = prime * result + ((brutHt == null) ? 0 : brutHt.hashCode());
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((codeTva == null) ? 0 : codeTva.hashCode());
        result = prime * result + ((datBon == null) ? 0 : datBon.hashCode());
        result = prime * result + ((embal == null) ? 0 : embal.hashCode());
        result = prime * result + ((liv == null) ? 0 : liv.hashCode());
        result = prime * result + ((montRem == null) ? 0 : montRem.hashCode());
        result = prime * result + ((montTrs == null) ? 0 : montTrs.hashCode());
        result = prime * result + ((montTva == null) ? 0 : montTva.hashCode());
        result = prime * result + ((natDoc == null) ? 0 : natDoc.hashCode());
        result = prime * result + ((netHt == null) ? 0 : netHt.hashCode());
        result = prime * result + ((numBon == null) ? 0 : numBon.hashCode());
        result = prime * result + ((plusV == null) ? 0 : plusV.hashCode());
        result = prime * result + ((point == null) ? 0 : point.hashCode());
        result = prime * result + ((pointage == null) ? 0 : pointage.hashCode());
        result = prime * result + ((poste == null) ? 0 : poste.hashCode());
        result = prime * result + ((prep == null) ? 0 : prep.hashCode());
        result = prime * result + ((raison == null) ? 0 : raison.hashCode());
        result = prime * result + ((tauxRem == null) ? 0 : tauxRem.hashCode());
        result = prime * result + ((tauxRes == null) ? 0 : tauxRes.hashCode());
        result = prime * result + ((totTtc == null) ? 0 : totTtc.hashCode());
        result = prime * result + ((xbase0 == null) ? 0 : xbase0.hashCode());
        result = prime * result + ((xbase10 == null) ? 0 : xbase10.hashCode());
        result = prime * result + ((xbase12 == null) ? 0 : xbase12.hashCode());
        result = prime * result + ((xbase13 == null) ? 0 : xbase13.hashCode());
        result = prime * result + ((xbase17 == null) ? 0 : xbase17.hashCode());
        result = prime * result + ((xbase19 == null) ? 0 : xbase19.hashCode());
        result = prime * result + ((xbase21 == null) ? 0 : xbase21.hashCode());
        result = prime * result + ((xbase29 == null) ? 0 : xbase29.hashCode());
        result = prime * result + ((xbase36 == null) ? 0 : xbase36.hashCode());
        result = prime * result + ((xbase6 == null) ? 0 : xbase6.hashCode());
        result = prime * result + ((xbase7 == null) ? 0 : xbase7.hashCode());
        result = prime * result + ((xbase7A == null) ? 0 : xbase7A.hashCode());
        result = prime * result + ((xtva10 == null) ? 0 : xtva10.hashCode());
        result = prime * result + ((xtva12 == null) ? 0 : xtva12.hashCode());
        result = prime * result + ((xtva13 == null) ? 0 : xtva13.hashCode());
        result = prime * result + ((xtva17 == null) ? 0 : xtva17.hashCode());
        result = prime * result + ((xtva19 == null) ? 0 : xtva19.hashCode());
        result = prime * result + ((xtva21 == null) ? 0 : xtva21.hashCode());
        result = prime * result + ((xtva29 == null) ? 0 : xtva29.hashCode());
        result = prime * result + ((xtva36 == null) ? 0 : xtva36.hashCode());
        result = prime * result + ((xtva6 == null) ? 0 : xtva6.hashCode());
        result = prime * result + ((xtva7 == null) ? 0 : xtva7.hashCode());
        result = prime * result + ((xtva7A == null) ? 0 : xtva7A.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BonPrep other = (BonPrep) obj;
        if (adresse == null) {
            if (other.adresse != null)
                return false;
        } else if (!adresse.equals(other.adresse))
            return false;
        if (aideMag == null) {
            if (other.aideMag != null)
                return false;
        } else if (!aideMag.equals(other.aideMag))
            return false;
        if (brutHt == null) {
            if (other.brutHt != null)
                return false;
        } else if (!brutHt.equals(other.brutHt))
            return false;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (codeTva == null) {
            if (other.codeTva != null)
                return false;
        } else if (!codeTva.equals(other.codeTva))
            return false;
        if (datBon == null) {
            if (other.datBon != null)
                return false;
        } else if (!datBon.equals(other.datBon))
            return false;
        if (embal == null) {
            if (other.embal != null)
                return false;
        } else if (!embal.equals(other.embal))
            return false;
        if (liv == null) {
            if (other.liv != null)
                return false;
        } else if (!liv.equals(other.liv))
            return false;
        if (montRem == null) {
            if (other.montRem != null)
                return false;
        } else if (!montRem.equals(other.montRem))
            return false;
        if (montTrs == null) {
            if (other.montTrs != null)
                return false;
        } else if (!montTrs.equals(other.montTrs))
            return false;
        if (montTva == null) {
            if (other.montTva != null)
                return false;
        } else if (!montTva.equals(other.montTva))
            return false;
        if (natDoc == null) {
            if (other.natDoc != null)
                return false;
        } else if (!natDoc.equals(other.natDoc))
            return false;
        if (netHt == null) {
            if (other.netHt != null)
                return false;
        } else if (!netHt.equals(other.netHt))
            return false;
        if (numBon == null) {
            if (other.numBon != null)
                return false;
        } else if (!numBon.equals(other.numBon))
            return false;
        if (plusV == null) {
            if (other.plusV != null)
                return false;
        } else if (!plusV.equals(other.plusV))
            return false;
        if (point == null) {
            if (other.point != null)
                return false;
        } else if (!point.equals(other.point))
            return false;
        if (pointage == null) {
            if (other.pointage != null)
                return false;
        } else if (!pointage.equals(other.pointage))
            return false;
        if (poste == null) {
            if (other.poste != null)
                return false;
        } else if (!poste.equals(other.poste))
            return false;
        if (prep == null) {
            if (other.prep != null)
                return false;
        } else if (!prep.equals(other.prep))
            return false;
        if (raison == null) {
            if (other.raison != null)
                return false;
        } else if (!raison.equals(other.raison))
            return false;
        if (tauxRem == null) {
            if (other.tauxRem != null)
                return false;
        } else if (!tauxRem.equals(other.tauxRem))
            return false;
        if (tauxRes == null) {
            if (other.tauxRes != null)
                return false;
        } else if (!tauxRes.equals(other.tauxRes))
            return false;
        if (totTtc == null) {
            if (other.totTtc != null)
                return false;
        } else if (!totTtc.equals(other.totTtc))
            return false;
        if (xbase0 == null) {
            if (other.xbase0 != null)
                return false;
        } else if (!xbase0.equals(other.xbase0))
            return false;
        if (xbase10 == null) {
            if (other.xbase10 != null)
                return false;
        } else if (!xbase10.equals(other.xbase10))
            return false;
        if (xbase12 == null) {
            if (other.xbase12 != null)
                return false;
        } else if (!xbase12.equals(other.xbase12))
            return false;
        if (xbase13 == null) {
            if (other.xbase13 != null)
                return false;
        } else if (!xbase13.equals(other.xbase13))
            return false;
        if (xbase17 == null) {
            if (other.xbase17 != null)
                return false;
        } else if (!xbase17.equals(other.xbase17))
            return false;
        if (xbase19 == null) {
            if (other.xbase19 != null)
                return false;
        } else if (!xbase19.equals(other.xbase19))
            return false;
        if (xbase21 == null) {
            if (other.xbase21 != null)
                return false;
        } else if (!xbase21.equals(other.xbase21))
            return false;
        if (xbase29 == null) {
            if (other.xbase29 != null)
                return false;
        } else if (!xbase29.equals(other.xbase29))
            return false;
        if (xbase36 == null) {
            if (other.xbase36 != null)
                return false;
        } else if (!xbase36.equals(other.xbase36))
            return false;
        if (xbase6 == null) {
            if (other.xbase6 != null)
                return false;
        } else if (!xbase6.equals(other.xbase6))
            return false;
        if (xbase7 == null) {
            if (other.xbase7 != null)
                return false;
        } else if (!xbase7.equals(other.xbase7))
            return false;
        if (xbase7A == null) {
            if (other.xbase7A != null)
                return false;
        } else if (!xbase7A.equals(other.xbase7A))
            return false;
        if (xtva10 == null) {
            if (other.xtva10 != null)
                return false;
        } else if (!xtva10.equals(other.xtva10))
            return false;
        if (xtva12 == null) {
            if (other.xtva12 != null)
                return false;
        } else if (!xtva12.equals(other.xtva12))
            return false;
        if (xtva13 == null) {
            if (other.xtva13 != null)
                return false;
        } else if (!xtva13.equals(other.xtva13))
            return false;
        if (xtva17 == null) {
            if (other.xtva17 != null)
                return false;
        } else if (!xtva17.equals(other.xtva17))
            return false;
        if (xtva19 == null) {
            if (other.xtva19 != null)
                return false;
        } else if (!xtva19.equals(other.xtva19))
            return false;
        if (xtva21 == null) {
            if (other.xtva21 != null)
                return false;
        } else if (!xtva21.equals(other.xtva21))
            return false;
        if (xtva29 == null) {
            if (other.xtva29 != null)
                return false;
        } else if (!xtva29.equals(other.xtva29))
            return false;
        if (xtva36 == null) {
            if (other.xtva36 != null)
                return false;
        } else if (!xtva36.equals(other.xtva36))
            return false;
        if (xtva6 == null) {
            if (other.xtva6 != null)
                return false;
        } else if (!xtva6.equals(other.xtva6))
            return false;
        if (xtva7 == null) {
            if (other.xtva7 != null)
                return false;
        } else if (!xtva7.equals(other.xtva7))
            return false;
        if (xtva7A == null) {
            if (other.xtva7A != null)
                return false;
        } else if (!xtva7A.equals(other.xtva7A))
            return false;
        return true;
    }

    @Override
    public String toString() { 
        return "BonPrep [adresse=" + adresse + ", aideMag=" + aideMag + ", brutHt=" + brutHt + ", centre=" + centre
                + ", codeTva=" + codeTva + ", datBon=" + datBon + ", embal=" + embal + ", liv=" + liv + ", montRem=" + montRem
                + ", montTrs=" + montTrs + ", montTva=" + montTva + ", natDoc=" + natDoc + ", natLiv=" + natLiv
                + ", netHt=" + netHt + ", numBon=" + numBon + ", plusV="
                + plusV + ", point=" + point + ", pointage=" + pointage + ", poste=" + poste + ", prep=" + prep
                + ", raison=" + raison + ", tauxRem=" + tauxRem + ", tauxRes=" + tauxRes + ", totTtc=" + totTtc
                + ", xbase0=" + xbase0 + ", xbase10=" + xbase10 + ", xbase12=" + xbase12 + ", xbase13=" + xbase13
                + ", xbase17=" + xbase17 + ", xbase19=" + xbase19 + ", xbase21=" + xbase21 + ", xbase29=" + xbase29
                + ", xbase36=" + xbase36 + ", xbase6=" + xbase6 + ", xbase7=" + xbase7 + ", xbase7A=" + xbase7A
                + ", xtva10=" + xtva10 + ", xtva12=" + xtva12 + ", xtva13=" + xtva13 + ", xtva17=" + xtva17
                + ", xtva19=" + xtva19 + ", xtva21=" + xtva21 + ", xtva29=" + xtva29 + ", xtva36=" + xtva36 + ", xtva6="
                + xtva6 + ", xtva7=" + xtva7 + ", xtva7A=" + xtva7A + "]";
    }
    
}
