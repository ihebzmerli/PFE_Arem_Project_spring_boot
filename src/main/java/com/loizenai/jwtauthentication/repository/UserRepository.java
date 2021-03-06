package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loizenai.jwtauthentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM `users` WHERE `username` LIKE %:username%", nativeQuery = true)
    public User getUserNameForAuthorisation(String username);

    @Query(value = "SELECT * FROM `users` WHERE `email` LIKE %:email%", nativeQuery = true)
    public User getRequestPassword(String email);

    @Query(value = "SELECT id FROM `users` WHERE `username` LIKE %:username%", nativeQuery = true)
    public Integer getUserByUsername(String username);


/**FILTER DATE */

    @Query(value = "SELECT * FROM `users` WHERE datffac  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserdatffacBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `users` WHERE date_contrat  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserdate_contratBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `users` WHERE date_de_naissance  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserdate_de_naissanceBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `users` WHERE date_debut_conge  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserdate_debut_congeBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM `users` WHERE date_fin_conge  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserdate_fin_congeBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    @Query(value = "SELECT * FROM `users` WHERE date_rec  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserdate_recBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
        
    @Query(value = "SELECT * FROM `users` WHERE der_mvt  BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<User> getAllUserder_mvtBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    
    
/**FILTER DATE */

    /**statistique pie */
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 1", nativeQuery = true)
public Optional<Integer> getSumROLE_USER();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 2", nativeQuery = true)
public Optional<Integer> getSumROLE_ADMIN();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 3", nativeQuery = true)
public Optional<Integer> getSumROLE_ACHETEUR();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 4", nativeQuery = true)
public Optional<Integer> getSumROLE_TRANSITAIRE();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 5", nativeQuery = true)
public Optional<Integer> getSumROLE_CLIENT();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 6", nativeQuery = true)
public Optional<Integer> getSumROLE_VENDEUR();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 7", nativeQuery = true)
public Optional<Integer> getSumROLE_DECIDEUR_BP();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 8", nativeQuery = true)
public Optional<Integer> getSumROLE_AGENT_CAB();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 9", nativeQuery = true)
public Optional<Integer> getSumROLE_PREPARATEUR_BR();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 10", nativeQuery = true)
public Optional<Integer> getSumROLE_RESPONSABLE_DISPATCHING_BP();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 11", nativeQuery = true)
public Optional<Integer> getSumROLE_PREPARATEUR();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 12", nativeQuery = true)
public Optional<Integer> getSumROLE_VALIDATEUR_DE_CHARIOT();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 13", nativeQuery = true)
public Optional<Integer> getSumROLE_RESPONSABLE_POINTAGE();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 14", nativeQuery = true)
public Optional<Integer> getSumROLE_EMBALLEUR();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 15", nativeQuery = true)
public Optional<Integer> getSumROLE_EXPEDITEUR();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 16", nativeQuery = true)
public Optional<Integer> getSumROLE_AGENT_SAISIE_REG();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 17", nativeQuery = true)
public Optional<Integer> getSumROLE_CAISSIER();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 18", nativeQuery = true)
public Optional<Integer> getSumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 19", nativeQuery = true)
public Optional<Integer> getSumROLE_RESPONSABLE_SERVICE_FRS_LOCAL();
@Query(value = "SELECT COUNT(*) FROM `user_roles` WHERE `role_id` like 20", nativeQuery = true)
public Optional<Integer> getSumROLE_LIVREUR();

/**roles modification for update user */

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=1 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToUSER(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=2 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToADMIN(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=3 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToACHETEUR(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=4 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToTRANSITAIRE(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=5 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToCLIENT(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=6 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToVENDEUR(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=7 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToDECIDEUR_BP(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=8 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToAGENT_CAB(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=9 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToPREPARATEUR_BR(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=10 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToRESPONSABLE_DISPATCHING_BP(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=11 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToPREPARATEUR(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=12 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToVALIDATEUR_DE_CHARIOT(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=13 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToRESPONSABLE_POINTAGE(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=14 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToEMBALLEUR(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=15 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToEXPEDITEUR(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=16 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToAGENT_SAISIE_REG(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=17 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToCAISSIER(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=18 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToRESPONSABLE_SERVICE_FRS_ETRANGER(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=19 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToRESPONSABLE_SERVICE_FRS_LOCAL(long id);

@Modifying
@Query(value = "UPDATE `user_roles` SET `role_id`=20 WHERE `user_id` LIKE %:id% ", nativeQuery = true)
public void ChangeRoleToLIVREUR(long id);

/**end here */


@Query(value = "SELECT MAX(user_id) FROM `user_roles`", nativeQuery = true)
public Optional<Long> getLastIdUser();



@Modifying
@Query(value = "UPDATE `users` SET `file_name`=%:getfile% WHERE `id` LIKE %:id% ", nativeQuery = true)
public void ChangeFileName(@Param("getfile") String getfile, @Param("id") Long id);
}