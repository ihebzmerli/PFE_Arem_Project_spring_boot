package com.loizenai.jwtauthentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bon_liv", schema = "testbd")
public class BonLiv implements Serializable{

    @Id
    @Column(name = "NUM_BON_LIV")
    private String numBon;



    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_BON")
    @LastModifiedDate
    private Timestamp datBon;

    @Enumerated(EnumType.STRING)
    @Column(name = "trans_action")
    private TRANSACTION trans_action;
    public enum TRANSACTION{
        recu,
        envoyer
    }

    @Column(name = "CRONO")
    private Timestamp cronoTime;
    //FK_KEYS***********************
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bonLivs_articles",
            joinColumns = {
                    @JoinColumn(name = "NUM_BON_LIV", referencedColumnName = "NUM_BON_LIV",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "COD_ART", referencedColumnName = "COD_ART",
                            nullable = true, updatable = false)})
    private List<Article> articles; 


    @OneToOne(mappedBy = "bonliv_xcommand", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Xcommand numCom;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_livreur", nullable = true)
    private Livreur livreur;

    @OneToOne(mappedBy = "bonLiv", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private EtatLiv etatLiv;
    
    @OneToOne(mappedBy = "bonLiv", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Livreur_Expide livreur_Expide;

    @OneToMany(mappedBy = "bonLiv", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ArtTerm> artTerms;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "cod_Frs", nullable = true)
    private Fournis fournis;

    //END FK_KEYS************************
    @Column(name = "NUM_BON_FRS")
    private String numBonFrs;

    @Column(name = "COD_CLI")
    private String nomprenomCli;
    @Column(name = "ADRESSE")
    private String adresseCli;

    private String raison;
    private BigDecimal brutHt;
    private BigDecimal tauxRem;
    private BigDecimal montRem;
    private BigDecimal netHt;
    private BigDecimal montTva;
    private BigDecimal totTtc;
    private long numFac;
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
    private String command;
    private String pointage;
    private BigDecimal montIrpp;
    private String poste;
    private String centre;
    private BigDecimal xbase19;
    private BigDecimal xtva19;
    private BigDecimal xbase13;
    private BigDecimal xtva13;
    private BigDecimal xbase7A;
    private BigDecimal xtva7A;
    private String codeTva;


    public BonLiv() {

    }

    public BonLiv(String numBon, Timestamp datBon, String trans_ction,String nomprenomCli, String numBonFrs, String raison, BigDecimal brutHt, BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc, long numFac, BigDecimal xbase0, BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17, BigDecimal xbase29, BigDecimal xbase7, BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36, BigDecimal xtva6, BigDecimal xtva10, BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7, BigDecimal xtva12, BigDecimal xtva21, BigDecimal xtva36, BigDecimal plusV, BigDecimal tauxRes, BigDecimal montTrs, String liv, String command, String pointage, BigDecimal montIrpp, String poste, String centre, BigDecimal xbase19, BigDecimal xtva19, BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7A, BigDecimal xtva7A, String codeTva) {
        this.numBon = numBon;
        this.datBon = datBon;
        this.nomprenomCli = nomprenomCli;
        this.numBonFrs = numBonFrs;
        this.raison = raison;
        this.brutHt = brutHt;
        this.tauxRem = tauxRem;
        this.montRem = montRem;
        this.netHt = netHt;
        this.montTva = montTva;
        this.totTtc = totTtc;
        this.numFac = numFac;
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
        this.command = command;
        this.pointage = pointage;
        this.montIrpp = montIrpp;
        this.poste = poste;
        this.centre = centre;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        this.xbase7A = xbase7A;
        this.xtva7A = xtva7A;
        this.codeTva = codeTva;
    }


    
    public BonLiv(String numBon, Timestamp datBon, TRANSACTION trans_action, Timestamp cronoTime,
            List<Article> articles, Xcommand numCom, User user, Livreur livreur, EtatLiv etatLiv,
            Livreur_Expide livreur_Expide, List<ArtTerm> artTerms, Fournis fournis, String numBonFrs,
            String nomprenomCli, String adresseCli, String raison, BigDecimal brutHt, BigDecimal tauxRem,
            BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc, long numFac, BigDecimal xbase0,
            BigDecimal xbase6, BigDecimal xbase10, BigDecimal xbase17, BigDecimal xbase29, BigDecimal xbase7,
            BigDecimal xbase12, BigDecimal xbase21, BigDecimal xbase36, BigDecimal xtva6, BigDecimal xtva10,
            BigDecimal xtva17, BigDecimal xtva29, BigDecimal xtva7, BigDecimal xtva12, BigDecimal xtva21,
            BigDecimal xtva36, BigDecimal plusV, BigDecimal tauxRes, BigDecimal montTrs, String liv, String command,
            String pointage, BigDecimal montIrpp, String poste, String centre, BigDecimal xbase19, BigDecimal xtva19,
            BigDecimal xbase13, BigDecimal xtva13, BigDecimal xbase7a, BigDecimal xtva7a, String codeTva) {
        this.numBon = numBon;
        this.datBon = datBon;
        this.trans_action = trans_action;
        this.cronoTime = cronoTime;
        this.articles = articles;
        this.numCom = numCom;
        this.user = user;
        this.livreur = livreur;
        this.etatLiv = etatLiv;
        this.livreur_Expide = livreur_Expide;
        this.artTerms = artTerms;
        this.fournis = fournis;
        this.numBonFrs = numBonFrs;
        this.nomprenomCli = nomprenomCli;
        this.adresseCli = adresseCli;
        this.raison = raison;
        this.brutHt = brutHt;
        this.tauxRem = tauxRem;
        this.montRem = montRem;
        this.netHt = netHt;
        this.montTva = montTva;
        this.totTtc = totTtc;
        this.numFac = numFac;
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
        this.command = command;
        this.pointage = pointage;
        this.montIrpp = montIrpp;
        this.poste = poste;
        this.centre = centre;
        this.xbase19 = xbase19;
        this.xtva19 = xtva19;
        this.xbase13 = xbase13;
        this.xtva13 = xtva13;
        xbase7A = xbase7a;
        xtva7A = xtva7a;
        this.codeTva = codeTva;
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

    public String getNomprenomCli() {
        return nomprenomCli;
    }

    public void setNomprenomCli(String nomprenomCli) {
        this.nomprenomCli = nomprenomCli;
    }

    public String getAdresseCli() {
        return adresseCli;
    }

    public void setAdresseCli(String adresseCli) {
        this.adresseCli = adresseCli;
    }

    public String getNumBonFrs() {
        return numBonFrs;
    }

    public void setNumBonFrs(String numBonFrs) {
        this.numBonFrs = numBonFrs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "NUM_FAC",unique = true)
    public long getNumFac() {
        return numFac;
    }

    public void setNumFac(long numFac) {
        this.numFac = numFac;
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
    @Column(name = "MONT_TRS")
    public BigDecimal getMontTrs() {
        return montTrs;
    }

    public void setMontTrs(BigDecimal montTrs) {
        this.montTrs = montTrs;
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
    @Column(name = "COMMAND")
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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
    @Column(name = "CODE_TVA")
    public String getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(String codeTva) {
        this.codeTva = codeTva;
    }

    public void setEtatLiv(EtatLiv etatLiv) {
        this.etatLiv = etatLiv;
    }
    
    public TRANSACTION getTrans_action() {
        return trans_action;
    }

    public void setTrans_action(TRANSACTION trans_action) {
        this.trans_action = trans_action;
    }

    public Xcommand getNumCom() {
        return numCom;
    }

    public void setNumCom(Xcommand numCom) {
        this.numCom = numCom;
    }

    
    public Timestamp getCronoTime() {
        return cronoTime;
    }

    public void setCronoTime(Timestamp cronoTime) {
        this.cronoTime = cronoTime;
    }

    public List<ArtTerm> getArtTerms() {
        return artTerms;
    }

    public void setArtTerms(List<ArtTerm> artTerms) {
        this.artTerms = artTerms;
    }
    
    public void setLivreur_Expide(Livreur_Expide livreur_Expide) {
        this.livreur_Expide = livreur_Expide;
    }
    
    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }  

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Fournis getFournis() {
        return fournis;
    }

    public void setFournis(Fournis fournis) {
        this.fournis = fournis;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brutHt == null) ? 0 : brutHt.hashCode());
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((codeTva == null) ? 0 : codeTva.hashCode());
        result = prime * result + ((datBon == null) ? 0 : datBon.hashCode());
        result = prime * result + ((etatLiv == null) ? 0 : etatLiv.hashCode());
        result = prime * result + ((liv == null) ? 0 : liv.hashCode());
        result = prime * result + ((montIrpp == null) ? 0 : montIrpp.hashCode());
        result = prime * result + ((montRem == null) ? 0 : montRem.hashCode());
        result = prime * result + ((montTrs == null) ? 0 : montTrs.hashCode());
        result = prime * result + ((montTva == null) ? 0 : montTva.hashCode());
        result = prime * result + ((netHt == null) ? 0 : netHt.hashCode());
        result = prime * result + ((numBon == null) ? 0 : numBon.hashCode());
        result = prime * result + ((numCom == null) ? 0 : numCom.hashCode());
        result = prime * result + (int) (numFac ^ (numFac >>> 32));
        result = prime * result + ((plusV == null) ? 0 : plusV.hashCode());
        result = prime * result + ((pointage == null) ? 0 : pointage.hashCode());
        result = prime * result + ((poste == null) ? 0 : poste.hashCode());
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
        BonLiv other = (BonLiv) obj;
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
        if (etatLiv == null) {
            if (other.etatLiv != null)
                return false;
        } else if (!etatLiv.equals(other.etatLiv))
            return false;
        if (liv == null) {
            if (other.liv != null)
                return false;
        } else if (!liv.equals(other.liv))
            return false;
        if (montIrpp == null) {
            if (other.montIrpp != null)
                return false;
        } else if (!montIrpp.equals(other.montIrpp))
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
        if (numCom == null) {
            if (other.numCom != null)
                return false;
        } else if (!numCom.equals(other.numCom))
            return false;
        if (numFac != other.numFac)
            return false;
        if (plusV == null) {
            if (other.plusV != null)
                return false;
        } else if (!plusV.equals(other.plusV))
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
        return "BonLiv [brutHt=" + brutHt + ", centre=" + centre + ", codeTva=" + codeTva
                + ", datBon=" + datBon + ", numBonFrs=" + numBonFrs + ", liv=" + liv +
                 ", montIrpp=" + montIrpp + ", montRem=" + montRem + ", montTrs=" + montTrs + ", montTva="
                + montTva + ", netHt=" + netHt + ", numBon=" + numBon + ", numCom=" + numCom + ", plusV=" + plusV + ", pointage=" + pointage + ", poste=" + poste + ", raison=" + raison
                + ", tauxRem=" + tauxRem + ", tauxRes=" + tauxRes + ", totTtc=" + totTtc + ", xbase0=" + xbase0
                + ", xbase10=" + xbase10 + ", xbase12=" + xbase12 + ", xbase13=" + xbase13 + ", xbase17=" + xbase17
                + ", xbase19=" + xbase19 + ", xbase21=" + xbase21 + ", xbase29=" + xbase29 + ", xbase36=" + xbase36
                + ", xbase6=" + xbase6 + ", xbase7=" + xbase7 + ", xbase7A=" + xbase7A + ", xtva10=" + xtva10
                + ", xtva12=" + xtva12 + ", xtva13=" + xtva13 + ", xtva17=" + xtva17 + ", xtva19=" + xtva19
                + ", xtva21=" + xtva21 + ", xtva29=" + xtva29 + ", xtva36=" + xtva36 + ", xtva6=" + xtva6 + ", xtva7="
                + xtva7 + ", xtva7A=" + xtva7A + "]";
    }
  
}
