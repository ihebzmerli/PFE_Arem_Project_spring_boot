package com.loizenai.jwtauthentication.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "det_emba", schema = "seratest")
public class DetEmba implements Serializable{

    @Id
    @Column(name = "id_emba")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CALL_CHARIOT", nullable = false)
    @LastModifiedDate
    private Timestamp dateEmba;


    private Integer num;
    private Integer qut;
    //FK_KEYS***********************
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "NUM_BON_PREP", nullable = true)
    private BonPrep bonprep_detEmbas;
/*
    @OneToMany(mappedBy = "detembas_articles", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Article> articles;
*/
    //END FK_KEYS************************    
    public DetEmba(Integer num, Integer qut) {
        this.num = num;
        this.qut = qut;
    }

    public DetEmba(long id, Integer num, Integer qut) {
        this.id = id;
        this.num = num;
        this.qut = qut;
    }
    public DetEmba(Integer num, Integer qut, BonPrep bonprep_detEmbas) {
        this.num = num;
        this.qut = qut;
        this.bonprep_detEmbas = bonprep_detEmbas;
    }
    public DetEmba() {

    }



    
    public DetEmba(long id, Timestamp dateEmba, Integer num, Integer qut, BonPrep bonprep_detEmbas) {
        this.id = id;
        this.dateEmba = dateEmba;
        this.num = num;
        this.qut = qut;
        this.bonprep_detEmbas = bonprep_detEmbas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NUM")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "QUT")
    public Integer getQut() {
        return qut;
    }

    public void setQut(Integer qut) {
        this.qut = qut;
    }

    public BonPrep getBonprep_detEmbas() {
        return bonprep_detEmbas;
    }

    public void setBonprep_detEmbas(BonPrep bonprep_detEmbas) {
        this.bonprep_detEmbas = bonprep_detEmbas;
    }
    
    public Timestamp getDateEmba() {
        return dateEmba;
    }

    public void setDateEmba(Timestamp dateEmba) {
        this.dateEmba = dateEmba;
    }
/*
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
*/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bonprep_detEmbas == null) ? 0 : bonprep_detEmbas.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((num == null) ? 0 : num.hashCode());
        result = prime * result + ((qut == null) ? 0 : qut.hashCode());
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
        DetEmba other = (DetEmba) obj;
        if (bonprep_detEmbas == null) {
            if (other.bonprep_detEmbas != null)
                return false;
        } else if (!bonprep_detEmbas.equals(other.bonprep_detEmbas))
            return false;
        if (id != other.id)
            return false;
        if (num == null) {
            if (other.num != null)
                return false;
        } else if (!num.equals(other.num))
            return false;
        if (qut == null) {
            if (other.qut != null)
                return false;
        } else if (!qut.equals(other.qut))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DetEmba [artprep_detEmbas=" + bonprep_detEmbas + ", id=" + id + ", num=" + num + ", qut=" + qut + "]";
    }

}
