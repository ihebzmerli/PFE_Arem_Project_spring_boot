package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bonSorts_articles", schema = "testbd")
public class ArtSort implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artsort")
    private long id;
    
    @Column(name = "cod_art")
    private String codArt;  

    @Column(name = "num_bon_sort")
    private String num_bon_sort;  

    private Integer qutSortie;
    private BigDecimal remise;
    private BigDecimal prixHt;

    @Column(name = "PRIX_AREM")
    private BigDecimal prixArem;

    private BigDecimal tva;
    private BigDecimal totHt;
    private BigDecimal cumulRet;
    private String centre;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POINTAGE_CHARIOT")
    @LastModifiedDate
    private Timestamp poitageChariot;

    //FK_KEYS***********************
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "numChar", nullable = true)
    private Chariot chariot;
    
    //END FK_KEYS************************ 
    @Column(name = "PREPARATEUR")
    private String preparateur;

    @Column(name = "QUT_STK")
    private Integer qutStk;

    @Column(name = "QUT_STK2")
    private Integer qutStk2;

    @Column(name = "STK_GAR")
    private Integer stkGar;

    @Column(name = "STK_INI")
    private Integer stkIni;

    @Column(name = "ANAL_STK")
    private Integer analStk;

    @Column(name = "NBJ_STK")
    private Integer nbjStk;

    @Column(name = "V_SSTK")
    private Integer vSstk;

    @Column(name = "COM_STK")
    private Integer comStk;

    @Column(name = "XANAL_STK")
    private Integer xanalStk;

    @Column(name = "STK_ATRSF")
    private Integer stkAtrsf;

    @Column(name = "STK_TRSF")
    private Integer stkTrsf;

    @Column(name = "STK_REEL")
    private Integer stkReel;

    @Column(name = "STK_RES")
    private Integer stkRes;

    @Column(name = "STK_NP")
    private Integer stkNp;
    
    public ArtSort(Integer qutSortie, BigDecimal remise, BigDecimal prixHt, BigDecimal tva, BigDecimal totHt, BigDecimal cumulRet, String centre) {
        this.qutSortie = qutSortie;
        this.remise = remise;
        this.prixHt = prixHt;
        this.tva = tva;
        this.totHt = totHt;
        this.cumulRet = cumulRet;
        this.centre = centre;
    }

    public ArtSort() {

    }

   
    public ArtSort(long id, String codArt, String num_bon_sort, Integer qutSortie, BigDecimal remise, BigDecimal prixHt,
            BigDecimal prixArem, BigDecimal tva, BigDecimal totHt, BigDecimal cumulRet, String centre,
            Timestamp poitageChariot, Chariot chariot, String preparateur, Integer qutStk, Integer qutStk2,
            Integer stkGar, Integer stkIni, Integer analStk, Integer nbjStk, Integer vSstk, Integer comStk,
            Integer xanalStk, Integer stkAtrsf, Integer stkTrsf, Integer stkReel, Integer stkRes, Integer stkNp) {
        this.id = id;
        this.codArt = codArt;
        this.num_bon_sort = num_bon_sort;
        this.qutSortie = qutSortie;
        this.remise = remise;
        this.prixHt = prixHt;
        this.prixArem = prixArem;
        this.tva = tva;
        this.totHt = totHt;
        this.cumulRet = cumulRet;
        this.centre = centre;
        this.poitageChariot = poitageChariot;
        this.chariot = chariot;
        this.preparateur = preparateur;
        this.qutStk = qutStk;
        this.qutStk2 = qutStk2;
        this.stkGar = stkGar;
        this.stkIni = stkIni;
        this.analStk = analStk;
        this.nbjStk = nbjStk;
        this.vSstk = vSstk;
        this.comStk = comStk;
        this.xanalStk = xanalStk;
        this.stkAtrsf = stkAtrsf;
        this.stkTrsf = stkTrsf;
        this.stkReel = stkReel;
        this.stkRes = stkRes;
        this.stkNp = stkNp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum_bon_sort() {
        return num_bon_sort;
    }

    public void setNum_bon_sort(String num_bon_sort) {
        this.num_bon_sort = num_bon_sort;
    }

    @Basic
    @Column(name = "QUT_SORTIE")
    public Integer getQutSortie() {
        return qutSortie;
    }

    public void setQutSortie(Integer qutSortie) {
        this.qutSortie = qutSortie;
    }

    @Basic
    @Column(name = "REMISE")
    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    @Basic
    @Column(name = "PRIX_HT")
    public BigDecimal getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(BigDecimal prixHt) {
        this.prixHt = prixHt;
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
    @Column(name = "TOT_HT")
    public BigDecimal getTotHt() {
        return totHt;
    }

    public void setTotHt(BigDecimal totHt) {
        this.totHt = totHt;
    }

    @Basic
    @Column(name = "CUMUL_RET")
    public BigDecimal getCumulRet() {
        return cumulRet;
    }

    public void setCumulRet(BigDecimal cumulRet) {
        this.cumulRet = cumulRet;
    }

    @Basic
    @Column(name = "CENTRE")
    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }
    public Chariot getChariot() {
        return chariot;
    }

    public void setChariot(Chariot chariot) {
        this.chariot = chariot;
    }

    public Timestamp getPoitageChariot() {
        return poitageChariot;
    }

    public void setPoitageChariot(Timestamp poitageChariot) {
        this.poitageChariot = poitageChariot;
    }

    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public Integer getQutStk() {
        return qutStk;
    }

    public void setQutStk(Integer qutStk) {
        this.qutStk = qutStk;
    }

    public Integer getQutStk2() {
        return qutStk2;
    }

    public void setQutStk2(Integer qutStk2) {
        this.qutStk2 = qutStk2;
    }

    public Integer getStkGar() {
        return stkGar;
    }

    public void setStkGar(Integer stkGar) {
        this.stkGar = stkGar;
    }

    public Integer getStkIni() {
        return stkIni;
    }

    public void setStkIni(Integer stkIni) {
        this.stkIni = stkIni;
    }

    public Integer getAnalStk() {
        return analStk;
    }

    public void setAnalStk(Integer analStk) {
        this.analStk = analStk;
    }

    public Integer getNbjStk() {
        return nbjStk;
    }

    public void setNbjStk(Integer nbjStk) {
        this.nbjStk = nbjStk;
    }

    public Integer getvSstk() {
        return vSstk;
    }

    public void setvSstk(Integer vSstk) {
        this.vSstk = vSstk;
    }

    public Integer getComStk() {
        return comStk;
    }

    public void setComStk(Integer comStk) {
        this.comStk = comStk;
    }

    public Integer getXanalStk() {
        return xanalStk;
    }

    public void setXanalStk(Integer xanalStk) {
        this.xanalStk = xanalStk;
    }

    public Integer getStkAtrsf() {
        return stkAtrsf;
    }

    public void setStkAtrsf(Integer stkAtrsf) {
        this.stkAtrsf = stkAtrsf;
    }

    public Integer getStkTrsf() {
        return stkTrsf;
    }

    public void setStkTrsf(Integer stkTrsf) {
        this.stkTrsf = stkTrsf;
    }

    public Integer getStkReel() {
        return stkReel;
    }

    public void setStkReel(Integer stkReel) {
        this.stkReel = stkReel;
    }

    public Integer getStkRes() {
        return stkRes;
    }

    public void setStkRes(Integer stkRes) {
        this.stkRes = stkRes;
    }

    public Integer getStkNp() {
        return stkNp;
    }

    public void setStkNp(Integer stkNp) {
        this.stkNp = stkNp;
    }
    
    public String getPreparateur() {
        return preparateur;
    }

    public void setPreparateur(String preparateur) {
        this.preparateur = preparateur;
    }   

    public BigDecimal getPrixArem() {
        return prixArem;
    }
    public void setPrixArem(BigDecimal prixArem) {
        this.prixArem = prixArem;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((chariot == null) ? 0 : chariot.hashCode());
        result = prime * result + ((codArt == null) ? 0 : codArt.hashCode());
        result = prime * result + ((cumulRet == null) ? 0 : cumulRet.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((poitageChariot == null) ? 0 : poitageChariot.hashCode());
        result = prime * result + ((prixHt == null) ? 0 : prixHt.hashCode());
        result = prime * result + ((qutSortie == null) ? 0 : qutSortie.hashCode());
        result = prime * result + ((remise == null) ? 0 : remise.hashCode());
        result = prime * result + ((totHt == null) ? 0 : totHt.hashCode());
        result = prime * result + ((tva == null) ? 0 : tva.hashCode());
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
        ArtSort other = (ArtSort) obj;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (chariot == null) {
            if (other.chariot != null)
                return false;
        } else if (!chariot.equals(other.chariot))
            return false;
        if (codArt == null) {
            if (other.codArt != null)
                return false;
        } else if (!codArt.equals(other.codArt))
            return false;
        if (cumulRet == null) {
            if (other.cumulRet != null)
                return false;
        } else if (!cumulRet.equals(other.cumulRet))
            return false;
        if (id != other.id)
            return false;
        if (poitageChariot == null) {
            if (other.poitageChariot != null)
                return false;
        } else if (!poitageChariot.equals(other.poitageChariot))
            return false;
        if (prixHt == null) {
            if (other.prixHt != null)
                return false;
        } else if (!prixHt.equals(other.prixHt))
            return false;
        if (qutSortie == null) {
            if (other.qutSortie != null)
                return false;
        } else if (!qutSortie.equals(other.qutSortie))
            return false;
        if (remise == null) {
            if (other.remise != null)
                return false;
        } else if (!remise.equals(other.remise))
            return false;
        if (totHt == null) {
            if (other.totHt != null)
                return false;
        } else if (!totHt.equals(other.totHt))
            return false;
        if (tva == null) {
            if (other.tva != null)
                return false;
        } else if (!tva.equals(other.tva))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArtSort [centre=" + centre + ", chariot=" + chariot + ", codArt=" + codArt
                + ", cumulRet=" + cumulRet + ", id=" + id + ", poitageChariot=" + poitageChariot + ", prixHt=" + prixHt
                + ", qutSortie=" + qutSortie + ", remise=" + remise + ", totHt=" + totHt + ", tva=" + tva + "]";
    }
    
}
