package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.Prime;
import com.loizenai.jwtauthentication.repository.PrimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimeService {
        
    @Autowired
    private PrimeRepository repository;

    public List<Prime> getPrimes(){
        return repository.findAll();
    }

    public void addPrime(Prime prime){
        repository.save(prime);
    }

    public Prime updatePrime(Prime prime){
       return repository.save(prime);
    }

    public void deleteLivreur(Long id){
        repository.deleteById(id);
    }

/** add  drop down list */

public List<Long> getLivs_PrimesOfAdd(){
    return repository.getLivs_PrimesOfAdd();
}

/** end drop down list */

        /** start les searsh from repository */

        public List<Prime>getAllPrimeByCategorie(String nom){
            return repository.getAllPrimeByCategorie(nom);
        }
        
        public List<Prime>getAllPrimeByPrime(String prime){
            return repository.getAllPrimeByPrime(prime);
        }
            
        public List<Prime>getAllPrimeByBloc(String bloc){
            return repository.getAllPrimeByBloc(bloc);
        }
        public List<Prime>getAllPrimeByDerMvt(String d_mvt){
            return repository.getAllPrimeByDerMvt(d_mvt);
        }
        
    /** end les searsh from repository */
}
