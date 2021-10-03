package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "mod_reg", schema = "testbd")
public class ModReg {
    private long id;
    private long codUser;
    private String raison;
    private Date datFac;
    private BigDecimal espece;
    private BigDecimal montChq;
    private Date datEnc;
    private String banque;
    private String ville;
    private String compta;
    private BigDecimal chqimp;
    private BigDecimal effimp;
    private BigDecimal facins;
    private BigDecimal facent;
    private BigDecimal facmat;
    private BigDecimal regcli;
    private BigDecimal regdiv;
    private BigDecimal efnrec;
    private BigDecimal chqPf;
    private BigDecimal effPf;
    private BigDecimal pieces;
    private String comptaS;
    private Date datComp;
    private String poste;
    private long numEsp;
    private String recouv;

    public ModReg(long codUser, String raison, Date datFac, BigDecimal espece, BigDecimal montChq, Date datEnc, String banque, String ville, String compta, BigDecimal chqimp, BigDecimal effimp, BigDecimal facins, BigDecimal facent, BigDecimal facmat, BigDecimal regcli, BigDecimal regdiv, BigDecimal efnrec, BigDecimal chqPf, BigDecimal effPf, BigDecimal pieces, String comptaS, Date datComp, String poste, long numEsp, String recouv) {
        this.codUser = codUser;
        this.raison = raison;
        this.datFac = datFac;
        this.espece = espece;
        this.montChq = montChq;
        this.datEnc = datEnc;
        this.banque = banque;
        this.ville = ville;
        this.compta = compta;
        this.chqimp = chqimp;
        this.effimp = effimp;
        this.facins = facins;
        this.facent = facent;
        this.facmat = facmat;
        this.regcli = regcli;
        this.regdiv = regdiv;
        this.efnrec = efnrec;
        this.chqPf = chqPf;
        this.effPf = effPf;
        this.pieces = pieces;
        this.comptaS = comptaS;
        this.datComp = datComp;
        this.poste = poste;
        this.numEsp = numEsp;
        this.recouv = recouv;
    }

    public ModReg() {

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
    @Column(name = "DAT_FAC")
    public Date getDatFac() {
        return datFac;
    }

    public void setDatFac(Date datFac) {
        this.datFac = datFac;
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
    @Column(name = "MONT_CHQ")
    public BigDecimal getMontChq() {
        return montChq;
    }

    public void setMontChq(BigDecimal montChq) {
        this.montChq = montChq;
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
    @Column(name = "POSTE")
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Basic
    @Column(name = "NUM_ESP")
    public long getNumEsp() {
        return numEsp;
    }

    public void setNumEsp(long numEsp) {
        this.numEsp = numEsp;
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
        ModReg modReg = (ModReg) o;
        return id == modReg.id &&
                codUser == modReg.codUser &&
                numEsp == modReg.numEsp &&
                Objects.equals(raison, modReg.raison) &&
                Objects.equals(datFac, modReg.datFac) &&
                Objects.equals(espece, modReg.espece) &&
                Objects.equals(montChq, modReg.montChq) &&
                Objects.equals(datEnc, modReg.datEnc) &&
                Objects.equals(banque, modReg.banque) &&
                Objects.equals(ville, modReg.ville) &&
                Objects.equals(compta, modReg.compta) &&
                Objects.equals(chqimp, modReg.chqimp) &&
                Objects.equals(effimp, modReg.effimp) &&
                Objects.equals(facins, modReg.facins) &&
                Objects.equals(facent, modReg.facent) &&
                Objects.equals(facmat, modReg.facmat) &&
                Objects.equals(regcli, modReg.regcli) &&
                Objects.equals(regdiv, modReg.regdiv) &&
                Objects.equals(efnrec, modReg.efnrec) &&
                Objects.equals(chqPf, modReg.chqPf) &&
                Objects.equals(effPf, modReg.effPf) &&
                Objects.equals(pieces, modReg.pieces) &&
                Objects.equals(comptaS, modReg.comptaS) &&
                Objects.equals(datComp, modReg.datComp) &&
                Objects.equals(poste, modReg.poste) &&
                Objects.equals(recouv, modReg.recouv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codUser, raison, datFac, espece, montChq, datEnc, banque, ville, compta, chqimp, effimp, facins, facent, facmat, regcli, regdiv, efnrec, chqPf, effPf, pieces, comptaS, datComp, poste, numEsp, recouv);
    }

    @Override
    public String toString() {
        return "ModReg{" +
                "id=" + id +
                ", codUser=" + codUser +
                ", raison='" + raison + '\'' +
                ", datFac=" + datFac +
                ", espece=" + espece +
                ", montChq=" + montChq +
                ", datEnc=" + datEnc +
                ", banque='" + banque + '\'' +
                ", ville='" + ville + '\'' +
                ", compta='" + compta + '\'' +
                ", chqimp=" + chqimp +
                ", effimp=" + effimp +
                ", facins=" + facins +
                ", facent=" + facent +
                ", facmat=" + facmat +
                ", regcli=" + regcli +
                ", regdiv=" + regdiv +
                ", efnrec=" + efnrec +
                ", chqPf=" + chqPf +
                ", effPf=" + effPf +
                ", pieces=" + pieces +
                ", comptaS='" + comptaS + '\'' +
                ", datComp=" + datComp +
                ", poste='" + poste + '\'' +
                ", numEsp=" + numEsp +
                ", recouv='" + recouv + '\'' +
                '}';
    }
}
