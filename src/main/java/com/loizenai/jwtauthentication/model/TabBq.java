package com.loizenai.jwtauthentication.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tab_bq", schema = "testbd", catalog = "")
public class TabBq {
    private long id;
    private String bank;
    private String abrevbank;
    private String compte;
    private String compteEsp;
    private String compteFin;
    private String journal;
    private String rapChq;
    private String rapEff;
    private BigDecimal plafond;
    private String rib;
    private String actif;
    private Long decouvert;
    private Long autoriLc;
    private Long autoriFd;
    private Long autoriEsc;
    private Long autoriDd;
    private Long autoriFc;
    private Long soldeOuv;
    private Long autoriChq;
    private Long autoriCd;
    private Long autoriEng;
    private Short nb;
    private String libelle;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "ABREVBANK")
    public String getAbrevbank() {
        return abrevbank;
    }

    public void setAbrevbank(String abrevbank) {
        this.abrevbank = abrevbank;
    }

    @Basic
    @Column(name = "COMPTE")
    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    @Basic
    @Column(name = "COMPTE_ESP")
    public String getCompteEsp() {
        return compteEsp;
    }

    public void setCompteEsp(String compteEsp) {
        this.compteEsp = compteEsp;
    }

    @Basic
    @Column(name = "COMPTE_FIN")
    public String getCompteFin() {
        return compteFin;
    }

    public void setCompteFin(String compteFin) {
        this.compteFin = compteFin;
    }

    @Basic
    @Column(name = "JOURNAL")
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    @Basic
    @Column(name = "RAP_CHQ")
    public String getRapChq() {
        return rapChq;
    }

    public void setRapChq(String rapChq) {
        this.rapChq = rapChq;
    }

    @Basic
    @Column(name = "RAP_EFF")
    public String getRapEff() {
        return rapEff;
    }

    public void setRapEff(String rapEff) {
        this.rapEff = rapEff;
    }

    @Basic
    @Column(name = "PLAFOND")
    public BigDecimal getPlafond() {
        return plafond;
    }

    public void setPlafond(BigDecimal plafond) {
        this.plafond = plafond;
    }

    @Basic
    @Column(name = "RIB")
    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    @Basic
    @Column(name = "ACTIF")
    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    @Basic
    @Column(name = "DECOUVERT")
    public Long getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Long decouvert) {
        this.decouvert = decouvert;
    }

    @Basic
    @Column(name = "AUTORI_LC")
    public Long getAutoriLc() {
        return autoriLc;
    }

    public void setAutoriLc(Long autoriLc) {
        this.autoriLc = autoriLc;
    }

    @Basic
    @Column(name = "AUTORI_FD")
    public Long getAutoriFd() {
        return autoriFd;
    }

    public void setAutoriFd(Long autoriFd) {
        this.autoriFd = autoriFd;
    }

    @Basic
    @Column(name = "AUTORI_ESC")
    public Long getAutoriEsc() {
        return autoriEsc;
    }

    public void setAutoriEsc(Long autoriEsc) {
        this.autoriEsc = autoriEsc;
    }

    @Basic
    @Column(name = "AUTORI_DD")
    public Long getAutoriDd() {
        return autoriDd;
    }

    public void setAutoriDd(Long autoriDd) {
        this.autoriDd = autoriDd;
    }

    @Basic
    @Column(name = "AUTORI_FC")
    public Long getAutoriFc() {
        return autoriFc;
    }

    public void setAutoriFc(Long autoriFc) {
        this.autoriFc = autoriFc;
    }

    @Basic
    @Column(name = "SOLDE_OUV")
    public Long getSoldeOuv() {
        return soldeOuv;
    }

    public void setSoldeOuv(Long soldeOuv) {
        this.soldeOuv = soldeOuv;
    }

    @Basic
    @Column(name = "AUTORI_CHQ")
    public Long getAutoriChq() {
        return autoriChq;
    }

    public void setAutoriChq(Long autoriChq) {
        this.autoriChq = autoriChq;
    }

    @Basic
    @Column(name = "AUTORI_CD")
    public Long getAutoriCd() {
        return autoriCd;
    }

    public void setAutoriCd(Long autoriCd) {
        this.autoriCd = autoriCd;
    }

    @Basic
    @Column(name = "AUTORI_ENG")
    public Long getAutoriEng() {
        return autoriEng;
    }

    public void setAutoriEng(Long autoriEng) {
        this.autoriEng = autoriEng;
    }

    @Basic
    @Column(name = "NB")
    public Short getNb() {
        return nb;
    }

    public void setNb(Short nb) {
        this.nb = nb;
    }

    @Basic
    @Column(name = "LIBELLE")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabBq tabBq = (TabBq) o;
        return id == tabBq.id &&
                Objects.equals(bank, tabBq.bank) &&
                Objects.equals(abrevbank, tabBq.abrevbank) &&
                Objects.equals(compte, tabBq.compte) &&
                Objects.equals(compteEsp, tabBq.compteEsp) &&
                Objects.equals(compteFin, tabBq.compteFin) &&
                Objects.equals(journal, tabBq.journal) &&
                Objects.equals(rapChq, tabBq.rapChq) &&
                Objects.equals(rapEff, tabBq.rapEff) &&
                Objects.equals(plafond, tabBq.plafond) &&
                Objects.equals(rib, tabBq.rib) &&
                Objects.equals(actif, tabBq.actif) &&
                Objects.equals(decouvert, tabBq.decouvert) &&
                Objects.equals(autoriLc, tabBq.autoriLc) &&
                Objects.equals(autoriFd, tabBq.autoriFd) &&
                Objects.equals(autoriEsc, tabBq.autoriEsc) &&
                Objects.equals(autoriDd, tabBq.autoriDd) &&
                Objects.equals(autoriFc, tabBq.autoriFc) &&
                Objects.equals(soldeOuv, tabBq.soldeOuv) &&
                Objects.equals(autoriChq, tabBq.autoriChq) &&
                Objects.equals(autoriCd, tabBq.autoriCd) &&
                Objects.equals(autoriEng, tabBq.autoriEng) &&
                Objects.equals(nb, tabBq.nb) &&
                Objects.equals(libelle, tabBq.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bank, abrevbank, compte, compteEsp, compteFin, journal, rapChq, rapEff, plafond, rib, actif, decouvert, autoriLc, autoriFd, autoriEsc, autoriDd, autoriFc, soldeOuv, autoriChq, autoriCd, autoriEng, nb, libelle);
    }
}
