package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lign_pro", schema = "seratest")
public class LignPro {
    private long id;
    private String libelle;

    public LignPro(String libelle) {
        this.libelle = libelle;
    }

    public LignPro() {

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
    @Column(name = "LIBELLE")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LignPro lignPro = (LignPro) o;
        return id == lignPro.id &&
                Objects.equals(libelle, lignPro.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }

    @Override
    public String toString() {
        return "LignPro{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
