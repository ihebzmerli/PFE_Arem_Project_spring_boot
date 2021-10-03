package com.loizenai.jwtauthentication.model;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Table(name = "livreurs_primes", schema = "testbd")
public class livreurs_primes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livreur_prime")
    private long id_livreur_prime;



    @Column(name = "id_livreur")
    private long id_livreur;

    @Column(name = "id_prime")
    private long id_prime;

    public livreurs_primes() {
    }

    public livreurs_primes(long id_livreur_prime, long id_livreur, long id_prime) {
        this.id_livreur_prime = id_livreur_prime;
        this.id_livreur = id_livreur;
        this.id_prime = id_prime;
    }

    public long getId_livreur_prime() {
        return id_livreur_prime;
    }

    public void setId_livreur_prime(long id_livreur_prime) {
        this.id_livreur_prime = id_livreur_prime;
    }

    public long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(long id_livreur) {
        this.id_livreur = id_livreur;
    }

    public long getId_prime() {
        return id_prime;
    }

    public void setId_prime(long id_prime) {
        this.id_prime = id_prime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id_livreur ^ (id_livreur >>> 32));
        result = prime * result + (int) (id_livreur_prime ^ (id_livreur_prime >>> 32));
        result = prime * result + (int) (id_prime ^ (id_prime >>> 32));
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
        livreurs_primes other = (livreurs_primes) obj;
        if (id_livreur != other.id_livreur)
            return false;
        if (id_livreur_prime != other.id_livreur_prime)
            return false;
        if (id_prime != other.id_prime)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "livreurs_primes [id_livreur=" + id_livreur + ", id_livreur_prime=" + id_livreur_prime + ", id_prime="
                + id_prime + "]";
    }
    
}
