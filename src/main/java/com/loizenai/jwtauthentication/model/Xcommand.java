package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Xcommand implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_COM")
    private long numCom;
    
    private String raison;
    private Timestamp datCom;
    private String liv;
    private String typCom;
    private String traite;

    //FK_KEYS***********************

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "NUM_BON_LIV", nullable = true)
    private BonLiv bonliv_xcommand;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "codFrs", nullable = true)
    private Fournis fournis;

    //END FK_KEYS************************

    public Xcommand(long numCom, String raison, Timestamp datCom, String liv, String typCom, String traite,
            BonLiv bonliv_xcommand, User user, Fournis fournis) {
        this.numCom = numCom;
        this.raison = raison;
        this.datCom = datCom;
        this.liv = liv;
        this.typCom = typCom;
        this.traite = traite;
        this.bonliv_xcommand = bonliv_xcommand;
        this.user = user;
        this.fournis = fournis;
    }

    public Xcommand() {
    }

    public long getNumCom() {
        return numCom;
    }

    public void setNumCom(long numCom) {
        this.numCom = numCom;
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
    @Column(name = "DAT_COM")
    public Timestamp getDatCom() {
        return datCom;
    }

    public void setDatCom(Timestamp datCom) {
        this.datCom = datCom;
    }

    @Basic
    @Column(name = "LIV")
    public String getLiv() {
        return liv;
    }

    public void setLiv(String liv) {
        this.liv = liv;
    }

    @Basic
    @Column(name = "TYP_COM")
    public String getTypCom() {
        return typCom;
    }

    public void setTypCom(String typCom) {
        this.typCom = typCom;
    }

    @Basic
    @Column(name = "TRAITE")
    public String getTraite() {
        return traite;
    }

    public void setTraite(String traite) {
        this.traite = traite;
    }

    public void setBonliv_xcommand(BonLiv bonliv_xcommand) {
        this.bonliv_xcommand = bonliv_xcommand;
    }

 
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fournis getFournis() {
        return fournis;
    }

    public void setFournis(Fournis fournis) {
        this.fournis = fournis;
    }
/*
    public List<BonSort> getBonsorts() {
        return bonsorts;
    }

    public void setBonsorts(List<BonSort> bonsorts) {
        this.bonsorts = bonsorts;
    }
*/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bonliv_xcommand == null) ? 0 : bonliv_xcommand.hashCode()); 
        result = prime * result + ((datCom == null) ? 0 : datCom.hashCode());
        result = prime * result + ((liv == null) ? 0 : liv.hashCode());
        result = prime * result + (int) (numCom ^ (numCom >>> 32));
        result = prime * result + ((raison == null) ? 0 : raison.hashCode());
        result = prime * result + ((traite == null) ? 0 : traite.hashCode());
        result = prime * result + ((typCom == null) ? 0 : typCom.hashCode());
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
        Xcommand other = (Xcommand) obj;
        if (bonliv_xcommand == null) {
            if (other.bonliv_xcommand != null)
                return false;
        } else if (!bonliv_xcommand.equals(other.bonliv_xcommand))
            return false;
        if (datCom == null) {
            if (other.datCom != null)
                return false;
        } else if (!datCom.equals(other.datCom))
            return false;
        if (liv == null) {
            if (other.liv != null)
                return false;
        } else if (!liv.equals(other.liv))
            return false;
        if (numCom != other.numCom)
            return false;
        if (raison == null) {
            if (other.raison != null)
                return false;
        } else if (!raison.equals(other.raison))
            return false;
        if (traite == null) {
            if (other.traite != null)
                return false;
        } else if (!traite.equals(other.traite))
            return false;
        if (typCom == null) {
            if (other.typCom != null)
                return false;
        } else if (!typCom.equals(other.typCom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Xcommand [bonliv_xcommand=" + bonliv_xcommand + ", user=" + user + ", datCom=" + datCom + ", liv=" + liv + ", numCom=" + numCom
                + ", raison=" + raison + ", traite=" + traite + ", typCom=" + typCom + "]";
    }

}
