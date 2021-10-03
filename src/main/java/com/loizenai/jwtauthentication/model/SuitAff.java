package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "suit_aff", schema = "testbd", catalog = "")
public class SuitAff implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String codArt;
    private String refOrg;
    private String marque;
    private Integer qutDem;
    private Date datAff;
    private BigDecimal prixDev;
    private String desArt;
    private Integer qutProf;
    private BigDecimal prixProf;
    private BigDecimal prixAch;
    private Integer qutConf;
    private Date datConf;
    private Integer qutFac;
    private Integer qutRec;
    private String raison;
    private BigDecimal prixDt;
    private long codFrs;
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
    private Integer analStk;
    private Integer ecart;
    private String codBar;
    private String codTrsf;


    //FK_KEYS***********************
    

        @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "numAff", nullable = true)
        private Affaire affaire_suitaff;
    
    
    //FK_KEYS***********************

    public SuitAff(long id, String codArt, String refOrg, String marque, Integer qutDem, Date datAff,
    BigDecimal prixDev, String desArt, Integer qutProf, BigDecimal prixProf, BigDecimal prixAch,
    Integer qutConf, Date datConf, Integer qutFac, Integer qutRec, String raison, BigDecimal prixDt,
    long codFrs, BigDecimal ancPrix, BigDecimal prixConf, BigDecimal nouvPrix, BigDecimal prixMp,
    String transfer, BigDecimal prixTrsf, Integer vente, Date datTransf, Integer stkIni, Integer qutTrsf,
    Integer analStk, Integer ecart, String codBar, String codTrsf, Affaire affaire_suitaff) {
        this.id = id;
        this.codArt = codArt;
        this.refOrg = refOrg;
        this.marque = marque;
        this.qutDem = qutDem;
        this.datAff = datAff;
        this.prixDev = prixDev;
        this.desArt = desArt;
        this.qutProf = qutProf;
        this.prixProf = prixProf;
        this.prixAch = prixAch;
        this.qutConf = qutConf;
        this.datConf = datConf;
        this.qutFac = qutFac;
        this.qutRec = qutRec;
        this.raison = raison;
        this.prixDt = prixDt;
        this.codFrs = codFrs;
        this.ancPrix = ancPrix;
        this.prixConf = prixConf;
        this.nouvPrix = nouvPrix;
        this.prixMp = prixMp;
        this.transfer = transfer;
        this.prixTrsf = prixTrsf;
        this.vente = vente;
        this.datTransf = datTransf;
        this.stkIni = stkIni;
        this.qutTrsf = qutTrsf;
        this.analStk = analStk;
        this.ecart = ecart;
        this.codBar = codBar;
        this.codTrsf = codTrsf;
        this.affaire_suitaff = affaire_suitaff;
    }

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
    @Column(name = "DAT_AFF")
    public Date getDatAff() {
        return datAff;
    }

    public void setDatAff(Date datAff) {
        this.datAff = datAff;
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
    @Column(name = "COD_FRS")
    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
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
    @Column(name = "ANAL_STK")
    public Integer getAnalStk() {
        return analStk;
    }

    public void setAnalStk(Integer analStk) {
        this.analStk = analStk;
    }

    @Basic
    @Column(name = "ECART")
    public Integer getEcart() {
        return ecart;
    }

    public void setEcart(Integer ecart) {
        this.ecart = ecart;
    }

    @Basic
    @Column(name = "COD_BAR")
    public String getCodBar() {
        return codBar;
    }

    public void setCodBar(String codBar) {
        this.codBar = codBar;
    }

    @Basic
    @Column(name = "COD_TRSF")
    public String getCodTrsf() {
        return codTrsf;
    }

    public void setCodTrsf(String codTrsf) {
        this.codTrsf = codTrsf;
    }

    public void setAffaire(Affaire affaire_suitaff) {
        this.affaire_suitaff = affaire_suitaff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuitAff suitAff = (SuitAff) o;
        return id == suitAff.id &&
                codFrs == suitAff.codFrs &&
                Objects.equals(codArt, suitAff.codArt) &&
                Objects.equals(refOrg, suitAff.refOrg) &&
                Objects.equals(marque, suitAff.marque) &&
                Objects.equals(qutDem, suitAff.qutDem) &&
                Objects.equals(datAff, suitAff.datAff) &&
                Objects.equals(prixDev, suitAff.prixDev) &&
                Objects.equals(desArt, suitAff.desArt) &&
                Objects.equals(qutProf, suitAff.qutProf) &&
                Objects.equals(prixProf, suitAff.prixProf) &&
                Objects.equals(prixAch, suitAff.prixAch) &&
                Objects.equals(qutConf, suitAff.qutConf) &&
                Objects.equals(datConf, suitAff.datConf) &&
                Objects.equals(qutFac, suitAff.qutFac) &&
                Objects.equals(qutRec, suitAff.qutRec) &&
                Objects.equals(raison, suitAff.raison) &&
                Objects.equals(prixDt, suitAff.prixDt) &&
                Objects.equals(ancPrix, suitAff.ancPrix) &&
                Objects.equals(prixConf, suitAff.prixConf) &&
                Objects.equals(nouvPrix, suitAff.nouvPrix) &&
                Objects.equals(prixMp, suitAff.prixMp) &&
                Objects.equals(transfer, suitAff.transfer) &&
                Objects.equals(prixTrsf, suitAff.prixTrsf) &&
                Objects.equals(vente, suitAff.vente) &&
                Objects.equals(datTransf, suitAff.datTransf) &&
                Objects.equals(stkIni, suitAff.stkIni) &&
                Objects.equals(qutTrsf, suitAff.qutTrsf) &&
                Objects.equals(analStk, suitAff.analStk) &&
                Objects.equals(ecart, suitAff.ecart) &&
                Objects.equals(codBar, suitAff.codBar) &&
                Objects.equals(codTrsf, suitAff.codTrsf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codArt, refOrg, marque, qutDem, datAff, prixDev, desArt, qutProf, prixProf, prixAch, qutConf, datConf, qutFac, qutRec, raison, prixDt, codFrs, ancPrix, prixConf, nouvPrix, prixMp, transfer, prixTrsf, vente, datTransf, stkIni, qutTrsf, analStk, ecart, codBar, codTrsf);
    }

    @Override
    public String toString() {
        return "SuitAff [affaire_suitaff=" + affaire_suitaff + ", analStk=" + analStk + ", ancPrix=" + ancPrix
                + ", codArt=" + codArt + ", codBar=" + codBar + ", codFrs=" + codFrs + ", codTrsf=" + codTrsf
                + ", datAff=" + datAff + ", datConf=" + datConf + ", datTransf=" + datTransf + ", desArt=" + desArt
                + ", ecart=" + ecart + ", id=" + id + ", marque=" + marque + ", nouvPrix=" + nouvPrix + ", prixAch="
                + prixAch + ", prixConf=" + prixConf + ", prixDev=" + prixDev + ", prixDt=" + prixDt + ", prixMp="
                + prixMp + ", prixProf=" + prixProf + ", prixTrsf=" + prixTrsf + ", qutConf=" + qutConf + ", qutDem="
                + qutDem + ", qutFac=" + qutFac + ", qutProf=" + qutProf + ", qutRec=" + qutRec + ", qutTrsf=" + qutTrsf
                + ", raison=" + raison + ", refOrg=" + refOrg + ", stkIni=" + stkIni + ", transfer=" + transfer
                + ", vente=" + vente + "]";
    }
 
}
