package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "note_credit", schema = "seratest")
public class NoteCredit {
    private long num;
    private Date date;
    private long codFrs;
    private String raison;
    private BigDecimal montDev;
    private String nature;
    private String numDoc;
    private String traiter;
    private String valider;
    private Integer regFrs;
    private Date dateSaisi;
    private String devise;
    private String obsrv;
    private long codUser;

    public NoteCredit(Date date, long codFrs, String raison, BigDecimal montDev, String nature, String numDoc, String traiter, String valider, Integer regFrs, Date dateSaisi, String devise, String obsrv, long codUser) {
        this.date = date;
        this.codFrs = codFrs;
        this.raison = raison;
        this.montDev = montDev;
        this.nature = nature;
        this.numDoc = numDoc;
        this.traiter = traiter;
        this.valider = valider;
        this.regFrs = regFrs;
        this.dateSaisi = dateSaisi;
        this.devise = devise;
        this.obsrv = obsrv;
        this.codUser = codUser;
    }

    public NoteCredit() {

    }

    @Id
    @Column(name = "NUM")
    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
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
    @Column(name = "MONT_DEV")
    public BigDecimal getMontDev() {
        return montDev;
    }

    public void setMontDev(BigDecimal montDev) {
        this.montDev = montDev;
    }

    @Basic
    @Column(name = "NATURE")
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Basic
    @Column(name = "NUM_DOC")
    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    @Basic
    @Column(name = "TRAITER")
    public String getTraiter() {
        return traiter;
    }

    public void setTraiter(String traiter) {
        this.traiter = traiter;
    }

    @Basic
    @Column(name = "VALIDER")
    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
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
    @Column(name = "DATE_SAISI")
    public Date getDateSaisi() {
        return dateSaisi;
    }

    public void setDateSaisi(Date dateSaisi) {
        this.dateSaisi = dateSaisi;
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
    @Column(name = "OBSRV")
    public String getObsrv() {
        return obsrv;
    }

    public void setObsrv(String obsrv) {
        this.obsrv = obsrv;
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
        NoteCredit that = (NoteCredit) o;
        return num == that.num &&
                codFrs == that.codFrs &&
                codUser == that.codUser &&
                Objects.equals(date, that.date) &&
                Objects.equals(raison, that.raison) &&
                Objects.equals(montDev, that.montDev) &&
                Objects.equals(nature, that.nature) &&
                Objects.equals(numDoc, that.numDoc) &&
                Objects.equals(traiter, that.traiter) &&
                Objects.equals(valider, that.valider) &&
                Objects.equals(regFrs, that.regFrs) &&
                Objects.equals(dateSaisi, that.dateSaisi) &&
                Objects.equals(devise, that.devise) &&
                Objects.equals(obsrv, that.obsrv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, date, codFrs, raison, montDev, nature, numDoc, traiter, valider, regFrs, dateSaisi, devise, obsrv, codUser);
    }

    @Override
    public String toString() {
        return "NoteCredit{" +
                "num=" + num +
                ", date=" + date +
                ", codFrs=" + codFrs +
                ", raison='" + raison + '\'' +
                ", montDev=" + montDev +
                ", nature='" + nature + '\'' +
                ", numDoc='" + numDoc + '\'' +
                ", traiter='" + traiter + '\'' +
                ", valider='" + valider + '\'' +
                ", regFrs=" + regFrs +
                ", dateSaisi=" + dateSaisi +
                ", devise='" + devise + '\'' +
                ", obsrv='" + obsrv + '\'' +
                ", codUser=" + codUser +
                '}';
    }
}
