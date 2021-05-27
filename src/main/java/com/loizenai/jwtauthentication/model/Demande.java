package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Demande {
    private long id;
    private Long numDem;
    private Date datDem;
    private long codFrs;
    private String raison;
    private Date datProf;
    private Date datConf;
    private String proven;
    private String numProf;
    private String transfer;
    private String proforma;
    private String confirmer;
    private String observ;
    private Date datAnal;
    private BigDecimal montDev;
    private BigDecimal montDt;
    private BigDecimal montRev;
    private BigDecimal montTrsp;
    private BigDecimal montEmbl;
    private String devise;
    private BigDecimal montProf;
    private Short delaiLiv;
    private String modPaie;
    private BigDecimal totalConf;
    private BigDecimal montConf;
    private String affaires;
    private String euro;
    private BigDecimal prixDem;
    private BigDecimal montDem;
    private BigDecimal totREur;
    private BigDecimal montEur;
    private String codFam;
    private BigDecimal coefG;
    private BigDecimal coefCe;
    private BigDecimal coefHce;
    private long codUser;

    public Demande(Long numDem, Date datDem, long codFrs, String raison, Date datProf, Date datConf, String proven, String numProf, String transfer, String proforma, String confirmer, String observ, Date datAnal, BigDecimal montDev, BigDecimal montDt, BigDecimal montRev, BigDecimal montTrsp, BigDecimal montEmbl, String devise, BigDecimal montProf, Short delaiLiv, String modPaie, BigDecimal totalConf, BigDecimal montConf, String affaires, String euro, BigDecimal prixDem, BigDecimal montDem, BigDecimal totREur, BigDecimal montEur, String codFam, BigDecimal coefG, BigDecimal coefCe, BigDecimal coefHce, long codUser) {
        this.numDem = numDem;
        this.datDem = datDem;
        this.codFrs = codFrs;
        this.raison = raison;
        this.datProf = datProf;
        this.datConf = datConf;
        this.proven = proven;
        this.numProf = numProf;
        this.transfer = transfer;
        this.proforma = proforma;
        this.confirmer = confirmer;
        this.observ = observ;
        this.datAnal = datAnal;
        this.montDev = montDev;
        this.montDt = montDt;
        this.montRev = montRev;
        this.montTrsp = montTrsp;
        this.montEmbl = montEmbl;
        this.devise = devise;
        this.montProf = montProf;
        this.delaiLiv = delaiLiv;
        this.modPaie = modPaie;
        this.totalConf = totalConf;
        this.montConf = montConf;
        this.affaires = affaires;
        this.euro = euro;
        this.prixDem = prixDem;
        this.montDem = montDem;
        this.totREur = totREur;
        this.montEur = montEur;
        this.codFam = codFam;
        this.coefG = coefG;
        this.coefCe = coefCe;
        this.coefHce = coefHce;
        this.codUser = codUser;
    }

    public Demande() {

    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NUM_DEM")
    public Long getNumDem() {
        return numDem;
    }

    public void setNumDem(Long numDem) {
        this.numDem = numDem;
    }

    @Basic
    @Column(name = "DAT_DEM")
    public Date getDatDem() {
        return datDem;
    }

    public void setDatDem(Date datDem) {
        this.datDem = datDem;
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
    public Date getDatProf() {
        return datProf;
    }

    public void setDatProf(Date datProf) {
        this.datProf = datProf;
    }

    @Basic
    @Column(name = "DAT_CONF")
    public Date getDatConf() {
        return datConf;
    }

    public void setDatConf(Date datConf) {
        this.datConf = datConf;
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
    @Column(name = "OBSERV")
    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    @Basic
    @Column(name = "DAT_ANAL")
    public Date getDatAnal() {
        return datAnal;
    }

    public void setDatAnal(Date datAnal) {
        this.datAnal = datAnal;
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
    @Column(name = "DEVISE")
    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    @Basic
    @Column(name = "MONT_PROF")
    public BigDecimal getMontProf() {
        return montProf;
    }

    public void setMontProf(BigDecimal montProf) {
        this.montProf = montProf;
    }

    @Basic
    @Column(name = "DELAI_LIV")
    public Short getDelaiLiv() {
        return delaiLiv;
    }

    public void setDelaiLiv(Short delaiLiv) {
        this.delaiLiv = delaiLiv;
    }

    @Basic
    @Column(name = "MOD_PAIE")
    public String getModPaie() {
        return modPaie;
    }

    public void setModPaie(String modPaie) {
        this.modPaie = modPaie;
    }

    @Basic
    @Column(name = "TOTAL_CONF")
    public BigDecimal getTotalConf() {
        return totalConf;
    }

    public void setTotalConf(BigDecimal totalConf) {
        this.totalConf = totalConf;
    }

    @Basic
    @Column(name = "MONT_CONF")
    public BigDecimal getMontConf() {
        return montConf;
    }

    public void setMontConf(BigDecimal montConf) {
        this.montConf = montConf;
    }

    @Basic
    @Column(name = "AFFAIRES")
    public String getAffaires() {
        return affaires;
    }

    public void setAffaires(String affaires) {
        this.affaires = affaires;
    }

    @Basic
    @Column(name = "EURO")
    public String getEuro() {
        return euro;
    }

    public void setEuro(String euro) {
        this.euro = euro;
    }

    @Basic
    @Column(name = "PRIX_DEM")
    public BigDecimal getPrixDem() {
        return prixDem;
    }

    public void setPrixDem(BigDecimal prixDem) {
        this.prixDem = prixDem;
    }

    @Basic
    @Column(name = "MONT_DEM")
    public BigDecimal getMontDem() {
        return montDem;
    }

    public void setMontDem(BigDecimal montDem) {
        this.montDem = montDem;
    }

    @Basic
    @Column(name = "TOT_R_EUR")
    public BigDecimal getTotREur() {
        return totREur;
    }

    public void setTotREur(BigDecimal totREur) {
        this.totREur = totREur;
    }

    @Basic
    @Column(name = "MONT_EUR")
    public BigDecimal getMontEur() {
        return montEur;
    }

    public void setMontEur(BigDecimal montEur) {
        this.montEur = montEur;
    }

    @Basic
    @Column(name = "COD_FAM")
    public String getCodFam() {
        return codFam;
    }

    public void setCodFam(String codFam) {
        this.codFam = codFam;
    }

    @Basic
    @Column(name = "COEF_G")
    public BigDecimal getCoefG() {
        return coefG;
    }

    public void setCoefG(BigDecimal coefG) {
        this.coefG = coefG;
    }

    @Basic
    @Column(name = "COEF_CE")
    public BigDecimal getCoefCe() {
        return coefCe;
    }

    public void setCoefCe(BigDecimal coefCe) {
        this.coefCe = coefCe;
    }

    @Basic
    @Column(name = "COEF_HCE")
    public BigDecimal getCoefHce() {
        return coefHce;
    }

    public void setCoefHce(BigDecimal coefHce) {
        this.coefHce = coefHce;
    }

    @Basic
    @Column(name = "COD_USER")
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demande demande = (Demande) o;
        return id == demande.id &&
                codFrs == demande.codFrs &&
                codUser == demande.codUser &&
                Objects.equals(numDem, demande.numDem) &&
                Objects.equals(datDem, demande.datDem) &&
                Objects.equals(raison, demande.raison) &&
                Objects.equals(datProf, demande.datProf) &&
                Objects.equals(datConf, demande.datConf) &&
                Objects.equals(proven, demande.proven) &&
                Objects.equals(numProf, demande.numProf) &&
                Objects.equals(transfer, demande.transfer) &&
                Objects.equals(proforma, demande.proforma) &&
                Objects.equals(confirmer, demande.confirmer) &&
                Objects.equals(observ, demande.observ) &&
                Objects.equals(datAnal, demande.datAnal) &&
                Objects.equals(montDev, demande.montDev) &&
                Objects.equals(montDt, demande.montDt) &&
                Objects.equals(montRev, demande.montRev) &&
                Objects.equals(montTrsp, demande.montTrsp) &&
                Objects.equals(montEmbl, demande.montEmbl) &&
                Objects.equals(devise, demande.devise) &&
                Objects.equals(montProf, demande.montProf) &&
                Objects.equals(delaiLiv, demande.delaiLiv) &&
                Objects.equals(modPaie, demande.modPaie) &&
                Objects.equals(totalConf, demande.totalConf) &&
                Objects.equals(montConf, demande.montConf) &&
                Objects.equals(affaires, demande.affaires) &&
                Objects.equals(euro, demande.euro) &&
                Objects.equals(prixDem, demande.prixDem) &&
                Objects.equals(montDem, demande.montDem) &&
                Objects.equals(totREur, demande.totREur) &&
                Objects.equals(montEur, demande.montEur) &&
                Objects.equals(codFam, demande.codFam) &&
                Objects.equals(coefG, demande.coefG) &&
                Objects.equals(coefCe, demande.coefCe) &&
                Objects.equals(coefHce, demande.coefHce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numDem, datDem, codFrs, raison, datProf, datConf, proven, numProf, transfer, proforma, confirmer, observ, datAnal, montDev, montDt, montRev, montTrsp, montEmbl, devise, montProf, delaiLiv, modPaie, totalConf, montConf, affaires, euro, prixDem, montDem, totREur, montEur, codFam, coefG, coefCe, coefHce, codUser);
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", numDem=" + numDem +
                ", datDem=" + datDem +
                ", codFrs=" + codFrs +
                ", raison='" + raison + '\'' +
                ", datProf=" + datProf +
                ", datConf=" + datConf +
                ", proven='" + proven + '\'' +
                ", numProf='" + numProf + '\'' +
                ", transfer='" + transfer + '\'' +
                ", proforma='" + proforma + '\'' +
                ", confirmer='" + confirmer + '\'' +
                ", observ='" + observ + '\'' +
                ", datAnal=" + datAnal +
                ", montDev=" + montDev +
                ", montDt=" + montDt +
                ", montRev=" + montRev +
                ", montTrsp=" + montTrsp +
                ", montEmbl=" + montEmbl +
                ", devise='" + devise + '\'' +
                ", montProf=" + montProf +
                ", delaiLiv=" + delaiLiv +
                ", modPaie='" + modPaie + '\'' +
                ", totalConf=" + totalConf +
                ", montConf=" + montConf +
                ", affaires='" + affaires + '\'' +
                ", euro='" + euro + '\'' +
                ", prixDem=" + prixDem +
                ", montDem=" + montDem +
                ", totREur=" + totREur +
                ", montEur=" + montEur +
                ", codFam='" + codFam + '\'' +
                ", coefG=" + coefG +
                ", coefCe=" + coefCe +
                ", coefHce=" + coefHce +
                ", codUser=" + codUser +
                '}';
    }
}
