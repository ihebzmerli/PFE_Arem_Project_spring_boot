package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.Rectif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectifRepository extends JpaRepository<Rectif, Long> {

    //** les query de filtrage */

    @Query(value = "SELECT * FROM `rectif` WHERE DATE BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<Rectif> getAllRectifBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `rectif` WHERE NUM_DOC LIKE %:numDoc%", nativeQuery = true)
    public List<Rectif> getAllRectifByAchats(@Param("numDoc") String numDoc);

    @Query(value = "SELECT * FROM `rectif` WHERE QUT_ART BETWEEN :MinQ_art AND :MaxQ_art", nativeQuery = true)
    public List<Rectif> getAllRectifByQutArt(@Param("MinQ_art") String MinQ_art, @Param("MaxQ_art") String MaxQ_art);

    @Query(value = "SELECT * FROM `rectif` WHERE PRIX_ACH BETWEEN :MinP_ach AND :MaxP_ach", nativeQuery = true)
    public List<Rectif> getAllRectifByPrixAch(@Param("MinP_ach") String MinP_ach, @Param("MaxP_ach") String MaxP_ach);
    
    @Query(value = "SELECT * FROM `rectif` WHERE TYP_MVT LIKE %:Ty_mvt%", nativeQuery = true)
    public List<Rectif> getAllRectifByTyMvt(@Param("Ty_mvt") String Ty_mvt);

    @Query(value = "SELECT * FROM `rectif` WHERE NUM_REC LIKE %:Numrec%", nativeQuery = true)
    public List<Rectif> getAllRectifByNumRec(@Param("Numrec") String Numrec);

    @Query(value = "SELECT * FROM `rectif` WHERE CENTRE LIKE %:center%", nativeQuery = true)
    public List<Rectif> getAllRectifByCentre(@Param("center") String center);

    @Query(value = "SELECT * FROM `rectif` WHERE DATE_RECLAM BETWEEN :startDateReclama AND :endDateReclama", nativeQuery = true)
    public List<Rectif> getAllRectifBydateReclamBetween(@Param("startDateReclama") String startDateReclama, @Param("endDateReclama") String endDateReclama);

    @Query(value = "SELECT * FROM `rectif` WHERE DATE_REPON BETWEEN :startDateRepon AND :endDateRepon", nativeQuery = true)
    public List<Rectif> getAllRectifBydateReponBetween(@Param("startDateRepon") String startDateRepon, @Param("endDateRepon") String endDateRepon);

    @Query(value = "SELECT * FROM `rectif` WHERE DATE_CLOTUR BETWEEN :startDateClotur AND :endDateClotur", nativeQuery = true)
    public List<Rectif> getAllRectifBydateCloturBetween(@Param("startDateClotur") String startDateClotur, @Param("endDateClotur") String endDateClotur);

    //** les query de filtrage */
    
}