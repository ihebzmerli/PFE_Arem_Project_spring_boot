package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bor_esp", schema = "seratest")
public class BorEsp {
    private long id;
    private String numBor;
    private Date datBor;
    private String banque;
    private String agence;
    private BigDecimal totBor;
    private Date datRem;
    private String valid;
    private String typBor;
    private String tresor;
    private String compta;
    private String numBorBq;
    private Date datComp;
    private String poste;
    private long numEsp;
    private long codUser;

    public BorEsp(String numBor, Date datBor, String banque, String agence, BigDecimal totBor, Date datRem, String valid, String typBor, String tresor, String compta, String numBorBq, Date datComp, String poste, long numEsp, long codUser) {
        this.numBor = numBor;
        this.datBor = datBor;
        this.banque = banque;
        this.agence = agence;
        this.totBor = totBor;
        this.datRem = datRem;
        this.valid = valid;
        this.typBor = typBor;
        this.tresor = tresor;
        this.compta = compta;
        this.numBorBq = numBorBq;
        this.datComp = datComp;
        this.poste = poste;
        this.numEsp = numEsp;
        this.codUser = codUser;
    }

    public BorEsp() {

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
    @Column(name = "NUM_BOR")
    public String getNumBor() {
        return numBor;
    }

    public void setNumBor(String numBor) {
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
    @Column(name = "TYP_BOR")
    public String getTypBor() {
        return typBor;
    }

    public void setTypBor(String typBor) {
        this.typBor = typBor;
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
    @Column(name = "NUM_ESP")
    public long getNumEsp() {
        return numEsp;
    }

    public void setNumEsp(long numEsp) {
        this.numEsp = numEsp;
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
        BorEsp borEsp = (BorEsp) o;
        return id == borEsp.id &&
                numEsp == borEsp.numEsp &&
                codUser == borEsp.codUser &&
                Objects.equals(numBor, borEsp.numBor) &&
                Objects.equals(datBor, borEsp.datBor) &&
                Objects.equals(banque, borEsp.banque) &&
                Objects.equals(agence, borEsp.agence) &&
                Objects.equals(totBor, borEsp.totBor) &&
                Objects.equals(datRem, borEsp.datRem) &&
                Objects.equals(valid, borEsp.valid) &&
                Objects.equals(typBor, borEsp.typBor) &&
                Objects.equals(tresor, borEsp.tresor) &&
                Objects.equals(compta, borEsp.compta) &&
                Objects.equals(numBorBq, borEsp.numBorBq) &&
                Objects.equals(datComp, borEsp.datComp) &&
                Objects.equals(poste, borEsp.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numBor, datBor, banque, agence, totBor, datRem, valid, typBor, tresor, compta, numBorBq, datComp, poste, numEsp, codUser);
    }
}
