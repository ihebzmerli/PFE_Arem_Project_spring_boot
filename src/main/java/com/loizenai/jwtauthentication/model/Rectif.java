package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rectif", schema = "testbd")
public class Rectif implements Serializable{

    @Id
    @Column(name = "id_rectif")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rectif;
    
    //FK_KEYS***********************
   
        @OneToOne(fetch = FetchType.EAGER, optional = true)
        @JoinColumn(name = "numDoc", nullable = true)
        private Achats achats;
    
    //END FK_KEYS***********************  
    private Timestamp date;
    private String observ;
    private String typMvt;
    private int numRec;
    private Timestamp datReclam;
    private Boolean reclam;
    private Boolean cloture;
    private String obsReclam;
    private Timestamp datRepon;
    private Timestamp datClotur;
    
 

    public Rectif() {

    }
    public Rectif(Timestamp date, String observ, String typMvt, int numRec, Timestamp datReclam, Boolean reclam, Boolean cloture, String obsReclam, Timestamp datRepon, Timestamp datClotur) {
        this.date = date;
        this.observ = observ;
        this.typMvt = typMvt;
        this.numRec = numRec;
        this.datReclam = datReclam;
        this.reclam = reclam;
        this.cloture = cloture;
        this.obsReclam = obsReclam;
        this.datRepon = datRepon;
        this.datClotur = datClotur;
    }




    
    public Rectif(long id_rectif, Achats achats, Timestamp date, String observ, String typMvt, int numRec,
            Timestamp datReclam, Boolean reclam, Boolean cloture, String obsReclam, Timestamp datRepon,
            Timestamp datClotur) {
        this.id_rectif = id_rectif;
        this.achats = achats;
        this.date = date;
        this.observ = observ;
        this.typMvt = typMvt;
        this.numRec = numRec;
        this.datReclam = datReclam;
        this.reclam = reclam;
        this.cloture = cloture;
        this.obsReclam = obsReclam;
        this.datRepon = datRepon;
        this.datClotur = datClotur;
    }
    public long getId_rectif() {
        return id_rectif;
    }

    public void setId_rectif(long id_rectif) {
        this.id_rectif = id_rectif;
    }

    @Basic
    @Column(name = "DATE")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "TYP_MVT")
    public String getTypMvt() {
        return typMvt;
    }

    public void setTypMvt(String typMvt) {
        this.typMvt = typMvt;
    }

    @Column(name = "NUM_REC")
    public int getNumRec() {
        return numRec;
    }

    public void setNumRec(int numRec) {
        this.numRec = numRec;
    }

    @Basic
    @Column(name = "DAT_RECLAM")
    public Timestamp getDatReclam() {
        return datReclam;
    }

    public void setDatReclam(Timestamp datReclam) {
        this.datReclam = datReclam;
    }

    @Basic
    @Column(name = "RECLAM")
    public Boolean getReclam() {
        return reclam;
    }

    public void setReclam(Boolean reclam) {
        this.reclam = reclam;
    }

    @Basic
    @Column(name = "CLOTURE")
    public Boolean getCloture() {
        return cloture;
    }

    public void setCloture(Boolean cloture) {
        this.cloture = cloture;
    }

    @Basic
    @Column(name = "OBS_RECLAM")
    public String getObsReclam() {
        return obsReclam;
    }

    public void setObsReclam(String obsReclam) {
        this.obsReclam = obsReclam;
    }

    @Basic
    @Column(name = "DAT_REPON")
    public Timestamp getDatRepon() {
        return datRepon;
    }

    public void setDatRepon(Timestamp datRepon) {
        this.datRepon = datRepon;
    }

    @Basic
    @Column(name = "DAT_CLOTUR")
    public Timestamp getDatClotur() {
        return datClotur;
    }

    public void setDatClotur(Timestamp datClotur) {
        this.datClotur = datClotur;
    }
    public Achats getAchats() {
        return achats;
    }
    public void setAchats(Achats achats) {
        this.achats = achats;
    }

    @Override
    public String toString() {
        return "Rectif{" +
                "id_rectif=" + id_rectif +
                ", date=" + date +
                ", observ='" + observ + '\'' +
                ", typMvt='" + typMvt + '\'' +
                ", numRec=" + numRec +
                ", datReclam=" + datReclam +
                ", reclam=" + reclam +
                ", cloture=" + cloture +
                ", obsReclam='" + obsReclam + '\'' +
                ", datRepon=" + datRepon +
                ", datClotur=" + datClotur +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cloture == null) ? 0 : cloture.hashCode());
        result = prime * result + ((datClotur == null) ? 0 : datClotur.hashCode());
        result = prime * result + ((datReclam == null) ? 0 : datReclam.hashCode());
        result = prime * result + ((datRepon == null) ? 0 : datRepon.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + (int) (id_rectif ^ (id_rectif >>> 32));
        result = prime * result + numRec;
        result = prime * result + ((obsReclam == null) ? 0 : obsReclam.hashCode());
        result = prime * result + ((observ == null) ? 0 : observ.hashCode());
        result = prime * result + ((reclam == null) ? 0 : reclam.hashCode());
        result = prime * result + ((typMvt == null) ? 0 : typMvt.hashCode());
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
        Rectif other = (Rectif) obj;
        if (cloture == null) {
            if (other.cloture != null)
                return false;
        } else if (!cloture.equals(other.cloture))
            return false;
        if (datClotur == null) {
            if (other.datClotur != null)
                return false;
        } else if (!datClotur.equals(other.datClotur))
            return false;
        if (datReclam == null) {
            if (other.datReclam != null)
                return false;
        } else if (!datReclam.equals(other.datReclam))
            return false;
        if (datRepon == null) {
            if (other.datRepon != null)
                return false;
        } else if (!datRepon.equals(other.datRepon))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (numRec != other.numRec)
            return false;
        if (obsReclam == null) {
            if (other.obsReclam != null)
                return false;
        } else if (!obsReclam.equals(other.obsReclam))
            return false;
        if (observ == null) {
            if (other.observ != null)
                return false;
        } else if (!observ.equals(other.observ))
            return false;
        if (reclam == null) {
            if (other.reclam != null)
                return false;
        } else if (!reclam.equals(other.reclam))
            return false;
        if (typMvt == null) {
            if (other.typMvt != null)
                return false;
        } else if (!typMvt.equals(other.typMvt))
            return false;
        return true;
    }

}
