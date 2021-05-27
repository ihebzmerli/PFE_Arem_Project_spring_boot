package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "livreur", schema = "seratest")
public class Livreur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livreur")
    private long id_livreur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "num_rec")
    private long numrec;

    @Column(name = "centre")
    private String centre;

    @Column(name ="dat_reclam")
    private Timestamp datreclam;

    @Column(name ="dat_repon")
    private Timestamp datrepon;

    @Column(name ="date")
    private Timestamp date;

    @Column(name ="OBJECTIF")
    private long objectif;


    @Column(name ="obs_reclam")
    private String obsreclam;

    @Column(name ="observ")
    private String observ;

    @Column(name ="prix_ach")
    private long prixach;

    @Column(name ="qut_art")
    private long qutart;

    @Column(name ="reclam")
    private long reclam;

    @Column(name ="typ_mvt")
    private String typmvt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "NATURE")
    private NATURE nature;
    public enum NATURE{
        EN_ATTEND,
        EN_MISSION,
        PAS_PRESENT
    }
    
    //FK_KEYS***********************
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_prime", nullable = true)
    private Prime prime;   

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "livreurs_expides",
            joinColumns = {
                    @JoinColumn(name = "id_livreur", referencedColumnName = "id_livreur",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_expide", referencedColumnName = "id_expide",
                            nullable = true, updatable = false)})
    private List<Expide> expides;   


    @OneToMany(mappedBy = "livreur", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<BonLiv> bonLivs;
    //END FK_KEYS***********************  

    public Livreur() {

    }
    
        public Livreur(String nom, long numrec,Timestamp datreclam, String centre,Timestamp datrepon, Timestamp date, String obsreclam, String observ, long prixach,
        long qutart, long reclam, String typmvt) {
    this.nom = nom;
    this.numrec = numrec;
    this.centre = centre;
    this.datreclam = datreclam;
    this.datrepon = datrepon;
    this.date = date;
    this.obsreclam = obsreclam;
    this.observ = observ;
    this.prixach = prixach;
    this.qutart = qutart;
    this.reclam = reclam;
    this.typmvt = typmvt;
    }

    
    public Livreur(long id_livreur, String nom, long numrec, String centre, Timestamp datreclam, Timestamp datrepon,
                Timestamp date, long objectif, String obsreclam, String observ, long prixach, long qutart, long reclam,
                String typmvt, NATURE nature, Prime prime, List<Expide> expides, List<BonLiv> bonLivs) {
            this.id_livreur = id_livreur;
            this.nom = nom;
            this.numrec = numrec;
            this.centre = centre;
            this.datreclam = datreclam;
            this.datrepon = datrepon;
            this.date = date;
            this.objectif = objectif;
            this.obsreclam = obsreclam;
            this.observ = observ;
            this.prixach = prixach;
            this.qutart = qutart;
            this.reclam = reclam;
            this.typmvt = typmvt;
            this.nature = nature;
            this.prime = prime;
            this.expides = expides;
            this.bonLivs = bonLivs;
        }

    public long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(long id_livreur) {
        this.id_livreur = id_livreur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNumrec() {
        return numrec;
    }

    public void setNumrec(long numrec) {
        this.numrec = numrec;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public Timestamp getDatreclam() {
        return datreclam;
    }

    public void setDatreclam(Timestamp datreclam) {
        this.datreclam = datreclam;
    }

    public Timestamp getDatrepon() {
        return datrepon;
    }

    public void setDatrepon(Timestamp datrepon) {
        this.datrepon = datrepon;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public String getObsreclam() {
        return obsreclam;
    }

    public void setObsreclam(String obsreclam) {
        this.obsreclam = obsreclam;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public long getPrixach() {
        return prixach;
    }

    public void setPrixach(long prixach) {
        this.prixach = prixach;
    }

    public long getQutart() {
        return qutart;
    }

    public void setQutart(long qutart) {
        this.qutart = qutart;
    }

    public long getReclam() {
        return reclam;
    }

    public void setReclam(long reclam) {
        this.reclam = reclam;
    }

    public String getTypmvt() {
        return typmvt;
    }

    public void setTypmvt(String typmvt) {
        this.typmvt = typmvt;
    }

    public NATURE getNature() {
        return nature;
    }

    public void setNature(NATURE nature) {
        this.nature = nature;
    }

    public Prime getPrime() {
        return prime;
    }

    public void setPrime(Prime prime) {
        this.prime = prime;
    }

    public long getObjectif() {
        return objectif;
    }

    public void setObjectif(long objectif) {
        this.objectif = objectif;
    }
/**FK_key debut 
/**end FK_KEY */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((datreclam == null) ? 0 : datreclam.hashCode());
        result = prime * result + ((datrepon == null) ? 0 : datrepon.hashCode());
        result = prime * result + (int) (id_livreur ^ (id_livreur >>> 32));
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + (int) (numrec ^ (numrec >>> 32));
        result = prime * result + ((observ == null) ? 0 : observ.hashCode());
        result = prime * result + ((obsreclam == null) ? 0 : obsreclam.hashCode());
        result = prime * result + (int) (prixach ^ (prixach >>> 32));
        result = prime * result + (int) (qutart ^ (qutart >>> 32));
        result = prime * result + (int) (reclam ^ (reclam >>> 32));
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
        Livreur other = (Livreur) obj;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (datreclam == null) {
            if (other.datreclam != null)
                return false;
        } else if (!datreclam.equals(other.datreclam))
            return false;
        if (datrepon == null) {
            if (other.datrepon != null)
                return false;
        } else if (!datrepon.equals(other.datrepon))
            return false;
        if (id_livreur != other.id_livreur)
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (observ == null) {
            if (other.observ != null)
                return false;
        } else if (!observ.equals(other.observ))
            return false;
        if (obsreclam == null) {
            if (other.obsreclam != null)
                return false;
        } else if (!obsreclam.equals(other.obsreclam))
            return false;
        if (prixach != other.prixach)
            return false;
        if (qutart != other.qutart)
            return false;
        if (reclam != other.reclam)
            return false;
        if (typmvt != other.typmvt)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Livreur [centre=" + centre + ", date=" + date + ", datreclam=" + datreclam + ", datrepon=" + datrepon
                + ", id_livreur=" + id_livreur + ", nom=" + nom + ", numrec=" + numrec + ", observ=" + observ
                + ", obsreclam=" + obsreclam + ", prixach=" + prixach + ", qutart=" + qutart
                + ", reclam=" + reclam + ", typmvt=" + typmvt + ", nature=" + nature +"]";
    }

}
