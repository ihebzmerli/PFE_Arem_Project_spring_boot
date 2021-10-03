package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "typ_voit", schema = "testbd", catalog = "")
public class TypVoit {
    private long id;
    private String marque;

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
        TypVoit typVoit = (TypVoit) o;
        return id == typVoit.id &&
                Objects.equals(marque, typVoit.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marque);
    }
}
