package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.BonPrep;
import com.loizenai.jwtauthentication.model.Expide;
import com.loizenai.jwtauthentication.model.Xcommand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Bon_PrepRepository extends JpaRepository<BonPrep, String> {

    /**drop down list dor add */
    @Query(value = "SELECT NUM_BON_PREP FROM `bon_prep` WHERE NUM_BON_PREP IS NOT NULL", nativeQuery = true)
    public List<String> getBonPrepOfAdd();
    
    /**drop down list dor add */


    @Query(value = "SELECT * FROM `bon_prep` WHERE NUM_BON_PREP LIKE %:numBonPp%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByNumBonPre(@Param("numBonPp") String numBonPp);

    @Query(value = "SELECT * FROM `bon_prep` WHERE DAT_BON  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<BonPrep> getAllBonPrepBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `bon_prep` WHERE COD_CLI LIKE %:codcli%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByClient(@Param("codcli") String codcli);

    @Query(value = "SELECT * FROM `bon_prep` WHERE POINTAGE LIKE %:Pointage%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByPointage(@Param("Pointage") String Pointage);  /** if all bon sortie all pointer ,Pointage té5ou valeur vrais ijibhom ilkoll */

    @Query(value = "SELECT * FROM `bon_prep` WHERE NAT_LIV LIKE %:NatLiv%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByNatLivraison(@Param("NatLiv") String NatLiv);                /** if il nature est saisi melouwel donc yfeltri ili bich yorjou b type */
    
    @Query(value = "SELECT * FROM `bon_prep` WHERE POINT LIKE %:Point%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByPointeur(@Param("Point") String Point);

    @Query(value = "SELECT * FROM `bon_prep` WHERE AIDE_MAG LIKE %:AideMag%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByAideMag(@Param("AideMag") String AideMag);

    @Query(value = "SELECT * FROM `bon_prep` WHERE CENTRE LIKE %:Centre%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByCentre(@Param("Centre") String Centre);

    @Query(value = "SELECT * FROM `bon_prep` WHERE id LIKE %:userId%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByUserId(@Param("userId") String userId);

    @Query(value = "SELECT * FROM `bon_prep` WHERE num_doc LIKE %:numdoc%", nativeQuery = true)
    public List<BonPrep> getAllBonPrepByNumDoc(@Param("numdoc") String numdoc);




/**statistique bar horisontale*/
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE YEAR(`DAT_PREP`) LIKE YEAR(NOW())", nativeQuery = true)
public Optional<Integer> getSumD1();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE YEAR(`DAT_PREP`) LIKE YEAR(NOW()- interval 1 year)", nativeQuery = true)
public Optional<Integer> getSumD2();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE YEAR(`DAT_PREP`) LIKE YEAR(NOW()- interval 2 year)", nativeQuery = true)
public Optional<Integer> getSumD3();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE YEAR(`DAT_PREP`) LIKE YEAR(NOW()- interval 3 year)", nativeQuery = true)
public Optional<Integer> getSumD4();
/**statistique pie*/
@Query(value = "SELECT COUNT(`NAT_LIV`) FROM `bon_prep` WHERE `NAT_LIV` LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumC();
@Query(value = "SELECT COUNT(`NAT_LIV`) FROM `bon_prep` WHERE `NAT_LIV` LIKE 'livraison'", nativeQuery = true)
public Optional<Integer> getSumL();

/**statistique bar */
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 0", nativeQuery = true)
public Optional<Float> getSumBar1();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 1", nativeQuery = true)
public Optional<Float> getSumBar2();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 2", nativeQuery = true)
public Optional<Float> getSumBar3();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 3", nativeQuery = true)
public Optional<Float> getSumBar4();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 4", nativeQuery = true)
public Optional<Float> getSumBar5();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 5", nativeQuery = true)
public Optional<Float> getSumBar6();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_prep` WHERE WEEKDAY(`DAT_BON`) = 6", nativeQuery = true)
public Optional<Float> getSumBar7();
}