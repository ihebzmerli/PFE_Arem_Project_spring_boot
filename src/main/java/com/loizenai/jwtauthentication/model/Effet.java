package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Effet {
    private long id;
    private long numEff;
    private long codUser;
    private String raison;
    private BigDecimal montEff;
    private Date datEff;
    private Date echeance;
    private String regle;
    private String bord;
    private String aviscr;
    private String impaye;
    private Date datImp;
    private BigDecimal montReg;
    private Date datReg;
    private BigDecimal intEff;
    private BigDecimal intFixe;
    private BigDecimal regInt;
    private String typeBord;
    private String bank;
    private Date datBord;
    private String regImp;
    private Date datAcc;
    private Date datPas;
    private String typAcc;
    private String cont;
    private Date datInt;
    private String nom;
    private Date date;
    private String obs;
    private String numImp;
    private BigDecimal montProv;
    private BigDecimal regcli;
    private String compta;
    private String comptaImp;
    private String comptaCr;
    private BigDecimal tvaInt;
    private String tresorImp;
    private BigDecimal comEsc;
    private BigDecimal intEsc;
    private BigDecimal tvaEsc;
    private Date datComp;
    private Date datComp2;
    private Date datComp3;
    private String poste;
    private String recouv;

    public Effet(long numEff, long codUser, String raison, BigDecimal montEff, Date datEff, Date echeance, String regle, String bord, String aviscr, String impaye, Date datImp, BigDecimal montReg, Date datReg, BigDecimal intEff, BigDecimal intFixe, BigDecimal regInt, String typeBord, String bank, Date datBord, String regImp, Date datAcc, Date datPas, String typAcc, String cont, Date datInt, String nom, Date date, String obs, String numImp, BigDecimal montProv, BigDecimal regcli, String compta, String comptaImp, String comptaCr, BigDecimal tvaInt, String tresorImp, BigDecimal comEsc, BigDecimal intEsc, BigDecimal tvaEsc, Date datComp, Date datComp2, Date datComp3, String poste, String recouv) {
        this.numEff = numEff;
        this.codUser = codUser;
        this.raison = raison;
        this.montEff = montEff;
        this.datEff = datEff;
        this.echeance = echeance;
        this.regle = regle;
        this.bord = bord;
        this.aviscr = aviscr;
        this.impaye = impaye;
        this.datImp = datImp;
        this.montReg = montReg;
        this.datReg = datReg;
        this.intEff = intEff;
        this.intFixe = intFixe;
        this.regInt = regInt;
        this.typeBord = typeBord;
        this.bank = bank;
        this.datBord = datBord;
        this.regImp = regImp;
        this.datAcc = datAcc;
        this.datPas = datPas;
        this.typAcc = typAcc;
        this.cont = cont;
        this.datInt = datInt;
        this.nom = nom;
        this.date = date;
        this.obs = obs;
        this.numImp = numImp;
        this.montProv = montProv;
        this.regcli = regcli;
        this.compta = compta;
        this.comptaImp = comptaImp;
        this.comptaCr = comptaCr;
        this.tvaInt = tvaInt;
        this.tresorImp = tresorImp;
        this.comEsc = comEsc;
        this.intEsc = intEsc;
        this.tvaEsc = tvaEsc;
        this.datComp = datComp;
        this.datComp2 = datComp2;
        this.datComp3 = datComp3;
        this.poste = poste;
        this.recouv = recouv;
    }

    public Effet() {

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
    @Column(name = "NUM_EFF")
    public long getNumEff() {
        return numEff;
    }

    public void setNumEff(long numEff) {
        this.numEff = numEff;
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
    @Column(name = "MONT_EFF")
    public BigDecimal getMontEff() {
        return montEff;
    }

    public void setMontEff(BigDecimal montEff) {
        this.montEff = montEff;
    }

    @Basic
    @Column(name = "DAT_EFF")
    public Date getDatEff() {
        return datEff;
    }

    public void setDatEff(Date datEff) {
        this.datEff = datEff;
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
    @Column(name = "REGLE")
    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
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
    @Column(name = "AVISCR")
    public String getAviscr() {
        return aviscr;
    }

    public void setAviscr(String aviscr) {
        this.aviscr = aviscr;
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
    @Column(name = "DAT_REG")
    public Date getDatReg() {
        return datReg;
    }

    public void setDatReg(Date datReg) {
        this.datReg = datReg;
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
    @Column(name = "INT_FIXE")
    public BigDecimal getIntFixe() {
        return intFixe;
    }

    public void setIntFixe(BigDecimal intFixe) {
        this.intFixe = intFixe;
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
    @Column(name = "TYPE_BORD")
    public String getTypeBord() {
        return typeBord;
    }

    public void setTypeBord(String typeBord) {
        this.typeBord = typeBord;
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
    @Column(name = "DAT_BORD")
    public Date getDatBord() {
        return datBord;
    }

    public void setDatBord(Date datBord) {
        this.datBord = datBord;
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
    @Column(name = "DAT_ACC")
    public Date getDatAcc() {
        return datAcc;
    }

    public void setDatAcc(Date datAcc) {
        this.datAcc = datAcc;
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
    @Column(name = "TYP_ACC")
    public String getTypAcc() {
        return typAcc;
    }

    public void setTypAcc(String typAcc) {
        this.typAcc = typAcc;
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
    @Column(name = "NUM_IMP")
    public String getNumImp() {
        return numImp;
    }

    public void setNumImp(String numImp) {
        this.numImp = numImp;
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
    @Column(name = "REGCLI")
    public BigDecimal getRegcli() {
        return regcli;
    }

    public void setRegcli(BigDecimal regcli) {
        this.regcli = regcli;
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
    @Column(name = "COMPTA_IMP")
    public String getComptaImp() {
        return comptaImp;
    }

    public void setComptaImp(String comptaImp) {
        this.comptaImp = comptaImp;
    }

    @Basic
    @Column(name = "COMPTA_CR")
    public String getComptaCr() {
        return comptaCr;
    }

    public void setComptaCr(String comptaCr) {
        this.comptaCr = comptaCr;
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
    @Column(name = "COM_ESC")
    public BigDecimal getComEsc() {
        return comEsc;
    }

    public void setComEsc(BigDecimal comEsc) {
        this.comEsc = comEsc;
    }

    @Basic
    @Column(name = "INT_ESC")
    public BigDecimal getIntEsc() {
        return intEsc;
    }

    public void setIntEsc(BigDecimal intEsc) {
        this.intEsc = intEsc;
    }

    @Basic
    @Column(name = "TVA_ESC")
    public BigDecimal getTvaEsc() {
        return tvaEsc;
    }

    public void setTvaEsc(BigDecimal tvaEsc) {
        this.tvaEsc = tvaEsc;
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
    @Column(name = "DAT_COMP3")
    public Date getDatComp3() {
        return datComp3;
    }

    public void setDatComp3(Date datComp3) {
        this.datComp3 = datComp3;
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
        Effet effet = (Effet) o;
        return id == effet.id &&
                numEff == effet.numEff &&
                codUser == effet.codUser &&
                Objects.equals(raison, effet.raison) &&
                Objects.equals(montEff, effet.montEff) &&
                Objects.equals(datEff, effet.datEff) &&
                Objects.equals(echeance, effet.echeance) &&
                Objects.equals(regle, effet.regle) &&
                Objects.equals(bord, effet.bord) &&
                Objects.equals(aviscr, effet.aviscr) &&
                Objects.equals(impaye, effet.impaye) &&
                Objects.equals(datImp, effet.datImp) &&
                Objects.equals(montReg, effet.montReg) &&
                Objects.equals(datReg, effet.datReg) &&
                Objects.equals(intEff, effet.intEff) &&
                Objects.equals(intFixe, effet.intFixe) &&
                Objects.equals(regInt, effet.regInt) &&
                Objects.equals(typeBord, effet.typeBord) &&
                Objects.equals(bank, effet.bank) &&
                Objects.equals(datBord, effet.datBord) &&
                Objects.equals(regImp, effet.regImp) &&
                Objects.equals(datAcc, effet.datAcc) &&
                Objects.equals(datPas, effet.datPas) &&
                Objects.equals(typAcc, effet.typAcc) &&
                Objects.equals(cont, effet.cont) &&
                Objects.equals(datInt, effet.datInt) &&
                Objects.equals(nom, effet.nom) &&
                Objects.equals(date, effet.date) &&
                Objects.equals(obs, effet.obs) &&
                Objects.equals(numImp, effet.numImp) &&
                Objects.equals(montProv, effet.montProv) &&
                Objects.equals(regcli, effet.regcli) &&
                Objects.equals(compta, effet.compta) &&
                Objects.equals(comptaImp, effet.comptaImp) &&
                Objects.equals(comptaCr, effet.comptaCr) &&
                Objects.equals(tvaInt, effet.tvaInt) &&
                Objects.equals(tresorImp, effet.tresorImp) &&
                Objects.equals(comEsc, effet.comEsc) &&
                Objects.equals(intEsc, effet.intEsc) &&
                Objects.equals(tvaEsc, effet.tvaEsc) &&
                Objects.equals(datComp, effet.datComp) &&
                Objects.equals(datComp2, effet.datComp2) &&
                Objects.equals(datComp3, effet.datComp3) &&
                Objects.equals(poste, effet.poste) &&
                Objects.equals(recouv, effet.recouv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numEff, codUser, raison, montEff, datEff, echeance, regle, bord, aviscr, impaye, datImp, montReg, datReg, intEff, intFixe, regInt, typeBord, bank, datBord, regImp, datAcc, datPas, typAcc, cont, datInt, nom, date, obs, numImp, montProv, regcli, compta, comptaImp, comptaCr, tvaInt, tresorImp, comEsc, intEsc, tvaEsc, datComp, datComp2, datComp3, poste, recouv);
    }

    @Override
    public String toString() {
        return "Effet{" +
                "id=" + id +
                ", numEff=" + numEff +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", montEff=" + montEff +
                ", datEff=" + datEff +
                ", echeance=" + echeance +
                ", regle='" + regle + '\'' +
                ", bord='" + bord + '\'' +
                ", aviscr='" + aviscr + '\'' +
                ", impaye='" + impaye + '\'' +
                ", datImp=" + datImp +
                ", montReg=" + montReg +
                ", datReg=" + datReg +
                ", intEff=" + intEff +
                ", intFixe=" + intFixe +
                ", regInt=" + regInt +
                ", typeBord='" + typeBord + '\'' +
                ", bank='" + bank + '\'' +
                ", datBord=" + datBord +
                ", regImp='" + regImp + '\'' +
                ", datAcc=" + datAcc +
                ", datPas=" + datPas +
                ", typAcc='" + typAcc + '\'' +
                ", cont='" + cont + '\'' +
                ", datInt=" + datInt +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                ", obs='" + obs + '\'' +
                ", numImp='" + numImp + '\'' +
                ", montProv=" + montProv +
                ", regcli=" + regcli +
                ", compta='" + compta + '\'' +
                ", comptaImp='" + comptaImp + '\'' +
                ", comptaCr='" + comptaCr + '\'' +
                ", tvaInt=" + tvaInt +
                ", tresorImp='" + tresorImp + '\'' +
                ", comEsc=" + comEsc +
                ", intEsc=" + intEsc +
                ", tvaEsc=" + tvaEsc +
                ", datComp=" + datComp +
                ", datComp2=" + datComp2 +
                ", datComp3=" + datComp3 +
                ", poste='" + poste + '\'' +
                ", recouv='" + recouv + '\'' +
                '}';
    }
}
