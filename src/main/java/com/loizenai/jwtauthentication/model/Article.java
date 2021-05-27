package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "article", schema = "testbd")
public class Article implements Serializable{

    @Id    
    @Column(name = "COD_ART")
    private String codArt;

    //FK_KEYS***********************
    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    private List<Achats> achatss;

    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    private List<BonSort> bonsorts;

    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    private List<BonPrep> bonpreps;

    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    private List<BonLiv> bonlivs;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_emba", nullable = true)
    private DetEmba detembas_articles;

/*
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_rectif", nullable = true)
    private Rectif rectif_articles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "articles_fourniss",
            joinColumns = {
                    @JoinColumn(name = "COD_FRS", referencedColumnName = "COD_FRS",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "COD_ART", referencedColumnName = "COD_ART",
                            nullable = true, updatable = false)})
    private List<Fournis> fourniss;  
    
    */
    //END FK_KEYS************************ 

    private String desArt;
    private String refOrg;
    private String refRem;
    private String codNgp;
    private long codFrs;
    private String marque;
    private String numCas;
    private Integer qutStk;
    private Integer qutStk2;
    private Short unitVen;
    private Integer stkGar;
    private Integer stkIni;
    private Integer qutMax;
    private Integer qutMin;
    private Integer qutDep;
    private BigDecimal prixMin;
    private Float prixDev;
    private BigDecimal cours;
    private Short coef;
    private BigDecimal derPAch;
    private Float prixAch;
    private Float prixVen;
    private Byte remise;
    private Float prixArem;
    private Byte tva;
    private Long cumulVen;
    private Long cumulAch;
    private Timestamp derAch;
    private Timestamp derMvt;
    private BigDecimal pValu;
    private Long unitInv;
    private Integer qutV1;
    private Integer qutV2;
    private Integer qutV3;
    private BigDecimal vente1;
    private BigDecimal vente2;
    private BigDecimal vente3;
    private Integer qutA1;
    private Integer mois1;
    private Integer mois2;
    private Integer mois3;
    private Integer mois4;
    private Integer mois5;
    private Integer mois6;
    private Integer mois7;
    private Integer mois8;
    private Integer mois9;
    private Integer mois10;
    private Integer mois11;
    private Integer mois12;
    private BigDecimal chifAff;
    private BigDecimal taux;
    private BigDecimal tot;
    private String classe;

    @Column(name = "ZONE")
    private String zone;

    private Integer analStk;
    private Integer nbjStk;
    private Integer nbjCom;
    private Integer vSstk;
    private String typAnal;
    private Byte flag1;
    private Byte flag2;
    private Integer comStk;
    private Integer comNbj;
    private Integer cumulDem;
    private Integer qutDou;
    private Integer xanalStk;
    private Byte xtypAnal;
    private BigDecimal xvCom;
    private Integer qutDem;
    private Integer qutConf;
    private Integer qutProf;
    private Float prixProf;
    private Float prixConf;
    private Integer qutSup;
    private BigDecimal venPer;
    private BigDecimal tarifFrs;
    private String confr;
    private Float prixAM;
    private String typeV;
    private Float xprixAch;
    private String t;
    private Integer reliq;
    private BigDecimal derPDev;
    private Float prixEuro;
    private Integer cumulRes;
    private Timestamp datRup;
    private Timestamp datPAch;
    private String codBar;
    private String controle;
    private String modele;
    private String energie;
    private BigDecimal poids;
    private String versions;
    private Boolean special1;
    private Boolean special2;
    private Boolean special3;
    private Boolean special4;
    private Boolean special5;
    private Boolean special6;
    private Boolean special7;
    private Boolean special8;
    private Boolean special9;
    private Boolean special10;
    private Boolean special11;
    private Boolean special12;
    private Boolean special13;
    private String observatio;
    private Timestamp datCreat;
    private Short nbjRup;
    private Short nbjRup1;
    private Integer m1;
    private Integer m2;
    private Integer m3;
    private Integer m4;
    private Integer m5;
    private Integer m6;
    private Integer m7;
    private Integer m8;
    private Integer m9;
    private Integer m10;
    private Integer m11;
    private Integer m12;
    private Float prixCEur;
    private Float prixIni;
    private Integer cumulEnt;
    private Integer cumulBs;
    private Integer stkAtrsf;
    private Integer stkTrsf;
    private Integer consMoy;
    private Integer qutRav;
    private Integer qutDep1;
    private Integer cumulConf;
    private Long pointage;
    private Long pointage1;
    private Long pointage2;
    private Long totalPoin;
    private String etage2;
    private String famille;
    private String sFamille;
    private String centre;
    private Integer stkReel;
    private Integer stkRes;
    private Integer stkNp;
    
    @Basic
    @Column(name = "GALERY")
    private String galery;            

    public Article() {

    }

    public Article(String codArt,String desArt, String refOrg, String refRem, String codNgp,
            long codFrs, String marque, String numCas, Integer qutStk, Integer qutStk2, Short unitVen, Integer stkGar,
            Integer stkIni, Integer qutMax, Integer qutMin, Integer qutDep, BigDecimal prixMin, Float prixDev,
            BigDecimal cours, Short coef, BigDecimal derPAch, Float prixAch, Float prixVen, Byte remise,
            Float prixArem, Byte tva, Long cumulVen, Long cumulAch, Timestamp derAch, Timestamp derMvt,
            BigDecimal pValu, Long unitInv, Integer qutV1, Integer qutV2, Integer qutV3, BigDecimal vente1,
            BigDecimal vente2, BigDecimal vente3, Integer qutA1, Integer mois1, Integer mois2, Integer mois3,
            Integer mois4, Integer mois5, Integer mois6, Integer mois7, Integer mois8, Integer mois9, Integer mois10,
            Integer mois11, Integer mois12, BigDecimal chifAff, BigDecimal taux, BigDecimal tot, String classe,
            Integer analStk, Integer nbjStk, Integer nbjCom, Integer vSstk, String typAnal, Byte flag1, Byte flag2,
            Integer comStk, Integer comNbj, Integer cumulDem, Integer qutDou, Integer xanalStk, Byte xtypAnal,
            BigDecimal xvCom, Integer qutDem, Integer qutConf, Integer qutProf, Float prixProf,
            Float prixConf, Integer qutSup, BigDecimal venPer, BigDecimal tarifFrs, String confr,
            Float prixAM, String typeV, Float xprixAch, String t, Integer reliq, BigDecimal derPDev,
            Float prixEuro, Integer cumulRes, Timestamp datRup, Timestamp datPAch, String codBar, String controle,
            String modele, String energie, BigDecimal poids, String versions, Boolean special1, Boolean special2,
            Boolean special3, Boolean special4, Boolean special5, Boolean special6, Boolean special7, Boolean special8,
            Boolean special9, Boolean special10, Boolean special11, Boolean special12, Boolean special13,
            String observatio, Timestamp datCreat, Short nbjRup, Short nbjRup1, Integer m1, Integer m2, Integer m3,
            Integer m4, Integer m5, Integer m6, Integer m7, Integer m8, Integer m9, Integer m10, Integer m11,
            Integer m12, Float prixCEur, Float prixIni, Integer cumulEnt, Integer cumulBs,
            Integer stkAtrsf, Integer stkTrsf, Integer consMoy, Integer qutRav, Integer qutDep1, Integer cumulConf,
            Long pointage, Long pointage1, Long pointage2, Long totalPoin, String etage2, String famille,
            String sFamille, String centre, Integer stkReel, Integer stkRes, Integer stkNp, String galery) {
        this.codArt = codArt;
        this.desArt = desArt;
        this.refOrg = refOrg;
        this.refRem = refRem;
        this.codNgp = codNgp;
        this.codFrs = codFrs;
        this.marque = marque;
        this.numCas = numCas;
        this.qutStk = qutStk;
        this.qutStk2 = qutStk2;
        this.unitVen = unitVen;
        this.stkGar = stkGar;
        this.stkIni = stkIni;
        this.qutMax = qutMax;
        this.qutMin = qutMin;
        this.qutDep = qutDep;
        this.prixMin = prixMin;
        this.prixDev = prixDev;
        this.cours = cours;
        this.coef = coef;
        this.derPAch = derPAch;
        this.prixAch = prixAch;
        this.prixVen = prixVen;
        this.remise = remise;
        this.prixArem = prixArem;
        this.tva = tva;
        this.cumulVen = cumulVen;
        this.cumulAch = cumulAch;
        this.derAch = derAch;
        this.derMvt = derMvt;
        this.pValu = pValu;
        this.unitInv = unitInv;
        this.qutV1 = qutV1;
        this.qutV2 = qutV2;
        this.qutV3 = qutV3;
        this.vente1 = vente1;
        this.vente2 = vente2;
        this.vente3 = vente3;
        this.qutA1 = qutA1;
        this.mois1 = mois1;
        this.mois2 = mois2;
        this.mois3 = mois3;
        this.mois4 = mois4;
        this.mois5 = mois5;
        this.mois6 = mois6;
        this.mois7 = mois7;
        this.mois8 = mois8;
        this.mois9 = mois9;
        this.mois10 = mois10;
        this.mois11 = mois11;
        this.mois12 = mois12;
        this.chifAff = chifAff;
        this.taux = taux;
        this.tot = tot;
        this.classe = classe;
        this.analStk = analStk;
        this.nbjStk = nbjStk;
        this.nbjCom = nbjCom;
        this.vSstk = vSstk;
        this.typAnal = typAnal;
        this.flag1 = flag1;
        this.flag2 = flag2;
        this.comStk = comStk;
        this.comNbj = comNbj;
        this.cumulDem = cumulDem;
        this.qutDou = qutDou;
        this.xanalStk = xanalStk;
        this.xtypAnal = xtypAnal;
        this.xvCom = xvCom;
        this.qutDem = qutDem;
        this.qutConf = qutConf;
        this.qutProf = qutProf;
        this.prixProf = prixProf;
        this.prixConf = prixConf;
        this.qutSup = qutSup;
        this.venPer = venPer;
        this.tarifFrs = tarifFrs;
        this.confr = confr;
        this.prixAM = prixAM;
        this.typeV = typeV;
        this.xprixAch = xprixAch;
        this.t = t;
        this.reliq = reliq;
        this.derPDev = derPDev;
        this.prixEuro = prixEuro;
        this.cumulRes = cumulRes;
        this.datRup = datRup;
        this.datPAch = datPAch;
        this.codBar = codBar;
        this.controle = controle;
        this.modele = modele;
        this.energie = energie;
        this.poids = poids;
        this.versions = versions;
        this.special1 = special1;
        this.special2 = special2;
        this.special3 = special3;
        this.special4 = special4;
        this.special5 = special5;
        this.special6 = special6;
        this.special7 = special7;
        this.special8 = special8;
        this.special9 = special9;
        this.special10 = special10;
        this.special11 = special11;
        this.special12 = special12;
        this.special13 = special13;
        this.observatio = observatio;
        this.datCreat = datCreat;
        this.nbjRup = nbjRup;
        this.nbjRup1 = nbjRup1;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
        this.m7 = m7;
        this.m8 = m8;
        this.m9 = m9;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.prixCEur = prixCEur;
        this.prixIni = prixIni;
        this.cumulEnt = cumulEnt;
        this.cumulBs = cumulBs;
        this.stkAtrsf = stkAtrsf;
        this.stkTrsf = stkTrsf;
        this.consMoy = consMoy;
        this.qutRav = qutRav;
        this.qutDep1 = qutDep1;
        this.cumulConf = cumulConf;
        this.pointage = pointage;
        this.pointage1 = pointage1;
        this.pointage2 = pointage2;
        this.totalPoin = totalPoin;
        this.etage2 = etage2;
        this.famille = famille;
        this.sFamille = sFamille;
        this.centre = centre;
        this.stkReel = stkReel;
        this.stkRes = stkRes;
        this.stkNp = stkNp;
        this.galery = galery;
    }

    
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    @Basic
    @Column(name = "DES_ART")
    public String getDesArt() {
        return desArt;
    }

    public void setDesArt(String desArt) {
        this.desArt = desArt;
    }

    @Basic
    @Column(name = "REF_ORG")
    public String getRefOrg() {
        return refOrg;
    }

    public void setRefOrg(String refOrg) {
        this.refOrg = refOrg;
    }

    @Basic
    @Column(name = "REF_REM")
    public String getRefRem() {
        return refRem;
    }

    public void setRefRem(String refRem) {
        this.refRem = refRem;
    }

    @Basic
    @Column(name = "COD_NGP")
    public String getCodNgp() {
        return codNgp;
    }

    public void setCodNgp(String codNgp) {
        this.codNgp = codNgp;
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
    @Column(name = "MARQUE")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "NUM_CAS")
    public String getNumCas() {
        return numCas;
    }

    public void setNumCas(String numCas) {
        this.numCas = numCas;
    }

    @Basic
    @Column(name = "QUT_STK")
    public Integer getQutStk() {
        return qutStk;
    }

    public void setQutStk(Integer qutStk) {
        this.qutStk = qutStk;
    }

    @Basic
    @Column(name = "QUT_STK2")
    public Integer getQutStk2() {
        return qutStk2;
    }

    public void setQutStk2(Integer qutStk2) {
        this.qutStk2 = qutStk2;
    }

    @Basic
    @Column(name = "UNIT_VEN")
    public Short getUnitVen() {
        return unitVen;
    }

    public void setUnitVen(Short unitVen) {
        this.unitVen = unitVen;
    }

    @Basic
    @Column(name = "STK_GAR")
    public Integer getStkGar() {
        return stkGar;
    }

    public void setStkGar(Integer stkGar) {
        this.stkGar = stkGar;
    }

    @Basic
    @Column(name = "STK_INI")
    public Integer getStkIni() {
        return stkIni;
    }

    public void setStkIni(Integer stkIni) {
        this.stkIni = stkIni;
    }

    @Basic
    @Column(name = "QUT_MAX")
    public Integer getQutMax() {
        return qutMax;
    }

    public void setQutMax(Integer qutMax) {
        this.qutMax = qutMax;
    }

    @Basic
    @Column(name = "QUT_MIN")
    public Integer getQutMin() {
        return qutMin;
    }

    public void setQutMin(Integer qutMin) {
        this.qutMin = qutMin;
    }

    @Basic
    @Column(name = "QUT_DEP")
    public Integer getQutDep() {
        return qutDep;
    }

    public void setQutDep(Integer qutDep) {
        this.qutDep = qutDep;
    }

    @Basic
    @Column(name = "PRIX_MIN")
    public BigDecimal getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(BigDecimal prixMin) {
        this.prixMin = prixMin;
    }

    @Basic
    @Column(name = "PRIX_DEV")
    public Float getPrixDev() {
        return prixDev;
    }

    public void setPrixDev(Float prixDev) {
        this.prixDev = prixDev;
    }

    @Basic
    @Column(name = "COURS")
    public BigDecimal getCours() {
        return cours;
    }

    public void setCours(BigDecimal cours) {
        this.cours = cours;
    }

    @Basic
    @Column(name = "COEF")
    public Short getCoef() {
        return coef;
    }

    public void setCoef(Short coef) {
        this.coef = coef;
    }

    @Basic
    @Column(name = "DER_P_ACH")
    public BigDecimal getDerPAch() {
        return derPAch;
    }

    public void setDerPAch(BigDecimal derPAch) {
        this.derPAch = derPAch;
    }

    @Basic
    @Column(name = "PRIX_ACH")
    public Float getPrixAch() {
        return prixAch;
    }

    public void setPrixAch(Float prixAch) {
        this.prixAch = prixAch;
    }

    @Basic
    @Column(name = "PRIX_VEN")
    public Float getPrixVen() {
        return prixVen;
    }

    public void setPrixVen(Float prixVen) {
        this.prixVen = prixVen;
    }

    @Basic
    @Column(name = "REMISE")
    public Byte getRemise() {
        return remise;
    }

    public void setRemise(Byte remise) {
        this.remise = remise;
    }

    @Basic
    @Column(name = "PRIX_AREM")
    public Float getPrixArem() {
        return prixArem;
    }

    public void setPrixArem(Float prixArem) {
        this.prixArem = prixArem;
    }

    @Basic
    @Column(name = "TVA")
    public Byte getTva() {
        return tva;
    }

    public void setTva(Byte tva) {
        this.tva = tva;
    }

    @Basic
    @Column(name = "CUMUL_VEN")
    public Long getCumulVen() {
        return cumulVen;
    }

    public void setCumulVen(Long cumulVen) {
        this.cumulVen = cumulVen;
    }

    @Basic
    @Column(name = "CUMUL_ACH")
    public Long getCumulAch() {
        return cumulAch;
    }

    public void setCumulAch(Long cumulAch) {
        this.cumulAch = cumulAch;
    }

    @Basic
    @Column(name = "DER_ACH")
    public Timestamp getDerAch() {
        return derAch;
    }

    public void setDerAch(Timestamp derAch) {
        this.derAch = derAch;
    }

    @Basic
    @Column(name = "DER_MVT")
    public Timestamp getDerMvt() {
        return derMvt;
    }

    public void setDerMvt(Timestamp derMvt) {
        this.derMvt = derMvt;
    }

    @Basic
    @Column(name = "P_VALU")
    public BigDecimal getpValu() {
        return pValu;
    }

    public void setpValu(BigDecimal pValu) {
        this.pValu = pValu;
    }

    @Basic
    @Column(name = "UNIT_INV")
    public Long getUnitInv() {
        return unitInv;
    }

    public void setUnitInv(Long unitInv) {
        this.unitInv = unitInv;
    }

    @Basic
    @Column(name = "QUT_V1")
    public Integer getQutV1() {
        return qutV1;
    }

    public void setQutV1(Integer qutV1) {
        this.qutV1 = qutV1;
    }

    @Basic
    @Column(name = "QUT_V2")
    public Integer getQutV2() {
        return qutV2;
    }

    public void setQutV2(Integer qutV2) {
        this.qutV2 = qutV2;
    }

    @Basic
    @Column(name = "QUT_V3")
    public Integer getQutV3() {
        return qutV3;
    }

    public void setQutV3(Integer qutV3) {
        this.qutV3 = qutV3;
    }

    @Basic
    @Column(name = "VENTE1")
    public BigDecimal getVente1() {
        return vente1;
    }

    public void setVente1(BigDecimal vente1) {
        this.vente1 = vente1;
    }

    @Basic
    @Column(name = "VENTE2")
    public BigDecimal getVente2() {
        return vente2;
    }

    public void setVente2(BigDecimal vente2) {
        this.vente2 = vente2;
    }

    @Basic
    @Column(name = "VENTE3")
    public BigDecimal getVente3() {
        return vente3;
    }

    public void setVente3(BigDecimal vente3) {
        this.vente3 = vente3;
    }

    @Basic
    @Column(name = "QUT_A1")
    public Integer getQutA1() {
        return qutA1;
    }

    public void setQutA1(Integer qutA1) {
        this.qutA1 = qutA1;
    }

    @Basic
    @Column(name = "MOIS1")
    public Integer getMois1() {
        return mois1;
    }

    public void setMois1(Integer mois1) {
        this.mois1 = mois1;
    }

    @Basic
    @Column(name = "MOIS2")
    public Integer getMois2() {
        return mois2;
    }

    public void setMois2(Integer mois2) {
        this.mois2 = mois2;
    }

    @Basic
    @Column(name = "MOIS3")
    public Integer getMois3() {
        return mois3;
    }

    public void setMois3(Integer mois3) {
        this.mois3 = mois3;
    }

    @Basic
    @Column(name = "MOIS4")
    public Integer getMois4() {
        return mois4;
    }

    public void setMois4(Integer mois4) {
        this.mois4 = mois4;
    }

    @Basic
    @Column(name = "MOIS5")
    public Integer getMois5() {
        return mois5;
    }

    public void setMois5(Integer mois5) {
        this.mois5 = mois5;
    }

    @Basic
    @Column(name = "MOIS6")
    public Integer getMois6() {
        return mois6;
    }

    public void setMois6(Integer mois6) {
        this.mois6 = mois6;
    }

    @Basic
    @Column(name = "MOIS7")
    public Integer getMois7() {
        return mois7;
    }

    public void setMois7(Integer mois7) {
        this.mois7 = mois7;
    }

    @Basic
    @Column(name = "MOIS8")
    public Integer getMois8() {
        return mois8;
    }

    public void setMois8(Integer mois8) {
        this.mois8 = mois8;
    }

    @Basic
    @Column(name = "MOIS9")
    public Integer getMois9() {
        return mois9;
    }

    public void setMois9(Integer mois9) {
        this.mois9 = mois9;
    }

    @Basic
    @Column(name = "MOIS10")
    public Integer getMois10() {
        return mois10;
    }

    public void setMois10(Integer mois10) {
        this.mois10 = mois10;
    }

    @Basic
    @Column(name = "MOIS11")
    public Integer getMois11() {
        return mois11;
    }

    public void setMois11(Integer mois11) {
        this.mois11 = mois11;
    }

    @Basic
    @Column(name = "MOIS12")
    public Integer getMois12() {
        return mois12;
    }

    public void setMois12(Integer mois12) {
        this.mois12 = mois12;
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
    @Column(name = "TAUX")
    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    @Basic
    @Column(name = "TOT")
    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    @Basic
    @Column(name = "CLASSE")
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
    
    @Basic
    @Column(name = "ANAL_STK")
    public Integer getAnalStk() {
        return analStk;
    }

    public void setAnalStk(Integer analStk) {
        this.analStk = analStk;
    }

    @Basic
    @Column(name = "NBJ_STK")
    public Integer getNbjStk() {
        return nbjStk;
    }

    public void setNbjStk(Integer nbjStk) {
        this.nbjStk = nbjStk;
    }

    @Basic
    @Column(name = "NBJ_COM")
    public Integer getNbjCom() {
        return nbjCom;
    }

    public void setNbjCom(Integer nbjCom) {
        this.nbjCom = nbjCom;
    }

    @Basic
    @Column(name = "V_SSTK")
    public Integer getvSstk() {
        return vSstk;
    }

    public void setvSstk(Integer vSstk) {
        this.vSstk = vSstk;
    }

    @Basic
    @Column(name = "TYP_ANAL")
    public String getTypAnal() {
        return typAnal;
    }

    public void setTypAnal(String typAnal) {
        this.typAnal = typAnal;
    }

    @Basic
    @Column(name = "FLAG1")
    public Byte getFlag1() {
        return flag1;
    }

    public void setFlag1(Byte flag1) {
        this.flag1 = flag1;
    }

    @Basic
    @Column(name = "FLAG2")
    public Byte getFlag2() {
        return flag2;
    }

    public void setFlag2(Byte flag2) {
        this.flag2 = flag2;
    }

    @Basic
    @Column(name = "COM_STK")
    public Integer getComStk() {
        return comStk;
    }

    public void setComStk(Integer comStk) {
        this.comStk = comStk;
    }

    @Basic
    @Column(name = "COM_NBJ")
    public Integer getComNbj() {
        return comNbj;
    }

    public void setComNbj(Integer comNbj) {
        this.comNbj = comNbj;
    }

    @Basic
    @Column(name = "CUMUL_DEM")
    public Integer getCumulDem() {
        return cumulDem;
    }

    public void setCumulDem(Integer cumulDem) {
        this.cumulDem = cumulDem;
    }

    @Basic
    @Column(name = "QUT_DOU")
    public Integer getQutDou() {
        return qutDou;
    }

    public void setQutDou(Integer qutDou) {
        this.qutDou = qutDou;
    }

    @Basic
    @Column(name = "XANAL_STK")
    public Integer getXanalStk() {
        return xanalStk;
    }

    public void setXanalStk(Integer xanalStk) {
        this.xanalStk = xanalStk;
    }

    @Basic
    @Column(name = "XTYP_ANAL")
    public Byte getXtypAnal() {
        return xtypAnal;
    }

    public void setXtypAnal(Byte xtypAnal) {
        this.xtypAnal = xtypAnal;
    }

    @Basic
    @Column(name = "XV_COM")
    public BigDecimal getXvCom() {
        return xvCom;
    }

    public void setXvCom(BigDecimal xvCom) {
        this.xvCom = xvCom;
    }

    @Basic
    @Column(name = "QUT_DEM")
    public Integer getQutDem() {
        return qutDem;
    }

    public void setQutDem(Integer qutDem) {
        this.qutDem = qutDem;
    }

    @Basic
    @Column(name = "QUT_CONF")
    public Integer getQutConf() {
        return qutConf;
    }

    public void setQutConf(Integer qutConf) {
        this.qutConf = qutConf;
    }

    @Basic
    @Column(name = "QUT_PROF")
    public Integer getQutProf() {
        return qutProf;
    }

    public void setQutProf(Integer qutProf) {
        this.qutProf = qutProf;
    }

    @Basic
    @Column(name = "PRIX_PROF")
    public Float getPrixProf() {
        return prixProf;
    }

    public void setPrixProf(Float prixProf) {
        this.prixProf = prixProf;
    }

    @Basic
    @Column(name = "PRIX_CONF")
    public Float getPrixConf() {
        return prixConf;
    }

    public void setPrixConf(Float prixConf) {
        this.prixConf = prixConf;
    }

    @Basic
    @Column(name = "QUT_SUP")
    public Integer getQutSup() {
        return qutSup;
    }

    public void setQutSup(Integer qutSup) {
        this.qutSup = qutSup;
    }

    @Basic
    @Column(name = "VEN_PER")
    public BigDecimal getVenPer() {
        return venPer;
    }

    public void setVenPer(BigDecimal venPer) {
        this.venPer = venPer;
    }

    @Basic
    @Column(name = "TARIF_FRS")
    public BigDecimal getTarifFrs() {
        return tarifFrs;
    }

    public void setTarifFrs(BigDecimal tarifFrs) {
        this.tarifFrs = tarifFrs;
    }

    @Basic
    @Column(name = "CONFR")
    public String getConfr() {
        return confr;
    }

    public void setConfr(String confr) {
        this.confr = confr;
    }

    @Basic
    @Column(name = "PRIX_A_M")
    public Float getPrixAM() {
        return prixAM;
    }

    public void setPrixAM(Float prixAM) {
        this.prixAM = prixAM;
    }

    @Basic
    @Column(name = "TYPE_V")
    public String getTypeV() {
        return typeV;
    }

    public void setTypeV(String typeV) {
        this.typeV = typeV;
    }

    @Basic
    @Column(name = "XPRIX_ACH")
    public Float getXprixAch() {
        return xprixAch;
    }

    public void setXprixAch(Float xprixAch) {
        this.xprixAch = xprixAch;
    }

    @Basic
    @Column(name = "T")
    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    @Basic
    @Column(name = "RELIQ")
    public Integer getReliq() {
        return reliq;
    }

    public void setReliq(Integer reliq) {
        this.reliq = reliq;
    }

    @Basic
    @Column(name = "DER_P_DEV")
    public BigDecimal getDerPDev() {
        return derPDev;
    }

    public void setDerPDev(BigDecimal derPDev) {
        this.derPDev = derPDev;
    }

    @Basic
    @Column(name = "PRIX_EURO")
    public Float getPrixEuro() {
        return prixEuro;
    }

    public void setPrixEuro(Float prixEuro) {
        this.prixEuro = prixEuro;
    }

    @Basic
    @Column(name = "CUMUL_RES")
    public Integer getCumulRes() {
        return cumulRes;
    }

    public void setCumulRes(Integer cumulRes) {
        this.cumulRes = cumulRes;
    }

    @Basic
    @Column(name = "DAT_RUP")
    public Timestamp getDatRup() {
        return datRup;
    }

    public void setDatRup(Timestamp datRup) {
        this.datRup = datRup;
    }

    @Basic
    @Column(name = "DAT_P_ACH")
    public Timestamp getDatPAch() {
        return datPAch;
    }

    public void setDatPAch(Timestamp datPAch) {
        this.datPAch = datPAch;
    }

    @Basic
    @Column(name = "COD_BAR")
    public String getCodBar() {
        return codBar;
    }

    public void setCodBar(String codBar) {
        this.codBar = codBar;
    }

    @Basic
    @Column(name = "CONTROLE")
    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    @Basic
    @Column(name = "MODELE")
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "ENERGIE")
    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    @Basic
    @Column(name = "POIDS")
    public BigDecimal getPoids() {
        return poids;
    }

    public void setPoids(BigDecimal poids) {
        this.poids = poids;
    }

    @Basic
    @Column(name = "VERSIONS")
    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    @Basic
    @Column(name = "SPECIAL1")
    public Boolean getSpecial1() {
        return special1;
    }

    public void setSpecial1(Boolean special1) {
        this.special1 = special1;
    }

    @Basic
    @Column(name = "SPECIAL2")
    public Boolean getSpecial2() {
        return special2;
    }

    public void setSpecial2(Boolean special2) {
        this.special2 = special2;
    }

    @Basic
    @Column(name = "SPECIAL3")
    public Boolean getSpecial3() {
        return special3;
    }

    public void setSpecial3(Boolean special3) {
        this.special3 = special3;
    }

    @Basic
    @Column(name = "SPECIAL4")
    public Boolean getSpecial4() {
        return special4;
    }

    public void setSpecial4(Boolean special4) {
        this.special4 = special4;
    }

    @Basic
    @Column(name = "SPECIAL5")
    public Boolean getSpecial5() {
        return special5;
    }

    public void setSpecial5(Boolean special5) {
        this.special5 = special5;
    }

    @Basic
    @Column(name = "SPECIAL6")
    public Boolean getSpecial6() {
        return special6;
    }

    public void setSpecial6(Boolean special6) {
        this.special6 = special6;
    }

    @Basic
    @Column(name = "SPECIAL7")
    public Boolean getSpecial7() {
        return special7;
    }

    public void setSpecial7(Boolean special7) {
        this.special7 = special7;
    }

    @Basic
    @Column(name = "SPECIAL8")
    public Boolean getSpecial8() {
        return special8;
    }

    public void setSpecial8(Boolean special8) {
        this.special8 = special8;
    }

    @Basic
    @Column(name = "SPECIAL9")
    public Boolean getSpecial9() {
        return special9;
    }

    public void setSpecial9(Boolean special9) {
        this.special9 = special9;
    }

    @Basic
    @Column(name = "SPECIAL10")
    public Boolean getSpecial10() {
        return special10;
    }

    public void setSpecial10(Boolean special10) {
        this.special10 = special10;
    }

    @Basic
    @Column(name = "SPECIAL11")
    public Boolean getSpecial11() {
        return special11;
    }

    public void setSpecial11(Boolean special11) {
        this.special11 = special11;
    }

    @Basic
    @Column(name = "SPECIAL12")
    public Boolean getSpecial12() {
        return special12;
    }

    public void setSpecial12(Boolean special12) {
        this.special12 = special12;
    }

    @Basic
    @Column(name = "SPECIAL13")
    public Boolean getSpecial13() {
        return special13;
    }

    public void setSpecial13(Boolean special13) {
        this.special13 = special13;
    }

    @Basic
    @Column(name = "OBSERVATIO")
    public String getObservatio() {
        return observatio;
    }

    public void setObservatio(String observatio) {
        this.observatio = observatio;
    }

    @Basic
    @Column(name = "DAT_CREAT")
    public Timestamp getDatCreat() {
        return datCreat;
    }

    public void setDatCreat(Timestamp datCreat) {
        this.datCreat = datCreat;
    }

    @Basic
    @Column(name = "NBJ_RUP")
    public Short getNbjRup() {
        return nbjRup;
    }

    public void setNbjRup(Short nbjRup) {
        this.nbjRup = nbjRup;
    }

    @Basic
    @Column(name = "NBJ_RUP1")
    public Short getNbjRup1() {
        return nbjRup1;
    }

    public void setNbjRup1(Short nbjRup1) {
        this.nbjRup1 = nbjRup1;
    }

    @Basic
    @Column(name = "M1")
    public Integer getM1() {
        return m1;
    }

    public void setM1(Integer m1) {
        this.m1 = m1;
    }

    @Basic
    @Column(name = "M2")
    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    @Basic
    @Column(name = "M3")
    public Integer getM3() {
        return m3;
    }

    public void setM3(Integer m3) {
        this.m3 = m3;
    }

    @Basic
    @Column(name = "M4")
    public Integer getM4() {
        return m4;
    }

    public void setM4(Integer m4) {
        this.m4 = m4;
    }

    @Basic
    @Column(name = "M5")
    public Integer getM5() {
        return m5;
    }

    public void setM5(Integer m5) {
        this.m5 = m5;
    }

    @Basic
    @Column(name = "M6")
    public Integer getM6() {
        return m6;
    }

    public void setM6(Integer m6) {
        this.m6 = m6;
    }

    @Basic
    @Column(name = "M7")
    public Integer getM7() {
        return m7;
    }

    public void setM7(Integer m7) {
        this.m7 = m7;
    }

    @Basic
    @Column(name = "M8")
    public Integer getM8() {
        return m8;
    }

    public void setM8(Integer m8) {
        this.m8 = m8;
    }

    @Basic
    @Column(name = "M9")
    public Integer getM9() {
        return m9;
    }

    public void setM9(Integer m9) {
        this.m9 = m9;
    }

    @Basic
    @Column(name = "M10")
    public Integer getM10() {
        return m10;
    }

    public void setM10(Integer m10) {
        this.m10 = m10;
    }

    @Basic
    @Column(name = "M11")
    public Integer getM11() {
        return m11;
    }

    public void setM11(Integer m11) {
        this.m11 = m11;
    }

    @Basic
    @Column(name = "M12")
    public Integer getM12() {
        return m12;
    }

    public void setM12(Integer m12) {
        this.m12 = m12;
    }

    @Basic
    @Column(name = "PRIX_C_EUR")
    public Float getPrixCEur() {
        return prixCEur;
    }

    public void setPrixCEur(Float prixCEur) {
        this.prixCEur = prixCEur;
    }

    @Basic
    @Column(name = "PRIX_INI")
    public Float getPrixIni() {
        return prixIni;
    }

    public void setPrixIni(Float prixIni) {
        this.prixIni = prixIni;
    }

    @Basic
    @Column(name = "CUMUL_ENT")
    public Integer getCumulEnt() {
        return cumulEnt;
    }

    public void setCumulEnt(Integer cumulEnt) {
        this.cumulEnt = cumulEnt;
    }

    @Basic
    @Column(name = "CUMUL_BS")
    public Integer getCumulBs() {
        return cumulBs;
    }

    public void setCumulBs(Integer cumulBs) {
        this.cumulBs = cumulBs;
    }

    @Basic
    @Column(name = "STK_ATRSF")
    public Integer getStkAtrsf() {
        return stkAtrsf;
    }

    public void setStkAtrsf(Integer stkAtrsf) {
        this.stkAtrsf = stkAtrsf;
    }

    @Basic
    @Column(name = "STK_TRSF")
    public Integer getStkTrsf() {
        return stkTrsf;
    }

    public void setStkTrsf(Integer stkTrsf) {
        this.stkTrsf = stkTrsf;
    }

    @Basic
    @Column(name = "CONS_MOY")
    public Integer getConsMoy() {
        return consMoy;
    }

    public void setConsMoy(Integer consMoy) {
        this.consMoy = consMoy;
    }

    @Basic
    @Column(name = "QUT_RAV")
    public Integer getQutRav() {
        return qutRav;
    }

    public void setQutRav(Integer qutRav) {
        this.qutRav = qutRav;
    }

    @Basic
    @Column(name = "QUT_DEP1")
    public Integer getQutDep1() {
        return qutDep1;
    }

    public void setQutDep1(Integer qutDep1) {
        this.qutDep1 = qutDep1;
    }

    @Basic
    @Column(name = "CUMUL_CONF")
    public Integer getCumulConf() {
        return cumulConf;
    }

    public void setCumulConf(Integer cumulConf) {
        this.cumulConf = cumulConf;
    }

    @Basic
    @Column(name = "POINTAGE")
    public Long getPointage() {
        return pointage;
    }

    public void setPointage(Long pointage) {
        this.pointage = pointage;
    }

    @Basic
    @Column(name = "POINTAGE1")
    public Long getPointage1() {
        return pointage1;
    }

    public void setPointage1(Long pointage1) {
        this.pointage1 = pointage1;
    }

    @Basic
    @Column(name = "POINTAGE2")
    public Long getPointage2() {
        return pointage2;
    }

    public void setPointage2(Long pointage2) {
        this.pointage2 = pointage2;
    }

    @Basic
    @Column(name = "TOTAL_POIN")
    public Long getTotalPoin() {
        return totalPoin;
    }

    public void setTotalPoin(Long totalPoin) {
        this.totalPoin = totalPoin;
    }

    @Basic
    @Column(name = "ETAGE2")
    public String getEtage2() {
        return etage2;
    }

    public void setEtage2(String etage2) {
        this.etage2 = etage2;
    }

    @Basic
    @Column(name = "FAMILLE")
    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    @Basic
    @Column(name = "S_FAMILLE")
    public String getsFamille() {
        return sFamille;
    }

    public void setsFamille(String sFamille) {
        this.sFamille = sFamille;
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
    @Column(name = "STK_REEL")
    public Integer getStkReel() {
        return stkReel;
    }

    public void setStkReel(Integer stkReel) {
        this.stkReel = stkReel;
    }

    @Basic
    @Column(name = "STK_RES")
    public Integer getStkRes() {
        return stkRes;
    }

    public void setStkRes(Integer stkRes) {
        this.stkRes = stkRes;
    }

    @Basic
    @Column(name = "STK_NP")
    public Integer getStkNp() {
        return stkNp;
    }

    public void setStkNp(Integer stkNp) {
        this.stkNp = stkNp;
    }
    public String getGalery() {
        return galery;
    }

    public void setGalery(String galery) {
        this.galery = galery;
    }

/* Fk start */
    public DetEmba getDetembas_articles() {
        return detembas_articles;
    }

    public void setDetembas_articles(DetEmba detembas_articles) {
        this.detembas_articles = detembas_articles;
    }

    public List<BonPrep> getBonpreps() {
        return bonpreps;
    }

    public void setBonpreps(List<BonPrep> bonpreps) {
        this.bonpreps = bonpreps;
    }

    public List<BonLiv> getBonlivs() {
        return bonlivs;
    }

    public void setBonlivs(List<BonLiv> bonlivs) {
        this.bonlivs = bonlivs;
    }


    public void setBonsorts(List<BonSort> bonsorts) {
        this.bonsorts = bonsorts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((achatss == null) ? 0 : achatss.hashCode());
        result = prime * result + ((analStk == null) ? 0 : analStk.hashCode());
        result = prime * result + ((bonlivs == null) ? 0 : bonlivs.hashCode());
        result = prime * result + ((bonpreps == null) ? 0 : bonpreps.hashCode());
        result = prime * result + ((bonsorts == null) ? 0 : bonsorts.hashCode());
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((chifAff == null) ? 0 : chifAff.hashCode());
        result = prime * result + ((classe == null) ? 0 : classe.hashCode());
        result = prime * result + ((codArt == null) ? 0 : codArt.hashCode());
        result = prime * result + ((codBar == null) ? 0 : codBar.hashCode());
        result = prime * result + (int) (codFrs ^ (codFrs >>> 32));
        result = prime * result + ((codNgp == null) ? 0 : codNgp.hashCode());
        result = prime * result + ((coef == null) ? 0 : coef.hashCode());
        result = prime * result + ((comNbj == null) ? 0 : comNbj.hashCode());
        result = prime * result + ((comStk == null) ? 0 : comStk.hashCode());
        result = prime * result + ((confr == null) ? 0 : confr.hashCode());
        result = prime * result + ((consMoy == null) ? 0 : consMoy.hashCode());
        result = prime * result + ((controle == null) ? 0 : controle.hashCode());
        result = prime * result + ((cours == null) ? 0 : cours.hashCode());
        result = prime * result + ((cumulAch == null) ? 0 : cumulAch.hashCode());
        result = prime * result + ((cumulBs == null) ? 0 : cumulBs.hashCode());
        result = prime * result + ((cumulConf == null) ? 0 : cumulConf.hashCode());
        result = prime * result + ((cumulDem == null) ? 0 : cumulDem.hashCode());
        result = prime * result + ((cumulEnt == null) ? 0 : cumulEnt.hashCode());
        result = prime * result + ((cumulRes == null) ? 0 : cumulRes.hashCode());
        result = prime * result + ((cumulVen == null) ? 0 : cumulVen.hashCode());
        result = prime * result + ((datCreat == null) ? 0 : datCreat.hashCode());
        result = prime * result + ((datPAch == null) ? 0 : datPAch.hashCode());
        result = prime * result + ((datRup == null) ? 0 : datRup.hashCode());
        result = prime * result + ((derAch == null) ? 0 : derAch.hashCode());
        result = prime * result + ((derMvt == null) ? 0 : derMvt.hashCode());
        result = prime * result + ((derPAch == null) ? 0 : derPAch.hashCode());
        result = prime * result + ((derPDev == null) ? 0 : derPDev.hashCode());
        result = prime * result + ((desArt == null) ? 0 : desArt.hashCode());
        result = prime * result + ((detembas_articles == null) ? 0 : detembas_articles.hashCode());
        result = prime * result + ((energie == null) ? 0 : energie.hashCode());
        result = prime * result + ((etage2 == null) ? 0 : etage2.hashCode());
        result = prime * result + ((famille == null) ? 0 : famille.hashCode());
        result = prime * result + ((flag1 == null) ? 0 : flag1.hashCode());
        result = prime * result + ((flag2 == null) ? 0 : flag2.hashCode());
        result = prime * result + ((galery == null) ? 0 : galery.hashCode());
        result = prime * result + ((m1 == null) ? 0 : m1.hashCode());
        result = prime * result + ((m10 == null) ? 0 : m10.hashCode());
        result = prime * result + ((m11 == null) ? 0 : m11.hashCode());
        result = prime * result + ((m12 == null) ? 0 : m12.hashCode());
        result = prime * result + ((m2 == null) ? 0 : m2.hashCode());
        result = prime * result + ((m3 == null) ? 0 : m3.hashCode());
        result = prime * result + ((m4 == null) ? 0 : m4.hashCode());
        result = prime * result + ((m5 == null) ? 0 : m5.hashCode());
        result = prime * result + ((m6 == null) ? 0 : m6.hashCode());
        result = prime * result + ((m7 == null) ? 0 : m7.hashCode());
        result = prime * result + ((m8 == null) ? 0 : m8.hashCode());
        result = prime * result + ((m9 == null) ? 0 : m9.hashCode());
        result = prime * result + ((marque == null) ? 0 : marque.hashCode());
        result = prime * result + ((modele == null) ? 0 : modele.hashCode());
        result = prime * result + ((mois1 == null) ? 0 : mois1.hashCode());
        result = prime * result + ((mois10 == null) ? 0 : mois10.hashCode());
        result = prime * result + ((mois11 == null) ? 0 : mois11.hashCode());
        result = prime * result + ((mois12 == null) ? 0 : mois12.hashCode());
        result = prime * result + ((mois2 == null) ? 0 : mois2.hashCode());
        result = prime * result + ((mois3 == null) ? 0 : mois3.hashCode());
        result = prime * result + ((mois4 == null) ? 0 : mois4.hashCode());
        result = prime * result + ((mois5 == null) ? 0 : mois5.hashCode());
        result = prime * result + ((mois6 == null) ? 0 : mois6.hashCode());
        result = prime * result + ((mois7 == null) ? 0 : mois7.hashCode());
        result = prime * result + ((mois8 == null) ? 0 : mois8.hashCode());
        result = prime * result + ((mois9 == null) ? 0 : mois9.hashCode());
        result = prime * result + ((nbjCom == null) ? 0 : nbjCom.hashCode());
        result = prime * result + ((nbjRup == null) ? 0 : nbjRup.hashCode());
        result = prime * result + ((nbjRup1 == null) ? 0 : nbjRup1.hashCode());
        result = prime * result + ((nbjStk == null) ? 0 : nbjStk.hashCode());
        result = prime * result + ((numCas == null) ? 0 : numCas.hashCode());
        result = prime * result + ((observatio == null) ? 0 : observatio.hashCode());
        result = prime * result + ((pValu == null) ? 0 : pValu.hashCode());
        result = prime * result + ((poids == null) ? 0 : poids.hashCode());
        result = prime * result + ((pointage == null) ? 0 : pointage.hashCode());
        result = prime * result + ((pointage1 == null) ? 0 : pointage1.hashCode());
        result = prime * result + ((pointage2 == null) ? 0 : pointage2.hashCode());
        result = prime * result + ((prixAM == null) ? 0 : prixAM.hashCode());
        result = prime * result + ((prixAch == null) ? 0 : prixAch.hashCode());
        result = prime * result + ((prixArem == null) ? 0 : prixArem.hashCode());
        result = prime * result + ((prixCEur == null) ? 0 : prixCEur.hashCode());
        result = prime * result + ((prixConf == null) ? 0 : prixConf.hashCode());
        result = prime * result + ((prixDev == null) ? 0 : prixDev.hashCode());
        result = prime * result + ((prixEuro == null) ? 0 : prixEuro.hashCode());
        result = prime * result + ((prixIni == null) ? 0 : prixIni.hashCode());
        result = prime * result + ((prixMin == null) ? 0 : prixMin.hashCode());
        result = prime * result + ((prixProf == null) ? 0 : prixProf.hashCode());
        result = prime * result + ((prixVen == null) ? 0 : prixVen.hashCode());
        result = prime * result + ((qutA1 == null) ? 0 : qutA1.hashCode());
        result = prime * result + ((qutConf == null) ? 0 : qutConf.hashCode());
        result = prime * result + ((qutDem == null) ? 0 : qutDem.hashCode());
        result = prime * result + ((qutDep == null) ? 0 : qutDep.hashCode());
        result = prime * result + ((qutDep1 == null) ? 0 : qutDep1.hashCode());
        result = prime * result + ((qutDou == null) ? 0 : qutDou.hashCode());
        result = prime * result + ((qutMax == null) ? 0 : qutMax.hashCode());
        result = prime * result + ((qutMin == null) ? 0 : qutMin.hashCode());
        result = prime * result + ((qutProf == null) ? 0 : qutProf.hashCode());
        result = prime * result + ((qutRav == null) ? 0 : qutRav.hashCode());
        result = prime * result + ((qutStk == null) ? 0 : qutStk.hashCode());
        result = prime * result + ((qutStk2 == null) ? 0 : qutStk2.hashCode());
        result = prime * result + ((qutSup == null) ? 0 : qutSup.hashCode());
        result = prime * result + ((qutV1 == null) ? 0 : qutV1.hashCode());
        result = prime * result + ((qutV2 == null) ? 0 : qutV2.hashCode());
        result = prime * result + ((qutV3 == null) ? 0 : qutV3.hashCode());
        result = prime * result + ((refOrg == null) ? 0 : refOrg.hashCode());
        result = prime * result + ((refRem == null) ? 0 : refRem.hashCode());
        result = prime * result + ((reliq == null) ? 0 : reliq.hashCode());
        result = prime * result + ((remise == null) ? 0 : remise.hashCode());
        result = prime * result + ((sFamille == null) ? 0 : sFamille.hashCode());
        result = prime * result + ((special1 == null) ? 0 : special1.hashCode());
        result = prime * result + ((special10 == null) ? 0 : special10.hashCode());
        result = prime * result + ((special11 == null) ? 0 : special11.hashCode());
        result = prime * result + ((special12 == null) ? 0 : special12.hashCode());
        result = prime * result + ((special13 == null) ? 0 : special13.hashCode());
        result = prime * result + ((special2 == null) ? 0 : special2.hashCode());
        result = prime * result + ((special3 == null) ? 0 : special3.hashCode());
        result = prime * result + ((special4 == null) ? 0 : special4.hashCode());
        result = prime * result + ((special5 == null) ? 0 : special5.hashCode());
        result = prime * result + ((special6 == null) ? 0 : special6.hashCode());
        result = prime * result + ((special7 == null) ? 0 : special7.hashCode());
        result = prime * result + ((special8 == null) ? 0 : special8.hashCode());
        result = prime * result + ((special9 == null) ? 0 : special9.hashCode());
        result = prime * result + ((stkAtrsf == null) ? 0 : stkAtrsf.hashCode());
        result = prime * result + ((stkGar == null) ? 0 : stkGar.hashCode());
        result = prime * result + ((stkIni == null) ? 0 : stkIni.hashCode());
        result = prime * result + ((stkNp == null) ? 0 : stkNp.hashCode());
        result = prime * result + ((stkReel == null) ? 0 : stkReel.hashCode());
        result = prime * result + ((stkRes == null) ? 0 : stkRes.hashCode());
        result = prime * result + ((stkTrsf == null) ? 0 : stkTrsf.hashCode());
        result = prime * result + ((t == null) ? 0 : t.hashCode());
        result = prime * result + ((tarifFrs == null) ? 0 : tarifFrs.hashCode());
        result = prime * result + ((taux == null) ? 0 : taux.hashCode());
        result = prime * result + ((tot == null) ? 0 : tot.hashCode());
        result = prime * result + ((totalPoin == null) ? 0 : totalPoin.hashCode());
        result = prime * result + ((tva == null) ? 0 : tva.hashCode());
        result = prime * result + ((typAnal == null) ? 0 : typAnal.hashCode());
        result = prime * result + ((typeV == null) ? 0 : typeV.hashCode());
        result = prime * result + ((unitInv == null) ? 0 : unitInv.hashCode());
        result = prime * result + ((unitVen == null) ? 0 : unitVen.hashCode());
        result = prime * result + ((vSstk == null) ? 0 : vSstk.hashCode());
        result = prime * result + ((venPer == null) ? 0 : venPer.hashCode());
        result = prime * result + ((vente1 == null) ? 0 : vente1.hashCode());
        result = prime * result + ((vente2 == null) ? 0 : vente2.hashCode());
        result = prime * result + ((vente3 == null) ? 0 : vente3.hashCode());
        result = prime * result + ((versions == null) ? 0 : versions.hashCode());
        result = prime * result + ((xanalStk == null) ? 0 : xanalStk.hashCode());
        result = prime * result + ((xprixAch == null) ? 0 : xprixAch.hashCode());
        result = prime * result + ((xtypAnal == null) ? 0 : xtypAnal.hashCode());
        result = prime * result + ((xvCom == null) ? 0 : xvCom.hashCode());
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
        Article other = (Article) obj;
        if (achatss == null) {
            if (other.achatss != null)
                return false;
        } else if (!achatss.equals(other.achatss))
            return false;
        if (analStk == null) {
            if (other.analStk != null)
                return false;
        } else if (!analStk.equals(other.analStk))
            return false;
        if (bonlivs == null) {
            if (other.bonlivs != null)
                return false;
        } else if (!bonlivs.equals(other.bonlivs))
            return false;
        if (bonpreps == null) {
            if (other.bonpreps != null)
                return false;
        } else if (!bonpreps.equals(other.bonpreps))
            return false;
        if (bonsorts == null) {
            if (other.bonsorts != null)
                return false;
        } else if (!bonsorts.equals(other.bonsorts))
            return false;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (chifAff == null) {
            if (other.chifAff != null)
                return false;
        } else if (!chifAff.equals(other.chifAff))
            return false;
        if (classe == null) {
            if (other.classe != null)
                return false;
        } else if (!classe.equals(other.classe))
            return false;
        if (codArt == null) {
            if (other.codArt != null)
                return false;
        } else if (!codArt.equals(other.codArt))
            return false;
        if (codBar == null) {
            if (other.codBar != null)
                return false;
        } else if (!codBar.equals(other.codBar))
            return false;
        if (codFrs != other.codFrs)
            return false;
        if (codNgp == null) {
            if (other.codNgp != null)
                return false;
        } else if (!codNgp.equals(other.codNgp))
            return false;
        if (coef == null) {
            if (other.coef != null)
                return false;
        } else if (!coef.equals(other.coef))
            return false;
        if (comNbj == null) {
            if (other.comNbj != null)
                return false;
        } else if (!comNbj.equals(other.comNbj))
            return false;
        if (comStk == null) {
            if (other.comStk != null)
                return false;
        } else if (!comStk.equals(other.comStk))
            return false;
        if (confr == null) {
            if (other.confr != null)
                return false;
        } else if (!confr.equals(other.confr))
            return false;
        if (consMoy == null) {
            if (other.consMoy != null)
                return false;
        } else if (!consMoy.equals(other.consMoy))
            return false;
        if (controle == null) {
            if (other.controle != null)
                return false;
        } else if (!controle.equals(other.controle))
            return false;
        if (cours == null) {
            if (other.cours != null)
                return false;
        } else if (!cours.equals(other.cours))
            return false;
        if (cumulAch == null) {
            if (other.cumulAch != null)
                return false;
        } else if (!cumulAch.equals(other.cumulAch))
            return false;
        if (cumulBs == null) {
            if (other.cumulBs != null)
                return false;
        } else if (!cumulBs.equals(other.cumulBs))
            return false;
        if (cumulConf == null) {
            if (other.cumulConf != null)
                return false;
        } else if (!cumulConf.equals(other.cumulConf))
            return false;
        if (cumulDem == null) {
            if (other.cumulDem != null)
                return false;
        } else if (!cumulDem.equals(other.cumulDem))
            return false;
        if (cumulEnt == null) {
            if (other.cumulEnt != null)
                return false;
        } else if (!cumulEnt.equals(other.cumulEnt))
            return false;
        if (cumulRes == null) {
            if (other.cumulRes != null)
                return false;
        } else if (!cumulRes.equals(other.cumulRes))
            return false;
        if (cumulVen == null) {
            if (other.cumulVen != null)
                return false;
        } else if (!cumulVen.equals(other.cumulVen))
            return false;
        if (datCreat == null) {
            if (other.datCreat != null)
                return false;
        } else if (!datCreat.equals(other.datCreat))
            return false;
        if (datPAch == null) {
            if (other.datPAch != null)
                return false;
        } else if (!datPAch.equals(other.datPAch))
            return false;
        if (datRup == null) {
            if (other.datRup != null)
                return false;
        } else if (!datRup.equals(other.datRup))
            return false;
        if (derAch == null) {
            if (other.derAch != null)
                return false;
        } else if (!derAch.equals(other.derAch))
            return false;
        if (derMvt == null) {
            if (other.derMvt != null)
                return false;
        } else if (!derMvt.equals(other.derMvt))
            return false;
        if (derPAch == null) {
            if (other.derPAch != null)
                return false;
        } else if (!derPAch.equals(other.derPAch))
            return false;
        if (derPDev == null) {
            if (other.derPDev != null)
                return false;
        } else if (!derPDev.equals(other.derPDev))
            return false;
        if (desArt == null) {
            if (other.desArt != null)
                return false;
        } else if (!desArt.equals(other.desArt))
            return false;
        if (detembas_articles == null) {
            if (other.detembas_articles != null)
                return false;
        } else if (!detembas_articles.equals(other.detembas_articles))
            return false;
        if (energie == null) {
            if (other.energie != null)
                return false;
        } else if (!energie.equals(other.energie))
            return false;
        if (etage2 == null) {
            if (other.etage2 != null)
                return false;
        } else if (!etage2.equals(other.etage2))
            return false;
        if (famille == null) {
            if (other.famille != null)
                return false;
        } else if (!famille.equals(other.famille))
            return false;
        if (flag1 == null) {
            if (other.flag1 != null)
                return false;
        } else if (!flag1.equals(other.flag1))
            return false;
        if (flag2 == null) {
            if (other.flag2 != null)
                return false;
        } else if (!flag2.equals(other.flag2))
            return false;
        if (galery == null) {
            if (other.galery != null)
                return false;
        } else if (!galery.equals(other.galery))
            return false;
        if (m1 == null) {
            if (other.m1 != null)
                return false;
        } else if (!m1.equals(other.m1))
            return false;
        if (m10 == null) {
            if (other.m10 != null)
                return false;
        } else if (!m10.equals(other.m10))
            return false;
        if (m11 == null) {
            if (other.m11 != null)
                return false;
        } else if (!m11.equals(other.m11))
            return false;
        if (m12 == null) {
            if (other.m12 != null)
                return false;
        } else if (!m12.equals(other.m12))
            return false;
        if (m2 == null) {
            if (other.m2 != null)
                return false;
        } else if (!m2.equals(other.m2))
            return false;
        if (m3 == null) {
            if (other.m3 != null)
                return false;
        } else if (!m3.equals(other.m3))
            return false;
        if (m4 == null) {
            if (other.m4 != null)
                return false;
        } else if (!m4.equals(other.m4))
            return false;
        if (m5 == null) {
            if (other.m5 != null)
                return false;
        } else if (!m5.equals(other.m5))
            return false;
        if (m6 == null) {
            if (other.m6 != null)
                return false;
        } else if (!m6.equals(other.m6))
            return false;
        if (m7 == null) {
            if (other.m7 != null)
                return false;
        } else if (!m7.equals(other.m7))
            return false;
        if (m8 == null) {
            if (other.m8 != null)
                return false;
        } else if (!m8.equals(other.m8))
            return false;
        if (m9 == null) {
            if (other.m9 != null)
                return false;
        } else if (!m9.equals(other.m9))
            return false;
        if (marque == null) {
            if (other.marque != null)
                return false;
        } else if (!marque.equals(other.marque))
            return false;
        if (modele == null) {
            if (other.modele != null)
                return false;
        } else if (!modele.equals(other.modele))
            return false;
        if (mois1 == null) {
            if (other.mois1 != null)
                return false;
        } else if (!mois1.equals(other.mois1))
            return false;
        if (mois10 == null) {
            if (other.mois10 != null)
                return false;
        } else if (!mois10.equals(other.mois10))
            return false;
        if (mois11 == null) {
            if (other.mois11 != null)
                return false;
        } else if (!mois11.equals(other.mois11))
            return false;
        if (mois12 == null) {
            if (other.mois12 != null)
                return false;
        } else if (!mois12.equals(other.mois12))
            return false;
        if (mois2 == null) {
            if (other.mois2 != null)
                return false;
        } else if (!mois2.equals(other.mois2))
            return false;
        if (mois3 == null) {
            if (other.mois3 != null)
                return false;
        } else if (!mois3.equals(other.mois3))
            return false;
        if (mois4 == null) {
            if (other.mois4 != null)
                return false;
        } else if (!mois4.equals(other.mois4))
            return false;
        if (mois5 == null) {
            if (other.mois5 != null)
                return false;
        } else if (!mois5.equals(other.mois5))
            return false;
        if (mois6 == null) {
            if (other.mois6 != null)
                return false;
        } else if (!mois6.equals(other.mois6))
            return false;
        if (mois7 == null) {
            if (other.mois7 != null)
                return false;
        } else if (!mois7.equals(other.mois7))
            return false;
        if (mois8 == null) {
            if (other.mois8 != null)
                return false;
        } else if (!mois8.equals(other.mois8))
            return false;
        if (mois9 == null) {
            if (other.mois9 != null)
                return false;
        } else if (!mois9.equals(other.mois9))
            return false;
        if (nbjCom == null) {
            if (other.nbjCom != null)
                return false;
        } else if (!nbjCom.equals(other.nbjCom))
            return false;
        if (nbjRup == null) {
            if (other.nbjRup != null)
                return false;
        } else if (!nbjRup.equals(other.nbjRup))
            return false;
        if (nbjRup1 == null) {
            if (other.nbjRup1 != null)
                return false;
        } else if (!nbjRup1.equals(other.nbjRup1))
            return false;
        if (nbjStk == null) {
            if (other.nbjStk != null)
                return false;
        } else if (!nbjStk.equals(other.nbjStk))
            return false;
        if (numCas == null) {
            if (other.numCas != null)
                return false;
        } else if (!numCas.equals(other.numCas))
            return false;
        if (observatio == null) {
            if (other.observatio != null)
                return false;
        } else if (!observatio.equals(other.observatio))
            return false;
        if (pValu == null) {
            if (other.pValu != null)
                return false;
        } else if (!pValu.equals(other.pValu))
            return false;
        if (poids == null) {
            if (other.poids != null)
                return false;
        } else if (!poids.equals(other.poids))
            return false;
        if (pointage == null) {
            if (other.pointage != null)
                return false;
        } else if (!pointage.equals(other.pointage))
            return false;
        if (pointage1 == null) {
            if (other.pointage1 != null)
                return false;
        } else if (!pointage1.equals(other.pointage1))
            return false;
        if (pointage2 == null) {
            if (other.pointage2 != null)
                return false;
        } else if (!pointage2.equals(other.pointage2))
            return false;
        if (prixAM == null) {
            if (other.prixAM != null)
                return false;
        } else if (!prixAM.equals(other.prixAM))
            return false;
        if (prixAch == null) {
            if (other.prixAch != null)
                return false;
        } else if (!prixAch.equals(other.prixAch))
            return false;
        if (prixArem == null) {
            if (other.prixArem != null)
                return false;
        } else if (!prixArem.equals(other.prixArem))
            return false;
        if (prixCEur == null) {
            if (other.prixCEur != null)
                return false;
        } else if (!prixCEur.equals(other.prixCEur))
            return false;
        if (prixConf == null) {
            if (other.prixConf != null)
                return false;
        } else if (!prixConf.equals(other.prixConf))
            return false;
        if (prixDev == null) {
            if (other.prixDev != null)
                return false;
        } else if (!prixDev.equals(other.prixDev))
            return false;
        if (prixEuro == null) {
            if (other.prixEuro != null)
                return false;
        } else if (!prixEuro.equals(other.prixEuro))
            return false;
        if (prixIni == null) {
            if (other.prixIni != null)
                return false;
        } else if (!prixIni.equals(other.prixIni))
            return false;
        if (prixMin == null) {
            if (other.prixMin != null)
                return false;
        } else if (!prixMin.equals(other.prixMin))
            return false;
        if (prixProf == null) {
            if (other.prixProf != null)
                return false;
        } else if (!prixProf.equals(other.prixProf))
            return false;
        if (prixVen == null) {
            if (other.prixVen != null)
                return false;
        } else if (!prixVen.equals(other.prixVen))
            return false;
        if (qutA1 == null) {
            if (other.qutA1 != null)
                return false;
        } else if (!qutA1.equals(other.qutA1))
            return false;
        if (qutConf == null) {
            if (other.qutConf != null)
                return false;
        } else if (!qutConf.equals(other.qutConf))
            return false;
        if (qutDem == null) {
            if (other.qutDem != null)
                return false;
        } else if (!qutDem.equals(other.qutDem))
            return false;
        if (qutDep == null) {
            if (other.qutDep != null)
                return false;
        } else if (!qutDep.equals(other.qutDep))
            return false;
        if (qutDep1 == null) {
            if (other.qutDep1 != null)
                return false;
        } else if (!qutDep1.equals(other.qutDep1))
            return false;
        if (qutDou == null) {
            if (other.qutDou != null)
                return false;
        } else if (!qutDou.equals(other.qutDou))
            return false;
        if (qutMax == null) {
            if (other.qutMax != null)
                return false;
        } else if (!qutMax.equals(other.qutMax))
            return false;
        if (qutMin == null) {
            if (other.qutMin != null)
                return false;
        } else if (!qutMin.equals(other.qutMin))
            return false;
        if (qutProf == null) {
            if (other.qutProf != null)
                return false;
        } else if (!qutProf.equals(other.qutProf))
            return false;
        if (qutRav == null) {
            if (other.qutRav != null)
                return false;
        } else if (!qutRav.equals(other.qutRav))
            return false;
        if (qutStk == null) {
            if (other.qutStk != null)
                return false;
        } else if (!qutStk.equals(other.qutStk))
            return false;
        if (qutStk2 == null) {
            if (other.qutStk2 != null)
                return false;
        } else if (!qutStk2.equals(other.qutStk2))
            return false;
        if (qutSup == null) {
            if (other.qutSup != null)
                return false;
        } else if (!qutSup.equals(other.qutSup))
            return false;
        if (qutV1 == null) {
            if (other.qutV1 != null)
                return false;
        } else if (!qutV1.equals(other.qutV1))
            return false;
        if (qutV2 == null) {
            if (other.qutV2 != null)
                return false;
        } else if (!qutV2.equals(other.qutV2))
            return false;
        if (qutV3 == null) {
            if (other.qutV3 != null)
                return false;
        } else if (!qutV3.equals(other.qutV3))
            return false;
        if (refOrg == null) {
            if (other.refOrg != null)
                return false;
        } else if (!refOrg.equals(other.refOrg))
            return false;
        if (refRem == null) {
            if (other.refRem != null)
                return false;
        } else if (!refRem.equals(other.refRem))
            return false;
        if (reliq == null) {
            if (other.reliq != null)
                return false;
        } else if (!reliq.equals(other.reliq))
            return false;
        if (remise == null) {
            if (other.remise != null)
                return false;
        } else if (!remise.equals(other.remise))
            return false;
        if (sFamille == null) {
            if (other.sFamille != null)
                return false;
        } else if (!sFamille.equals(other.sFamille))
            return false;
        if (special1 == null) {
            if (other.special1 != null)
                return false;
        } else if (!special1.equals(other.special1))
            return false;
        if (special10 == null) {
            if (other.special10 != null)
                return false;
        } else if (!special10.equals(other.special10))
            return false;
        if (special11 == null) {
            if (other.special11 != null)
                return false;
        } else if (!special11.equals(other.special11))
            return false;
        if (special12 == null) {
            if (other.special12 != null)
                return false;
        } else if (!special12.equals(other.special12))
            return false;
        if (special13 == null) {
            if (other.special13 != null)
                return false;
        } else if (!special13.equals(other.special13))
            return false;
        if (special2 == null) {
            if (other.special2 != null)
                return false;
        } else if (!special2.equals(other.special2))
            return false;
        if (special3 == null) {
            if (other.special3 != null)
                return false;
        } else if (!special3.equals(other.special3))
            return false;
        if (special4 == null) {
            if (other.special4 != null)
                return false;
        } else if (!special4.equals(other.special4))
            return false;
        if (special5 == null) {
            if (other.special5 != null)
                return false;
        } else if (!special5.equals(other.special5))
            return false;
        if (special6 == null) {
            if (other.special6 != null)
                return false;
        } else if (!special6.equals(other.special6))
            return false;
        if (special7 == null) {
            if (other.special7 != null)
                return false;
        } else if (!special7.equals(other.special7))
            return false;
        if (special8 == null) {
            if (other.special8 != null)
                return false;
        } else if (!special8.equals(other.special8))
            return false;
        if (special9 == null) {
            if (other.special9 != null)
                return false;
        } else if (!special9.equals(other.special9))
            return false;
        if (stkAtrsf == null) {
            if (other.stkAtrsf != null)
                return false;
        } else if (!stkAtrsf.equals(other.stkAtrsf))
            return false;
        if (stkGar == null) {
            if (other.stkGar != null)
                return false;
        } else if (!stkGar.equals(other.stkGar))
            return false;
        if (stkIni == null) {
            if (other.stkIni != null)
                return false;
        } else if (!stkIni.equals(other.stkIni))
            return false;
        if (stkNp == null) {
            if (other.stkNp != null)
                return false;
        } else if (!stkNp.equals(other.stkNp))
            return false;
        if (stkReel == null) {
            if (other.stkReel != null)
                return false;
        } else if (!stkReel.equals(other.stkReel))
            return false;
        if (stkRes == null) {
            if (other.stkRes != null)
                return false;
        } else if (!stkRes.equals(other.stkRes))
            return false;
        if (stkTrsf == null) {
            if (other.stkTrsf != null)
                return false;
        } else if (!stkTrsf.equals(other.stkTrsf))
            return false;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        if (tarifFrs == null) {
            if (other.tarifFrs != null)
                return false;
        } else if (!tarifFrs.equals(other.tarifFrs))
            return false;
        if (taux == null) {
            if (other.taux != null)
                return false;
        } else if (!taux.equals(other.taux))
            return false;
        if (tot == null) {
            if (other.tot != null)
                return false;
        } else if (!tot.equals(other.tot))
            return false;
        if (totalPoin == null) {
            if (other.totalPoin != null)
                return false;
        } else if (!totalPoin.equals(other.totalPoin))
            return false;
        if (tva == null) {
            if (other.tva != null)
                return false;
        } else if (!tva.equals(other.tva))
            return false;
        if (typAnal == null) {
            if (other.typAnal != null)
                return false;
        } else if (!typAnal.equals(other.typAnal))
            return false;
        if (typeV == null) {
            if (other.typeV != null)
                return false;
        } else if (!typeV.equals(other.typeV))
            return false;
        if (unitInv == null) {
            if (other.unitInv != null)
                return false;
        } else if (!unitInv.equals(other.unitInv))
            return false;
        if (unitVen == null) {
            if (other.unitVen != null)
                return false;
        } else if (!unitVen.equals(other.unitVen))
            return false;
        if (vSstk == null) {
            if (other.vSstk != null)
                return false;
        } else if (!vSstk.equals(other.vSstk))
            return false;
        if (venPer == null) {
            if (other.venPer != null)
                return false;
        } else if (!venPer.equals(other.venPer))
            return false;
        if (vente1 == null) {
            if (other.vente1 != null)
                return false;
        } else if (!vente1.equals(other.vente1))
            return false;
        if (vente2 == null) {
            if (other.vente2 != null)
                return false;
        } else if (!vente2.equals(other.vente2))
            return false;
        if (vente3 == null) {
            if (other.vente3 != null)
                return false;
        } else if (!vente3.equals(other.vente3))
            return false;
        if (versions == null) {
            if (other.versions != null)
                return false;
        } else if (!versions.equals(other.versions))
            return false;
        if (xanalStk == null) {
            if (other.xanalStk != null)
                return false;
        } else if (!xanalStk.equals(other.xanalStk))
            return false;
        if (xprixAch == null) {
            if (other.xprixAch != null)
                return false;
        } else if (!xprixAch.equals(other.xprixAch))
            return false;
        if (xtypAnal == null) {
            if (other.xtypAnal != null)
                return false;
        } else if (!xtypAnal.equals(other.xtypAnal))
            return false;
        if (xvCom == null) {
            if (other.xvCom != null)
                return false;
        } else if (!xvCom.equals(other.xvCom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Article [achatss=" + achatss + ", analStk=" + analStk + ", bonlivs=" + bonlivs + ", bonpreps="
                + bonpreps + ", bonsorts=" + bonsorts + ", centre=" + centre + ", chifAff=" + chifAff + ", classe="
                + classe + ", codArt=" + codArt + ", codBar=" + codBar + ", codFrs=" + codFrs + ", codNgp=" + codNgp
                + ", coef=" + coef + ", comNbj=" + comNbj + ", comStk=" + comStk + ", confr=" + confr + ", consMoy="
                + consMoy + ", controle=" + controle + ", cours=" + cours + ", cumulAch=" + cumulAch + ", cumulBs="
                + cumulBs + ", cumulConf=" + cumulConf + ", cumulDem=" + cumulDem + ", cumulEnt=" + cumulEnt
                + ", cumulRes=" + cumulRes + ", cumulVen=" + cumulVen + ", datCreat=" + datCreat + ", datPAch="
                + datPAch + ", datRup=" + datRup + ", derAch=" + derAch + ", derMvt=" + derMvt + ", derPAch=" + derPAch
                + ", derPDev=" + derPDev + ", desArt=" + desArt + ", detembas_articles=" + detembas_articles
                + ", energie=" + energie + ", etage2=" + etage2 + ", famille=" + famille + ", flag1=" + flag1
                + ", flag2=" + flag2 + ", galery=" + galery + ", m1=" + m1 + ", m10=" + m10 + ", m11=" + m11 + ", m12="
                + m12 + ", m2=" + m2 + ", m3=" + m3 + ", m4=" + m4 + ", m5=" + m5 + ", m6=" + m6 + ", m7=" + m7
                + ", m8=" + m8 + ", m9=" + m9 + ", marque=" + marque + ", modele=" + modele + ", mois1=" + mois1
                + ", mois10=" + mois10 + ", mois11=" + mois11 + ", mois12=" + mois12 + ", mois2=" + mois2 + ", mois3="
                + mois3 + ", mois4=" + mois4 + ", mois5=" + mois5 + ", mois6=" + mois6 + ", mois7=" + mois7 + ", mois8="
                + mois8 + ", mois9=" + mois9 + ", nbjCom=" + nbjCom + ", nbjRup=" + nbjRup + ", nbjRup1=" + nbjRup1
                + ", nbjStk=" + nbjStk + ", numCas=" + numCas + ", observatio=" + observatio + ", pValu=" + pValu
                + ", poids=" + poids + ", pointage=" + pointage + ", pointage1=" + pointage1 + ", pointage2="
                + pointage2 + ", prixAM=" + prixAM + ", prixAch=" + prixAch + ", prixArem=" + prixArem + ", prixCEur="
                + prixCEur + ", prixConf=" + prixConf + ", prixDev=" + prixDev + ", prixEuro=" + prixEuro + ", prixIni="
                + prixIni + ", prixMin=" + prixMin + ", prixProf=" + prixProf + ", prixVen=" + prixVen + ", qutA1="
                + qutA1 + ", qutConf=" + qutConf + ", qutDem=" + qutDem + ", qutDep=" + qutDep + ", qutDep1=" + qutDep1
                + ", qutDou=" + qutDou + ", qutMax=" + qutMax + ", qutMin=" + qutMin + ", qutProf=" + qutProf
                + ", qutRav=" + qutRav + ", qutStk=" + qutStk + ", qutStk2=" + qutStk2 + ", qutSup=" + qutSup
                + ", qutV1=" + qutV1 + ", qutV2=" + qutV2 + ", qutV3=" + qutV3 + ", refOrg=" + refOrg + ", refRem="
                + refRem + ", reliq=" + reliq + ", remise=" + remise + ", sFamille=" + sFamille + ", special1="
                + special1 + ", special10=" + special10 + ", special11=" + special11 + ", special12=" + special12
                + ", special13=" + special13 + ", special2=" + special2 + ", special3=" + special3 + ", special4="
                + special4 + ", special5=" + special5 + ", special6=" + special6 + ", special7=" + special7
                + ", special8=" + special8 + ", special9=" + special9 + ", stkAtrsf="
                + stkAtrsf + ", stkGar=" + stkGar + ", stkIni=" + stkIni + ", stkNp=" + stkNp + ", stkReel=" + stkReel
                + ", stkRes=" + stkRes + ", stkTrsf=" + stkTrsf + ", t=" + t + ", tarifFrs=" + tarifFrs + ", taux="
                + taux + ", tot=" + tot + ", totalPoin=" + totalPoin + ", tva=" + tva + ", typAnal=" + typAnal
                + ", typeV=" + typeV + ", unitInv=" + unitInv + ", unitVen=" + unitVen + ", vSstk=" + vSstk
                + ", venPer=" + venPer + ", vente1=" + vente1 + ", vente2=" + vente2 + ", vente3=" + vente3
                + ", versions=" + versions + ", xanalStk=" + xanalStk + ", xprixAch=" + xprixAch + ", xtypAnal="
                + xtypAnal + ", xvCom=" + xvCom + "]";
    }

}
