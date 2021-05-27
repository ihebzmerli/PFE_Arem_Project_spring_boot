package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Famnpret {
    private long id;
    private String famille;
    private Date date;
    private String numAff;

    public Famnpret(String famille, Date date, String numAff) {
        this.famille = famille;
        this.date = date;
        this.numAff = numAff;
    }

    public Famnpret() {

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
    @Column(name = "FAMILLE")
    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
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
    @Column(name = "NUM_AFF")
    public String getNumAff() {
        return numAff;
    }

    public void setNumAff(String numAff) {
        this.numAff = numAff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Famnpret famnpret = (Famnpret) o;
        return id == famnpret.id &&
                Objects.equals(famille, famnpret.famille) &&
                Objects.equals(date, famnpret.date) &&
                Objects.equals(numAff, famnpret.numAff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, famille, date, numAff);
    }

    @Override
    public String toString() {
        return "Famnpret{" +
                "id=" + id +
                ", famille='" + famille + '\'' +
                ", date=" + date +
                ", numAff='" + numAff + '\'' +
                '}';
    }
}
