package com.loizenai.jwtauthentication.model;
import javax.persistence.CascadeType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marque", schema = "seratest")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Marque implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marque_id")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "file_name")
    private String fileName;
    
    @OneToMany(mappedBy = "marque", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Model> models;
    
    @OneToMany(mappedBy = "marque", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Article> articles;

    @OneToMany(mappedBy = "marque", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Gallery> galleries;
    
    @OneToMany(mappedBy = "marque", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Vehicule> vehicule;


    public Marque(String code,String title) {
        this.code = code;
        this.title = title;
    }

    public Marque() {

    }
    
    public Marque(long id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Marque(long id, String code, String title, String fileName) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.fileName = fileName;
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

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Marque [code=" + code + ", id=" + id + ", title=" + title + ", models=" + models + "]";
    }



}
