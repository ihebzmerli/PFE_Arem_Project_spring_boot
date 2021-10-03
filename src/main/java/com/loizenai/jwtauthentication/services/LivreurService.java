package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Livreur;
import com.loizenai.jwtauthentication.repository.LivreurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreurService {
        
    @Autowired
    private LivreurRepository repository;

    public List<Livreur> getLivreurs(){
        return repository.findAll();
    }

    public void addLivreur(Livreur livreur){
        repository.save(livreur);
    }

    public Livreur updateLivreur(Livreur livreur){
       return repository.save(livreur);
    }

    public void deleteLivreur(long id){
        repository.deleteById(id);
    }


    public List<Livreur> getAllEtatLivdat_reclamBydateBetween(String startDate, String endDate){
        return repository.getAllEtatLivdat_reclamBydateBetween(startDate,endDate);
    }

    public List<Livreur> getAllEtatLivdat_reponBydateBetween(String startDate, String endDate){
        return repository.getAllEtatLivdat_reponBydateBetween(startDate,endDate);
    }

    public List<Livreur> getAllEtatLivdateBydateBetween(String startDate, String endDate){
        return repository.getAllEtatLivdateBydateBetween(startDate,endDate);
    }

    /** add  drop down list */

    public List<Livreur> getLivreurOfAdd(){
        return repository.getLivreurOfAdd();
    }

    /** end drop down list */

    /** start les searsh from repository */

        public List<Livreur>getAllLivreurByNom(String nom){
            return repository.getAllLivreurByNom(nom);
        }
        
        public List<Livreur>getAllLivreurByCentre(String centre){
            return repository.getAllLivreurByCentre(centre);
        }
            
        public List<Livreur>getAllLivreurByQutArt(String qutart){
            return repository.getAllLivreurByQutArt(qutart);
        }
        public List<Livreur>getAllLivreurByExpide(String expide){
            return repository.getAllLivreurByExpide(expide);
        }
        
    /** end les searsh from repository */







/**statistique Pie Livreur  */

public Optional<Integer> getSumL1(){
    return repository.getSumL1();
}
public Optional<Integer> getSumL2(){
    return repository.getSumL2();
}
public Optional<Integer> getSumL3(){
    return repository.getSumL3();
}    
}
