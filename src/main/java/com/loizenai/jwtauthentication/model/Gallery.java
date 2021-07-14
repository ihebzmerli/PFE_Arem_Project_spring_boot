package com.loizenai.jwtauthentication.model;
import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "gallery", schema = "testbd")
public class Gallery {

    @Id
    @Column(name = "id_gallery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gallery;

    @Basic
    @Column(name = "last_modification")
    @LastModifiedDate
    private Timestamp lastModification;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private Long size;

    @Column(name = "type")
    private String type;



    /********Fk keys */
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "codArt", nullable = true)
    private Article article;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_user", nullable = true)
    private User user;


    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "marque_id", nullable = true)
    private Marque marque;

    /********Fk keys */


    public Gallery() {
    }

    public Gallery(Long id_gallery, Timestamp lastModification, String name, Long size, String type) {
        this.id_gallery = id_gallery;
        this.lastModification = lastModification;
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public Gallery(Long id_gallery, Timestamp lastModification, String name, Long size, String type, Article article,
            User user, Marque marque) {
        this.id_gallery = id_gallery;
        this.lastModification = lastModification;
        this.name = name;
        this.size = size;
        this.type = type;
        this.article = article;
        this.user = user;
        this.marque = marque;
    }

    public Long getId_gallery() {
        return id_gallery;
    }

    public void setId_gallery(Long id_gallery) {
        this.id_gallery = id_gallery;
    }

    public Timestamp getLastModification() {
        return lastModification;
    }

    public void setLastModification(Timestamp lastModification) {
        this.lastModification = lastModification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_gallery == null) ? 0 : id_gallery.hashCode());
        result = prime * result + ((lastModification == null) ? 0 : lastModification.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Gallery other = (Gallery) obj;
        if (id_gallery == null) {
            if (other.id_gallery != null)
                return false;
        } else if (!id_gallery.equals(other.id_gallery))
            return false;
        if (lastModification == null) {
            if (other.lastModification != null)
                return false;
        } else if (!lastModification.equals(other.lastModification))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Gallery [article=" + article + ", id_gallery=" + id_gallery + ", lastModification=" + lastModification
                + ", marque=" + marque + ", name=" + name + ", size=" + size + ", type=" + type + ", user=" + user
                + "]";
    }

    

}
