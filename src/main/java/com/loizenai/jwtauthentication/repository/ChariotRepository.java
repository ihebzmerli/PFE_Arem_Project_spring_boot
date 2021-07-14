package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.BonPrep;
import com.loizenai.jwtauthentication.model.BonSort;
import com.loizenai.jwtauthentication.model.Chariot;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChariotRepository extends JpaRepository<Chariot, Long> {

    /**drop down list dor add */
    @Query(value = "SELECT * FROM `chariot` WHERE NUM_CHAR IS NOT NULL", nativeQuery = true)
    public List<Chariot> getChariotOfAddForBonPrep();

    /**drop down list dor add */

    
//    List<Chariot> findByNumBon(BonPrep numBon);

    @Query(value = "SELECT * FROM `chariot` WHERE id_artprep LIKE %:IdArtPrep%", nativeQuery = true)
    public List<Chariot> getAllChariotByArticle(@Param("IdArtPrep") String IdArtPrep);

    @Query(value = "SELECT * FROM `chariot` WHERE call_chariot  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Chariot> getAllChariotBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    /** end searsh */
    @Query(value = "SELECT MAX(NUM_CHAR) FROM `chariot`", nativeQuery = true)
    public Optional<Integer> getLastIdChariot();

    @Modifying
    @Query(value = "UPDATE `chariot` SET `ETAT_CHAR`='occuper' WHERE `NUM_CHAR` LIKE %:numChar% ", nativeQuery = true)
    public void ChangeChariotEtat(long numChar);
    @Modifying
    @Query(value = "UPDATE `chariot` SET `ETAT_CHAR`='en_attente' WHERE `NUM_CHAR` LIKE %:numChar% ", nativeQuery = true)
    public void ChangeChariotEtatEnAttent(long numChar);

    /**statistique pie*/
@Query(value = "SELECT COUNT(`ETAT_CHAR`) FROM `chariot` WHERE `ETAT_CHAR` LIKE 'occuper'", nativeQuery = true)
public Optional<Integer> getSumCha1();
@Query(value = "SELECT COUNT(`ETAT_CHAR`) FROM `chariot` WHERE `ETAT_CHAR` LIKE 'en_attente'", nativeQuery = true)
public Optional<Integer> getSumCha2();
@Query(value = "SELECT COUNT(`ETAT_CHAR`) FROM `chariot` WHERE `ETAT_CHAR` LIKE 'en_panne'", nativeQuery = true)
public Optional<Integer> getSumCha3();
}