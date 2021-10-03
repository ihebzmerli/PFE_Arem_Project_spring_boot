package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "list_chq", schema = "testbd")
public class ListChq {
    private long id;
    private long numBor;
    private long numChq;
    private Date echeance;
    private BigDecimal montant;
    private String raison;
    private String banque;
    private String ville;

    public ListChq(long numBor, Date echeance, BigDecimal montant, String raison, String banque, String ville) {
        this.numBor = numBor;
        this.echeance = echeance;
        this.montant = montant;
        this.raison = raison;
        this.banque = banque;
        this.ville = ville;
    }

    public ListChq() {

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

    @Column(name = "NUM_CHQ")
    public long getNumChq() {
        return numChq;
    }

    public void setNumChq(long numChq) {
        this.numChq = numChq;
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
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListChq listChq = (ListChq) o;
        return id == listChq.id &&
                numBor == listChq.numBor &&
                numChq == listChq.numChq &&
                Objects.equals(echeance, listChq.echeance) &&
                Objects.equals(montant, listChq.montant) &&
                Objects.equals(raison, listChq.raison) &&
                Objects.equals(banque, listChq.banque) &&
                Objects.equals(ville, listChq.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numBor, numChq, echeance, montant, raison, banque, ville);
    }

    @Override
    public String toString() {
        return "ListChq{" +
                "id=" + id +
                ", numBor=" + numBor +
                ", numChq=" + numChq +
                ", echeance=" + echeance +
                ", montant=" + montant +
                ", raison='" + raison + '\'' +
                ", banque='" + banque + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
