package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reg_frs", schema = "testbd")
public class RegFrs {
    private int num;
    private String nature;
    private String raison;
    private long codFrs;
    private BigDecimal montDev;
    private BigDecimal montDt;
    private String devise;
    private Date date;
    private Date echeance;
    private Date dateFac;
    private Short delai;
    private BigDecimal cours;
    private Boolean modif;
    private Boolean affecter;
    private String valider;
    private String fd;
    private String avisdb;
    private Date echeance2;
    private String ordre;
    private Date datAvd;
    private BigDecimal fraisDb;
    private BigDecimal commission;
    private BigDecimal tva;
    private BigDecimal interet;
    private BigDecimal totAvis;
    private String banqueFin;
    private String comptaFin;
    private String comptaD;
    private Date dateComp1;
    private Date dateComp2;
    private BigDecimal cours2;
    private BigDecimal montDt2;
    private String ordonne;
    private String poste;
    private BigDecimal anMontdev;
    private long numAff;
    private long codUser;

    public RegFrs(String nature, String raison, long codFrs, BigDecimal montDev, BigDecimal montDt, String devise, Date date, Date echeance, Date dateFac, Short delai, BigDecimal cours, Boolean modif, Boolean affecter, String valider, String fd, String avisdb, Date echeance2, String ordre, Date datAvd, BigDecimal fraisDb, BigDecimal commission, BigDecimal tva, BigDecimal interet, BigDecimal totAvis, String banqueFin, String comptaFin, String comptaD, Date dateComp1, Date dateComp2, BigDecimal cours2, BigDecimal montDt2, String ordonne, String poste, BigDecimal anMontdev, long numAff, long codUser) {
        this.nature = nature;
        this.raison = raison;
        this.codFrs = codFrs;
        this.montDev = montDev;
        this.montDt = montDt;
        this.devise = devise;
        this.date = date;
        this.echeance = echeance;
        this.dateFac = dateFac;
        this.delai = delai;
        this.cours = cours;
        this.modif = modif;
        this.affecter = affecter;
        this.valider = valider;
        this.fd = fd;
        this.avisdb = avisdb;
        this.echeance2 = echeance2;
        this.ordre = ordre;
        this.datAvd = datAvd;
        this.fraisDb = fraisDb;
        this.commission = commission;
        this.tva = tva;
        this.interet = interet;
        this.totAvis = totAvis;
        this.banqueFin = banqueFin;
        this.comptaFin = comptaFin;
        this.comptaD = comptaD;
        this.dateComp1 = dateComp1;
        this.dateComp2 = dateComp2;
        this.cours2 = cours2;
        this.montDt2 = montDt2;
        this.ordonne = ordonne;
        this.poste = poste;
        this.anMontdev = anMontdev;
        this.numAff = numAff;
        this.codUser = codUser;
    }

    public RegFrs() {

    }

    @Id
    @Column(name = "NUM")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
    @Column(name = "RAISON")
    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
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
    @Column(name = "DEVISE")
    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
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
    @Column(name = "DATE_FAC")
    public Date getDateFac() {
        return dateFac;
    }

    public void setDateFac(Date dateFac) {
        this.dateFac = dateFac;
    }

    @Basic
    @Column(name = "DELAI")
    public Short getDelai() {
        return delai;
    }

    public void setDelai(Short delai) {
        this.delai = delai;
    }

    @Basic
    @Column(name = "COURS")
    public BigDecimal getCours() {
        return cours;
    }

    public void setCours(BigDecimal cours) {
        this.cours = cours;
    }

    @Basic
    @Column(name = "MODIF")
    public Boolean getModif() {
        return modif;
    }

    public void setModif(Boolean modif) {
        this.modif = modif;
    }

    @Basic
    @Column(name = "AFFECTER")
    public Boolean getAffecter() {
        return affecter;
    }

    public void setAffecter(Boolean affecter) {
        this.affecter = affecter;
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
    @Column(name = "FD")
    public String getFd() {
        return fd;
    }

    public void setFd(String fd) {
        this.fd = fd;
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
    @Column(name = "ECHEANCE2")
    public Date getEcheance2() {
        return echeance2;
    }

    public void setEcheance2(Date echeance2) {
        this.echeance2 = echeance2;
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
    @Column(name = "BANQUE_FIN")
    public String getBanqueFin() {
        return banqueFin;
    }

    public void setBanqueFin(String banqueFin) {
        this.banqueFin = banqueFin;
    }

    @Basic
    @Column(name = "COMPTA_FIN")
    public String getComptaFin() {
        return comptaFin;
    }

    public void setComptaFin(String comptaFin) {
        this.comptaFin = comptaFin;
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
    @Column(name = "DATE_COMP1")
    public Date getDateComp1() {
        return dateComp1;
    }

    public void setDateComp1(Date dateComp1) {
        this.dateComp1 = dateComp1;
    }

    @Basic
    @Column(name = "DATE_COMP2")
    public Date getDateComp2() {
        return dateComp2;
    }

    public void setDateComp2(Date dateComp2) {
        this.dateComp2 = dateComp2;
    }

    @Basic
    @Column(name = "COURS2")
    public BigDecimal getCours2() {
        return cours2;
    }

    public void setCours2(BigDecimal cours2) {
        this.cours2 = cours2;
    }

    @Basic
    @Column(name = "MONT_DT2")
    public BigDecimal getMontDt2() {
        return montDt2;
    }

    public void setMontDt2(BigDecimal montDt2) {
        this.montDt2 = montDt2;
    }

    @Basic
    @Column(name = "ORDONNE")
    public String getOrdonne() {
        return ordonne;
    }

    public void setOrdonne(String ordonne) {
        this.ordonne = ordonne;
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
    @Column(name = "AN_MONTDEV")
    public BigDecimal getAnMontdev() {
        return anMontdev;
    }

    public void setAnMontdev(BigDecimal anMontdev) {
        this.anMontdev = anMontdev;
    }

    @Basic
    @Column(name = "NUM_AFF")
    public long getNumAff() {
        return numAff;
    }

    public void setNumAff(long numAff) {
        this.numAff = numAff;
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
        RegFrs regFrs = (RegFrs) o;
        return num == regFrs.num &&
                codFrs == regFrs.codFrs &&
                numAff == regFrs.numAff &&
                codUser == regFrs.codUser &&
                Objects.equals(nature, regFrs.nature) &&
                Objects.equals(raison, regFrs.raison) &&
                Objects.equals(montDev, regFrs.montDev) &&
                Objects.equals(montDt, regFrs.montDt) &&
                Objects.equals(devise, regFrs.devise) &&
                Objects.equals(date, regFrs.date) &&
                Objects.equals(echeance, regFrs.echeance) &&
                Objects.equals(dateFac, regFrs.dateFac) &&
                Objects.equals(delai, regFrs.delai) &&
                Objects.equals(cours, regFrs.cours) &&
                Objects.equals(modif, regFrs.modif) &&
                Objects.equals(affecter, regFrs.affecter) &&
                Objects.equals(valider, regFrs.valider) &&
                Objects.equals(fd, regFrs.fd) &&
                Objects.equals(avisdb, regFrs.avisdb) &&
                Objects.equals(echeance2, regFrs.echeance2) &&
                Objects.equals(ordre, regFrs.ordre) &&
                Objects.equals(datAvd, regFrs.datAvd) &&
                Objects.equals(fraisDb, regFrs.fraisDb) &&
                Objects.equals(commission, regFrs.commission) &&
                Objects.equals(tva, regFrs.tva) &&
                Objects.equals(interet, regFrs.interet) &&
                Objects.equals(totAvis, regFrs.totAvis) &&
                Objects.equals(banqueFin, regFrs.banqueFin) &&
                Objects.equals(comptaFin, regFrs.comptaFin) &&
                Objects.equals(comptaD, regFrs.comptaD) &&
                Objects.equals(dateComp1, regFrs.dateComp1) &&
                Objects.equals(dateComp2, regFrs.dateComp2) &&
                Objects.equals(cours2, regFrs.cours2) &&
                Objects.equals(montDt2, regFrs.montDt2) &&
                Objects.equals(ordonne, regFrs.ordonne) &&
                Objects.equals(poste, regFrs.poste) &&
                Objects.equals(anMontdev, regFrs.anMontdev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, nature, raison, codFrs, montDev, montDt, devise, date, echeance, dateFac, delai, cours, modif, affecter, valider, fd, avisdb, echeance2, ordre, datAvd, fraisDb, commission, tva, interet, totAvis, banqueFin, comptaFin, comptaD, dateComp1, dateComp2, cours2, montDt2, ordonne, poste, anMontdev, numAff, codUser);
    }

    @Override
    public String toString() {
        return "RegFrs{" +
                "num=" + num +
                ", nature='" + nature + '\'' +
                ", raison='" + raison + '\'' +
                ", codFrs=" + codFrs +
                ", montDev=" + montDev +
                ", montDt=" + montDt +
                ", devise='" + devise + '\'' +
                ", date=" + date +
                ", echeance=" + echeance +
                ", dateFac=" + dateFac +
                ", delai=" + delai +
                ", cours=" + cours +
                ", modif=" + modif +
                ", affecter=" + affecter +
                ", valider='" + valider + '\'' +
                ", fd='" + fd + '\'' +
                ", avisdb='" + avisdb + '\'' +
                ", echeance2=" + echeance2 +
                ", ordre='" + ordre + '\'' +
                ", datAvd=" + datAvd +
                ", fraisDb=" + fraisDb +
                ", commission=" + commission +
                ", tva=" + tva +
                ", interet=" + interet +
                ", totAvis=" + totAvis +
                ", banqueFin='" + banqueFin + '\'' +
                ", comptaFin='" + comptaFin + '\'' +
                ", comptaD='" + comptaD + '\'' +
                ", dateComp1=" + dateComp1 +
                ", dateComp2=" + dateComp2 +
                ", cours2=" + cours2 +
                ", montDt2=" + montDt2 +
                ", ordonne='" + ordonne + '\'' +
                ", poste='" + poste + '\'' +
                ", anMontdev=" + anMontdev +
                ", numAff=" + numAff +
                ", codUser=" + codUser +
                '}';
    }
}
