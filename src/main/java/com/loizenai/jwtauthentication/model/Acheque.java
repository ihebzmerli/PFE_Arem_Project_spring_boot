package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "acheque", schema = "seratest")
public class Acheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String numChq;
    private Date datDoc;
    private String typMvt;
    private long codFrs;
    private BigDecimal montDoc;
    private String docReg;
    private Date datEnc;
    private Date datVal;
    private String bank;
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
    private BigDecimal facent;
    private BigDecimal facmat;
    private BigDecimal facins;
    private BigDecimal regcli;
    private BigDecimal regdiv;
    private BigDecimal efnrec;
    private BigDecimal chqPf;
    private BigDecimal effPf;
    private BigDecimal pieces;
    private String avisdb;
    private String tresor;
    private String comptaS;
    private Date datComp;
    private String raison;
    private String poste;

    public Acheque(Date datDoc, String typMvt, long codFrs, BigDecimal montDoc, String docReg, Date datEnc, Date datVal, String bank, String ville, String compta, String bord, String impaye, Date datImp, BigDecimal montReg, String natReg, BigDecimal intFixe, BigDecimal intEff, BigDecimal regInt, Date datRegi, String natRegi, Date datReg, BigDecimal chqimp, BigDecimal effimp, BigDecimal facent, BigDecimal facmat, BigDecimal facins, BigDecimal regcli, BigDecimal regdiv, BigDecimal efnrec, BigDecimal chqPf, BigDecimal effPf, BigDecimal pieces, String avisdb, String tresor, String comptaS, Date datComp, String raison, String poste) {
        this.datDoc = datDoc;
        this.typMvt = typMvt;
        this.codFrs = codFrs;
        this.montDoc = montDoc;
        this.docReg = docReg;
        this.datEnc = datEnc;
        this.datVal = datVal;
        this.bank = bank;
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
        this.facent = facent;
        this.facmat = facmat;
        this.facins = facins;
        this.regcli = regcli;
        this.regdiv = regdiv;
        this.efnrec = efnrec;
        this.chqPf = chqPf;
        this.effPf = effPf;
        this.pieces = pieces;
        this.avisdb = avisdb;
        this.tresor = tresor;
        this.comptaS = comptaS;
        this.datComp = datComp;
        this.raison = raison;
        this.poste = poste;
    }

    public Acheque() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUM_CHQ")
    public String getNumChq() {
        return numChq;
    }

    public void setNumChq(String numChq) {
        this.numChq = numChq;
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

    @Id
    @Column(name = "COD_FRS")
    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
    }

    @Basic
    @Column(name = "MONT_DOC")
    public BigDecimal getMontDoc() {
        return montDoc;
    }

    public void setMontDoc(BigDecimal montDoc) {
        this.montDoc = montDoc;
    }

    @Basic
    @Column(name = "DOC_REG")
    public String getDocReg() {
        return docReg;
    }

    public void setDocReg(String docReg) {
        this.docReg = docReg;
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
    @Column(name = "DAT_VAL")
    public Date getDatVal() {
        return datVal;
    }

    public void setDatVal(Date datVal) {
        this.datVal = datVal;
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
    @Column(name = "FACENT")
    public BigDecimal getFacent() {
        return facent;
    }

    public void setFacent(BigDecimal facent) {
        this.facent = facent;
    }

    @Basic
    @Column(name = "FACMAT")
    public BigDecimal getFacmat() {
        return facmat;
    }

    public void setFacmat(BigDecimal facmat) {
        this.facmat = facmat;
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
    @Column(name = "AVISDB")
    public String getAvisdb() {
        return avisdb;
    }

    public void setAvisdb(String avisdb) {
        this.avisdb = avisdb;
    }

    @Basic
    @Column(name = "TRESOR")
    public String getTresor() {
        return tresor;
    }

    public void setTresor(String tresor) {
        this.tresor = tresor;
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
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Basic
    @Column(name = "POSTE")
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acheque acheque = (Acheque) o;
        return id == acheque.id &&
                codFrs == acheque.codFrs &&
                Objects.equals(numChq, acheque.numChq) &&
                Objects.equals(datDoc, acheque.datDoc) &&
                Objects.equals(typMvt, acheque.typMvt) &&
                Objects.equals(montDoc, acheque.montDoc) &&
                Objects.equals(docReg, acheque.docReg) &&
                Objects.equals(datEnc, acheque.datEnc) &&
                Objects.equals(datVal, acheque.datVal) &&
                Objects.equals(bank, acheque.bank) &&
                Objects.equals(ville, acheque.ville) &&
                Objects.equals(compta, acheque.compta) &&
                Objects.equals(bord, acheque.bord) &&
                Objects.equals(impaye, acheque.impaye) &&
                Objects.equals(datImp, acheque.datImp) &&
                Objects.equals(montReg, acheque.montReg) &&
                Objects.equals(natReg, acheque.natReg) &&
                Objects.equals(intFixe, acheque.intFixe) &&
                Objects.equals(intEff, acheque.intEff) &&
                Objects.equals(regInt, acheque.regInt) &&
                Objects.equals(datRegi, acheque.datRegi) &&
                Objects.equals(natRegi, acheque.natRegi) &&
                Objects.equals(datReg, acheque.datReg) &&
                Objects.equals(chqimp, acheque.chqimp) &&
                Objects.equals(effimp, acheque.effimp) &&
                Objects.equals(facent, acheque.facent) &&
                Objects.equals(facmat, acheque.facmat) &&
                Objects.equals(facins, acheque.facins) &&
                Objects.equals(regcli, acheque.regcli) &&
                Objects.equals(regdiv, acheque.regdiv) &&
                Objects.equals(efnrec, acheque.efnrec) &&
                Objects.equals(chqPf, acheque.chqPf) &&
                Objects.equals(effPf, acheque.effPf) &&
                Objects.equals(pieces, acheque.pieces) &&
                Objects.equals(avisdb, acheque.avisdb) &&
                Objects.equals(tresor, acheque.tresor) &&
                Objects.equals(comptaS, acheque.comptaS) &&
                Objects.equals(datComp, acheque.datComp) &&
                Objects.equals(raison, acheque.raison) &&
                Objects.equals(poste, acheque.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numChq, datDoc, typMvt, codFrs, montDoc, docReg, datEnc, datVal, bank, ville, compta, bord, impaye, datImp, montReg, natReg, intFixe, intEff, regInt, datRegi, natRegi, datReg, chqimp, effimp, facent, facmat, facins, regcli, regdiv, efnrec, chqPf, effPf, pieces, avisdb, tresor, comptaS, datComp, raison, poste);
    }

    @Override
    public String toString() {
        return "Acheque{" +
                "id=" + id +
                ", numChq='" + numChq + '\'' +
                ", datDoc=" + datDoc +
                ", typMvt='" + typMvt + '\'' +
                ", codFrs=" + codFrs +
                ", montDoc=" + montDoc +
                ", docReg='" + docReg + '\'' +
                ", datEnc=" + datEnc +
                ", datVal=" + datVal +
                ", bank='" + bank + '\'' +
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
                ", facent=" + facent +
                ", facmat=" + facmat +
                ", facins=" + facins +
                ", regcli=" + regcli +
                ", regdiv=" + regdiv +
                ", efnrec=" + efnrec +
                ", chqPf=" + chqPf +
                ", effPf=" + effPf +
                ", pieces=" + pieces +
                ", avisdb='" + avisdb + '\'' +
                ", tresor='" + tresor + '\'' +
                ", comptaS='" + comptaS + '\'' +
                ", datComp=" + datComp +
                ", raison='" + raison + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
}
