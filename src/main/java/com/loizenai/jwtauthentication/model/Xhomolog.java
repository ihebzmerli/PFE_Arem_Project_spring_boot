package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Xhomolog {
    private long numHomol;
    private String numDem;
    private long codFrs;
    private String raison;
    private String banque;
    private String modePaie;
    private String natMarch;
    private String numDom;
    private Date dateDom;
    private String titre;
    private String numFac;
    private Date datFac;
    private BigDecimal valDBru;
    private BigDecimal valDNet;
    private String devise;
    private BigDecimal cours;
    private BigDecimal montDt;
    private BigDecimal montDou;
    private BigDecimal transit;
    private BigDecimal fFinance;
    private BigDecimal assurance;
    private BigDecimal magasinage;
    private BigDecimal fret;
    private BigDecimal autresTva;
    private BigDecimal tvaDouane;
    private BigDecimal totalHt;
    private BigDecimal prixRev;
    private BigDecimal marge;
    private BigDecimal coef;
    private BigDecimal tierOblig;
    private Short delai;
    private Date datFbl;
    private Date echRegl;
    private Date echObl;
    private String banqueObl;
    private BigDecimal intObl;
    private BigDecimal oblig;
    private BigDecimal tvaTsit;
    private BigDecimal tvaMag;
    private BigDecimal tvaAss;
    private BigDecimal tvaFret;
    private String engage;
    private String codTrs;
    private String numAff;
    private BigDecimal intDd;
    private Short nbjIntd;
    private Date datChq;
    private String bdFin;
    private String banqfin;
    private BigDecimal fraisDiv;
    private BigDecimal tvaFdiv;
    private String transport;
    private Date datFTrsp;
    private Integer regFrs;
    private BigDecimal pv;
    private Date datftrsp;
    private BigDecimal valdbru;
    private BigDecimal valdnet;

    @Id
    @Column(name = "NUM_HOMOL")
    public long getNumHomol() {
        return numHomol;
    }

    public void setNumHomol(long numHomol) {
        this.numHomol = numHomol;
    }

    @Basic
    @Column(name = "NUM_DEM")
    public String getNumDem() {
        return numDem;
    }

    public void setNumDem(String numDem) {
        this.numDem = numDem;
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
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
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
    @Column(name = "MODE_PAIE")
    public String getModePaie() {
        return modePaie;
    }

    public void setModePaie(String modePaie) {
        this.modePaie = modePaie;
    }

    @Basic
    @Column(name = "NAT_MARCH")
    public String getNatMarch() {
        return natMarch;
    }

    public void setNatMarch(String natMarch) {
        this.natMarch = natMarch;
    }

    @Basic
    @Column(name = "NUM_DOM")
    public String getNumDom() {
        return numDom;
    }

    public void setNumDom(String numDom) {
        this.numDom = numDom;
    }

    @Basic
    @Column(name = "DATE_DOM")
    public Date getDateDom() {
        return dateDom;
    }

    public void setDateDom(Date dateDom) {
        this.dateDom = dateDom;
    }

    @Basic
    @Column(name = "TITRE")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "NUM_FAC")
    public String getNumFac() {
        return numFac;
    }

    public void setNumFac(String numFac) {
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
    @Column(name = "VAL_D_BRU")
    public BigDecimal getValDBru() {
        return valDBru;
    }

    public void setValDBru(BigDecimal valDBru) {
        this.valDBru = valDBru;
    }

    @Basic
    @Column(name = "VAL_D_NET")
    public BigDecimal getValDNet() {
        return valDNet;
    }

    public void setValDNet(BigDecimal valDNet) {
        this.valDNet = valDNet;
    }

    @Basic
    @Column(name = "DEVISE")
    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
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
    @Column(name = "MONT_DT")
    public BigDecimal getMontDt() {
        return montDt;
    }

    public void setMontDt(BigDecimal montDt) {
        this.montDt = montDt;
    }

    @Basic
    @Column(name = "MONT_DOU")
    public BigDecimal getMontDou() {
        return montDou;
    }

    public void setMontDou(BigDecimal montDou) {
        this.montDou = montDou;
    }

    @Basic
    @Column(name = "TRANSIT")
    public BigDecimal getTransit() {
        return transit;
    }

    public void setTransit(BigDecimal transit) {
        this.transit = transit;
    }

    @Basic
    @Column(name = "F_FINANCE")
    public BigDecimal getfFinance() {
        return fFinance;
    }

    public void setfFinance(BigDecimal fFinance) {
        this.fFinance = fFinance;
    }

    @Basic
    @Column(name = "ASSURANCE")
    public BigDecimal getAssurance() {
        return assurance;
    }

    public void setAssurance(BigDecimal assurance) {
        this.assurance = assurance;
    }

    @Basic
    @Column(name = "MAGASINAGE")
    public BigDecimal getMagasinage() {
        return magasinage;
    }

    public void setMagasinage(BigDecimal magasinage) {
        this.magasinage = magasinage;
    }

    @Basic
    @Column(name = "FRET")
    public BigDecimal getFret() {
        return fret;
    }

    public void setFret(BigDecimal fret) {
        this.fret = fret;
    }

    @Basic
    @Column(name = "AUTRES_TVA")
    public BigDecimal getAutresTva() {
        return autresTva;
    }

    public void setAutresTva(BigDecimal autresTva) {
        this.autresTva = autresTva;
    }

    @Basic
    @Column(name = "TVA_DOUANE")
    public BigDecimal getTvaDouane() {
        return tvaDouane;
    }

    public void setTvaDouane(BigDecimal tvaDouane) {
        this.tvaDouane = tvaDouane;
    }

    @Basic
    @Column(name = "TOTAL_HT")
    public BigDecimal getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(BigDecimal totalHt) {
        this.totalHt = totalHt;
    }

    @Basic
    @Column(name = "PRIX_REV")
    public BigDecimal getPrixRev() {
        return prixRev;
    }

    public void setPrixRev(BigDecimal prixRev) {
        this.prixRev = prixRev;
    }

    @Basic
    @Column(name = "MARGE")
    public BigDecimal getMarge() {
        return marge;
    }

    public void setMarge(BigDecimal marge) {
        this.marge = marge;
    }

    @Basic
    @Column(name = "COEF")
    public BigDecimal getCoef() {
        return coef;
    }

    public void setCoef(BigDecimal coef) {
        this.coef = coef;
    }

    @Basic
    @Column(name = "TIER_OBLIG")
    public BigDecimal getTierOblig() {
        return tierOblig;
    }

    public void setTierOblig(BigDecimal tierOblig) {
        this.tierOblig = tierOblig;
    }

    @Basic
    @Column(name = "DELAI")
    public Short getDelai() {
        return delai;
    }

    public void setDelai(Short delai) {
        this.delai = delai;
    }

    @Basic
    @Column(name = "DAT_FBL")
    public Date getDatFbl() {
        return datFbl;
    }

    public void setDatFbl(Date datFbl) {
        this.datFbl = datFbl;
    }

    @Basic
    @Column(name = "ECH_REGL")
    public Date getEchRegl() {
        return echRegl;
    }

    public void setEchRegl(Date echRegl) {
        this.echRegl = echRegl;
    }

    @Basic
    @Column(name = "ECH_OBL")
    public Date getEchObl() {
        return echObl;
    }

    public void setEchObl(Date echObl) {
        this.echObl = echObl;
    }

    @Basic
    @Column(name = "BANQUE_OBL")
    public String getBanqueObl() {
        return banqueObl;
    }

    public void setBanqueObl(String banqueObl) {
        this.banqueObl = banqueObl;
    }

    @Basic
    @Column(name = "INT_OBL")
    public BigDecimal getIntObl() {
        return intObl;
    }

    public void setIntObl(BigDecimal intObl) {
        this.intObl = intObl;
    }

    @Basic
    @Column(name = "OBLIG")
    public BigDecimal getOblig() {
        return oblig;
    }

    public void setOblig(BigDecimal oblig) {
        this.oblig = oblig;
    }

    @Basic
    @Column(name = "TVA_TSIT")
    public BigDecimal getTvaTsit() {
        return tvaTsit;
    }

    public void setTvaTsit(BigDecimal tvaTsit) {
        this.tvaTsit = tvaTsit;
    }

    @Basic
    @Column(name = "TVA_MAG")
    public BigDecimal getTvaMag() {
        return tvaMag;
    }

    public void setTvaMag(BigDecimal tvaMag) {
        this.tvaMag = tvaMag;
    }

    @Basic
    @Column(name = "TVA_ASS")
    public BigDecimal getTvaAss() {
        return tvaAss;
    }

    public void setTvaAss(BigDecimal tvaAss) {
        this.tvaAss = tvaAss;
    }

    @Basic
    @Column(name = "TVA_FRET")
    public BigDecimal getTvaFret() {
        return tvaFret;
    }

    public void setTvaFret(BigDecimal tvaFret) {
        this.tvaFret = tvaFret;
    }

    @Basic
    @Column(name = "ENGAGE")
    public String getEngage() {
        return engage;
    }

    public void setEngage(String engage) {
        this.engage = engage;
    }

    @Basic
    @Column(name = "COD_TRS")
    public String getCodTrs() {
        return codTrs;
    }

    public void setCodTrs(String codTrs) {
        this.codTrs = codTrs;
    }

    @Basic
    @Column(name = "NUM_AFF")
    public String getNumAff() {
        return numAff;
    }

    public void setNumAff(String numAff) {
        this.numAff = numAff;
    }

    @Basic
    @Column(name = "INT_DD")
    public BigDecimal getIntDd() {
        return intDd;
    }

    public void setIntDd(BigDecimal intDd) {
        this.intDd = intDd;
    }

    @Basic
    @Column(name = "NBJ_INTD")
    public Short getNbjIntd() {
        return nbjIntd;
    }

    public void setNbjIntd(Short nbjIntd) {
        this.nbjIntd = nbjIntd;
    }

    @Basic
    @Column(name = "DAT_CHQ")
    public Date getDatChq() {
        return datChq;
    }

    public void setDatChq(Date datChq) {
        this.datChq = datChq;
    }

    @Basic
    @Column(name = "BD_FIN")
    public String getBdFin() {
        return bdFin;
    }

    public void setBdFin(String bdFin) {
        this.bdFin = bdFin;
    }

    @Basic
    @Column(name = "BANQFIN")
    public String getBanqfin() {
        return banqfin;
    }

    public void setBanqfin(String banqfin) {
        this.banqfin = banqfin;
    }

    @Basic
    @Column(name = "FRAIS_DIV")
    public BigDecimal getFraisDiv() {
        return fraisDiv;
    }

    public void setFraisDiv(BigDecimal fraisDiv) {
        this.fraisDiv = fraisDiv;
    }

    @Basic
    @Column(name = "TVA_FDIV")
    public BigDecimal getTvaFdiv() {
        return tvaFdiv;
    }

    public void setTvaFdiv(BigDecimal tvaFdiv) {
        this.tvaFdiv = tvaFdiv;
    }

    @Basic
    @Column(name = "TRANSPORT")
    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Basic
    @Column(name = "DAT_F_TRSP")
    public Date getDatFTrsp() {
        return datFTrsp;
    }

    public void setDatFTrsp(Date datFTrsp) {
        this.datFTrsp = datFTrsp;
    }

    @Basic
    @Column(name = "REG_FRS")
    public Integer getRegFrs() {
        return regFrs;
    }

    public void setRegFrs(Integer regFrs) {
        this.regFrs = regFrs;
    }

    @Basic
    @Column(name = "PV")
    public BigDecimal getPv() {
        return pv;
    }

    public void setPv(BigDecimal pv) {
        this.pv = pv;
    }

    @Basic
    @Column(name = "datftrsp")
    public Date getDatftrsp() {
        return datftrsp;
    }

    public void setDatftrsp(Date datftrsp) {
        this.datftrsp = datftrsp;
    }

    @Basic
    @Column(name = "valdbru")
    public BigDecimal getValdbru() {
        return valdbru;
    }

    public void setValdbru(BigDecimal valdbru) {
        this.valdbru = valdbru;
    }

    @Basic
    @Column(name = "valdnet")
    public BigDecimal getValdnet() {
        return valdnet;
    }

    public void setValdnet(BigDecimal valdnet) {
        this.valdnet = valdnet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xhomolog xhomolog = (Xhomolog) o;
        return numHomol == xhomolog.numHomol &&
                codFrs == xhomolog.codFrs &&
                Objects.equals(numDem, xhomolog.numDem) &&
                Objects.equals(raison, xhomolog.raison) &&
                Objects.equals(banque, xhomolog.banque) &&
                Objects.equals(modePaie, xhomolog.modePaie) &&
                Objects.equals(natMarch, xhomolog.natMarch) &&
                Objects.equals(numDom, xhomolog.numDom) &&
                Objects.equals(dateDom, xhomolog.dateDom) &&
                Objects.equals(titre, xhomolog.titre) &&
                Objects.equals(numFac, xhomolog.numFac) &&
                Objects.equals(datFac, xhomolog.datFac) &&
                Objects.equals(valDBru, xhomolog.valDBru) &&
                Objects.equals(valDNet, xhomolog.valDNet) &&
                Objects.equals(devise, xhomolog.devise) &&
                Objects.equals(cours, xhomolog.cours) &&
                Objects.equals(montDt, xhomolog.montDt) &&
                Objects.equals(montDou, xhomolog.montDou) &&
                Objects.equals(transit, xhomolog.transit) &&
                Objects.equals(fFinance, xhomolog.fFinance) &&
                Objects.equals(assurance, xhomolog.assurance) &&
                Objects.equals(magasinage, xhomolog.magasinage) &&
                Objects.equals(fret, xhomolog.fret) &&
                Objects.equals(autresTva, xhomolog.autresTva) &&
                Objects.equals(tvaDouane, xhomolog.tvaDouane) &&
                Objects.equals(totalHt, xhomolog.totalHt) &&
                Objects.equals(prixRev, xhomolog.prixRev) &&
                Objects.equals(marge, xhomolog.marge) &&
                Objects.equals(coef, xhomolog.coef) &&
                Objects.equals(tierOblig, xhomolog.tierOblig) &&
                Objects.equals(delai, xhomolog.delai) &&
                Objects.equals(datFbl, xhomolog.datFbl) &&
                Objects.equals(echRegl, xhomolog.echRegl) &&
                Objects.equals(echObl, xhomolog.echObl) &&
                Objects.equals(banqueObl, xhomolog.banqueObl) &&
                Objects.equals(intObl, xhomolog.intObl) &&
                Objects.equals(oblig, xhomolog.oblig) &&
                Objects.equals(tvaTsit, xhomolog.tvaTsit) &&
                Objects.equals(tvaMag, xhomolog.tvaMag) &&
                Objects.equals(tvaAss, xhomolog.tvaAss) &&
                Objects.equals(tvaFret, xhomolog.tvaFret) &&
                Objects.equals(engage, xhomolog.engage) &&
                Objects.equals(codTrs, xhomolog.codTrs) &&
                Objects.equals(numAff, xhomolog.numAff) &&
                Objects.equals(intDd, xhomolog.intDd) &&
                Objects.equals(nbjIntd, xhomolog.nbjIntd) &&
                Objects.equals(datChq, xhomolog.datChq) &&
                Objects.equals(bdFin, xhomolog.bdFin) &&
                Objects.equals(banqfin, xhomolog.banqfin) &&
                Objects.equals(fraisDiv, xhomolog.fraisDiv) &&
                Objects.equals(tvaFdiv, xhomolog.tvaFdiv) &&
                Objects.equals(transport, xhomolog.transport) &&
                Objects.equals(datFTrsp, xhomolog.datFTrsp) &&
                Objects.equals(regFrs, xhomolog.regFrs) &&
                Objects.equals(pv, xhomolog.pv) &&
                Objects.equals(datftrsp, xhomolog.datftrsp) &&
                Objects.equals(valdbru, xhomolog.valdbru) &&
                Objects.equals(valdnet, xhomolog.valdnet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numHomol, numDem, codFrs, raison, banque, modePaie, natMarch, numDom, dateDom, titre, numFac, datFac, valDBru, valDNet, devise, cours, montDt, montDou, transit, fFinance, assurance, magasinage, fret, autresTva, tvaDouane, totalHt, prixRev, marge, coef, tierOblig, delai, datFbl, echRegl, echObl, banqueObl, intObl, oblig, tvaTsit, tvaMag, tvaAss, tvaFret, engage, codTrs, numAff, intDd, nbjIntd, datChq, bdFin, banqfin, fraisDiv, tvaFdiv, transport, datFTrsp, regFrs, pv, datftrsp, valdbru, valdnet);
    }
}
