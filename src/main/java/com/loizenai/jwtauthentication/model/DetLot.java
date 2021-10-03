package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "det_lot", schema = "testbd")
public class DetLot {
    
    private long id;
    private String codArt1;
    private String desArt1;
    private String codArt2;
    private String desArt2;
    private Integer qut2;

    public DetLot(String codArt1, String desArt1, String codArt2, String desArt2, Integer qut2) {
        this.codArt1 = codArt1;
        this.desArt1 = desArt1;
        this.codArt2 = codArt2;
        this.desArt2 = desArt2;
        this.qut2 = qut2;
    }

    public DetLot() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COD_ART1")
    public String getCodArt1() {
        return codArt1;
    }

    public void setCodArt1(String codArt1) {
        this.codArt1 = codArt1;
    }

    @Basic
    @Column(name = "DES_ART1")
    public String getDesArt1() {
        return desArt1;
    }

    public void setDesArt1(String desArt1) {
        this.desArt1 = desArt1;
    }

    @Basic
    @Column(name = "COD_ART2")
    public String getCodArt2() {
        return codArt2;
    }

    public void setCodArt2(String codArt2) {
        this.codArt2 = codArt2;
    }

    @Basic
    @Column(name = "DES_ART2")
    public String getDesArt2() {
        return desArt2;
    }

    public void setDesArt2(String desArt2) {
        this.desArt2 = desArt2;
    }

    @Basic
    @Column(name = "QUT2")
    public Integer getQut2() {
        return qut2;
    }

    public void setQut2(Integer qut2) {
        this.qut2 = qut2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetLot detLot = (DetLot) o;
        return id == detLot.id &&
                Objects.equals(codArt1, detLot.codArt1) &&
                Objects.equals(desArt1, detLot.desArt1) &&
                Objects.equals(codArt2, detLot.codArt2) &&
                Objects.equals(desArt2, detLot.desArt2) &&
                Objects.equals(qut2, detLot.qut2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codArt1, desArt1, codArt2, desArt2, qut2);
    }

    @Override
    public String toString() {
        return "DetLot{" +
                "id=" + id +
                ", codArt1='" + codArt1 + '\'' +
                ", desArt1='" + desArt1 + '\'' +
                ", codArt2='" + codArt2 + '\'' +
                ", desArt2='" + desArt2 + '\'' +
                ", qut2=" + qut2 +
                '}';
    }
}
