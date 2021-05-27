package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bon_preps_articles", schema = "seratest")
public class ArtPrep implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artprep")
    private long id;
    
    @Column(name = "num_bon_prep")
    private String numBon;

    @Column(name = "cod_art")
    private String codArt;

    private BigDecimal qutLiv;
    private BigDecimal remise;
    private BigDecimal prixHt;
    
    @Column(name = "PRIX_AREM")
    private BigDecimal prixArem;

    private BigDecimal tva;
    private BigDecimal totHt;
    private BigDecimal marge;
    private Integer cumulRet;
    private BigDecimal prixAch;
    private Integer qutPrep;
    private Boolean nonTrouve;
    private Timestamp datPrep;
    private BigDecimal remExp;
    private String etage2;
    private String numCas;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHRONO")
    @LastModifiedDate
    private Timestamp chrono;
    
    private String prep;
    private String prepara;
    private String avPrep;
    private Integer qutPoint;
    private String poste;
    private String centre;
    @Column(name = "TYP_ART")
    private String typArt;
    
    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POINTAGE_CHARIOT")
    @LastModifiedDate
    private Timestamp poitageChariot;

    //FK_KEYS***********************
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "NUM_BON_FAC", nullable = true)
    private ArtTerm artPrep_artTerm;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "numChar", nullable = true)
    private Chariot artprep_chariot;
    //END FK_KEYS************************

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


    public ArtPrep() {

    }
    public ArtPrep(String typArt,BigDecimal qutLiv, BigDecimal remise, BigDecimal prixHt, BigDecimal tva, BigDecimal totHt,
            BigDecimal marge, Integer cumulRet, BigDecimal prixAch, Integer qutPrep, Boolean nonTrouve, Timestamp datPrep,
            BigDecimal remExp, String etage2, String numCas, String heure, String heure1, String prep, String prepara,
            String avPrep, Integer qutPoint, String poste, String centre) {
        this.typArt = typArt;
        this.qutLiv = qutLiv;
        this.remise = remise;
        this.prixHt = prixHt;
        this.tva = tva;
        this.totHt = totHt;
        this.marge = marge;
        this.cumulRet = cumulRet;
        this.prixAch = prixAch;
        this.qutPrep = qutPrep;
        this.nonTrouve = nonTrouve;
        this.datPrep = datPrep;
        this.remExp = remExp;
        this.etage2 = etage2;
        this.numCas = numCas; 
        this.prep = prep;
        this.prepara = prepara;
        this.avPrep = avPrep;
        this.qutPoint = qutPoint;
        this.poste = poste;
        this.centre = centre;
    }
    

    
    public ArtPrep(long id, String numBon, String codArt, BigDecimal qutLiv, BigDecimal remise, BigDecimal prixHt,
            BigDecimal prixArem, BigDecimal tva, BigDecimal totHt, BigDecimal marge, Integer cumulRet,
            BigDecimal prixAch, Integer qutPrep, Boolean nonTrouve, Timestamp datPrep, BigDecimal remExp, String etage2,
            String numCas, Timestamp chrono, String prep, String prepara, String avPrep, Integer qutPoint, String poste,
            String centre, String typArt, Timestamp poitageChariot, ArtTerm artPrep_artTerm, Chariot artprep_chariot,
            Integer qutStk, Integer qutStk2, Integer stkGar, Integer stkIni, Integer analStk, Integer nbjStk,
            Integer vSstk, Integer comStk, Integer xanalStk, Integer stkAtrsf, Integer stkTrsf, Integer stkReel,
            Integer stkRes, Integer stkNp) {
        this.id = id;
        this.numBon = numBon;
        this.codArt = codArt;
        this.qutLiv = qutLiv;
        this.remise = remise;
        this.prixHt = prixHt;
        this.prixArem = prixArem;
        this.tva = tva;
        this.totHt = totHt;
        this.marge = marge;
        this.cumulRet = cumulRet;
        this.prixAch = prixAch;
        this.qutPrep = qutPrep;
        this.nonTrouve = nonTrouve;
        this.datPrep = datPrep;
        this.remExp = remExp;
        this.etage2 = etage2;
        this.numCas = numCas;
        this.chrono = chrono;
        this.prep = prep;
        this.prepara = prepara;
        this.avPrep = avPrep;
        this.qutPoint = qutPoint;
        this.poste = poste;
        this.centre = centre;
        this.typArt = typArt;
        this.poitageChariot = poitageChariot;
        this.artPrep_artTerm = artPrep_artTerm;
        this.artprep_chariot = artprep_chariot;
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
    
    public String getTypArt() {
        return typArt;
    }
    public void setTypArt(String typArt) {
        this.typArt = typArt;
    }

    @Basic
    @Column(name = "QUT_LIV")
    public BigDecimal getQutLiv() {
        return qutLiv;
    }

    public void setQutLiv(BigDecimal qutLiv) {
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
    @Column(name = "QUT_PREP")
    public Integer getQutPrep() {
        return qutPrep;
    }

    public void setQutPrep(Integer qutPrep) {
        this.qutPrep = qutPrep;
    }

    @Basic
    @Column(name = "NON_TROUVE")
    public Boolean getNonTrouve() {
        return nonTrouve;
    }

    public void setNonTrouve(Boolean nonTrouve) {
        this.nonTrouve = nonTrouve;
    }

    @Basic
    @Column(name = "DAT_PREP")
    public Timestamp getDatPrep() {
        return datPrep;
    }

    public void setDatPrep(Timestamp datPrep) {
        this.datPrep = datPrep;
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
    @Column(name = "ETAGE2")
    public String getEtage2() {
        return etage2;
    }

    public void setEtage2(String etage2) {
        this.etage2 = etage2;
    }

    @Basic
    @Column(name = "NUM_CAS")
    public String getNumCas() {
        return numCas;
    }

    public void setNumCas(String numCas) {
        this.numCas = numCas;
    } 

    @Basic
    @Column(name = "PREP")
    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    @Basic
    @Column(name = "PREPARA")
    public String getPrepara() {
        return prepara;
    }

    public void setPrepara(String prepara) {
        this.prepara = prepara;
    }

    @Basic
    @Column(name = "AV_PREP")
    public String getAvPrep() {
        return avPrep;
    }

    public void setAvPrep(String avPrep) {
        this.avPrep = avPrep;
    }

    @Basic
    @Column(name = "QUT_POINT")
    public Integer getQutPoint() {
        return qutPoint;
    }

    public void setQutPoint(Integer qutPoint) {
        this.qutPoint = qutPoint;
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

    public Chariot getArtprep_chariot() {
        return artprep_chariot;
    }
    public void setArtprep_chariot(Chariot artprep_chariot) {
        this.artprep_chariot = artprep_chariot;
    }

    public void setArtPrep_artTerm(ArtTerm artPrep_artTerm) {
        this.artPrep_artTerm = artPrep_artTerm;
    }

    public Timestamp getChrono() {
        return chrono;
    }

    public void setChrono(Timestamp chrono) {
        this.chrono = chrono;
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

    public String getNumBon() {
        return numBon;
    }

    public void setNumBon(String numBon) {
        this.numBon = numBon;
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
        result = prime * result + ((artPrep_artTerm == null) ? 0 : artPrep_artTerm.hashCode());
        result = prime * result + ((artprep_chariot == null) ? 0 : artprep_chariot.hashCode());
        result = prime * result + ((avPrep == null) ? 0 : avPrep.hashCode());
        result = prime * result + ((centre == null) ? 0 : centre.hashCode());
        result = prime * result + ((chrono == null) ? 0 : chrono.hashCode());
        result = prime * result + ((codArt == null) ? 0 : codArt.hashCode());
        result = prime * result + ((cumulRet == null) ? 0 : cumulRet.hashCode());
        result = prime * result + ((datPrep == null) ? 0 : datPrep.hashCode());
        result = prime * result + ((etage2 == null) ? 0 : etage2.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((marge == null) ? 0 : marge.hashCode());
        result = prime * result + ((nonTrouve == null) ? 0 : nonTrouve.hashCode());
        result = prime * result + ((numBon == null) ? 0 : numBon.hashCode());
        result = prime * result + ((numCas == null) ? 0 : numCas.hashCode());
        result = prime * result + ((poitageChariot == null) ? 0 : poitageChariot.hashCode());
        result = prime * result + ((poste == null) ? 0 : poste.hashCode());
        result = prime * result + ((prep == null) ? 0 : prep.hashCode());
        result = prime * result + ((prepara == null) ? 0 : prepara.hashCode());
        result = prime * result + ((prixAch == null) ? 0 : prixAch.hashCode());
        result = prime * result + ((prixHt == null) ? 0 : prixHt.hashCode());
        result = prime * result + ((qutLiv == null) ? 0 : qutLiv.hashCode());
        result = prime * result + ((qutPoint == null) ? 0 : qutPoint.hashCode());
        result = prime * result + ((qutPrep == null) ? 0 : qutPrep.hashCode());
        result = prime * result + ((remExp == null) ? 0 : remExp.hashCode());
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
        ArtPrep other = (ArtPrep) obj;
        if (artPrep_artTerm == null) {
            if (other.artPrep_artTerm != null)
                return false;
        } else if (!artPrep_artTerm.equals(other.artPrep_artTerm))
            return false;
        if (artprep_chariot == null) {
            if (other.artprep_chariot != null)
                return false;
        } else if (!artprep_chariot.equals(other.artprep_chariot))
            return false;
        if (avPrep == null) {
            if (other.avPrep != null)
                return false;
        } else if (!avPrep.equals(other.avPrep))
            return false;
        if (centre == null) {
            if (other.centre != null)
                return false;
        } else if (!centre.equals(other.centre))
            return false;
        if (chrono == null) {
            if (other.chrono != null)
                return false;
        } else if (!chrono.equals(other.chrono))
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
        if (datPrep == null) {
            if (other.datPrep != null)
                return false;
        } else if (!datPrep.equals(other.datPrep))
            return false;
        if (etage2 == null) {
            if (other.etage2 != null)
                return false;
        } else if (!etage2.equals(other.etage2))
            return false;
        if (id != other.id)
            return false;
        if (marge == null) {
            if (other.marge != null)
                return false;
        } else if (!marge.equals(other.marge))
            return false;
        if (nonTrouve == null) {
            if (other.nonTrouve != null)
                return false;
        } else if (!nonTrouve.equals(other.nonTrouve))
            return false;
        if (numBon == null) {
            if (other.numBon != null)
                return false;
        } else if (!numBon.equals(other.numBon))
            return false;
        if (numCas == null) {
            if (other.numCas != null)
                return false;
        } else if (!numCas.equals(other.numCas))
            return false;
        if (poitageChariot == null) {
            if (other.poitageChariot != null)
                return false;
        } else if (!poitageChariot.equals(other.poitageChariot))
            return false;
        if (poste == null) {
            if (other.poste != null)
                return false;
        } else if (!poste.equals(other.poste))
            return false;
        if (prep == null) {
            if (other.prep != null)
                return false;
        } else if (!prep.equals(other.prep))
            return false;
        if (prepara == null) {
            if (other.prepara != null)
                return false;
        } else if (!prepara.equals(other.prepara))
            return false;
        if (prixAch == null) {
            if (other.prixAch != null)
                return false;
        } else if (!prixAch.equals(other.prixAch))
            return false;
        if (prixHt == null) {
            if (other.prixHt != null)
                return false;
        } else if (!prixHt.equals(other.prixHt))
            return false;
        if (qutLiv == null) {
            if (other.qutLiv != null)
                return false;
        } else if (!qutLiv.equals(other.qutLiv))
            return false;
        if (qutPoint == null) {
            if (other.qutPoint != null)
                return false;
        } else if (!qutPoint.equals(other.qutPoint))
            return false;
        if (qutPrep == null) {
            if (other.qutPrep != null)
                return false;
        } else if (!qutPrep.equals(other.qutPrep))
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
        return "ArtPrep [artPrep_artTerm=" + artPrep_artTerm + ", artprep_chariot=" + artprep_chariot + ", avPrep="
                + avPrep + ", centre=" + centre + ", chrono=" + chrono + ", codArt=" + codArt + ", cumulRet=" + cumulRet
                + ", datPrep=" + datPrep + ", etage2=" + etage2 + ", id=" + id + ", marge=" + marge + ", nonTrouve="
                + nonTrouve + ", numBon=" + numBon + ", numCas=" + numCas
                + ", poitageChariot=" + poitageChariot + ", poste=" + poste + ", prep=" + prep + ", prepara=" + prepara
                + ", prixAch=" + prixAch + ", prixHt=" + prixHt + ", qutLiv=" + qutLiv + ", qutPoint=" + qutPoint
                + ", qutPrep=" + qutPrep + ", remExp=" + remExp + ", remise=" + remise + ", totHt=" + totHt + ", tva="
                + tva + "]";
    }

}
