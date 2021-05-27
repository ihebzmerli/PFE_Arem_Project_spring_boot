package com.loizenai.jwtauthentication.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Chariot implements Serializable{

    @Id
    @Column(name = "NUM_CHAR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numChar;
    
    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CHARIOT")
    @LastModifiedDate
    private Timestamp datchariot;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CALL_CHARIOT")
    @LastModifiedDate
    private Timestamp callChariot;

    //FK_KEYS***********************
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "chariots_Users",
            joinColumns = {
                    @JoinColumn(name = "NUM_CHAR", referencedColumnName = "NUM_CHAR",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id", referencedColumnName = "id",
                            nullable = true, updatable = false)})
    private List<User> Users;   

    
    @OneToMany(mappedBy = "artprep_chariot", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<ArtPrep> artPreps;

    @OneToMany(mappedBy = "chariot_artsort", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<ArtSort> artSorts;
/*
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_prep", nullable = true)
    private DetPrep detprep_chariot;
*/    
    //END FK_KEYS************************
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT_CHAR")
    private ETAT_CHAR etat_char;
    public enum ETAT_CHAR{
        en_panne,
        occuper,
        en_attente
    }


    public Chariot(long numChar, Timestamp datchariot, Timestamp callChariot, List<User> Users,
            List<ArtPrep> artPreps, List<ArtSort> artSorts, ETAT_CHAR etat_char) {
        this.numChar = numChar;
        this.datchariot = datchariot;
        this.callChariot = callChariot;
        this.Users = Users;
        this.artPreps = artPreps;
        this.artSorts = artSorts;
        this.etat_char = etat_char;
    }

    public Chariot() {

    }

    public long getNumChar() {
        return numChar;
    }

    public void setNumChar(long numChar) {
        this.numChar = numChar;
    }

    public Timestamp getCallChariot() {
        return callChariot;
    }

    public void setCallChariot(Timestamp callChariot) {
        this.callChariot = callChariot;
    }    

    public void setBonSorts(List<ArtSort> artSorts) {
        this.artSorts = artSorts;
    }

    public ETAT_CHAR getEtat_char() {
        return etat_char;
    }

    public void setEtat_char(ETAT_CHAR etat_char) {
        this.etat_char = etat_char;
    }

    public void setChariots(List<ArtPrep> artPreps) {
        this.artPreps = artPreps;
    }
    
    public Timestamp getDatchariot() {
        return datchariot;
    }

    public void setDatchariot(Timestamp datchariot) {
        this.datchariot = datchariot;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((callChariot == null) ? 0 : callChariot.hashCode());
        result = prime * result + (int) (numChar ^ (numChar >>> 32));
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
        Chariot other = (Chariot) obj;
        if (callChariot == null) {
            if (other.callChariot != null)
                return false;
        } else if (!callChariot.equals(other.callChariot))
            return false;
        if (numChar != other.numChar)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Chariot [callChariot=" + callChariot + ", numChar=" + numChar
                + "]";
    }



}
