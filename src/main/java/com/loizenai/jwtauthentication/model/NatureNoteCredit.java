package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nature_note_credit", schema = "seratest")
public class NatureNoteCredit {
    private long id;
    private String libelle;

    public NatureNoteCredit(String libelle) {
        this.libelle = libelle;
    }

    public NatureNoteCredit() {

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
        NatureNoteCredit that = (NatureNoteCredit) o;
        return id == that.id &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }

    @Override
    public String toString() {
        return "NatureNoteCredit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
