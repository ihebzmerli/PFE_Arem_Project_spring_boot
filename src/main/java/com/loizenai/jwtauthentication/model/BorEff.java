package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bor_eff", schema = "seratest")
public class BorEff {
    private long id;
    private long numBor;
    private Date datBor;
    private String typBor;
    private String banque;
    private String agence;
    private BigDecimal totBor;
    private Date datRem;
    private String valid;
    private String tresor;
    private String compta;
    private String numBorBq;
    private Date datComp;
    private String poste;
    private long codUser;

    public BorEff(Date datBor, String typBor, String banque, String agence, BigDecimal totBor, Date datRem, String valid, String tresor, String compta, String numBorBq, Date datComp, String poste, long codUser) {
        this.datBor = datBor;
        this.typBor = typBor;
        this.banque = banque;
        this.agence = agence;
        this.totBor = totBor;
        this.datRem = datRem;
        this.valid = valid;
        this.tresor = tresor;
        this.compta = compta;
        this.numBorBq = numBorBq;
        this.datComp = datComp;
        this.poste = poste;
        this.codUser = codUser;
    }

    public BorEff() {

    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUM_BOR")
    public long getNumBor() {
        return numBor;
    }

    public void setNumBor(long numBor) {
        this.numBor = numBor;
    }

    @Basic
    @Column(name = "DAT_BOR")
    public Date getDatBor() {
        return datBor;
    }

    public void setDatBor(Date datBor) {
        this.datBor = datBor;
    }

    @Basic
    @Column(name = "TYP_BOR")
    public String getTypBor() {
        return typBor;
    }

    public void setTypBor(String typBor) {
        this.typBor = typBor;
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
    @Column(name = "AGENCE")
    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    @Basic
    @Column(name = "TOT_BOR")
    public BigDecimal getTotBor() {
        return totBor;
    }

    public void setTotBor(BigDecimal totBor) {
        this.totBor = totBor;
    }

    @Basic
    @Column(name = "DAT_REM")
    public Date getDatRem() {
        return datRem;
    }

    public void setDatRem(Date datRem) {
        this.datRem = datRem;
    }

    @Basic
    @Column(name = "VALID")
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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
    @Column(name = "COMPTA")
    public String getCompta() {
        return compta;
    }

    public void setCompta(String compta) {
        this.compta = compta;
    }

    @Basic
    @Column(name = "NUM_BOR_BQ")
    public String getNumBorBq() {
        return numBorBq;
    }

    public void setNumBorBq(String numBorBq) {
        this.numBorBq = numBorBq;
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
    @Column(name = "COD_USER")
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorEff borEff = (BorEff) o;
        return id == borEff.id &&
                numBor == borEff.numBor &&
                codUser == borEff.codUser &&
                Objects.equals(datBor, borEff.datBor) &&
                Objects.equals(typBor, borEff.typBor) &&
                Objects.equals(banque, borEff.banque) &&
                Objects.equals(agence, borEff.agence) &&
                Objects.equals(totBor, borEff.totBor) &&
                Objects.equals(datRem, borEff.datRem) &&
                Objects.equals(valid, borEff.valid) &&
                Objects.equals(tresor, borEff.tresor) &&
                Objects.equals(compta, borEff.compta) &&
                Objects.equals(numBorBq, borEff.numBorBq) &&
                Objects.equals(datComp, borEff.datComp) &&
                Objects.equals(poste, borEff.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numBor, datBor, typBor, banque, agence, totBor, datRem, valid, tresor, compta, numBorBq, datComp, poste, codUser);
    }

    @Override
    public String toString() {
        return "BorEff{" +
                "id=" + id +
                ", numBor=" + numBor +
                ", datBor=" + datBor +
                ", typBor='" + typBor + '\'' +
                ", banque='" + banque + '\'' +
                ", agence='" + agence + '\'' +
                ", totBor=" + totBor +
                ", datRem=" + datRem +
                ", valid='" + valid + '\'' +
                ", tresor='" + tresor + '\'' +
                ", compta='" + compta + '\'' +
                ", numBorBq='" + numBorBq + '\'' +
                ", datComp=" + datComp +
                ", poste='" + poste + '\'' +
                ", codUser=" + codUser +
                '}';
    }
}
