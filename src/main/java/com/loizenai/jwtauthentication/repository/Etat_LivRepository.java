package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.EtatLiv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface Etat_LivRepository extends JpaRepository<EtatLiv, Long> {
    List<EtatLiv> findByRegion(String region);
    
       //** les query de filtrage */

       @Query(value = "SELECT * FROM `etat_liv` WHERE REGION LIKE %:region%", nativeQuery = true)
       public List<EtatLiv> getAllEtatLivByRegion(@Param("region") String region);


       @Query(value = "SELECT * FROM `etat_liv` WHERE CONFIRMATION LIKE %:confirma%", nativeQuery = true)
       public List<EtatLiv> getAllEtatLivByConfirmation(@Param("confirma") String confirma);

       @Query(value = "SELECT * FROM `etat_liv` WHERE num_bon_liv LIKE %:bon_liv%", nativeQuery = true)
       public List<EtatLiv> getAllEtatLivByBL(@Param("bon_liv") String bon_liv);

       @Query(value = "SELECT * FROM `etat_liv` WHERE DATE  BETWEEN :startDate AND :endDate", nativeQuery = true)
       public List<EtatLiv> getAllEtatLivBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

       @Query(value = "SELECT TIMEDIFF('%:endDate%','%:startDate%')", nativeQuery = true)
       public Optional<Timestamp> getEtatCronometre(@Param("endDate") String endDate,@Param("startDate") String startDate);
           /** end searsh */






        /**statistique recu_non_verifier multi - x axis*/
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=1 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar1();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=2 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar2();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=3 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar3();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=4 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar4();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=5 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar5();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=6 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar6();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=7 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar7();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=8 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar8();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=9 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar9();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=10 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar10();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=11 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar11();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=12 AND CONFIRMATION LIKE 'recu_non_verifier'", nativeQuery = true)
public Optional<Integer> getSumBar12();

        /**statistique recu_est_verifier multi - x axis*/
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=1 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar21();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=2 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar22();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=3 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar23();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=4 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar24();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=5 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar25();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=6 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar26();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=7 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar27();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=8 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar28();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=9 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar29();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=10 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar210();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=11 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar211();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=12 AND CONFIRMATION LIKE 'recu_est_verifier'", nativeQuery = true)
        public Optional<Integer> getSumBar212();

        
                /**statistique  multi - x axis*/
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=1 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar31();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=2 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar32();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=3 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar33();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=4 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar34();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=5 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar35();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=6 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar36();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=7 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar37();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=8 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar38();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=9 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar39();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=10 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar310();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=11 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar311();
@Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=12 AND CONFIRMATION LIKE 'un_problem_a_la_reception'", nativeQuery = true)
public Optional<Integer> getSumBar312();


        /**statistique  multi - x axis*/
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=1 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar41();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=2 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar42();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=3 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar43();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=4 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar44();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=5 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar45();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=6 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar46();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=7 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar47();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=8 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar48();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=9 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar49();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=10 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar410();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=11 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar411();
        @Query(value = "SELECT COUNT(*) FROM `etat_liv` WHERE YEAR(`DATE`) LIKE YEAR(NOW()) AND MONTH(`DATE`)=12 AND CONFIRMATION LIKE 'n_est_pas_recu'", nativeQuery = true)
        public Optional<Integer> getSumBar412();
        
}
