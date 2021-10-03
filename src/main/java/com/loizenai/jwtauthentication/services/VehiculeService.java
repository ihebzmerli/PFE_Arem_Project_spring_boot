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

    public List<String> getCouleurVehicule(){
        return repository.getCouleurVehicule();
    }
/** end drop down list */


    /**FILTER DATE */

    public List<Vehicule> getAllVehiculeDT_ACQBydateBetween(String startDate, String endDate){
        return repository.getAllVehiculeDT_ACQBydateBetween(startDate,endDate);
    }

    public List<Vehicule> getAllVehiculedt1mc2BydateBetween(String startDate, String endDate){
        return repository.getAllVehiculedt1mc2BydateBetween(startDate,endDate);
    }

    public List<Vehicule> getAllVehiculedt1mcBydateBetween(String startDate, String endDate){
        return repository.getAllVehiculedt1mcBydateBetween(startDate,endDate);
    }

    public List<Vehicule> getAllVehiculedtfassBydateBetween(String startDate, String endDate){
        return repository.getAllVehiculedtfassBydateBetween(startDate,endDate);
    }

    public List<Vehicule> getAllVehiculedtfvisitBydateBetween(String startDate, String endDate){
        return repository.getAllVehiculedtfvisitBydateBetween(startDate,endDate);
    }
    /**end filter date */
}
