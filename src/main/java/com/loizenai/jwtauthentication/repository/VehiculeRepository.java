package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.Vehicule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, String> {
  
    /**drop down list dor add */

    @Query(value = "SELECT * FROM `vehicule`", nativeQuery = true)
    public List<Vehicule> getVehiculeOfAdd();

    /**drop down list dor add */
}
