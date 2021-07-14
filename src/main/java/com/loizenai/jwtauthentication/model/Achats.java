package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Achats implements Serializable{

    @Id 
    @Column(name = "NUM_DOC", updatable = false, nullable = false)
    private long numDocAchat;

    private String typDoc;
    private Timestamp date;
    private long codFrs;
    private BigDecimal montant;
    private BigDecimal montHt;
    private BigDecimal tva;
    private BigDecimal solde;
    private long numCom;

    @Enumerated(EnumType.STRING)
    private TYPREG typReg;
    public enum TYPREG{
        Payer_via_carte_bancaire,
        Commande_Paypal,
        Paiment_en_cheque_et_virement_bancaire,
        Acheter_en_mensualite
    }

    private BigDecimal montReg;
    private String docReg;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "PRET")
    private PRET pret;
    public enum PRET{
        payer,
        non_payer
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "VALIDATION")
    private VALIDATION validation;
    public enum VALIDATION{
        valider,
        non_valider
    }
/**FK start */

    @OneToOne(mappedBy = "achats", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Affaire affaire;

    @OneToOne(mappedBy = "achats", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Rectif rectif;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "achatss_articles",
            joinColumns = {
                    @JoinColumn(name = "NUM_DOC", referencedColumnName = "NUM_DOC",
                            nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "COD_ART", referencedColumnName = "COD_ART",
                            nullable = true, updatable = false)})
    private List<Article> articles;  
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User user;
/**FK end */

    public Achats(String typDoc, Timestamp date, long codFrs, BigDecimal montant, BigDecimal montHt, BigDecimal tva, BigDecimal solde, long numCom, TYPREG typReg, BigDecimal montReg, String docReg, PRET pret) {
        this.typDoc = typDoc;
        this.date = date;
        this.codFrs = codFrs;
        this.montant = montant;
        this.montHt = montHt;
        this.tva = tva;
        this.solde = solde;
        this.numCom = numCom;
        this.typReg = typReg;
        this.montReg = montReg;
        this.docReg = docReg;
        this.pret = pret;
    }

    public Achats(long numDocAchat, String typDoc, Timestamp date, long codFrs, BigDecimal montant, BigDecimal montHt,
        BigDecimal tva, BigDecimal solde, long numCom, TYPREG typReg, BigDecimal montReg, String docReg, PRET pret,
        VALIDATION validation, Affaire affaire, Rectif rectif, List<Article> articles, User user) {
    this.numDocAchat = numDocAchat;
    this.typDoc = typDoc;
    this.date = date;
    this.codFrs = codFrs;
    this.montant = montant;
    this.montHt = montHt;
    this.tva = tva;
    this.solde = solde;
    this.numCom = numCom;
    this.typReg = typReg;
    this.montReg = montReg;
    this.docReg = docReg;
    this.pret = pret;
    this.validation = validation;
    this.affaire = affaire;
    this.rectif = rectif;
    this.articles = articles;
    this.user = user;
}

    public Achats() {

    }

    public long getNumDocAchat() {
        return numDocAchat;
    }

    public void setNumDocAchat(long numDocAchat) {
        this.numDocAchat = numDocAchat;
    }


    @Basic
    @Column(name = "TYP_DOC")
    public String getTypDoc() {
        return typDoc;
    }

    public void setTypDoc(String typDoc) {
        this.typDoc = typDoc;
    }

    @Basic
    @Column(name = "DATE")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "COD_FRS")
    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
    }

    @Basic
    @Column(name = "MONTANT")
    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    @Basic
    @Column(name = "MONT_HT")
    public BigDecimal getMontHt() {
        return montHt;
    }

    public void setMontHt(BigDecimal montHt) {
        this.montHt = montHt;
    }

    @Basic
    @Column(name = "TVA")
    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
    }

    @Basic
    @Column(name = "SOLDE")
    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Basic
    @Column(name = "NUM_COM")
    public long getNumCom() {
        return numCom;
    }

    public void setNumCom(long numCom) {
        this.numCom = numCom;
    }

    @Basic
    @Column(name = "TYP_REG")
    public TYPREG getTypReg() {
        return typReg;
    }

    public void setTypReg(TYPREG typReg) {
        this.typReg = typReg;
    }

    @Basic
    @Column(name = "MONT_REG")
    public BigDecimal getMontReg() {
        return montReg;
    }

    public void setMontReg(BigDecimal montReg) {
        this.montReg = montReg;
    }

    @Basic
    @Column(name = "DOC_REG")
    public String getDocReg() {
        return docReg;
    }

    public void setDocReg(String docReg) {
        this.docReg = docReg;
    }

    public PRET getPret() {
        return pret;
    }

    public void setPret(PRET pret) {
        this.pret = pret;
    }

    public void setAffaire(Affaire affaire) {
        this.affaire = affaire;
    }
    public VALIDATION getValidation() {
        return validation;
    }

    public void setValidation(VALIDATION validation) {
        this.validation = validation;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRectif(Rectif rectif) {
        this.rectif = rectif;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((docReg == null) ? 0 : docReg.hashCode());
        result = prime * result + ((montHt == null) ? 0 : montHt.hashCode());
        result = prime * result + ((montReg == null) ? 0 : montReg.hashCode());
        result = prime * result + ((montant == null) ? 0 : montant.hashCode());
        result = prime * result + (int) (numCom ^ (numCom >>> 32));
        result = prime * result + (int) (numDocAchat ^ (numDocAchat >>> 32));
        result = prime * result + ((pret == null) ? 0 : pret.hashCode());
        result = prime * result + ((solde == null) ? 0 : solde.hashCode());
        result = prime * result + ((tva == null) ? 0 : tva.hashCode());
        result = prime * result + ((typDoc == null) ? 0 : typDoc.hashCode());
        result = prime * result + ((typReg == null) ? 0 : typReg.hashCode());
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
        Achats other = (Achats) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (docReg == null) {
            if (other.docReg != null)
                return false;
        } else if (!docReg.equals(other.docReg))
            return false;
        if (montHt == null) {
            if (other.montHt != null)
                return false;
        } else if (!montHt.equals(other.montHt))
            return false;
        if (montReg == null) {
            if (other.montReg != null)
                return false;
        } else if (!montReg.equals(other.montReg))
            return false;
        if (montant == null) {
            if (other.montant != null)
                return false;
        } else if (!montant.equals(other.montant))
            return false;
        if (numCom != other.numCom)
            return false;
        if (numDocAchat != other.numDocAchat)
            return false;
        if (pret == null) {
            if (other.pret != null)
                return false;
        } else if (!pret.equals(other.pret))
            return false;
        if (solde == null) {
            if (other.solde != null)
                return false;
        } else if (!solde.equals(other.solde))
            return false;
        if (tva == null) {
            if (other.tva != null)
                return false;
        } else if (!tva.equals(other.tva))
            return false;
        if (typDoc == null) {
            if (other.typDoc != null)
                return false;
        } else if (!typDoc.equals(other.typDoc))
            return false;
        if (typReg == null) {
            if (other.typReg != null)
                return false;
        } else if (!typReg.equals(other.typReg))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Achats{" +
                ", numDoc=" + numDocAchat +
                ", typDoc='" + typDoc + '\'' +
                ", date=" + date +
                ", codFrs=" + codFrs +
                ", montant=" + montant +
                ", montHt=" + montHt +
                ", tva=" + tva +
                ", solde=" + solde +
                ", numCom=" + numCom +
                ", typReg='" + typReg + '\'' +
                ", montReg=" + montReg +
                ", docReg='" + docReg + '\'' +
                ", pret='" + pret + '\'' +
                ", validation='" + validation + '\'' +
                '}';
    }
   
}
