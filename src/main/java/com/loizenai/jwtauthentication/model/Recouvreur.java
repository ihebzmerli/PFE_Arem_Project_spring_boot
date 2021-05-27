package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Recouvreur {
    private long id;
    private String recouvreur;

    public Recouvreur(String recouvreur) {
        this.recouvreur = recouvreur;
    }

    public Recouvreur() {

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
    @Column(name = "RECOUVREUR")
    public String getRecouvreur() {
        return recouvreur;
    }

    public void setRecouvreur(String recouvreur) {
        this.recouvreur = recouvreur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recouvreur that = (Recouvreur) o;
        return id == that.id &&
                Objects.equals(recouvreur, that.recouvreur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recouvreur);
    }

    @Override
    public String toString() {
        return "Recouvreur{" +
                "id=" + id +
                ", recouvreur='" + recouvreur + '\'' +
                '}';
    }
}
