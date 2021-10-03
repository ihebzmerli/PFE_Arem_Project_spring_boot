package com.loizenai.jwtauthentication.model;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "model", schema = "testbd")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "marque_id", nullable = true)
    private Marque marque;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Article> articles;

    
    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Vehicule> vehicule;

    public Model() {
    }

    public Model(String code, String title, Marque marque) {
        this.code = code;
        this.title = title;
        this.marque = marque;
    }

    public Model(long id, String code, String title, Marque marque) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.marque = marque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((marque == null) ? 0 : marque.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        Model other = (Model) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (id != other.id)
            return false;
        if (marque == null) {
            if (other.marque != null)
                return false;
        } else if (!marque.equals(other.marque))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Model [code=" + code + ", id=" + id + ", marque=" + marque + ", title=" + title + "]";
    }  

    
}
