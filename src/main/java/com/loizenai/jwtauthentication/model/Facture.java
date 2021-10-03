package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "facture", schema = "testbd")
public class Facture implements Serializable{

    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NUM_DOC")
    private String numDoc;

    private long codFrs;
    private BigDecimal totalHt;
    private BigDecimal totalRem;
    private BigDecimal totalNet;
    private BigDecimal totalTva;
    private BigDecimal totalFod;
    private BigDecimal totalTtc;
    private Timestamp datDoc;
    private BigDecimal totalRet;
    private String numCom;
    private String typDoc;
    private String regl;
    private BigDecimal timbre;
    private BigDecimal montReg;
    private BigDecimal totalDev;
    private String banque;
    private Timestamp echeance;
    private String objet;
    private String poste;
    private long codUser;




    /**start Fk  */


    
    @OneToMany(mappedBy = "facture", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<ArtTerm> artTerms;

    /**end Fk */
    public Facture(long id , String numDoc , long codFrs, BigDecimal totalHt, BigDecimal totalRem, BigDecimal totalNet, BigDecimal totalTva, BigDecimal totalFod, BigDecimal totalTtc, Timestamp datDoc, BigDecimal totalRet, String numCom, String typDoc, String regl, BigDecimal timbre, BigDecimal montReg, BigDecimal totalDev, String banque, Timestamp echeance, String objet, String poste, long codUser) {
        this.id = id;
        this.numDoc=numDoc;
        this.codFrs = codFrs;
        this.totalHt = totalHt;
        this.totalRem = totalRem;
        this.totalNet = totalNet;
        this.totalTva = totalTva;
        this.totalFod = totalFod;
        this.totalTtc = totalTtc;
        this.datDoc = datDoc;
        this.totalRet = totalRet;
        this.numCom = numCom;
        this.typDoc = typDoc;
        this.regl = regl;
        this.timbre = timbre;
        this.montReg = montReg;
        this.totalDev = totalDev;
        this.banque = banque;
        this.echeance = echeance;
        this.objet = objet;
        this.poste = poste;
        this.codUser = codUser;
    }

    public Facture() {

    }

    public Facture(long id, String numDoc, long codFrs, BigDecimal totalHt, BigDecimal totalRem, BigDecimal totalNet,
            BigDecimal totalTva, BigDecimal totalFod, BigDecimal totalTtc, Timestamp datDoc, BigDecimal totalRet,
            String numCom, String typDoc, String regl, BigDecimal timbre, BigDecimal montReg, BigDecimal totalDev,
            String banque, Timestamp echeance, String objet, String poste, long codUser, List<ArtTerm> artTerms) {
        this.id = id;
        this.numDoc = numDoc;
        this.codFrs = codFrs;
        this.totalHt = totalHt;
        this.totalRem = totalRem;
        this.totalNet = totalNet;
        this.totalTva = totalTva;
        this.totalFod = totalFod;
        this.totalTtc = totalTtc;
        this.datDoc = datDoc;
        this.totalRet = totalRet;
        this.numCom = numCom;
        this.typDoc = typDoc;
        this.regl = regl;
        this.timbre = timbre;
        this.montReg = montReg;
        this.totalDev = totalDev;
        this.banque = banque;
        this.echeance = echeance;
        this.objet = objet;
        this.poste = poste;
        this.codUser = codUser;
        this.artTerms = artTerms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
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
    @Column(name = "TOTAL_HT")
    public BigDecimal getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(BigDecimal totalHt) {
        this.totalHt = totalHt;
    }

    @Basic
    @Column(name = "TOTAL_REM")
    public BigDecimal getTotalRem() {
        return totalRem;
    }

    public void setTotalRem(BigDecimal totalRem) {
        this.totalRem = totalRem;
    }

    @Basic
    @Column(name = "TOTAL_NET")
    public BigDecimal getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(BigDecimal totalNet) {
        this.totalNet = totalNet;
    }

    @Basic
    @Column(name = "TOTAL_TVA")
    public BigDecimal getTotalTva() {
        return totalTva;
    }

    public void setTotalTva(BigDecimal totalTva) {
        this.totalTva = totalTva;
    }

    @Basic
    @Column(name = "TOTAL_FOD")
    public BigDecimal getTotalFod() {
        return totalFod;
    }

    public void setTotalFod(BigDecimal totalFod) {
        this.totalFod = totalFod;
    }

    @Basic
    @Column(name = "TOTAL_TTC")
    public BigDecimal getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(BigDecimal totalTtc) {
        this.totalTtc = totalTtc;
    }

    @Basic
    @Column(name = "DAT_DOC")
    public Timestamp getDatDoc() {
        return datDoc;
    }

    public void setDatDoc(Timestamp datDoc) {
        this.datDoc = datDoc;
    }

    @Basic
    @Column(name = "TOTAL_RET")
    public BigDecimal getTotalRet() {
        return totalRet;
    }

    public void setTotalRet(BigDecimal totalRet) {
        this.totalRet = totalRet;
    }

    @Basic
    @Column(name = "NUM_COM")
    public String getNumCom() {
        return numCom;
    }

    public void setNumCom(String numCom) {
        this.numCom = numCom;
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
    @Column(name = "REGL")
    public String getRegl() {
        return regl;
    }

    public void setRegl(String regl) {
        this.regl = regl;
    }

    @Basic
    @Column(name = "TIMBRE")
    public BigDecimal getTimbre() {
        return timbre;
    }

    public void setTimbre(BigDecimal timbre) {
        this.timbre = timbre;
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
    @Column(name = "TOTAL_DEV")
    public BigDecimal getTotalDev() {
        return totalDev;
    }

    public void setTotalDev(BigDecimal totalDev) {
        this.totalDev = totalDev;
    }

    @Basic
    @Column(name = "BANQUE")
    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    @Basic
    @Column(name = "ECHEANCE")
    public Timestamp getEcheance() {
        return echeance;
    }

    public void setEcheance(Timestamp echeance) {
        this.echeance = echeance;
    }

    @Basic
    @Column(name = "OBJET")
    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
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
    @Column(name = "COD_USER")
    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((banque == null) ? 0 : banque.hashCode());
        result = prime * result + (int) (codFrs ^ (codFrs >>> 32));
        result = prime * result + (int) (codUser ^ (codUser >>> 32));
        result = prime * result + ((datDoc == null) ? 0 : datDoc.hashCode());
        result = prime * result + ((echeance == null) ? 0 : echeance.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((montReg == null) ? 0 : montReg.hashCode());
        result = prime * result + ((numCom == null) ? 0 : numCom.hashCode());
        result = prime * result + ((numDoc == null) ? 0 : numDoc.hashCode());
        result = prime * result + ((objet == null) ? 0 : objet.hashCode());
        result = prime * result + ((poste == null) ? 0 : poste.hashCode());
        result = prime * result + ((regl == null) ? 0 : regl.hashCode());
        result = prime * result + ((timbre == null) ? 0 : timbre.hashCode());
        result = prime * result + ((totalDev == null) ? 0 : totalDev.hashCode());
        result = prime * result + ((totalFod == null) ? 0 : totalFod.hashCode());
        result = prime * result + ((totalHt == null) ? 0 : totalHt.hashCode());
        result = prime * result + ((totalNet == null) ? 0 : totalNet.hashCode());
        result = prime * result + ((totalRem == null) ? 0 : totalRem.hashCode());
        result = prime * result + ((totalRet == null) ? 0 : totalRet.hashCode());
        result = prime * result + ((totalTtc == null) ? 0 : totalTtc.hashCode());
        result = prime * result + ((totalTva == null) ? 0 : totalTva.hashCode());
        result = prime * result + ((typDoc == null) ? 0 : typDoc.hashCode());
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
        Facture other = (Facture) obj;
        if (banque == null) {
            if (other.banque != null)
                return false;
        } else if (!banque.equals(other.banque))
            return false;
        if (codFrs != other.codFrs)
            return false;
        if (codUser != other.codUser)
            return false;
        if (datDoc == null) {
            if (other.datDoc != null)
                return false;
        } else if (!datDoc.equals(other.datDoc))
            return false;
        if (echeance == null) {
            if (other.echeance != null)
                return false;
        } else if (!echeance.equals(other.echeance))
            return false;
        if (id != other.id)
            return false;
        if (montReg == null) {
            if (other.montReg != null)
                return false;
        } else if (!montReg.equals(other.montReg))
            return false;
        if (numCom == null) {
            if (other.numCom != null)
                return false;
        } else if (!numCom.equals(other.numCom))
            return false;
        if (numDoc == null) {
            if (other.numDoc != null)
                return false;
        } else if (!numDoc.equals(other.numDoc))
            return false;
        if (objet == null) {
            if (other.objet != null)
                return false;
        } else if (!objet.equals(other.objet))
            return false;
        if (poste == null) {
            if (other.poste != null)
                return false;
        } else if (!poste.equals(other.poste))
            return false;
        if (regl == null) {
            if (other.regl != null)
                return false;
        } else if (!regl.equals(other.regl))
            return false;
        if (timbre == null) {
            if (other.timbre != null)
                return false;
        } else if (!timbre.equals(other.timbre))
            return false;
        if (totalDev == null) {
            if (other.totalDev != null)
                return false;
        } else if (!totalDev.equals(other.totalDev))
            return false;
        if (totalFod == null) {
            if (other.totalFod != null)
                return false;
        } else if (!totalFod.equals(other.totalFod))
            return false;
        if (totalHt == null) {
            if (other.totalHt != null)
                return false;
        } else if (!totalHt.equals(other.totalHt))
            return false;
        if (totalNet == null) {
            if (other.totalNet != null)
                return false;
        } else if (!totalNet.equals(other.totalNet))
            return false;
        if (totalRem == null) {
            if (other.totalRem != null)
                return false;
        } else if (!totalRem.equals(other.totalRem))
            return false;
        if (totalRet == null) {
            if (other.totalRet != null)
                return false;
        } else if (!totalRet.equals(other.totalRet))
            return false;
        if (totalTtc == null) {
            if (other.totalTtc != null)
                return false;
        } else if (!totalTtc.equals(other.totalTtc))
            return false;
        if (totalTva == null) {
            if (other.totalTva != null)
                return false;
        } else if (!totalTva.equals(other.totalTva))
            return false;
        if (typDoc == null) {
            if (other.typDoc != null)
                return false;
        } else if (!typDoc.equals(other.typDoc))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Facture [banque=" + banque + ", codFrs=" + codFrs + ", codUser=" + codUser + ", datDoc=" + datDoc
                + ", echeance=" + echeance + ", id=" + id + ", montReg=" + montReg + ", numCom=" + numCom + ", numDoc="
                + numDoc + ", objet=" + objet + ", poste=" + poste + ", regl=" + regl + ", timbre=" + timbre
                + ", totalDev=" + totalDev + ", totalFod=" + totalFod + ", totalHt=" + totalHt + ", totalNet="
                + totalNet + ", totalRem=" + totalRem + ", totalRet=" + totalRet + ", totalTtc=" + totalTtc
                + ", totalTva=" + totalTva + ", typDoc=" + typDoc + "]";
    }

}
