package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "prime", schema = "testbd")
public class Prime implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prime")
    private long id;

    private String raison;
    private String categorie;
    private BigDecimal objMin;
    private BigDecimal objMax;
    private BigDecimal ca;

    @Column(name = "CA_N1")
    private BigDecimal caN1;
    private Timestamp derMvt;
    private BigDecimal mort;
    private String artSpec;
    private BigDecimal prime;
    private String bloc;
    private Long nbArt;
    private BigDecimal marge;

    //FK_KEYS***********************
    
    @OneToMany(mappedBy = "prime", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Livreur> livreurs;

    //END FK_KEYS***********************   
    
    
    public Prime() {

    }

    public Prime(long id, String raison, String categorie, BigDecimal objMin, BigDecimal objMax, BigDecimal ca,
            BigDecimal caN1, Timestamp derMvt, BigDecimal mort, String artSpec, BigDecimal prime, String bloc,
            Long nbArt, BigDecimal marge, List<Livreur> livreurs) {
        this.id = id;
        this.raison = raison;
        this.categorie = categorie;
        this.objMin = objMin;
        this.objMax = objMax;
        this.ca = ca;
        this.caN1 = caN1;
        this.derMvt = derMvt;
        this.mort = mort;
        this.artSpec = artSpec;
        this.prime = prime;
        this.bloc = bloc;
        this.nbArt = nbArt;
        this.marge = marge;
        this.livreurs = livreurs;
    }

    public Prime(String raison, String categorie, BigDecimal objMin, BigDecimal objMax, BigDecimal ca, BigDecimal caN1, Timestamp derMvt, BigDecimal mort, String artSpec, BigDecimal prime, String bloc, Long nbArt, BigDecimal marge) {
        this.raison = raison;
        this.categorie = categorie;
        this.objMin = objMin;
        this.objMax = objMax;
        this.ca = ca;
        this.caN1 = caN1;
        this.derMvt = derMvt;
        this.mort = mort;
        this.artSpec = artSpec;
        this.prime = prime;
        this.bloc = bloc;
        this.nbArt = nbArt;
        this.marge = marge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "CATEGORIE")
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Basic
    @Column(name = "OBJ_MIN")
    public BigDecimal getObjMin() {
        return objMin;
    }

    public void setObjMin(BigDecimal objMin) {
        this.objMin = objMin;
    }

    @Basic
    @Column(name = "OBJ_MAX")
    public BigDecimal getObjMax() {
        return objMax;
    }

    public void setObjMax(BigDecimal objMax) {
        this.objMax = objMax;
    }

    @Basic
    @Column(name = "CA")
    public BigDecimal getCa() {
        return ca;
    }

    public void setCa(BigDecimal ca) {
        this.ca = ca;
    }


    public BigDecimal getCaN1() {
        return caN1;
    }

    public void setCaN1(BigDecimal caN1) {
        this.caN1 = caN1;
    }

    @Basic
    @Column(name = "DER_MVT")
    public Timestamp getDerMvt() {
        return derMvt;
    }

    public void setDerMvt(Timestamp derMvt) {
        this.derMvt = derMvt;
    }

    @Basic
    @Column(name = "MORT")
    public BigDecimal getMort() {
        return mort;
    }

    public void setMort(BigDecimal mort) {
        this.mort = mort;
    }

    @Basic
    @Column(name = "ART_SPEC")
    public String getArtSpec() {
        return artSpec;
    }

    public void setArtSpec(String artSpec) {
        this.artSpec = artSpec;
    }

    @Basic
    @Column(name = "PRIME")
    public BigDecimal getPrime() {
        return prime;
    }

    public void setPrime(BigDecimal prime) {
        this.prime = prime;
    }

    @Basic
    @Column(name = "BLOC")
    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    @Basic
    @Column(name = "NB_ART")
    public Long getNbArt() {
        return nbArt;
    }

    public void setNbArt(Long nbArt) {
        this.nbArt = nbArt;
    }

    @Basic
    @Column(name = "MARGE")
    public BigDecimal getMarge() {
        return marge;
    }

    public void setMarge(BigDecimal marge) {
        this.marge = marge;
    }


    public void setLivreurs(List<Livreur> livreurs) {
        this.livreurs = livreurs;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((artSpec == null) ? 0 : artSpec.hashCode());
        result = prime * result + ((bloc == null) ? 0 : bloc.hashCode());
        result = prime * result + ((ca == null) ? 0 : ca.hashCode());
        result = prime * result + ((caN1 == null) ? 0 : caN1.hashCode());
        result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
        result = prime * result + ((derMvt == null) ? 0 : derMvt.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((marge == null) ? 0 : marge.hashCode());
        result = prime * result + ((mort == null) ? 0 : mort.hashCode());
        result = prime * result + ((nbArt == null) ? 0 : nbArt.hashCode());
        result = prime * result + ((objMax == null) ? 0 : objMax.hashCode());
        result = prime * result + ((objMin == null) ? 0 : objMin.hashCode());
        result = prime * result + ((this.prime == null) ? 0 : this.prime.hashCode());
        result = prime * result + ((raison == null) ? 0 : raison.hashCode());
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
        Prime other = (Prime) obj;
        if (artSpec == null) {
            if (other.artSpec != null)
                return false;
        } else if (!artSpec.equals(other.artSpec))
            return false;
        if (bloc == null) {
            if (other.bloc != null)
                return false;
        } else if (!bloc.equals(other.bloc))
            return false;
        if (ca == null) {
            if (other.ca != null)
                return false;
        } else if (!ca.equals(other.ca))
            return false;
        if (caN1 == null) {
            if (other.caN1 != null)
                return false;
        } else if (!caN1.equals(other.caN1))
            return false;
        if (categorie == null) {
            if (other.categorie != null)
                return false;
        } else if (!categorie.equals(other.categorie))
            return false;
        if (derMvt == null) {
            if (other.derMvt != null)
                return false;
        } else if (!derMvt.equals(other.derMvt))
            return false;
        if (id != other.id)
            return false;
        if (marge == null) {
            if (other.marge != null)
                return false;
        } else if (!marge.equals(other.marge))
            return false;
        if (mort == null) {
            if (other.mort != null)
                return false;
        } else if (!mort.equals(other.mort))
            return false;
        if (nbArt == null) {
            if (other.nbArt != null)
                return false;
        } else if (!nbArt.equals(other.nbArt))
            return false;
        if (objMax == null) {
            if (other.objMax != null)
                return false;
        } else if (!objMax.equals(other.objMax))
            return false;
        if (objMin == null) {
            if (other.objMin != null)
                return false;
        } else if (!objMin.equals(other.objMin))
            return false;
        if (prime == null) {
            if (other.prime != null)
                return false;
        } else if (!prime.equals(other.prime))
            return false;
        if (raison == null) {
            if (other.raison != null)
                return false;
        } else if (!raison.equals(other.raison))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prime [artSpec=" + artSpec + ", bloc=" + bloc + ", ca=" + ca + ", caN1=" + caN1 + ", categorie="
                + categorie + ", derMvt=" + derMvt + ", id=" + id + ", marge=" + marge
                + ", mort=" + mort + ", nbArt=" + nbArt + ", objMax=" + objMax + ", objMin=" + objMin + ", prime="
                + prime + ", raison=" + raison + "]";
    }

}
