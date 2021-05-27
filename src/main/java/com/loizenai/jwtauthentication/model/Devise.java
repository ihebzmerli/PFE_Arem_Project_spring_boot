package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Devise {
    private long id;
    private String code;
    private BigDecimal coef;

    public Devise(BigDecimal coef) {
        this.coef = coef;
    }

    public Devise() {

    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "COEF")
    public BigDecimal getCoef() {
        return coef;
    }

    public void setCoef(BigDecimal coef) {
        this.coef = coef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devise devise = (Devise) o;
        return id == devise.id &&
                Objects.equals(code, devise.code) &&
                Objects.equals(coef, devise.coef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, coef);
    }

    @Override
    public String toString() {
        return "Devise{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", coef=" + coef +
                '}';
    }
}
