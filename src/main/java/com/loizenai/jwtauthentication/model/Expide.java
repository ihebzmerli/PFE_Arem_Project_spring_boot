package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "expide", schema = "testbd")
public class Expide implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expide")
    private long id;

    @LastModifiedDate
    @Column(name = "DATE_EXPEDITION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datExpedition;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYP_EXP")
    private TYPEXP typExp;
    public enum TYPEXP{
        livraison_voiture,
        sur_comptoir
    }

    private String transp;
    private Long matAgent;
    private String typeDoc;
    //FK_KEYS***********************
    
    @ManyToMany(mappedBy = "expides", fetch = FetchType.LAZY)
    private List<Livreur> livreurs;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User user;

    //END FK_KEYS************************

    public Expide(Date datExpedition, TYPEXP typExp, String transp, Long matAgent, String typeDoc, User user) {
        this.datExpedition = datExpedition;
        this.user = user;
        this.typExp = typExp;
        this.transp = transp;
        this.matAgent = matAgent;
        this.typeDoc = typeDoc;
    }

    public Expide() {

    }


    public Expide(long id, Date datExpedition, TYPEXP typExp, String transp, Long matAgent, String typeDoc,
            List<Livreur> livreurs, User user) {
        this.id = id;
        this.datExpedition = datExpedition;
        this.typExp = typExp;
        this.transp = transp;
        this.matAgent = matAgent;
        this.typeDoc = typeDoc;
        this.livreurs = livreurs;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatExpedition() {
        return datExpedition;
    }

    public void setDatExpedition(Date datExpedition) {
        this.datExpedition = datExpedition;
    }

    @Basic
    @Column(name = "TYP_EXP")
    public TYPEXP getTypExp() {
        return typExp;
    }

    public void setTypExp(TYPEXP typExp) {
        this.typExp = typExp;
    }

    @Basic
    @Column(name = "TRANSP")
    public String getTransp() {
        return transp;
    }

    public void setTransp(String transp) {
        this.transp = transp;
    }

    @Basic
    @Column(name = "MAT_AGENT")
    public Long getMatAgent() {
        return matAgent;
    }

    public void setMatAgent(Long matAgent) {
        this.matAgent = matAgent;
    }

    @Basic
    @Column(name = "TYPE_DOC")
    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }
    
    public List<Livreur> getLivreurs() {
        return livreurs;
    }

    public void setLivreurs(List<Livreur> livreurs) {
        this.livreurs = livreurs;
    }
 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datExpedition == null) ? 0 : datExpedition.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((matAgent == null) ? 0 : matAgent.hashCode());
        result = prime * result + ((transp == null) ? 0 : transp.hashCode());
        result = prime * result + ((typExp == null) ? 0 : typExp.hashCode());
        result = prime * result + ((typeDoc == null) ? 0 : typeDoc.hashCode());
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
        Expide other = (Expide) obj;
        if (datExpedition == null) {
            if (other.datExpedition != null)
                return false;
        } else if (!datExpedition.equals(other.datExpedition))
            return false;
        if (id != other.id)
            return false;
        if (matAgent == null) {
            if (other.matAgent != null)
                return false;
        } else if (!matAgent.equals(other.matAgent))
            return false;
        if (transp == null) {
            if (other.transp != null)
                return false;
        } else if (!transp.equals(other.transp))
            return false;
        if (typExp == null) {
            if (other.typExp != null)
                return false;
        } else if (!typExp.equals(other.typExp))
            return false;
        if (typeDoc == null) {
            if (other.typeDoc != null)
                return false;
        } else if (!typeDoc.equals(other.typeDoc))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Expide [datExpedition=" + datExpedition
                + ", id_expide=" + id + ", matAgent=" + matAgent + ", transp=" + transp + ", typExp=" + typExp + ", typeDoc=" + typeDoc + "]";
    }
    
}
