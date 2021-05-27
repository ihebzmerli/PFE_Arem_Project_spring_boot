package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loizenai.jwtauthentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


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
}