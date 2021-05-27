package com.loizenai.jwtauthentication.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Affaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AffaireRepository extends JpaRepository<Affaire, Long> {
    /**drop down list dor add */
    
        @Query(value = "SELECT * FROM `affaire`", nativeQuery = true)
        public List<Affaire> getAffairesOfAddPrep();

    
    /**drop down list dor add */





    
    /**statistique Article stk */
    @Query(value = "SELECT `COD_FRS` FROM `affaire` GROUP BY `COD_FRS`", nativeQuery = true)
    public List<Long> getSumAvg1();
    @Query(value = "SELECT AVG(`TOTAL_AFF`) FROM `affaire` GROUP BY `COD_FRS`", nativeQuery = true)
    public List<Float> getSumAvg2();


/**statistique bar */
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 0", nativeQuery = true)
public Optional<Float> getSumBar1();
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 1", nativeQuery = true)
public Optional<Float> getSumBar2();
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 2", nativeQuery = true)
public Optional<Float> getSumBar3();
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 3", nativeQuery = true)
public Optional<Float> getSumBar4();
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 4", nativeQuery = true)
public Optional<Float> getSumBar5();
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 5", nativeQuery = true)
public Optional<Float> getSumBar6();
@Query(value = "SELECT sum(`TOTAL_AFF`) FROM `affaire` WHERE WEEKDAY(`DAT_AFF`) = 6", nativeQuery = true)
public Optional<Float> getSumBar7();
}