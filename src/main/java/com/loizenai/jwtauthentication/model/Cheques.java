package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Cheques {
    private long id;
    private Date datDoc;
    private String typMvt;
    private long codUser;
    private String raison;
    private BigDecimal montChq;
    private long numChq;
    private Date datEnc;
    private String banque;
    private String ville;
    private String compta;
    private String bord;
    private String impaye;
    private Date datImp;
    private BigDecimal montReg;
    private String natReg;
    private BigDecimal intFixe;
    private BigDecimal intEff;
    private BigDecimal regInt;
    private Date datRegi;
    private String natRegi;
    private Date datReg;
    private BigDecimal chqimp;
    private BigDecimal effimp;
    private BigDecimal facins;
    private BigDecimal regcli;
    private BigDecimal regdiv;
    private BigDecimal efnrec;
    private BigDecimal chqPf;
    private BigDecimal effPf;
    private BigDecimal pieces;
    private Date datPas;
    private String cont;
    private Date datInt;
    private String nom;
    private Date date;
    private String obs;
    private Date ancDat;
    private String prov;
    private BigDecimal montProv;
    private String avis;
    private String comptaImp;
    private BigDecimal tvaInt;
    private String tresorImp;
    private String comptaS;
    private String rib;
    private Date datComp;
    private Date datComp2;
    private String poste;
    private String recouv;

    public Cheques(Date datDoc, String typMvt, long codUser, String raison, BigDecimal montChq, long numChq, Date datEnc, String banque, String ville, String compta, String bord, String impaye, Date datImp, BigDecimal montReg, String natReg, BigDecimal intFixe, BigDecimal intEff, BigDecimal regInt, Date datRegi, String natRegi, Date datReg, BigDecimal chqimp, BigDecimal effimp, BigDecimal facins, BigDecimal regcli, BigDecimal regdiv, BigDecimal efnrec, BigDecimal chqPf, BigDecimal effPf, BigDecimal pieces, Date datPas, String cont, Date datInt, String nom, Date date, String obs, Date ancDat, String prov, BigDecimal montProv, String avis, String comptaImp, BigDecimal tvaInt, String tresorImp, String comptaS, String rib, Date datComp, Date datComp2, String poste, String recouv) {
        this.datDoc = datDoc;
        this.typMvt = typMvt;
        this.codUser = codUser;
        this.raison = raison;
        this.montChq = montChq;
        this.numChq = numChq;
        this.datEnc = datEnc;
        this.banque = banque;
        this.ville = ville;
        this.compta = compta;
        this.bord = bord;
        this.impaye = impaye;
        this.datImp = datImp;
        this.montReg = montReg;
        this.natReg = natReg;
        this.intFixe = intFixe;
        this.intEff = intEff;
        this.regInt = regInt;
        this.datRegi = datRegi;
        this.natRegi = natRegi;
        this.datReg = datReg;
        this.chqimp = chqimp;
        this.effimp = effimp;
        this.facins = facins;
        this.regcli = regcli;
        this.regdiv = regdiv;
        this.efnrec = efnrec;
        this.chqPf = chqPf;
        this.effPf = effPf;
        this.pieces = pieces;
        this.datPas = datPas;
        this.cont = cont;
        this.datInt = datInt;
        this.nom = nom;
        this.date = date;
        this.obs = obs;
        this.ancDat = ancDat;
        this.prov = prov;
        this.montProv = montProv;
        this.avis = avis;
        this.comptaImp = comptaImp;
        this.tvaInt = tvaInt;
        this.tresorImp = tresorImp;
        this.comptaS = comptaS;
        this.rib = rib;
        this.datComp = datComp;
        this.datComp2 = datComp2;
        this.poste = poste;
        this.recouv = recouv;
    }

    public Cheques() {

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
    @Column(name = "DAT_DOC")
    public Date getDatDoc() {
        return datDoc;
    }

    public void setDatDoc(Date datDoc) {
        this.datDoc = datDoc;
    }

    @Basic
    @Column(name = "TYP_MVT")
    public String getTypMvt() {
        return typMvt;
    }

    public void setTypMvt(String typMvt) {
        this.typMvt = typMvt;
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
    @Column(name = "MONT_CHQ")
    public BigDecimal getMontChq() {
        return montChq;
    }

    public void setMontChq(BigDecimal montChq) {
        this.montChq = montChq;
    }

    @Column(name = "NUM_CHQ")
    public long getNumChq() {
        return numChq;
    }

    public void setNumChq(long numChq) {
        this.numChq = numChq;
    }

    @Basic
    @Column(name = "DAT_ENC")
    public Date getDatEnc() {
        return datEnc;
    }

    public void setDatEnc(Date datEnc) {
        this.datEnc = datEnc;
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
    @Column(name = "VILLE")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
    @Column(name = "BORD")
    public String getBord() {
        return bord;
    }

    public void setBord(String bord) {
        this.bord = bord;
    }

    @Basic
    @Column(name = "IMPAYE")
    public String getImpaye() {
        return impaye;
    }

    public void setImpaye(String impaye) {
        this.impaye = impaye;
    }

    @Basic
    @Column(name = "DAT_IMP")
    public Date getDatImp() {
        return datImp;
    }

    public void setDatImp(Date datImp) {
        this.datImp = datImp;
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
    @Column(name = "NAT_REG")
    public String getNatReg() {
        return natReg;
    }

    public void setNatReg(String natReg) {
        this.natReg = natReg;
    }

    @Basic
    @Column(name = "INT_FIXE")
    public BigDecimal getIntFixe() {
        return intFixe;
    }

    public void setIntFixe(BigDecimal intFixe) {
        this.intFixe = intFixe;
    }

    @Basic
    @Column(name = "INT_EFF")
    public BigDecimal getIntEff() {
        return intEff;
    }

    public void setIntEff(BigDecimal intEff) {
        this.intEff = intEff;
    }

    @Basic
    @Column(name = "REG_INT")
    public BigDecimal getRegInt() {
        return regInt;
    }

    public void setRegInt(BigDecimal regInt) {
        this.regInt = regInt;
    }

    @Basic
    @Column(name = "DAT_REGI")
    public Date getDatRegi() {
        return datRegi;
    }

    public void setDatRegi(Date datRegi) {
        this.datRegi = datRegi;
    }

    @Basic
    @Column(name = "NAT_REGI")
    public String getNatRegi() {
        return natRegi;
    }

    public void setNatRegi(String natRegi) {
        this.natRegi = natRegi;
    }

    @Basic
    @Column(name = "DAT_REG")
    public Date getDatReg() {
        return datReg;
    }

    public void setDatReg(Date datReg) {
        this.datReg = datReg;
    }

    @Basic
    @Column(name = "CHQIMP")
    public BigDecimal getChqimp() {
        return chqimp;
    }

    public void setChqimp(BigDecimal chqimp) {
        this.chqimp = chqimp;
    }

    @Basic
    @Column(name = "EFFIMP")
    public BigDecimal getEffimp() {
        return effimp;
    }

    public void setEffimp(BigDecimal effimp) {
        this.effimp = effimp;
    }

    @Basic
    @Column(name = "FACINS")
    public BigDecimal getFacins() {
        return facins;
    }

    public void setFacins(BigDecimal facins) {
        this.facins = facins;
    }

    @Basic
    @Column(name = "REGCLI")
    public BigDecimal getRegcli() {
        return regcli;
    }

    public void setRegcli(BigDecimal regcli) {
        this.regcli = regcli;
    }

    @Basic
    @Column(name = "REGDIV")
    public BigDecimal getRegdiv() {
        return regdiv;
    }

    public void setRegdiv(BigDecimal regdiv) {
        this.regdiv = regdiv;
    }

    @Basic
    @Column(name = "EFNREC")
    public BigDecimal getEfnrec() {
        return efnrec;
    }

    public void setEfnrec(BigDecimal efnrec) {
        this.efnrec = efnrec;
    }

    @Basic
    @Column(name = "CHQ_PF")
    public BigDecimal getChqPf() {
        return chqPf;
    }

    public void setChqPf(BigDecimal chqPf) {
        this.chqPf = chqPf;
    }

    @Basic
    @Column(name = "EFF_PF")
    public BigDecimal getEffPf() {
        return effPf;
    }

    public void setEffPf(BigDecimal effPf) {
        this.effPf = effPf;
    }

    @Basic
    @Column(name = "PIECES")
    public BigDecimal getPieces() {
        return pieces;
    }

    public void setPieces(BigDecimal pieces) {
        this.pieces = pieces;
    }

    @Basic
    @Column(name = "DAT_PAS")
    public Date getDatPas() {
        return datPas;
    }

    public void setDatPas(Date datPas) {
        this.datPas = datPas;
    }

    @Basic
    @Column(name = "CONT")
    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    @Basic
    @Column(name = "DAT_INT")
    public Date getDatInt() {
        return datInt;
    }

    public void setDatInt(Date datInt) {
        this.datInt = datInt;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "OBS")
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Basic
    @Column(name = "ANC_DAT")
    public Date getAncDat() {
        return ancDat;
    }

    public void setAncDat(Date ancDat) {
        this.ancDat = ancDat;
    }

    @Basic
    @Column(name = "PROV")
    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
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
    @Column(name = "AVIS")
    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    @Basic
    @Column(name = "COMPTA_IMP")
    public String getComptaImp() {
        return comptaImp;
    }

    public void setComptaImp(String comptaImp) {
        this.comptaImp = comptaImp;
    }

    @Basic
    @Column(name = "TVA_INT")
    public BigDecimal getTvaInt() {
        return tvaInt;
    }

    public void setTvaInt(BigDecimal tvaInt) {
        this.tvaInt = tvaInt;
    }

    @Basic
    @Column(name = "TRESOR_IMP")
    public String getTresorImp() {
        return tresorImp;
    }

    public void setTresorImp(String tresorImp) {
        this.tresorImp = tresorImp;
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
    @Column(name = "RIB")
    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
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
    @Column(name = "DAT_COMP2")
    public Date getDatComp2() {
        return datComp2;
    }

    public void setDatComp2(Date datComp2) {
        this.datComp2 = datComp2;
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
    @Column(name = "RECOUV")
    public String getRecouv() {
        return recouv;
    }

    public void setRecouv(String recouv) {
        this.recouv = recouv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheques cheques = (Cheques) o;
        return id == cheques.id &&
                codUser == cheques.codUser &&
                numChq == cheques.numChq &&
                Objects.equals(datDoc, cheques.datDoc) &&
                Objects.equals(typMvt, cheques.typMvt) &&
                Objects.equals(raison, cheques.raison) &&
                Objects.equals(montChq, cheques.montChq) &&
                Objects.equals(datEnc, cheques.datEnc) &&
                Objects.equals(banque, cheques.banque) &&
                Objects.equals(ville, cheques.ville) &&
                Objects.equals(compta, cheques.compta) &&
                Objects.equals(bord, cheques.bord) &&
                Objects.equals(impaye, cheques.impaye) &&
                Objects.equals(datImp, cheques.datImp) &&
                Objects.equals(montReg, cheques.montReg) &&
                Objects.equals(natReg, cheques.natReg) &&
                Objects.equals(intFixe, cheques.intFixe) &&
                Objects.equals(intEff, cheques.intEff) &&
                Objects.equals(regInt, cheques.regInt) &&
                Objects.equals(datRegi, cheques.datRegi) &&
                Objects.equals(natRegi, cheques.natRegi) &&
                Objects.equals(datReg, cheques.datReg) &&
                Objects.equals(chqimp, cheques.chqimp) &&
                Objects.equals(effimp, cheques.effimp) &&
                Objects.equals(facins, cheques.facins) &&
                Objects.equals(regcli, cheques.regcli) &&
                Objects.equals(regdiv, cheques.regdiv) &&
                Objects.equals(efnrec, cheques.efnrec) &&
                Objects.equals(chqPf, cheques.chqPf) &&
                Objects.equals(effPf, cheques.effPf) &&
                Objects.equals(pieces, cheques.pieces) &&
                Objects.equals(datPas, cheques.datPas) &&
                Objects.equals(cont, cheques.cont) &&
                Objects.equals(datInt, cheques.datInt) &&
                Objects.equals(nom, cheques.nom) &&
                Objects.equals(date, cheques.date) &&
                Objects.equals(obs, cheques.obs) &&
                Objects.equals(ancDat, cheques.ancDat) &&
                Objects.equals(prov, cheques.prov) &&
                Objects.equals(montProv, cheques.montProv) &&
                Objects.equals(avis, cheques.avis) &&
                Objects.equals(comptaImp, cheques.comptaImp) &&
                Objects.equals(tvaInt, cheques.tvaInt) &&
                Objects.equals(tresorImp, cheques.tresorImp) &&
                Objects.equals(comptaS, cheques.comptaS) &&
                Objects.equals(rib, cheques.rib) &&
                Objects.equals(datComp, cheques.datComp) &&
                Objects.equals(datComp2, cheques.datComp2) &&
                Objects.equals(poste, cheques.poste) &&
                Objects.equals(recouv, cheques.recouv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datDoc, typMvt, codUser, raison, montChq, numChq, datEnc, banque, ville, compta, bord, impaye, datImp, montReg, natReg, intFixe, intEff, regInt, datRegi, natRegi, datReg, chqimp, effimp, facins, regcli, regdiv, efnrec, chqPf, effPf, pieces, datPas, cont, datInt, nom, date, obs, ancDat, prov, montProv, avis, comptaImp, tvaInt, tresorImp, comptaS, rib, datComp, datComp2, poste, recouv);
    }

    @Override
    public String toString() {
        return "Cheques{" +
                "id=" + id +
                ", datDoc=" + datDoc +
                ", typMvt='" + typMvt + '\'' +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", montChq=" + montChq +
                ", numChq=" + numChq +
                ", datEnc=" + datEnc +
                ", banque='" + banque + '\'' +
                ", ville='" + ville + '\'' +
                ", compta='" + compta + '\'' +
                ", bord='" + bord + '\'' +
                ", impaye='" + impaye + '\'' +
                ", datImp=" + datImp +
                ", montReg=" + montReg +
                ", natReg='" + natReg + '\'' +
                ", intFixe=" + intFixe +
                ", intEff=" + intEff +
                ", regInt=" + regInt +
                ", datRegi=" + datRegi +
                ", natRegi='" + natRegi + '\'' +
                ", datReg=" + datReg +
                ", chqimp=" + chqimp +
                ", effimp=" + effimp +
                ", facins=" + facins +
                ", regcli=" + regcli +
                ", regdiv=" + regdiv +
                ", efnrec=" + efnrec +
                ", chqPf=" + chqPf +
                ", effPf=" + effPf +
                ", pieces=" + pieces +
                ", datPas=" + datPas +
                ", cont='" + cont + '\'' +
                ", datInt=" + datInt +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                ", obs='" + obs + '\'' +
                ", ancDat=" + ancDat +
                ", prov='" + prov + '\'' +
                ", montProv=" + montProv +
                ", avis='" + avis + '\'' +
                ", comptaImp='" + comptaImp + '\'' +
                ", tvaInt=" + tvaInt +
                ", tresorImp='" + tresorImp + '\'' +
                ", comptaS='" + comptaS + '\'' +
                ", rib='" + rib + '\'' +
                ", datComp=" + datComp +
                ", datComp2=" + datComp2 +
                ", poste='" + poste + '\'' +
                ", recouv='" + recouv + '\'' +
                '}';
    }
}
