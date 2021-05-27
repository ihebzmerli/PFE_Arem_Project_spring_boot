package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "achatss_articles", schema = "seratest")
public class ArtAcha implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private Byte bonise;
    private BigDecimal prixAch;
    private BigDecimal prixVen;
    private Byte tva;
    private BigDecimal prixAMp;
    private String centre;

    @Column(name = "cod_art")
    private String cod_art;

    @Column(name = "num_doc")
    private long num_doc;
    /**FK start */

    
/**FK end */

    public ArtAcha(Byte bonise, BigDecimal prixAch, BigDecimal prixVen, Byte tva,BigDecimal prixAMp, String centre) {
        this.bonise = bonise;
        this.prixAch = prixAch;
        this.prixVen = prixVen;
        this.tva = tva;
        this.prixAMp = prixAMp;
        this.centre = centre;
    }

    public ArtAcha(long id, Byte bonise, BigDecimal prixAch, BigDecimal prixVen, Byte tva, BigDecimal prixAMp,
        String centre, String cod_art, long num_doc) {
    this.id = id;
    this.bonise = bonise;
    this.prixAch = prixAch;
    this.prixVen = prixVen;
    this.tva = tva;
    this.prixAMp = prixAMp;
    this.centre = centre;
    this.cod_art = cod_art;
    this.num_doc = num_doc;
}

    public ArtAcha() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BONISE")
    public Byte getBonise() {
        return bonise;
    }

    public void setBonise(Byte bonise) {
        this.bonise = bonise;
    }

    @Basic
    @Column(name = "PRIX_ACH")
    public BigDecimal getPrixAch() {
        return prixAch;
    }

    public void setPrixAch(BigDecimal prixAch) {
        this.prixAch = prixAch;
    }

    @Basic
    @Column(name = "PRIX_VEN")
    public BigDecimal getPrixVen() {
        return prixVen;
    }

    public void setPrixVen(BigDecimal prixVen) {
        this.prixVen = prixVen;
    }

    @Basic
    @Column(name = "TVA")
    public Byte getTva() {
        return tva;
    }

    public void setTva(Byte tva) {
        this.tva = tva;
    }

    @Basic
    @Column(name = "PRIX_A_MP")
    public BigDecimal getPrixAMp() {
        return prixAMp;
    }

    public void setPrixAMp(BigDecimal prixAMp) {
        this.prixAMp = prixAMp;
    }

    @Basic
    @Column(name = "CENTRE")
    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getCod_art() {
        return cod_art;
    }

    public void setCod_art(String cod_art) {
        this.cod_art = cod_art;
    }

    public long getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(long num_doc) {
        this.num_doc = num_doc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bonise == null) ? 0 : bonise.hashCode());
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((cod_art == null) ? 0 : cod_art.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (num_doc ^ (num_doc >>> 32));
        result = prime * result + ((prixAMp == null) ? 0 : prixAMp.hashCode());
        result = prime * result + ((prixAch == null) ? 0 : prixAch.hashCode());
        result = prime * result + ((prixVen == null) ? 0 : prixVen.hashCode());
        result = prime * result + ((tva == null) ? 0 : tva.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArtAcha other = (ArtAcha) obj;
        if (bonise == null) {
            if (other.bonise != null)
                return false;
        } else if (!bonise.equals(other.bonise))
            return false;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (cod_art == null) {
            if (other.cod_art != null)
                return false;
        } else if (!cod_art.equals(other.cod_art))
            return false;
        if (id != other.id)
            return false;
        if (num_doc != other.num_doc)
            return false;
        if (prixAMp == null) {
            if (other.prixAMp != null)
                return false;
        } else if (!prixAMp.equals(other.prixAMp))
            return false;
        if (prixAch == null) {
            if (other.prixAch != null)
                return false;
        } else if (!prixAch.equals(other.prixAch))
            return false;
        if (prixVen == null) {
            if (other.prixVen != null)
                return false;
        } else if (!prixVen.equals(other.prixVen))
            return false;
        if (tva == null) {
            if (other.tva != null)
                return false;
        } else if (!tva.equals(other.tva))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArtAcha [bonise=" + bonise + ", centre=" + centre + ", cod_art=" + cod_art + ", id="
                + id + ", num_doc=" + num_doc + ", prixAMp=" + prixAMp + ", prixAch=" + prixAch + ", prixVen=" + prixVen
                + ", tva=" + tva + "]";
    }


    
}
