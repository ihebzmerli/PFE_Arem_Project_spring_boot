package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.model.Expide;
import com.loizenai.jwtauthentication.model.Livreur;
import com.loizenai.jwtauthentication.model.Livreur_Expide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpideRepository extends JpaRepository<Expide, Long> {
    /**drop down list dor add */

    @Query(value = "SELECT DATE_FORMAT(DATE_EXPEDITION,'%d/%m/%Y') FROM `expide` WHERE DATE_FORMAT(DATE_EXPEDITION,'%d/%m/%Y') = DATE_FORMAT(SYSDATE(),'%d/%m/%Y')", nativeQuery = true)
    public List<Date> getExpideOfAddForBonPrep();

    @Query(value = "SELECT DATE_EXPEDITION FROM `expide`", nativeQuery = true)
    public List<Date> getExpideOfAdd();
    

    /**drop down list dor add */

       //** les query de filtrage */


       @Query(value = "SELECT * FROM `expide` WHERE TYPE_DOC LIKE %:typeDoc%", nativeQuery = true)
       public List<Expide> getAllExpideByTypDoc(@Param("typeDoc") String typeDoc);

       @Query(value = "SELECT * FROM `expide` WHERE MATRICULE LIKE %:matricule%", nativeQuery = true)
       public List<Expide> getAllExpideByMatricule(@Param("matricule") String matricule);

       @Query(value = "SELECT * FROM `expide` WHERE TRANSP LIKE %:transporter%", nativeQuery = true)
       public List<Expide> getAllExpideByTransp(@Param("transporter") String transporter);

       @Query(value = "SELECT * FROM `expide` WHERE TYP_EXP LIKE %:typExp%", nativeQuery = true)
       public List<Expide> getAllExpideByTypExp(@Param("typExp") String typExp);

       @Query(value = "SELECT * FROM `expide` WHERE DATE_EXPEDITION  BETWEEN :startDate AND :endDate", nativeQuery = true)
       public List<Expide> getAllExpideBydateEXBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);



           /** end searsh */





    /**statistique pie */
@Query(value = "SELECT COUNT(`TYP_EXP`) FROM `expide` WHERE TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumT1();
@Query(value = "SELECT COUNT(`TYP_EXP`) FROM `expide` WHERE TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumT2();




/**statistique bar horizontale */
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=1", nativeQuery = true)
public Optional<Integer> getSumM11();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=2", nativeQuery = true)
public Optional<Integer> getSumM12();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=3", nativeQuery = true)
public Optional<Integer> getSumM13();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=4", nativeQuery = true)
public Optional<Integer> getSumM14();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=5", nativeQuery = true)
public Optional<Integer> getSumM15();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=6", nativeQuery = true)
public Optional<Integer> getSumM16();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=7", nativeQuery = true)
public Optional<Integer> getSumM17();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=8", nativeQuery = true)
public Optional<Integer> getSumM18();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=9", nativeQuery = true)
public Optional<Integer> getSumM19();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=10", nativeQuery = true)
public Optional<Integer> getSumM110();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=11", nativeQuery = true)
public Optional<Integer> getSumM111();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND MONTH(`DATE_EXPEDITION`)=12", nativeQuery = true)
public Optional<Integer> getSumM112();



@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=1", nativeQuery = true)
public Optional<Integer> getSumM21();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=2", nativeQuery = true)
public Optional<Integer> getSumM22();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=3", nativeQuery = true)
public Optional<Integer> getSumM23();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=4", nativeQuery = true)
public Optional<Integer> getSumM24();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=5", nativeQuery = true)
public Optional<Integer> getSumM25();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=6", nativeQuery = true)
public Optional<Integer> getSumM26();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=7", nativeQuery = true)
public Optional<Integer> getSumM27();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=8", nativeQuery = true)
public Optional<Integer> getSumM28();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=9", nativeQuery = true)
public Optional<Integer> getSumM29();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=10", nativeQuery = true)
public Optional<Integer> getSumM210();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=11", nativeQuery = true)
public Optional<Integer> getSumM211();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND MONTH(`DATE_EXPEDITION`)=12", nativeQuery = true)
public Optional<Integer> getSumM212();




/**statistique bar horizontale */
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA11();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA12();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 2 year) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA13();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 3 year) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA14();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 4 year) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA15();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 5 year) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA16();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 6 year) AND TYP_EXP LIKE 'livraison_voiture'", nativeQuery = true)
public Optional<Integer> getSumA17();


@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA21();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 1 year) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA22();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 2 year) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA23();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 3 year) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA24();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 4 year) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA25();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 5 year) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA26();
@Query(value = "SELECT count(*) FROM `expide` WHERE YEAR(`DATE_EXPEDITION`) LIKE YEAR(NOW()- interval 6 year) AND TYP_EXP LIKE 'sur_comptoir'", nativeQuery = true)
public Optional<Integer> getSumA27();

}