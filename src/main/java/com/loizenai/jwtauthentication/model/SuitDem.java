package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "suit_dem", schema = "testbd", catalog = "")
public class SuitDem {
    private long id;
    private String codArt;
    private String refOrg;
    private String marque;
    private Integer qutDem;
    private Date datDem;
    private BigDecimal prixDev;
    private String desArt;
    private Integer qutProf;
    private BigDecimal prixProf;
    private BigDecimal prixAch;
    private Integer qutConf;
    private Date datConf;
    private Integer qutFac;
    private Integer qutRec;
    private String codFrs;
    private String raison;
    private BigDecimal prixDt;
    private BigDecimal ancPrix;
    private BigDecimal prixConf;
    private BigDecimal nouvPrix;
    private BigDecimal prixMp;
    private String transfer;
    private BigDecimal prixTrsf;
    private Integer vente;
    private Date datTransf;
    private Integer stkIni;
    private Integer qutTrsf;
    private Integer cumulFac;
    private BigDecimal prixEuro;
    private String totLiv;
    private BigDecimal prixDem;
    private Integer analStk;
    private Integer qutAnnul;
    private String cat;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COD_ART")
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    @Basic
    @Column(name = "REF_ORG")
    public String getRefOrg() {
        return refOrg;
    }

    public void setRefOrg(String refOrg) {
        this.refOrg = refOrg;
    }

    @Basic
    @Column(name = "MARQUE")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "QUT_DEM")
    public Integer getQutDem() {
        return qutDem;
    }

    public void setQutDem(Integer qutDem) {
        this.qutDem = qutDem;
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
    @Column(name = "PRIX_DEV")
    public BigDecimal getPrixDev() {
        return prixDev;
    }

    public void setPrixDev(BigDecimal prixDev) {
        this.prixDev = prixDev;
    }

    @Basic
    @Column(name = "DES_ART")
    public String getDesArt() {
        return desArt;
    }

    public void setDesArt(String desArt) {
        this.desArt = desArt;
    }

    @Basic
    @Column(name = "QUT_PROF")
    public Integer getQutProf() {
        return qutProf;
    }

    public void setQutProf(Integer qutProf) {
        this.qutProf = qutProf;
    }

    @Basic
    @Column(name = "PRIX_PROF")
    public BigDecimal getPrixProf() {
        return prixProf;
    }

    public void setPrixProf(BigDecimal prixProf) {
        this.prixProf = prixProf;
    }

    @Basic
    @Column(name = "PRIX_ACH")
    public BigDecimal getPrixAch() {
        return prixAch;
    }

    public void setPrixAch(BigDecimal prixAch) {
        this.prixAch = prixAch;
    }

    @Basic
    @Column(name = "QUT_CONF")
    public Integer getQutConf() {
        return qutConf;
    }

    public void setQutConf(Integer qutConf) {
        this.qutConf = qutConf;
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
    @Column(name = "QUT_FAC")
    public Integer getQutFac() {
        return qutFac;
    }

    public void setQutFac(Integer qutFac) {
        this.qutFac = qutFac;
    }

    @Basic
    @Column(name = "QUT_REC")
    public Integer getQutRec() {
        return qutRec;
    }

    public void setQutRec(Integer qutRec) {
        this.qutRec = qutRec;
    }

    @Basic
    @Column(name = "COD_FRS")
    public String getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(String codFrs) {
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
    @Column(name = "PRIX_DT")
    public BigDecimal getPrixDt() {
        return prixDt;
    }

    public void setPrixDt(BigDecimal prixDt) {
        this.prixDt = prixDt;
    }

    @Basic
    @Column(name = "ANC_PRIX")
    public BigDecimal getAncPrix() {
        return ancPrix;
    }

    public void setAncPrix(BigDecimal ancPrix) {
        this.ancPrix = ancPrix;
    }

    @Basic
    @Column(name = "PRIX_CONF")
    public BigDecimal getPrixConf() {
        return prixConf;
    }

    public void setPrixConf(BigDecimal prixConf) {
        this.prixConf = prixConf;
    }

    @Basic
    @Column(name = "NOUV_PRIX")
    public BigDecimal getNouvPrix() {
        return nouvPrix;
    }

    public void setNouvPrix(BigDecimal nouvPrix) {
        this.nouvPrix = nouvPrix;
    }

    @Basic
    @Column(name = "PRIX_MP")
    public BigDecimal getPrixMp() {
        return prixMp;
    }

    public void setPrixMp(BigDecimal prixMp) {
        this.prixMp = prixMp;
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
    @Column(name = "PRIX_TRSF")
    public BigDecimal getPrixTrsf() {
        return prixTrsf;
    }

    public void setPrixTrsf(BigDecimal prixTrsf) {
        this.prixTrsf = prixTrsf;
    }

    @Basic
    @Column(name = "VENTE")
    public Integer getVente() {
        return vente;
    }

    public void setVente(Integer vente) {
        this.vente = vente;
    }

    @Basic
    @Column(name = "DAT_TRANSF")
    public Date getDatTransf() {
        return datTransf;
    }

    public void setDatTransf(Date datTransf) {
        this.datTransf = datTransf;
    }

    @Basic
    @Column(name = "STK_INI")
    public Integer getStkIni() {
        return stkIni;
    }

    public void setStkIni(Integer stkIni) {
        this.stkIni = stkIni;
    }

    @Basic
    @Column(name = "QUT_TRSF")
    public Integer getQutTrsf() {
        return qutTrsf;
    }

    public void setQutTrsf(Integer qutTrsf) {
        this.qutTrsf = qutTrsf;
    }

    @Basic
    @Column(name = "CUMUL_FAC")
    public Integer getCumulFac() {
        return cumulFac;
    }

    public void setCumulFac(Integer cumulFac) {
        this.cumulFac = cumulFac;
    }

    @Basic
    @Column(name = "PRIX_EURO")
    public BigDecimal getPrixEuro() {
        return prixEuro;
    }

    public void setPrixEuro(BigDecimal prixEuro) {
        this.prixEuro = prixEuro;
    }

    @Basic
    @Column(name = "TOT_LIV")
    public String getTotLiv() {
        return totLiv;
    }

    public void setTotLiv(String totLiv) {
        this.totLiv = totLiv;
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
    @Column(name = "ANAL_STK")
    public Integer getAnalStk() {
        return analStk;
    }

    public void setAnalStk(Integer analStk) {
        this.analStk = analStk;
    }

    @Basic
    @Column(name = "QUT_ANNUL")
    public Integer getQutAnnul() {
        return qutAnnul;
    }

    public void setQutAnnul(Integer qutAnnul) {
        this.qutAnnul = qutAnnul;
    }

    @Basic
    @Column(name = "CAT")
    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuitDem suitDem = (SuitDem) o;
        return id == suitDem.id &&
                Objects.equals(codArt, suitDem.codArt) &&
                Objects.equals(refOrg, suitDem.refOrg) &&
                Objects.equals(marque, suitDem.marque) &&
                Objects.equals(qutDem, suitDem.qutDem) &&
                Objects.equals(datDem, suitDem.datDem) &&
                Objects.equals(prixDev, suitDem.prixDev) &&
                Objects.equals(desArt, suitDem.desArt) &&
                Objects.equals(qutProf, suitDem.qutProf) &&
                Objects.equals(prixProf, suitDem.prixProf) &&
                Objects.equals(prixAch, suitDem.prixAch) &&
                Objects.equals(qutConf, suitDem.qutConf) &&
                Objects.equals(datConf, suitDem.datConf) &&
                Objects.equals(qutFac, suitDem.qutFac) &&
                Objects.equals(qutRec, suitDem.qutRec) &&
                Objects.equals(codFrs, suitDem.codFrs) &&
                Objects.equals(raison, suitDem.raison) &&
                Objects.equals(prixDt, suitDem.prixDt) &&
                Objects.equals(ancPrix, suitDem.ancPrix) &&
                Objects.equals(prixConf, suitDem.prixConf) &&
                Objects.equals(nouvPrix, suitDem.nouvPrix) &&
                Objects.equals(prixMp, suitDem.prixMp) &&
                Objects.equals(transfer, suitDem.transfer) &&
                Objects.equals(prixTrsf, suitDem.prixTrsf) &&
                Objects.equals(vente, suitDem.vente) &&
                Objects.equals(datTransf, suitDem.datTransf) &&
                Objects.equals(stkIni, suitDem.stkIni) &&
                Objects.equals(qutTrsf, suitDem.qutTrsf) &&
                Objects.equals(cumulFac, suitDem.cumulFac) &&
                Objects.equals(prixEuro, suitDem.prixEuro) &&
                Objects.equals(totLiv, suitDem.totLiv) &&
                Objects.equals(prixDem, suitDem.prixDem) &&
                Objects.equals(analStk, suitDem.analStk) &&
                Objects.equals(qutAnnul, suitDem.qutAnnul) &&
                Objects.equals(cat, suitDem.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codArt, refOrg, marque, qutDem, datDem, prixDev, desArt, qutProf, prixProf, prixAch, qutConf, datConf, qutFac, qutRec, codFrs, raison, prixDt, ancPrix, prixConf, nouvPrix, prixMp, transfer, prixTrsf, vente, datTransf, stkIni, qutTrsf, cumulFac, prixEuro, totLiv, prixDem, analStk, qutAnnul, cat);
    }
}
