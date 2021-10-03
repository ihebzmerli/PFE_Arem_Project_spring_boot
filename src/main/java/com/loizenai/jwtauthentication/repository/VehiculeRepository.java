package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.Vehicule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, String> {
  
    /**drop down list dor add */

    @Query(value = "SELECT * FROM `vehicule`", nativeQuery = true)
    public List<Vehicule> getVehiculeOfAdd();

    @Query(value = "SELECT DISTINCT couleur FROM `vehicule`", nativeQuery = true)
    public List<String> getCouleurVehicule();
    /**drop down list dor add */


    /**FILTER DATE */

    @Query(value = "SELECT * FROM `vehicule` WHERE DT_ACQ  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Vehicule> getAllVehiculeDT_ACQBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `vehicule` WHERE dt1mc2  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Vehicule> getAllVehiculedt1mc2BydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `vehicule` WHERE dt1mc  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Vehicule> getAllVehiculedt1mcBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `vehicule` WHERE dtfass  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Vehicule> getAllVehiculedtfassBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `vehicule` WHERE dtfvisit  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Vehicule> getAllVehiculedtfvisitBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
