package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.livreurs_primes;
import com.loizenai.jwtauthentication.repository.livreurs_primesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class livreurs_primesService {
      
    @Autowired
    private livreurs_primesRepository repository;

    public List<livreurs_primes> getLivreurs_Primes(){
        return repository.findAll();
    }

    public void addLivreur_Prime(livreurs_primes livreurs_primes){
        repository.save(livreurs_primes);
    }

    public livreurs_primes updateLivreur_Prime(livreurs_primes livreurs_primes){
       return repository.save(livreurs_primes);
    }

    public void deleteLivreur_Prime(long id_livreur_prime){
        repository.deleteById(id_livreur_prime);
    }

    public List<livreurs_primes>getAllPrimeByLivreur(String id_livreur){
        return repository.getAllPrimeByLivreur(id_livreur);
    }  
}
