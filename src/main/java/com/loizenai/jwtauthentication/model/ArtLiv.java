package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bonLivs_articles", schema = "seratest")
public class ArtLiv implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artliv")
    private long id_artliv;

    @Column(name = "livreur_frs")
    private String livreur_frs;

    private Integer qutLiv;
    private BigDecimal remise;
    private BigDecimal prixHt;

    @Column(name = "PRIX_AREM")
    private BigDecimal prixArem;
    
    private BigDecimal tva;
    private BigDecimal totHt;
    private BigDecimal marge;
    private String typArt;
    private Integer cumulRet;
    private BigDecimal prixAch;
    private BigDecimal remExp;
    private String poste;
    private String centre;

    @Column(name = "num_bon_liv")
    private String num_bon_liv;

    @Column(name = "cod_art")
    private String codArt;



    

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

        //FK_KEYS***********************

       //END FK_KEYS************************     
    public ArtLiv(Integer qutLiv, BigDecimal remise, BigDecimal prixHt, BigDecimal tva, BigDecimal totHt, BigDecimal marge, String typArt, Integer cumulRet, BigDecimal prixAch, BigDecimal remExp, String poste, String centre) {
        this.qutLiv = qutLiv;
        this.remise = remise;
        this.prixHt = prixHt;
        this.tva = tva;
        this.totHt = totHt;
        this.marge = marge;
        this.typArt = typArt;
        this.cumulRet = cumulRet;
        this.prixAch = prixAch;
        this.remExp = remExp;
        this.poste = poste;
        this.centre = centre;
    }

    public ArtLiv() {

    }




    public ArtLiv(long id_artliv, String livreur_frs, Integer qutLiv, BigDecimal remise, BigDecimal prixHt,
            BigDecimal prixArem, BigDecimal tva, BigDecimal totHt, BigDecimal marge, String typArt, Integer cumulRet,
            BigDecimal prixAch, BigDecimal remExp, String poste, String centre, String num_bon_liv, String codArt,
            Integer qutStk, Integer qutStk2, Integer stkGar, Integer stkIni, Integer analStk, Integer nbjStk,
            Integer vSstk, Integer comStk, Integer xanalStk, Integer stkAtrsf, Integer stkTrsf, Integer stkReel,
            Integer stkRes, Integer stkNp) {
        this.id_artliv = id_artliv;
        this.livreur_frs = livreur_frs;
        this.qutLiv = qutLiv;
        this.remise = remise;
        this.prixHt = prixHt;
        this.prixArem = prixArem;
        this.tva = tva;
        this.totHt = totHt;
        this.marge = marge;
        this.typArt = typArt;
        this.cumulRet = cumulRet;
        this.prixAch = prixAch;
        this.remExp = remExp;
        this.poste = poste;
        this.centre = centre;
        this.num_bon_liv = num_bon_liv;
        this.codArt = codArt;
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

    @Basic
    @Column(name = "QUT_LIV")
    public Integer getQutLiv() {
        return qutLiv;
    }

    public void setQutLiv(Integer qutLiv) {
        this.qutLiv = qutLiv;
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
    @Column(name = "MARGE")
    public BigDecimal getMarge() {
        return marge;
    }

    public void setMarge(BigDecimal marge) {
        this.marge = marge;
    }

    @Basic
    @Column(name = "TYP_ART")
    public String getTypArt() {
        return typArt;
    }

    public void setTypArt(String typArt) {
        this.typArt = typArt;
    }

    @Basic
    @Column(name = "CUMUL_RET")
    public Integer getCumulRet() {
        return cumulRet;
    }

    public void setCumulRet(Integer cumulRet) {
        this.cumulRet = cumulRet;
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
    @Column(name = "REM_EXP")
    public BigDecimal getRemExp() {
        return remExp;
    }

    public void setRemExp(BigDecimal remExp) {
        this.remExp = remExp;
    }

    @Basic
    @Column(name = "POSTE")
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Basic
    @Column(name = "CENTRE")
    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public long getId_artliv() {
        return id_artliv;
    }

    public void setId_artliv(long id_artliv) {
        this.id_artliv = id_artliv;
    }

    public String getNum_bon_liv() {
        return num_bon_liv;
    }

    public void setNum_bon_liv(String num_bon_liv) {
        this.num_bon_liv = num_bon_liv;
    }

    public String getCod_art() {
        return codArt;
    }

    public void setCod_art(String codArt) {
        this.codArt = codArt;
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

    public String getLivreur_frs() {
        return livreur_frs;
    }

    public void setLivreur_frs(String livreur_frs) {
        this.livreur_frs = livreur_frs;
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
        result = prime * result + ((codArt == null) ? 0 : codArt.hashCode());
        result = prime * result + ((cumulRet == null) ? 0 : cumulRet.hashCode());
        result = prime * result + (int) (id_artliv ^ (id_artliv >>> 32));
        result = prime * result + ((marge == null) ? 0 : marge.hashCode());
        result = prime * result + ((num_bon_liv == null) ? 0 : num_bon_liv.hashCode());
        result = prime * result + ((poste == null) ? 0 : poste.hashCode());
        result = prime * result + ((remExp == null) ? 0 : remExp.hashCode());
        result = prime * result + ((remise == null) ? 0 : remise.hashCode());
        result = prime * result + ((tva == null) ? 0 : tva.hashCode());
        result = prime * result + ((typArt == null) ? 0 : typArt.hashCode());
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
        ArtLiv other = (ArtLiv) obj;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
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
        if (id_artliv != other.id_artliv)
            return false;
        if (marge == null) {
            if (other.marge != null)
                return false;
        } else if (!marge.equals(other.marge))
            return false;
        if (num_bon_liv == null) {
            if (other.num_bon_liv != null)
                return false;
        } else if (!num_bon_liv.equals(other.num_bon_liv))
            return false;
        if (poste == null) {
            if (other.poste != null)
                return false;
        } else if (!poste.equals(other.poste))
            return false;
        if (remExp == null) {
            if (other.remExp != null)
                return false;
        } else if (!remExp.equals(other.remExp))
            return false;
        if (remise == null) {
            if (other.remise != null)
                return false;
        } else if (!remise.equals(other.remise))
            return false;
        if (tva == null) {
            if (other.tva != null)
                return false;
        } else if (!tva.equals(other.tva))
            return false;
        if (typArt == null) {
            if (other.typArt != null)
                return false;
        } else if (!typArt.equals(other.typArt))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArtLiv [centre=" + centre + ", codArt=" + codArt + ", cumulRet=" + cumulRet + ", id_artliv="
                + id_artliv + ", marge=" + marge + ", num_bon_liv=" + num_bon_liv
                + ", poste=" + poste + ", prixAch=" + prixAch + ", prixHt=" + prixHt + ", qutLiv=" + qutLiv
                + ", remExp=" + remExp + ", remise=" + remise + ", totHt=" + totHt + ", tva=" + tva + ", typArt="
                + typArt + "]";
    }
}
