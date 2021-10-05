package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.model.Xcommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Bon_LivRepository extends JpaRepository<BonLiv, String> {
/**drop down list dor add */

    @Query(value = "SELECT * FROM `bon_liv` WHERE trans_action ='envoyer'", nativeQuery = true)
    public List<BonLiv> getBonLivOfAdd();

/**drop down list dor add */

    //** les query de filtrage */
    @Query(value = "SELECT * FROM `bon_liv` WHERE NUM_BON_LIV LIKE %:numBonL%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByBonLi(@Param("numBonL") String numBonL);

    @Query(value = "SELECT * FROM `bon_liv` WHERE COD_CLI LIKE %:codcli%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByClient(@Param("codcli") String codcli);

    @Query(value = "SELECT * FROM `bon_liv` WHERE DAT_BON  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<BonLiv> getAllBonLivBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `bon_liv` WHERE NUM_FAC LIKE %:numfac%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByNumFac(@Param("numfac") String numfac);

    @Query(value = "SELECT * FROM `bon_liv` WHERE trans_action LIKE %:Trans_action%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByTrasaction(@Param("Trans_action") String Trans_action);

    @Query(value = "SELECT ADRESSE FROM `fournis` WHERE cod_frs = %:cod_frs%", nativeQuery = true)
    public List<String> getAllBonLivByCodFrs(@Param("cod_frs") Long cod_frs);

    @Query(value = "SELECT * FROM `bon_liv` WHERE id_expide LIKE %:id_expide%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByExpidetion(@Param("id_expide") String id_expide);

    @Query(value = "SELECT * FROM `bon_liv` WHERE CENTRE LIKE %:centre%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByCentre(@Param("centre") String centre);

    @Query(value = "SELECT * FROM `bon_liv` WHERE POINTAGE LIKE %:pointage%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByPointage(@Param("pointage") String pointage);

    @Query(value = "SELECT * FROM `bon_liv` WHERE COMMAND LIKE %:command%", nativeQuery = true)
    public List<BonLiv> getAllBonLivByCommand(@Param("command") String command);


    @Query(value = "SELECT DISTINCT NUM_DOC FROM `facture`", nativeQuery = true)
    public List<String> getNumDocFactureForBonLiv();
    /** end searsh */
    List<BonLiv> findByNumCom(Xcommand numCom);
    List<BonLiv> findByNumFac(long numFac);

    @Query(value = "SELECT * FROM `bon_liv` WHERE (`trans_action` LIKE 'envoyer' AND `id_livreur` is NULL AND `LIV` LIKE 'livraison_voiture' AND `CRONO` is NULL)", nativeQuery = true)
    public List<BonLiv> getBLEnvoyer();


    @Query(value = "SELECT * FROM `bon_liv` WHERE (`trans_action` LIKE 'envoyer' AND `id_livreur` is NULL AND `LIV` LIKE 'sur_comptoir' AND `CRONO` is NULL)", nativeQuery = true)
    public List<BonLiv> getBLEnvoyerComptoir();







    /**statistique 3d bar*/
    @Query(value = "Select NUM_BON_LIV,min(TIMEDIFF(`CRONO`,`DAT_BON`)) as Difference From `bon_liv` WHERE `CRONO` is not NULL", nativeQuery = true)
    public Optional<String>  getMinChrono();
    @Query(value = "Select NUM_BON_LIV,max(TIMEDIFF(`CRONO`,`DAT_BON`)) as Difference From `bon_liv` WHERE `CRONO` is not NULL", nativeQuery = true)
    public Optional<String>  getMaxChrono();


    
    @Query(value = "SELECT `COD_FRS`,AVG(`TOT_TTC`) FROM `bon_liv` GROUP BY `COD_FRS`", nativeQuery = true)
    public List getSumAvg();

    /**statistique bar*/
    @Query(value = "SELECT `COD_FRS`,AVG(`TOT_TTC`) as AFieldAVG FROM `bon_liv` GROUP BY `COD_FRS` order by AFieldAVG desc", nativeQuery = true)
    public List<Long> getSumAvgF1();
    @Query(value = "SELECT AVG(`TOT_TTC`) as AFieldAVG FROM `bon_liv` GROUP BY `COD_FRS` order by AFieldAVG desc", nativeQuery = true)
    public List<Float> getSumAvgF2();
    @Query(value = "SELECT `COD_CLI`,AVG(`TOT_TTC`) as AFieldAVG FROM `bon_liv` GROUP BY `COD_CLI` order by AFieldAVG desc", nativeQuery = true)
    public List<String> getSumAvgC1();
    @Query(value = "SELECT AVG(`TOT_TTC`) as AFieldAVG FROM `bon_liv` GROUP BY `COD_CLI` order by AFieldAVG desc", nativeQuery = true)
    public List<Float> getSumAvgC2();

/**statistique pie */
@Query(value = "SELECT COUNT(`trans_action`) FROM `bon_liv` WHERE `trans_action` LIKE 'envoyer'", nativeQuery = true)
public Optional<Integer> getSumR();
@Query(value = "SELECT COUNT(`trans_action`) FROM `bon_liv` WHERE `trans_action` LIKE 'recu'", nativeQuery = true)
public Optional<Integer> getSumE();


/**statistique bar */
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 0", nativeQuery = true)
public Optional<Float> getSumBar1();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 1", nativeQuery = true)
public Optional<Float> getSumBar2();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 2", nativeQuery = true)
public Optional<Float> getSumBar3();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 3", nativeQuery = true)
public Optional<Float> getSumBar4();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 4", nativeQuery = true)
public Optional<Float> getSumBar5();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 5", nativeQuery = true)
public Optional<Float> getSumBar6();
@Query(value = "SELECT sum(`TOT_TTC`) FROM `bon_liv` WHERE WEEKDAY(`DAT_BON`) = 6", nativeQuery = true)
public Optional<Float> getSumBar7();
}