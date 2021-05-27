package com.loizenai.jwtauthentication.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Famille {
    private long id;
    private String code;
    private BigDecimal montant;
    private Byte numCom;
    private Date datCom;
    private Short nbrCom;
    private long codFrs;
    private Short delLiv;
    private BigDecimal valCom;
    private String confr;
    private String devise;
    private BigDecimal montReal;
    private BigDecimal montPrev;
    private BigDecimal totConf;
    private BigDecimal totDem;
    private BigDecimal coef;
    private String zone;
    private BigDecimal tauxFret;
    private BigDecimal tauxFrais;
    private BigDecimal tauxDou;
    private String nature;
    private Short marge;
    private String payement;
    private Short delaiPay;
    private String observ1;
    private String societe;

    public Famille(String code, BigDecimal montant, Byte numCom, Date datCom, Short nbrCom, long codFrs, Short delLiv, BigDecimal valCom, String confr, String devise, BigDecimal montReal, BigDecimal montPrev, BigDecimal totConf, BigDecimal totDem, BigDecimal coef, String zone, BigDecimal tauxFret, BigDecimal tauxFrais, BigDecimal tauxDou, String nature, Short marge, String payement, Short delaiPay, String observ1, String societe) {
        this.code = code;
        this.montant = montant;
        this.numCom = numCom;
        this.datCom = datCom;
        this.nbrCom = nbrCom;
        this.codFrs = codFrs;
        this.delLiv = delLiv;
        this.valCom = valCom;
        this.confr = confr;
        this.devise = devise;
        this.montReal = montReal;
        this.montPrev = montPrev;
        this.totConf = totConf;
        this.totDem = totDem;
        this.coef = coef;
        this.zone = zone;
        this.tauxFret = tauxFret;
        this.tauxFrais = tauxFrais;
        this.tauxDou = tauxDou;
        this.nature = nature;
        this.marge = marge;
        this.payement = payement;
        this.delaiPay = delaiPay;
        this.observ1 = observ1;
        this.societe = societe;
    }

    public Famille() {

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
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "NUM_COM")
    public Byte getNumCom() {
        return numCom;
    }

    public void setNumCom(Byte numCom) {
        this.numCom = numCom;
    }

    @Basic
    @Column(name = "DAT_COM")
    public Date getDatCom() {
        return datCom;
    }

    public void setDatCom(Date datCom) {
        this.datCom = datCom;
    }

    @Basic
    @Column(name = "NBR_COM")
    public Short getNbrCom() {
        return nbrCom;
    }

    public void setNbrCom(Short nbrCom) {
        this.nbrCom = nbrCom;
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
    @Column(name = "DEL_LIV")
    public Short getDelLiv() {
        return delLiv;
    }

    public void setDelLiv(Short delLiv) {
        this.delLiv = delLiv;
    }

    @Basic
    @Column(name = "VAL_COM")
    public BigDecimal getValCom() {
        return valCom;
    }

    public void setValCom(BigDecimal valCom) {
        this.valCom = valCom;
    }

    @Basic
    @Column(name = "CONFR")
    public String getConfr() {
        return confr;
    }

    public void setConfr(String confr) {
        this.confr = confr;
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
    @Column(name = "MONT_REAL")
    public BigDecimal getMontReal() {
        return montReal;
    }

    public void setMontReal(BigDecimal montReal) {
        this.montReal = montReal;
    }

    @Basic
    @Column(name = "MONT_PREV")
    public BigDecimal getMontPrev() {
        return montPrev;
    }

    public void setMontPrev(BigDecimal montPrev) {
        this.montPrev = montPrev;
    }

    @Basic
    @Column(name = "TOT_CONF")
    public BigDecimal getTotConf() {
        return totConf;
    }

    public void setTotConf(BigDecimal totConf) {
        this.totConf = totConf;
    }

    @Basic
    @Column(name = "TOT_DEM")
    public BigDecimal getTotDem() {
        return totDem;
    }

    public void setTotDem(BigDecimal totDem) {
        this.totDem = totDem;
    }

    @Basic
    @Column(name = "COEF")
    public BigDecimal getCoef() {
        return coef;
    }

    public void setCoef(BigDecimal coef) {
        this.coef = coef;
    }

    @Basic
    @Column(name = "ZONE")
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Basic
    @Column(name = "TAUX_FRET")
    public BigDecimal getTauxFret() {
        return tauxFret;
    }

    public void setTauxFret(BigDecimal tauxFret) {
        this.tauxFret = tauxFret;
    }

    @Basic
    @Column(name = "TAUX_FRAIS")
    public BigDecimal getTauxFrais() {
        return tauxFrais;
    }

    public void setTauxFrais(BigDecimal tauxFrais) {
        this.tauxFrais = tauxFrais;
    }

    @Basic
    @Column(name = "TAUX_DOU")
    public BigDecimal getTauxDou() {
        return tauxDou;
    }

    public void setTauxDou(BigDecimal tauxDou) {
        this.tauxDou = tauxDou;
    }

    @Basic
    @Column(name = "NATURE")
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Basic
    @Column(name = "MARGE")
    public Short getMarge() {
        return marge;
    }

    public void setMarge(Short marge) {
        this.marge = marge;
    }

    @Basic
    @Column(name = "PAYEMENT")
    public String getPayement() {
        return payement;
    }

    public void setPayement(String payement) {
        this.payement = payement;
    }

    @Basic
    @Column(name = "DELAI_PAY")
    public Short getDelaiPay() {
        return delaiPay;
    }

    public void setDelaiPay(Short delaiPay) {
        this.delaiPay = delaiPay;
    }

    @Basic
    @Column(name = "OBSERV1")
    public String getObserv1() {
        return observ1;
    }

    public void setObserv1(String observ1) {
        this.observ1 = observ1;
    }

    @Basic
    @Column(name = "SOCIETE")
    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Famille famille = (Famille) o;
        return id == famille.id &&
                codFrs == famille.codFrs &&
                Objects.equals(code, famille.code) &&
                Objects.equals(montant, famille.montant) &&
                Objects.equals(numCom, famille.numCom) &&
                Objects.equals(datCom, famille.datCom) &&
                Objects.equals(nbrCom, famille.nbrCom) &&
                Objects.equals(delLiv, famille.delLiv) &&
                Objects.equals(valCom, famille.valCom) &&
                Objects.equals(confr, famille.confr) &&
                Objects.equals(devise, famille.devise) &&
                Objects.equals(montReal, famille.montReal) &&
                Objects.equals(montPrev, famille.montPrev) &&
                Objects.equals(totConf, famille.totConf) &&
                Objects.equals(totDem, famille.totDem) &&
                Objects.equals(coef, famille.coef) &&
                Objects.equals(zone, famille.zone) &&
                Objects.equals(tauxFret, famille.tauxFret) &&
                Objects.equals(tauxFrais, famille.tauxFrais) &&
                Objects.equals(tauxDou, famille.tauxDou) &&
                Objects.equals(nature, famille.nature) &&
                Objects.equals(marge, famille.marge) &&
                Objects.equals(payement, famille.payement) &&
                Objects.equals(delaiPay, famille.delaiPay) &&
                Objects.equals(observ1, famille.observ1) &&
                Objects.equals(societe, famille.societe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, montant, numCom, datCom, nbrCom, codFrs, delLiv, valCom, confr, devise, montReal, montPrev, totConf, totDem, coef, zone, tauxFret, tauxFrais, tauxDou, nature, marge, payement, delaiPay, observ1, societe);
    }

    @Override
    public String toString() {
        return "Famille{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", montant=" + montant +
                ", numCom=" + numCom +
                ", datCom=" + datCom +
                ", nbrCom=" + nbrCom +
                ", codFrs=" + codFrs +
                ", delLiv=" + delLiv +
                ", valCom=" + valCom +
                ", confr='" + confr + '\'' +
                ", devise='" + devise + '\'' +
                ", montReal=" + montReal +
                ", montPrev=" + montPrev +
                ", totConf=" + totConf +
                ", totDem=" + totDem +
                ", coef=" + coef +
                ", zone='" + zone + '\'' +
                ", tauxFret=" + tauxFret +
                ", tauxFrais=" + tauxFrais +
                ", tauxDou=" + tauxDou +
                ", nature='" + nature + '\'' +
                ", marge=" + marge +
                ", payement='" + payement + '\'' +
                ", delaiPay=" + delaiPay +
                ", observ1='" + observ1 + '\'' +
                ", societe='" + societe + '\'' +
                '}';
    }
}
