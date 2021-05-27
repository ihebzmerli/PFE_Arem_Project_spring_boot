package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Aremise {
    private long id;
    private long codFrs;
    private String docReg;
    private BigDecimal montDoc;
    private Date datDoc;
    private String nature;
    private String compta;
    private Date datComp;
    private BigDecimal taux;
    private String poste;

    public Aremise(long codFrs, String docReg, BigDecimal montDoc, Date datDoc, String nature, String compta, Date datComp, BigDecimal taux, String poste) {
        this.codFrs = codFrs;
        this.docReg = docReg;
        this.montDoc = montDoc;
        this.datDoc = datDoc;
        this.nature = nature;
        this.compta = compta;
        this.datComp = datComp;
        this.taux = taux;
        this.poste = poste;
    }

    public Aremise() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "DOC_REG")
    public String getDocReg() {
        return docReg;
    }

    public void setDocReg(String docReg) {
        this.docReg = docReg;
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
    @Column(name = "DAT_DOC")
    public Date getDatDoc() {
        return datDoc;
    }

    public void setDatDoc(Date datDoc) {
        this.datDoc = datDoc;
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
    @Column(name = "COMPTA")
    public String getCompta() {
        return compta;
    }

    public void setCompta(String compta) {
        this.compta = compta;
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
    @Column(name = "TAUX")
    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
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
        Aremise aremise = (Aremise) o;
        return id == aremise.id &&
                codFrs == aremise.codFrs &&
                Objects.equals(docReg, aremise.docReg) &&
                Objects.equals(montDoc, aremise.montDoc) &&
                Objects.equals(datDoc, aremise.datDoc) &&
                Objects.equals(nature, aremise.nature) &&
                Objects.equals(compta, aremise.compta) &&
                Objects.equals(datComp, aremise.datComp) &&
                Objects.equals(taux, aremise.taux) &&
                Objects.equals(poste, aremise.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codFrs, docReg, montDoc, datDoc, nature, compta, datComp, taux, poste);
    }

    @Override
    public String toString() {
        return "Aremise{" +
                "id=" + id +
                ", codFrs=" + codFrs +
                ", docReg='" + docReg + '\'' +
                ", montDoc=" + montDoc +
                ", datDoc=" + datDoc +
                ", nature='" + nature + '\'' +
                ", compta='" + compta + '\'' +
                ", datComp=" + datComp +
                ", taux=" + taux +
                ", poste='" + poste + '\'' +
                '}';
    }
}
