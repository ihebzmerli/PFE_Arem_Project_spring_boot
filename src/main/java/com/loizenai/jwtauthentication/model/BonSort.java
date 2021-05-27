package com.loizenai.jwtauthentication.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bon_sort", schema = "testbd")
public class BonSort implements Serializable{

    @Id
    @Column(name = "NUM_BON_SORT")
    private String numBon;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_BON")
    @LastModifiedDate
    private Timestamp datBon;

    //FK_KEYS***********************
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bonSorts_articles",
            joinColumns = {
                    @JoinColumn(name = "NUM_BON_SORT", referencedColumnName = "NUM_BON_SORT",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "COD_ART", referencedColumnName = "COD_ART",
                            nullable = true, updatable = false)})
    private List<Article> articles;   

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User user;


    
    //END FK_KEYS************************
    private String raison;
    private BigDecimal brutHt;
    private BigDecimal tauxRem;
    private BigDecimal montRem;
    private BigDecimal netHt;
    private BigDecimal montTva;
    private BigDecimal totTtc;
    private String poste;
    private BigDecimal xbase1;
    private BigDecimal xbase2;
    private BigDecimal xbase3;
    private BigDecimal xbase4;
    private BigDecimal xbase5;
    private BigDecimal xtva1;
    private BigDecimal xtva2;
    private BigDecimal xtva3;
    private BigDecimal xtva4;
    private String centre;
    private String observ;
    private String vehicule;

    public BonSort(Timestamp datBon, String raison, BigDecimal brutHt, BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva, BigDecimal totTtc, BigDecimal xbase1, BigDecimal xbase2, BigDecimal xbase3, BigDecimal xbase4, BigDecimal xbase5, BigDecimal xtva1, BigDecimal xtva2, BigDecimal xtva3, BigDecimal xtva4, String centre, String observ, String vehicule) {
        this.datBon = datBon;
        this.raison = raison;
        this.brutHt = brutHt;
        this.tauxRem = tauxRem;
        this.montRem = montRem;
        this.netHt = netHt;
        this.montTva = montTva;
        this.totTtc = totTtc;
        this.xbase1 = xbase1;
        this.xbase2 = xbase2;
        this.xbase3 = xbase3;
        this.xbase4 = xbase4;
        this.xbase5 = xbase5;
        this.xtva1 = xtva1;
        this.xtva2 = xtva2;
        this.xtva3 = xtva3;
        this.xtva4 = xtva4;
        this.centre = centre;
        this.observ = observ;
        this.vehicule = vehicule;
    }

    public BonSort(String numBon, Timestamp datBon, List<Article> articles, User user, String raison,
            BigDecimal brutHt, BigDecimal tauxRem, BigDecimal montRem, BigDecimal netHt, BigDecimal montTva,
            BigDecimal totTtc, String poste, BigDecimal xbase1, BigDecimal xbase2, BigDecimal xbase3, BigDecimal xbase4,
            BigDecimal xbase5, BigDecimal xtva1, BigDecimal xtva2, BigDecimal xtva3, BigDecimal xtva4, String centre,
            String observ, String vehicule) {
        this.numBon = numBon;
        this.datBon = datBon;
        this.articles = articles;
        this.user = user;
        this.raison = raison;
        this.brutHt = brutHt;
        this.tauxRem = tauxRem;
        this.montRem = montRem;
        this.netHt = netHt;
        this.montTva = montTva;
        this.totTtc = totTtc;
        this.poste = poste;
        this.xbase1 = xbase1;
        this.xbase2 = xbase2;
        this.xbase3 = xbase3;
        this.xbase4 = xbase4;
        this.xbase5 = xbase5;
        this.xtva1 = xtva1;
        this.xtva2 = xtva2;
        this.xtva3 = xtva3;
        this.xtva4 = xtva4;
        this.centre = centre;
        this.observ = observ;
        this.vehicule = vehicule;
    }

    public BonSort() {

    }

    public String getNumBon() {
        return numBon;
    }

    public void setNumBon(String numBon) {
        this.numBon = numBon;
    }

    @Basic
    @Column(name = "DAT_BON")
    public Timestamp getDatBon() {
        return datBon;
    }

    public void setDatBon(Timestamp datBon) {
        this.datBon = datBon;
    }

 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "BRUT_HT")
    public BigDecimal getBrutHt() {
        return brutHt;
    }

    public void setBrutHt(BigDecimal brutHt) {
        this.brutHt = brutHt;
    }

    @Basic
    @Column(name = "TAUX_REM")
    public BigDecimal getTauxRem() {
        return tauxRem;
    }

    public void setTauxRem(BigDecimal tauxRem) {
        this.tauxRem = tauxRem;
    }

    @Basic
    @Column(name = "MONT_REM")
    public BigDecimal getMontRem() {
        return montRem;
    }

    public void setMontRem(BigDecimal montRem) {
        this.montRem = montRem;
    }

    @Basic
    @Column(name = "NET_HT")
    public BigDecimal getNetHt() {
        return netHt;
    }

    public void setNetHt(BigDecimal netHt) {
        this.netHt = netHt;
    }

    @Basic
    @Column(name = "MONT_TVA")
    public BigDecimal getMontTva() {
        return montTva;
    }

    public void setMontTva(BigDecimal montTva) {
        this.montTva = montTva;
    }

    @Basic
    @Column(name = "TOT_TTC")
    public BigDecimal getTotTtc() {
        return totTtc;
    }

    public void setTotTtc(BigDecimal totTtc) {
        this.totTtc = totTtc;
    }
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Basic
    @Column(name = "XBASE1")
    public BigDecimal getXbase1() {
        return xbase1;
    }

    public void setXbase1(BigDecimal xbase1) {
        this.xbase1 = xbase1;
    }

    @Basic
    @Column(name = "XBASE2")
    public BigDecimal getXbase2() {
        return xbase2;
    }

    public void setXbase2(BigDecimal xbase2) {
        this.xbase2 = xbase2;
    }

    @Basic
    @Column(name = "XBASE3")
    public BigDecimal getXbase3() {
        return xbase3;
    }

    public void setXbase3(BigDecimal xbase3) {
        this.xbase3 = xbase3;
    }

    @Basic
    @Column(name = "XBASE4")
    public BigDecimal getXbase4() {
        return xbase4;
    }

    public void setXbase4(BigDecimal xbase4) {
        this.xbase4 = xbase4;
    }

    @Basic
    @Column(name = "XBASE5")
    public BigDecimal getXbase5() {
        return xbase5;
    }

    public void setXbase5(BigDecimal xbase5) {
        this.xbase5 = xbase5;
    }

    @Basic
    @Column(name = "XTVA1")
    public BigDecimal getXtva1() {
        return xtva1;
    }

    public void setXtva1(BigDecimal xtva1) {
        this.xtva1 = xtva1;
    }

    @Basic
    @Column(name = "XTVA2")
    public BigDecimal getXtva2() {
        return xtva2;
    }

    public void setXtva2(BigDecimal xtva2) {
        this.xtva2 = xtva2;
    }

    @Basic
    @Column(name = "XTVA3")
    public BigDecimal getXtva3() {
        return xtva3;
    }

    public void setXtva3(BigDecimal xtva3) {
        this.xtva3 = xtva3;
    }

    @Basic
    @Column(name = "XTVA4")
    public BigDecimal getXtva4() {
        return xtva4;
    }

    public void setXtva4(BigDecimal xtva4) {
        this.xtva4 = xtva4;
    }

    @Basic
    @Column(name = "CENTRE")
    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    @Basic
    @Column(name = "OBSERV")
    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    @Basic
    @Column(name = "VEHICULE")
    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brutHt == null) ? 0 : brutHt.hashCode());
        result = prime * result + ((centre == null) ? 0 : centre.hashCode()); 
        result = prime * result + ((datBon == null) ? 0 : datBon.hashCode());
        result = prime * result + ((montRem == null) ? 0 : montRem.hashCode());
        result = prime * result + ((montTva == null) ? 0 : montTva.hashCode());
        result = prime * result + ((netHt == null) ? 0 : netHt.hashCode());
        result = prime * result + ((numBon == null) ? 0 : numBon.hashCode());
        result = prime * result + ((observ == null) ? 0 : observ.hashCode());
        result = prime * result + ((raison == null) ? 0 : raison.hashCode());
        result = prime * result + ((tauxRem == null) ? 0 : tauxRem.hashCode());
        result = prime * result + ((totTtc == null) ? 0 : totTtc.hashCode());
        result = prime * result + ((vehicule == null) ? 0 : vehicule.hashCode());
        result = prime * result + ((xbase1 == null) ? 0 : xbase1.hashCode());
        result = prime * result + ((xbase2 == null) ? 0 : xbase2.hashCode());
        result = prime * result + ((xbase3 == null) ? 0 : xbase3.hashCode());
        result = prime * result + ((xbase4 == null) ? 0 : xbase4.hashCode());
        result = prime * result + ((xbase5 == null) ? 0 : xbase5.hashCode());
        result = prime * result + ((xtva1 == null) ? 0 : xtva1.hashCode());
        result = prime * result + ((xtva2 == null) ? 0 : xtva2.hashCode());
        result = prime * result + ((xtva3 == null) ? 0 : xtva3.hashCode());
        result = prime * result + ((xtva4 == null) ? 0 : xtva4.hashCode());
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
        BonSort other = (BonSort) obj;
        if (brutHt == null) {
            if (other.brutHt != null)
                return false;
        } else if (!brutHt.equals(other.brutHt))
            return false;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (datBon == null) {
            if (other.datBon != null)
                return false;
        } else if (!datBon.equals(other.datBon))
            return false;
        if (montRem == null) {
            if (other.montRem != null)
                return false;
        } else if (!montRem.equals(other.montRem))
            return false;
        if (montTva == null) {
            if (other.montTva != null)
                return false;
        } else if (!montTva.equals(other.montTva))
            return false;
        if (netHt == null) {
            if (other.netHt != null)
                return false;
        } else if (!netHt.equals(other.netHt))
            return false;
        if (numBon == null) {
            if (other.numBon != null)
                return false;
        } else if (!numBon.equals(other.numBon))
            return false;
        if (observ == null) {
            if (other.observ != null)
                return false;
        } else if (!observ.equals(other.observ))
            return false;
        if (raison == null) {
            if (other.raison != null)
                return false;
        } else if (!raison.equals(other.raison))
            return false;
        if (tauxRem == null) {
            if (other.tauxRem != null)
                return false;
        } else if (!tauxRem.equals(other.tauxRem))
            return false;
        if (totTtc == null) {
            if (other.totTtc != null)
                return false;
        } else if (!totTtc.equals(other.totTtc))
            return false;
        if (vehicule == null) {
            if (other.vehicule != null)
                return false;
        } else if (!vehicule.equals(other.vehicule))
            return false;
        if (xbase1 == null) {
            if (other.xbase1 != null)
                return false;
        } else if (!xbase1.equals(other.xbase1))
            return false;
        if (xbase2 == null) {
            if (other.xbase2 != null)
                return false;
        } else if (!xbase2.equals(other.xbase2))
            return false;
        if (xbase3 == null) {
            if (other.xbase3 != null)
                return false;
        } else if (!xbase3.equals(other.xbase3))
            return false;
        if (xbase4 == null) {
            if (other.xbase4 != null)
                return false;
        } else if (!xbase4.equals(other.xbase4))
            return false;
        if (xbase5 == null) {
            if (other.xbase5 != null)
                return false;
        } else if (!xbase5.equals(other.xbase5))
            return false;
        if (xtva1 == null) {
            if (other.xtva1 != null)
                return false;
        } else if (!xtva1.equals(other.xtva1))
            return false;
        if (xtva2 == null) {
            if (other.xtva2 != null)
                return false;
        } else if (!xtva2.equals(other.xtva2))
            return false;
        if (xtva3 == null) {
            if (other.xtva3 != null)
                return false;
        } else if (!xtva3.equals(other.xtva3))
            return false;
        if (xtva4 == null) {
            if (other.xtva4 != null)
                return false;
        } else if (!xtva4.equals(other.xtva4))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BonSort [brutHt=" + brutHt + ", centre=" + centre + ", datBon=" + datBon + ", montRem=" + montRem + ", montTva=" + montTva
                + ", netHt=" + netHt + ", numBon=" + numBon + ", observ=" + observ + ", raison="
                + raison + ", tauxRem=" + tauxRem + ", totTtc=" + totTtc + ", vehicule=" + vehicule + ", xbase1="
                + xbase1 + ", xbase2=" + xbase2 + ", xbase3=" + xbase3 + ", xbase4=" + xbase4 + ", xbase5=" + xbase5
                + ", xtva1=" + xtva1 + ", xtva2=" + xtva2 + ", xtva3="
                + xtva3 + ", xtva4=" + xtva4 + "]";
    }

}
