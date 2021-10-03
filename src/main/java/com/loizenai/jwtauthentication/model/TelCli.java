package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tel_cli", schema = "testbd", catalog = "")
public class TelCli {
    private long id;
    private String codCli;
    private String raison;
    private String tel;
    private String nom;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COD_CLI")
    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

    @Basic
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Basic
    @Column(name = "TEL")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelCli telCli = (TelCli) o;
        return id == telCli.id &&
                Objects.equals(codCli, telCli.codCli) &&
                Objects.equals(raison, telCli.raison) &&
                Objects.equals(tel, telCli.tel) &&
                Objects.equals(nom, telCli.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codCli, raison, tel, nom);
    }
}
