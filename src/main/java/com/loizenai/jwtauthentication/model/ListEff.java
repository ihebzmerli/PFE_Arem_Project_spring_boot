package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "list_eff", schema = "seratest")
public class ListEff {
    private long id;
    private long numBor;
    private long numEff;
    private Date datEff;
    private Date echeance;
    private BigDecimal montant;
    private long codUser;
    private String tire;

    public ListEff(long numBor, long numEff, Date datEff, Date echeance, BigDecimal montant, long codUser, String tire) {
        this.numBor = numBor;
        this.numEff = numEff;
        this.datEff = datEff;
        this.echeance = echeance;
        this.montant = montant;
        this.codUser = codUser;
        this.tire = tire;
    }

    public ListEff() {

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
    public long getNumBor() {
        return numBor;
    }

    public void setNumBor(long numBor) {
        this.numBor = numBor;
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
    @Column(name = "MONTANT")
    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
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
    @Column(name = "TIRE")
    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListEff listEff = (ListEff) o;
        return id == listEff.id &&
                numBor == listEff.numBor &&
                numEff == listEff.numEff &&
                codUser == listEff.codUser &&
                Objects.equals(datEff, listEff.datEff) &&
                Objects.equals(echeance, listEff.echeance) &&
                Objects.equals(montant, listEff.montant) &&
                Objects.equals(tire, listEff.tire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numBor, numEff, datEff, echeance, montant, codUser, tire);
    }

    @Override
    public String toString() {
        return "ListEff{" +
                "id=" + id +
                ", numBor=" + numBor +
                ", numEff=" + numEff +
                ", datEff=" + datEff +
                ", echeance=" + echeance +
                ", montant=" + montant +
                ", codUser=" + codUser +
                ", tire='" + tire + '\'' +
                '}';
    }
}
