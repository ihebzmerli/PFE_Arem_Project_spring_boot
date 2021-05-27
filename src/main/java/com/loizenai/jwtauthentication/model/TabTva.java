package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tab_tva", schema = "seratest", catalog = "")
public class TabTva {
    private long id;
    private Byte tva;
    private String xcompte;
    private String riscompte;
    private String compte;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TVA")
    public Byte getTva() {
        return tva;
    }

    public void setTva(Byte tva) {
        this.tva = tva;
    }

    @Basic
    @Column(name = "XCOMPTE")
    public String getXcompte() {
        return xcompte;
    }

    public void setXcompte(String xcompte) {
        this.xcompte = xcompte;
    }

    @Basic
    @Column(name = "RISCOMPTE")
    public String getRiscompte() {
        return riscompte;
    }

    public void setRiscompte(String riscompte) {
        this.riscompte = riscompte;
    }

    @Basic
    @Column(name = "COMPTE")
    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabTva tabTva = (TabTva) o;
        return id == tabTva.id &&
                Objects.equals(tva, tabTva.tva) &&
                Objects.equals(xcompte, tabTva.xcompte) &&
                Objects.equals(riscompte, tabTva.riscompte) &&
                Objects.equals(compte, tabTva.compte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tva, xcompte, riscompte, compte);
    }
}
