package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "fond_caisse", schema = "testbd")
public class FondCaisse {
    private long id;
    private Date date;
    private String type;
    private String banque;
    private BigDecimal montant;
    private String etat;
    private long codUser;

    public FondCaisse(Date date, String type, String banque, BigDecimal montant, String etat, long codUser) {
        this.date = date;
        this.type = type;
        this.banque = banque;
        this.montant = montant;
        this.etat = etat;
        this.codUser = codUser;
    }

    public FondCaisse() {

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
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    @Column(name = "BANQUE")
    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
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
    @Column(name = "ETAT")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
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
        FondCaisse that = (FondCaisse) o;
        return id == that.id &&
                codUser == that.codUser &&
                Objects.equals(date, that.date) &&
                Objects.equals(type, that.type) &&
                Objects.equals(banque, that.banque) &&
                Objects.equals(montant, that.montant) &&
                Objects.equals(etat, that.etat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, type, banque, montant, etat, codUser);
    }

    @Override
    public String toString() {
        return "FondCaisse{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", banque='" + banque + '\'' +
                ", montant=" + montant +
                ", etat='" + etat + '\'' +
                ", codUser=" + codUser +
                '}';
    }
}
