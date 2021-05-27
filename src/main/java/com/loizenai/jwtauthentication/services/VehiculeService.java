package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.Vehicule;
import com.loizenai.jwtauthentication.repository.VehiculeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeService {
    
    
    @Autowired
    private VehiculeRepository repository;

    public List<Vehicule> getVehicules(){
        return repository.findAll();
    }

    public void addVehicule(Vehicule vehicule){
        repository.save(vehicule);
    }

    public Vehicule updateVehicule(Vehicule vehicule){
        return repository.save(vehicule);
    }

    public void deleteVehicule(String matricule){
        repository.deleteById(matricule);
    }

/** end drop down list */

    public List<Vehicule> getVehiculeOfAdd(){
        return repository.getVehiculeOfAdd();
    }

/** end drop down list */
}
