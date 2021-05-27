package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Agent {
    private long id;
    private long matAgent;
    private String nom;
    private Date datRec;
    private String observation;



    public Agent() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "MAT_AGENT")
    public long getMatAgent() {
        return matAgent;
    }

    public void setMatAgent(long matAgent) {
        this.matAgent = matAgent;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "DAT_REC")
    public Date getDatRec() {
        return datRec;
    }

    public void setDatRec(Date datRec) {
        this.datRec = datRec;
    }

    @Basic
    @Column(name = "OBSERVATION")
    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return id == agent.id &&
                matAgent == agent.matAgent &&
                Objects.equals(nom, agent.nom) &&
                Objects.equals(datRec, agent.datRec) &&
                Objects.equals(observation, agent.observation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matAgent, nom, datRec, observation);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", matAgent=" + matAgent +
                ", nom='" + nom + '\'' +
                ", datRec=" + datRec +
                ", observation='" + observation + '\'' +
                '}';
    }
}
