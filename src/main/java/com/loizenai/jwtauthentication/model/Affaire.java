package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Affaire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_AFF")
    private long numAff;

    private Timestamp datAff;
    private long codFrs;
    private String raison;
    private Timestamp datProf;
    private Timestamp datConf;
    private Timestamp datTransf;
    private String proven;
    private String numProf;
    private String transfer;
    private String proforma;
    private String confirmer;
    private Timestamp datAnal;
    private String numFac;
    private BigDecimal montDev;
    private BigDecimal montDt;
    private BigDecimal montRev;
    private boolean delaiLiv;
    private Timestamp datFac;
    private BigDecimal montTrsp;
    private BigDecimal montEmbl;
    private BigDecimal montAff;
    private BigDecimal totalAff;
    private String devise;
    private String listDem;
    private BigDecimal coef;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat_affaire")
    private EtatAffaire etat_affaire;
    public enum EtatAffaire{
        affaire_encore_pas_sortie_de_fournisseur,
        affaire_arriver_a_la_diwan,
        affaire_reçu_et_verifier;
    }
        //FK_KEYS***********************

        @OneToOne(fetch = FetchType.EAGER, optional = true)
        @JoinColumn(name = "numDoc", nullable = true)
        private Achats achats;

        @OneToMany(mappedBy = "affaire_suitaff", fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
        private List<SuitAff> suitaffs;


        
        //FK_KEYS***********************
        
        
    public Affaire(Timestamp datAff, long codFrs, String raison, Timestamp datProf, Timestamp datConf, Timestamp datTransf, String proven, String numProf, String transfer, String proforma, String confirmer, Timestamp datAnal, String numFac, BigDecimal montDev, BigDecimal montDt, BigDecimal montRev, boolean delaiLiv, Timestamp datFac, BigDecimal montTrsp, BigDecimal montEmbl, BigDecimal montAff, BigDecimal totalAff, String devise, String listDem, BigDecimal coef) {
        this.datAff = datAff;
        this.codFrs = codFrs;
        this.raison = raison;
        this.datProf = datProf;
        this.datConf = datConf;
        this.datTransf = datTransf;
        this.proven = proven;
        this.numProf = numProf;
        this.transfer = transfer;
        this.proforma = proforma;
        this.confirmer = confirmer;
        this.datAnal = datAnal;
        this.numFac = numFac;
        this.montDev = montDev;
        this.montDt = montDt;
        this.montRev = montRev;
        this.delaiLiv = delaiLiv;
        this.datFac = datFac;
        this.montTrsp = montTrsp;
        this.montEmbl = montEmbl;
        this.montAff = montAff;
        this.totalAff = totalAff;
        this.devise = devise;
        this.listDem = listDem;
        this.coef = coef;
    }

    public Affaire(long numAff, Timestamp datAff, long codFrs, String raison, Timestamp datProf, Timestamp datConf,
            Timestamp datTransf, String proven, String numProf, String transfer, String proforma, String confirmer,
            Timestamp datAnal, String numFac, BigDecimal montDev, BigDecimal montDt, BigDecimal montRev,
            boolean delaiLiv, Timestamp datFac, BigDecimal montTrsp, BigDecimal montEmbl, BigDecimal montAff,
            BigDecimal totalAff, String devise, String listDem, BigDecimal coef, Achats achats) {
        this.numAff = numAff;
        this.datAff = datAff;
        this.codFrs = codFrs;
        this.raison = raison;
        this.datProf = datProf;
        this.datConf = datConf;
        this.datTransf = datTransf;
        this.proven = proven;
        this.numProf = numProf;
        this.transfer = transfer;
        this.proforma = proforma;
        this.confirmer = confirmer;
        this.datAnal = datAnal;
        this.numFac = numFac;
        this.montDev = montDev;
        this.montDt = montDt;
        this.montRev = montRev;
        this.delaiLiv = delaiLiv;
        this.datFac = datFac;
        this.montTrsp = montTrsp;
        this.montEmbl = montEmbl;
        this.montAff = montAff;
        this.totalAff = totalAff;
        this.devise = devise;
        this.listDem = listDem;
        this.coef = coef;
        this.achats = achats;
        this.suitaffs = suitaffs;
    }

    public Affaire() {
    }

    public long getNumAff() {
        return numAff;
    }

    public void setNumAff(long numAff) {
        this.numAff = numAff;
    }

    @Basic
    @Column(name = "DAT_AFF")
    public Timestamp getDatAff() {
        return datAff;
    }

    public void setDatAff(Timestamp datAff) {
        this.datAff = datAff;
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
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Basic
    @Column(name = "DAT_PROF")
    public Timestamp getDatProf() {
        return datProf;
    }

    public void setDatProf(Timestamp datProf) {
        this.datProf = datProf;
    }

    @Basic
    @Column(name = "DAT_CONF")
    public Timestamp getDatConf() {
        return datConf;
    }

    public void setDatConf(Timestamp datConf) {
        this.datConf = datConf;
    }

    @Basic
    @Column(name = "DAT_TRANSF")
    public Timestamp getDatTransf() {
        return datTransf;
    }

    public void setDatTransf(Timestamp datTransf) {
        this.datTransf = datTransf;
    }

    @Basic
    @Column(name = "PROVEN")
    public String getProven() {
        return proven;
    }

    public void setProven(String proven) {
        this.proven = proven;
    }

    @Basic
    @Column(name = "NUM_PROF")
    public String getNumProf() {
        return numProf;
    }

    public void setNumProf(String numProf) {
        this.numProf = numProf;
    }

    @Basic
    @Column(name = "TRANSFER")
    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    @Basic
    @Column(name = "PROFORMA")
    public String getProforma() {
        return proforma;
    }

    public void setProforma(String proforma) {
        this.proforma = proforma;
    }

    @Basic
    @Column(name = "CONFIRMER")
    public String getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(String confirmer) {
        this.confirmer = confirmer;
    }

    @Basic
    @Column(name = "DAT_ANAL")
    public Timestamp getDatAnal() {
        return datAnal;
    }

    public void setDatAnal(Timestamp datAnal) {
        this.datAnal = datAnal;
    }

    @Basic
    @Column(name = "NUM_FAC")
    public String getNumFac() {
        return numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }

    @Basic
    @Column(name = "MONT_DEV")
    public BigDecimal getMontDev() {
        return montDev;
    }

    public void setMontDev(BigDecimal montDev) {
        this.montDev = montDev;
    }

    @Basic
    @Column(name = "MONT_DT")
    public BigDecimal getMontDt() {
        return montDt;
    }

    public void setMontDt(BigDecimal montDt) {
        this.montDt = montDt;
    }

    @Basic
    @Column(name = "MONT_REV")
    public BigDecimal getMontRev() {
        return montRev;
    }

    public void setMontRev(BigDecimal montRev) {
        this.montRev = montRev;
    }

    @Basic
    @Column(name = "DELAI_LIV")
    public boolean getDelaiLiv() {
        return delaiLiv;
    }

    public void setDelaiLiv(boolean delaiLiv) {
        this.delaiLiv = delaiLiv;
    }

    @Basic
    @Column(name = "DAT_FAC")
    public Timestamp getDatFac() {
        return datFac;
    }

    public void setDatFac(Timestamp datFac) {
        this.datFac = datFac;
    }

    @Basic
    @Column(name = "MONT_TRSP")
    public BigDecimal getMontTrsp() {
        return montTrsp;
    }

    public void setMontTrsp(BigDecimal montTrsp) {
        this.montTrsp = montTrsp;
    }

    @Basic
    @Column(name = "MONT_EMBL")
    public BigDecimal getMontEmbl() {
        return montEmbl;
    }

    public void setMontEmbl(BigDecimal montEmbl) {
        this.montEmbl = montEmbl;
    }

    @Basic
    @Column(name = "MONT_AFF")
    public BigDecimal getMontAff() {
        return montAff;
    }

    public void setMontAff(BigDecimal montAff) {
        this.montAff = montAff;
    }

    @Basic
    @Column(name = "TOTAL_AFF")
    public BigDecimal getTotalAff() {
        return totalAff;
    }

    public void setTotalAff(BigDecimal totalAff) {
        this.totalAff = totalAff;
    }

    @Basic
    @Column(name = "DEVISE")
    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    @Basic
    @Column(name = "LIST_DEM")
    public String getListDem() {
        return listDem;
    }

    public void setListDem(String listDem) {
        this.listDem = listDem;
    }

    @Basic
    @Column(name = "COEF")
    public BigDecimal getCoef() {
        return coef;
    }

    public void setCoef(BigDecimal coef) {
        this.coef = coef;
    }

    public List<SuitAff> getSuitaffs() {
        return suitaffs;
    }

    public void setSuitaffs(List<SuitAff> suitaffs) {
        this.suitaffs = suitaffs;
    }
    
    public Achats getAchats() {
        return achats;
    }
    public void setAchats(Achats achats) {
        this.achats = achats;
    }

    public EtatAffaire getEtat_affaire() {
        return etat_affaire;
    }

    public void setEtat_affaire(EtatAffaire etat_affaire) {
        this.etat_affaire = etat_affaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affaire affaire = (Affaire) o;
        return numAff == affaire.numAff &&
                codFrs == affaire.codFrs &&
                Objects.equals(datAff, affaire.datAff) &&
                Objects.equals(raison, affaire.raison) &&
                Objects.equals(datProf, affaire.datProf) &&
                Objects.equals(datConf, affaire.datConf) &&
                Objects.equals(datTransf, affaire.datTransf) &&
                Objects.equals(proven, affaire.proven) &&
                Objects.equals(numProf, affaire.numProf) &&
                Objects.equals(transfer, affaire.transfer) &&
                Objects.equals(proforma, affaire.proforma) &&
                Objects.equals(confirmer, affaire.confirmer) &&
                Objects.equals(datAnal, affaire.datAnal) &&
                Objects.equals(numFac, affaire.numFac) &&
                Objects.equals(montDev, affaire.montDev) &&
                Objects.equals(montDt, affaire.montDt) &&
                Objects.equals(montRev, affaire.montRev) &&
                Objects.equals(delaiLiv, affaire.delaiLiv) &&
                Objects.equals(datFac, affaire.datFac) &&
                Objects.equals(montTrsp, affaire.montTrsp) &&
                Objects.equals(montEmbl, affaire.montEmbl) &&
                Objects.equals(montAff, affaire.montAff) &&
                Objects.equals(totalAff, affaire.totalAff) &&
                Objects.equals(devise, affaire.devise) &&
                Objects.equals(listDem, affaire.listDem) &&
                Objects.equals(coef, affaire.coef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAff, datAff, codFrs, raison, datProf, datConf, datTransf, proven, numProf, transfer, proforma, confirmer, datAnal, numFac, montDev, montDt, montRev, delaiLiv, datFac, montTrsp, montEmbl, montAff, totalAff, devise, listDem, coef);
    }

    @Override
    public String toString() {
        return "Affaire{" +
                "numAff=" + numAff +
                ", datAff=" + datAff +
                ", codFrs=" + codFrs +
                ", raison='" + raison + '\'' +
                ", datProf=" + datProf +
                ", datConf=" + datConf +
                ", datTransf=" + datTransf +
                ", proven='" + proven + '\'' +
                ", numProf='" + numProf + '\'' +
                ", transfer='" + transfer + '\'' +
                ", proforma='" + proforma + '\'' +
                ", confirmer='" + confirmer + '\'' +
                ", datAnal=" + datAnal +
                ", numFac='" + numFac + '\'' +
                ", montDev=" + montDev +
                ", montDt=" + montDt +
                ", montRev=" + montRev +
                ", delaiLiv=" + delaiLiv +
                ", datFac=" + datFac +
                ", montTrsp=" + montTrsp +
                ", montEmbl=" + montEmbl +
                ", montAff=" + montAff +
                ", totalAff=" + totalAff +
                ", devise='" + devise + '\'' +
                ", listDem='" + listDem + '\'' +
                ", coef=" + coef +
                '}';
    }

    
}
