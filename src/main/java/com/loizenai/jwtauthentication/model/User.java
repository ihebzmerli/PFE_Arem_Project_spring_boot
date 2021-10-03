package com.loizenai.jwtauthentication.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String firstname;
    
    @NotBlank
    @Size(min=3, max = 50)
    private String lastname;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    @Column(name = "file_name")
    private String fileName;

    private Timestamp dateDeNaissance;
    private int cin;
    private String address;
    private int cps;
    private int telephone;
    private String pseudo;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Date_Rec")
    private Timestamp dateRec;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_Contrat")
    private TypeContrat typeContrat;
    public enum TypeContrat{
        indefini,
        CDI,
        CDD,
        CTT,
        C_en_Alternance;
    }

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_Contrat")
    private Timestamp dateContrat;

    /*
    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;
    public enum Role {
        acheteur,
        transitaire,
        client,
        vendeur,
        decideur_BP,
        agent_CAB,
        preparateur_BR,
        responsable_dispatching_BP,
        preparateur,
        validateur_de_chariot,
        responsable_pointage,
        emballeur,
        expediteur,
        agent_saisie_reg,
        caissier,
        responsable_service_frs_etranger,
        responsable_service_frs_local,
        administrateur;
    }
*/


    private String famille;
    private Float salaire;

    @Basic
    @Column(name = "Prime_De_Rendement")
    private Float primeDeRendement;

    @Basic
    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "Heures_De_Travail")
    private Timestamp heuresDeTravail;

    @Basic
    @Column(name = "Vente_Par_Heure")
    private int venteParHeure;

    @Basic
    @Column(name = "Objectif_Par_Jour")
    private Float objectifParJour;

    @Basic
    @Column(name = "Objectif_Par_Mois")
    private Float objectifParMois;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Date_Debut_Conge")
    private Timestamp dateDebutConge;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Date_Fin_Conge")
    private Timestamp dateFinConge;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type_Conge")
    private TypeConge typeConge;
    public enum TypeConge{
        indefini,
        maternite,
        maladie,
        reduire,
        sans_solde,
        deces,
        annuel;
    }
    
    @Basic
    @Column(name = "Prime_Dev")
    private Float primeDev;

    @Basic
    @Column(name = "Prime_Global")
    private Float primeGlobal;
    @Basic
    @Column(name = "Prime_Par_Client")
    private Float primeParClient;
    @Basic
    @Column(name = "Prime_Stock")
    private Float primeStock;
    private String postV;

    @Column(unique=true)
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

    @Column(name = "ZONE")
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

    @Column(name = "connected")
    private Integer connected;

    @Enumerated(EnumType.STRING)
    @Column(name = "Authorisation")
    private Authorisation authorisation;
    public enum Authorisation{
        Allow,
        Block;
    }

    @Nullable
    @Column(name = "DateLastForgot")
    private Timestamp dateLastForgot;

    @Column(name = "show_password")
    private String ShowPassword;
    //FK_KEYS***********************
    @ManyToMany(mappedBy = "Users", fetch = FetchType.LAZY)
    private List<Chariot> chariots;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Xcommand> numCom;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BonSort> bonSorts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private List<BonLiv> bonLivs;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<BonPrep> bonPreps;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Expide> expides;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private List<Achats> achats;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Gallery> galleries;

    @OneToMany(mappedBy = "prepara", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<ArtPrep> artPreps;

    @OneToMany(mappedBy = "prep", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<ArtPrep> artPreps2;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<DetEmba> detEmbas;
    //END FK_KEYS************************
    
    public User() {}

    public User(String firstname, String lastname, 
    				String username, String email, String password,Integer connected) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.connected = connected;
    }



    
    public User(@NotBlank @Size(min = 3, max = 50) String firstname, @NotBlank @Size(min = 3, max = 50) String lastname,
            @NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
            @NotBlank @Size(min = 6, max = 100) String password, Set<Role> roles, Timestamp dateDeNaissance, int cin,
            String address, int cps, int telephone, String pseudo, String fileName , Timestamp dateRec, Authorisation authorisation, TypeContrat typeContrat,
            Timestamp dateContrat, String famille, Float salaire, Float primeDeRendement, Timestamp heuresDeTravail,
            int venteParHeure, Float objectifParJour, Float objectifParMois, Timestamp dateDebutConge,
            Timestamp dateFinConge, TypeConge typeConge, Float primeDev, Float primeGlobal, Float primeParClient,
            Float primeStock, String postV, long codUser, String raison, String rc, String respon1, String fonction1,
            String faxs, String adrSiege, String ruel, String numRuel, String cpl, String villel, String regionl,
            String tell, String faxl, String adrLiv, String region, String taxe, String ccb1, String bank1,
            String agence1, String garanties, String codGrp, String modReg, String domBan, Short echeance,
            BigDecimal crMax, Timestamp derMvt, BigDecimal credit, BigDecimal preVen, BigDecimal cumulAch,
            BigDecimal chifAff1, BigDecimal chifAff2, BigDecimal chifAff3, BigDecimal tauxRem, BigDecimal tauxCom,
            BigDecimal reste, Byte tauxRes, BigDecimal valRes, String patron, Short rang, BigDecimal impaye,
            BigDecimal chqImpaye, BigDecimal efPort, BigDecimal efBanque, BigDecimal efNrecu, BigDecimal avCom,
            String caution, BigDecimal benefice, BigDecimal tauxBene, BigDecimal recFff, BigDecimal tva, Byte cle,
            BigDecimal soldDep, BigDecimal interet, BigDecimal regChq, BigDecimal regEff, BigDecimal regEsp,
            BigDecimal facInst, BigDecimal avoir, BigDecimal effInst, BigDecimal soldeBq, BigDecimal creance,
            BigDecimal effEnc, BigDecimal effEsc, BigDecimal comission, String bloc, String codeTva, BigDecimal remOrg,
            BigDecimal avance, BigDecimal chqPf, BigDecimal retenue, BigDecimal regVir, BigDecimal avN1, String classe,
            BigDecimal ristourne, BigDecimal caPrev, BigDecimal soldeCpf, BigDecimal soldeImp, Long soldeEpf,
            Timestamp datFFac, String datGFac, BigDecimal caMens, BigDecimal crImax, String zone, BigDecimal fcreN1,
            BigDecimal fcreN2, BigDecimal freglN1, BigDecimal freglN2, BigDecimal fescN1, BigDecimal fescN2,
            BigDecimal fbkN1, BigDecimal fbkN2, BigDecimal fefpN1, BigDecimal fefpN2, BigDecimal fchpN1,
            BigDecimal fchpN2, BigDecimal fefnrN1, BigDecimal fefnrN2, BigDecimal icreN1, BigDecimal icreN2,
            BigDecimal ireglN1, BigDecimal ireglN2, BigDecimal iescN1, BigDecimal iescN2, BigDecimal ibkN1,
            BigDecimal ibkN2, BigDecimal iefpN1, BigDecimal iefpN2, BigDecimal ichpN1, BigDecimal ichpN2,
            BigDecimal iefnrN1, BigDecimal iefnrN2, String datOuvr, String command, BigDecimal remExp,
            String chefMag, String jourVisit, Boolean instance, Boolean comptant, Boolean bl, String natLiv,
            BigDecimal mois1, BigDecimal mois2, BigDecimal mois3, BigDecimal mois4, BigDecimal mois5, BigDecimal mois6,
            BigDecimal mois7, BigDecimal mois8, BigDecimal mois9, BigDecimal mois10, BigDecimal mois11,
            BigDecimal mois12, String datDerLi, BigDecimal margePour, BigDecimal margeVal, BigDecimal credblEnc,
            BigDecimal credinstec, String observatio, String observ, String gouv1, String gouv2, String natcaution,
            Boolean cheque, Boolean espece, Boolean traite, BigDecimal crRef, BigDecimal soldTerm, BigDecimal chqImp,
            BigDecimal criRef, String remFam, Boolean reglement, Short delai, Byte nbTranche, String codSteq,
            BigDecimal reference, String sansRet, String cliGroup, BigDecimal tauxMarge, String ShowPassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.dateDeNaissance = dateDeNaissance;
        this.cin = cin;
        this.address = address;
        this.cps = cps;
        this.telephone = telephone;
        this.pseudo = pseudo;
        this.fileName = fileName;
        this.dateRec = dateRec;
        this.typeContrat = typeContrat;
        this.dateContrat = dateContrat;
        this.famille = famille;
        this.salaire = salaire;
        this.primeDeRendement = primeDeRendement;
        this.heuresDeTravail = heuresDeTravail;
        this.venteParHeure = venteParHeure;
        this.objectifParJour = objectifParJour;
        this.objectifParMois = objectifParMois;
        this.dateDebutConge = dateDebutConge;
        this.dateFinConge = dateFinConge;
        this.authorisation = authorisation;
        this.typeConge = typeConge;
        this.primeDev = primeDev;
        this.primeGlobal = primeGlobal;
        this.primeParClient = primeParClient;
        this.primeStock = primeStock;
        this.postV = postV;
        this.codUser = codUser;
        this.raison = raison;
        this.rc = rc;
        this.respon1 = respon1;
        this.fonction1 = fonction1;
        this.faxs = faxs;
        this.adrSiege = adrSiege;
        this.ruel = ruel;
        this.numRuel = numRuel;
        this.cpl = cpl;
        this.villel = villel;
        this.regionl = regionl;
        this.tell = tell;
        this.faxl = faxl;
        this.adrLiv = adrLiv;
        this.region = region;
        this.taxe = taxe;
        this.ccb1 = ccb1;
        this.bank1 = bank1;
        this.agence1 = agence1;
        this.garanties = garanties;
        this.codGrp = codGrp;
        this.modReg = modReg;
        this.domBan = domBan;
        this.echeance = echeance;
        this.crMax = crMax;
        this.derMvt = derMvt;
        this.credit = credit;
        this.preVen = preVen;
        this.cumulAch = cumulAch;
        this.chifAff1 = chifAff1;
        this.chifAff2 = chifAff2;
        this.chifAff3 = chifAff3;
        this.tauxRem = tauxRem;
        this.tauxCom = tauxCom;
        this.reste = reste;
        this.tauxRes = tauxRes;
        this.valRes = valRes;
        this.patron = patron;
        this.rang = rang;
        this.impaye = impaye;
        this.chqImpaye = chqImpaye;
        this.efPort = efPort;
        this.efBanque = efBanque;
        this.efNrecu = efNrecu;
        this.avCom = avCom;
        this.caution = caution;
        this.benefice = benefice;
        this.tauxBene = tauxBene;
        this.recFff = recFff;
        this.tva = tva;
        this.cle = cle;
        this.soldDep = soldDep;
        this.interet = interet;
        this.regChq = regChq;
        this.regEff = regEff;
        this.regEsp = regEsp;
        this.facInst = facInst;
        this.avoir = avoir;
        this.effInst = effInst;
        this.soldeBq = soldeBq;
        this.creance = creance;
        this.effEnc = effEnc;
        this.effEsc = effEsc;
        this.comission = comission;
        this.bloc = bloc;
        this.codeTva = codeTva;
        this.remOrg = remOrg;
        this.avance = avance;
        this.chqPf = chqPf;
        this.retenue = retenue;
        this.regVir = regVir;
        this.avN1 = avN1;
        this.classe = classe;
        this.ristourne = ristourne;
        this.caPrev = caPrev;
        this.soldeCpf = soldeCpf;
        this.soldeImp = soldeImp;
        this.soldeEpf = soldeEpf;
        this.datFFac = datFFac;
        this.datGFac = datGFac;
        this.caMens = caMens;
        this.crImax = crImax;
        this.zone = zone;
        this.fcreN1 = fcreN1;
        this.fcreN2 = fcreN2;
        this.freglN1 = freglN1;
        this.freglN2 = freglN2;
        this.fescN1 = fescN1;
        this.fescN2 = fescN2;
        this.fbkN1 = fbkN1;
        this.fbkN2 = fbkN2;
        this.fefpN1 = fefpN1;
        this.fefpN2 = fefpN2;
        this.fchpN1 = fchpN1;
        this.fchpN2 = fchpN2;
        this.fefnrN1 = fefnrN1;
        this.fefnrN2 = fefnrN2;
        this.icreN1 = icreN1;
        this.icreN2 = icreN2;
        this.ireglN1 = ireglN1;
        this.ireglN2 = ireglN2;
        this.iescN1 = iescN1;
        this.iescN2 = iescN2;
        this.ibkN1 = ibkN1;
        this.ibkN2 = ibkN2;
        this.iefpN1 = iefpN1;
        this.iefpN2 = iefpN2;
        this.ichpN1 = ichpN1;
        this.ichpN2 = ichpN2;
        this.iefnrN1 = iefnrN1;
        this.iefnrN2 = iefnrN2;
        this.datOuvr = datOuvr;
        this.command = command;
        this.remExp = remExp;
        this.chefMag = chefMag;
        this.jourVisit = jourVisit;
        this.instance = instance;
        this.comptant = comptant;
        this.bl = bl;
        this.natLiv = natLiv;
        this.mois1 = mois1;
        this.mois2 = mois2;
        this.mois3 = mois3;
        this.mois4 = mois4;
        this.mois5 = mois5;
        this.mois6 = mois6;
        this.mois7 = mois7;
        this.mois8 = mois8;
        this.mois9 = mois9;
        this.mois10 = mois10;
        this.mois11 = mois11;
        this.mois12 = mois12;
        this.datDerLi = datDerLi;
        this.margePour = margePour;
        this.margeVal = margeVal;
        this.credblEnc = credblEnc;
        this.credinstec = credinstec;
        this.observatio = observatio;
        this.observ = observ;
        this.gouv1 = gouv1;
        this.gouv2 = gouv2;
        this.natcaution = natcaution;
        this.cheque = cheque;
        this.espece = espece;
        this.traite = traite;
        this.crRef = crRef;
        this.soldTerm = soldTerm;
        this.chqImp = chqImp;
        this.criRef = criRef;
        this.remFam = remFam;
        this.reglement = reglement;
        this.delai = delai;
        this.nbTranche = nbTranche;
        this.codSteq = codSteq;
        this.reference = reference;
        this.sansRet = sansRet;
        this.cliGroup = cliGroup;
        this.tauxMarge = tauxMarge;
        this.ShowPassword = ShowPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    public String getShowPassword() {
        return ShowPassword;
    }

    public void setShowPassword(String showPassword) {
        ShowPassword = showPassword;
    }

    public Authorisation getAuthorisation() {
        return authorisation;
    }

    public void setAuthorisation(Authorisation authorisation) {
        this.authorisation = authorisation;
    }

    public Timestamp getDateLastForgot() {
        return dateLastForgot;
    }

    public void setDateLastForgot(Timestamp dateLastForgot) {
        this.dateLastForgot = dateLastForgot;
    }

    public Integer getConnected() {
        return connected;
    }

    public void setConnected(Integer connected) {
        this.connected = connected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((adrLiv == null) ? 0 : adrLiv.hashCode());
        result = prime * result + ((adrSiege == null) ? 0 : adrSiege.hashCode());
        result = prime * result + ((agence1 == null) ? 0 : agence1.hashCode());
        result = prime * result + ((avCom == null) ? 0 : avCom.hashCode());
        result = prime * result + ((avN1 == null) ? 0 : avN1.hashCode());
        result = prime * result + ((avance == null) ? 0 : avance.hashCode());
        result = prime * result + ((avoir == null) ? 0 : avoir.hashCode());
        result = prime * result + ((bank1 == null) ? 0 : bank1.hashCode());
        result = prime * result + ((benefice == null) ? 0 : benefice.hashCode());
        result = prime * result + ((bl == null) ? 0 : bl.hashCode());
        result = prime * result + ((bloc == null) ? 0 : bloc.hashCode());
        result = prime * result + ((caMens == null) ? 0 : caMens.hashCode());
        result = prime * result + ((caPrev == null) ? 0 : caPrev.hashCode());
        result = prime * result + ((caution == null) ? 0 : caution.hashCode());
        result = prime * result + ((ccb1 == null) ? 0 : ccb1.hashCode());
        result = prime * result + ((chefMag == null) ? 0 : chefMag.hashCode());
        result = prime * result + ((cheque == null) ? 0 : cheque.hashCode());
        result = prime * result + ((chifAff1 == null) ? 0 : chifAff1.hashCode());
        result = prime * result + ((chifAff2 == null) ? 0 : chifAff2.hashCode());
        result = prime * result + ((chifAff3 == null) ? 0 : chifAff3.hashCode());
        result = prime * result + ((chqImp == null) ? 0 : chqImp.hashCode());
        result = prime * result + ((chqImpaye == null) ? 0 : chqImpaye.hashCode());
        result = prime * result + ((chqPf == null) ? 0 : chqPf.hashCode());
        result = prime * result + cin;
        result = prime * result + ((classe == null) ? 0 : classe.hashCode());
        result = prime * result + ((cle == null) ? 0 : cle.hashCode());
        result = prime * result + ((cliGroup == null) ? 0 : cliGroup.hashCode());
        result = prime * result + ((codGrp == null) ? 0 : codGrp.hashCode());
        result = prime * result + ((codSteq == null) ? 0 : codSteq.hashCode());
        result = prime * result + (int) (codUser ^ (codUser >>> 32));
        result = prime * result + ((codeTva == null) ? 0 : codeTva.hashCode());
        result = prime * result + ((comission == null) ? 0 : comission.hashCode());
        result = prime * result + ((command == null) ? 0 : command.hashCode());
        result = prime * result + ((comptant == null) ? 0 : comptant.hashCode());
        result = prime * result + ((cpl == null) ? 0 : cpl.hashCode());
        result = prime * result + cps;
        result = prime * result + ((crImax == null) ? 0 : crImax.hashCode());
        result = prime * result + ((crMax == null) ? 0 : crMax.hashCode());
        result = prime * result + ((crRef == null) ? 0 : crRef.hashCode());
        result = prime * result + ((creance == null) ? 0 : creance.hashCode());
        result = prime * result + ((credblEnc == null) ? 0 : credblEnc.hashCode());
        result = prime * result + ((credinstec == null) ? 0 : credinstec.hashCode());
        result = prime * result + ((credit == null) ? 0 : credit.hashCode());
        result = prime * result + ((criRef == null) ? 0 : criRef.hashCode());
        result = prime * result + ((cumulAch == null) ? 0 : cumulAch.hashCode());
        result = prime * result + ((datDerLi == null) ? 0 : datDerLi.hashCode());
        result = prime * result + ((datFFac == null) ? 0 : datFFac.hashCode());
        result = prime * result + ((datGFac == null) ? 0 : datGFac.hashCode());
        result = prime * result + ((datOuvr == null) ? 0 : datOuvr.hashCode());
        result = prime * result + ((dateContrat == null) ? 0 : dateContrat.hashCode());
        result = prime * result + ((dateDeNaissance == null) ? 0 : dateDeNaissance.hashCode());
        result = prime * result + ((dateDebutConge == null) ? 0 : dateDebutConge.hashCode());
        result = prime * result + ((dateFinConge == null) ? 0 : dateFinConge.hashCode());
        result = prime * result + ((dateRec == null) ? 0 : dateRec.hashCode());
        result = prime * result + ((delai == null) ? 0 : delai.hashCode());
        result = prime * result + ((derMvt == null) ? 0 : derMvt.hashCode());
        result = prime * result + ((domBan == null) ? 0 : domBan.hashCode());
        result = prime * result + ((echeance == null) ? 0 : echeance.hashCode());
        result = prime * result + ((efBanque == null) ? 0 : efBanque.hashCode());
        result = prime * result + ((efNrecu == null) ? 0 : efNrecu.hashCode());
        result = prime * result + ((efPort == null) ? 0 : efPort.hashCode());
        result = prime * result + ((effEnc == null) ? 0 : effEnc.hashCode());
        result = prime * result + ((effEsc == null) ? 0 : effEsc.hashCode());
        result = prime * result + ((effInst == null) ? 0 : effInst.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((espece == null) ? 0 : espece.hashCode());
        result = prime * result + ((facInst == null) ? 0 : facInst.hashCode());
        result = prime * result + ((famille == null) ? 0 : famille.hashCode());
        result = prime * result + ((faxl == null) ? 0 : faxl.hashCode());
        result = prime * result + ((faxs == null) ? 0 : faxs.hashCode());
        result = prime * result + ((fbkN1 == null) ? 0 : fbkN1.hashCode());
        result = prime * result + ((fbkN2 == null) ? 0 : fbkN2.hashCode());
        result = prime * result + ((fchpN1 == null) ? 0 : fchpN1.hashCode());
        result = prime * result + ((fchpN2 == null) ? 0 : fchpN2.hashCode());
        result = prime * result + ((fcreN1 == null) ? 0 : fcreN1.hashCode());
        result = prime * result + ((fcreN2 == null) ? 0 : fcreN2.hashCode());
        result = prime * result + ((fefnrN1 == null) ? 0 : fefnrN1.hashCode());
        result = prime * result + ((fefnrN2 == null) ? 0 : fefnrN2.hashCode());
        result = prime * result + ((fefpN1 == null) ? 0 : fefpN1.hashCode());
        result = prime * result + ((fefpN2 == null) ? 0 : fefpN2.hashCode());
        result = prime * result + ((fescN1 == null) ? 0 : fescN1.hashCode());
        result = prime * result + ((fescN2 == null) ? 0 : fescN2.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((fonction1 == null) ? 0 : fonction1.hashCode());
        result = prime * result + ((freglN1 == null) ? 0 : freglN1.hashCode());
        result = prime * result + ((freglN2 == null) ? 0 : freglN2.hashCode());
        result = prime * result + ((garanties == null) ? 0 : garanties.hashCode());
        result = prime * result + ((gouv1 == null) ? 0 : gouv1.hashCode());
        result = prime * result + ((gouv2 == null) ? 0 : gouv2.hashCode());
        result = prime * result + ((heuresDeTravail == null) ? 0 : heuresDeTravail.hashCode());
        result = prime * result + ((ibkN1 == null) ? 0 : ibkN1.hashCode());
        result = prime * result + ((ibkN2 == null) ? 0 : ibkN2.hashCode());
        result = prime * result + ((ichpN1 == null) ? 0 : ichpN1.hashCode());
        result = prime * result + ((ichpN2 == null) ? 0 : ichpN2.hashCode());
        result = prime * result + ((icreN1 == null) ? 0 : icreN1.hashCode());
        result = prime * result + ((icreN2 == null) ? 0 : icreN2.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((iefnrN1 == null) ? 0 : iefnrN1.hashCode());
        result = prime * result + ((iefnrN2 == null) ? 0 : iefnrN2.hashCode());
        result = prime * result + ((iefpN1 == null) ? 0 : iefpN1.hashCode());
        result = prime * result + ((iefpN2 == null) ? 0 : iefpN2.hashCode());
        result = prime * result + ((iescN1 == null) ? 0 : iescN1.hashCode());
        result = prime * result + ((iescN2 == null) ? 0 : iescN2.hashCode());
        result = prime * result + ((impaye == null) ? 0 : impaye.hashCode());
        result = prime * result + ((instance == null) ? 0 : instance.hashCode());
        result = prime * result + ((interet == null) ? 0 : interet.hashCode());
        result = prime * result + ((ireglN1 == null) ? 0 : ireglN1.hashCode());
        result = prime * result + ((ireglN2 == null) ? 0 : ireglN2.hashCode());
        result = prime * result + ((jourVisit == null) ? 0 : jourVisit.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((margePour == null) ? 0 : margePour.hashCode());
        result = prime * result + ((margeVal == null) ? 0 : margeVal.hashCode());
        result = prime * result + ((modReg == null) ? 0 : modReg.hashCode());
        result = prime * result + ((mois1 == null) ? 0 : mois1.hashCode());
        result = prime * result + ((mois10 == null) ? 0 : mois10.hashCode());
        result = prime * result + ((mois11 == null) ? 0 : mois11.hashCode());
        result = prime * result + ((mois12 == null) ? 0 : mois12.hashCode());
        result = prime * result + ((mois2 == null) ? 0 : mois2.hashCode());
        result = prime * result + ((mois3 == null) ? 0 : mois3.hashCode());
        result = prime * result + ((mois4 == null) ? 0 : mois4.hashCode());
        result = prime * result + ((mois5 == null) ? 0 : mois5.hashCode());
        result = prime * result + ((mois6 == null) ? 0 : mois6.hashCode());
        result = prime * result + ((mois7 == null) ? 0 : mois7.hashCode());
        result = prime * result + ((mois8 == null) ? 0 : mois8.hashCode());
        result = prime * result + ((mois9 == null) ? 0 : mois9.hashCode());
        result = prime * result + ((natLiv == null) ? 0 : natLiv.hashCode());
        result = prime * result + ((natcaution == null) ? 0 : natcaution.hashCode());
        result = prime * result + ((nbTranche == null) ? 0 : nbTranche.hashCode());
        result = prime * result + ((numRuel == null) ? 0 : numRuel.hashCode());
        long temp;
        result = prime * result + ((observ == null) ? 0 : observ.hashCode());
        result = prime * result + ((observatio == null) ? 0 : observatio.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((patron == null) ? 0 : patron.hashCode());
        result = prime * result + ((postV == null) ? 0 : postV.hashCode());
        result = prime * result + ((preVen == null) ? 0 : preVen.hashCode());
        result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
        result = prime * result + ((raison == null) ? 0 : raison.hashCode());
        result = prime * result + ((rang == null) ? 0 : rang.hashCode());
        result = prime * result + ((rc == null) ? 0 : rc.hashCode());
        result = prime * result + ((recFff == null) ? 0 : recFff.hashCode());
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
        result = prime * result + ((regChq == null) ? 0 : regChq.hashCode());
        result = prime * result + ((regEff == null) ? 0 : regEff.hashCode());
        result = prime * result + ((regEsp == null) ? 0 : regEsp.hashCode());
        result = prime * result + ((regVir == null) ? 0 : regVir.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((regionl == null) ? 0 : regionl.hashCode());
        result = prime * result + ((reglement == null) ? 0 : reglement.hashCode());
        result = prime * result + ((remExp == null) ? 0 : remExp.hashCode());
        result = prime * result + ((remFam == null) ? 0 : remFam.hashCode());
        result = prime * result + ((remOrg == null) ? 0 : remOrg.hashCode());
        result = prime * result + ((respon1 == null) ? 0 : respon1.hashCode());
        result = prime * result + ((reste == null) ? 0 : reste.hashCode());
        result = prime * result + ((retenue == null) ? 0 : retenue.hashCode());
        result = prime * result + ((ristourne == null) ? 0 : ristourne.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((ruel == null) ? 0 : ruel.hashCode());
        result = prime * result + ((sansRet == null) ? 0 : sansRet.hashCode());
        result = prime * result + ((soldDep == null) ? 0 : soldDep.hashCode());
        result = prime * result + ((soldTerm == null) ? 0 : soldTerm.hashCode());
        result = prime * result + ((soldeBq == null) ? 0 : soldeBq.hashCode());
        result = prime * result + ((soldeCpf == null) ? 0 : soldeCpf.hashCode());
        result = prime * result + ((soldeEpf == null) ? 0 : soldeEpf.hashCode());
        result = prime * result + ((soldeImp == null) ? 0 : soldeImp.hashCode());
        result = prime * result + ((tauxBene == null) ? 0 : tauxBene.hashCode());
        result = prime * result + ((tauxCom == null) ? 0 : tauxCom.hashCode());
        result = prime * result + ((tauxMarge == null) ? 0 : tauxMarge.hashCode());
        result = prime * result + ((tauxRem == null) ? 0 : tauxRem.hashCode());
        result = prime * result + ((tauxRes == null) ? 0 : tauxRes.hashCode());
        result = prime * result + ((taxe == null) ? 0 : taxe.hashCode());
        result = prime * result + telephone;
        result = prime * result + ((tell == null) ? 0 : tell.hashCode());
        result = prime * result + ((traite == null) ? 0 : traite.hashCode());
        result = prime * result + ((tva == null) ? 0 : tva.hashCode());
        result = prime * result + ((typeConge == null) ? 0 : typeConge.hashCode());
        result = prime * result + ((typeContrat == null) ? 0 : typeContrat.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((valRes == null) ? 0 : valRes.hashCode());
        result = prime * result + ((villel == null) ? 0 : villel.hashCode());
        result = prime * result + ((zone == null) ? 0 : zone.hashCode());
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
        User other = (User) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (adrLiv == null) {
            if (other.adrLiv != null)
                return false;
        } else if (!adrLiv.equals(other.adrLiv))
            return false;
        if (adrSiege == null) {
            if (other.adrSiege != null)
                return false;
        } else if (!adrSiege.equals(other.adrSiege))
            return false;
        if (agence1 == null) {
            if (other.agence1 != null)
                return false;
        } else if (!agence1.equals(other.agence1))
            return false;
        if (avCom == null) {
            if (other.avCom != null)
                return false;
        } else if (!avCom.equals(other.avCom))
            return false;
        if (avN1 == null) {
            if (other.avN1 != null)
                return false;
        } else if (!avN1.equals(other.avN1))
            return false;
        if (avance == null) {
            if (other.avance != null)
                return false;
        } else if (!avance.equals(other.avance))
            return false;
        if (avoir == null) {
            if (other.avoir != null)
                return false;
        } else if (!avoir.equals(other.avoir))
            return false;
        if (bank1 == null) {
            if (other.bank1 != null)
                return false;
        } else if (!bank1.equals(other.bank1))
            return false;
        if (benefice == null) {
            if (other.benefice != null)
                return false;
        } else if (!benefice.equals(other.benefice))
            return false;
        if (bl == null) {
            if (other.bl != null)
                return false;
        } else if (!bl.equals(other.bl))
            return false;
        if (bloc == null) {
            if (other.bloc != null)
                return false;
        } else if (!bloc.equals(other.bloc))
            return false;
        if (caMens == null) {
            if (other.caMens != null)
                return false;
        } else if (!caMens.equals(other.caMens))
            return false;
        if (caPrev == null) {
            if (other.caPrev != null)
                return false;
        } else if (!caPrev.equals(other.caPrev))
            return false;
        if (caution == null) {
            if (other.caution != null)
                return false;
        } else if (!caution.equals(other.caution))
            return false;
        if (ccb1 == null) {
            if (other.ccb1 != null)
                return false;
        } else if (!ccb1.equals(other.ccb1))
            return false;
        if (chefMag == null) {
            if (other.chefMag != null)
                return false;
        } else if (!chefMag.equals(other.chefMag))
            return false;
        if (cheque == null) {
            if (other.cheque != null)
                return false;
        } else if (!cheque.equals(other.cheque))
            return false;
        if (chifAff1 == null) {
            if (other.chifAff1 != null)
                return false;
        } else if (!chifAff1.equals(other.chifAff1))
            return false;
        if (chifAff2 == null) {
            if (other.chifAff2 != null)
                return false;
        } else if (!chifAff2.equals(other.chifAff2))
            return false;
        if (chifAff3 == null) {
            if (other.chifAff3 != null)
                return false;
        } else if (!chifAff3.equals(other.chifAff3))
            return false;
        if (chqImp == null) {
            if (other.chqImp != null)
                return false;
        } else if (!chqImp.equals(other.chqImp))
            return false;
        if (chqImpaye == null) {
            if (other.chqImpaye != null)
                return false;
        } else if (!chqImpaye.equals(other.chqImpaye))
            return false;
        if (chqPf == null) {
            if (other.chqPf != null)
                return false;
        } else if (!chqPf.equals(other.chqPf))
            return false;
        if (cin != other.cin)
            return false;
        if (classe == null) {
            if (other.classe != null)
                return false;
        } else if (!classe.equals(other.classe))
            return false;
        if (cle == null) {
            if (other.cle != null)
                return false;
        } else if (!cle.equals(other.cle))
            return false;
        if (cliGroup == null) {
            if (other.cliGroup != null)
                return false;
        } else if (!cliGroup.equals(other.cliGroup))
            return false;
        if (codGrp == null) {
            if (other.codGrp != null)
                return false;
        } else if (!codGrp.equals(other.codGrp))
            return false;
        if (codSteq == null) {
            if (other.codSteq != null)
                return false;
        } else if (!codSteq.equals(other.codSteq))
            return false;
        if (codUser != other.codUser)
            return false;
        if (codeTva == null) {
            if (other.codeTva != null)
                return false;
        } else if (!codeTva.equals(other.codeTva))
            return false;
        if (comission == null) {
            if (other.comission != null)
                return false;
        } else if (!comission.equals(other.comission))
            return false;
        if (command == null) {
            if (other.command != null)
                return false;
        } else if (!command.equals(other.command))
            return false;
        if (comptant == null) {
            if (other.comptant != null)
                return false;
        } else if (!comptant.equals(other.comptant))
            return false;
        if (cpl == null) {
            if (other.cpl != null)
                return false;
        } else if (!cpl.equals(other.cpl))
            return false;
        if (cps != other.cps)
            return false;
        if (crImax == null) {
            if (other.crImax != null)
                return false;
        } else if (!crImax.equals(other.crImax))
            return false;
        if (crMax == null) {
            if (other.crMax != null)
                return false;
        } else if (!crMax.equals(other.crMax))
            return false;
        if (crRef == null) {
            if (other.crRef != null)
                return false;
        } else if (!crRef.equals(other.crRef))
            return false;
        if (creance == null) {
            if (other.creance != null)
                return false;
        } else if (!creance.equals(other.creance))
            return false;
        if (credblEnc == null) {
            if (other.credblEnc != null)
                return false;
        } else if (!credblEnc.equals(other.credblEnc))
            return false;
        if (credinstec == null) {
            if (other.credinstec != null)
                return false;
        } else if (!credinstec.equals(other.credinstec))
            return false;
        if (credit == null) {
            if (other.credit != null)
                return false;
        } else if (!credit.equals(other.credit))
            return false;
        if (criRef == null) {
            if (other.criRef != null)
                return false;
        } else if (!criRef.equals(other.criRef))
            return false;
        if (cumulAch == null) {
            if (other.cumulAch != null)
                return false;
        } else if (!cumulAch.equals(other.cumulAch))
            return false;
        if (datDerLi == null) {
            if (other.datDerLi != null)
                return false;
        } else if (!datDerLi.equals(other.datDerLi))
            return false;
        if (datFFac == null) {
            if (other.datFFac != null)
                return false;
        } else if (!datFFac.equals(other.datFFac))
            return false;
        if (datGFac == null) {
            if (other.datGFac != null)
                return false;
        } else if (!datGFac.equals(other.datGFac))
            return false;
        if (datOuvr == null) {
            if (other.datOuvr != null)
                return false;
        } else if (!datOuvr.equals(other.datOuvr))
            return false;
        if (dateContrat == null) {
            if (other.dateContrat != null)
                return false;
        } else if (!dateContrat.equals(other.dateContrat))
            return false;
        if (dateDeNaissance == null) {
            if (other.dateDeNaissance != null)
                return false;
        } else if (!dateDeNaissance.equals(other.dateDeNaissance))
            return false;
        if (dateDebutConge == null) {
            if (other.dateDebutConge != null)
                return false;
        } else if (!dateDebutConge.equals(other.dateDebutConge))
            return false;
        if (dateFinConge == null) {
            if (other.dateFinConge != null)
                return false;
        } else if (!dateFinConge.equals(other.dateFinConge))
            return false;
        if (dateRec == null) {
            if (other.dateRec != null)
                return false;
        } else if (!dateRec.equals(other.dateRec))
            return false;
        if (delai == null) {
            if (other.delai != null)
                return false;
        } else if (!delai.equals(other.delai))
            return false;
        if (derMvt == null) {
            if (other.derMvt != null)
                return false;
        } else if (!derMvt.equals(other.derMvt))
            return false;
        if (domBan == null) {
            if (other.domBan != null)
                return false;
        } else if (!domBan.equals(other.domBan))
            return false;
        if (echeance == null) {
            if (other.echeance != null)
                return false;
        } else if (!echeance.equals(other.echeance))
            return false;
        if (efBanque == null) {
            if (other.efBanque != null)
                return false;
        } else if (!efBanque.equals(other.efBanque))
            return false;
        if (efNrecu == null) {
            if (other.efNrecu != null)
                return false;
        } else if (!efNrecu.equals(other.efNrecu))
            return false;
        if (efPort == null) {
            if (other.efPort != null)
                return false;
        } else if (!efPort.equals(other.efPort))
            return false;
        if (effEnc == null) {
            if (other.effEnc != null)
                return false;
        } else if (!effEnc.equals(other.effEnc))
            return false;
        if (effEsc == null) {
            if (other.effEsc != null)
                return false;
        } else if (!effEsc.equals(other.effEsc))
            return false;
        if (effInst == null) {
            if (other.effInst != null)
                return false;
        } else if (!effInst.equals(other.effInst))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (espece == null) {
            if (other.espece != null)
                return false;
        } else if (!espece.equals(other.espece))
            return false;
        if (facInst == null) {
            if (other.facInst != null)
                return false;
        } else if (!facInst.equals(other.facInst))
            return false;
        if (famille == null) {
            if (other.famille != null)
                return false;
        } else if (!famille.equals(other.famille))
            return false;
        if (faxl == null) {
            if (other.faxl != null)
                return false;
        } else if (!faxl.equals(other.faxl))
            return false;
        if (faxs == null) {
            if (other.faxs != null)
                return false;
        } else if (!faxs.equals(other.faxs))
            return false;
        if (fbkN1 == null) {
            if (other.fbkN1 != null)
                return false;
        } else if (!fbkN1.equals(other.fbkN1))
            return false;
        if (fbkN2 == null) {
            if (other.fbkN2 != null)
                return false;
        } else if (!fbkN2.equals(other.fbkN2))
            return false;
        if (fchpN1 == null) {
            if (other.fchpN1 != null)
                return false;
        } else if (!fchpN1.equals(other.fchpN1))
            return false;
        if (fchpN2 == null) {
            if (other.fchpN2 != null)
                return false;
        } else if (!fchpN2.equals(other.fchpN2))
            return false;
        if (fcreN1 == null) {
            if (other.fcreN1 != null)
                return false;
        } else if (!fcreN1.equals(other.fcreN1))
            return false;
        if (fcreN2 == null) {
            if (other.fcreN2 != null)
                return false;
        } else if (!fcreN2.equals(other.fcreN2))
            return false;
        if (fefnrN1 == null) {
            if (other.fefnrN1 != null)
                return false;
        } else if (!fefnrN1.equals(other.fefnrN1))
            return false;
        if (fefnrN2 == null) {
            if (other.fefnrN2 != null)
                return false;
        } else if (!fefnrN2.equals(other.fefnrN2))
            return false;
        if (fefpN1 == null) {
            if (other.fefpN1 != null)
                return false;
        } else if (!fefpN1.equals(other.fefpN1))
            return false;
        if (fefpN2 == null) {
            if (other.fefpN2 != null)
                return false;
        } else if (!fefpN2.equals(other.fefpN2))
            return false;
        if (fescN1 == null) {
            if (other.fescN1 != null)
                return false;
        } else if (!fescN1.equals(other.fescN1))
            return false;
        if (fescN2 == null) {
            if (other.fescN2 != null)
                return false;
        } else if (!fescN2.equals(other.fescN2))
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (fonction1 == null) {
            if (other.fonction1 != null)
                return false;
        } else if (!fonction1.equals(other.fonction1))
            return false;
        if (freglN1 == null) {
            if (other.freglN1 != null)
                return false;
        } else if (!freglN1.equals(other.freglN1))
            return false;
        if (freglN2 == null) {
            if (other.freglN2 != null)
                return false;
        } else if (!freglN2.equals(other.freglN2))
            return false;
        if (garanties == null) {
            if (other.garanties != null)
                return false;
        } else if (!garanties.equals(other.garanties))
            return false;
        if (gouv1 == null) {
            if (other.gouv1 != null)
                return false;
        } else if (!gouv1.equals(other.gouv1))
            return false;
        if (gouv2 == null) {
            if (other.gouv2 != null)
                return false;
        } else if (!gouv2.equals(other.gouv2))
            return false;
        if (heuresDeTravail == null) {
            if (other.heuresDeTravail != null)
                return false;
        } else if (!heuresDeTravail.equals(other.heuresDeTravail))
            return false;
        if (ibkN1 == null) {
            if (other.ibkN1 != null)
                return false;
        } else if (!ibkN1.equals(other.ibkN1))
            return false;
        if (ibkN2 == null) {
            if (other.ibkN2 != null)
                return false;
        } else if (!ibkN2.equals(other.ibkN2))
            return false;
        if (ichpN1 == null) {
            if (other.ichpN1 != null)
                return false;
        } else if (!ichpN1.equals(other.ichpN1))
            return false;
        if (ichpN2 == null) {
            if (other.ichpN2 != null)
                return false;
        } else if (!ichpN2.equals(other.ichpN2))
            return false;
        if (icreN1 == null) {
            if (other.icreN1 != null)
                return false;
        } else if (!icreN1.equals(other.icreN1))
            return false;
        if (icreN2 == null) {
            if (other.icreN2 != null)
                return false;
        } else if (!icreN2.equals(other.icreN2))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (iefnrN1 == null) {
            if (other.iefnrN1 != null)
                return false;
        } else if (!iefnrN1.equals(other.iefnrN1))
            return false;
        if (iefnrN2 == null) {
            if (other.iefnrN2 != null)
                return false;
        } else if (!iefnrN2.equals(other.iefnrN2))
            return false;
        if (iefpN1 == null) {
            if (other.iefpN1 != null)
                return false;
        } else if (!iefpN1.equals(other.iefpN1))
            return false;
        if (iefpN2 == null) {
            if (other.iefpN2 != null)
                return false;
        } else if (!iefpN2.equals(other.iefpN2))
            return false;
        if (iescN1 == null) {
            if (other.iescN1 != null)
                return false;
        } else if (!iescN1.equals(other.iescN1))
            return false;
        if (iescN2 == null) {
            if (other.iescN2 != null)
                return false;
        } else if (!iescN2.equals(other.iescN2))
            return false;
        if (impaye == null) {
            if (other.impaye != null)
                return false;
        } else if (!impaye.equals(other.impaye))
            return false;
        if (instance == null) {
            if (other.instance != null)
                return false;
        } else if (!instance.equals(other.instance))
            return false;
        if (interet == null) {
            if (other.interet != null)
                return false;
        } else if (!interet.equals(other.interet))
            return false;
        if (ireglN1 == null) {
            if (other.ireglN1 != null)
                return false;
        } else if (!ireglN1.equals(other.ireglN1))
            return false;
        if (ireglN2 == null) {
            if (other.ireglN2 != null)
                return false;
        } else if (!ireglN2.equals(other.ireglN2))
            return false;
        if (jourVisit == null) {
            if (other.jourVisit != null)
                return false;
        } else if (!jourVisit.equals(other.jourVisit))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (margePour == null) {
            if (other.margePour != null)
                return false;
        } else if (!margePour.equals(other.margePour))
            return false;
        if (margeVal == null) {
            if (other.margeVal != null)
                return false;
        } else if (!margeVal.equals(other.margeVal))
            return false;
        if (modReg == null) {
            if (other.modReg != null)
                return false;
        } else if (!modReg.equals(other.modReg))
            return false;
        if (mois1 == null) {
            if (other.mois1 != null)
                return false;
        } else if (!mois1.equals(other.mois1))
            return false;
        if (mois10 == null) {
            if (other.mois10 != null)
                return false;
        } else if (!mois10.equals(other.mois10))
            return false;
        if (mois11 == null) {
            if (other.mois11 != null)
                return false;
        } else if (!mois11.equals(other.mois11))
            return false;
        if (mois12 == null) {
            if (other.mois12 != null)
                return false;
        } else if (!mois12.equals(other.mois12))
            return false;
        if (mois2 == null) {
            if (other.mois2 != null)
                return false;
        } else if (!mois2.equals(other.mois2))
            return false;
        if (mois3 == null) {
            if (other.mois3 != null)
                return false;
        } else if (!mois3.equals(other.mois3))
            return false;
        if (mois4 == null) {
            if (other.mois4 != null)
                return false;
        } else if (!mois4.equals(other.mois4))
            return false;
        if (mois5 == null) {
            if (other.mois5 != null)
                return false;
        } else if (!mois5.equals(other.mois5))
            return false;
        if (mois6 == null) {
            if (other.mois6 != null)
                return false;
        } else if (!mois6.equals(other.mois6))
            return false;
        if (mois7 == null) {
            if (other.mois7 != null)
                return false;
        } else if (!mois7.equals(other.mois7))
            return false;
        if (mois8 == null) {
            if (other.mois8 != null)
                return false;
        } else if (!mois8.equals(other.mois8))
            return false;
        if (mois9 == null) {
            if (other.mois9 != null)
                return false;
        } else if (!mois9.equals(other.mois9))
            return false;
        if (natLiv == null) {
            if (other.natLiv != null)
                return false;
        } else if (!natLiv.equals(other.natLiv))
            return false;
        if (natcaution == null) {
            if (other.natcaution != null)
                return false;
        } else if (!natcaution.equals(other.natcaution))
            return false;
        if (nbTranche == null) {
            if (other.nbTranche != null)
                return false;
        } else if (!nbTranche.equals(other.nbTranche))
            return false;
        if (numRuel == null) {
            if (other.numRuel != null)
                return false;
        } else if (!numRuel.equals(other.numRuel))
            return false;
        if (Double.doubleToLongBits(objectifParJour) != Double.doubleToLongBits(other.objectifParJour))
            return false;
        if (Double.doubleToLongBits(objectifParMois) != Double.doubleToLongBits(other.objectifParMois))
            return false;
        if (observ == null) {
            if (other.observ != null)
                return false;
        } else if (!observ.equals(other.observ))
            return false;
        if (observatio == null) {
            if (other.observatio != null)
                return false;
        } else if (!observatio.equals(other.observatio))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (patron == null) {
            if (other.patron != null)
                return false;
        } else if (!patron.equals(other.patron))
            return false;
        if (postV == null) {
            if (other.postV != null)
                return false;
        } else if (!postV.equals(other.postV))
            return false;
        if (preVen == null) {
            if (other.preVen != null)
                return false;
        } else if (!preVen.equals(other.preVen))
            return false;
        if (Double.doubleToLongBits(primeDeRendement) != Double.doubleToLongBits(other.primeDeRendement))
            return false;
        if (Double.doubleToLongBits(primeDev) != Double.doubleToLongBits(other.primeDev))
            return false;
        if (Double.doubleToLongBits(primeGlobal) != Double.doubleToLongBits(other.primeGlobal))
            return false;
        if (Double.doubleToLongBits(primeParClient) != Double.doubleToLongBits(other.primeParClient))
            return false;
        if (Double.doubleToLongBits(primeStock) != Double.doubleToLongBits(other.primeStock))
            return false;
        if (pseudo == null) {
            if (other.pseudo != null)
                return false;
        } else if (!pseudo.equals(other.pseudo))
            return false;
        if (raison == null) {
            if (other.raison != null)
                return false;
        } else if (!raison.equals(other.raison))
            return false;
        if (rang == null) {
            if (other.rang != null)
                return false;
        } else if (!rang.equals(other.rang))
            return false;
        if (rc == null) {
            if (other.rc != null)
                return false;
        } else if (!rc.equals(other.rc))
            return false;
        if (recFff == null) {
            if (other.recFff != null)
                return false;
        } else if (!recFff.equals(other.recFff))
            return false;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        if (regChq == null) {
            if (other.regChq != null)
                return false;
        } else if (!regChq.equals(other.regChq))
            return false;
        if (regEff == null) {
            if (other.regEff != null)
                return false;
        } else if (!regEff.equals(other.regEff))
            return false;
        if (regEsp == null) {
            if (other.regEsp != null)
                return false;
        } else if (!regEsp.equals(other.regEsp))
            return false;
        if (regVir == null) {
            if (other.regVir != null)
                return false;
        } else if (!regVir.equals(other.regVir))
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        if (regionl == null) {
            if (other.regionl != null)
                return false;
        } else if (!regionl.equals(other.regionl))
            return false;
        if (reglement == null) {
            if (other.reglement != null)
                return false;
        } else if (!reglement.equals(other.reglement))
            return false;
        if (remExp == null) {
            if (other.remExp != null)
                return false;
        } else if (!remExp.equals(other.remExp))
            return false;
        if (remFam == null) {
            if (other.remFam != null)
                return false;
        } else if (!remFam.equals(other.remFam))
            return false;
        if (remOrg == null) {
            if (other.remOrg != null)
                return false;
        } else if (!remOrg.equals(other.remOrg))
            return false;
        if (respon1 == null) {
            if (other.respon1 != null)
                return false;
        } else if (!respon1.equals(other.respon1))
            return false;
        if (reste == null) {
            if (other.reste != null)
                return false;
        } else if (!reste.equals(other.reste))
            return false;
        if (retenue == null) {
            if (other.retenue != null)
                return false;
        } else if (!retenue.equals(other.retenue))
            return false;
        if (ristourne == null) {
            if (other.ristourne != null)
                return false;
        } else if (!ristourne.equals(other.ristourne))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (ruel == null) {
            if (other.ruel != null)
                return false;
        } else if (!ruel.equals(other.ruel))
            return false;
        if (Double.doubleToLongBits(salaire) != Double.doubleToLongBits(other.salaire))
            return false;
        if (sansRet == null) {
            if (other.sansRet != null)
                return false;
        } else if (!sansRet.equals(other.sansRet))
            return false;
        if (soldDep == null) {
            if (other.soldDep != null)
                return false;
        } else if (!soldDep.equals(other.soldDep))
            return false;
        if (soldTerm == null) {
            if (other.soldTerm != null)
                return false;
        } else if (!soldTerm.equals(other.soldTerm))
            return false;
        if (soldeBq == null) {
            if (other.soldeBq != null)
                return false;
        } else if (!soldeBq.equals(other.soldeBq))
            return false;
        if (soldeCpf == null) {
            if (other.soldeCpf != null)
                return false;
        } else if (!soldeCpf.equals(other.soldeCpf))
            return false;
        if (soldeEpf == null) {
            if (other.soldeEpf != null)
                return false;
        } else if (!soldeEpf.equals(other.soldeEpf))
            return false;
        if (soldeImp == null) {
            if (other.soldeImp != null)
                return false;
        } else if (!soldeImp.equals(other.soldeImp))
            return false;
        if (tauxBene == null) {
            if (other.tauxBene != null)
                return false;
        } else if (!tauxBene.equals(other.tauxBene))
            return false;
        if (tauxCom == null) {
            if (other.tauxCom != null)
                return false;
        } else if (!tauxCom.equals(other.tauxCom))
            return false;
        if (tauxMarge == null) {
            if (other.tauxMarge != null)
                return false;
        } else if (!tauxMarge.equals(other.tauxMarge))
            return false;
        if (tauxRem == null) {
            if (other.tauxRem != null)
                return false;
        } else if (!tauxRem.equals(other.tauxRem))
            return false;
        if (tauxRes == null) {
            if (other.tauxRes != null)
                return false;
        } else if (!tauxRes.equals(other.tauxRes))
            return false;
        if (taxe == null) {
            if (other.taxe != null)
                return false;
        } else if (!taxe.equals(other.taxe))
            return false;
        if (telephone != other.telephone)
            return false;
        if (tell == null) {
            if (other.tell != null)
                return false;
        } else if (!tell.equals(other.tell))
            return false;
        if (traite == null) {
            if (other.traite != null)
                return false;
        } else if (!traite.equals(other.traite))
            return false;
        if (tva == null) {
            if (other.tva != null)
                return false;
        } else if (!tva.equals(other.tva))
            return false;
        if (typeConge != other.typeConge)
            return false;
        if (typeContrat != other.typeContrat)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (valRes == null) {
            if (other.valRes != null)
                return false;
        } else if (!valRes.equals(other.valRes))
            return false;
        if (Double.doubleToLongBits(venteParHeure) != Double.doubleToLongBits(other.venteParHeure))
            return false;
        if (villel == null) {
            if (other.villel != null)
                return false;
        } else if (!villel.equals(other.villel))
            return false;
        if (zone == null) {
            if (other.zone != null)
                return false;
        } else if (!zone.equals(other.zone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", adrLiv=" + adrLiv + ", adrSiege=" + adrSiege + ", agence1=" + agence1
                + ", avCom=" + avCom + ", avN1=" + avN1 + ", avance=" + avance + ", avoir=" + avoir + ", bank1=" + bank1
                + ", benefice=" + benefice + ", bl=" + bl + ", bloc=" + bloc + ", caMens=" + caMens + ", caPrev="
                + caPrev + ", caution=" + caution + ", ccb1=" + ccb1 + ", chefMag=" + chefMag + ", cheque=" + cheque
                + ", chifAff1=" + chifAff1 + ", chifAff2=" + chifAff2 + ", chifAff3=" + chifAff3 + ", chqImp=" + chqImp
                + ", chqImpaye=" + chqImpaye + ", chqPf=" + chqPf + ", cin=" + cin + ", classe=" + classe + ", cle="
                + cle + ", cliGroup=" + cliGroup + ", codGrp=" + codGrp + ", codSteq=" + codSteq + ", codUser="
                + codUser + ", codeTva=" + codeTva + ", comission=" + comission + ", command=" + command + ", comptant="
                + comptant + ", cpl=" + cpl + ", cps=" + cps + ", crImax=" + crImax + ", crMax=" + crMax + ", crRef="
                + crRef + ", creance=" + creance + ", credblEnc=" + credblEnc + ", credinstec=" + credinstec
                + ", credit=" + credit + ", criRef=" + criRef + ", cumulAch=" + cumulAch + ", datDerLi=" + datDerLi
                + ", datFFac=" + datFFac + ", datGFac=" + datGFac + ", datOuvr=" + datOuvr + ", dateContrat="
                + dateContrat + ", dateDeNaissance=" + dateDeNaissance + ", dateDebutConge=" + dateDebutConge
                + ", dateFinConge=" + dateFinConge + ", dateRec=" + dateRec + ", delai=" + delai + ", derMvt=" + derMvt
                + ", domBan=" + domBan + ", echeance=" + echeance + ", efBanque=" + efBanque
                + ", efNrecu=" + efNrecu + ", efPort=" + efPort + ", effEnc=" + effEnc + ", effEsc=" + effEsc
                + ", effInst=" + effInst + ", email=" + email + ", espece=" + espece + ", facInst=" + facInst
                + ", famille=" + famille + ", faxl=" + faxl + ", faxs=" + faxs + ", fbkN1=" + fbkN1 + ", fbkN2=" + fbkN2
                + ", fchpN1=" + fchpN1 + ", fchpN2=" + fchpN2 + ", fcreN1=" + fcreN1 + ", fcreN2=" + fcreN2
                + ", fefnrN1=" + fefnrN1 + ", fefnrN2=" + fefnrN2 + ", fefpN1=" + fefpN1 + ", fefpN2=" + fefpN2
                + ", fescN1=" + fescN1 + ", fescN2=" + fescN2 + ", firstname=" + firstname + ", fonction1=" + fonction1
                + ", freglN1=" + freglN1 + ", freglN2=" + freglN2 + ", garanties=" + garanties + ", gouv1=" + gouv1
                + ", gouv2=" + gouv2 + ", heuresDeTravail=" + heuresDeTravail + ", ibkN1=" + ibkN1 + ", ibkN2=" + ibkN2
                + ", ichpN1=" + ichpN1 + ", ichpN2=" + ichpN2 + ", icreN1=" + icreN1 + ", icreN2=" + icreN2 + ", id="
                + id + ", iefnrN1=" + iefnrN1 + ", iefnrN2=" + iefnrN2 + ", iefpN1=" + iefpN1 + ", iefpN2=" + iefpN2
                + ", iescN1=" + iescN1 + ", iescN2=" + iescN2 + ", impaye=" + impaye + ", instance=" + instance
                + ", interet=" + interet + ", ireglN1=" + ireglN1 + ", ireglN2=" + ireglN2 + ", jourVisit=" + jourVisit
                + ", lastname=" + lastname + ", margePour=" + margePour + ", margeVal=" + margeVal + ", modReg="
                + modReg + ", mois1=" + mois1 + ", mois10=" + mois10 + ", mois11=" + mois11 + ", mois12=" + mois12
                + ", mois2=" + mois2 + ", mois3=" + mois3 + ", mois4=" + mois4 + ", mois5=" + mois5 + ", mois6=" + mois6
                + ", mois7=" + mois7 + ", mois8=" + mois8 + ", mois9=" + mois9 + ", natLiv=" + natLiv + ", natcaution="
                + natcaution + ", nbTranche=" + nbTranche + ", numRuel=" + numRuel + ", objectifParJour="
                + objectifParJour + ", objectifParMois=" + objectifParMois + ", observ=" + observ + ", observatio="
                + observatio + ", password=" + password + ", patron=" + patron + ", postV=" + postV + ", preVen="
                + preVen + ", primeDeRendement=" + primeDeRendement + ", primeDev=" + primeDev + ", primeGlobal="
                + primeGlobal + ", primeParClient=" + primeParClient + ", primeStock=" + primeStock + ", pseudo="
                + pseudo + ", raison=" + raison + ", rang=" + rang + ", rc=" + rc + ", recFff=" + recFff
                + ", reference=" + reference + ", regChq=" + regChq + ", regEff=" + regEff + ", regEsp=" + regEsp
                + ", regVir=" + regVir + ", region=" + region + ", regionl=" + regionl + ", reglement=" + reglement
                + ", remExp=" + remExp + ", remFam=" + remFam + ", remOrg=" + remOrg + ", respon1=" + respon1
                + ", reste=" + reste + ", retenue=" + retenue + ", ristourne=" + ristourne + ", roles=" + roles
                + ", ruel=" + ruel + ", salaire=" + salaire + ", sansRet=" + sansRet + ", soldDep=" + soldDep
                + ", soldTerm=" + soldTerm + ", soldeBq=" + soldeBq + ", soldeCpf=" + soldeCpf + ", soldeEpf="
                + soldeEpf + ", soldeImp=" + soldeImp + ", tauxBene=" + tauxBene + ", tauxCom=" + tauxCom
                + ", tauxMarge=" + tauxMarge + ", tauxRem=" + tauxRem + ", tauxRes=" + tauxRes + ", taxe=" + taxe
                + ", telephone=" + telephone + ", tell=" + tell + ", traite=" + traite + ", tva=" + tva
                + ", typeConge=" + typeConge + ", typeContrat=" + typeContrat + ", username=" + username + ", valRes="
                + valRes + ", venteParHeure=" + venteParHeure + ", villel=" + villel + ", zone=" + zone + "]";
    }



    
}