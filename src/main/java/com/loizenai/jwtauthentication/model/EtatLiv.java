package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "etat_liv", schema = "testbd")
public class EtatLiv implements Serializable{

    @Id
    @Column(name = "id_etaliv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String region;

    @Basic
    @Column(name = "DATE")
    //@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Timestamp date;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONFIRMATION")
    private CONFIRMATION confirmation;
    public enum CONFIRMATION{
        recu_non_verifier,
        recu_est_verifier,
        n_est_pas_recu,
        un_problem_a_la_reception
    }
    //FK_KEYS***********************

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "NUM_BON_LIV", nullable = true)
    private BonLiv bonLiv;

    //END FK_KEYS************************
    public EtatLiv() {

    }
    public EtatLiv(long id, String region, Timestamp date, CONFIRMATION confirmation) {
        this.id = id;
        this.region = region;
        this.date = date;
        this.confirmation = confirmation;
    }

    public EtatLiv(String region, Timestamp date, CONFIRMATION confirmation) {
        this.region = region;
        this.date = date;
        this.confirmation = confirmation;
    }
    
    public EtatLiv(String region, Timestamp date, CONFIRMATION confirmation, BonLiv bonLiv) {
        this.region = region;
        this.date = date;
        this.confirmation = confirmation;
        this.bonLiv = bonLiv;
    }



    
    public EtatLiv(long id, String region, Timestamp date, CONFIRMATION confirmation, BonLiv bonLiv) {
        this.id = id;
        this.region = region;
        this.date = date;
        this.confirmation = confirmation;
        this.bonLiv = bonLiv;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public CONFIRMATION getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(CONFIRMATION confirmation) {
        this.confirmation = confirmation;
    }
    
    public BonLiv getBonLiv() {
        return bonLiv;
    }
    public void setBonLiv(BonLiv bonLiv) {
        this.bonLiv = bonLiv;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((confirmation == null) ? 0 : confirmation.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((region == null) ? 0 : region.hashCode());
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
        EtatLiv other = (EtatLiv) obj;
        if (confirmation != other.confirmation)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id != other.id)
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        return true;
    }

}
