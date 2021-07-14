package com.loizenai.jwtauthentication.message.request;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

public class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstname;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastname;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;





    private Timestamp dateDeNaissance;
    private int cin;
    private String address;
    private int cps;
    private int telephone;
    private String pseudo;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateRec;

    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;
    public enum TypeContrat{
        CDI,
        CDD,
        CTT,
        C_en_Alternance;
    }

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateContrat;


    private String famille;
    private Float salaire;

    private Float primeDeRendement;

    @Basic
    @DateTimeFormat(pattern = "HH:mm")
    private Timestamp heuresDeTravail;

    @Basic
    private int venteParHeure;

    @Basic
    private Float objectifParJour;

    @Basic
    private Float objectifParMois;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateDebutConge;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateFinConge;

    @Enumerated(EnumType.STRING)
    private TypeConge typeConge;
    public enum TypeConge{
        maternite,
        maladie,
        reduire,
        sans_solde,
        deces,
        annuel;
    }
    
    @Basic
    private Float primeDev;

    @Basic
    private Float primeGlobal;

    @Basic
    private Float primeParClient;

    @Basic
    private Float primeStock;
    private String postV;

    private long codUser;
    private String raison;
    private String rc;
    private String respon1;
    private String fonction1;
    private String faxs;
    private String adrSiege;
    private String ruel;
    private String numRuel;
    private String cpl;
    private String villel;
    private String regionl;
    private String tell;
    private String faxl;
    private String adrLiv;
    private String region;
    private String taxe;
    private String ccb1;
    private String bank1;
    private String agence1;
    private String garanties;
    private String codGrp;
    private String modReg;
    private String domBan;
    private Short echeance;
    private BigDecimal crMax;
    private Timestamp derMvt;
    private BigDecimal credit;
    private BigDecimal preVen;
    private BigDecimal cumulAch;
    private BigDecimal chifAff1;
    private BigDecimal chifAff2;
    private BigDecimal chifAff3;
    private BigDecimal tauxRem;
    private BigDecimal tauxCom;
    private BigDecimal reste;
    private Byte tauxRes;
    private BigDecimal valRes;
    private String patron;
    private Short rang;
    private BigDecimal impaye;
    private BigDecimal chqImpaye;
    private BigDecimal efPort;
    private BigDecimal efBanque;
    private BigDecimal efNrecu;
    private BigDecimal avCom;
    private String caution;
    private BigDecimal benefice;
    private BigDecimal tauxBene;
    private BigDecimal recFff;
    private BigDecimal tva;
    private Byte cle;
    private BigDecimal soldDep;
    private BigDecimal interet;
    private BigDecimal regChq;
    private BigDecimal regEff;
    private BigDecimal regEsp;
    private BigDecimal facInst;
    private BigDecimal avoir;
    private BigDecimal effInst;
    private BigDecimal soldeBq;
    private BigDecimal creance;
    private BigDecimal effEnc;
    private BigDecimal effEsc;
    private BigDecimal comission;
    private String bloc;
    private String codeTva;
    private BigDecimal remOrg;
    private BigDecimal avance;
    private BigDecimal chqPf;
    private BigDecimal retenue;
    private BigDecimal regVir;
    private BigDecimal avN1;
    private String classe;
    private BigDecimal ristourne;
    private BigDecimal caPrev;
    private BigDecimal soldeCpf;
    private BigDecimal soldeImp;
    private Long soldeEpf;
    private Timestamp datFFac;
    private String datGFac;
    private BigDecimal caMens;
    private BigDecimal crImax;

    private String zone;
    
    private BigDecimal fcreN1;
    private BigDecimal fcreN2;
    private BigDecimal freglN1;
    private BigDecimal freglN2;
    private BigDecimal fescN1;
    private BigDecimal fescN2;
    private BigDecimal fbkN1;
    private BigDecimal fbkN2;
    private BigDecimal fefpN1;
    private BigDecimal fefpN2;
    private BigDecimal fchpN1;
    private BigDecimal fchpN2;
    private BigDecimal fefnrN1;
    private BigDecimal fefnrN2;
    private BigDecimal icreN1;
    private BigDecimal icreN2;
    private BigDecimal ireglN1;
    private BigDecimal ireglN2;
    private BigDecimal iescN1;
    private BigDecimal iescN2;
    private BigDecimal ibkN1;
    private BigDecimal ibkN2;
    private BigDecimal iefpN1;
    private BigDecimal iefpN2;
    private BigDecimal ichpN1;
    private BigDecimal ichpN2;
    private BigDecimal iefnrN1;
    private BigDecimal iefnrN2;
    private String datOuvr;
    private String command;
    private BigDecimal remExp;
    private String chefMag;
    private String jourVisit;
    private Boolean instance;
    private Boolean comptant;
    private Boolean bl;
    private String natLiv;
    private BigDecimal mois1;
    private BigDecimal mois2;
    private BigDecimal mois3;
    private BigDecimal mois4;
    private BigDecimal mois5;
    private BigDecimal mois6;
    private BigDecimal mois7;
    private BigDecimal mois8;
    private BigDecimal mois9;
    private BigDecimal mois10;
    private BigDecimal mois11;
    private BigDecimal mois12;
    private String datDerLi;
    private BigDecimal margePour;
    private BigDecimal margeVal;
    private BigDecimal credblEnc;
    private BigDecimal credinstec;
    private String observatio;
    private String observ;
    private String gouv1;
    private String gouv2;
    private String natcaution;
    private Boolean cheque;
    private Boolean espece;
    private Boolean traite;
    private BigDecimal crRef;
    private BigDecimal soldTerm;
    private BigDecimal chqImp;
    private BigDecimal criRef;
    private String remFam;
    private Boolean reglement;
    private Short delai;
    private Byte nbTranche;
    private String codSteq;
    private BigDecimal reference;
    private String sansRet;
    private String cliGroup;
    private BigDecimal tauxMarge;
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
    	return this.role;
    }
    
    public void setRole(Set<String> role) {
    	this.role = role;
    }

    public Timestamp getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Timestamp dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCps() {
        return cps;
    }

    public void setCps(int cps) {
        this.cps = cps;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Timestamp getDateRec() {
        return dateRec;
    }

    public void setDateRec(Timestamp dateRec) {
        this.dateRec = dateRec;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Timestamp getDateContrat() {
        return dateContrat;
    }

    public void setDateContrat(Timestamp dateContrat) {
        this.dateContrat = dateContrat;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public Float getPrimeDeRendement() {
        return primeDeRendement;
    }

    public void setPrimeDeRendement(Float primeDeRendement) {
        this.primeDeRendement = primeDeRendement;
    }

    public Timestamp getHeuresDeTravail() {
        return heuresDeTravail;
    }

    public void setHeuresDeTravail(Timestamp heuresDeTravail) {
        this.heuresDeTravail = heuresDeTravail;
    }

    public int getVenteParHeure() {
        return venteParHeure;
    }

    public void setVenteParHeure(int venteParHeure) {
        this.venteParHeure = venteParHeure;
    }

    public Float getObjectifParJour() {
        return objectifParJour;
    }

    public void setObjectifParJour(Float objectifParJour) {
        this.objectifParJour = objectifParJour;
    }

    public Float getObjectifParMois() {
        return objectifParMois;
    }

    public void setObjectifParMois(Float objectifParMois) {
        this.objectifParMois = objectifParMois;
    }

    public Timestamp getDateDebutConge() {
        return dateDebutConge;
    }

    public void setDateDebutConge(Timestamp dateDebutConge) {
        this.dateDebutConge = dateDebutConge;
    }

    public Timestamp getDateFinConge() {
        return dateFinConge;
    }

    public void setDateFinConge(Timestamp dateFinConge) {
        this.dateFinConge = dateFinConge;
    }

    public TypeConge getTypeConge() {
        return typeConge;
    }

    public void setTypeConge(TypeConge typeConge) {
        this.typeConge = typeConge;
    }

    public Float getPrimeDev() {
        return primeDev;
    }

    public void setPrimeDev(Float primeDev) {
        this.primeDev = primeDev;
    }

    public Float getPrimeGlobal() {
        return primeGlobal;
    }

    public void setPrimeGlobal(Float primeGlobal) {
        this.primeGlobal = primeGlobal;
    }

    public Float getPrimeParClient() {
        return primeParClient;
    }

    public void setPrimeParClient(Float primeParClient) {
        this.primeParClient = primeParClient;
    }

    public Float getPrimeStock() {
        return primeStock;
    }

    public void setPrimeStock(Float primeStock) {
        this.primeStock = primeStock;
    }

    public String getPostV() {
        return postV;
    }

    public void setPostV(String postV) {
        this.postV = postV;
    }

    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRespon1() {
        return respon1;
    }

    public void setRespon1(String respon1) {
        this.respon1 = respon1;
    }

    public String getFonction1() {
        return fonction1;
    }

    public void setFonction1(String fonction1) {
        this.fonction1 = fonction1;
    }

    public String getFaxs() {
        return faxs;
    }

    public void setFaxs(String faxs) {
        this.faxs = faxs;
    }

    public String getAdrSiege() {
        return adrSiege;
    }

    public void setAdrSiege(String adrSiege) {
        this.adrSiege = adrSiege;
    }

    public String getRuel() {
        return ruel;
    }

    public void setRuel(String ruel) {
        this.ruel = ruel;
    }

    public String getNumRuel() {
        return numRuel;
    }

    public void setNumRuel(String numRuel) {
        this.numRuel = numRuel;
    }

    public String getCpl() {
        return cpl;
    }

    public void setCpl(String cpl) {
        this.cpl = cpl;
    }

    public String getVillel() {
        return villel;
    }

    public void setVillel(String villel) {
        this.villel = villel;
    }

    public String getRegionl() {
        return regionl;
    }

    public void setRegionl(String regionl) {
        this.regionl = regionl;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getFaxl() {
        return faxl;
    }

    public void setFaxl(String faxl) {
        this.faxl = faxl;
    }

    public String getAdrLiv() {
        return adrLiv;
    }

    public void setAdrLiv(String adrLiv) {
        this.adrLiv = adrLiv;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTaxe() {
        return taxe;
    }

    public void setTaxe(String taxe) {
        this.taxe = taxe;
    }

    public String getCcb1() {
        return ccb1;
    }

    public void setCcb1(String ccb1) {
        this.ccb1 = ccb1;
    }

    public String getBank1() {
        return bank1;
    }

    public void setBank1(String bank1) {
        this.bank1 = bank1;
    }

    public String getAgence1() {
        return agence1;
    }

    public void setAgence1(String agence1) {
        this.agence1 = agence1;
    }

    public String getGaranties() {
        return garanties;
    }

    public void setGaranties(String garanties) {
        this.garanties = garanties;
    }

    public String getCodGrp() {
        return codGrp;
    }

    public void setCodGrp(String codGrp) {
        this.codGrp = codGrp;
    }

    public String getModReg() {
        return modReg;
    }

    public void setModReg(String modReg) {
        this.modReg = modReg;
    }

    public String getDomBan() {
        return domBan;
    }

    public void setDomBan(String domBan) {
        this.domBan = domBan;
    }

    public Short getEcheance() {
        return echeance;
    }

    public void setEcheance(Short echeance) {
        this.echeance = echeance;
    }

    public BigDecimal getCrMax() {
        return crMax;
    }

    public void setCrMax(BigDecimal crMax) {
        this.crMax = crMax;
    }

    public Timestamp getDerMvt() {
        return derMvt;
    }

    public void setDerMvt(Timestamp derMvt) {
        this.derMvt = derMvt;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getPreVen() {
        return preVen;
    }

    public void setPreVen(BigDecimal preVen) {
        this.preVen = preVen;
    }

    public BigDecimal getCumulAch() {
        return cumulAch;
    }

    public void setCumulAch(BigDecimal cumulAch) {
        this.cumulAch = cumulAch;
    }

    public BigDecimal getChifAff1() {
        return chifAff1;
    }

    public void setChifAff1(BigDecimal chifAff1) {
        this.chifAff1 = chifAff1;
    }

    public BigDecimal getChifAff2() {
        return chifAff2;
    }

    public void setChifAff2(BigDecimal chifAff2) {
        this.chifAff2 = chifAff2;
    }

    public BigDecimal getChifAff3() {
        return chifAff3;
    }

    public void setChifAff3(BigDecimal chifAff3) {
        this.chifAff3 = chifAff3;
    }

    public BigDecimal getTauxRem() {
        return tauxRem;
    }

    public void setTauxRem(BigDecimal tauxRem) {
        this.tauxRem = tauxRem;
    }

    public BigDecimal getTauxCom() {
        return tauxCom;
    }

    public void setTauxCom(BigDecimal tauxCom) {
        this.tauxCom = tauxCom;
    }

    public BigDecimal getReste() {
        return reste;
    }

    public void setReste(BigDecimal reste) {
        this.reste = reste;
    }

    public Byte getTauxRes() {
        return tauxRes;
    }

    public void setTauxRes(Byte tauxRes) {
        this.tauxRes = tauxRes;
    }

    public BigDecimal getValRes() {
        return valRes;
    }

    public void setValRes(BigDecimal valRes) {
        this.valRes = valRes;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public Short getRang() {
        return rang;
    }

    public void setRang(Short rang) {
        this.rang = rang;
    }

    public BigDecimal getImpaye() {
        return impaye;
    }

    public void setImpaye(BigDecimal impaye) {
        this.impaye = impaye;
    }

    public BigDecimal getChqImpaye() {
        return chqImpaye;
    }

    public void setChqImpaye(BigDecimal chqImpaye) {
        this.chqImpaye = chqImpaye;
    }

    public BigDecimal getEfPort() {
        return efPort;
    }

    public void setEfPort(BigDecimal efPort) {
        this.efPort = efPort;
    }

    public BigDecimal getEfBanque() {
        return efBanque;
    }

    public void setEfBanque(BigDecimal efBanque) {
        this.efBanque = efBanque;
    }

    public BigDecimal getEfNrecu() {
        return efNrecu;
    }

    public void setEfNrecu(BigDecimal efNrecu) {
        this.efNrecu = efNrecu;
    }

    public BigDecimal getAvCom() {
        return avCom;
    }

    public void setAvCom(BigDecimal avCom) {
        this.avCom = avCom;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public BigDecimal getBenefice() {
        return benefice;
    }

    public void setBenefice(BigDecimal benefice) {
        this.benefice = benefice;
    }

    public BigDecimal getTauxBene() {
        return tauxBene;
    }

    public void setTauxBene(BigDecimal tauxBene) {
        this.tauxBene = tauxBene;
    }

    public BigDecimal getRecFff() {
        return recFff;
    }

    public void setRecFff(BigDecimal recFff) {
        this.recFff = recFff;
    }

    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
    }

    public Byte getCle() {
        return cle;
    }

    public void setCle(Byte cle) {
        this.cle = cle;
    }

    public BigDecimal getSoldDep() {
        return soldDep;
    }

    public void setSoldDep(BigDecimal soldDep) {
        this.soldDep = soldDep;
    }

    public BigDecimal getInteret() {
        return interet;
    }

    public void setInteret(BigDecimal interet) {
        this.interet = interet;
    }

    public BigDecimal getRegChq() {
        return regChq;
    }

    public void setRegChq(BigDecimal regChq) {
        this.regChq = regChq;
    }

    public BigDecimal getRegEff() {
        return regEff;
    }

    public void setRegEff(BigDecimal regEff) {
        this.regEff = regEff;
    }

    public BigDecimal getRegEsp() {
        return regEsp;
    }

    public void setRegEsp(BigDecimal regEsp) {
        this.regEsp = regEsp;
    }

    public BigDecimal getFacInst() {
        return facInst;
    }

    public void setFacInst(BigDecimal facInst) {
        this.facInst = facInst;
    }

    public BigDecimal getAvoir() {
        return avoir;
    }

    public void setAvoir(BigDecimal avoir) {
        this.avoir = avoir;
    }

    public BigDecimal getEffInst() {
        return effInst;
    }

    public void setEffInst(BigDecimal effInst) {
        this.effInst = effInst;
    }

    public BigDecimal getSoldeBq() {
        return soldeBq;
    }

    public void setSoldeBq(BigDecimal soldeBq) {
        this.soldeBq = soldeBq;
    }

    public BigDecimal getCreance() {
        return creance;
    }

    public void setCreance(BigDecimal creance) {
        this.creance = creance;
    }

    public BigDecimal getEffEnc() {
        return effEnc;
    }

    public void setEffEnc(BigDecimal effEnc) {
        this.effEnc = effEnc;
    }

    public BigDecimal getEffEsc() {
        return effEsc;
    }

    public void setEffEsc(BigDecimal effEsc) {
        this.effEsc = effEsc;
    }

    public BigDecimal getComission() {
        return comission;
    }

    public void setComission(BigDecimal comission) {
        this.comission = comission;
    }

    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    public String getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(String codeTva) {
        this.codeTva = codeTva;
    }

    public BigDecimal getRemOrg() {
        return remOrg;
    }

    public void setRemOrg(BigDecimal remOrg) {
        this.remOrg = remOrg;
    }

    public BigDecimal getAvance() {
        return avance;
    }

    public void setAvance(BigDecimal avance) {
        this.avance = avance;
    }

    public BigDecimal getChqPf() {
        return chqPf;
    }

    public void setChqPf(BigDecimal chqPf) {
        this.chqPf = chqPf;
    }

    public BigDecimal getRetenue() {
        return retenue;
    }

    public void setRetenue(BigDecimal retenue) {
        this.retenue = retenue;
    }

    public BigDecimal getRegVir() {
        return regVir;
    }

    public void setRegVir(BigDecimal regVir) {
        this.regVir = regVir;
    }

    public BigDecimal getAvN1() {
        return avN1;
    }

    public void setAvN1(BigDecimal avN1) {
        this.avN1 = avN1;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public BigDecimal getRistourne() {
        return ristourne;
    }

    public void setRistourne(BigDecimal ristourne) {
        this.ristourne = ristourne;
    }

    public BigDecimal getCaPrev() {
        return caPrev;
    }

    public void setCaPrev(BigDecimal caPrev) {
        this.caPrev = caPrev;
    }

    public BigDecimal getSoldeCpf() {
        return soldeCpf;
    }

    public void setSoldeCpf(BigDecimal soldeCpf) {
        this.soldeCpf = soldeCpf;
    }

    public BigDecimal getSoldeImp() {
        return soldeImp;
    }

    public void setSoldeImp(BigDecimal soldeImp) {
        this.soldeImp = soldeImp;
    }

    public Long getSoldeEpf() {
        return soldeEpf;
    }

    public void setSoldeEpf(Long soldeEpf) {
        this.soldeEpf = soldeEpf;
    }

    public Timestamp getDatFFac() {
        return datFFac;
    }

    public void setDatFFac(Timestamp datFFac) {
        this.datFFac = datFFac;
    }

    public String getDatGFac() {
        return datGFac;
    }

    public void setDatGFac(String datGFac) {
        this.datGFac = datGFac;
    }

    public BigDecimal getCaMens() {
        return caMens;
    }

    public void setCaMens(BigDecimal caMens) {
        this.caMens = caMens;
    }

    public BigDecimal getCrImax() {
        return crImax;
    }

    public void setCrImax(BigDecimal crImax) {
        this.crImax = crImax;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public BigDecimal getFcreN1() {
        return fcreN1;
    }

    public void setFcreN1(BigDecimal fcreN1) {
        this.fcreN1 = fcreN1;
    }

    public BigDecimal getFcreN2() {
        return fcreN2;
    }

    public void setFcreN2(BigDecimal fcreN2) {
        this.fcreN2 = fcreN2;
    }

    public BigDecimal getFreglN1() {
        return freglN1;
    }

    public void setFreglN1(BigDecimal freglN1) {
        this.freglN1 = freglN1;
    }

    public BigDecimal getFreglN2() {
        return freglN2;
    }

    public void setFreglN2(BigDecimal freglN2) {
        this.freglN2 = freglN2;
    }

    public BigDecimal getFescN1() {
        return fescN1;
    }

    public void setFescN1(BigDecimal fescN1) {
        this.fescN1 = fescN1;
    }

    public BigDecimal getFescN2() {
        return fescN2;
    }

    public void setFescN2(BigDecimal fescN2) {
        this.fescN2 = fescN2;
    }

    public BigDecimal getFbkN1() {
        return fbkN1;
    }

    public void setFbkN1(BigDecimal fbkN1) {
        this.fbkN1 = fbkN1;
    }

    public BigDecimal getFbkN2() {
        return fbkN2;
    }

    public void setFbkN2(BigDecimal fbkN2) {
        this.fbkN2 = fbkN2;
    }

    public BigDecimal getFefpN1() {
        return fefpN1;
    }

    public void setFefpN1(BigDecimal fefpN1) {
        this.fefpN1 = fefpN1;
    }

    public BigDecimal getFefpN2() {
        return fefpN2;
    }

    public void setFefpN2(BigDecimal fefpN2) {
        this.fefpN2 = fefpN2;
    }

    public BigDecimal getFchpN1() {
        return fchpN1;
    }

    public void setFchpN1(BigDecimal fchpN1) {
        this.fchpN1 = fchpN1;
    }

    public BigDecimal getFchpN2() {
        return fchpN2;
    }

    public void setFchpN2(BigDecimal fchpN2) {
        this.fchpN2 = fchpN2;
    }

    public BigDecimal getFefnrN1() {
        return fefnrN1;
    }

    public void setFefnrN1(BigDecimal fefnrN1) {
        this.fefnrN1 = fefnrN1;
    }

    public BigDecimal getFefnrN2() {
        return fefnrN2;
    }

    public void setFefnrN2(BigDecimal fefnrN2) {
        this.fefnrN2 = fefnrN2;
    }

    public BigDecimal getIcreN1() {
        return icreN1;
    }

    public void setIcreN1(BigDecimal icreN1) {
        this.icreN1 = icreN1;
    }

    public BigDecimal getIcreN2() {
        return icreN2;
    }

    public void setIcreN2(BigDecimal icreN2) {
        this.icreN2 = icreN2;
    }

    public BigDecimal getIreglN1() {
        return ireglN1;
    }

    public void setIreglN1(BigDecimal ireglN1) {
        this.ireglN1 = ireglN1;
    }

    public BigDecimal getIreglN2() {
        return ireglN2;
    }

    public void setIreglN2(BigDecimal ireglN2) {
        this.ireglN2 = ireglN2;
    }

    public BigDecimal getIescN1() {
        return iescN1;
    }

    public void setIescN1(BigDecimal iescN1) {
        this.iescN1 = iescN1;
    }

    public BigDecimal getIescN2() {
        return iescN2;
    }

    public void setIescN2(BigDecimal iescN2) {
        this.iescN2 = iescN2;
    }

    public BigDecimal getIbkN1() {
        return ibkN1;
    }

    public void setIbkN1(BigDecimal ibkN1) {
        this.ibkN1 = ibkN1;
    }

    public BigDecimal getIbkN2() {
        return ibkN2;
    }

    public void setIbkN2(BigDecimal ibkN2) {
        this.ibkN2 = ibkN2;
    }

    public BigDecimal getIefpN1() {
        return iefpN1;
    }

    public void setIefpN1(BigDecimal iefpN1) {
        this.iefpN1 = iefpN1;
    }

    public BigDecimal getIefpN2() {
        return iefpN2;
    }

    public void setIefpN2(BigDecimal iefpN2) {
        this.iefpN2 = iefpN2;
    }

    public BigDecimal getIchpN1() {
        return ichpN1;
    }

    public void setIchpN1(BigDecimal ichpN1) {
        this.ichpN1 = ichpN1;
    }

    public BigDecimal getIchpN2() {
        return ichpN2;
    }

    public void setIchpN2(BigDecimal ichpN2) {
        this.ichpN2 = ichpN2;
    }

    public BigDecimal getIefnrN1() {
        return iefnrN1;
    }

    public void setIefnrN1(BigDecimal iefnrN1) {
        this.iefnrN1 = iefnrN1;
    }

    public BigDecimal getIefnrN2() {
        return iefnrN2;
    }

    public void setIefnrN2(BigDecimal iefnrN2) {
        this.iefnrN2 = iefnrN2;
    }

    public String getDatOuvr() {
        return datOuvr;
    }

    public void setDatOuvr(String datOuvr) {
        this.datOuvr = datOuvr;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public BigDecimal getRemExp() {
        return remExp;
    }

    public void setRemExp(BigDecimal remExp) {
        this.remExp = remExp;
    }

    public String getChefMag() {
        return chefMag;
    }

    public void setChefMag(String chefMag) {
        this.chefMag = chefMag;
    }

    public String getJourVisit() {
        return jourVisit;
    }

    public void setJourVisit(String jourVisit) {
        this.jourVisit = jourVisit;
    }

    public Boolean getInstance() {
        return instance;
    }

    public void setInstance(Boolean instance) {
        this.instance = instance;
    }

    public Boolean getComptant() {
        return comptant;
    }

    public void setComptant(Boolean comptant) {
        this.comptant = comptant;
    }

    public Boolean getBl() {
        return bl;
    }

    public void setBl(Boolean bl) {
        this.bl = bl;
    }

    public String getNatLiv() {
        return natLiv;
    }

    public void setNatLiv(String natLiv) {
        this.natLiv = natLiv;
    }

    public BigDecimal getMois1() {
        return mois1;
    }

    public void setMois1(BigDecimal mois1) {
        this.mois1 = mois1;
    }

    public BigDecimal getMois2() {
        return mois2;
    }

    public void setMois2(BigDecimal mois2) {
        this.mois2 = mois2;
    }

    public BigDecimal getMois3() {
        return mois3;
    }

    public void setMois3(BigDecimal mois3) {
        this.mois3 = mois3;
    }

    public BigDecimal getMois4() {
        return mois4;
    }

    public void setMois4(BigDecimal mois4) {
        this.mois4 = mois4;
    }

    public BigDecimal getMois5() {
        return mois5;
    }

    public void setMois5(BigDecimal mois5) {
        this.mois5 = mois5;
    }

    public BigDecimal getMois6() {
        return mois6;
    }

    public void setMois6(BigDecimal mois6) {
        this.mois6 = mois6;
    }

    public BigDecimal getMois7() {
        return mois7;
    }

    public void setMois7(BigDecimal mois7) {
        this.mois7 = mois7;
    }

    public BigDecimal getMois8() {
        return mois8;
    }

    public void setMois8(BigDecimal mois8) {
        this.mois8 = mois8;
    }

    public BigDecimal getMois9() {
        return mois9;
    }

    public void setMois9(BigDecimal mois9) {
        this.mois9 = mois9;
    }

    public BigDecimal getMois10() {
        return mois10;
    }

    public void setMois10(BigDecimal mois10) {
        this.mois10 = mois10;
    }

    public BigDecimal getMois11() {
        return mois11;
    }

    public void setMois11(BigDecimal mois11) {
        this.mois11 = mois11;
    }

    public BigDecimal getMois12() {
        return mois12;
    }

    public void setMois12(BigDecimal mois12) {
        this.mois12 = mois12;
    }

    public String getDatDerLi() {
        return datDerLi;
    }

    public void setDatDerLi(String datDerLi) {
        this.datDerLi = datDerLi;
    }

    public BigDecimal getMargePour() {
        return margePour;
    }

    public void setMargePour(BigDecimal margePour) {
        this.margePour = margePour;
    }

    public BigDecimal getMargeVal() {
        return margeVal;
    }

    public void setMargeVal(BigDecimal margeVal) {
        this.margeVal = margeVal;
    }

    public BigDecimal getCredblEnc() {
        return credblEnc;
    }

    public void setCredblEnc(BigDecimal credblEnc) {
        this.credblEnc = credblEnc;
    }

    public BigDecimal getCredinstec() {
        return credinstec;
    }

    public void setCredinstec(BigDecimal credinstec) {
        this.credinstec = credinstec;
    }

    public String getObservatio() {
        return observatio;
    }

    public void setObservatio(String observatio) {
        this.observatio = observatio;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getGouv1() {
        return gouv1;
    }

    public void setGouv1(String gouv1) {
        this.gouv1 = gouv1;
    }

    public String getGouv2() {
        return gouv2;
    }

    public void setGouv2(String gouv2) {
        this.gouv2 = gouv2;
    }

    public String getNatcaution() {
        return natcaution;
    }

    public void setNatcaution(String natcaution) {
        this.natcaution = natcaution;
    }

    public Boolean getCheque() {
        return cheque;
    }

    public void setCheque(Boolean cheque) {
        this.cheque = cheque;
    }

    public Boolean getEspece() {
        return espece;
    }

    public void setEspece(Boolean espece) {
        this.espece = espece;
    }

    public Boolean getTraite() {
        return traite;
    }

    public void setTraite(Boolean traite) {
        this.traite = traite;
    }

    public BigDecimal getCrRef() {
        return crRef;
    }

    public void setCrRef(BigDecimal crRef) {
        this.crRef = crRef;
    }

    public BigDecimal getSoldTerm() {
        return soldTerm;
    }

    public void setSoldTerm(BigDecimal soldTerm) {
        this.soldTerm = soldTerm;
    }

    public BigDecimal getChqImp() {
        return chqImp;
    }

    public void setChqImp(BigDecimal chqImp) {
        this.chqImp = chqImp;
    }

    public BigDecimal getCriRef() {
        return criRef;
    }

    public void setCriRef(BigDecimal criRef) {
        this.criRef = criRef;
    }

    public String getRemFam() {
        return remFam;
    }

    public void setRemFam(String remFam) {
        this.remFam = remFam;
    }

    public Boolean getReglement() {
        return reglement;
    }

    public void setReglement(Boolean reglement) {
        this.reglement = reglement;
    }

    public Short getDelai() {
        return delai;
    }

    public void setDelai(Short delai) {
        this.delai = delai;
    }

    public Byte getNbTranche() {
        return nbTranche;
    }

    public void setNbTranche(Byte nbTranche) {
        this.nbTranche = nbTranche;
    }

    public String getCodSteq() {
        return codSteq;
    }

    public void setCodSteq(String codSteq) {
        this.codSteq = codSteq;
    }

    public BigDecimal getReference() {
        return reference;
    }

    public void setReference(BigDecimal reference) {
        this.reference = reference;
    }

    public String getSansRet() {
        return sansRet;
    }

    public void setSansRet(String sansRet) {
        this.sansRet = sansRet;
    }

    public String getCliGroup() {
        return cliGroup;
    }

    public void setCliGroup(String cliGroup) {
        this.cliGroup = cliGroup;
    }

    public BigDecimal getTauxMarge() {
        return tauxMarge;
    }

    public void setTauxMarge(BigDecimal tauxMarge) {
        this.tauxMarge = tauxMarge;
    }




    
}