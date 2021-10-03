package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "fin_douane", schema = "testbd")
public class FinDouane {
    private long num;
    private String banque;
    private String codFin;
    private long codFrs;
    private String raison;
    private BigDecimal montant;
    private Date date;
    private Date echeance;
    private String compta;
    private Date datCompta;
    private String affecte;
    private String avisdb;
    private String ordre;
    private Date datAvd;
    private BigDecimal fraisDb;
    private BigDecimal commission;
    private BigDecimal tva;
    private BigDecimal interet;
    private BigDecimal totAvis;
    private String numDec;
    private String valider;
    private String annuler;
    private long codUser;

    public FinDouane(String banque, String codFin, long codFrs, String raison, BigDecimal montant, Date date, Date echeance, String compta, Date datCompta, String affecte, String avisdb, String ordre, Date datAvd, BigDecimal fraisDb, BigDecimal commission, BigDecimal tva, BigDecimal interet, BigDecimal totAvis, String numDec, String valider, String annuler, long codUser) {
        this.banque = banque;
        this.codFin = codFin;
        this.codFrs = codFrs;
        this.raison = raison;
        this.montant = montant;
        this.date = date;
        this.echeance = echeance;
        this.compta = compta;
        this.datCompta = datCompta;
        this.affecte = affecte;
        this.avisdb = avisdb;
        this.ordre = ordre;
        this.datAvd = datAvd;
        this.fraisDb = fraisDb;
        this.commission = commission;
        this.tva = tva;
        this.interet = interet;
        this.totAvis = totAvis;
        this.numDec = numDec;
        this.valider = valider;
        this.annuler = annuler;
        this.codUser = codUser;
    }

    public FinDouane() {

    }

    @Id
    @Column(name = "NUM")
    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
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
    @Column(name = "COD_FIN")
    public String getCodFin() {
        return codFin;
    }

    public void setCodFin(String codFin) {
        this.codFin = codFin;
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
    @Column(name = "MONTANT")
    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    @Column(name = "COMPTA")
    public String getCompta() {
        return compta;
    }

    public void setCompta(String compta) {
        this.compta = compta;
    }

    @Basic
    @Column(name = "DAT_COMPTA")
    public Date getDatCompta() {
        return datCompta;
    }

    public void setDatCompta(Date datCompta) {
        this.datCompta = datCompta;
    }

    @Basic
    @Column(name = "AFFECTE")
    public String getAffecte() {
        return affecte;
    }

    public void setAffecte(String affecte) {
        this.affecte = affecte;
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
    @Column(name = "ORDRE")
    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
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
    @Column(name = "FRAIS_DB")
    public BigDecimal getFraisDb() {
        return fraisDb;
    }

    public void setFraisDb(BigDecimal fraisDb) {
        this.fraisDb = fraisDb;
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
    @Column(name = "INTERET")
    public BigDecimal getInteret() {
        return interet;
    }

    public void setInteret(BigDecimal interet) {
        this.interet = interet;
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
    @Column(name = "NUM_DEC")
    public String getNumDec() {
        return numDec;
    }

    public void setNumDec(String numDec) {
        this.numDec = numDec;
    }

    @Basic
    @Column(name = "VALIDER")
    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    @Basic
    @Column(name = "ANNULER")
    public String getAnnuler() {
        return annuler;
    }

    public void setAnnuler(String annuler) {
        this.annuler = annuler;
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
        FinDouane finDouane = (FinDouane) o;
        return num == finDouane.num &&
                codFrs == finDouane.codFrs &&
                codUser == finDouane.codUser &&
                Objects.equals(banque, finDouane.banque) &&
                Objects.equals(codFin, finDouane.codFin) &&
                Objects.equals(raison, finDouane.raison) &&
                Objects.equals(montant, finDouane.montant) &&
                Objects.equals(date, finDouane.date) &&
                Objects.equals(echeance, finDouane.echeance) &&
                Objects.equals(compta, finDouane.compta) &&
                Objects.equals(datCompta, finDouane.datCompta) &&
                Objects.equals(affecte, finDouane.affecte) &&
                Objects.equals(avisdb, finDouane.avisdb) &&
                Objects.equals(ordre, finDouane.ordre) &&
                Objects.equals(datAvd, finDouane.datAvd) &&
                Objects.equals(fraisDb, finDouane.fraisDb) &&
                Objects.equals(commission, finDouane.commission) &&
                Objects.equals(tva, finDouane.tva) &&
                Objects.equals(interet, finDouane.interet) &&
                Objects.equals(totAvis, finDouane.totAvis) &&
                Objects.equals(numDec, finDouane.numDec) &&
                Objects.equals(valider, finDouane.valider) &&
                Objects.equals(annuler, finDouane.annuler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, banque, codFin, codFrs, raison, montant, date, echeance, compta, datCompta, affecte, avisdb, ordre, datAvd, fraisDb, commission, tva, interet, totAvis, numDec, valider, annuler, codUser);
    }

    @Override
    public String toString() {
        return "FinDouane{" +
                "num=" + num +
                ", banque='" + banque + '\'' +
                ", codFin='" + codFin + '\'' +
                ", codFrs=" + codFrs +
                ", raison='" + raison + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", echeance=" + echeance +
                ", compta='" + compta + '\'' +
                ", datCompta=" + datCompta +
                ", affecte='" + affecte + '\'' +
                ", avisdb='" + avisdb + '\'' +
                ", ordre='" + ordre + '\'' +
                ", datAvd=" + datAvd +
                ", fraisDb=" + fraisDb +
                ", commission=" + commission +
                ", tva=" + tva +
                ", interet=" + interet +
                ", totAvis=" + totAvis +
                ", numDec='" + numDec + '\'' +
                ", valider='" + valider + '\'' +
                ", annuler='" + annuler + '\'' +
                ", codUser=" + codUser +
                '}';
    }
}
