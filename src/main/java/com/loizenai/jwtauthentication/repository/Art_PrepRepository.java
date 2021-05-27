package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtPrep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Art_PrepRepository extends JpaRepository<ArtPrep, Long> {
    
/**drop down list dor add */
    
    @Query(value = "SELECT COD_ART,DES_ART FROM `article` WHERE COD_ART IS NOT NULL AND DES_ART IS NOT NULL", nativeQuery = true)
    public List<String> getArtPrepOfAdd();

    @Query(value = "SELECT * FROM `bon_preps_articles` WHERE num_bon_prep LIKE %:num_bon_prep%", nativeQuery = true)
    public List<ArtPrep> getArtPrepForBonPrep(@Param("num_bon_prep") String num_bon_prep);
    
    @Query(value = "SELECT * FROM `bon_preps_articles` WHERE num_char LIKE %:num_char%", nativeQuery = true)
    public List<ArtPrep> getArtPrepByChariot(@Param("num_char") String num_char);
/**drop down list dor add */

@Query(value = "SELECT * FROM `bon_preps_articles` WHERE num_bon_prep LIKE %:num_bon_prep% AND cod_art LIKE %:cod_art%", nativeQuery = true)
public Optional<ArtPrep> getArtPrepBP_CA(@Param("num_bon_prep") String num_bon_prep,@Param("cod_art") String cod_art);

@Query(value = "SELECT SUM(`prix_ach`) FROM `bon_preps_articles` WHERE `num_bon_prep` LIKE %:num_bon_prep%", nativeQuery = true)
public Optional<Integer> getSumQutByBPach(@Param("num_bon_prep") String num_bon_prep);
@Query(value = "SELECT SUM(`prix_ht`) FROM `bon_preps_articles` WHERE `num_bon_prep` LIKE %:num_bon_prep%", nativeQuery = true)
public Optional<Integer> getSumQutByBPht(@Param("num_bon_prep") String num_bon_prep);
@Query(value = "SELECT SUM(`PRIX_AREM`) FROM `bon_preps_articles` WHERE `num_bon_prep` LIKE %:num_bon_prep%", nativeQuery = true)
public Optional<Integer> getSumQutByBPAREM(@Param("num_bon_prep") String num_bon_prep);


@Modifying
@Query(value = "UPDATE `bon_preps_articles` SET `POINTAGE_CHARIOT`=NOW() WHERE (SELECT max(`DAT_PREP`)) AND `num_char` LIKE %:num_char% AND `POINTAGE_CHARIOT` is null", nativeQuery = true)
public void ChronoChariotPointage(long num_char);

@Modifying
@Query(value = "UPDATE `bon_preps_articles` SET `CHRONO`=TIMEDIFF(`POINTAGE_CHARIOT`,`DAT_PREP`) WHERE (SELECT max(`DAT_PREP`)) AND `num_char` LIKE %:num_char% AND `CHRONO` is NULL AND `POINTAGE_CHARIOT` IS NOT NULL", nativeQuery = true)
public void  ChangeChrono(long num_char);
}
