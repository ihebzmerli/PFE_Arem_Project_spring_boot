package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "av_cli", schema = "testbd")
public class AvCli {
    private long id;
    private long codUser;
    private String raison;
    private long numDoc;
    private BigDecimal montDoc;
    private BigDecimal montReg;
    private BigDecimal avance;
    private String annul;

    public AvCli(long codUser, String raison, long numDoc, BigDecimal montDoc, BigDecimal montReg, BigDecimal avance, String annul) {
        this.codUser = codUser;
        this.raison = raison;
        this.numDoc = numDoc;
        this.montDoc = montDoc;
        this.montReg = montReg;
        this.avance = avance;
        this.annul = annul;
    }

    public AvCli() {

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
    @Column(name = "NUM_DOC")
    public long getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(long numDoc) {
        this.numDoc = numDoc;
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
    @Column(name = "MONT_REG")
    public BigDecimal getMontReg() {
        return montReg;
    }

    public void setMontReg(BigDecimal montReg) {
        this.montReg = montReg;
    }

    @Basic
    @Column(name = "AVANCE")
    public BigDecimal getAvance() {
        return avance;
    }

    public void setAvance(BigDecimal avance) {
        this.avance = avance;
    }

    @Basic
    @Column(name = "ANNUL")
    public String getAnnul() {
        return annul;
    }

    public void setAnnul(String annul) {
        this.annul = annul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvCli avCli = (AvCli) o;
        return id == avCli.id &&
                codUser == avCli.codUser &&
                numDoc == avCli.numDoc &&
                Objects.equals(raison, avCli.raison) &&
                Objects.equals(montDoc, avCli.montDoc) &&
                Objects.equals(montReg, avCli.montReg) &&
                Objects.equals(avance, avCli.avance) &&
                Objects.equals(annul, avCli.annul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codUser, raison, numDoc, montDoc, montReg, avance, annul);
    }
}
