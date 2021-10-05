package com.loizenai.jwtauthentication.model;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;

@Entity
@Table(name = "livreurs_expides", schema = "testbd")
public class Livreur_Expide implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livreur_expide")
    private long id_livreur_expide;



    @Column(name = "id_livreur")
    private long id_livreur;

    @Column(name = "id_expide")
    private long id_expide;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "NUM_BON_LIV", nullable = true)
    private BonLiv bonLiv;

    
    @Column(name = "MATRICULE")
    private String matricule;
    public Livreur_Expide() {
    }

    public Livreur_Expide(long id_livreur_expide, long id_livreur, long id_expide, BonLiv bonLiv,String matricule) {
        this.id_livreur_expide = id_livreur_expide;
        this.id_livreur = id_livreur;
        this.id_expide = id_expide;
        this.bonLiv = bonLiv;
        this.matricule = matricule;
    }

    public Livreur_Expide(long id_expide, BonLiv bonLiv) {
        this.id_expide = id_expide;
        this.bonLiv = bonLiv;
    }
    public long getId_Livreur_Expide() {
        return id_livreur_expide;
    }

    public void setId_Livreur_Expide(long id_livreur_expide) {
        this.id_livreur_expide = id_livreur_expide;
    }

    public long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(long id_livreur) {
        this.id_livreur = id_livreur;
    }

    public long getId_expide() {
        return id_expide;
    }

    public void setId_expide(long id_expide) {
        this.id_expide = id_expide;
    }

    public BonLiv getBonLiv() {
        return bonLiv;
    }

    public void setBonLiv(BonLiv bonLiv) {
        this.bonLiv = bonLiv;
    }
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bonLiv == null) ? 0 : bonLiv.hashCode());
        result = prime * result + (int) (id_livreur_expide ^ (id_livreur_expide >>> 32));
        result = prime * result + (int) (id_expide ^ (id_expide >>> 32));
        result = prime * result + (int) (id_livreur ^ (id_livreur >>> 32));
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
        Livreur_Expide other = (Livreur_Expide) obj;
        if (bonLiv == null) {
            if (other.bonLiv != null)
                return false;
        } else if (!bonLiv.equals(other.bonLiv))
            return false;
        if (id_livreur_expide != other.id_livreur_expide)
            return false;
        if (id_expide != other.id_expide)
            return false;
        if (id_livreur != other.id_livreur)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Livreur_Expide [bonLiv=" + bonLiv + ", matricule=" + matricule +", id_livreur_expide=" + id_livreur_expide + ", id_expide="
                + id_expide + ", id_livreur=" + id_livreur + "]";
    }
    
}
