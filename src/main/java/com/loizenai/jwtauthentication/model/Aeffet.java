package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Aeffet {
    private long id;
    private String docReg;
    private long codFrs;
    private BigDecimal montDoc;
    private Date datDoc;
    private Date echeance;
    private Date datVal;
    private String avisdb;
    private String typEf;
    private String bank;
    private BigDecimal fraisDb;
    private Date datAvd;
    private Boolean paye;
    private String numFac;
    private String nature;
    private String frsAff;
    private BigDecimal montDev;
    private String ordre;
    private Date datOrd;
    private Integer numHomo;
    private String compta;
    private String tresor;
    private String comptaS;
    private String comptaD;
    private BigDecimal interet;
    private BigDecimal commission;
    private BigDecimal tva;
    private BigDecimal totAvis;
    private Date datComp;
    private Date datComp2;
    private String poste;

    public Aeffet(String docReg, long codFrs, BigDecimal montDoc, Date datDoc, Date echeance, Date datVal, String avisdb, String typEf, String bank, BigDecimal fraisDb, Date datAvd, Boolean paye, String numFac, String nature, String frsAff, BigDecimal montDev, String ordre, Date datOrd, Integer numHomo, String compta, String tresor, String comptaS, String comptaD, BigDecimal interet, BigDecimal commission, BigDecimal tva, BigDecimal totAvis, Date datComp, Date datComp2, String poste) {
        this.docReg = docReg;
        this.codFrs = codFrs;
        this.montDoc = montDoc;
        this.datDoc = datDoc;
        this.echeance = echeance;
        this.datVal = datVal;
        this.avisdb = avisdb;
        this.typEf = typEf;
        this.bank = bank;
        this.fraisDb = fraisDb;
        this.datAvd = datAvd;
        this.paye = paye;
        this.numFac = numFac;
        this.nature = nature;
        this.frsAff = frsAff;
        this.montDev = montDev;
        this.ordre = ordre;
        this.datOrd = datOrd;
        this.numHomo = numHomo;
        this.compta = compta;
        this.tresor = tresor;
        this.comptaS = comptaS;
        this.comptaD = comptaD;
        this.interet = interet;
        this.commission = commission;
        this.tva = tva;
        this.totAvis = totAvis;
        this.datComp = datComp;
        this.datComp2 = datComp2;
        this.poste = poste;
    }

    public Aeffet() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "DOC_REG")
    public String getDocReg() {
        return docReg;
    }

    public void setDocReg(String docReg) {
        this.docReg = docReg;
    }

    @Column(name = "COD_FRS")
    public long getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(long codFrs) {
        this.codFrs = codFrs;
    }

    @Basic
    @Column(name = "MONT_DOC")
    public BigDecimal getMontDoc() {
        return montDoc;
    }

    public void setMontDoc(BigDecimal montDoc) {
        this.montDoc = montDoc;
    }

    @Basic
    @Column(name = "DAT_DOC")
    public Date getDatDoc() {
        return datDoc;
    }

    public void setDatDoc(Date datDoc) {
        this.datDoc = datDoc;
    }

    @Basic
    @Column(name = "ECHEANCE")
    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    @Basic
    @Column(name = "DAT_VAL")
    public Date getDatVal() {
        return datVal;
    }

    public void setDatVal(Date datVal) {
        this.datVal = datVal;
    }

    @Basic
    @Column(name = "AVISDB")
    public String getAvisdb() {
        return avisdb;
    }

    public void setAvisdb(String avisdb) {
        this.avisdb = avisdb;
    }

    @Basic
    @Column(name = "TYP_EF")
    public String getTypEf() {
        return typEf;
    }

    public void setTypEf(String typEf) {
        this.typEf = typEf;
    }

    @Basic
    @Column(name = "BANK")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "FRAIS_DB")
    public BigDecimal getFraisDb() {
        return fraisDb;
    }

    public void setFraisDb(BigDecimal fraisDb) {
        this.fraisDb = fraisDb;
    }

    @Basic
    @Column(name = "DAT_AVD")
    public Date getDatAvd() {
        return datAvd;
    }

    public void setDatAvd(Date datAvd) {
        this.datAvd = datAvd;
    }

    @Basic
    @Column(name = "PAYE")
    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
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
    @Column(name = "NATURE")
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Basic
    @Column(name = "FRS_AFF")
    public String getFrsAff() {
        return frsAff;
    }

    public void setFrsAff(String frsAff) {
        this.frsAff = frsAff;
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
    @Column(name = "ORDRE")
    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    @Basic
    @Column(name = "DAT_ORD")
    public Date getDatOrd() {
        return datOrd;
    }

    public void setDatOrd(Date datOrd) {
        this.datOrd = datOrd;
    }

    @Basic
    @Column(name = "NUM_HOMO")
    public Integer getNumHomo() {
        return numHomo;
    }

    public void setNumHomo(Integer numHomo) {
        this.numHomo = numHomo;
    }

    @Basic
    @Column(name = "COMPTA")
    public String getCompta() {
        return compta;
    }

    public void setCompta(String compta) {
        this.compta = compta;
    }

    @Basic
    @Column(name = "TRESOR")
    public String getTresor() {
        return tresor;
    }

    public void setTresor(String tresor) {
        this.tresor = tresor;
    }

    @Basic
    @Column(name = "COMPTA_S")
    public String getComptaS() {
        return comptaS;
    }

    public void setComptaS(String comptaS) {
        this.comptaS = comptaS;
    }

    @Basic
    @Column(name = "COMPTA_D")
    public String getComptaD() {
        return comptaD;
    }

    public void setComptaD(String comptaD) {
        this.comptaD = comptaD;
    }

    @Basic
    @Column(name = "INTERET")
    public BigDecimal getInteret() {
        return interet;
    }

    public void setInteret(BigDecimal interet) {
        this.interet = interet;
    }

    @Basic
    @Column(name = "COMMISSION")
    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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
    @Column(name = "TOT_AVIS")
    public BigDecimal getTotAvis() {
        return totAvis;
    }

    public void setTotAvis(BigDecimal totAvis) {
        this.totAvis = totAvis;
    }

    @Basic
    @Column(name = "DAT_COMP")
    public Date getDatComp() {
        return datComp;
    }

    public void setDatComp(Date datComp) {
        this.datComp = datComp;
    }

    @Basic
    @Column(name = "DAT_COMP2")
    public Date getDatComp2() {
        return datComp2;
    }

    public void setDatComp2(Date datComp2) {
        this.datComp2 = datComp2;
    }

    @Basic
    @Column(name = "POSTE")
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeffet aeffet = (Aeffet) o;
        return id == aeffet.id &&
                codFrs == aeffet.codFrs &&
                Objects.equals(docReg, aeffet.docReg) &&
                Objects.equals(montDoc, aeffet.montDoc) &&
                Objects.equals(datDoc, aeffet.datDoc) &&
                Objects.equals(echeance, aeffet.echeance) &&
                Objects.equals(datVal, aeffet.datVal) &&
                Objects.equals(avisdb, aeffet.avisdb) &&
                Objects.equals(typEf, aeffet.typEf) &&
                Objects.equals(bank, aeffet.bank) &&
                Objects.equals(fraisDb, aeffet.fraisDb) &&
                Objects.equals(datAvd, aeffet.datAvd) &&
                Objects.equals(paye, aeffet.paye) &&
                Objects.equals(numFac, aeffet.numFac) &&
                Objects.equals(nature, aeffet.nature) &&
                Objects.equals(frsAff, aeffet.frsAff) &&
                Objects.equals(montDev, aeffet.montDev) &&
                Objects.equals(ordre, aeffet.ordre) &&
                Objects.equals(datOrd, aeffet.datOrd) &&
                Objects.equals(numHomo, aeffet.numHomo) &&
                Objects.equals(compta, aeffet.compta) &&
                Objects.equals(tresor, aeffet.tresor) &&
                Objects.equals(comptaS, aeffet.comptaS) &&
                Objects.equals(comptaD, aeffet.comptaD) &&
                Objects.equals(interet, aeffet.interet) &&
                Objects.equals(commission, aeffet.commission) &&
                Objects.equals(tva, aeffet.tva) &&
                Objects.equals(totAvis, aeffet.totAvis) &&
                Objects.equals(datComp, aeffet.datComp) &&
                Objects.equals(datComp2, aeffet.datComp2) &&
                Objects.equals(poste, aeffet.poste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, docReg, codFrs, montDoc, datDoc, echeance, datVal, avisdb, typEf, bank, fraisDb, datAvd, paye, numFac, nature, frsAff, montDev, ordre, datOrd, numHomo, compta, tresor, comptaS, comptaD, interet, commission, tva, totAvis, datComp, datComp2, poste);
    }

    @Override
    public String toString() {
        return "Aeffet{" +
                "id=" + id +
                ", docReg='" + docReg + '\'' +
                ", codFrs=" + codFrs +
                ", montDoc=" + montDoc +
                ", datDoc=" + datDoc +
                ", echeance=" + echeance +
                ", datVal=" + datVal +
                ", avisdb='" + avisdb + '\'' +
                ", typEf='" + typEf + '\'' +
                ", bank='" + bank + '\'' +
                ", fraisDb=" + fraisDb +
                ", datAvd=" + datAvd +
                ", paye=" + paye +
                ", numFac='" + numFac + '\'' +
                ", nature='" + nature + '\'' +
                ", frsAff='" + frsAff + '\'' +
                ", montDev=" + montDev +
                ", ordre='" + ordre + '\'' +
                ", datOrd=" + datOrd +
                ", numHomo=" + numHomo +
                ", compta='" + compta + '\'' +
                ", tresor='" + tresor + '\'' +
                ", comptaS='" + comptaS + '\'' +
                ", comptaD='" + comptaD + '\'' +
                ", interet=" + interet +
                ", commission=" + commission +
                ", tva=" + tva +
                ", totAvis=" + totAvis +
                ", datComp=" + datComp +
                ", datComp2=" + datComp2 +
                ", poste='" + poste + '\'' +
                '}';
    }
}
