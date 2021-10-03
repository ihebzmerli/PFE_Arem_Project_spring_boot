package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.Livreur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivreurRepository extends JpaRepository<Livreur, Long> {

/**drop down list dor add */

    @Query(value = "SELECT * FROM `livreur` WHERE NOM IS NOT NULL AND NATURE ='EN_ATTEND'", nativeQuery = true)
    public List<Livreur> getLivreurOfAdd();

/**drop down list dor add */

    //** les query de filtrage */

    @Query(value = "SELECT * FROM `livreur` WHERE NOM LIKE %:nom%", nativeQuery = true)
    public List<Livreur> getAllLivreurByNom(@Param("nom") String nom);

    @Query(value = "SELECT * FROM `livreur` WHERE centre LIKE %:centre%", nativeQuery = true)
    public List<Livreur> getAllLivreurByCentre(@Param("centre") String centre);

    @Query(value = "SELECT * FROM `livreur` WHERE qut_art LIKE %:qutart%", nativeQuery = true)
    public List<Livreur> getAllLivreurByQutArt(@Param("qutart") String qutart);

    @Query(value = "SELECT * FROM `livreur` WHERE id_expide LIKE %:expide%", nativeQuery = true)
    public List<Livreur> getAllLivreurByExpide(@Param("expide") String expide);


    @Query(value = "SELECT * FROM `livreur` WHERE dat_reclam  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Livreur> getAllEtatLivdat_reclamBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `livreur` WHERE dat_repon  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Livreur> getAllEtatLivdat_reponBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `livreur` WHERE date  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Livreur> getAllEtatLivdateBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);




    /**statistique pie*/
@Query(value = "SELECT COUNT(`NATURE`) FROM `livreur` WHERE `NATURE` LIKE 'PAS_PRESENT'", nativeQuery = true)
public Optional<Integer> getSumL1();
@Query(value = "SELECT COUNT(`NATURE`) FROM `livreur` WHERE `NATURE` LIKE 'EN_MISSION'", nativeQuery = true)
public Optional<Integer> getSumL2();
@Query(value = "SELECT COUNT(`NATURE`) FROM `livreur` WHERE `NATURE` LIKE 'EN_ATTEND'", nativeQuery = true)
public Optional<Integer> getSumL3();   

}