package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Banque {
    private long id;
    private String libBank;
    private long codBank;
    private BigDecimal tauxInt;
    private String rib;

    public Banque(BigDecimal tauxInt, String rib) {
        this.tauxInt = tauxInt;
        this.rib = rib;
    }

    public Banque() {

    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "LIB_BANK")
    public String getLibBank() {
        return libBank;
    }

    public void setLibBank(String libBank) {
        this.libBank = libBank;
    }

    @Column(name = "COD_BANK")
    public long getCodBank() {
        return codBank;
    }

    public void setCodBank(long codBank) {
        this.codBank = codBank;
    }

    @Basic
    @Column(name = "TAUX_INT")
    public BigDecimal getTauxInt() {
        return tauxInt;
    }

    public void setTauxInt(BigDecimal tauxInt) {
        this.tauxInt = tauxInt;
    }

    @Basic
    @Column(name = "RIB")
    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banque banque = (Banque) o;
        return id == banque.id &&
                codBank == banque.codBank &&
                Objects.equals(libBank, banque.libBank) &&
                Objects.equals(tauxInt, banque.tauxInt) &&
                Objects.equals(rib, banque.rib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libBank, codBank, tauxInt, rib);
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", libBank='" + libBank + '\'' +
                ", codBank=" + codBank +
                ", tauxInt=" + tauxInt +
                ", rib='" + rib + '\'' +
                '}';
    }
}
