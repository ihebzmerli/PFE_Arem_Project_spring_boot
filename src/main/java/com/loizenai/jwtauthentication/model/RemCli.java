package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "rem_cli", schema = "seratest")
public class RemCli {
    private long id;
    private String codArt;
    private long famille;
    private long codUser;
    private String libelle;
    private BigDecimal remise;
    private String remiseParClient;
    private String remiseParProduit;
    private String remiseParFamille;

    public RemCli(String codArt, long famille, long codUser, String libelle, BigDecimal remise, String remiseParClient, String remiseParProduit, String remiseParFamille) {
        this.codArt = codArt;
        this.famille = famille;
        this.codUser = codUser;
        this.libelle = libelle;
        this.remise = remise;
        this.remiseParClient = remiseParClient;
        this.remiseParProduit = remiseParProduit;
        this.remiseParFamille = remiseParFamille;
    }

    public RemCli() {

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
    @Column(name = "COD_ART")
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    @Basic
    @Column(name = "FAMILLE")
    public long getFamille() {
        return famille;
    }

    public void setFamille(long famille) {
        this.famille = famille;
    }

    @Basic
    @Column(name = "COD_USER")
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    @Basic
    @Column(name = "LIBELLE")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "REMISE")
    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    @Basic
    @Column(name = "remise_par_client")
    public String getRemiseParClient() {
        return remiseParClient;
    }

    public void setRemiseParClient(String remiseParClient) {
        this.remiseParClient = remiseParClient;
    }

    @Basic
    @Column(name = "remise_par_produit")
    public String getRemiseParProduit() {
        return remiseParProduit;
    }

    public void setRemiseParProduit(String remiseParProduit) {
        this.remiseParProduit = remiseParProduit;
    }

    @Basic
    @Column(name = "remise_par_famille")
    public String getRemiseParFamille() {
        return remiseParFamille;
    }

    public void setRemiseParFamille(String remiseParFamille) {
        this.remiseParFamille = remiseParFamille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemCli remCli = (RemCli) o;
        return id == remCli.id &&
                famille == remCli.famille &&
                codUser == remCli.codUser &&
                Objects.equals(codArt, remCli.codArt) &&
                Objects.equals(libelle, remCli.libelle) &&
                Objects.equals(remise, remCli.remise) &&
                Objects.equals(remiseParClient, remCli.remiseParClient) &&
                Objects.equals(remiseParProduit, remCli.remiseParProduit) &&
                Objects.equals(remiseParFamille, remCli.remiseParFamille);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codArt, famille, codUser, libelle, remise, remiseParClient, remiseParProduit, remiseParFamille);
    }

    @Override
    public String toString() {
        return "RemCli{" +
                "id=" + id +
                ", codArt='" + codArt + '\'' +
                ", famille=" + famille +
                ", codUser=" + codUser +
                ", libelle='" + libelle + '\'' +
                ", remise=" + remise +
                ", remiseParClient='" + remiseParClient + '\'' +
                ", remiseParProduit='" + remiseParProduit + '\'' +
                ", remiseParFamille='" + remiseParFamille + '\'' +
                '}';
    }
}
