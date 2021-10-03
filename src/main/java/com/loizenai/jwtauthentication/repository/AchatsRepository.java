package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Achats;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface AchatsRepository extends JpaRepository<Achats, Long> {
    /**drop down list start add */


/*    @Query(value = "SELECT * FROM `achats` WHERE DOC_REG LIKE %:docReg%", nativeQuery = true)
    public Optional<Achats> findByDocReg(String docReg);
  */  
  
    Optional<Achats> findByDocReg(String docReg);
    
        @Query(value = "SELECT * FROM `achats` WHERE NUM_DOC IS NOT NULL AND TYP_DOC = 'BON LIV.' AND PRET = 'payer' ", nativeQuery = true)
        public List<Achats> getAchatsOfAddPrep();
    

        @Modifying
        @Query(value = "UPDATE `achats` SET `VALIDATION`='valider' WHERE `NUM_DOC` LIKE %:numDocAchat% ", nativeQuery = true)
        public void ChangeAchatToValidate(long numDocAchat);
        @Modifying
        @Query(value = "UPDATE `achats` SET `VALIDATION`='non_valider' WHERE `NUM_DOC` LIKE %:numDocAchat% ", nativeQuery = true)
        public void ChangeAchatToNotValidate(long numDocAchat);
    /**drop down list end add */




    @Query(value = "SELECT * FROM `achats` WHERE date  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Achats> getAllAchatsBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);




/**statistique pie */
@Query(value = "SELECT COUNT(`PRET`) FROM `achats` WHERE PRET LIKE 'non_payer'", nativeQuery = true)
public Optional<Integer> getSumP1();
@Query(value = "SELECT COUNT(`PRET`) FROM `achats` WHERE PRET LIKE 'payer'", nativeQuery = true)
public Optional<Integer> getSumP2();
@Query(value = "SELECT COUNT(`VALIDATION`) FROM `achats` WHERE VALIDATION LIKE 'valider'", nativeQuery = true)
public Optional<Integer> getSumV1();
@Query(value = "SELECT COUNT(`VALIDATION`) FROM `achats` WHERE VALIDATION LIKE 'non_valider'", nativeQuery = true)
public Optional<Integer> getSumV2();


/**statistique bar */
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 0", nativeQuery = true)
public Optional<Float> getSumBar1();
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 1", nativeQuery = true)
public Optional<Float> getSumBar2();
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 2", nativeQuery = true)
public Optional<Float> getSumBar3();
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 3", nativeQuery = true)
public Optional<Float> getSumBar4();
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 4", nativeQuery = true)
public Optional<Float> getSumBar5();
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 5", nativeQuery = true)
public Optional<Float> getSumBar6();
@Query(value = "SELECT sum(`MONTANT`) FROM `achats` WHERE WEEKDAY(`DATE`) = 6", nativeQuery = true)
public Optional<Float> getSumBar7();
}