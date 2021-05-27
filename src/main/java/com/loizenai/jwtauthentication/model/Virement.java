package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Virement {
    private long id;
    private long codUser;
    private String raison;
    private Date datVir;
    private BigDecimal montant;
    private String compta;
    private String banque;
    private BigDecimal efnrec;
    private BigDecimal effPf;
    private BigDecimal facins;
    private BigDecimal effimp;
    private BigDecimal regcli;
    private BigDecimal chqPf;
    private BigDecimal chqimp;
    private BigDecimal regdiv;
    private String type;
    private String comptaS;
    private Date datComp;
    private String poste;
    private String recouv;
    private String comptas;

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
    @Column(name = "DAT_VIR")
    public Date getDatVir() {
        return datVir;
    }

    public void setDatVir(Date datVir) {
        this.datVir = datVir;
    }

    @Basic
    @Column(name = "MONTANT")
    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
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
    @Column(name = "BANQUE")
    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
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
    @Column(name = "EFF_PF")
    public BigDecimal getEffPf() {
        return effPf;
    }

    public void setEffPf(BigDecimal effPf) {
        this.effPf = effPf;
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
    @Column(name = "EFFIMP")
    public BigDecimal getEffimp() {
        return effimp;
    }

    public void setEffimp(BigDecimal effimp) {
        this.effimp = effimp;
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
    @Column(name = "CHQ_PF")
    public BigDecimal getChqPf() {
        return chqPf;
    }

    public void setChqPf(BigDecimal chqPf) {
        this.chqPf = chqPf;
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
    @Column(name = "REGDIV")
    public BigDecimal getRegdiv() {
        return regdiv;
    }

    public void setRegdiv(BigDecimal regdiv) {
        this.regdiv = regdiv;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "RECOUV")
    public String getRecouv() {
        return recouv;
    }

    public void setRecouv(String recouv) {
        this.recouv = recouv;
    }

    @Basic
    @Column(name = "comptas")
    public String getComptas() {
        return comptas;
    }

    public void setComptas(String comptas) {
        this.comptas = comptas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Virement virement = (Virement) o;
        return id == virement.id &&
                codUser == virement.codUser &&
                Objects.equals(raison, virement.raison) &&
                Objects.equals(datVir, virement.datVir) &&
                Objects.equals(montant, virement.montant) &&
                Objects.equals(compta, virement.compta) &&
                Objects.equals(banque, virement.banque) &&
                Objects.equals(efnrec, virement.efnrec) &&
                Objects.equals(effPf, virement.effPf) &&
                Objects.equals(facins, virement.facins) &&
                Objects.equals(effimp, virement.effimp) &&
                Objects.equals(regcli, virement.regcli) &&
                Objects.equals(chqPf, virement.chqPf) &&
                Objects.equals(chqimp, virement.chqimp) &&
                Objects.equals(regdiv, virement.regdiv) &&
                Objects.equals(type, virement.type) &&
                Objects.equals(comptaS, virement.comptaS) &&
                Objects.equals(datComp, virement.datComp) &&
                Objects.equals(poste, virement.poste) &&
                Objects.equals(recouv, virement.recouv) &&
                Objects.equals(comptas, virement.comptas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codUser, raison, datVir, montant, compta, banque, efnrec, effPf, facins, effimp, regcli, chqPf, chqimp, regdiv, type, comptaS, datComp, poste, recouv, comptas);
    }
}
