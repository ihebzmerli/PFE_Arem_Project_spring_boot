package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "marque", schema = "seratest")
public class Marque implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String marque;

    public Marque(String marque) {
        this.marque = marque;
    }

    public Marque() {

    }
    
    public Marque(long id, String marque) {
        this.id = id;
        this.marque = marque;
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
    @Column(name = "MARQUE")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque1 = (Marque) o;
        return id == marque1.id &&
                Objects.equals(marque, marque1.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marque);
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                '}';
    }
}
